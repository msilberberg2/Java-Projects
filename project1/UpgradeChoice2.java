import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the text box for the second upgrade choice.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class UpgradeChoice2 extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage upgrade2;
    private int width = 500;
    private int height = 90;
    
    /**
     * Constructor for objects of class UpgradeChoice2.
     */
    public UpgradeChoice2()
    {
        this.upgrade2 = new GreenfootImage(this.width, this.height);
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
        String b = "Friendly AI: Press 1 to generate a temporary Rapid Fire Ally Turret.";
        String c = "Self Destruct Code: Press 2 to destroy most enemies on the screen.";
        String d = "Completely Unsuspicious Free Upgrade: Press 3 to win.";
        upgrade2.setTransparency(255);
        upgrade2.setColor(java.awt.Color.white);
        upgrade2.fillRect(0, 0, width, height);
        upgrade2.setColor(java.awt.Color.red);
        createNewLine(a,25);
        createNewLine(b,38);
        createNewLine(c,51);
        createNewLine(d,64);
        this.setImage(upgrade2);
        remove(world);
    }
    
    /**
     * This code allows the player to remove the text box and apply upgrades.
     */
    public void remove(World world)
    {
        //Creates an object of class FriendlyAI.
        if(Greenfoot.isKeyDown("1"))
        {
            FriendlyAI ai = new FriendlyAI();
            world.addObject(ai, 40, 200);       
            world.removeObject(this);
        }
        //Wipes out all enemies onscreen.
        if(Greenfoot.isKeyDown("2"))
        {
            world.removeObjects(world.getObjects(BasicEnemy.class));
            world.removeObjects(world.getObjects(Boss.class));
            GreenfootSound explosion = new GreenfootSound("explosion.wav");
            explosion.setVolume(75);
            explosion.play();
            world.removeObject(this);
        }
        //Creates a large number of EvilLaser objects that damage the player and all allies.
        if(Greenfoot.isKeyDown("3"))
        {
            for(int j = 0; j < 20; j++)
            {
                for(int i = 0; i < 580; i++)
                {
                    EvilLaser laser = new EvilLaser();
                    world.addObject(laser, 580, i);
                }
            }
            world.removeObject(this);
        }
    }
    
    /**
     *This method creates a new line in the text each time it is called.
     */
    public void createNewLine(String a, int b)
    {
        upgrade2.drawString(a, 40, b);
    }
}
