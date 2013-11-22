import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the text box for the first upgrade choice.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class UpgradeChoice1 extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage upgrade1;
    private int width = 500;
    private int height = 70;
    
    /**
     * Constructor for objects of class UpgradeChoice1.
     */
    public UpgradeChoice1()
    {
        this.upgrade1 = new GreenfootImage(this.width, this.height);
    }
    
    /**
     * This method is called whenever the game environment acts or runs.
     * It creates the text box.
     */
    public void act() 
    {
        createTextBox();
    }    
    
    /**
     * This method is called whenever the game environment acts or runs.
     * This text box appears to present upgrade options to the player.
     */
    public void createTextBox()
    {
        World world = getWorld();
        String a = "__Please select an upgrade__";
        String b = "Friendly VI: Press 1 to generate an Ally Turret";
        String c = "EMP: Press 2 to destroy a large number of enemies with an electromagnetic pulse.";
        upgrade1.setTransparency(255);
        upgrade1.setColor(java.awt.Color.white);
        upgrade1.fillRect(0, 0, width, height);
        upgrade1.setColor(java.awt.Color.red);
        createNewLine(a,25);
        createNewLine(b,38);
        createNewLine(c,51);
        this.setImage(upgrade1);
        remove(world);
    }
    
    /**
     * This code allows the player to remove the text box and apply upgrades.
     */
    public void remove(World world)
    {
        //Creates an object of class FriendlyVI.
        if(Greenfoot.isKeyDown("1"))
        {
            FriendlyVI vi = new FriendlyVI();
            world.addObject(vi, 40, 400);
            world.removeObject(this);
        }
        //Creates a large number of Laser objects that wipe out all enemies on the screen.
        if(Greenfoot.isKeyDown("2"))
        {
            for(int i = 0; i < 580; i++)
            {
                Laser laser = new Laser();
                world.addObject(laser, 0, i);
            }
            world.removeObject(this);
        }
    }
    /**
     *This method creates a new line in the text each time it is called.
     */
    public void createNewLine(String a, int b)
    {
        upgrade1.drawString(a, 40, b);
    }
}
