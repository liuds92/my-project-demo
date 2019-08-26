package com.liuds.dubbo.demo;

/**
 * @author: liuds
 * @date: 2019/6/27
 */
public class HelloException extends RuntimeException {

    public HelloException(){

    }

    public HelloException(String message) {
        super(message);
    }
}
