package models;

/**
 *
 * @author jakubvavra
 */
public class Job {
    private final String title;
    private final Double minSalary;
    private final Double maxSalary;
    
    public Job(String title, Double minSalary, Double maxSalary) {
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }
    
    @Override
    public String toString() {
        return title + ", od " + minSalary + " Kc do " + maxSalary + " Kc";
    }
}
