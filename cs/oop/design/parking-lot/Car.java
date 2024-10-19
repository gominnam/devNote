public class Car extends Vehicle {
    public Car() {
        spotneeded = 1;
        size = VehicleSize.COMPACT;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.COMPACT || spot.getSpotSize() == VehicleSize.LARGE;
    }
}