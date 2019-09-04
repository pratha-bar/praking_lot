package com.gojek;

import com.gojek.business.ParkingLot;
import java.util.Scanner;

/**
 * Created on 03/09/2019, 9:25 PM
 * ParkingLotApplication.java
 *
 * @author prathabarsaiyan
 */
public class ParkingLotApplication {

    static ParkingLot parkingLot = new ParkingLot();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            String string = scanner.nextLine();
            mapInputToMethod(string);
        }

    }

    private static void mapInputToMethod(String string) {
        if(string.startsWith("create_parking_lot")){
            int lotSize = Integer.parseInt(string.substring(string.indexOf(" ")).trim());
            System.out.println(parkingLot.createParkingSlot(lotSize));
        } else if(string.equalsIgnoreCase("exit")){
            parkingLot.exit();
            System.exit(1);
        } else {
            if(parkingLot.getSize() == 0){
                System.out.println("Please create a parking 1st");
                return;
            }
            if(string.startsWith("park")){
                String regNo = string.substring(string.indexOf(" "), string.lastIndexOf(" ")).trim();
                String color = string.substring( string.lastIndexOf(" ")).trim();
                System.out.println(parkingLot.parkCar(regNo,color));
            } else if(string.startsWith("leave")){
                int lotNo = Integer.parseInt(string.substring(string.indexOf(" ")).trim());
                System.out.println(parkingLot.leave(lotNo));
            } else if(string.startsWith("status")){
                System.out.println(parkingLot.status());
            } else if(string.startsWith("registration_numbers_for_cars_with_colour")){
                String color = string.substring(string.indexOf(" ")).trim();
                System.out.println(parkingLot.regNoWithColor(color));
            } else if(string.startsWith("slot_number_for_registration_number")){
                String regNo = string.substring(string.indexOf(" ")).trim();
                System.out.println(parkingLot.slotNoForRegNo(regNo));
            } else if(string.startsWith("slot_numbers_for_cars_with_colour")){
                String color = string.substring(string.indexOf(" ")).trim();
                System.out.println(parkingLot.slotWithColor(color));
            }
        }
    }

}
