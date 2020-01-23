import javax.swing.JFrame;

/**
* Demonstrates using GUI with Pokemon class.
* @author Jatin Pandya
* @since 12/6/2018
*/

public class PokemonGUIJatinp {
   /** main method.
   * @param args not used
   */
   public static void main(String[ ] args) {
      //setup basic JFrame
        
      JFrame frm = new JFrame("Pokemon GUI");
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //Add PokemonPanel object to Frame
      frm.getContentPane().add(new PokemonPanel());
      //Display to screen
      frm.pack();
      frm.setVisible(true);
      
   }
}