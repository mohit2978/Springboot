
### Types of applications

1) Standalone-app (only one user can access at a time)

2) Web app (Multiple users can access at a time)

3) Distributed app  (webservices)

### What is Distributed application ?

 If one application is communicating with another application then it is called as Distributed application.

 like passport communicating with aadhar or gpay communicating with banking app or MakeMyTrip to Irctc 
 
 here irctc,banking app and aadhar are providing services so they are called as provider and passport ,gpay and makemytrip is called consumer!!

 IRCTC act as provider for various consumer like Makemytrip ,yatra etc!

 ### why use distributed system
 
- For code re-usability (so that we can use logic of other people if logic already written)

- For loosely coupling

### Distributed Application Architecture


In Ditributed applications, 2 actors will be available

1) Provider  : The app which is giving services to other application

    ex: IRCTC

2) Consumer : The app which is accessing services from other application

	ex: MakeMyTrip, Yatra ..

Provider and consumer can be in different technologies!! 

>irrespective of technology ,platform if two applications able to communicate then we say applications are interoperable!!


>Note: To achieve intereoperability we will use xml/json format to transfer data from one application to another application.

> XML & JSON formats are univeral, all languages will understand these formats.

### Distributed Technologies

1) CORBA

2) RMI

3) EJB

4) SOAP Webservices (Outdated)
 sun microsystem provided apis to run SOAP both outdated!
	- JAX-RPC
	- JAX-WS

5) RESTFul Services (Trending)

	- JAX-RS (outdated)
	- Spring REST  (trending)

### JSON

=> Java Script Object Notation

=> In Distributed applications we will use JSON as a mediator between Consumer & Provider.

=> JSON is interoperable

=> JSON is very light weight

=> JSON will represent data in key-value format.

Syntax:
```json
{
	
	"id" : 101,
	"name" : "ashok",
	"gender" : "male"

}

```
=> To convert java object to json data and json data to java object we will use "Jackson" API.

=> Jackson is a third party library.

=> Jackson api provided "ObjectMapper" class to perform conversions
    
```java

public class Customer {

	private int cid;
	private String cname;
	private String cemail;
	
	public Customer() {
		
	}

	public Customer(int cid, String cname, String cemail) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + "]";
	}
	
	
}

```

```java
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsonToObj {

	public static void main(String[] args) throws Exception {
		
		File f = new File("customer.json");
		ObjectMapper mapper = new ObjectMapper();
		Customer customer = mapper.readValue(f, Customer.class);
		System.out.println(customer);
		
	
		
	}
}
```

in customer.json we have following content

```json
{
	"cid": 101,
	"cname": "mohit",
	"cemail": "balu19@gmail.com"
}
```

Output:
```bash
Customer [cid=101, cname=mohit, cemail=balu19@gmail.com]

```
so 
```java
Customer customer = mapper.readValue(f, Customer.class);
```
reads value from file f and align according to class customer!!

now to convert object to json

```java
package in.ashokit;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertObjToJson {

	public static void main(String[] args) throws Exception {
		
		Customer c = new Customer(101, "balu", "mohit.k4@gmail.com");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("customer.json"), c);
	
		System.out.println("completed...");
		
	
		
		
	}
}
```

output in customer.json!!
```json 
{"cid":101,"cname":"balu","cemail":"mohit.k4@gmail.com"}
```

	
```java

ObjectMapper mapper = new ObjectMapper ( );

writeValue(object); // convert java obj to json

readValue(String file);// convert json to java obj

```
dependency we used
```xml
<dependency>
		<groupId>com.fasterxml.jackson.core</groupId>
		<artifactId>jackson-databind</artifactId>
		<version>2.16.1</version>
</dependency>
```

this json to java and java to json conversion is very useful in distributed system as there might be different tech you will be using and all understand json !! to make sure all communicate with each other correctly json is only way !! so we need to convert json to something which technology understand!!


 ### REST API development using Spring Boot


-> We need to use "web-starter" dependency in pom.xml

-> As part of REST API (Provider) development we will use below annotations


1) @RestController   : To make our class as distributed component (B2B)

2) @RequestParam : To read query parameters from URL (Key-Value )

3) @PathVariable : To read path parameters (as a variable)

4) @RequestBody : To read data from request body

5) @GetMapping : To map rest controller method to HTTP GET request

6) @PostMapping : To map rest controller method to HTTP POST request

7) @PutMapping : To map rest controller method to HTTP PUT request

8) @DeleteMapping : To map rest controller method to HTTP DELETE request
   


