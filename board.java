import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class board extends World{
    int[][] gameMap;
    public board()
    {    
        super(700, 500, 1);
        setPaintOrder(card.class, highlight.class);
        game myGame = new game();
        gameMap = myGame.getMap();
        prepare(gameMap);
        
    }
    
    public int offsetX = 52;  
    public int offsetY = 52;
    public int DX = 52;
    public int DY = 52;
    
    private void prepare(int[][] gameMap)
    {
        for (int baris=0;baris<=8;baris++){
            for(int kolom=0;kolom<=11;kolom++){
                if(gameMap[baris][kolom]==1){
                    argentina AR = new argentina(baris,kolom,this);
                    addObject(AR,DX+(kolom*offsetX),DY+(baris*offsetY));
                } 
                else if(gameMap[baris][kolom]==2){
                    austria AU = new austria(baris,kolom,this);
                    addObject(AU,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==3){
                    belanda BE= new belanda(baris,kolom,this);
                    addObject(BE,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==4){
                    brazil BR = new brazil(baris,kolom,this);
                    addObject(BR,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==5){
                    denmark DE = new denmark(baris,kolom,this);
                    addObject(DE,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==6){
                    indonesia IN = new indonesia(baris,kolom,this);
                    addObject(IN,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==7){
                    italia IT = new italia(baris,kolom,this);
                    addObject(IT,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==8){
                    jepang JP = new jepang(baris,kolom,this);
                    addObject(JP,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==9){
                    jerman JR = new jerman(baris,kolom,this);
                    addObject(JR,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                else if(gameMap[baris][kolom]==10){
                    swiss SW = new swiss(baris,kolom,this);
                    addObject(SW,DX+(kolom*offsetX),DY+(baris*offsetY));
                }
                System.out.println(gameMap[baris][kolom]+"baris"+baris+"kolom"+kolom);
            }
        }
    }
    
    public int[][] getMap(){
        return gameMap;
    }
    
    public void removeCard(int baris, int kolom, int currentB, int currentK){
        removeObjects(getObjectsAt(DX+(kolom*offsetX)+1, DY+(baris*offsetY)+1, null));
        removeObjects(getObjectsAt(DX+(currentK*offsetX)+1, DY+(currentB*offsetY)+1, null));
    }   
}
