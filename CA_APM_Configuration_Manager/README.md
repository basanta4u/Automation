Introduction:
The main objective of this application is to improve the ease of use by allowing users to edit all the properties at single location. This tool would essentially be a Web GUI to configure the APM properties.

Prerequisites:

1. TOMCAT server 
2. POM with the required MAVEN dependencies to consume JAX-RS API [Already exists]
3. Make sure that a directory named config exists in your current working directory( Ex: "C:\sw\eclipse-jee-kepler-R-win32-x86_64\config" is our config directory) and it should have file named IntroscopeEnterpriseManager.properties
4. Currently this is limited to ONLY IntroscopeEnterpriseManager.properties.

Steps to import the .zip file to eclipse:

1.File --> Import --> Existing Projects Eclipse
2.Select Archive file Option and browse the .zip file (CA_APM_Configuration_Manager.zip)
3.Click on Finish

Steps to run the application:

1.Right click on Project --> Run As --> Run On Server--> Select Tomcat Server (ex: Tomcat 7). Please add a tomcat server before doing this.
2.Access the URL in the browser (ex: http://tuuja01-e6430:8080:/CA_APM_Configuration_Manager)


Note: 
Browser recommended is Google Chrome
JDK : 1.7 or higher
Eclipse: Kepler -Release 20130614-0229 : Recommended