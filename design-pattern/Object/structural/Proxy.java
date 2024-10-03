public class Proxy {
    // 이미지를 미리 로드하지 않고, 필요할 때만 로드하는 상황을 가정.
    // Subject
    interface Image {
        void display();
    }

    // RealImage
    static class RealImage implements Image {
        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk(); // 실제 이미지 로딩 (시간이 오래 걸림)
        }

        private void loadFromDisk() {
            System.out.println("Loading image from disk: " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    // Proxy
    static class ProxyImage implements Image {
        private RealImage realImage;
        private String fileName;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() { // display() 메서드가 호출될 때 실제 이미지를 로드
            if(realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    // Client
    public static void main(String[] args){
        Image image = new ProxyImage("test.jpg");

        // 실제 이미지는 첫 번째로 호출될 때만 로드됨
        System.out.println("Image will be loaded and displayed:");
        image.display(); // 이미지를 처음 요청할 때 로드됨

        System.out.println("\nImage is already loaded, no need to load again:");
        image.display(); // 이미 로드된 이미지를 다시 표시
    }
}

/*

:: 프록시 패턴 (Proxy Pattern) ::

1. 구조

: 다른 객체로의 접근을 제어하기 위한 대리자 또는 자리채움자 역할을 하는 패턴

2. 의도

: 실제 객체와 같은 인터페이스를 가지며, 실제 객체를 대체하거나 이를 감싸서 추가적인 기능을 제공할 수 있다.

3. 활용

: 지연 초기화(Lazy Initialization) - 객체가 필요할 때까지 생성을 지연시키는 방법.
: 접근 제어(Access Control) - 객체에 대한 접근 권한을 제한하거나, 인증/권한 부여 등의 기능을 추가하는 경우.
: 로깅, 캐시등 부가 기능 - 실제 객체에 접근하기 전에 로깅, 캐싱, 트랜잭션 처리 등의 부가적인 작업을 수행하는 경우.

 */