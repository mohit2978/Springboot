# Springboot app on aws (IRCTC app  development)

=> Develop IRCTC api to book train tickets for passengers

=> We need to have below 2 functionalities in IRCTC API

1) book-ticket   (POST Request method)

	input : passenger data

	output : ticket data

2) get all tickets (GET request method)

	input : N/A

	output : all tickets data

 


### Step-1 ) Identify request structure and create req binding class

Request : passenger info

- name
- email
- doj
- from
- to
- trainNum

### Step-2 ) Identify response structure and create resp binding class

Response : Ticket info

 - ticket-num
- name
- doj
- from
- to
- trainNum
- status


### Step-3 ) Creae Boot application with required classes

1) Passenger.java
2) Ticket.java
3) TicketService.java
4) TicketServiceImpl.java
5) TicketRestController.java


### Step-4) Run the application and test it using swagger ui
   
```java
public class Passenger {

	private String name;
	private String email;
	private String from;
	private String to;
	private String doj;
	private String trainNum;
    
    }


 public class Ticket {
	
	private Integer ticketNum;
	private String name;
	private String email;
	private String from;
	private String to;
	private String doj;
	private String trainNum;
	private String status;
 }   
```
 ## controller

 ```java

@RestController
public class TicketRestController {

	@Autowired
	private TicketService service;
	
	@PostMapping(value="/ticket",
			consumes="application/json",
			produces="application/json"
			)
	
	public ResponseEntity<Ticket> bookTicket(@RequestBody  Passenger p){
		Ticket ticket = service.bookTicket(p);
		return new ResponseEntity<>(ticket,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/tickets",
			produces="application/json"
			)
	public ResponseEntity<Collection<Ticket>> getAllTickets(){
		Collection<Ticket> allTickets = service.getAllTickets();
		return new ResponseEntity<>(allTickets,HttpStatus.OK);
	}
 ```
 ## service
```java

@Service
public class TicketServiceImpl implements TicketService {

	
	Map<Integer, Ticket> db = new HashMap<>();
	
	@Override
	public Ticket bookTicket(Passenger p) {
		
		Ticket t = new Ticket();
		
		Random r = new Random();
		
		int id = r.nextInt(6);
		
		t.setTicketNum(id);
		
		BeanUtils.copyProperties(p, t);
		t.setStatus("CONFIRMED");
		db.put(id, t);
		return t;
	}

	@Override
	public Collection<Ticket> getAllTickets() {
		return db.values();
	}

}

```
can see code in 06-IRCTC-app

# Deploying Provider API in AWS cloud


Reference Video : https://youtu.be/cRQPgbwOWq0?si=9b0Yuye0iFPoUB1W

1) Login into aws cloud account

2) Create Linux VM in aws cloud using EC2 service

3) Connect with Linux VM using MobaXterm

4) Upload our api jar file

5) Install java in linux vm

	$ sudo yum install java

6) Run jar file

	nohup java -jar <jarfile>	&

7) Access our application documentation like below

	URL : http://public-ip:8080/swagger-ui/index.html


Provider URL : http://43.205.144.253:8080/swagger-ui/index.html

  