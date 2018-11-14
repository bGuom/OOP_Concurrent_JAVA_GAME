/*
 * Classname : Fish
*
 * Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */


public abstract class Fish extends GameObject{
    private String fish_type;
    private boolean isInnocent;
    private boolean eat_Rubber;
    private boolean is_Killer;

    
    public Fish(String name, Locatable position){
        super(name,"Fish",position);
    }
           
    
    //-------------- return fish type ------------------
    public String getFishType(){
        return fish_type;
    }
    //--------------------------------------------------
    
    
    //-------------- set fish type ---------------------
    public void setFishType(String fish_type){
        if (fish_type=="I"){
            this.isInnocent=true;
            this.eat_Rubber=false;
            this.is_Killer=false;
            this.fish_type=fish_type;
        }
        if (fish_type=="R"){
            this.isInnocent=false;
            this.eat_Rubber=true;
            this.is_Killer=false;
            this.fish_type=fish_type;
        }
        if (fish_type=="K"){
            this.isInnocent=false;
            this.eat_Rubber=false;
            this.is_Killer=true;
            this.fish_type=fish_type;
        }
    }
    //--------------------------------------------------  

    
}