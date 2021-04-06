package ElectronicDevices;

import java.util.*;
import java.util.stream.Collectors;

public class ElectronicDevice implements Comparable<ElectronicDevice>
{
    private int energyConsumption;
    private boolean isTurnOn;

    public void setEnergyConsumption(int energyConsumption){
        this.energyConsumption = energyConsumption;
    }
    public int getEnergyConsumption(){
        return energyConsumption;
    }

    private void turnOn(){
        isTurnOn = true;
    }

    private void turnOff(){
        isTurnOn = false;
        energyConsumption = 0;
    }

    public void AskToTurnOn(String answer){
        switch(answer){
            case "yes" -> turnOn();
            case "no" -> turnOff();
        }
    }

    public static void Filter(ElectronicDevice device1, ElectronicDevice device2, ElectronicDevice device3) {
        Scanner sc = new Scanner(System.in);
        List<ElectronicDevice> TurnOnDevices = Arrays.asList(device1, device2, device3);
        List<ElectronicDevice> TurnOffDevices = Arrays.asList(device1, device2, device3);
        TurnOnDevices = TurnOnDevices.stream().filter(device -> device.isTurnOn).collect(Collectors.toList());
        TurnOffDevices = TurnOffDevices.stream().filter(device -> !device.isTurnOn).collect(Collectors.toList());
        List<ElectronicDevice> TurnOnDevicesSortedList = TurnOnDevices.stream().sorted().collect(Collectors.toList());
        List<ElectronicDevice> TurnOffDevicesSortedList = TurnOffDevices.stream().sorted().collect(Collectors.toList());
        System.out.println("Turned on devices:");
        TurnOnDevicesSortedList.forEach(System.out::println);
        System.out.println("Turned off devices:");
        TurnOffDevicesSortedList.forEach(System.out::println);
        System.out.println("Enter device energy consumption for search");
        int EnergyConsumptionValue = sc.nextInt();
        TurnOnDevices = TurnOnDevices.stream().filter(device -> device.energyConsumption == EnergyConsumptionValue).collect(Collectors.toList());
        if(TurnOnDevices.isEmpty()){
            System.out.println("No devices found");
        }else{
            TurnOnDevices.forEach(System.out::println);
        }
    }

    @Override
    public int compareTo(ElectronicDevice o){
        return (this.energyConsumption - o.energyConsumption);
    }

    public String toString(){
        return "Energy Consumption: " + energyConsumption + " Watts";
    }
}