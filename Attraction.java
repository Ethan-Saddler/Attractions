public class Attraction implements Admittable, Comparable<Attraction> {
    final private String name;
    private long sumRatings = 0;
    private int numRatings = 0;
    final private double admissionFee;
    private Group[] visitors = new Group[5];

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
    public Group[] resize(Group[] visitors, int size) {
        Group[] visitorsCopy = new Group[size];
        for (int n = 0; n < size; n++) {
            if (n < 5) {
                visitorsCopy[n] = visitors[n];
            }
        }
        return visitorsCopy;
    }
    public void admit(String[] names) {
        String[] people = new String[5];
        int groupCount;
        int nameIndex = 0;

        if (names.length % 5 == 0) {
            groupCount = names.length / 5;
        } else {
            groupCount = names.length / 5 + 1;
        }
        for (int n = 1; n <= groupCount; n++) {
            for (int x = 0; x < 5; x++) {
                if (nameIndex < names.length) {
                    people[x] = new String(names[nameIndex]);
                    nameIndex++;
                } else {
                    people[x] = null;
                }
            }
            for (int m = 0; m <= visitors.length; m++) {
                if (m == visitors.length) {
                    visitors = resize(visitors, visitors.length * 2);
                    visitors[m] = new Group(people);
                    break;
                }
                if (visitors[m] == null) {
                    visitors[m] = new Group(people);
                    break;
                }
            }
        }
    }
    public void rateAndExit(int index, int rating) {
        if (index <= visitors.length - 1 && index >= 0 && visitors[index] != null) { 
            if (rating > 10) {
                rating = 10;
            }
            if (rating < 0) {
                rating = 0;
            }
            numRatings++;
            sumRatings += rating;
            visitors[index] = null;
            for (int n = index + 1; n < visitors.length; n++) {
                if (visitors[n] != null) {
                    visitors[n - 1] = new Group(visitors[n]);
                    visitors[n] = null;
                }
            } 
        } else {
            System.out.println("Could not update rating. Index invalid.");
        }
        
    }
    public double averageRating() {
        if (numRatings == 0) {
            return 0.0;
        } else {
            double sumRating = sumRatings;
            double numRating = numRatings;
            return (Math.round((100 * sumRating / numRating))) / 100.0;
        }
    }
    public void printVisitors() {
        System.out.println(this.toString());
        for (int n = 0; n < this.visitors.length; n++) {
            if (visitors[n] != null) {
                System.out.printf("Group %d: %s%n", (n + 1), visitors[n].toString());
            }
        }
    }
    @Override
    public String toString() {
        return String.format("%s/%.2f/%.2f", name, averageRating(), admissionFee);
    }
    @Override
    public int compareTo(Attraction attraction) {
        if (this.averageRating() == attraction.averageRating() 
            && this.admissionFee == attraction.admissionFee) {
            return 0;
        } else if (this.averageRating() > attraction.averageRating()) {
            return -1;
        } else if (this.averageRating() < attraction.averageRating()) {
            return 1;
        } else if (this.admissionFee < attraction.admissionFee) {
            return -1;
        }
        return 1;
    }
    public int getVisitorCount() {
        int count = 0;
        for (Group group : visitors) {
            if (group != null) {
                count += group.getPeople().length;
            }
        }
        return count;
    }
    public int getGroupCount(int index) {
        int count = 0;
        if (index >= visitors.length || visitors[index] == null) {
            count = -1;
        } else {
            count = visitors[index].getPeople().length;
        }
        return count;
    }
    public double getRating() {
        return sumRatings;
    }
}