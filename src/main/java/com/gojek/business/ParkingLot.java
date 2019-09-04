package com.gojek.business;

import com.gojek.model.Car;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import lombok.Getter;
import lombok.Setter;

/**
 * Created on 02/09/2019, 7:15 PM
 * ParkingLot.java
 *
 * @author prathabarsaiyan
 */
@Getter
@Setter
public class ParkingLot {

    private TreeSet<Integer> parkingSlot;
    private int size;
    private Map<String,Car> cars;
    private Map<String, Set<Car>> colorCarMapping;
    List<Car> list;

    public String createParkingSlot(int n){
        parkingSlot = new TreeSet <Integer>();
        for(int i = 1; i <= n; i++){
            parkingSlot.add(i);
        }
        cars = new HashMap <String, Car>();
        colorCarMapping = new HashMap <String, Set <Car>>();
        size = n;
        list = new ArrayList<Car>();

        return "Created a parking lot with "+n+" slots";
    }

    public String parkCar(String regNo, String color){
        if(cars.containsKey(regNo)){
            return "Duplicate Entry, car with registration no is already parked at slot no  "+cars.get(regNo).getSlotNo();
        }
        if(size == cars.size()){
            return "Sorry, parking lot is full";
        }
        int slot = parkingSlot.first();
        parkingSlot.remove(slot);
        color = color.toLowerCase();
        Car car = new Car(regNo, color,slot);
        cars.put(regNo,car);
        Set<Car> carSet = colorCarMapping.get(color);
        if(carSet == null){
            carSet = new HashSet <Car>();
            colorCarMapping.put(color,carSet);
        }
        list.add(slot,car);
        carSet.add(car);
        return "Allocated slot number: "+slot;
    }

    public String leave(int slotNo){
        if(slotNo < 1 || slotNo > size){
            return "Invalid slot No";
        }
        Car car = list.get(slotNo);
        if(car == null){
            return "Given slot no is empty";
        }
        list.add(slotNo, null);
        parkingSlot.add(slotNo);

        colorCarMapping.get(car.getColor()).remove(car);
        cars.remove(car.getRegNo());

        return "Slot number "+slotNo+" is free";
    }

    public String status(){
        return cars.values().toString();
    }

    public String regNoWithColor(String color){
        color = color.toLowerCase();
        StringBuffer sb = new StringBuffer("");
        if(colorCarMapping.containsKey(color)){
            int i =0;
            for(Car car: colorCarMapping.get(color)){
                if(i == 0){
                    sb.append(car.getRegNo());
                }else {
                    sb.append(", "+car.getRegNo());
                }
            }
        }
        return sb.toString();
    }

    public String slotWithColor(String color){
        color = color.toLowerCase();
        StringBuffer sb = new StringBuffer("");
        if(colorCarMapping.containsKey(color)){
            int i =0;
            for(Car car: colorCarMapping.get(color)){
                if(i == 0){
                    sb.append(car.getSlotNo());
                }else {
                    sb.append(", "+car.getSlotNo());
                }
            }
        }
        return sb.toString();
    }

    public String slotNoForRegNo(String regNo) {
        if(!cars.containsKey(regNo)){
            return "Not found";
        }
        return Integer.toString(cars.get(regNo).getSlotNo());
    }


    public void exit(){
        cars = null;
        colorCarMapping = null;
        list = null;
        parkingSlot = null;
        size =0;
    }

}
