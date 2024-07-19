package org.example.demo.serialization;

import org.example.demo.Car;

import java.io.*;

public class serialization {
    public static void main(String[] args) {
        // serialization
        Car car = new Car("Toyota", "black", 2020);
        String fileName = "file.ser";
        try {

            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(car);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException e) {
            e.printStackTrace();
        }
        Car Car2 = null;

        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(file);

            Car2 = (Car) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
