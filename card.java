import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class card extends Actor
{
    public card()
    {
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    static game myGame = new game();
    
    board myBoard;
    int[][] gameMap;
    private static int currentB,currentK;
    highlight cardHighlight = new highlight();
    pathfinder tracker = new pathfinder();
    
    
    card(board myBoard){
        // Store the board the card is on.
        super();
        this.myBoard = myBoard;
        this.gameMap = myBoard.gameMap;
    }
    
    public void nextTurn(int baris, int kolom){
        System.out.println("F1 Called");
        boolean currentCond = cekCurrentCard(baris, kolom);
        boolean matchCond = cekMatch(baris, kolom);
        if( !currentCond && matchCond){
            System.out.println("F2 Called");
            boolean trackerCond = tracker.findPath(gameMap, currentB, currentK, baris, kolom);
            //System.out.println(trackerCond?"true":"false");
            if(!currentCond && trackerCond){
                updateMap(baris,kolom);
            }
        setCurrentCard(baris, kolom, currentCond, matchCond);
        }
    }
    
    public void setCurrentCard(int baris, int kolom, boolean currentCond, boolean matchCond){
        //jika kartu yang dipilih sama dengan kartu sebelumnya
        System.out.println("next " +gameMap[baris][kolom] + ",current" + gameMap[currentB][currentK]);
        if(currentCond){
            currentB = 0;
            currentK = 0;
            getWorld().removeObjects(getWorld().getObjects(highlight.class));
            System.out.println("sama");
        }
        //jika kartu yang dipilih berbeda dengan kartu sebelumnya dan tidak bertemu kartu yang cocok
        else if(!currentCond && !matchCond){
            currentB = baris;
            currentK = kolom;            
            getWorld().removeObjects(getWorld().getObjects(highlight.class));
            getWorld().addObject(cardHighlight, getX(), getY());
            System.out.println("beda ga cocok");
        }
        //jika kartu yang dipilih berbeda dengan kartu sebelumnya dan bertemu kartu yang cocok
        else if(!currentCond && matchCond){
            currentB = 0;
            currentK = 0;
            System.out.println("beda cocok");
        }
        
    }
    
    public boolean cekMatch(int baris, int kolom){
        return (gameMap[baris][kolom] == gameMap[currentB][currentK]);
    }
    
    public void updateMap(int baris, int kolom){
        gameMap[baris][kolom] = 0;
        gameMap[currentB][currentK] = 0;
        myBoard.removeCard(baris,kolom,currentB,currentK);
    }
    
    public boolean cekCurrentCard(int baris, int kolom){
        //true jika sama, false jika berbeda
        return (baris == currentB) && (kolom == currentK);
    }
    
    public int[][] getMap(){
    return gameMap;
    }
}
