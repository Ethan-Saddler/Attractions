public class Group {
    protected String[] people;

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
    public int size(Group group) {
        return group.people.length;
    }
    @Override
    public String toString() {
        String str = "";
        for (int n = 0 ; n < this.people.length ; n++) {
            if (n == 0) {
                System.out.print(people[n]);
                continue;
            }
            str += String.format("/%s", people[n]);
        }
        return str;
    }
}