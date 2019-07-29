package com.bpaas.bps.common.utils;

import com.bpaas.bps.common.exception.TransactionException;
import java.sql.Connection;

/**
 * @Author: haowen.wang
 * @Date: 2019/5/20
 * @Description:
 * @version: 1.0
 */
public class ConnectionResourceHolder {

    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();


    public static Connection getConnection() throws TransactionException {
        return connectionHolder.get();
    }


    public static void bound(Connection connection) {
        connectionHolder.set(connection);
    }


    public static void unbound() {
        connectionHolder.set(null);
    }
}
