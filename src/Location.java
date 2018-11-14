/*
 * Class : Location
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */

public class Location implements Locatable {
    private int coordinateX;
    private int coordinateY;
    
    public Location(int coordinateX, int coordinateY){
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
    }
    
    //===============================================
    
    @Override
    public void updateLocation(int coordinateX, int coordinateY){
        this.coordinateX=coordinateX;
        this.coordinateY=coordinateY;
    }
    
    
    @Override
    public String getLocationAsString(){
        return (coordinateX+","+coordinateY);        
    }
    
    @Override
    public int getLocationX(){
        return coordinateX;        
    }
    
    @Override
    public int getLocationY(){
        return coordinateY;        
    }
    
    @Override
    public void setLocationX(int coordinateX){
        this.coordinateX=coordinateX;        
    }
    
    @Override
    public void setLocationY(int coordinateY){
        this.coordinateY=coordinateY;        
    }

    @Override
    public void setLocation(String coordinate) {
        coordinateX = Integer.parseInt(coordinate.split(",")[0]);
        coordinateY = Integer.parseInt(coordinate.split(",")[1]);
    }
    
    
    
    
}
