import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.util.*;
/**
* Panel for PokemonGuiJatinp.
* @author Jatin Pandya
* @since 12/6/2018
*/

public class PokemonPanel extends JPanel {
/**
  * Choice picker for sorting.
  */
   private Choice chPoke = new Choice();
/**
* pokemon.
*/
   private Pokemon p = null;
   /**
   * Title for program.
   */
   private JLabel lTitle = new JLabel("Pokemon");
   /**
   * Button to find pokemon.
   */
   private JButton bHunt = new JButton(" Hunt Pokemon ");
   /**
   * Button to catch pokemon.
   */
   private JButton bCatch = new JButton(" Capture Pokemon ");
   /**
   * Button to show pokemon you've caught.
   */
   private JButton bBackpack = new JButton(" Backpack ");
   /**
   * Button show pokemon you've found.
   */
   private JButton bPokedex = new JButton(" Pokedex ");
  
  /**
  * Panel to house title.
  */
   private JPanel topSubPanel = new JPanel();
   /**
   * Main panel.
   */
   private JPanel centerSubPanel = new JPanel();
   /**
   * Panel to house buttons and error message.
   */
   private JPanel bottomSubPanel = new JPanel();
   /**
   * Waits for buttons event.
   */
   private GUIListener listener = new GUIListener();
   /**
   * Tree for caught pokemon.
   */
   private PokeTree pt = new PokeTree();
   /**
   * Queue for Pokemon sorted in number order.
   */
   private PriorityQueue<Pokemon> pq = new PriorityQueue<Pokemon>();
   /**
   * Stack for Pokemon sorted in Recent order.
   */
   private Stack<Pokemon> stack = new Stack<>();
    
  /**
  * Capacity to autogenerate string because of jPanel.
  */
   private final int capacity = 10;
   /**
   * Storing autogenerated text.
   */
   private String sOut = new String("");
   /**
   * Outputting results from make pokemon.
   */
   private JTextArea textArea = new JTextArea("");
   /**
   * Scroll pane for make pokemon.
   */
   private JScrollPane scroll = new JScrollPane(textArea, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   /**
   * Text area for listing pokemon from pokedex or backpack.
   */
   private JTextArea textArea2 = new JTextArea("");
   /**
   * Allowing scrolling to view pokemons.
   */
   private JScrollPane scroll2 = new JScrollPane(textArea2, 
       JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

 /**
  * Constructor holds everything.
  */
   public PokemonPanel() {
    
      setLayout(new BorderLayout()); 
      setPreferredSize(new Dimension(400, 500));
      topSubPanel.setBackground(Color.red); 
      centerSubPanel.setBackground(Color.blue); 
      bottomSubPanel.setBackground(Color.red); 
     
     
      topSubPanel.add(lTitle);
      add("North", topSubPanel); 
     
        
     
     
      for (int x = 0; x < capacity; x++) {
         sOut += (x + 1) + "-------------------------------------"
            + "--------------------------------\n";
       
      }
      // Setting up text area and placing them
      textArea.setText(sOut);
      textArea.setEditable(false);
      centerSubPanel.add(scroll);  
      centerSubPanel.add(bHunt);
      bHunt.addActionListener(listener); 
      centerSubPanel.add(bCatch);
      bCatch.addActionListener(listener);
      textArea2.setText(sOut);
      textArea2.setEditable(false); 
      centerSubPanel.add(scroll2);  
     
      add("Center", centerSubPanel);
     
     // Setting and placing buttons
      bottomSubPanel.add(bPokedex);
      bPokedex.addActionListener(listener); 
      bottomSubPanel.add(bBackpack);
      bBackpack.addActionListener(listener);
      //Positioning for drop down menu
      bottomSubPanel.add(chPoke);
         
      add("South", bottomSubPanel);  
      //add choices to the choice dropdown list
      chPoke.add("Recent");
      chPoke.add("Number");
   
   } 
  /**
 * Private ActionListener class.
 */
   private class GUIListener implements ActionListener {
   /**
   * ActionPerformed method.
   * @param event what button is clicked.
   */ 
    
      public void actionPerformed(ActionEvent event) {
         
         // Hunting Pokemon
         if (event.getSource() == bHunt) { 
            int max = 18;
            Random randGen = new Random();
            int a = randGen.nextInt(max) + 1;
            String inString = Integer.toString(a);
            switch(inString) {
               case "1": p = new Bulbasaur(); 
                  
                  break;
               case "2": p = new Ivysaur(); 
                  
                  break;
               case "3": p = new Venusaur(); 
                  
                  break;
               case "4": p = new Charmander(); 
                  
                  break;
               case "5": p = new Charmeleon(); 
                  
                  break;
               case "6": p = new Charizard(); 
                  
                  break;
               case "7": p = new Squirtle();
                 
                  break;
               case "8": p = new Wartortle(); 
                  
                  break;
               case "9": p = new Blastoise(); 
                  
                  break;
               case "10": p = new Vulpix(); 
                  
                  break;
               case "11": p = new Ninetales(); 
                  
                  break;
               case "12": p = new Growlithe(); 
                  
                  break;
               case "13": p = new Arcanine(); 
                 
                  break;
               case "14": p = new Ponyta(); 
                  
                  break;
               case "15": p = new Rapidash(); 
                  
                  break;
               case "16": p = new Magmar(); 
                  
                  break;
               case "17": p = new Psyduck(); 
                  
                  break;
               case "18": p = new Golduck(); 
                  
                  break;
               default: System.out.println("Not a valid choice"); 
                  break;
               
            }
            pq.add(p);
            stack.push(p);
            textArea.setText(p.toString());
         } 
         if (event.getSource() == bCatch) { 
            if (p == null) {
               textArea.setText("No pokemon has been found");
            }
            else {
               boolean c;
               Random randGen = new Random();
               c = randGen.nextBoolean();
               if (c) {
                  textArea.setText(p.toString() + "\n\n" + p.getName()
                                   + " was caught");
                  pt.add(p);
               } else {
                  textArea.setText(p.toString() + "\n\n" + p.getName()
                                  + " ran away");
               }
               p = null;
            }
         }
         if (event.getSource() == bBackpack) {
            textArea2.setText(pt.printPokeTree());
         }
         if (event.getSource() == bPokedex) {
            String s = "";
            String sort = chPoke.getSelectedItem();
            PriorityQueue<Pokemon> pqTemp = new PriorityQueue<Pokemon>();
            Stack<Pokemon> stackCopy = new Stack<>();
            stackCopy.addAll(stack);
            
            if (sort.equals("Number")) {
               while (pq.size() > 0) { // Printing out Priority Queue
                  Pokemon curr = pq.poll();
                  s = s + curr.toString() + "\n"; 
                  pqTemp.add(curr);
               }
               pq.addAll(pqTemp);
               textArea2.setText(s);
            } else {
               int pSize = stack.size();
               for (int k = 0; k < pSize; k++) { // Printing out Stack
                  Pokemon curr = stackCopy.pop();
                  s = s + curr.toString() + "\n"; 
               }
               textArea2.setText(s);
            }
         }
      }
   } 
}