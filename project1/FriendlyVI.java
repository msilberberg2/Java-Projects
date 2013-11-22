import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents a friendly turret.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class FriendlyVI extends Actor
{
    /**
     * Constructor for objects of class FriendlyVI.
     */
    public FriendlyVI()
    {    
    }  
    
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the turret to shoot.
     */
    public void act() 
    {
        int x = Greenfoot.getRandomNumber(30);
        if(x < 1)
            fire();
    }  
    
    /**
     * This method fires a Laser actor in a random direction.
     */
    public void fire()
    {
        Actor laser = new Laser();
        int x = getX();
        int y = getY();
        World world;
        world = getWorld();
        world.addObject(laser, x, y);
        laser.setRotation(Greenfoot.getRandomNumber(60) + 330);
        GreenfootSound fire = new GreenfootSound("tele1.wav");
        if(fire.isPlaying())
            fire.stop();
        fire.play();
    }
}
