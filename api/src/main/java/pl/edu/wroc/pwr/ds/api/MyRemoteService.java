package pl.edu.wroc.pwr.ds.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemoteService extends Remote {
	public void getMessage(String data, MyRemoteCallback callback) throws RemoteException;
}