package com.bpaas.bps.common.api;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 通用返回对象
 * @version: 1.0
 */
public class CommonResult<T> {

    private long code;

    private String message;

    private T data;

    private String subcode;

    protected CommonResult() {

    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

//    protected CommonResult(long code, String subcode, String message) {
//        this.code = code;
//        this.subcode = subcode;
//        this.message = message;
//    }

    /**
     * 功能描述: 成功返回结果
     * @param: data 获取的数据,
     * @param: message 提示信息
     * @return:
     * @author:
     * @date:
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 功能描述:
     * @param: message 提示信息
     * @return:
     * @author:
     * @date: 2019/4/30 下午2:55
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

//    public static <T> CommonResult<T> failed(String subcode, String message) {
//        return new CommonResult<T>(ResultCode.FAILED.getCode(), subcode, message);
//    }
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }
}
