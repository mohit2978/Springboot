# Notes Login and Registration using spring security

To insert record in table we use JPA!!

## How to work with UserDetailsService in Spring Security

=> UserDetailsService is a predefined interface which contains loadUserByUsername(String name) method.

=> This is used to load User record for Authentication purpose in Spring Security.

=> We can implement UserDetailsService interface and we can write the logic to retrieve User record based on given username for Authentication purpose.

=> If we give UserDetailsService object to AuthenticationManagerBuild then AuthManager will call this method for every login request.

## Login and Registration using Spring Security

 Git Hub repo : https://github.com/ashokitschool/SpringBoot_Security_Register_Login.git

1) Create Boot app with required dependencies ##

			a) web-starter
			b) data-jpa-starter
			c) mysql
			d) security-starter
			e) devtools

2) Configure Data Source properties in yml file

2) Create Entity class & Repository interface 
```java
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

	public Customer findByUname(String cuname);

}
```
3) Create UserDetailsService class 

```java
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepo crepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer c = crepo.findByUname(username);
		return new User(c.getUname(), c.getPwd(), Collections.emptyList());
	}
}
```

 4) Create Security Config Class

Here we created various beans

1. PasswordEncoder - to encode password
2. auth provider - how data coming for authentication from db
3. AuthenticationManager - how to check is credentials valid
4. SecurityFilterChain -to customize security!!

```java
@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Autowired
	private MyUserDetailsService userDtlsSvc;
	
	@Bean
	public PasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=
        		new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDtlsSvc);
        authenticationProvider.setPasswordEncoder(pwdEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
	
    @Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/register", "/login").permitAll()
                .and()
                .build();
	}
}
```
 5) Create RestController with required methods

 two methods 
 1. login
 2. register
```java
@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepo crepo;

	@Autowired
	private PasswordEncoder pwdEncoder;// from configuration

	@Autowired
	private AuthenticationManager authManager;

	@PostMapping("/login")
	public ResponseEntity<String> loginCheck(@RequestBody Customer c) {
		
		UsernamePasswordAuthenticationToken token = 
				new UsernamePasswordAuthenticationToken(c.getUname(), c.getPwd());

		try {
			Authentication authenticate = authManager.authenticate(token);

			if (authenticate.isAuthenticated()) {
				return new ResponseEntity<>("Welcome To Ashok IT", HttpStatus.OK);
			}

		} catch (Exception e) {
			//logger
		}

		return new ResponseEntity<String>("Invalid Credentials", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/register")
	public String registerCustomer(@RequestBody Customer customer) {
		
		// duplicate check

		String encodedPwd = pwdEncoder.encode(customer.getPwd());
		customer.setPwd(encodedPwd);

		crepo.save(customer);

		return "User registered";
	}

}
```

 6) Run the application and test it


