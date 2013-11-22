import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the player's health bar.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class Health extends Actor
{
    /**
     * Width, height and health establish the health textbox and create the dimensions of the box.
     */
    private GreenfootImage health;
    private int width = 200;
    private int height = 15;
    /**
     * This method is called whenever the game environment acts or runs.
     * It does nothing.
     */
    public void act() 
    {
    }  
    
    /**
     * Constructor for objects of class Health.
     */    
    public Health()
    {
        this.health = new GreenfootImage(this.width, this.height);
        int hp = 750;
    }
    /**
     * This creates a text box that keeps track of the player's health.
     * Keeps track of the numerical value of the player's health.
     */
    public void displayHealth(int hp)
    { 
        health.setTransparency(255);
        health.setColor(java.awt.Color.gray);
        /**
         * The color of the text box changes when health is low.
         */
        if(hp <= 250)
            health.setColor(java.awt.Color.red);
        health.fillRect(0, 0, width, height);
        health.setColor(java.awt.Color.yellow);
        health.drawString("Exoskeleton Integrity: " + hp, 15, 12);
        this.setImage(health);
        if(hp <= 0)
        {
            GreenfootSound sound = new GreenfootSound("explosion2.wav");
            sound.setVolume(65);
            sound.play();
            Greenfoot.setWorld(new GameOverScreen());
        }
    }
}
