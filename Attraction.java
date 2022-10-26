public class Attraction implements Admittable {
    final protected String name;
    protected long sumRatings = 0;
    protected int numRatings = 0;
    final protected double admissionFee;
    Group[] visitors = new Group[5];

    public Attraction(String name, double admissionFee) {
        if (name.isEmpty()) {
            this.name = "No name";
        } else {
            this.name = name;
        }
        if (admissionFee < 0) {
            this.admissionFee = 0;
        } else {
            this.admissionFee = admissionFee;
        }
    }
    public Attraction(String name) {
        if (name.isEmpty()) {
            this.name = "No name";
        } else {
            this.name = name;
        }
        this.admissionFee = 5.25; 
    }
    public void admit(String[] names) {
        String[] people = new String[5];
        Group group = new Group(people);
        for (int n = 0; n < names.length; n++) {
            if (n == visitors.length) {
                visitors = resize(visitors, visitors.length * 2);
            }
            if (n % 5 != 0 || n == 0) {
                group.people[n % 5] = new String(names[n]);
            } else {
                visitors[n] = new Group(group);
                group = new Group(people);
            }
            if (names.length - 1 == n) {
                for (int x = 0; x < visitors.length; x++){
                    if (visitors[x] == null) {
                        visitors[x] = new Group(group);
                    }
                }
            }

        }
    }
    public void rateAndExit() {
        
    }
    public Group[] resize(Group[] visitors, int size) {
        Group[] visitorsCopy = new Group[size];
        for (int n = 0; n < size; n++) {
            if (n < 5) {
                visitorsCopy[n] = visitors[n];
            }
        }
        return visitorsCopy;
    }
}