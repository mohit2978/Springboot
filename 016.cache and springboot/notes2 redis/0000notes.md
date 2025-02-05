# Redis
let us now create our own project!!

```java
@Configuration
@EnableRedisRepositories
public class RedisConfig {

    @Bean
    public JedisConnectionFactory connectionFactory(){
        //host & port
//        RedisStandaloneConfiguration configuration=new RedisStandaloneConfiguration();
//        configuration.setHostName("localhost");
//        configuration.setPort(6379);
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<Object,Object> template(){
        RedisTemplate<Object,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        return template;
    }
}

```

hash of redis or entity of RDBMS

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("CustomersInfo")
public class Customer implements Serializable {

    private static final long serialVersionUID= 1L;

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dob;
    private String phone;
}
```
CustomersInfo --> is hash name for redis
Controller

```java
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return service.getCustomer(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable int id) {
        return service.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }
}
```

CustomerRepository

```java
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
```

Simple enough till now!!!

now see 

```java

@Repository
public class CustomerDAO {

    public static final String HASH_KEY = "CustomersInfo";


    @Autowired
    private RedisTemplate template;

    public Customer addCustomer(Customer customer) {
        //tell hashname and then key and value to store
        template.opsForHash().put(HASH_KEY, customer.getId(), customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Customer getCustomer(int id) {
        return (Customer) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteCustomer(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Customer " + id + " has been removed from system !";
    }

    public Customer updateCustomer(int id, Customer customer) {
        Customer existingCustomer = (Customer) template.opsForHash().get(HASH_KEY, id);
        if (existingCustomer != null) {
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhone(customer.getPhone());
            existingCustomer.setDob(customer.getDob());
            template.opsForHash().put(HASH_KEY, id, existingCustomer);
            return existingCustomer;
        } else {
            throw new RuntimeException("Customer not found !");
        }

    }


}
```

