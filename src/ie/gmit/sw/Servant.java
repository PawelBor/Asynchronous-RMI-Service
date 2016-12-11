package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ie.gmit.sw.StringService;
import ie.gmit.sw.StringServiceImpl;

//server
public class Servant {
	
	public static void main(String[] args) throws Exception {
		StringService service = new StringServiceImpl();
		LocateRegistry.createRegistry(1099);//1099 port registry
		Naming.rebind("stringService", service);
		System.out.println("Servant working...");
	}
}
