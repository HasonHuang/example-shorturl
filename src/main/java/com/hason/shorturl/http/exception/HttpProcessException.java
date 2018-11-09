package com.hason.shorturl.http.exception;

/**
 * HTTP 处理异常
 *
 * @date 2018/6/14
 */
public class HttpProcessException extends Exception {

    private static final long serialVersionUID = -2749168865492921426L;

    public HttpProcessException(Exception e) {
        super(e);
    }

    /**
     * @param msg 消息
     */
    public HttpProcessException(String msg) {
        super(msg);
    }

    /**
     * @param message 异常消息
     * @param e       异常
     */
    public HttpProcessException(String message, Exception e) {
        super(message, e);
    }

}
