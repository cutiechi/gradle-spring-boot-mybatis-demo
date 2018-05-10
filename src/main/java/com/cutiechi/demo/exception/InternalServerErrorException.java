package com.cutiechi.demo.exception;

/**
 * 内部服务器错误异常
 *
 * @author Cutie Chi
 */
public final class InternalServerErrorException extends Exception {

    /**
     * 构造函数调用 Exception 的构造函数
     *
     * @param message 异常信息
     */
    public InternalServerErrorException (final String message) {
        super(message);
    }
}
