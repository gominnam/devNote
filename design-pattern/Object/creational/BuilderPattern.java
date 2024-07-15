public class BuilderPattern{

    static class Person {
        // 필수 매개변수
        private final String firstName;
        private final String lastName;

        // 선택 매개변수
        private final int age;
        private final String phone;
        private final String address;

        public static class Builder {
            private final String firstName;
            private final String lastName;

            // 선택 매개변수 초기화
            private int age = 0;
            private String phone = "";
            private String address = "";

            public Builder(String firstName, String lastName){
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public Builder age(int val){
                this.age = val;
                return this;
            }

            public Builder phone(String val){
                this.phone = val;
                return this;
            }

            public Builder address(String val){
                this.address = val;
                return this;
            }

            public Person build(){
                return new Person(this);
            }
        }

        private Person(Builder builder){
            firstName = builder.firstName;
            lastName = builder.lastName;
            age = builder.age;
            phone = builder.phone;
            address = builder.address;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    public static void main(String[] args){
        Person person = new Person.Builder("민준", "고")
                .age(30)
                .phone("123-456-7890")
                .address("서울특별시 강남구 3가")
                .build();

        System.out.println(person);
    }
}

/*

:: 빌더 (Builder Patter) ::

1. 의도

- 복잡한 객체를 생성하는 방법과 표현하는 방법을 정의하는 클래스를 별도로 분리
  서로 다른 표현이라도 이를 생성할 수 있는 동일한 절차를 제공

2. 이점과 효율성

- 코드의 가독성:
  객체를 생성하는 코드가 명확해지고, 가독성이 높아집니다.
- 유연성:
  필요한 매개변수만 설정할 수 있어, 모든 매개변수를 반드시 설하지 않아도 된다.
- 일관성 유지:
  객체 생성 시 불변성을 유지하여, 객체의 상태가 일관성 있게 유지된다.
- 확장성:
  새로운 필드를 추가할 때, 기존 코드를 크게 수정하지 않아도 된다.

 */