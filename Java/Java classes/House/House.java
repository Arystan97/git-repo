package House;

import java.util.*;
import java.util.stream.*;

public class House{
    private int id;
    private int FlatNumber;
    private int Square;
    private int FloorNumber;
    private int RoomQuantity;
    private String Street;
    private String BuildingType;
    private int Lifespan;

    List<House> list = new ArrayList<>();

    public House(){

    }

    public void setSquare(int Square){
        this.Square = Square;
    }

    public int getSquare(){
        return this.Square;
    }

    public void setFloorNumber(int FloorNumber){
        this.FloorNumber = FloorNumber;
    }

    public int getFloorNumber(){
        return this.FloorNumber;
    }

    public void setRoomQuantity(int RoomQuantity){
        this.RoomQuantity = RoomQuantity;
    }

    public int getRoomQuantity(){
        return this.RoomQuantity;
    }

    public String toString(){
        return "Square: " + Square + '\n' + "Floor: " + FloorNumber + '\n' + "RoomQuantity: " + RoomQuantity + '\n';
    }

    public void CreateArray(int roomQuantity, int floorNumber, int square){
        House house = new House();
        house.setRoomQuantity(roomQuantity);
        house.setFloorNumber(floorNumber);
        house.setSquare(square);
        list.add(house);
        System.out.println(list);
    }

    public void Search(int roomQuantity, int FloorRangeUpperBound, int FloorRangeLowerBound, int square){
        List<House> roomQuantityList = list.stream().filter(l -> l.getRoomQuantity() == roomQuantity).collect(Collectors.toList());
        List<House> roomQuantityAndFloorNumberList = list.stream().filter(l -> l.getFloorNumber() < FloorRangeUpperBound && l.getFloorNumber() > FloorRangeLowerBound && l.getRoomQuantity() == roomQuantity).collect(Collectors.toList());
        List<House> SquareList = list.stream().filter(l -> l.getSquare() > square).collect(Collectors.toList());
        if(list.isEmpty()){
            System.out.println("no data");
        }
        else if(FloorRangeUpperBound == 0 && FloorRangeLowerBound == 0 && square == 0 && roomQuantity > 0){
            System.out.println(roomQuantityList);
        }
        else if(roomQuantity == 0 && FloorRangeUpperBound == 0 && FloorRangeLowerBound == 0 && square > 0){
            System.out.println(SquareList);
        }
        else if(square == 0 && FloorRangeUpperBound > 0 || FloorRangeLowerBound > 0 && roomQuantity > 0){
            System.out.println(roomQuantityAndFloorNumberList);
        }
        else{
            System.out.println("no parameters entered");
        }
    }
}