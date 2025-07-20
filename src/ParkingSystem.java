public class ParkingSystem {
    private final int[] slot;

    public ParkingSystem(int big, int medium, int small) {
        this.slot = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (slot[carType - 1] > 0) {
            slot[carType - 1]--;
            return true;
        }
        return false;
    }
}
