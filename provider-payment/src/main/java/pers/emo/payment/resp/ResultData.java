package pers.emo.payment.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultData<T> {

    private String code;
    private String message;
    private T data;
    private long timestamp;

    private ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<T>().setCode(ReturnCodeEnum.RC200.getCode())
                .setMessage(ReturnCodeEnum.RC200.getMessage())
                .setData(data);
    }

    public static <T> ResultData<T> fail() {
        return new ResultData<T>().setCode(ReturnCodeEnum.RC999.getCode())
                .setMessage(ReturnCodeEnum.RC999.getMessage())
                .setData(null);
    }

    public static <T> ResultData<T> fail(String code, String message) {
        return new ResultData<T>().setCode(code)
                .setMessage(message)
                .setData(null);
    }

    public static <T> ResultData<T> fail(ReturnCodeEnum returnCodeEnum) {
        return new ResultData<T>().setCode(returnCodeEnum.getCode())
                .setMessage(returnCodeEnum.getMessage())
                .setData(null);
    }

}
