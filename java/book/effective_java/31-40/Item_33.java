import java.util.*;

public class Item_33 {
    // [page 200]
    public static class Favorites {
        private Map<Class<?>, Object> favorites = new HashMap<>();

        public <T> void putFavorite(Class<T> type, T instance) {
            if (type == null) {
                throw new NullPointerException("Type is null");
            }
            favorites.put(type, type.cast(instance));
        }

        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }
    }


    public static void main(String[] args){
        Favorites favorites = new Favorites();

        // 다양한 타입의 객체를 컨테이너에 저장
        favorites.putFavorite(String.class, "Java");
        favorites.putFavorite(Integer.class, 123);
        favorites.putFavorite(Class.class, Favorites.class);

        // 저장한 객체를 타입 안전하게 불러오기
        String favoriteString = favorites.getFavorite(String.class);
        Integer favoriteInteger = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

        // 출력
        System.out.println("Favorite String: " + favoriteString);
        System.out.println("Favorite Integer: " + favoriteInteger);
        System.out.println("Favorite Class: " + favoriteClass.getName());
    }
}

/*

why?
데이터베이스의 행(row)은 임의 개수의 열(Column)을 가질 수 있는데, 모두 열을 타입 안전하게 이용하고 싶은 문제

==> 타입 안전 이종 컨에티너 패턴 사용
제네릭과 `Class`객체를 키로 사용하는 기을 사용할 수 있다.


 */