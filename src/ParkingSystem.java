import java.util.concurrent.atomic.AtomicInteger;

public class ParkingSystem {
    private final AtomicInteger[] slot;

    public ParkingSystem(int big, int medium, int small) {
        var bigLimit = new AtomicInteger(big);
        var mediumLimit = new AtomicInteger(medium);
        var smallLimit = new AtomicInteger(small);
        this.slot = new AtomicInteger[]{bigLimit, mediumLimit, smallLimit};
    }

    public boolean addCar(int carType) {
        return slot[carType - 1].decrementAndGet() >= 0;
    }
}
