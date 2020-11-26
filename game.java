import java.util.ArrayList;
import java.util.Random;

public class game  {
        // instance variables - replace the example below with your own
    private int[][] baseMap ={
    {1,1,1,1,2,2,2,2},
    {3,3,3,3,4,4,4,4},
    {5,5,5,5,6,6,6,6},
    {7,7,7,7,8,8,8,8},
    {9,9,9,9,10,10,10,10}};    
    
    int x = 9;
    int y = 12;
    private int[][] map = new int[x][y];
    
    public game()
    {
        newGame();
    }
    
    public void newGame(){
        initMap();
    }
    
    public void initMap(){
        
        int[][]myMap = shuffleMap(baseMap);  
        for(int i = 0; i < x ; i++){
            for(int j = 0 ; j < y ; j++){
                if( i==0 || i==x-1 || j==0 || j==y-1 ){map[i][j] = -1;}
                else if( i==1 || i==x-2 || j==1 || j==y-2 ){map[i][j] = 0;}
                else map[i][j] = myMap[i-2][j-2];
            }
        }
        //printmap(myMap);
        //printmap(map);
    }
    
    private void printmap(int[][]mumap){
    for(int i = 0; i < mumap.length ; i++){
            for(int j = 0 ; j < mumap[i].length ; j++){
                System.out.print(mumap[i][j]);
            }
        System.out.println("xxxxxxxxxxxx");
        }
    }
    
    public int[][] getMap(){
        return map;
    }
    
    public int[][]shuffleMap( int[][] map ){
        Random rand = new Random();
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int randomI = rand.nextInt(map.length);
                int randomJ = rand.nextInt(map[i].length);
                int temp = map[randomI][randomJ];
                map[randomI][randomJ] = map[i][j];
                map[i][j] = temp;
            }
        }
        return map;
    }
}
