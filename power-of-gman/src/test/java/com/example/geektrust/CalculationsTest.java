package com.example.geektrust;

import com.example.geektrust.calculations.Calculations;
import com.example.geektrust.domain.Direction;
import com.example.geektrust.domain.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculationsTest {

    @Test
    public void testCalculateDistance() {
        Point source = new Point(0, 0);
        Point destination = new Point(3, 4);
        int expectedDistance = 7;
        int actualDistance = Calculations.calculateDistance(source, destination);
        Assertions.assertEquals(expectedDistance, actualDistance);
    }

    @Test
    void testCalculateDirectionToGo() {
        Point source = new Point(1, 1);
        Point destination = new Point(1, 2);
        Direction[] expectedDirection = new Direction[]{Direction.NONE, Direction.N};
        Direction[] actualDirection = Calculations.calculateDirectionToGo(source, destination);
        Assertions.assertArrayEquals(expectedDirection, actualDirection);
    }

    @Test
    void testCalculateDirectionChange() {
        Direction currentDirection = Direction.E;
        Direction[] directionToGo = new Direction[]{Direction.NONE, Direction.S};
        int expectedChange = 1;
        int actualChange = Calculations.calculateDirectionChange(currentDirection, directionToGo);
        Assertions.assertEquals(expectedChange, actualChange);
    }

    // Negative test cases
    @Test
    void testCalculateDistanceWithNullPoints() {
        Point source = null;
        Point destination = null;
        Assertions.assertThrows(NullPointerException.class, () -> Calculations.calculateDistance(source, destination));
    }

    @Test
    void testCalculateDirectionToGoWithNullPoints() {
        Point source = null;
        Point destination = null;
        Assertions.assertThrows(NullPointerException.class, () -> Calculations.calculateDirectionToGo(source, destination));
    }

    @Test
    void testCalculateDirectionChangeWithNullCurrentDirection() {
        Direction currentDirection = null;
        Direction[] directionToGo = new Direction[]{Direction.NONE, Direction.S};
        Assertions.assertThrows(NullPointerException.class, () -> Calculations.calculateDirectionChange(currentDirection, directionToGo));
    }

}
