package com.bing.queen.ai.web.controller;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.bing.queen.ai.common.annotation.Anonymous;
import com.bing.queen.ai.common.core.domain.dto.AiContentDTO;
import com.bing.queen.ai.common.core.domain.dto.AiRequestDTO;
import okhttp3.*;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("NullableProblems")
@RestController
@RequestMapping("/ai/chat")
@Anonymous
public class AiChatController {

    // 你的 Vercel 地址和密钥
    private static final String PROXY_URL = "https://proxy.bingbingqueen.top/api/chat";
    private static final String API_KEY = "123";

    private final OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS) // 读流超时设置长一点
            .build();

    /**
     * 前端调用这个接口：GET /AI/chat/stream?content=你好
     */
    @GetMapping(value = "/stream")
    public SseEmitter chat(@RequestParam String content, HttpServletResponse response) {
        response.setContentType("text/event-stream;charset=UTF-8"); // 明确告诉浏览器用 UTF-8
        // ---------------------
        // 1. 建立和前端的连接管道 (SseEmitter)
        SseEmitter emitter = new SseEmitter(0L); // 0L 表示不过期

        // 2. 准备发给 Vercel 的数据
        AiRequestDTO requestDTO = new AiRequestDTO();
        requestDTO.setModel("gemini-2.5-flash");
        requestDTO.setContents(Collections.singletonList(new AiContentDTO("text", content)));

        // 转成 JSON 字符串
        String jsonBody = JSON.toJSONString(requestDTO);

        // 3. 构建 OkHttp 请求
        Request request = new Request.Builder()
                .url(PROXY_URL)
                .addHeader("Authorization", "Bearer " + API_KEY)
                .post(RequestBody.create(MediaType.parse("application/json"), jsonBody))
                .build();

        // 4. 异步发送请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 如果连不上 Vercel，告诉前端报错了
                try {
                    emitter.send("Error: " + e.getMessage());
                    emitter.complete();
                } catch (IOException ex) { /* 忽略 */ }
            }

            // ... in AiChatController.java
            @Override
            public void onResponse(Call call, Response response) {
                try (ResponseBody body = response.body()) {
                    if (body == null) {
                        emitter.complete(); // body为空，直接结束
                        return;
                    }

                    BufferedSource source = body.source();
                    while (!source.exhausted()) {
                        String line = source.readUtf8Line();

                        // 1. 过滤掉空行和非 data: 开头的行
                        if (line == null || !line.startsWith("data: ")) {
                            continue;
                        }

                        String rawData = line.substring(6);
                        if (rawData.isEmpty()) {
                            continue;
                        }

                        try {
                            // 2. 解析 JSON，检查内容
                            JSONObject json = JSON.parseObject(rawData);

                            // 3. 检查是否是结束标记
                            if ("STOP".equals(json.getString("finishReason"))) {
                                // 如果是结束标记，我们主动结束，不再向下转发
                                System.out.println("收到结束标记，正常关闭 SSE");
                                emitter.complete(); // 主动、正常地关闭连接
                                return; // 结束循环
                            }

                            // 4. 只转发包含 text 的有效数据
                            String text = json.getString("text");
                            if (text != null) {
                                // 后端只推纯文本，前端不用再解析 JSON 了，更简单！
                                emitter.send(text);
                            }

                        } catch (Exception e) {
                            // 忽略单个数据块的解析错误
                            System.err.println("解析 SSE 数据块失败: " + rawData);
                        }
                    }
                } catch (Exception e) {
                    // 连接异常，也要确保 emitter 关闭
                    emitter.completeWithError(e);
                } finally {
                    // 确保无论如何都 complete

                    emitter.complete();

                }
            }
        });

        return emitter;
    }
}