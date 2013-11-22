import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents an enemy that moves downwards.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class SidewaysDownEnemy extends BasicEnemy
{
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the enemy to shoot, move, and be destroyed by Laser or RobotHero actors.
     */
    public void act() 
    {
        move(-1);
        moveDown();
        int x = Greenfoot.getRandomNumber(200);
        if(x < 3)
            fire();
        selfDestruct();
    }    
    
    /**
     * Constructor for objects of class SidewaysDownEnemy.
     */
    public SidewaysDownEnemy()
    {
    }
    
    /**
    * This method constantly moves the enemy downwards.
    */
    public void moveDown()
    {
        if(getY() != 579)
            this.setLocation(getX(),getY() + 1);
        else
            this.setLocation(getY(),0);
    }
}
