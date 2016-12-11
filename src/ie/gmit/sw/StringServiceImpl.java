package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class StringServiceImpl extends UnicastRemoteObject implements StringService{

	private List<Node> cor = new LinkedList<Node>();
	private BlockingDeque<Resultator> queue = new LinkedBlockingDeque<Resultator>();

	public StringServiceImpl() throws RemoteException {
		super();
		cor.add(new Node(new Levenshtein(), "Levenshtein Distance"));
		cor.add(new Node(new DamerauLevenshtein(), "Damerau-Levenshtein Distance"));
		cor.add(new Node(new HammingDistance(), "Hamming Distance"));
		
	}
	
	public Resultator compare(String s, String t, String algo) throws RemoteException {
		//Slow down the process time to 10 seconds
		Resultator r = new ResultatorIml();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//loop through list of algorithms...
		for (Node n : cor){
			//select algorithm
			if (n.getName().equals(algo)){
				int distance = n.getAlgo().distance(s, t);
				r.setResult(" Distance of two strings is: " + distance);
				//Pass the int to a resultator and return it to the client
			}
		}
		//Set "r" to processed
		r.setProcessed();
		System.out.println(r.getResult());
		
		return r;
	}

	private class Node{
		private Algorithm a;
		private String name;
		
		public Node(Algorithm a, String name) {
			super();
			this.a = a;
			this.name = name;
		}
		
		public Algorithm getAlgo() {
			return a;
		}
		
		public String getName() {
			return name;
		}
	}
}
