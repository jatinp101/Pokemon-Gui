/**
* Class for Tree.
* @author Jatin Pandya
* @since 11/27/2018
*/
public class PokeTree  { // Taken alot from BinarySearchTree.java
	/** Root node instance variable. */
   private PokeNode root = null;

	  /** No parameter constructor. */
   public PokeTree() {
         // root already initialized
   }

	  /**
	   * Adds an item to the tree.
	   * Non-recursive wrapper method
	   * 
	   * @param item The object to be added
	   */
   public void add(Pokemon item) {
      // calls a recursive, private method
      // cannot get direct access to the root outside the class
      root = add(root, item);
   }
	  
	  /**
	   * Recusively adds an item to the tree.
	   * 
	   * @param node The root of the tree/subtree
	   * @param item The object to be added
	   * @return The current node
	   */
   private PokeNode add(PokeNode node, Pokemon item) {
   
      // base case: empty tree or end of a leaf
      if (node == null) {
         return new PokeNode(item, null, null);
      }
         // base case: duplicate node, so increase counter
      else if (node.getPokeNum(node) == item.getNumber()) {
         node.increaseCounter();
         return node;
      }
         // recursive case: if item is less than current node
         // then move to left child node
      else if (node.getPokeNum(node) > item.getNumber()) {
         // set the node's left child to the
         // left subtree with item added
         node.setLeftChild(this.add(node.getLeftChild(), item)); 
         return node;
      }
         // recursive case: if item is greater than current node
         // then traverse to right child node
      else {
         node.setRightChild(this.add(node.getRightChild(), item)); 
         return node;
      
      }
   }

	  /**
	   * called automatically by println/print method.
	   * 
	   * @return an inorder String of the tree
	   */
   public String printPokeTree() {
      return this.inOrder(root);
   }

	  /**
	   * inOrder display of nodes, with newline between each node.
	   * 
	   * @param node The root of the tree/subtree
	   * @return an inorder String of the tree
	   */
   private String inOrder(PokeNode node) {
      String displayNodes = "";
      if (node != null) {
         displayNodes = displayNodes 
               + this.inOrder(node.getLeftChild());
         displayNodes = displayNodes + node.toString()
                + "\nCaught: " + node.getCounter() + "\n";
         displayNodes = displayNodes 
               + this.inOrder(node.getRightChild());
      }
      return displayNodes;
   }

	  /**
	   * Pre-Order traversal of tree.
	   * 
	   * @return String representation of preOrder
	   */
   public String preOrder() {
      return this.preOrder(root);
   }

	  /**
	   * Recursive preOrder traversal of tree.
	   * 
	   * @param node The root of the tree/subtree
	   * @return a preOrder String of the tree
	   */
   private String preOrder(PokeNode node) {
      String displayNodes = "";
      if (node != null) {
         displayNodes = displayNodes + node.toString()
                + "\nCaught: " + root.getCounter() + "\n";
         displayNodes = displayNodes
               + this.preOrder(node.getLeftChild());
         displayNodes = displayNodes 
               + this.preOrder(node.getRightChild());
      }
      return displayNodes;
   }

	  /**
	   * Post-Order traversal of tree.
	   * 
	   * @return a postOrder String of the tree
	   */
   public String postOrder() {
      return this.postOrder(root);
   }

	  /**
	   * Recursive postOrder traversal of tree.
	   * To display nodes, with newline between each node
	   * 
	   * @param node The root of the tree/subtree
	   * @return a post-Order String of the tree
	   */
   private String postOrder(PokeNode node) {
      String displayNodes = "";
      if (node != null) {
         displayNodes = displayNodes + this.postOrder(node.getLeftChild());
         displayNodes = displayNodes + this.postOrder(node.getRightChild());
         displayNodes = displayNodes + node.toString()
                + "\nCaught: " + root.getCounter() + "\n";
      }
      return displayNodes;
   }

	  /**
	   * gets an item from the tree with the same search key.
	   * 
	   * @param searchKey1 An object containing the search key
	   * @return the data item in the tree with matching key.
	   */
   public Pokemon get(Pokemon searchKey1) {
      // cannot get direct access to the root outside the class
      return this.get(root, searchKey1);
   }

	  /**
	   * Recursive methog to get an item from the tree.
	   * 
	   * @param node The root of the tree/subtree
	   * @param searchKey2 An object storing the key to get.
	   * @return the data item in tree with matching key.
	   * @throws TreeException if item not found
	   */
   private Pokemon get(PokeNode node, Pokemon searchKey2) {
      // if not found, throw exception
      if (node == null) {
         throw new TreeException("Item not found!");
      } 
      else {
         int a1 = node.getPokeNum(node);
         int a2 = searchKey2.getNumber();
         // if the search key matches, return the item's address
         if (a1 == a2) { //Change to check species number instead
            return node.getPokemon();
         }
            // if the search key of the searchKey is less than the node,
            // then search the left subtree
         else if (a2 < a1) { //Change to check species number instead
            return this.get(node.getLeftChild(), searchKey2);
         }
            // if the search key of the searchKey is greater than the node,`  
            // then search the right subtree
         else {
            return this.get(node.getRightChild(), searchKey2);
         }
      }
   }

	  /**
	   * Removes an item from the tree.
	   * 
	   * @param searchKey3 An object storing the key to remove.
	   */
   public void remove(Pokemon searchKey3) {
      root = this.remove(root, searchKey3);
   }

	  /**
	   * Recursively removes an item from the tree.   
	   * 
	   * @param node The root of the tree/subtree
	   * @param searchKey4 An object storing only the key to remove.
	   * @return root of current subtree.
	   * @throws TreeException if item not found in tree.
	   */
   private PokeNode remove(PokeNode node, Pokemon searchKey4) {
      // if item not found, throw exception
      if (node == null) {
         throw new TreeException("Item not found!");
      }
         // if search key is less than node's search key,
         // continue to left subtree
      else if (searchKey4.getNumber() < node.getPokeNum(node)) {
         node.setLeftChild(this.remove(node.getLeftChild(), searchKey4)); 
         return node;
      }
         // if search key is greater than node's search key,
         // continue to right subtree
      else if (searchKey4.getNumber() > node.getPokeNum(node)) {
         node.setRightChild(this.remove(node.getRightChild(), searchKey4)); 
         return node;
      }
         // found node containing object with same search key,
         // so delete it
      else {
         // call private method remove
         node = this.remove(node);
         return node;
      }
   }

	  /**
	   * Helper method that takes a node out of tree.
	   * 
	   * @param node The node to remove
	   * @return The node that replaces removed node or null.
	   */
   private PokeNode remove(PokeNode node) {
      if (node.getCounter() > 1) {
         node.decreaseCounter();
         return node;
      } else {
      // if node is a leaf,return null
         if (node.getLeftChild() == null && node.getRightChild() == null) {
            return null;
         }
         // if node has a single right child node,
         // then return a reference to the right child node
         else if (node.getLeftChild() == null) {
            return node.getRightChild();
         }
         // if node has a single left child node,
         // then return a reference to the left child node
         else if (node.getRightChild() == null) {
            return node.getLeftChild();
         }
         // if the node has two child nodes
         else {
         // get next Smaller Item, which is Largest Item in Left Subtree
         // The next Smaller Item is stored at the rightmost node in the left
         // subtree.
            Pokemon largestItemInLeftSubtree = this.getItemWithLargestSearchKey(
                                             node.getLeftChild());
         // delete the rightmost node in the left subtree
            node.setLeftChild(this.removeNodeWithLargestSearchKey(node
                .getLeftChild()));
            return node;
         }
      }
   }

	  /**
	   * Returns the item with the largest search key in the (sub)tree.
	   * Helper method for removing interior nodes.
	   * @param node The root of the tree/subtree
	   * @return The data item with largest key
	   */
   private Pokemon getItemWithLargestSearchKey(PokeNode node) {
      // if no right child, then this node contains the largest item
      if (node.getRightChild() == null) {
         return node.getPokemon();
      }
         // if not, keep looking on the right
      else {
         return this.getItemWithLargestSearchKey(node.getRightChild());
      }
   }

	  /**
	   * Removes the node with the largest search key.
	   * Helper method for removing interior nodes.
	   * Remove the node formerly occupied by item with largest search key.
	   * To be called after item is moved to new node location.
	   * 
	   * @param node The root of the tree/subtree
	   * @return root of (sub)tree with node removed.
	   */
   private PokeNode removeNodeWithLargestSearchKey(PokeNode node) {
      // if no right child, then this node contains the largest item
      // so replace it with its left child
      if (node.getRightChild() == null) {
         return node.getLeftChild();
      }
         // if not, keep looking on the right
      else {
         node.setRightChild(this.removeNodeWithLargestSearchKey(node
                .getRightChild()));
         return node;
      }
   }

}
