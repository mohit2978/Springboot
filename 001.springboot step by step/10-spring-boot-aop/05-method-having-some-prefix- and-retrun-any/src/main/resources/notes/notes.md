### before Aspect was this in 04

```java
package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }
}
```
### now aspect is

```java
@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    // @Before("execution(public void add*())")

    @Before("execution(* add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }
}



```
now aspect run before every method
see

```java
package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }
}

```

before this addAccount() aspect will run 

```java
package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addSillyMember() {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

    }

    @Override
    public void add() {
        System.out.println("simple add aspect should run before it");
    }

    @Override
    public int addVersion() {
        System.out.println("No expect should run as int return type method although add* satisfied");
        return 0;
    }
}

```
before addVersion() aspect will not run except that aspect run for every mrthod
as addVersion() is returning int

### Main
```java
@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		return runner -> {

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		theAccountDAO.addAccount();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.add();
		theMembershipDAO.addVersion();

	}

}
```

## Previous Output:

```text
C:\Users\user\.jdks\openjdk-22\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.1.4\lib\idea_rt.jar=61340:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.1.4\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\user\Desktop\programs\SpringBoot notes\001.springboot step by step\10-spring-boot-aop\04-pointcut-expressions-match-any-addStar\target\classes;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-starter-aop\3.3.2\spring-boot-starter-aop-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\spring-aop\6.1.11\spring-aop-6.1.11.jar;C:\Users\user\.m2\repository\org\springframework\spring-beans\6.1.11\spring-beans-6.1.11.jar;C:\Users\user\.m2\repository\org\aspectj\aspectjweaver\1.9.22.1\aspectjweaver-1.9.22.1.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-starter\3.3.2\spring-boot-starter-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot\3.3.2\spring-boot-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\spring-context\6.1.11\spring-context-6.1.11.jar;C:\Users\user\.m2\repository\org\springframework\spring-expression\6.1.11\spring-expression-6.1.11.jar;C:\Users\user\.m2\repository\io\micrometer\micrometer-observation\1.13.2\micrometer-observation-1.13.2.jar;C:\Users\user\.m2\repository\io\micrometer\micrometer-commons\1.13.2\micrometer-commons-1.13.2.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.3.2\spring-boot-autoconfigure-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-starter-logging\3.3.2\spring-boot-starter-logging-3.3.2.jar;C:\Users\user\.m2\repository\ch\qos\logback\logback-classic\1.5.6\logback-classic-1.5.6.jar;C:\Users\user\.m2\repository\ch\qos\logback\logback-core\1.5.6\logback-core-1.5.6.jar;C:\Users\user\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.23.1\log4j-to-slf4j-2.23.1.jar;C:\Users\user\.m2\repository\org\apache\logging\log4j\log4j-api\2.23.1\log4j-api-2.23.1.jar;C:\Users\user\.m2\repository\org\slf4j\jul-to-slf4j\2.0.13\jul-to-slf4j-2.0.13.jar;C:\Users\user\.m2\repository\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;C:\Users\user\.m2\repository\org\springframework\spring-core\6.1.11\spring-core-6.1.11.jar;C:\Users\user\.m2\repository\org\springframework\spring-jcl\6.1.11\spring-jcl-6.1.11.jar;C:\Users\user\.m2\repository\org\yaml\snakeyaml\2.2\snakeyaml-2.2.jar;C:\Users\user\.m2\repository\org\slf4j\slf4j-api\2.0.13\slf4j-api-2.0.13.jar" com.luv2code.aopdemo.AopdemoApplication

=====>>> Executing @Before advice on method
class com.luv2code.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: ADDING AN ACCOUNT

=====>>> Executing @Before advice on method
class com.luv2code.aopdemo.dao.MembershipDAOImpl: DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT

=====>>> Executing @Before advice on method
simple add aspect should run before it
No expect should run as int return type method although add* satisfied

Process finished with exit code 0

```

## now output:

```text
C:\Users\user\.jdks\openjdk-22\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.1.4\lib\idea_rt.jar=61840:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2024.1.4\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "C:\Users\user\Desktop\programs\SpringBoot notes\001.springboot step by step\10-spring-boot-aop\05-spring-boot-aop-pointcut-expressions-match-any-return-type\target\classes;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-starter-aop\3.3.2\spring-boot-starter-aop-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\spring-aop\6.1.11\spring-aop-6.1.11.jar;C:\Users\user\.m2\repository\org\springframework\spring-beans\6.1.11\spring-beans-6.1.11.jar;C:\Users\user\.m2\repository\org\aspectj\aspectjweaver\1.9.22.1\aspectjweaver-1.9.22.1.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-starter\3.3.2\spring-boot-starter-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot\3.3.2\spring-boot-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\spring-context\6.1.11\spring-context-6.1.11.jar;C:\Users\user\.m2\repository\org\springframework\spring-expression\6.1.11\spring-expression-6.1.11.jar;C:\Users\user\.m2\repository\io\micrometer\micrometer-observation\1.13.2\micrometer-observation-1.13.2.jar;C:\Users\user\.m2\repository\io\micrometer\micrometer-commons\1.13.2\micrometer-commons-1.13.2.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-autoconfigure\3.3.2\spring-boot-autoconfigure-3.3.2.jar;C:\Users\user\.m2\repository\org\springframework\boot\spring-boot-starter-logging\3.3.2\spring-boot-starter-logging-3.3.2.jar;C:\Users\user\.m2\repository\ch\qos\logback\logback-classic\1.5.6\logback-classic-1.5.6.jar;C:\Users\user\.m2\repository\ch\qos\logback\logback-core\1.5.6\logback-core-1.5.6.jar;C:\Users\user\.m2\repository\org\apache\logging\log4j\log4j-to-slf4j\2.23.1\log4j-to-slf4j-2.23.1.jar;C:\Users\user\.m2\repository\org\apache\logging\log4j\log4j-api\2.23.1\log4j-api-2.23.1.jar;C:\Users\user\.m2\repository\org\slf4j\jul-to-slf4j\2.0.13\jul-to-slf4j-2.0.13.jar;C:\Users\user\.m2\repository\jakarta\annotation\jakarta.annotation-api\2.1.1\jakarta.annotation-api-2.1.1.jar;C:\Users\user\.m2\repository\org\springframework\spring-core\6.1.11\spring-core-6.1.11.jar;C:\Users\user\.m2\repository\org\springframework\spring-jcl\6.1.11\spring-jcl-6.1.11.jar;C:\Users\user\.m2\repository\org\yaml\snakeyaml\2.2\snakeyaml-2.2.jar;C:\Users\user\.m2\repository\org\slf4j\slf4j-api\2.0.13\slf4j-api-2.0.13.jar" com.luv2code.aopdemo.AopdemoApplication

=====>>> Executing @Before advice on method
class com.luv2code.aopdemo.dao.AccountDAOImpl: DOING MY DB WORK: ADDING AN ACCOUNT

=====>>> Executing @Before advice on method
class com.luv2code.aopdemo.dao.MembershipDAOImpl: DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT

=====>>> Executing @Before advice on method
simple add aspect should run before it

=====>>> Executing @Before advice on method
No expect should run as int return type method although add* satisfied

Process finished with exit code 0

```

see before every call to any method with prefix add aspect will run