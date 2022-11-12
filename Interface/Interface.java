package Interface;

import java.util.ArrayList;
import java.util.Scanner;

import Vehicle.Vehicle;
import Vehicle.Automobile.SubAutomobiles.*;
//import Vehicle.Automobile.SubAutomobiles.Hatchback;
//import Vehicle.Automobile.SubAutomobiles.Minivan;
//import Vehicle.Automobile.SubAutomobiles.Sedan;
import Vehicle.Automobile.*;
import Vehicle.Bicycle.Bicycle;
import Vehicle.PickupTruck.PickupTruck;
import Vehicle.Vehicle.MonthOfSale;
import Vehicle.Vehicle.CityOfSale;
import Vehicle.Vehicle.ProductionYear;
import Vehicle.Bicycle.Bicycle.ChainType;
import Vehicle.Bicycle.Bicycle.SeatPost;

import Vehicle.Automobile.SubAutomobiles.Sedan.*;;

public class Interface {
    ArrayList<Vehicle> vehicles;

    public Interface(ArrayList<Vehicle> vahicles) {
        this.vehicles = new ArrayList<>(vehicles);
    }

    public Interface() {
        this.vehicles = new ArrayList<Vehicle>();
        
        //Bicycle mini = new Bicycle("B653",MonthOfSale.valueOf("May"),CityOfSale.Istanbul,ProductionYear.2005,8.0, ChainType.DERAILLEUR,SeatPost.STEEL);
        //System.out.println(mini.getMonthOfSale().value());
        Automobile mini = new Sedan("B653",MonthOfSale.valueOf("May"),CityOfSale.Istanbul,ProductionYear.TwoThousund01_08,8.0, 
        		1.8,"SunRoof");
        //System.out.println(mini.getNumberOfSeats().value());
        
        //System.out.println(mini.calculateTotalPrice());
        System.out.println(((Sedan)mini).getRoofType());
        
    }

    public void start() {
        printMenu();
        int input = takeInput();
        ArrayList<Vehicle> list = getList(input);
        printResults(list);
    }

    private void printMenu() {
        System.out.println("Press :");
        System.out.println("1 to see all sold vehicles list");
        System.out.println("2 to see all sold sedan list");
        System.out.println("3 to see all sold hatchback list");
        System.out.println("4 to see all sold minivan list");
        System.out.println("5 to see all sold pickup truck list");
        System.out.println("6 to see all sold bicycle list");
        System.out.print("Please enter your choice : ");
    }

    private int takeInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            int input = 0;
            while (true) {
                input = scanner.nextInt();

                if (0 < input && input < 7) {
                    break;
                }
                else {
                    System.out.println("Invalid input. Try again.");
                }
            }
            return input;
        }
    }

    private ArrayList<Vehicle> getList(int input) {
        ArrayList<Vehicle> list = new ArrayList<>();

        for (Vehicle v : this.vehicles) {
            switch (input) {
                case 1: 
                    if (v.getClass().equals(Vehicle.class)) {
                        list.add(new Vehicle(v));
                    } 
                    break;
                case 2: 
                    if (v.getClass().equals(Sedan.class)) {
                        list.add(new Sedan(v));
                    }; 
                    break;
                case 3: 
                    if (v.getClass().equals(Hatchback.class)) {
                        list.add(new Hatchback(v));
                    } 
                    break;
                case 4: 
                    if (v.getClass().equals(Minivan.class)) {
                        list.add(new Minivan(v));
                    } 
                    break;
                case 5: 
                    if (v.getClass().equals(PickupTruck.class)) {
                        list.add(new PickupTruck(v));
                    } 
                    break;
                case 6: 
                    if (v.getClass().equals(Bicycle.class)) {
                        list.add(null);
                    } 
                    break;
            }

        }
        return list;
    }

    private void printResults(ArrayList<Vehicle> list) {
        for (Vehicle v : list) {
            System.out.println(v.toString());
        }
    }

    // private ArrayList<Vehicle> getVehicles() {
    //     return null;
    // }

    // private ArrayList<Vehicle> getSedans() {
    //     return null;
    // }

    // private ArrayList<Vehicle> getHatchBacks() {
    //     return null;
    // }

    // private ArrayList<Vehicle> getMinivans() {
    //     return null;
    // }

    // private ArrayList<Vehicle> getPickupTrucks() {
    //     return null;
    // }

    // private ArrayList<Vehicle> getBicycles() {
    //     return null;
    // }
}
