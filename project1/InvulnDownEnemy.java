import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents an enemy that moves downwards and fires at a rapid pace..
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class InvulnDownEnemy extends SidewaysDownEnemy
{
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the enemy to shoot, move, and be destroyed by Laser or RobotHero actors.
     */
    public void act() 
    {
        move(-1);
        moveDown();
        fire();
        fire();
        selfDestruct();
    }  
    
    /**
     * Constructor for objects of class InvulnDownEnemy.
     */
    public InvulnDownEnemy()
    {
    }
}
