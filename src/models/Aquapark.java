package models;

/**
 *
 * @author jakubvavra
 */
public class Aquapark {
    private int id;
    private String name;
    private double workHours;
    
    public Aquapark(int id, String name, double workHours) {
        this.id = id;
        this.name= name;
        this.workHours = workHours;
    }
    
    public int getID() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getWorkHours() {
        return workHours;
    }
    
    @Override
    public String toString() {
        return name + ", " + workHours;
    }
}
