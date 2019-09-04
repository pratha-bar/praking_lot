package com.gojek.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on 02/09/2019, 7:11 PM
 * Car.java
 *
 * @author prathabarsaiyan
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    String regNo;
    String color;
    int slotNo;

    public Car(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }

        Car car = (Car) o;

        return this.getRegNo() != null ? this.getRegNo().equals(car.getRegNo()) : car.getRegNo() == null;
    }

    @Override
    public int hashCode() {
        return this.getRegNo() != null ? this.getRegNo().hashCode() : 0;
    }


    @Override
    public String toString() {
        return slotNo + "\t" + regNo +"\t" + color + '\n' ;
    }
}
