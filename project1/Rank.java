import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor represents the player's current rank.
 * It increases throughout the game, with the number component ranging from 0 to 99 and the second letter 
 * becoming the next letter in the alphabet every time the number reaches 100.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class Rank extends Actor
{
    /**
     * Width, height and rank establish the rank textbox and create the dimensions of the box.
     */
    private GreenfootImage rank;
    private int width = 60;
    private int height = 15;
    /**
     * Represents the value of the numerical component of the rank.
     */
    protected int count1 = 1;
    /**
     * Represents the value of the alphabetic component of the rank.
     */
    protected int count2;
    /**
     * Keeps track of whether the first upgrade is locked(0), unlocked(1), or applied(2).
     */
    public int c = 0;
    /**
     * Keeps track of whether the second upgrade is locked(0), unlocked(1), or applied(2).
     */
    public int g = 0;
    /**
     * This method is called whenever the game environment acts or runs.
     * Checks whether or not the player has reached a high enough rank to upgrade.
     */
    public void act() 
    {
        upgrade();
    }    
    
    /**
     * Constructor for objects of class Rank.
     */    
    public Rank()
    {
        this.rank = new GreenfootImage(this.width, this.height);
    }
    /**
     * This method identifies when the player is presented with the choice to upgrade and creates the upgrade text box if it is appropriate.
     * The player can upgrade when he/she reaches the rank of HC or HG.
     */    
    public void upgrade()
    {
        World world = getWorld();
        if(c == 1)
        {
           /**
            * Sets a new image for the avatar.
            */
            for(int i = -30; i < 580; i++)
            {
                Actor hero = getOneObjectAtOffset(-10, i, RobotHero.class);
                if(hero != null)
                {
                    hero.setImage("steel-ball.png");
                }
            }
            /**
            * Prompts the player to choose an upgrade with a textbox.
            */
            UpgradeChoice1 upgrade1 = new UpgradeChoice1();
            world.addObject(upgrade1, 260, 100);
            c = 2;
        }
        if(g == 1)
        {
            /**
            * Sets a new image for the avatar.
            */
            for(int i = -30; i < 580; i++)
            {
                Actor hero = getOneObjectAtOffset(-10, i, RobotHero.class);
                if(hero != null)
                {
                    hero.setImage("robot.png");
                }
            }
            /**
            * Prompts the player to choose an upgrade with a textbox.
            */
            UpgradeChoice2 upgrade2 = new UpgradeChoice2();
            world.addObject(upgrade2, 260, 100);
            g = 2;
        }
    }
    
    /**
     * This creates a text box that keeps track of the player's rank.
     * Keeps track of the alphabetic and numerical components of the rank.
     */
    public void createRank()
    { 
        count1 = count1 + 2;
        if(count1 >= 100)
        {
            count1 = 0;
            count2++;
        }
        rank.setTransparency(255);
        String x = "";
        rank.setColor(java.awt.Color.gray);
        rank.fillRect(0, 0, width, height);
        rank.setColor(java.awt.Color.yellow);
        switch (count2)
        {
            case 0:
                    x = "A";
                    break;
            case 1:     
                    x = "B";            
                    break;
            case 2:     
                    x = "C";            
                    break;
            case 3:     
                    x = "D";            
                    break;
            case 4:         
                    x = "E";        
                    break;
            case 5:         
                    x = "F";        
                    break;
            case 6:         
                    x = "G";        
                    break;
            case 7:        
                    x = "H";        
                    break;
            case 8:         
                    x = "I";        
                    break;
            case 9:         
                    x = "J";        
                    break;
            case 10:        
                    x = "K";            
                    break;
            case 11:
                    Greenfoot.setWorld(new VictoryScreen());
                    break;
        }
        if(x == "C" && c == 0)
        {
            c = 1;
        }
        if(x == "G" && g == 0)
        {
            g = 1;
        }
        rank.drawString("H" + x + "-" + count1, 15, 12);
        this.setImage(rank);
    }
}
