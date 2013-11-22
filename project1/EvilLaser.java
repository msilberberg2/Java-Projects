import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents a laser fired by an enemy.
 * 
 * @author Martin Silberberg
 * @version 4/25/2013
 */
public class EvilLaser extends Actor
{
    /**
     * Constructor for objects of class EvilLaser.
     */
    public EvilLaser()
    {    
    }
    
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the EvilLaser to move backward in a straight line and delete itself when it reaches the borders of the game world.
     */
    public void act() 
    {
        move(-6);
        delete();
    }    
        
    /**
     * This method deletes the EvilLaser when it reached the borders of the game world.
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
