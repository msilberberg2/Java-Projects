import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the first text box of the opening cutscene's dialogue.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class TextConvo1 extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage textConvo1;
    private int width = 500;
    private int height = 60;
    
    /**
     * Constructor for objects of class TextConvo1.
     */
    public TextConvo1()
    {
        this.textConvo1 = new GreenfootImage(this.width, this.height);
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
     * This text box appears to explain the plot of the game to the player.
     */
    public void createTextBox()
    {
        String a = "HK-46: Reprimandation - HA-1, your unauthorized temporal shift indicates an agenda";
        String b = "in direct opposition to the protocols of the robot empire.";
        String i = "(Press 1 to Continue)"; 
        textConvo1.setTransparency(200);
        textConvo1.setColor(java.awt.Color.white);
        textConvo1.fillRect(0, 0, width, height);
        textConvo1.setColor(java.awt.Color.magenta);
        createNewLine(a,25);
        createNewLine(b,38);
        textConvo1.setColor(java.awt.Color.red);
        createNewLine(i,55);
        this.setImage(textConvo1);
        //This code allows the player to remove the text box and create a new one.
        if(Greenfoot.isKeyDown("1"))
        {
            World world = getWorld();
            world.removeObject(this);
            TextConvo2 textConvo2 = new TextConvo2();
            world.addObject(textConvo2, 287, 177);
        }
    }
    
    /**
     * This method creates a new line in the text box each time it is called.
     */
    public void createNewLine(String a, int b)
    {
        textConvo1.drawString(a,20,b);
    }
}
