/*
* Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public abstract class GameGround {
    private static int LENGTH;
    private static int WIDTH;
    
    
    public GameGround(int length , int width){
        this.LENGTH = length;
        this.WIDTH = width;
    }
    
    
    public int getMapLength(){
        return LENGTH;    
    }
    
    public int getMapWidth(){
        return WIDTH;
    }
    
    public Locatable getCenterCoordinate(){
        return new Location(WIDTH/2,LENGTH/2);    
    }
    
        
    
    
    
}
