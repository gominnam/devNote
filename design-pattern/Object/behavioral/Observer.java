import java.util.*;

public class Observer {
    // Observer Interface - 주체로부터 상태 변화를 알림받을 때 구현 메서드 정의
    interface ObserverIF {
        void update(String message);
    }

    // Subject Interface - Observer 객체들을 등록, 삭제, 알림을 위한 메서드 정의
    interface Subject {
        void registerObserver(ObserverIF observer);
        void removeObserver(ObserverIF observer);
        void notifyObservers();
    }

    static class NewsChannel implements Subject {
        private List<ObserverIF> observers;
        private String news;

        public NewsChannel() {
            this.observers = new ArrayList<>();
        }

        // Observer 등록
        @Override
        public void registerObserver(ObserverIF observer) {
            observers.add(observer);
        }

        // Observer 삭제
        @Override
        public void removeObserver(ObserverIF observer) {
            observers.remove(observer);
        }

        // Observer 알림
        @Override
        public void notifyObservers() {
            for (ObserverIF observer : observers) {
                observer.update(news);
            }
        }

        // 뉴스 업데이트
        public void updateNews(String news) {
            this.news = news;
            notifyObservers();
        }
    }

    static class Subscriber implements ObserverIF {
        private String name;

        public Subscriber(String name) {
            this.name = name;
        }

        @Override
        public void update(String message) {
            System.out.println(name + " received news: " + message);
        }
    }

    public static void main(String[] args) {
        // 뉴스 채널(주제) 생성
        NewsChannel newsChannel = new NewsChannel();

        // 구독자(옵서버) 생성
        Subscriber subscriber1 = new Subscriber("mj");
        Subscriber subscriber2 = new Subscriber("Bob");
        Subscriber subscriber3 = new Subscriber("Alice");

        // 옵서버 등록
        newsChannel.registerObserver(subscriber1);
        newsChannel.registerObserver(subscriber2);
        newsChannel.registerObserver(subscriber3);

        // 뉴스 업데이트 -> 옵서버들에게 알림
        newsChannel.updateNews("첫번째 뉴스 : 감시자 패턴이 처음으로 작동합니다.");

        // 한 구독자 제거
        newsChannel.removeObserver(subscriber2);

        // 뉴스 업데이트 -> 남은 옵서버들에게 알림
        newsChannel.updateNews("두번째 뉴스: 구독자 한분이 더 이상 뉴스를 받지 않습니다.");
    }
}

/*

:: 감지사 패턴 (Observer Pattern) ::

1. 구조

: Subject(주제)    -    Observer(감시자)
       |                     |
  Concrete Subject     Concrete Observer

2. 의도

: 객체 간 1대 다의 관계를 정의하고 상태 변화가 있을 때, 그 객체에 의존하는 다른 객체들에게 자동 통보 되도록 하는 패턴.

3. 활용

: 소셜 미디어 알림 - 팔로우, 구독, 좋아요 등의 알림을 받을 때
: 실시간 데이터 피드 - 주식, 날씨, 교통정보 등의 실시간 데이터를 받을 때
: 이벤트 시스템 - GUI 프레임워크에서 버튼 클릭 시 여러 컴포넌트가 반응하는 구조


 */