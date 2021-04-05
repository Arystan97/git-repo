package ElectronicDevices;

public class Microwave extends ElectronicDevice
{
    public Microwave(int energyConsumption){
        super(energyConsumption);
    }

    public String toString(){
        return "Energy Consumption of Microwave: " + energyConsumption + " Watts";
    }
}
