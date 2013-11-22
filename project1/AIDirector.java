import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This actor spawns enemies.
 * 
 * @author Martin Silberberg
 * @version 2/6/2013
 */
public class AIDirector extends Actor
{
    /**
     * Constructor for objects of class AIDirector.
     */
    public AIDirector()
    {
    }
    
    /**
     * This method is called whenever the game environment acts or runs.
     * This method decides how often to spawn enemies.
     */
    public void act() 
    {
        World world = getWorld();
        int x = Greenfoot.getRandomNumber(9500);
        if(x < 500)
            spawnBasicEnemy(world);
        if(x < 800 && x >= 500)
            spawnSideUpEnemy(world);
        if(x < 1000 && x >= 800)
            spawnSideDownEnemy(world);
        if(x < 1050 && x >= 1000)
            spawnInvulnUpEnemy(world);
        if(x < 1050 && x >= 1000)
            spawnInvulnDownEnemy(world);
        if(x < 1055 && x >= 1050)
            spawnBoss(world);
        if(x < 1070 && x >= 1055)
            spawnTeleporter(world); 
    }    
    
    /**
     * This method spawns actors of class BasicEnemy.
     */
    public void spawnBasicEnemy(World world)
    {
        BasicEnemy enemy = new BasicEnemy();
        world.addObject(enemy, 580, Greenfoot.getRandomNumber(580));
    }
    
    /**
     * This method spawns actors of class SidewaysUpEnemy.
     */
    public void spawnSideUpEnemy(World world)
    {
        SidewaysUpEnemy enemy = new SidewaysUpEnemy();
        world.addObject(enemy, 580, Greenfoot.getRandomNumber(580));
    }
    
    /**
     * This method spawns actors of class SidewaysDownEnemy.
     */
    public void spawnSideDownEnemy(World world)
    {
        SidewaysDownEnemy enemy = new SidewaysDownEnemy();
        world.addObject(enemy, 580, Greenfoot.getRandomNumber(580));
    }
    
    /**
     * This method spawns actors of class InvulnUpEnemy.
     */
    public void spawnInvulnUpEnemy(World world)
    {
        InvulnUpEnemy enemy = new InvulnUpEnemy();
        world.addObject(enemy, 580, Greenfoot.getRandomNumber(580));
    }
    
    /**
     * This method spawns actors of class InvulnDownEnemy.
     */
    public void spawnInvulnDownEnemy(World world)
    {
        InvulnDownEnemy enemy = new InvulnDownEnemy();
        world.addObject(enemy, 580, Greenfoot.getRandomNumber(580));
    }
    
    /**
     * This method spawns actors of class Boss.
     */
    public void spawnBoss(World world)
    {
        Boss boss = new Boss();
        GreenfootImage tempBackground = new GreenfootImage("Untitled.png");
        GreenfootImage newBackground = new GreenfootImage("104095-yana.jpg");
        GreenfootSound sound1 = new GreenfootSound("tele2.wav");
        world.setBackground(tempBackground);
        sound1.setVolume(75);
        sound1.play();
        Greenfoot.delay(30);
        world.setBackground(newBackground);
        int x = Greenfoot.getRandomNumber(580);
        world.addObject(boss, 540, x);
    }
    
    /**
     * This method spawns actors of class TeleporterEnemy.
     */
    public void spawnTeleporter(World world)
    {
        TeleporterEnemy tele = new TeleporterEnemy();
        GreenfootSound sound1 = new GreenfootSound("tele2.wav");
        sound1.setVolume(65);
        sound1.play();
        int x = Greenfoot.getRandomNumber(580);
        int y = Greenfoot.getRandomNumber(300);
        world.addObject(tele, 200+y, x);
    }
}
