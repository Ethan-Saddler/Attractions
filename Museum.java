public class Museum extends Attraction {
    private final int maxCapacity;
    private int occupancy = 0;

    public Museum(String name, double admissionFee, int maxCapacity) {
        super(name, admissionFee);
        if (maxCapacity < 25) {
            this.maxCapacity = 25;
        } else {
            this.maxCapacity = maxCapacity;
        }
    }
    public Museum(String name) {
        super(name);
        this.maxCapacity = 25;
    }
    @Override
    public void admit(String[] names) {
        if (names.length > maxCapacity - getVisitorCount()) {
            System.out.println("Museum has reached maximum capacity. Please visit another time!");
        } else {
            super.admit(names);
            occupancy += names.length;
            System.out.printf("Current occupancy: %d", occupancy);
        }
    }
    @Override
    public void rateAndExit(int index, int rating) {
        if (this.getGroupCount(index) != -1) {
            occupancy -= this.getGroupCount(index);
        }
        super.rateAndExit(index, rating);
    }
    public double percentOccupancy() {
        double x = (double) occupancy;
        double y = (double) maxCapacity;
        double rounded = (double) Math.round((x/y) * 100) / 100;
        return rounded * 100;
    }   
    @Override
    public String toString() {
        return String.format("Museum: %s/%.2f%% ------ %d --- %d", super.toString(), percentOccupancy(), occupancy, maxCapacity);
    }

}