package ie.gmit.sw;

import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServiceHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String remoteHost = null;
	private static long jobNumber = 0;
	private static LinkedList<Task> inQueue = new LinkedList<Task>();
	private static Map<String, Resultator> outQueue = new ConcurrentHashMap<String, Resultator>();
	
	private static Client clientJob; 
	private  Thread clientWorker;

	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER"); //Reads the value from the <context-param> in web.xml
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//job done initial false, used to stop resubmitting form
		boolean jdone = false;
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Init request vars
		String algorithm = req.getParameter("cmbAlgorithm");
		String s = req.getParameter("txtS");
		String t = req.getParameter("txtT");
		String taskNumber = req.getParameter("frmTaskNumber");

		out.print("<html><head><title>Distributed Systems Assignment</title>");		
		out.print("</head>");		
		out.print("<body>");
		
		if (taskNumber == null){
			taskNumber = new String("T" + jobNumber);
			jobNumber++;
			//Add job to in-queue
			inQueue.add(new Task(taskNumber, algorithm, s, t));
			Resultator r = new ResultatorIml();
			outQueue.put(taskNumber, r);
			//make new worker+job for every new request. :|
			clientJob = new Client(inQueue, (ConcurrentHashMap<String, Resultator>) outQueue);
			clientWorker = new Thread(clientJob);
			
			
			if(clientWorker.isAlive() != true){
				clientWorker.start();
			}
			
		}else{
			//Check out-queue for finished job
			Resultator r = outQueue.get(taskNumber);
			if(r != null && r.isProcessed() == true && r.getResult() != null){
				out.print("<font color=\"#993333\"><b>");
				out.print("<center>Request Complete " + "</center>");
				//shows result from resultator getResult() set by resultarorIml
				out.print("<center>RESULT:"+r.getResult() +"</center>");
				out.print("<center>Thank You for using the service."+"</center>");
				//get rid off task from queue at this stage
				outQueue.remove(taskNumber);
				//set job done to true
				jdone = true;
				
			}
			else{
				out.print("<font color=\"#993333\"><b>");
				out.print("Workng: Few more seconds...");
			}
		}
		
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<div id=\"r\"></div>");
		
		out.print("<font color=\"#993333\"><b>");
		out.print("RMI Server is located at " + remoteHost);
		out.print("<br>Algorithm: " + algorithm);		
		out.print("<br>String <i>s</i> : " + s);
		out.print("<br>String <i>t</i> : " + t);
		//if job done is still not done resubmit otherwise stop
		if(jdone == false){
			out.print("<form name=\"frmRequestDetails\">");
			out.print("<input name=\"cmbAlgorithm\" type=\"hidden\" value=\"" + algorithm + "\">");
			out.print("<input name=\"txtS\" type=\"hidden\" value=\"" + s + "\">");
			out.print("<input name=\"txtT\" type=\"hidden\" value=\"" + t + "\">");
			out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
			out.print("</form>");								
			out.print("</body>");	
			out.print("</html>");	
			
			out.print("<script>");
			out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
			out.print("</script>");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}