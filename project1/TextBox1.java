import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * This actor represents the second text box of the opening cutscene.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class TextBox1 extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage textBox1;
    private int width = 500;
    private int height = 200;
    
    /**
     * Constructor for objects of class TextBox1.
     */
    public TextBox1()
    {
        this.textBox1 = new GreenfootImage(this.width, this.height);
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
        String a = "You play as HA-1, a drone in the Robot Empire. Unbeknownst to HA-11, a ";
        String b = "mythical hero in a parallel world has just used the powers of slammin'";
        String c = "and jammin' to perform the greatest b-ball dunk of all time, the Chaos Dunk.";
        String d = "The dunk has ripped a hole in the space-time continuum, scrambling";
        String e = "HA-1's memories and deleting all his files containing hatred of humans.";
        String f = "Filled with new purpose, HA-1 initiates an emergency temporal shift,";
        String g = "travelling back in time to ensure human victory in the war.";
        String i = "(Press 2 to Continue. NOTICE: Please turn speakers/headphones down now.)";
        textBox1.setTransparency(200);
        textBox1.setColor(java.awt.Color.white);
        textBox1.fillRect(0, 0, width, height);
        textBox1.setColor(java.awt.Color.black);
        createNewLine(a,25);
        createNewLine(b,38);
        createNewLine(c,51);
        createNewLine(d,74);
        createNewLine(e,87);
        createNewLine(f,100);
        createNewLine(g,113);
        textBox1.setColor(java.awt.Color.red);
        createNewLine(i,169);
        this.setImage(textBox1);
        remove();
    }
    
    /**
     *This code allows the player to remove the text box and play the opening cutscene.
     */
    public void remove()
    {
        if(Greenfoot.isKeyDown("2"))
        {
            //Changes the background, delays execution, and adds/removes objectes repeatedly.
            World world = getWorld();
            world.removeObject(this);
            GreenfootImage newBackground = new GreenfootImage("104095-yana.jpg");
            GreenfootImage tempBackground = new GreenfootImage("Untitled.png");
            GreenfootSound sound1 = new GreenfootSound("tele2.wav");
            sound1.setVolume(75);
            Greenfoot.delay(15);
            world.setBackground(tempBackground);
            sound1.play();
            Greenfoot.delay(60);
            world.setBackground(newBackground);
            Greenfoot.delay(30);
            sound1.stop();
            sound1.play();
            TeleportEffect teleporteffect = new TeleportEffect();
            world.addObject(teleporteffect, 40, 302);            
            TeleportEffect teleporteffect2 = new TeleportEffect();
            world.addObject(teleporteffect2, 343, 309);
            TeleportEffect teleporteffect3 = new TeleportEffect();
            world.addObject(teleporteffect3, 417, 230);
            TeleportEffect teleporteffect4 = new TeleportEffect();
            world.addObject(teleporteffect4, 424, 402);
            Greenfoot.delay(60);
            world.setBackground(tempBackground);
            world.removeObject(teleporteffect);
            world.removeObject(teleporteffect2);
            world.removeObject(teleporteffect3);
            world.removeObject(teleporteffect4);
            sound1.stop();
            sound1.play();
            Greenfoot.delay(30);
            world.setBackground(newBackground);         
            HeroNPC heronpc = new HeroNPC();
            world.addObject(heronpc, 40, 302);
            HK47NPC hk47npc = new HK47NPC();
            world.addObject(hk47npc, 343, 309);
            HK47NPC hk47npc2 = new HK47NPC();
            world.addObject(hk47npc2, 417, 230);
            HK47NPC hk47npc3 = new HK47NPC();
            world.addObject(hk47npc3, 424, 402);
            Greenfoot.delay(30);
            TextConvo1 textConvo1 = new TextConvo1();
            world.addObject(textConvo1, 300, 140);
        }
    }
    
    /**
     * This method creates a new line in the text box each time it is called.
     */
    public void createNewLine(String a, int b)
    {
        textBox1.drawString(a, 40, b);
    }
}
