package pl.edu.wroc.pwr.ds;

import org.apache.log4j.Logger;
import java.rmi.RemoteException;
import pl.edu.wroc.pwr.ds.api.MyRemoteCallback;

public class MyRemoteCallbackImpl implements MyRemoteCallback {

  	final static Logger logger = Logger.getLogger(MyRemoteCallbackImpl.class);

	public void callback(String data) throws RemoteException{
		logger.info(String.format("In client callback, %s", data));
	}

}