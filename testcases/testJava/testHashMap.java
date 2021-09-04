package testJava;

import java.util.HashMap;

public class testHashMap {
    private String osName = System.getProperty("os.name");

    public static void main(String[] args) {
/*        // Create a HashMap object called capitalCities
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        // Add keys and values (Country, City)
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities);
        */


        // Create a HashMap object called people
        HashMap<String, Integer> people = new HashMap<String, Integer>();
        // Add keys and values (Name, Age)
        people.put("John", 32);
        people.put("Steve", 30);
        people.put("Angie", 33);

//        for (String i : people.keySet()) {
//            System.out.println("key: " + i + " value: " + people.get(i));
//        }

        for (String index : people.keySet()) {
            System.out.println(index + " - " + people.get(index));
        }
    }
}
