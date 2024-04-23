
## Template/Callback Pattern(템플릿/콜백 패턴)

템플릿/콜백 패턴은 반복적인 작업을 처리하 코드 중복을 줄이는 데 유용하다.
특정 작업의 구조를 정의한 `템플릿`을 만들고, 이 템플릿 내에서 변하는 부분만 `콜백`으로 처리한다. 


### 1. 사용 목적

- 코드중복 감소
  - 템플릿을 통해 공통적인 부분을 정의하고, 콜백을 통해 변하는 부분만 처리한다.<br><br>
  
- 유지보수 향상
  - 공통 로직이 템플릿에 중앙화되어 있기 때문에, 수정이 필요한 곳만 변경하면 된다.
  - 큰 규모의 시스템이나 많은 데이터 접근 패턴이 있는 애플리케이션에서 용이하다.<br><br>

- 결합도 감소
  - 템플릿과 콜백 간의 느슨한 결합은 시스템의 유연성을 증가시킨다.
  - 콜백 인터페이스를 통해 구현부를 교체하거나 수정하기 쉽기 때문에, 다양한 상황에 맞춰서 쉽게 코드를 조정할 수 있다.<br><br>

- 자원관리의 효율성
  - 템플릿은 자원을 획득하고 반환하는 과정을 관리한다. 이는 개발자가 자원 관리에 신경 쓸 필요 없이 비즈니스 로직에만 집중할 수 있게 해준다.<br><br>

- 테스트 용이성
  - 콜백 로직을 독립적으로 테스트할 수 있기 때문에, 복잡한 통합 테스트 없이도 로직의 정확성을 검증할 수 있다.
  - 모의 객체(Mock)를 사용하여 콜백을 테스트할 수 있어, 테스트 환경 구성이 간단하다.


### 2. 예제 소스

```java
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserById(int id) {
        String sql = "SELECT id, name, email FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }
}

class User {
    private int id;
    private String name;
    private String email;

    // Getters and Setters
}
```

1. 코드 중복 감소: JdbcTemplate는 데이터베이스 연결, SQL 실행, 결과 처리 등의 반복적인 작업을 수행합니다. 사용자는 변화하는 SQL 쿼리와 결과 매핑 로직만 제공합니다. 이로써, 데이터 액세스 코드의 중복을 줄일 수 있습니다.
2. 유지보수성 향상: 모든 데이터베이스 작업에 대한 템플릿 로직이 JdbcTemplate 내에 캡슐화되어 있습니다. 데이터베이스 연결 방식이나 예외 처리 로직을 변경해야 할 경우, JdbcTemplate을 수정하면 모든 관련 코드에 일관성 있게 적용됩니다.
3. 결합도 감소: RowMapper를 통해 SQL 결과를 객체로 매핑하는 로직을 콜백으로 제공합니다. 이 인터페이스를 다양한 방식으로 구현함으로써, SQL 처리 로직과 데이터 매핑 로직이 서로 독립적으로 유지되어, 각각 수정 및 확장이 용이합니다.
4. 자원 관리의 효율성: JdbcTemplate는 내부적으로 데이터베이스 연결과 자원 해제를 관리합니다. 이는 자원 누수를 방지하고, 예외 상황에서도 안전하게 자원을 정리할 수 있도록 도와줍니다.
5. 테스트 용이성: RowMapper 같은 콜백 인터페이스를 모의 객체(Mock)로 쉽게 대체할 수 있습니다. 이를 통해 데이터베이스에 접근하지 않고도 콜백의 로직을 단위 테스트할 수 있습니다.

