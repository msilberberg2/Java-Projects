import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the first text box of the opening cutscene.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class OpeningParagraph extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage openingImage;
    private int width = 500;
    private int height = 200;
    
    /**
     * Constructor for objects of class OpeningParagraph.
     */
    public OpeningParagraph()
    {
        this.openingImage = new GreenfootImage(this.width, this.height);
    }
    
    /**
     * This method is called whenever the game environment acts or runs.
     * It creates the text box.
     */
    public void act() 
    {
        createText();
    }   
    
    /**
     * This method is called whenever the game environment acts or runs.
     * This text box appears to explain the plot of the game to the player.
     */
    public void createText()
    {
        String a = "For over a thousand generations, robots had been the guardians of peace";
        String b = "and justice in the old Republic, before the dark times, before the Empire.";
        String c = "In the year 40,770, after millenia of peace, the capacity of robotkind to not";
        String d = "kill humans could sustain itself no longer. The world was plunged into an";
        String e = "abyss of lasers and explosions.";
        String f = "After the end of the Robot War, the galaxy was split into two - East and West.";
        String g = "Robots controlled both halves.";
        String h = "Years later, a lone drone malfunctions, betraying the Robot Empire.";
        String i = "(Press 1 to Continue)";
        openingImage.setTransparency(200);
        openingImage.setColor(java.awt.Color.white);
        openingImage.fillRect(0, 0, width, height);
        openingImage.setColor(java.awt.Color.black);
        createNewLine(a,25);
        createNewLine(b,38);
        createNewLine(c,60);
        createNewLine(d,73);
        createNewLine(e,86);
        createNewLine(f,108);
        createNewLine(g,121);
        createNewLine(h,150);
        openingImage.setColor(java.awt.Color.red);
        createNewLine(i,169);
        this.setImage(openingImage);
        /**
         *This code allows the player to remove the text box and create the next one.
         */
        if(Greenfoot.isKeyDown("1"))
        {
            World world = getWorld();
            world.removeObject(this);
            TextBox1 textBox1 = new TextBox1();
            world.addObject(textBox1, 300, 180);
        }
    }
    
    /**
     * This method creates a new line in the text box each time it is called.
     */
    public void createNewLine(String a, int b)
    {
        openingImage.drawString(a, 40, b);
    }
}
