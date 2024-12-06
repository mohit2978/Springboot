# OAuth notes

###  1) Create Spring Boot application with below dependencies

		a) web-starter
		b) security-starter
		c) oauth-client


### 2) Create OAuth app in Github.com

	(Login --> Profile -> Settings --> Developer Settings --> OAuth Apps --> Create App --> Copy Client ID & Client Secret)


### 3) Configure GitHub OAuth App client id & client secret in application.yml file like below


spring:
  security:
    oauth2:
      client:
        registration:
          github:
            clientId: 
            clientSecret: 


### 4) Create Rest Controller with method

@RestController
public class WelcomeRestController {

	@GetMapping("/")
	public String welcome() {
		return "Welcome to Ashok IT";
	}
}

#### 5) Run the application and test it.


Assignment : Spring Boot with oAuth using google account. Get username also from google and display that in response.
