import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents a basic enemy.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class BasicEnemy extends Actor
{
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the enemy to shoot, move, and be destroyed by Laser or RobotHero actors.
     */
    public void act() 
    {
        move(-2);
        int x = Greenfoot.getRandomNumber(200);
        if(x < 3)
            fire();
        selfDestruct();
    }    
    
    /**
     * Constructor for objects of class BasicEnemy.
     */
    public BasicEnemy()
    {
    }
    
    /**
     * This method fires an EvilLaser actor.
     */
    public void fire()
    {
        Actor evilLaser = new EvilLaser();
        int x = getX();
        int y = getY();
        World world;
        world = getWorld();
        world.addObject(evilLaser, x, y);
    }
    
    /**
    * This method deletes the enemy when it collides with a Laser or RobotHero.
    */
    public void selfDestruct()
    {
        Actor hero = getOneObjectAtOffset(0, 0, RobotHero.class);
        Actor laser = getOneObjectAtOffset(0, 0, Laser.class);
        if(hero != null || laser != null || getX() == 0)
        {
            World world = getWorld();
            OpeningText w = (OpeningText) this.getWorld();
            w.rank.createRank();
            world.removeObject(this);
            GreenfootSound explosion = new GreenfootSound("explosion.wav");
            explosion.setVolume(75);
            explosion.play();
            world.removeObject(laser);
        }
    }
   
    
}
