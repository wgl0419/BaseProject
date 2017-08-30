package me.fattycat.base.network;

/**
 * Author: Kelvinkun
 * Date: 16/8/29
 */

public class ApiException extends RuntimeException {
    public int    code;
    public String message;

    public ApiException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
