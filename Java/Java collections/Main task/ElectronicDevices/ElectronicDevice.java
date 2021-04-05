package ElectronicDevices;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ElectronicDevice implements Comparable<ElectronicDevice>
{
    protected int energyConsumption;
    public boolean isTurnOn;

    public ElectronicDevice(int energyConsumption){
        this.energyConsumption = energyConsumption;
    }

    public void TurnOn(){
        isTurnOn = true;
    }

    public void TurnOff(){
        isTurnOn = false;
        energyConsumption = 0;
    }

    public void AskToTurnOn(String answer){
        switch(answer){
            case "yes" -> TurnOn();
            case "no" -> TurnOff();
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
            System.out.println("No device found");
        }else{
            TurnOnDevices.forEach(System.out::println);
        }
    }

    @Override
    public int compareTo(ElectronicDevice o){
        return (this.energyConsumption - o.energyConsumption);
    }
}