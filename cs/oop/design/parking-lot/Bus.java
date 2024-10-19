public Bus extends Vehicle {
    public Bus() {
        spotsNeeded = 5;
        size = VehicleSize.LARGE;
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSpotSize() == VehicleSize.LARGE;
    }
}