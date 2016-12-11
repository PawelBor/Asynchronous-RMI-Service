Asynchronous RMI String Comparison Service

Student Details:
Pawel Borzym  -  G00313594
Galway-Mayo Institute of Technology
Software Development - Y4
Distributed Systems

Lecturer:
Dr. John Healy


Introduction:

This is Java RMI Project. A remote and asynchronous string comparison service. 
Client connects, passes two strings for comparison.
String comparison Algorithms are provided, user is meant to select one of them.
Program will compute distance + alignment between two strings.


Technical Side, Project design/structure:

Front-End:

Front End is a one JSP (Java Server Page) - Provided by Lecturer.


Source Code: 
*comparator
	|_ Web Content
		|_WEB-INF
			|_beb.xml - Responsible for mapping url paths
			
*comparator
	|_ Java Resources
		|_src
			|_ie.gmit.sw
				|_Algorithm.java - Interface: determine/calculate string distance for supplied algorithm
				
				|_Client.java - 
				
				|_DamerauLevenshtein.java - String comparison algorithm 
				
				|_HammingDistance.java - String comparison algorithm
				
				|_Levenshtein.java - String comparison algorithm
				
				|_Resultator.java - Interface: Stems the resulator obj
				
				|_ResultatorIml.java - Marshalling(CS) - transforming object to data format transmission, Get/Set String value, examines if job is processed
				
				|_Servant.java - Server
				
				|_ServiceHandler.java - Adds job to queue, checks queue if job is done, removes task, submits form
				
				|_StringService.java -  Interface: service compare 2 strings
				
				|_StringServiceImpl.java - Adds string service comparison algorithms to list, gets algorithm + sets result + sets if job is processed.
				
				|_Task.java - Task Constructor, Getters/Setters for Task/Strings - commuicate with Client.
				

Application Running Steps:

...::: Tomcat (.war + .jar):::...
*  Take comparator.war from G00313594, paste it into Tomcat "webapps" directory.
0. Open CMD -> Navigate to G00313594 -> Enter: java -jar string-service.jar  >>>>>> Servant should be running
1. Open CMD -> Navigate to Apache BIN Folder -> startup.bat -> Tomcat will run
2. Open WebBrowser -> localhost:8080/comparator
3. Enter Details, see changes on webpage + servant on CMD.
4. Open multiple tabs in browser and repeat from step 2.




.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-..-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.


OTHER (eclipse) WAYS.....


	...............................................................................................................................................................................
...:::Eclipe (Luna R Java EE Perspective):::...

0. Set Java 2 EE Perspective (Top Right Corner) - IF NOT Displayed then : Window -> Open Perspective -> Other -> Java EE (Default for LUNA R).
1. File -> Import -> Web -> WAR File -> Navigate to comparator.war
	**Few errors might be displayed in Client, ServiceHandler and StringServiceImpl...**
	->**Eclipse may ask to change project compliance and JRE to 1.5, do that.**
2. Project -> Properties -> Java Build Path -> Libraries -> Add External JARs -> Navigate to Tomcat folder -> lib -> Select servlet-api.jar -> OK
3. Expand comparator solution, expand Java Resources, expand ie.gmit.sw package, Select Servant.java -> Run As: Java Application 
4. Servant will be ready.
5. Right click "comparator" Solution -> Run As: Run on Server -> Page will open and you can then type in 2 strings.


...:::Eclipse + Tomcat:::...

0. Set Java 2 EE Perspective (Top Right Corner) - IF NOT Displayed then : Window -> Open Perspective -> Other -> Java EE (Default for LUNA R).
1. File -> Import -> Web -> WAR File -> Navigate to comparator.war
	**Few errors might be displayed in Client, ServiceHandler and StringServiceImpl...**
	->**Eclipse may ask to change project compliance and JRE to 1.5, do that.**
2. Project -> Properties -> Java Build Path -> Libraries -> Add External JARs -> Navigate to Tomcat folder -> lib -> Select servlet-api.jar -> OK
3. Expand comparator solution, expand Java Resources, expand ie.gmit.sw package, Select Servant.java -> Run As: Java Application 
4. Servant will be ready.
----
5. Navigate to Tomcat folder -> webapps -> Paste the comparator into this folder.
6. Open CMD -> cd into apache BIN directory.
7. Enter "startup.bat" while in bin directory.
8. Open browser -> localhost:8080/comparator
9. Page should display, enter strings, check eclipse servant console for updates + updates on browser...









