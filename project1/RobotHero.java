import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the player's avatar.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class RobotHero extends Actor
{
    /**
     * Constructor for objects of class RobotHero.
     */
    public RobotHero()
    {    
    }  
    /**
     * Represents the initial health value of the player.
     */
    protected int hp = 750;
    /**
     * Represents the bullet count variable for the player, which is used to regulate the fire rate
     * of the avatar's weapon.
     */
    protected int bulletCount = 10;
    /**
     * This method is called whenever the game environment acts or runs.
     * Allows the avatar to move, shoot, and be damaged by enemies.
     */
    public void act() 
    {
        moveHero();
        fire();
        collisionDamage();
        laserDamage();
    }    
    
    /**
     * This method sets the hero's direction and moves the hero.
     * It allows the avatar to move upwards or downwards.
     * It also allows the avatar to reach the bottom of the screen from the top or vice versa.
     */    
    public void moveHero()
    {
        setRotation(270);
        if(Greenfoot.isKeyDown("up"))
        {
            if(getY() != 0)
                move(4);
            else
                this.setLocation(getX(),580);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            if(getY() != 579)
                move(-4);
            else
                this.setLocation(getX(),0);
        }
    }
    
    /**
     * This method allows the avatar to fire its weapon.
     * It creates an actor of class Laser one out of every eleven times the method is called.
     */
    public void fire()
    {
        if (Greenfoot.isKeyDown("space"))
        {
            if(bulletCount == 10)
            {
                /**
                 * Constructs one actor of class Laser.
                 */
                Actor laser = new Laser();
                int x = getX();
                int y = getY();
                /**
                 * Adds laser to the environment and plays a sound for the firing of the avatar's gun.
                 */
                World world = getWorld();
                world.addObject(laser, x, y);
                GreenfootSound fire = new GreenfootSound("tele1.wav");
                fire.setVolume(75);
                if(fire.isPlaying())
                    fire.stop();
                fire.play();
                laser.setRotation(0);
            }
            bulletCount--;
            if(bulletCount <= 0)
            {
                bulletCount = 10;
            }
        }
    }
    
    /**
    * This method changes the health of the player when the avatar collides with an enemy.
    * The code for changing the value of the health box is taken from the lecture's 
    * super wombat code for modifying a health counter, changed for the purposes of my health counter.
    */
    public void collisionDamage()
    {
            Actor enemy = getOneObjectAtOffset(0, 0, BasicEnemy.class);
            if(enemy != null)
            {
                //Taken from the lecture's super wombat code for modifying a health counter.
                //Changed for the purposes of my health counter.
                OpeningText w = (OpeningText) this.getWorld();
                hp--;
                w.health.displayHealth(hp);
            }
    }
    
    /**
    * This method changes the health of the player when the avatar collides with an enemy laser.
    * The code for changing the value of the health box is taken from the lecture's 
    * super wombat code for modifying a health counter, changed for the purposes of my health counter.
    */    
    public void laserDamage()
    {
        Actor laser = getOneObjectAtOffset(0, 0, EvilLaser.class);
        if(laser != null)
        {
            OpeningText w = (OpeningText) this.getWorld();
            hp--;
            w.health.displayHealth(hp);
            w.removeObject(laser);
        }
    }
}
