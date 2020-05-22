package com.coderandyli.rmi.client;

import com.coderandyli.rmi.server.HelloRegistryFacade;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by lizhen on 2019-12-06
 */
public class RegistryClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            HelloRegistryFacade hello = (HelloRegistryFacade) registry.lookup("HelloRegistry");
            String response = hello.helloWorld("ZhenJin");
            System.out.println("=======> " + response + " <=======");
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
