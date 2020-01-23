/**
* Arcanine object class.
* @author Jatin P
* @since 10/3/2018
*/
public class Arcanine extends Growlithe {
	/** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 227;
	   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 166;
	   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 207;
	   
	   /** Constructor with no name. */
   public Arcanine() {
      super("Arcanine", "Arcanine", 59, FIRE_COLOR, 1.9, 155.0, FIRE_TYPE,
            "", BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
	   
	   /** Constructor with name.
	   * @param name The user-defined name.
	   */
   public Arcanine(String name) {
      super("Arcanine", name, 59, FIRE_COLOR, 1.9, 155.0, FIRE_TYPE,
            "", BASE_ATTACK_POWER, BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   }
	   /** 
	   * Constructor with species and name for subclasses.
	   *@param species The Pokemon's species.
	   *@param name The optional user-given name.
	   *@param num The Pokedex number for this species.
	   *@param ht The height of this Pokemon.
	   *@param wt The weight of this Pokemon. 
	   *@param baseAttackPwr The low limit of Attack Power for species.
	   *@param baseDefensePwr The low limit of Defense Power for species.
	   *@param baseStaminaPwr The low limit of Stamina Power for speices. 
      *@param typeOne primary type.
      *@param typeTwo secondary type.
	   */
   protected Arcanine(String species, String name, int num, double ht, 
          double wt, String typeOne, String typeTwo,
          int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {
         
      super(species, name, num, FIRE_COLOR, ht, wt, typeOne, typeTwo,
            baseAttackPwr, baseDefensePwr, baseStaminaPwr);
   }
	   

}
