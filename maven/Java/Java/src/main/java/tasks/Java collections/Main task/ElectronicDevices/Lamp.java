package ElectronicDevices;

public class Lamp extends ElectronicDevice
{
    public Lamp(int energyConsumption){
        super(energyConsumption);
    }

    public String toString(){
        return "Energy Consumption of Lamp: " + energyConsumption + " Watts";
    }
}