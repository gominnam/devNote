public class Command {
    // Command Interface
    interface CommandIF {
        void execute();
    }

    // Receiver TV
    static class TV {
        void turnOn() {
            System.out.println("TV is on");
        }

        void turnOff() {
            System.out.println("TV is off");
        }
    }

    // Receiver Radio
    static class Radio {
        void turnOn() {
            System.out.println("Radio is on");
        }

        void turnOff() {
            System.out.println("Radio is off");
        }
    }

    static class TVOnCommand implements CommandIF {
        private TV tv;

        public TVOnCommand(TV tv) {
            this.tv = tv;
        }

        @Override
        public void execute() {
            tv.turnOn();
        }
    }

    static class TVOffCommand implements CommandIF {
        private TV tv;

        public TVOffCommand(TV tv) {
            this.tv = tv;
        }

        @Override
        public void execute() {
            tv.turnOff();
        }
    }

    static class RadioOnCommand implements CommandIF {
        private Radio radio;

        public RadioOnCommand(Radio radio) {
            this.radio = radio;
        }

        @Override
        public void execute() {
            radio.turnOn();
        }
    }

    static class RadioOffCommand implements CommandIF {
        private Radio radio;

        public RadioOffCommand(Radio radio) {
            this.radio = radio;
        }

        @Override
        public void execute() {
            radio.turnOff();
        }
    }

    // Invoker
    static class RemoteControl {
        private CommandIF command;

        public void setCommand(CommandIF command) {
            this.command = command;
        }

        public void pressButton() {
            if (command != null) {
                command.execute();
            } else {
                System.out.println("No command assigned");
            }
        }
    }

    public static void main(String[] args){
        RemoteControl remote = new RemoteControl();

        TV tv = new TV();
        Radio radio = new Radio();

        // TV 명령 생성
        CommandIF tvOn = new TVOnCommand(tv);
        CommandIF tvOff = new TVOffCommand(tv);

        // 라디오 명령 생성
        CommandIF radioOn = new RadioOnCommand(radio);
        CommandIF radioOff = new RadioOffCommand(radio);

        // 리모컨으로 TV 켜기
        remote.setCommand(tvOn);
        remote.pressButton();

        // 리모컨으로 TV 끄기
        remote.setCommand(tvOff);
        remote.pressButton();

        // 리모컨으로 라디오 켜기
        remote.setCommand(radioOn);
        remote.pressButton();

        // 리모컨으로 라디오 끄기
        remote.setCommand(radioOff);
        remote.pressButton();
    }
}

/*

:: 명령 패턴 (Command Pattern) ::

1. 구조

: Command(명령) - Concrete Command(구체적인 명령) - Invoker(명령 실행자) - Receiver(명령 수신자)

2. 의도

: 요청을 캡슐화하여 서로 다른 사용자가 동일한 명령을 실행할 수 있도록 해줍니다.
  `명령을 객체`로 만들고, 요청을 발신자와 수신자로부터 분리하여 명령을 나중에 실행하거나, 취소할 수 있는 구조를 제공합니다.

3. 활용

: 매크로 - 여러 명령을 하나의 명령으로 묶어 한 번에 실행하는 매크로 시스템.
: 트랜잭션 관리 - 작업을 큐(queue)에 넣어 트랜잭션을 순차적으로 처리하거나 취소할 수 있는 시스템.
: Undo/Redo 기능 - 실행한 명령을 취소하거나 다시 실행할 수 있는 기능을 제공하는 시스템.

 */