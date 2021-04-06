import House.*;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        House house1 = new House();
        House house2 = new House();
        House house3 = new House();
        house1.CreateArray(5, 3, 27);
        house2.CreateArray(4, 7, 19);
        house3.CreateArray(2, 5, 35);
        System.out.println("Result:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter room quantity to search (if none enter 0)");
        int roomQuantity = sc.nextInt();
        System.out.println("Enter floor range lower bound to search (if none enter 0)");
        int FloorRangeLowerBound = sc.nextInt();
        System.out.println("Enter floor range upper bound to search (if none enter 0)");
        int FloorRangeUpperBound = sc.nextInt();
        System.out.println("Enter square value to search (if none enter 0)");
        int square = sc.nextInt();
        house1.Search(roomQuantity, FloorRangeUpperBound, FloorRangeLowerBound, square);
        house2.Search(roomQuantity, FloorRangeUpperBound, FloorRangeLowerBound, square);
        house3.Search(roomQuantity, FloorRangeUpperBound, FloorRangeLowerBound, square);
    }
}