public abstract class Vehicle {
    protected ArrayList<ParkingSpot> parkingSpots = new ArrayList(); // 실제 차량이 주차된 공간 리스트
    protected String licensePlate;
    protected int spotsNeeded; // 차량이 필요로 하는 주차 공간 수
    protected VehicleSize size; // 차량 크기

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        for(int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}