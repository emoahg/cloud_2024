package pers.emo.commons.exp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.emo.commons.resp.ResultData;
import pers.emo.commons.resp.ReturnCodeEnum;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultData<String> handleRuntime(Exception e) {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }


}
