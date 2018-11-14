/*
 * Classname : Lotus
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public class Lotus extends GameObject{
    private int no_of_Petals=100;
    
    public Lotus(String name,Locatable position){
        super(name,"Lotus",position);

    }
    
    
    //-----getters & setters for no of petals --------
    public void setNoOfPetals(int i){
        this.no_of_Petals=i;
    }
    
    public int getNoOfPetals(){
        return this.no_of_Petals;
    }
    //------------------------------------------------
    //------------------------------------------------
    
}

//=============================================================================================================================
//                                       END      OF       THE         CLASS
//=============================================================================================================================
