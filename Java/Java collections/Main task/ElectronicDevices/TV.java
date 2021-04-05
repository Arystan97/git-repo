package ElectronicDevices;

public class TV extends ElectronicDevice
{
    public TV(int energyConsumption){
        super(energyConsumption);
    }
    public String toString(){
        return "Energy Consumption of TV: " + energyConsumption + " Watts";
    }
}
