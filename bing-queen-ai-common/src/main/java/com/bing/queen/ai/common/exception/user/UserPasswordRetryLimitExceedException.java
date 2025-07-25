package com.bing.queen.ai.common.exception.user;

/**
 * 用户错误最大次数异常类
 * 
 * @author bing.queen
 */
public class UserPasswordRetryLimitExceedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount, int lockTime)
    {
        super("user.password.retry.limit.exceed", new Object[] { retryLimitCount, lockTime });
    }
}
