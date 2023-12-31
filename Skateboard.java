
/**
 * Skateboard base class for APCSA
 *
 * @author Roger Jaffe
 * @version 1.0.0
 */
public class Skateboard extends Vehicle
{
    private double xPos;
    private double yPos;
    private double speed;       // feet per second
    private String name;
    private int scratches;
    private boolean needsPolish;
    /**
     * Constructor form objects of class Skateboard
     */
    public Skateboard(String name, double speed) {
        super(name, speed);
        this.xPos = 0.0;
        this.yPos = 0.0;
        this.speed = speed;
        this.name = name;

    }
    public void addScratch(){
        scratches++; 
        if(scratches > 10){
            needsPolish = true;
        }
    }
    public void polishUp(){
        scratches = 0;
        needsPolish = false;
    }
    /**
     * Getter functions for the instance variables
     */
    public double getXPos() {
        return xPos;
    }
    
    public double getYPos() {
        return yPos;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public String getName() {
        return name;
    }
    
    /**
     * Setter function for speed which may change after the 
     * class has been instantiated
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    /**
     * Adjust the xPos and yPos bassed on speed and passed-in
     * time in secs and direction in degrees
     */
    public void travel(double time, int direction) {
        double deltaY = (speed * time) * Math.cos(direction * Math.PI / 360);
        double deltaX = (speed * time) * Math.sin(direction * Math.PI / 360);
        xPos = xPos + deltaX;
        yPos = yPos + deltaY;
        addScratch();
    }
    
    public double distanceFromHome() {
        return Math.sqrt(xPos * xPos + yPos * yPos);
    }
}

