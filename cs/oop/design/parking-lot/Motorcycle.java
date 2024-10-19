public class Motorcycle extends Vehicle {
    public Motorcycle {
        spotneeded = 1;
        size = VehicleSize.Motorcycle;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.MOTORCYCLE;
    }
}