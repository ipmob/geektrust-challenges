package com.example.geektrust;

import com.example.geektrust.calculations.Calculations;
import com.example.geektrust.domain.Direction;
import com.example.geektrust.domain.Point;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Main {

    public static void main(String[] args) {
        Point source = new Point(0, 0);
        Point destination = new Point(0, 0);
        Direction currentDirection = Direction.NONE;

        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line = br.readLine();
            String[] words = line.split(" ");
            source.x = Integer.parseInt(words[1]);
            source.y = Integer.parseInt(words[2]);
            currentDirection = Direction.valueOf(words[3]);

            line = br.readLine();
            words = line.split(" ");
            destination.x = Integer.parseInt(words[1]);
            destination.y = Integer.parseInt(words[2]);

            Direction[] directionToGo = Calculations.calculateDirectionToGo(source, destination);
            int directionScore = Calculations.calculateDirectionChange(currentDirection, directionToGo) * 5;
            int distanceScore = Calculations.calculateDistance(source, destination) * 10;

            System.out.println("POWER " + (200 - distanceScore - directionScore));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
