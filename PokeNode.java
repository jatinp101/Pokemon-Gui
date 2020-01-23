/**
 * PokeNode for Pokedex.
 * @author Jatin P
 * @since 11/15/2018
 */
public class PokeNode { // Taken alot from BinaryNode.java
	// data fields
	  /** Data held in Node. */
   private Pokemon data;
	   /** Link to left child Node. */
   private PokeNode left;
	   /** Link to right child Node. */
   private PokeNode right;
	   /** Counter. */
   private int counter;

		/**
		 * Constructor.
		 * 
		 * @param d The address of the object that is stored by the node
		 * @param l The address of the left child
		 * @param r The address of the right child
		 */
   public PokeNode(Pokemon d, PokeNode l,
      		PokeNode r) {
      data = d;
      left = l;
      right = r;
      counter = 1;
   }

		/**
		 * Automatically called by println() or print() method.
		 * 
		 * @return the item's string
		 */
   public String toString() {
      String display = data.toString();
      return display;
   }

		/**
		 * Accessor method.
		 * 
		 * @return the item's address
		 */
   public Pokemon getPokemon() {
      return data;
   }
   /**
   * Gets number for pokemon to compare.
   * @param p2 node.
   * @return pokenumber
   */
   public int getPokeNum(PokeNode p2) {
      int p1 = p2.getPokemon().getNumber();
      return p1;
   }

		/**
		 * Accessor method.
		 * 
		 * @return the left child's address
		 */
   public PokeNode getLeftChild() {
      return left;
   }

		/**
		 * Mutator method.
		 * 
		 * @param l
		 *            is the left child's address
		 */
   public void setLeftChild(PokeNode l) {
      left = l;
   }

		/**
		 * Accessor method.
		 * 
		 * @return the right child's address
		 */
   public PokeNode getRightChild() {
      return right;
   }

		/**
		 * Mutator method.
		 * 
		 * @param r
		 *            is the right child's address
		 */
   public void setRightChild(PokeNode r) {
      right = r;
   }
	   /**
		 * Accessor method.
       * @return counter.
		 */
   public int getCounter() {
      return counter;
   }
	   /**
		 * Mutator method.
		 */
   public void increaseCounter() {
      counter++;
   }
	   /**
		 * Mutator method.
		 * @throws PokemonException when counter == 1.
		 */
   public void decreaseCounter() throws PokemonException {
      if (counter == 1) {
         PokemonException pe = new PokemonException("Counter can't go below 1");
         throw pe;
      } else {
         counter--;
      } 
   }
}
