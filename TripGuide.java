public class TripGuide {
    public static void main(String[] args) {
        Attraction[] attractions = new Attraction[]{new Attraction("Coaster", 
        15.50), new Attraction("Ferris", 15.50), 
        new Museum("Art Museum", 15.50, 50), 
        new Attraction("Basketball", 10.25), 
        new Museum("Science Museum")};

        String[] people1 = new String[]{"A","B","C","D"};
        String[] people2 = new String[]{"E","F","G","H","I","J","K","L"};
        String[] people3 = new String[]{"M","N","O","P","Q","R","S","T","U","V"};
        String[] people4 = new String[]{"W","X","Y","Z","AA","AB","AC","AD","AE","AF","AG","AH","AI"};

        for (Attraction attraction : attractions) {
            attraction.admit(people1);
            // attraction.printVisitors();
            attraction.admit(people2);
            // attraction.printVisitors();
            attraction.admit(people3);
            // attraction.printVisitors();
            attraction.admit(people4);
            attraction.printVisitors();
        }
        attractions[0].rateAndExit(3, 9);
        attractions[0].rateAndExit(4, 7);
        attractions[1].rateAndExit(3, 9);
        attractions[1].rateAndExit(4, 7);

        attractions[2].rateAndExit(3, 4);
        attractions[2].rateAndExit(4,39);
        attractions[3].rateAndExit(1, 5);
        attractions[3].rateAndExit(6, 3);

        for (Attraction attraction : attractions) {
            attraction.printVisitors();
        }

        System.out.printf("Tests for rateAndExit()%n%.2f, %.2f, %.2f, %.2f, %.2f%n", 
        attractions[0].getRating(), attractions[1].getRating(), attractions[2].getRating(), 
        attractions[3].getRating(), attractions[4].getRating());

        for (Attraction attraction : attractions) {
            System.out.println(attraction.toString());
            attraction.printVisitors();

        }

        System.out.println(attractions[0].compareTo(attractions[1]));
        System.out.println(attractions[0].compareTo(attractions[2]));
        System.out.println(attractions[0].compareTo(attractions[3]));
        System.out.println(attractions[2].compareTo(attractions[0]));

    }
}