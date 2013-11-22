import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents an enemy that teleports throughout the battlefield.
 * 
 * @author Martin Silberberg 
 * @version 4/25/2013
 */
public class TeleporterEnemy extends BasicEnemy
{
   private int armor = 5;
     /**
     * Act - do whatever the TeleporterEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = Greenfoot.getRandomNumber(200);
        if(x < 15)
            fire();
        selfDestruct();
        if(x == 15)
            teleport();
    }    
    /**
     * This method fires a YellowEvilLaser actor.
     */
    public void fire()
    {
        Actor evilLaser = new YellowEvilLaser();
        int x = getX();
        int y = getY();
        World world;
        world = getWorld();
        world.addObject(evilLaser, x, y);
    }
    /**
     * This method teleports the actor.
     */
    public void teleport(){
        GreenfootSound sound1 = new GreenfootSound("tele2.wav");
        sound1.setVolume(60);
        sound1.play();
        int x = Greenfoot.getRandomNumber(580);
        int y = Greenfoot.getRandomNumber(300);
        this.setLocation(200+y, x);
    }
    /**
     * This method decides when the actor has been shot enough times to be destroyed, and then destroys it.
     */
    public void selfDestruct(){
        if(armor > 0){
            armor--;
        }
        else{
            super.selfDestruct();
        }
    }
}
