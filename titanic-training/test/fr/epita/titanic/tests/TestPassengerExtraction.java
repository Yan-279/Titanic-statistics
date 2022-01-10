package fr.epita.titanic.tests;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.epita.titanic.datamodel.Passenger;
import fr.epita.titanic.services.PassengerCSVReader;
import fr.epita.titanic.services.PassengerCSVReader2;

public class TestPassengerExtraction {

    public static void main(String[] args) throws IOException {

        givenTestFile_thenWeShouldHaveAValidListOfPassengers();
        computeStatisticalFacts();
    }

    private static void givenTestFile_thenWeShouldHaveAValidListOfPassengers() throws IOException {
        File file = new File("D:/MSc EPITA/Java and UML/2021-t3-java-uml-ais-master (1)/2021-t3-java-uml-ais-master/titanic-training/test.csv");
        PassengerCSVReader2 reader = new PassengerCSVReader2();
        List<Passenger> passengers = reader.readPassengers(file);

        System.out.println(passengers);

    }

    private static void computeStatisticalFacts() {
        /*PassengerCSVReader reader = new PassengerCSVReader();
        List<Passenger> passengers = reader.read(new File("D:/MSc EPITA/Java and UML/2021-t3-java-uml-ais-master (1)/2021-t3-java-uml-ais-master/titanic-training/test.csv"));
*/
        File file = new File("D:/MSc EPITA/Java and UML/2021-t3-java-uml-ais-master (1)/2021-t3-java-uml-ais-master/titanic-training/test.csv");
        PassengerCSVReader2 reader = new PassengerCSVReader2();
        List<Passenger> passengers = null;
        try {
            passengers = reader.readPassengers(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Double totalAge = 0.0;
        for(Passenger passenger : passengers){
            totalAge += passenger.getAge();
        }
        double averageAge = totalAge / passengers.size();
        System.out.println("The average of the age of every passenger is: " + averageAge);

        Double maxAge = 0.0;
        String maxName = "";
        for(Passenger passenger : passengers){
            if (passenger.getAge() > maxAge){
                maxAge = passenger.getAge();
                maxName = passenger.getName();
            }
        }
        System.out.println("The age of the oldest passenger is: " + maxAge + " and name is: " + maxName);

        Integer numMale = 0;
        Integer numFemale = 0;
        for(Passenger passenger : passengers){
            //System.out.println(passenger.getSex());
            if (passenger.getSex().equals("female")) {
                numFemale += 1;
            } else {
                numMale += 1;
            }
        }
        System.out.println("The total number of males is: " + numMale);
        System.out.println("The total number of females is: " + numFemale);


        Double minAge = 100.0;
        String minName = "";
        for(Passenger passenger : passengers){
            if (passenger.getAge() < minAge){
                minAge = passenger.getAge();
                minName = passenger.getName();
            }
        }
        System.out.println("The age of the youngest passenger is: " + minAge + " and name is: " + minName);

    }

    //loading the train.csv file

}
