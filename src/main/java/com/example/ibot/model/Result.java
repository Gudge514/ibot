package com.example.ibot.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
//    private static final long ser

    private boolean success;

    private String resultCode;

    private String resultMessage;

    private T data;

    public static <T> Result<T> buildSuccess(T data) {
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setResultCode("200");
        result.setData(data);
        return result;
    }
}
