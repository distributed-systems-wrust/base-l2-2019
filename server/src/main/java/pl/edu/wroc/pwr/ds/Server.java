package pl.edu.wroc.pwr.ds;
import org.apache.log4j.Logger;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import pl.edu.wroc.pwr.ds.api.MyRemoteService;
/**
 * Hello world server!
 *
 */
public class Server{
  final static Logger logger = Logger.getLogger(Server.class);
	private static final int port = 8080;

    // Throws in here is really ugly :(
    public static void main( String[] args ) throws Exception{
    	logger.info("Creating server");
    	MyRemoteServiceImpl impl = new MyRemoteServiceImpl("server");
    	Registry registry = LocateRegistry.createRegistry(8080);
    	MyRemoteService stub = (MyRemoteService) UnicastRemoteObject.exportObject(impl, 0);
        registry.rebind("MyRemoteService", stub);
        logger.info("Server created");
    }
}
