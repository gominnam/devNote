public class Adaptor {
    // Target 인터페이스
    public static interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // Adaptee 클래스
    public static class AdvancedMediaPlayer {
        public void playVlc(String fileName) {
            System.out.println("Playing VLC file: " + fileName);
        }

        public void playMp4(String fileName) {
            System.out.println("Playing MP4 file: " + fileName);
        }
    }

    // AdvancedMediaPlayer 클래스를 상속하고, MediaPlayer 인터페이스를 구현
    public class MediaAdapter extends AdvancedMediaPlayer implements MediaPlayer {

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                playVlc(fileName);  // Adaptee method 호출
            } else if (audioType.equalsIgnoreCase("mp4")) {
                playMp4(fileName);  // Adaptee method 호출
            }
        }
    }

    // Client 클래스 MediaPlayer 인터페이스만 알고 사용
    public static class AudioPlayer implements MediaPlayer {

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing MP3 file: " + fileName);
            } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
            } else {
                System.out.println("Invalid media. " + audioType + " format not supported");
            }
        }
    }

    public static void main(String[] args){
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}

/*

:: 적응자 (Adaptor Pattern) ::

- 다른이름으로 Wrapper 패턴이라고도 한다.

1. 구조

: Client -> Target Interface -> Adapter -> Adaptee

2. 의도

: 호환성이 없는 인터페이스를 함께 동작할 수 있도록 변환하는 패턴

3. Class Adapter Pattern

: 상속을 이용한 Adapter 패턴
: 퍼포먼스가 Object Adapter Pattern에 비해 더 좋다.
: 강하게 결합해야할 이유가 없으면 Object 패턴으로 사용하는게 좋아보인다.

 */