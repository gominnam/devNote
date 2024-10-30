## Reflection 


### Reflection 이란?

- Java 에서 relection 사용 이유
: **컴파일 시점에 알 수 없는 클래스나 메서드에 접근**하거나 동적으로 인스턴스를 조작해야 하는 상황 
: Spring 에서는 @Autowired, @Component, @Service, @Repository 등의 어노테이션을 사용하여 객체를 생성하고 관리하는데, 이때 **reflection을 사용**한다.
: 런타임에 애너테이션을 기반으로 특정 동작을 추가할 때 사용됩니다. ex) @Transactional 트랜잭션을 시작하고 커는 로직을 추가하는 방법

</br></br>

### Reflection 단점

- 성능 저하: 런타임 시점에 클래스의 정보를 가져오기 때문에 컴파일 시점에 비해 느리다.
- 컴파일러 체크 불가: 컴파일 시점에 타입을 체크할 수 없다.
- 코드 가독성 저하 
- 접근 지시자 무시: private 접근 지시자를 무시하고 접근할 수 있다.

</br></br>

### 의문

- Interface 를 통해 구현 Class 를 조건에 따라 new Instance() 하면 되지 않나?
: a. 컴파일 시점에 알 수 없는 클래스를 동적으로 로드하고 생성해야 하는 경우. ex) 컴파일 시점에 알 수 없는 클래스를 동적으로 로드하고 생성해야 할 때
: b. if-else문이나 switch 구문으로 처리하는 방식은 반복적이고 불필요하게 길어질 수 있습니다. (코드 간결화를 위해)

</br></br>

### Reflection 사용 방법

```java
import java.util.Map;
import java.util.HashMap;

public interface DatabaseConnector {
    void connect();
}

public class MySQLConnector implements DatabaseConnector {
    public void connect() {
        System.out.println("Connecting to MySQL Database");
    }
}

public class PostgreSQLConnector implements DatabaseConnector {
    public void connect() {
        System.out.println("Connecting to PostgreSQL Database");
    }
}

public class DynamicDatabaseLoader {
    private Map<String, DatabaseConnector> connectorMap = new HashMap<>();

    public DatabaseConnector loadDatabaseConnector(String className) throws Exception {
        if (connectorMap.containsKey(className)) {
            return connectorMap.get(className);
        }
        Class<?> clazz = Class.forName(className);
        DatabaseConnector connector = (DatabaseConnector) clazz.getDeclaredConstructor().newInstance();
        connectorMap.put(className, connector);
        return connector;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        DynamicDatabaseLoader loader = new DynamicDatabaseLoader();
        DatabaseConnector connector = loader.loadDatabaseConnector("MySQLConnector");
        connector.connect();  // 실행 시 동적으로 클래스 로드 후 연결
    }
}


```