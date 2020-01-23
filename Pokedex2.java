import java.util.*;

/**
* a driver program to test Pokemon and PokemonException
* 
* @author Lisa Miller ljmiller@hawaii.edu
* @since 11/20/2016
*/

public class Pokedex2{
 
     //this program will ask the user to enter the information for one Pokemon
     //it will validate it and print it if correct
     //If input is incorrect, it catches the exception and prints the error message
        
  public static void main(String [ ] args){
   
    Scanner sc = new Scanner(System.in);
    int pokeHP = -1;
    int pokeNumber = -1;
    String pokeSpecies = "";
    String pokeName = "";
    String sTemp = "";

    Pokemon p;
  
    try{
      System.out.print("Enter Pokemon's species: ");
      pokeSpecies = sc.nextLine( );

      System.out.print("\nEnter Pokemon's name: ");
      pokeName = sc.nextLine( );

      System.out.print("\nEnter Pokemon's number: ");
      sTemp = sc.nextLine();
      //risky will throw NumberFormatException
      pokeNumber = Integer.parseInt(sTemp);

      System.out.print("\nEnter Pokemon's HP: ");
      sTemp = sc.nextLine();
      //risky will throw NumberFormatException
      pokeHP = Integer.parseInt(sTemp);
      
      //attempting to construct Pokemon risky will throw PokemonException
      p = new Pokemon(pokeSpecies, pokeName, pokeNumber, pokeHP);
      //only will print if no exception
      System.out.println("The Pokemon entered was:");
      System.out.println(p.toString( ));
     }
     
     catch(NumberFormatException nfe){
        System.out.println("you did not enter a number");
     }
     catch (PokemonException pe){
        System.out.println(pe.getMessage( ));  //calling the getMessage from PokemonException.java
     }  
     
   }  //main method

}   //class