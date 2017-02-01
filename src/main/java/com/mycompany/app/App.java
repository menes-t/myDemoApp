package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static int summary(ArrayList<Integer> arr,int i1,int i2){
        
        //the array must be assigned
        if(arr == null){
            return 0;
        }

        /*
        int f,s;
        //whether index values are really integers,
        try{
            f = Integer.parseInt(i1);
            s = Integer.parseInt(i2);
        }catch(Exception e){
            return 0;
        }
        */

        //the array must contain at least two integers
        if(arr.size() == 0 || arr.size() == 1){
            return 0;
        }

        //the integers must be positive and smaller than the size of array
        if(i1 < 0 || i2 < 0 || i1 >= arr.size() || i2 >= arr.size()){
            return 0;
        }
        
        return arr.get(i1)+arr.get(i2);

        /*
        int first,second;
        //whether the value of integers are really integers,
        try{
            first = Integer.parseInt(arr[f]);
            second = Integer.parseInt(arr[s]);
        }catch(Exception e){
            return 0;
        }
        */

        //return first+second;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

}
