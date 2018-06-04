package com.iliyakos;

public class TcpRequestHandler implements IRequestHandler {
    static {
        RequestHandlerRegistrar.register(new TcpRequestHandler());
    }

    @Override
    public void handleRequest() {
        System.out.println("Handle request in TCP request handler");
    }
}
