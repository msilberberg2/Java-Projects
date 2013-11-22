import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents a laser fired by the player or his allies.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class Laser extends Actor
{
    /**
     * Constructor for objects of class Laser.
     */
    public Laser()
    {    
    }
    
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the Laser to move forward in a straight line and delete itself when it reaches the borders of the game world.
     */
    public void act() 
    {
        move(10);
        delete();
    }    
    
    /**
     * This method deletes the Laser when it reached the borders of the game world.
     */    
    public void delete()
    {
        World world = getWorld();
        if(getX() == 579 || getX() == 0 || getY() == 0 || getY() == 579)
        {
            world.removeObject(this); 
        }
    } 
}
