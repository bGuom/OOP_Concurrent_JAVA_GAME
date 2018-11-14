/*
 * Interface : Locatable
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public interface Locatable {
    public String getLocationAsString();
    public void setLocation(String coordinate);
    public void updateLocation(int x, int y);
    public int getLocationX();
    public int getLocationY();
    public void setLocationX(int x);
    public void setLocationY(int y);
    
    
    
}

//=============================================================================================================================
//                                       END      OF       THE         INTERFACE
//=============================================================================================================================