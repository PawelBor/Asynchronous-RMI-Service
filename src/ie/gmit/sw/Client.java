package ie.gmit.sw;

import java.rmi.Naming;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

public class Client implements Runnable{
	LinkedList<Task> inQueue;
	ConcurrentHashMap<String, Resultator> outQueue;

	//In/Out Queue 
	public Client(LinkedList<Task> inQueue, ConcurrentHashMap<String, Resultator> outQueue){
		this.inQueue = inQueue;
		this.outQueue = outQueue;
	}
	
		//update queue
		public void updateQueue(String taskNum, Resultator r){
			outQueue.put(taskNum, r);
		}
		//take first item from inqueue
		public Task getFollowingTask(){
			return this.inQueue.poll();
		}
	
	public void run() {
		try 
		{
			//Connect to RMI Service
			StringService service = (StringService) Naming.lookup("rmi://localhost:1099/stringService");
			while(true){
				Task currentTask = getFollowingTask();
				//Remote method - Return obj
				Resultator r = service.compare(currentTask.getString1(), currentTask.getString2(), currentTask.getAlgo());
				updateQueue(currentTask.getTaskNumber(), r);//Update out queue with current resultator
				do{
					if(r.getResult() != null){
						//update Resultator
						updateQueue(currentTask.getTaskNumber(), r);
					}
					Thread.sleep(5000);
				}
				while(r.isProcessed() == false);
				//update queue + get next taskNo
				updateQueue(currentTask.getTaskNumber(), r);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
