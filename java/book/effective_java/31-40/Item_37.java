public class Item_37 {
    // [page 226]
    // ordinal 인덱싱 대신 EnumMap 사용하기
    static enum PipeType {
        STRAIGHT_HORIZONTAL('-', new int[][]{{0, 1}, {0, -1}}),
        STRAIGHT_VERTICAL('|', new int[][]{{1, 0}, {-1, 0}}),
        CURVED_TOP_LEFT('L', new int[][]{{1, 0}, {0, 1}}),
        CURVED_TOP_RIGHT('R', new int[][]{{1, 0}, {0, -1}}),
        CURVED_BOTTOM_LEFT('B', new int[][]{{-1, 0}, {0, 1}}),
        CURVED_BOTTOM_RIGHT('J', new int[][]{{-1, 0}, {0, -1}});

        private final char representation;
        private final int[][] directions;

        PipeType(char representation, int[][] directions) {
            this.representation = representation;
            this.directions = directions;
        }

        public char getRepresentation() {
            return representation;
        }

        public int[][] getDirections() {
            return directions;
        }

        public static PipeType fromChar(char c) {
            for (PipeType p : values()) {
                if (p.representation == c) {
                    return p;
                }
            }
            throw new IllegalArgumentException("Unknown pipe type: " + c);
        }
    }

    /*
    enum Pipe가 아래과 같이 정의된 경우
    STRAIGHT_HORIZONTAL(new int[][]{{0, 1}, {0, -1}}),
    STRAIGHT_VERTICAL(new int[][]{{1, 0}, {-1, 0}}),
    ...

    // enumMap을 사용하여 PipeSystem 클래스를 정의할 수 있다.
    static class PipeSystem {
        private static final EnumMap<PipeType, Character> pipeMap = new EnumMap<>(PipeType.class);

        static {
            pipeMap.put(PipeType.STRAIGHT_HORIZONTAL, '-');
            pipeMap.put(PipeType.STRAIGHT_VERTICAL, '|');
            pipeMap.put(PipeType.CURVED_TOP_LEFT, 'L');
            pipeMap.put(PipeType.CURVED_TOP_RIGHT, 'R');
            pipeMap.put(PipeType.CURVED_BOTTOM_LEFT, 'B');
            pipeMap.put(PipeType.CURVED_BOTTOM_RIGHT, 'J');
        }
        ...

    }

     */
}

/*

EnumMap
1) enum 타입의 키를 사용하는 특수한 맵
2) 열거형 상수를 키로 하여 연관된 값을 효율적으로 저장하고 검색할 수 있다.
3) 내부적으로 배열을 사용하여 빠른 성능 제공

 */