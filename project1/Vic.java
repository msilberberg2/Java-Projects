import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a text box during the victory screen.
 * 
 * @author Martin Silberberg
 * @version 2.0
 */
public class Vic extends Actor
{
    /**
     * Creates a text box during the victory screen.
     */
    public void act() 
    {
        GreenfootImage vic = new GreenfootImage(600,70);
        vic.setTransparency(200);
        vic.setColor(java.awt.Color.white);
        vic.fillRect(0, 0, 600, 70);
        vic.setColor(java.awt.Color.red);
        vic.drawString("Having achieved the rank of HK-99, your robot's armor is powerful enough",40,40);
        vic.drawString("to shrug off every type of ordnance the Robot Empire has. Now capable of",40,53);
        vic.drawString("completely annihilating his enemies, HK-99 flies off in search of new adventures.",40,66);
        this.setImage(vic);
    }    
}
