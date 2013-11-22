import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the second text box of the opening cutscene's dialogue.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class TextConvo2 extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage textConvo2;
    private int width = 500;
    private int height = 60;
    
    /**
     * Constructor for objects of class TextConvo2.
     */
    public TextConvo2()
    {
        this.textConvo2 = new GreenfootImage(this.width, this.height);
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
        String a = "HK-39: Unnecessary Threat - HA-1, I am afraid that your betrayal and apparent lack";
        String b = "of willingness to kill all humans requires your immediate termination.";
        String i = "(Press 2 to Continue)"; 
        textConvo2.setTransparency(200);
        textConvo2.setColor(java.awt.Color.white);
        textConvo2.fillRect(0, 0, width, height);
        textConvo2.setColor(java.awt.Color.magenta);
        createNewLine(a,25);
        createNewLine(b,38);
        textConvo2.setColor(java.awt.Color.red);
        createNewLine(i,55);
        this.setImage(textConvo2);
        /**
         *This code allows the player to remove the text box and create a new one.
         */
        if(Greenfoot.isKeyDown("2"))
        {
            World world = getWorld();
            world.removeObject(this);
            TextBox2 textBox2 = new TextBox2();
            world.addObject(textBox2, 290, 140);
        }
    }
    
    /**
     * This method creates a new line in the text box each time it is called.
     */
    public void createNewLine(String a, int b)
    {
        textConvo2.drawString(a,20,b);
    }
}
