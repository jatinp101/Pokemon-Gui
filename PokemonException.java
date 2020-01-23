/**
* Exception for Pokemon class.
* @author Jatin Pandya
* @since 11/8/2018
*/
public class PokemonException extends RuntimeException {
  /**
  * Constructor. 
  * @param newMessage The error message to be sent.
  */
   public PokemonException(String newMessage) {
      super(newMessage);
   }
}