import Planes.*;
import models.MilitaryType;

import java.util.*;

public class Airport {
    private final List<? extends Plane> planes;
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    List<MilitaryPlane> militaryPlane = new ArrayList<>();

    public List<PassengerPlane> getPassengerPlane() {
        List<PassengerPlane> passengerPlane = new ArrayList<>();
        for (Plane p : this.planes) {
            if (p instanceof PassengerPlane) {
                passengerPlane.add((PassengerPlane) p);
            }
        }
        return passengerPlane;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        if (planes != null) {
            for (Plane plane : planes)
                if (plane instanceof MilitaryPlane) {
                    militaryPlane.add((MilitaryPlane) plane);
                }
        }
        return militaryPlane;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlane();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.TRANSPORT) {
                militaryPlane.add(plane);
            }
        }
    return militaryPlane;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == MilitaryType.BOMBER) {
                militaryPlane.add(plane);
            }
        }
        return militaryPlane;

    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanes.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::GetMaxFlightDistance));
        return this;
    }

    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMS));
        return this;
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMinLoadCapacity));
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        for (Plane plane : collection) {
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
