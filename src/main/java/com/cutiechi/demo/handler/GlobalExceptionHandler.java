package com.cutiechi.demo.handler;

import com.cutiechi.demo.exception.InternalServerErrorException;
import com.cutiechi.demo.model.dto.JsonResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author Cutie Chi
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 内部服务器错误异常处理方法
     *
     * @param exception 内部服务器错误异常
     * @return JSON 响应
     */
    @ExceptionHandler(InternalServerErrorException.class)
    public JsonResponse internalServerErrorException (InternalServerErrorException exception) {

        // 返回约定状态码为 50000 并且附带异常信息的 JSON 响应
        return new JsonResponse(50000, exception.getMessage());
    }
}
