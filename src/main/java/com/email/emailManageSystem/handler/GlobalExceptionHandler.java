package com.email.emailManageSystem.handler;

import com.email.emailManageSystem.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author userlzy
 * @version 1.0
 * @description: 全局异常处理器
 * @date 2025/3/23 16:19
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 捕获业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler
    public Result exceptionHandler(RuntimeException ex){
        return Result.error(ex.getMessage());
    }

    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex){
        String message = ex.getMessage();
        if(message.contains("Duplicate entry")){
            return Result.error("用户名已存在");
        }else {
            return Result.error("未知异常");
        }

    }

}
