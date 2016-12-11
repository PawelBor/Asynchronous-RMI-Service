# Asynchronous-RMI-Service

# *Distributed Systems Project 2016 - Year 4*

**Name:** Pawel Borzym </br>
**College:** Galway-Mayo Institute of Technology </br>
**Course:** Software Development - Y4 </br>
**Module:** Distributed Systems </br>
**Lecturer:** Dr.John Healy </br>

###Project
A remote and asynchronous string comparison service.


### How to Run: ...::: Tomcat (.war + .jar):::..
1.Download/Clone Repository
***  Take comparator.war from G00313594, paste it into Tomcat "webapps" directory.
0. Open CMD -> (cd *path* )Navigate to Repository Directory -> Enter: java -jar string-service.jar  >>>>>> Servant should be running
1. Open CMD -> Navigate to Apache Tomcat BIN Folder -> Enter: startup.bat -> Tomcat will run
2. Open WebBrowser -> localhost:8080/comparator
3. Enter Details, see changes on webpage + servant on CMD.
4. Open multiple tabs in browser and repeat from step 2.




2. RMI String Service : 

1. Download this repo
2. To run the string service(RMI side), run: java –cp ./string-service.jar ie.gmit.sw.Servant, on command line from whatever directory you stored the string-service.jar jar file. This will start up the RMI server to listen to requests from the web application.
3. You can put the comparator.war file into apache Tomcat server, webapps directory which will deploy and run the web appplication or import the war file into eclipse ee or netbeans and run the project from inside the IDE of your choice.
4. If you use tomcat or another server then once deployed open a web browser and navigate to localhost:8080/comparator
