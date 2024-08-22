# SpringBoot REST API's
 We have created HomeController see below code

```java
@RestController
public class HelloWorldController {

    // HTTP GET Request
    // http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String helloWorld(){
        
        return "Hello World!";
    }
}

```
Here we can put controller too but with controller we ned to put @ResponseBody tahta tells the object returned is 
automatically serialized to JSON and passed back as HttpResponse Object!

to avoid both we use @RestController which intenally has both annotation!!this is with spring 4.0!!
see Rsetcontroller has both the annotations
```java

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Controller
@ResponseBody
public @interface RestController {
    @AliasFor(
        annotation = Controller.class
    )
    String value() default "";
}

```
Output at url above will be "Hello World" in JSON!!
now lets see how to retrun java bean as JSON! for that we have Student bean
```java

@Component
public class Student {
    private int id;
    private String firstName;
    private String lastName;
}
```

now add controller for that
```java
@RestController
@RequestMapping("students")
public class StudentController {

    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );
        // return new ResponseEntity<>(student, HttpStatus.OK);
        return student;
    }
}
```
Output will be student object in JSON format

```java
    // http://localhost:8080/students
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ramesh", "Fadatare"));
        students.add(new Student(2, "umesh", "Fadatare"));
        students.add(new Student(3, "Ram", "Jadhav"));
        students.add(new Student(4, "Sanjay", "Pawar"));
        return ResponseEntity.ok(students);
    }
```

to return student list we will see ResponseEntity Later will tell later here only
***
## Path Variable

```java
    // Spring BOOT REST API with Path Variable
    // {id} - URI template variable
    // http://localhost:8080/students/1/ramesh/fadatare
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName){
        Student student = new Student(studentId, firstName, lastName);
        return ResponseEntity.ok(student);
    }
```