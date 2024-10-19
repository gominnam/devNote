public class Level {
    private int floor;
    private ParkingSpot[] spots;
    private int availableSpots = 0; // 빈자리 개수
    private static final int SPOTS_PER_ROW = 10; // 한 줄당 주차공간 개수

    public Level(int flr, int numberSpots) {
        floor = flr;
        spots = new ParkingSpot[numberSpots];
        int largeSpots = numberSpots / 4; // 대형차 주차공간 수
        int bikeSpots = numberSpots / 4;  // 오토바이 주차공간 수
        int compactSpots = numberSpots - largeSpots - bikeSpots;
        for (int i = 0; i < numberSpots; i++) {
            VehicleSize sz = VehicleSize.MORTORCYCLE;
            if (i < largeSpots) {
                sz = VehicleSize.LARGE;
            } else if (i < largeSpots + compactSpots) { // 대형차 주차공간 수 + 오토바이 주차공간 수
                sz = VehicleSize.COMPACT;
            }
            int row = i / SPOTS_PER_ROW; // 주차공간을 나누어 줄을 구함
            spots[i] = new ParkingSpot(this, row, i, sz);
        }
        availableSpots = numberSpots;
    }

    public int availableSpots() {
        return availableSpots;
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots() < vehicle.getSpotsNeeded()) {
            return false;
        }
        int spotNumber = findAvailableSpots(vehicle);
        if (spotNumber < 0) {
            return false;
        }
        return parkStartingAtSpot(spotNumber, vehicle);
    }

    private int findAvailableSpots(Vehicle vehicle) {
        int spotsNeeded = vehicle.getSpotsNeeded();
        int lastRow = -1;
        int spotsFound = 0;
        for (int i = 0; i < spots.length; i++) {
            ParkingSpot spot = spots[i];
            if (lastRow != spot.getRow()) {
                spotsFound = 0;
                lastRow = spot.getRow();
            }
            if (spot.canFitVehicle(vehicle)) {
                spotsFound++;
            } else {
                spotsFound = 0;
            }
            if (spotsFound == spotsNeeded) {
                return i - (spotsNeeded - 1);
            }
        }
        return -1;
    }

    private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
        vehicle.clearSpots();
        boolean success = true;
        for (int i = spotNumber; i < spotNumber + vehicle.getSpotsNeeded(); i++) {
            success &= spots[i].park(vehicle);
        }
        availableSpots -= vehicle.getSpotsNeeded();
        return success;
    }

    public void spotFreed() { // freed: 자유로운(해방된)
        availableSpots++;
    }
}