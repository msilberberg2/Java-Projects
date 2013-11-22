import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the third text box of the opening cutscene.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class TextBox2 extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage textBox2;
    private int width = 540;
    private int height = 200;
    /**
     * Represents whether the game is currently in hard mode.
     * true indicates that it is.
     */
    protected boolean hard = false;
    protected boolean medium = false;
    /**
     * Constructor for objects of class TextBox2.
     */
    public TextBox2()
    {
        this.textBox2 = new GreenfootImage(this.width, this.height);
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
        String a = "HA-1's voyage through time landed him in the year 41,000, during the final robot invasion";
        String b = "of Earth. Shoot the advancing robots that appear on the right side of the screen by pressing";
        String c = "space. Use the up and down arrow keys to move up and down.";
        String d = "Being from  the future, HA-1 has an advanced armored exoskeleton capable of withstanding";
        String e = "many direct hits from another robot's weapons. The status of his exoskeleton";
        String f = "is displayed in the upper-right corner.";
        String g = "As HA-1 destroys enemies, he increases his rank as a robot soldier. This rank is represented";
        String h = "by his name in the upper left corner of the screen. At some points, HA-1's rank will get high";
        String j = "enough to allow an upgrade. Upgrade options appear at the top of the screen.";
        String l = "(Press M while this text box is open to activate Medium Mode)";
        String k = "(Press H while this text box is open to activate Hard Mode)";
        String m = "(Otherwise, the game will proceed in Easy Mode)";
        String i = "(Press Enter to Start The Battle)"; 
        textBox2.setTransparency(200);
        textBox2.setColor(java.awt.Color.white);
        textBox2.fillRect(0, 0, width, height);
        textBox2.setColor(java.awt.Color.black);
        createNewLine(a,25);
        createNewLine(b,38);
        createNewLine(c,51);
        textBox2.setColor(java.awt.Color.black);
        createNewLine(d,64);
        createNewLine(e,77);
        createNewLine(f,90);
        createNewLine(g,103);
        createNewLine(h,116);
        createNewLine(j,129);
        textBox2.setColor(java.awt.Color.red);
        createNewLine(l,142);
        createNewLine(k,155);
        createNewLine(m,168);
        createNewLine(i,181);
        this.setImage(textBox2);
        //This code allows the player to enable hard mode.
        if(Greenfoot.isKeyDown("h"))
        {
            hard = true;
            GreenfootSound explosion = new GreenfootSound("explosion.wav");
            explosion.setVolume(70);
            explosion.play();
        }
        if(Greenfoot.isKeyDown("m"))
        {
            medium = true;
            GreenfootSound explosion = new GreenfootSound("explosion.wav");
            explosion.setVolume(70);
            explosion.play();
        }
        /**
         *This code allows the player to remove the text box and begin the game.
         */
        if(Greenfoot.isKeyDown("enter"))
        {
            World world = getWorld();
            world.removeObjects(world.getObjects(HeroNPC.class));
            world.removeObjects(world.getObjects(HK47NPC.class));
            world.removeObjects(world.getObjects(TextBox2.class));
            RobotHero hero = new RobotHero();
            world.addObject(hero, 40, 302);
            BasicEnemy enemy = new BasicEnemy();
            world.addObject(enemy, 343, 309);
            BasicEnemy enemy2 = new BasicEnemy();
            world.addObject(enemy2, 417, 230);
            BasicEnemy enemy3 = new BasicEnemy();
            world.addObject(enemy3, 424, 402);
            if(hard)
            {
                HardModeAIDirector ai = new HardModeAIDirector();
                world.addObject(ai, 0, 0);
            }
            else if(medium)
            {
                MediumAIDirector ai = new MediumAIDirector();
                world.addObject(ai, 0, 0);
            }
            else
            {
                AIDirector ai = new AIDirector();
                world.addObject(ai, 0, 0);
            }
        }
    }
    
    /**
     * This method creates a new line in the text box each time it is called.
     * Each line has the same x-coordinate. 
     * The y-coordinate and the string are decided by the code calling the method.
     */
    public void createNewLine(String a, int b)
    {
        textBox2.drawString(a,10,b);
    }   
}
