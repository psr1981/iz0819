package com.iz0819.www.basework;

public class SwitchStatement {
    public enum Test  { Low, Medium, High }

    public static void main (String[] args) {

        Test xval = Test.Medium;

        switch(xval) {
            case Low:
                System.out.println("It is Low");
                break;
            case Medium:
                System.out.println("It is Medium");
                break;
            case High:
                System.out.println("It is High");
                break;
            default:
                System.out.print("nothing matched");
        }
    }
}
