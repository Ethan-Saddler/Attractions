public class Group {
    private final String[] people;

    public Group(String[] people) {
        String[] newPeople;
        if (people == null) {
            newPeople = new String[0];
        }
        newPeople = new String[people.length];
        for (int n = 0 ; n < people.length ; n++) {
            newPeople[n] = people[n];
        }
        this.people =  newPeople;
    }
    public Group(Group group) {
        this.people = group.people;
    }
    public int size() {
        return people.length;
    }
    @Override
    public String toString() {
        String str = "";
        for (int n = 0 ; n < this.people.length ; n++) {
            if (n == 0) {
                str += people[n];
                continue;
            }
            str += String.format("/%s", people[n]);
        }
        return str;
    }
    public String[] getPeople() {
        return people;
    }
    public void setPeople(int index, String name) {
        this.people[index] = name;
    }
}