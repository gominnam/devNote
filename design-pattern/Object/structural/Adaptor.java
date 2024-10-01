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

    // Adaptee(AdvancedMediaPlayer)를 MediaPlayer 인터페이스에 맞게 변환하는 어댑터
    public static class MediaAdapter implements MediaPlayer {

        private AdvancedMediaPlayer advancedMediaPlayer;

        public MediaAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer = new AdvancedMediaPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer = new AdvancedMediaPlayer();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer.playVlc(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer.playMp4(fileName);
            }
        }
    }

    // Client 클래스 MediaPlayer 인터페이스만 알고 사용
    public static class AudioPlayer implements MediaPlayer {
        private MediaAdapter mediaAdapter;

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

3. Object Adapter Pattern

: Adapter 클래스가 Adaptee 클래스를 상속받는 대신, Adaptee 클래스를 멤버 변수로 가짐
: Adaptee 와 낮은 결합도
: 다중 Adaptee 와 결합 가능

 */