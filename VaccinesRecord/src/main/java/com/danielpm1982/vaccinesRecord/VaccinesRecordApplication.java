package com.danielpm1982.vaccinesRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaccinesRecordApplication {
	public static void main(String[] args) {
		SpringApplication.run(VaccinesRecordApplication.class, args);
	}
}


/*
For running this app, one can open it at an IDE like Eclipse and run as a java application the main file: VaccinesRecordApplication.java.
Or, for running outside the IDE, one could use the vaccinesRecord-1.0.0.jar file at the VaccinesRecord/target directory, by running, at
linux command line (from inside VaccinesRecord/target directory) the command: ./mvnw spring-boot:run .

Because physical paths have been used for the image files, using java -jar alone wouldn't work without further adaptation (so ./mvnw should be used instead).

Additionally, for using different a path structure  for the app, other than that defined at the properties file, the property 'targetStaticResourceAbsolutePath'
should have its value accordingly altered for the new path structure, otherwise files or folders won't be created or found (especially image ones).
*/

/*
Before running for the first time, and for generating the DB at MySQL, please run, at the Workbench, one of the two SQL scheme backups available 
at resources/dataBaseSchemes.

The initialScheme is populated only with the User ROLE types.

The populatedExampleScheme is populated with the ROLE types and with User, Vaccine, Patient and 
VaccineAdministration data.

If the example scheme data is used, the User data for login are as follows:

user1
id: 1
userName: user1
password: 123
firstName: user1FirstName
lastName: user1LastName
email: user1@user.com
roles: ROLE_USER (default)

patient1
id: 2
userName: patient1
password: 123
firstName: patient1FirstName
lastName: patient1LastName
email: patient1@patient.com
roles: ROLE_USER, ROLE_PATIENT

manager1
id: 3
userName: manager1
password: 123
firstName: manager1FirstName
lastName: manager1LastName
email: manager1@manager.com
roles: ROLE_USER, ROLE_MANAGER

director1
id: 4
userName: director1
password: 123
firstName: director1FirstName
lastName: director1LastName
email: director1@director.com
roles: ROLE_USER, ROLE_DIRECTOR
*/

/*
This app has two main User interfaces, one with traditional JSP/HTML pages and links and another
with a WebService REST API. See the RESTController if you wish to know the endpoints for accessing
all API via Postman or other app. Through the JSP/HTML view, only part of the API is visible
at the links (GET requests)... but other endpoints (POST, PUT, DELETE) are implemented as well. 
*/

/*
BCrypt with salt 15 is used as encryption for all passwords. Alter the salt if you wish faster 
responses with lower security.
*/
