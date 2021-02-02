package com.iz0819.www.oops;

enum Direction {
    EAST("E"),
    WEST("W"),
    NORTH("N"),
    SOUTH("S");

    private String direction;

    Direction(String d) {
        this.direction=d;
    }

    String getDirection() { return direction;}
}

public class EnumDirections {
    enum Apple { A, B, C, D, E }

    public static void main(String args[]) {
        Apple x1 = Apple.A;
        System.out.println("Apple.x1=" + x1);

        for( Apple x : Apple.values()) {
            System.out.println(x);
        }

        for(Direction a : Direction.values()) {
            System.out.println(a.getDirection());
        }
    }
}
