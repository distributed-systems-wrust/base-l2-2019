package pl.edu.wroc.pwr.ds;

import org.apache.log4j.Logger;
import java.rmi.RemoteException;
import pl.edu.wroc.pwr.ds.api.MyRemoteService;
import pl.edu.wroc.pwr.ds.api.MyRemoteCallback;

public class MyRemoteServiceImpl implements MyRemoteService {

  	final static Logger logger = Logger.getLogger(MyRemoteServiceImpl.class);

	private String param;
	public MyRemoteServiceImpl(String param){
		this.param=param;
		logger.info("Constructor");
	}


	public void getMessage(String data, MyRemoteCallback callback) throws RemoteException{
		logger.info("Method call");
		callback.callback(String.format("Hello %s in %s", data, this.param));
	}
}