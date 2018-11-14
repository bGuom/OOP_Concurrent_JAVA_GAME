/*
 * Classname : Player
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public abstract class Player extends GameObject{
    
    public  Player(String name,String type, Locatable position){
        super(name,type,position);
        
    }
    
    //-------------------Abstract Eat Method----------------------
    public abstract void eat();
    //------------------------------------------------------------
    
    //-------------------Abstract Sleep Method--------------------
    public abstract void sleep();
    //------------------------------------------------------------
    
    //-------------------Abstract Swim Method---------------------
    public abstract void swim(int X, int Y);
    //------------------------------------------------------------
    
    
   
   
}

//=============================================================================================================================
//                                       END      OF       THE         ABSTRACT         CLASS
//=============================================================================================================================