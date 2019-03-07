package pl.edu.wroc.pwr.ds;
import org.apache.log4j.Logger;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import pl.edu.wroc.pwr.ds.api.MyRemoteService;
import pl.edu.wroc.pwr.ds.api.MyRemoteCallback;
import java.rmi.server.UnicastRemoteObject;

/**
 * Hello world client!
 *
 */
public class Client{

  	final static Logger logger = Logger.getLogger(Client.class);

	// Throws in here is really ugly :(
    public static void main( String[] args ) throws Exception{
    	logger.info("Creating client");
        Registry registry = LocateRegistry.getRegistry("localhost", 8080);
        MyRemoteCallbackImpl callback = new MyRemoteCallbackImpl();
        MyRemoteCallback remoteCallback =(MyRemoteCallback) UnicastRemoteObject.exportObject(callback,0 );
        MyRemoteService obj = (MyRemoteService) registry.lookup("MyRemoteService");
       	obj.getMessage("data", remoteCallback);
    }
    
}
