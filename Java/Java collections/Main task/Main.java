import java.util.*;
import java.util.stream.*;
class ElectronicDevice implements Comparable<ElectronicDevice>
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

class TV extends ElectronicDevice
{
    public TV(int energyConsumption){
        super(energyConsumption);
    }
    public String toString(){
        return "Energy Consumption of TV: " + energyConsumption + " Watts";
    }
}

class Microwave extends ElectronicDevice
{
    public Microwave(int energyConsumption){
        super(energyConsumption);
    }

    public String toString(){
        return "Energy Consumption of Microwave: " + energyConsumption + " Watts";
    }
}

class Lamp extends ElectronicDevice
{
    public Lamp(int energyConsumption){
        super(energyConsumption);
    }

    public String toString(){
        return "Energy Consumption of Lamp: " + energyConsumption + " Watts";
    }
}

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter TV energy consumption");
        int TvEnergyConsumptionValue = sc.nextInt();
        System.out.println("Enter Microwave energy consumption");
        int MicrowaveEnergyConsumptionValue = sc.nextInt();
        System.out.println("Enter Lamp energy consumption");
        int LampEnergyConsumptionValue = sc.nextInt();
        System.out.println("Turn on TV?");
        sc.nextLine();
        String answer1 = sc.nextLine();
        System.out.println("Turn on Microwave?");
        String answer2 = sc.nextLine();
        System.out.println("Turn on Lamp?");
        String answer3 = sc.nextLine();
        ElectronicDevice tv = new TV(TvEnergyConsumptionValue);
        ElectronicDevice microwave = new Microwave(MicrowaveEnergyConsumptionValue);
        ElectronicDevice lamp = new Lamp(LampEnergyConsumptionValue);
        tv.AskToTurnOn(answer1);
        microwave.AskToTurnOn(answer2);
        lamp.AskToTurnOn(answer3);
        ElectronicDevice.Filter(tv, microwave, lamp);
    }
}