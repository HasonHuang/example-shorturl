package com.hason.shorturl.util;

/**
 * CheckedException的wrapper.
 *
 * 返回Message时, 将返回内层Exception的Message.
 */
public class UncheckedException extends RuntimeException {

    private static final long serialVersionUID = 2375564448108829908L;

    public UncheckedException(Throwable wrapped) {
        super(wrapped);
    }

    @Override
    public String getMessage() {
        return super.getCause().getMessage();
    }
}