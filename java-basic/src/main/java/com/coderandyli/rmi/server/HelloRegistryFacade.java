package com.coderandyli.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lizhen on 2019-12-06
 */
public interface HelloRegistryFacade extends Remote {

    String helloWorld(String name) throws RemoteException;

}
