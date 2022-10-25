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
    }
}