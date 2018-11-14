

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



/**
* Version info : 1.0
 *
 * Copyright notice : Buddhi Gunarathne (160170B)
 */
public class GameEngine {
    
    public static ArrayList<Locatable> locationArray = new ArrayList<Locatable>();
    
       
    
    //================================================================
    //----------------------------------------------------------------
    //------------- Get array containing 4 location around a node--------
    public static String[] getSurroundArray(Locatable Position){
        String[] tempSurroundArray = new String[4];
        
        int X = Position.getLocationX();
        int Y =Position.getLocationY();
        
        tempSurroundArray[0]= ((X+1)+","+Y);
        tempSurroundArray[1]= ((X-1)+","+Y);
        tempSurroundArray[2]= ( X+","+(Y+1));
        tempSurroundArray[3]= (X+","+(Y-1));
        
        return tempSurroundArray;  
    }
    //------------------------------------------------------------------
    //------------------------------------------------------------------
    
    public static boolean checkNearWin(Locatable winning_position,Locatable Position){
        String[] tempSurroundArray = new String[4];
        
        int X = winning_position.getLocationX();
        int Y =winning_position.getLocationY();
        
        tempSurroundArray[0]= ((X+1)+","+Y);
        tempSurroundArray[1]= ((X-1)+","+Y);
        tempSurroundArray[2]= ( X+","+(Y+1));
        tempSurroundArray[3]= (X+","+(Y-1));
        
        return Arrays.asList(tempSurroundArray).contains(Position.getLocationAsString()); 
        
    
    }
    
    
    //=============================================================================
    //-----------------------------------------------------------------------------
  
    //-----------------------------------------------------------------------------
    //--------- return new random Location object in the grid---------------------
    public static Locatable LocateNonPlayingObject(Locatable game_winning_target_position, int map_width, int map_length){
        Random randV = new Random(); 
        Locatable location=null;
        
        locationArray.add(game_winning_target_position);
        
        boolean located =false;
        while (located==false){
            int  XVal = randV.nextInt(map_width-2) + 1;
            int  YVal = randV.nextInt(map_length-2) + 1;
            location = new Location(XVal, YVal);
            
            if ( getLocationArrayAsStringArray(locationArray).indexOf(location.getLocationAsString())!=-1){
                located =false;
            }
            else{
                located =true;
                locationArray.add(location);
               break;
            }
        }
        return location;
        
    }
    //-----------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    
    public static ArrayList<String> getLocationArrayAsStringArray(ArrayList<Locatable> arr){
        
        ArrayList<String> temp = new ArrayList<String>();
        
        for(int i =0;i<arr.size();i++){
            temp.add(arr.get(i).getLocationAsString());
        }
        
        return temp;
    }
    
  
    
    
    
    public static String saveToFile(String Player,String time){
        String msg ="Written to a file\nWinning time was: "+time;
        try{
            // Create file
            FileWriter fstream = new FileWriter(System.currentTimeMillis() + "out.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(Player + " Won the game and ");
            out.write("Gameplay time was " + time);
            //Close the output stream
            out.close();
        }
        catch (Exception e){
            //Catch exception if any
            msg= ("Error: " + e.getMessage());
        }
        return msg;
    
    }
    //=============================================================================
    
}
