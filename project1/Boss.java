import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents an enemy Boss.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class Boss extends Actor
{
    /**
     * Represents the remaining health of the boss.
     */
    protected int armor = 20;
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the boss to shoot and be damaged by the player.
     */
    public void act() 
    {
        setRotation(270);
        int x = Greenfoot.getRandomNumber(5);
        if(x < 3)
            fireEverything();
        damage();
    }    
    
    /**
     * Constructor for objects of class Boss.
     */
    public Boss()
    {
    }
    
    /**
     * This method fires an EvilLaser actor in a random direction.
     */
    public void fireEverything()
    {
        Actor laser = new EvilLaser();
        int x = getX();
        int y = getY();
        World world;
        world = getWorld();
        world.addObject(laser, x, y);
        laser.setRotation(Greenfoot.getRandomNumber(180) + 270);
    }
    
    /**
    * This method changes the health of the boss when the Boss collides with a Laser.
    * It also deletes the boss when health is 0 and deletes the Laser.
    */
    public void damage()
    {
        Actor laser = getOneObjectAtOffset(0, 0, Laser.class);
        World world = getWorld();
        if(laser != null)
        {
            armor--;
            if(armor == 0)
            {
                OpeningText w = (OpeningText) this.getWorld();
                w.rank.createRank();
                world.removeObject(this);
                GreenfootSound explosion = new GreenfootSound("explosion.wav");
                explosion.setVolume(70);
                explosion.play();
            }
            world.removeObject(laser);
        }
    }
}
