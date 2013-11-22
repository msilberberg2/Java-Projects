import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents an enemy that moves upwards.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class SidewaysUpEnemy extends BasicEnemy
{
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the enemy to shoot, move, and be destroyed by Laser or RobotHero actors.
     */
    public void act() 
    {
        move(-1);
        moveUp();
        int x = Greenfoot.getRandomNumber(200);
        if(x < 3)
            fire();
        selfDestruct();
    }  
    
    /**
     * Constructor for objects of class SidewaysUpEnemy.
     */
    public SidewaysUpEnemy()
    {
    }
    
    /**
    * This method constantly moves the enemy upwards.
    */
    public void moveUp()
    {
        if(getY() != 0)
            this.setLocation(getX(),getY() - 1);
        else
            this.setLocation(getX(),580);
    }
}
