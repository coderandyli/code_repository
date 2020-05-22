package com.coderandyli.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by lizhen on 2019-12-06
 */
public class HelloRegistryFacadeImpl extends UnicastRemoteObject implements HelloRegistryFacade{

    public HelloRegistryFacadeImpl() throws RemoteException {
        super();
    }

    @Override
    public String helloWorld(String name) {
        return "[Registry] 你好! " + name;
    }

}
