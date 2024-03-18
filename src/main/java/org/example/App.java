package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Part 1 - Sorting Arrays !" );

//        Store the States and Capitals in a Two dimensional array

        String[][] stateCapitals = {
                {"Alabama", "Montgomery"}, {"Alaska", "Juneau"}, {"Arizona", "Phoenix"}, {"Arkansas", "Little Rock"},
                {"California", "Sacramento"}, {"Colorado", "Denver"}, {"Connecticut", "Hartford"}, {"Delaware", "Dover"},
                {"Florida", "Tallahassee"}, {"Georgia", "Atlanta"}, {"Hawaii", "Honolulu"}, {"Idaho", "Boise"},
                {"Illinois", "Springfield"}, {"Indiana", "Indianapolis"}, {"Iowa", "Des Moines"}, {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"}, {"Louisiana", "Baton Rouge"}, {"Maine", "Augusta"}, {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"}, {"Michigan", "Lansing"}, {"Minnesota", "St. Paul"}, {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"}, {"Montana", "Helena"}, {"Nebraska", "Lincoln"}, {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"}, {"New Jersey", "Trenton"}, {"New Mexico", "Santa Fe"}, {"New York", "Albany"},
                {"North Carolina", "Raleigh"}, {"North Dakota", "Bismarck"}, {"Ohio", "Columbus"}, {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"}, {"Pennsylvania", "Harrisburg"}, {"Rhode Island", "Providence"}, {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"}, {"Tennessee", "Nashville"}, {"Texas", "Austin"}, {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"}, {"Virginia", "Richmond"}, {"Washington", "Olympia"}, {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"}, {"Wyoming", "Cheyenne"}
        };


        //Traverse the Array to Display the states and their capitals
        //Using an Enhanced for loop

        System.out.println("The 50 states and their respective capital");
        for(String[] stateCapital : stateCapitals){
            System.out.println(stateCapital[0] + " - " + stateCapital[1]);
        }

        //Implement bubble sort and sort the array by capital name.

        for(int i = 0; i < stateCapitals.length ; i++){

            for(int j = 0; j < stateCapitals.length - i - 1; j++){
                 if(stateCapitals[j][1].compareToIgnoreCase(stateCapitals[j + 1][1] ) > 0){
                    String[] temp = stateCapitals[j];
                    stateCapitals[j] = stateCapitals[j + 1];
                    stateCapitals[j + 1] = temp;
                 }
            }
        }
        System.out.println();


        // Ask the User to enter a capital name
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;

        for(String[] stateCapital : stateCapitals){
            System.out.println("Enter the Capital name of : " + stateCapital[0]);
            StringBuilder userAnswer = new StringBuilder(scanner.nextLine().trim());

            if(userAnswer.toString().equalsIgnoreCase(stateCapital[1])){
                correctCount++;
            }
        }

        System.out.println("Total correct count: " + correctCount);
        System.out.println();

        System.out.println( "Part 2 - Sorting & Searching HashMap !" );

        //Create a HashMap and Add the values using the States has the Key and the Capital has the value

        HashMap<String, String> stateCapitalHashMap = new HashMap<>();

        for(String[] stateCapital: stateCapitals){

            stateCapitalHashMap.put(stateCapital[0], stateCapital[1]);
        }

        //Traverse The Map and display to user
        System.out.println("Content of The HashMap: ");

        for(Map.Entry<String,String> entry : stateCapitalHashMap.entrySet()){

            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println();

        //Sorting the Map using a treeMap

        Map<String, String> sortedMap = new TreeMap<>(stateCapitalHashMap);

        //Ask The user to enter a state

        System.out.println("Enter a capital name to know find its capital name: ");
        String userInput = scanner.nextLine().trim();
        String capital = sortedMap.get(userInput);

        if(capital != null){
            System.out.println("Capital of " + userInput + " is " + capital);
        }else {
            System.out.println("State not found.");
        }

        scanner.close();
    }
}
