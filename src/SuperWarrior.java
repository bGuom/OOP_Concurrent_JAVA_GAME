/*
 * Classname : SuperWarrior
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public class SuperWarrior extends Warrior{


    
    public SuperWarrior(String name,Locatable position){
        super(name, position);
        this.setBinoStatusTrue();
        
    }
    
    
    
    //----------------------Eat Method----------------------------
    @Override
    public void eat(){}
    //------------------------------------------------------------
    
    //-------------------------Sleep Method-----------------------
    @Override
    public void sleep(){}
    //------------------------------------------------------------
    
    //---------------------------Swim Method----------------------
    @Override
    public void swim(int X, int Y){
        this.position = new Location(X,Y);  
    }
    //------------------------------------------------------------
    
}

//=============================================================================================================================
//                                       END      OF       THE         CLASS
//=============================================================================================================================