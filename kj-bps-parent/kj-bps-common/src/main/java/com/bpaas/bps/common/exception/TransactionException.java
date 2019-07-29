package com.bpaas.bps.common.exception;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description:
 * @version: 1.0
 */
public class TransactionException extends RuntimeException {

    /**
     * Constructor for TransactionException.
     *
     * @param msg the detail message
     */
    public TransactionException(String msg) {
        super(msg);
    }

    /**
     * Constructor for TransactionException.
     *
     * @param msg   the detail message
     * @param cause the root cause from the transaction API in use
     */
    public TransactionException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
