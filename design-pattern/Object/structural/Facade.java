public class Facade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public Facade() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void start() { // 복잡한 서브시스템을 단순하게 제공하는 인터페이스
        cpu.freeze();
        memory.load(0, hardDrive.read(0, 1024));
        cpu.jump(0);
        cpu.execute();
    }

    public static void main(String[] args){
        Facade facade = new Facade();
        facade.start(); // 클라이언트는 Facade 객체를 통해 컴퓨터 시스템을 쉽게 시작
    }

    // 복잡한 서브시스템 클래스 1
    public static class CPU {
        public void freeze() {
            System.out.println("CPU freeze");
        }

        public void jump(long position) {
            System.out.println("CPU jump to " + position);
        }

        public void execute() {
            System.out.println("CPU execute");
        }
    }

    // 복잡한 서브시스템 클래스 2
    public static class Memory {
        public void load(long position, byte[] data) {
            System.out.println("Memory load data to " + position);
        }
    }

    // 복잡한 서브시스템 클래스 3
    public static class HardDrive {
        public byte[] read(long lba, int size) {
            System.out.println("HardDrive read data from " + lba + " with size " + size);
            return new byte[size];
        }
    }
}

/*

:: 퍼사드 패턴 (Facade Pattern) ::

1. 구조

: 복잡한 서브시스템을 단순하게 제공하는 인터페이스를 제공하는 패턴

2. 의도

: 복잡한 서브시스템을 일일히 호출해야하는 복잡합을 클라이언트가 쉽게 사용할 수 있도록 제공
: 클라이언트는 Facade 객체를 통해 컴퓨터 시스템을 시작

 */