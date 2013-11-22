import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents a friendly turret with limited health and a faster fire rate.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class FriendlyAI extends FriendlyVI
{
    /**
     * Represents the remaining health of the turret.
     */
    protected int armor = 150;
    /**
     * Constructor for objects of class FriendlyAI.
     */
    public FriendlyAI()
    {    
    }
    
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the turret to shoot and be damaged by EvilLaser actors.
     */
    public void act() 
    {
        int x = Greenfoot.getRandomNumber(10);
        if(x < 1)
            fire();
        damage();
    }   
    
    /**
     * This method recognizes damage an EvilLaser actor, deletes the EvilLaser, and deletes itself if armor == 0.
     */
    public void damage()
    {
        Actor laser = getOneObjectAtOffset(0, 0, EvilLaser.class);
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
                explosion.play();
            }
            world.removeObject(laser);
        }
    }
}
