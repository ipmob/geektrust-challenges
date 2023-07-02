package com.example.geektrust.calculations;

import com.example.geektrust.domain.Direction;
import com.example.geektrust.domain.Point;

public class Calculations {

    private Calculations() {
    }

    public static int calculateDistance(Point source, Point destination) {
        int xDist = Math.abs(source.x - destination.x);
        int yDist = Math.abs(source.y - destination.y);
        return xDist + yDist;
    }

    public static Direction[] calculateDirectionToGo(Point source, Point destination) {
        Direction xDir;
        Direction yDir;

        if (destination.x > source.x) {
            xDir = Direction.E;
        } else if (destination.x < source.x) {
            xDir = Direction.W;
        } else {
            xDir = Direction.NONE;
        }

        if (destination.y > source.y) {
            yDir = Direction.N;
        } else if (destination.y < source.y) {
            yDir = Direction.S;
        } else {
            yDir = Direction.NONE;
        }

        return new Direction[]{xDir, yDir};
    }

    public static int calculateDirectionChange(Direction currentDirection, Direction[] directionToGo) {
        if (currentDirection == null || directionToGo == null) {
            throw new NullPointerException("currentDirection and directionToGo cannot be null");
        }
        int one = 1;
        int two = 2;

        if (directionToGo[0] == Direction.NONE && directionToGo[1] == Direction.NONE) {
            return 0;
        } else if (directionToGo[0] == Direction.NONE) {
            if (currentDirection == Direction.E || currentDirection == Direction.W) {
                return one;
            } else if (currentDirection == directionToGo[1]) {
                return 0;
            } else {
                return two;
            }
        } else if (directionToGo[1] == Direction.NONE) {
            if (currentDirection == Direction.N || currentDirection == Direction.S) {
                return one;
            } else if (currentDirection == directionToGo[0]) {
                return 0;
            } else {
                return two;
            }
        } else {
            if (currentDirection == directionToGo[0] || currentDirection == directionToGo[1]) {
                return one;
            } else {
                return two;
            }
        }
    }
}
