import java.util.*;

public class Item_26 {
    // [page 154]
    public static void main(String[] args){
        // 1) raw type
        List rawList = new ArrayList();
        rawList.add("raw type String");
        rawList.add(10); // Raw type은 타입 안전성을 보장하지 않음

        // 원소 접근 시 명시적 캐스팅 필요
        String str = (String) rawList.get(0);
        Integer num = (Integer) rawList.get(1);
        System.out.println(str); // 출력: Hello
        System.out.println(num); // 출력: 10
        System.out.println();


        // 2) generic type
        List<String> genericList = new ArrayList<>();
        genericList.add("generic type String");
        // genericList.add(10); // 컴파일 오류 발생: 타입 불일치

        // 원소 접근 시 캐스팅 불필요
        String str2 = genericList.get(0);
        System.out.println(str2);
    }
}

/*

와일드카드 타입(?)
- 무제한 와일드카드 (<?>): 모든 타입을 허용합니다.
- 상한 경계 와일드카드 (<? extends T>): 특정 타입의 서브타입을 허용합니다.
- 하한 경계 와일드카드 (<? super T>): 특정 타입의 슈퍼타입을 허용합니다.

 */