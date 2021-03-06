package com.iliyakos;

import java.util.concurrent.CopyOnWriteArrayList;

public class RequestHandlerRegistrar {
    private static String[] handlerNames = new String[]{"com.iliyakos.TcpRequestHandler", "com.iliyakos.UdpRequestHandler"};
    private static CopyOnWriteArrayList<IRequestHandler> registeredHandlers = new CopyOnWriteArrayList<IRequestHandler>();

    static {
        try {
            // through service locator this class would find handler class names in real world scenario
            final Class<?> aClass1 = Class.forName(handlerNames[1]);
            aClass1.newInstance();
            final Class<?> aClass = Class.forName(handlerNames[0]);
            aClass.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void register(IRequestHandler handler) {
        if (!registeredHandlers.contains(handler)) {
            registeredHandlers.add(handler);
        }
    }

}
