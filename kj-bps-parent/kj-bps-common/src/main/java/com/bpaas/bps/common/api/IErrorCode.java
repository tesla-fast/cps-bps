package com.bpaas.bps.common.api;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description: 封装API的错误码
 * @version: 1.0
 */
public interface IErrorCode {

    long getCode();

    String getMessage();
}
