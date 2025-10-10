//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ciphergateway.crypto;

public enum ErrorCode {
    UNKNOW_ERROR("unknow error", -1),
    INVALID_PARAMETER("invalid parameter", -1000),
    INVALID_ENGINE("invalid engine", -1001),
    ALLOCATE_MEMORY_FAILED("allocate memory failed", -1002),
    INVALID_ALGORITHM("illegal algorithm", -1003),
    NOT_INIT("not init", -5000);

    private String message;
    private int code;

    private ErrorCode(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

    public String getErrorMessage(String error) {
        return this.code + ": " + this.message + " [" + error + "]";
    }

    public static Error unknow_error(String message) {
        return new Error(UNKNOW_ERROR.getErrorMessage(message));
    }

    public static Error invalid_parameter(String message) {
        return new Error(INVALID_PARAMETER.getErrorMessage(message));
    }

    public static Error invalid_algorithm(String message) {
        return new Error(INVALID_ALGORITHM.getErrorMessage(message));
    }

    public static Error not_init(String message) {
        return new Error(NOT_INIT.getErrorMessage(message));
    }
}
