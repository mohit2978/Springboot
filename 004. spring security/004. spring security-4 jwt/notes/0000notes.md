# JWT

-> JWT stands for JSON Web Tokens

-> JSON Web Tokens are an open, industry standard RFC 7519 method for representing claims securely between two parties.

## How JWT works!!

![alt text](image.png)

1. client registers so his credentials are stored in DB!! and then he login !!

2. after login he receives a token from provider using JWTUtils class!!After successful login , we send a token to client!!

	![alt text](image-1.png)

	see how we get the token

3. now to access secured URL , client need to send that token along with URL!!

4. validation is for 3 url's so we use validate method for all three using filters!! we are not going to write logic to validate token in all 3 methods!! so before going to restController token must be validated so filter is used!!


5. token will have expiry too !!so after that expiry time token will be expired!!

After getting token when you login from token to secured url's you 
will be able to login !!

![alt text](image-2.png)

remember token is bearer token!!


-> Below is the sample JWT Token

token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c

-> JWT contains below 3 parts

		1) Header
		2) Payload
		3) Signature

Note: JWT 3 parts will be seperated by using dot(.)


1) JWT Token generation (JwtService.java)

		- generateToken(String uname)
		- validateToken(String uname)

2) JWT Token validation Filter (AppFilter.java) - OncePerRequest
	
		- check Authorization header presence
		- retrieve bearer token from header
		- validate token
		- if token is valid, update security context to process req

3) Customize SecurityFilterChain

		- permit /api/register & /api/login urls
		- authenticate any other request
		- set security context as stateless

## Authorization format
Key = Authorization
Value = Bearer <token>

## SpringBoot Application

1. depency needed

	- Spring Security
	- Spring Web
	- devtools
	- Mysql driver
	- data jpa dependency

 also these 3 dependency needs to be added for Jwt

 ```xml
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.11.5</version>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.11.5</version>
		</dependency>
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.11.5</version>
		</dependency>
 ```	

2. now configure database info 

```yml
server:
  port: 8082
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    password: Balu@123
    url: jdbc:mysql://localhost:3306/ashokit
    username: root
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true

```

3. entity class

```java

@Entity
public class UserEntity {

	@Id // for pk
	@GeneratedValue // to auto generate this value
	private Integer uid;
	private String uname;
	private String upwd;
	private Long phno;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Long getPhno() {
		return phno;
	}
	public void setPhno(Long phno) {
		this.phno = phno;
	}
	
}
```
4. repository


```java
public interface UserRepo  extends JpaRepository<UserEntity, Integer> {
	
	// select * from user_tabl where uname = !uname
	
	public UserEntity  findByUname(String uname);

}

```

5. service class implemeting User Detail service where we overide method loadUSerbyUserName

```java
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity entity = repo.findByUname(username);
		return new User(entity.getUname(), entity.getUpwd(), Collections.emptyList());
	}
	
	public boolean saveUser(UserEntity user) {
         user = repo.save(user);
		return user.getUid() != null;
	}
	

}

```

6. controller let us see that

```java
@RestController
@RequestMapping("/api")
public class UserRestController {

	// register
	public String registerUser(UserEntity user) {
		return null;
		
	}
}

```

Login will be taken care by spring security!!

7. need to create password encoder class
## JWT in Microservices

=> Auth-Service contains functionality for user registration and user login with MySQL DB. 

=> If user login successfully then auth-service will generate JWT token and will send it as response to user.

=> API-Gateway contains logic to validate the token using Filter.

>Note: In API-Gateway we have added routings for our microservices along with Filter.

=> When we access any microservice url through api-gateway then api-gateway will execute filter to validate the token. If token is valid then only api-gateway will route the request to particular microservice. If token is invalid then api-gateway will throw Exception.

### Git Hub Repo : https://github.com/ashokitschool/Microservices_Security.git

