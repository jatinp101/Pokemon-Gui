import java.util.Random;
/**
 * Magmar Pokemon Object Class.
 * Impliment FireType class.
 * @author Jatin P
 * @since 9/21/2018
 */
public class Magmar extends Pokemon implements FireType {
	 /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 206;
	   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 154;
	   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 163;

	   /**
	   * Constructor with no name.
	   * uses Pokemon superclass constructor
	   * attacks must be set after contruction of Pokemon Object
	   * because of dependence on type interface
	   */
   public Magmar() {
      super("Magmar", "Magmar", 126, FIRE_COLOR, 1.3, 44.5, 
           FIRE_TYPE, "", BASE_ATTACK_POWER, 
           BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
         //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }
	   /**
	   * Constructor with name.
	   * uses Pokemon superclass constructor
	   * attacks must be set after contruction of Pokemon Object
	   * because of dependence on type interface
	   * @param name The user-defined name.
	   */
   public Magmar(String name) {
      super("Magmar", name, 126, FIRE_COLOR, 1.3, 44.5, 
           FIRE_TYPE, "", BASE_ATTACK_POWER, 
           BASE_DEFENSE_POWER, BASE_STAMINA_POWER);
         //pick Attacks
      chooseFastAttack();
      chooseSpecialAttack();
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
      *@param fireColor Color for fire pokemon.
      *@param typeOne primary type.
      *@param typeTwo secondary type.
	   */
   protected Magmar(String species, String name, int num, String fireColor,
          double ht, double wt, String typeOne, String typeTwo,
          int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {
          
      super(species, name, num, FIRE_COLOR, ht, wt, typeOne, 
           typeTwo, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
         //pick Attacks
         //can happen here because all subclasses are same types as Bulbasaur
      chooseFastAttack();
      chooseSpecialAttack();
   }
	   
	   /**
	   * Randomly picks an attack from type attack arrays.
	   */
   protected void chooseFastAttack() {
      Random randGen = new Random();
      int index;
   
      index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
      fastAttack = FIRE_FAST_ATTACKS[index];
      fastAttackPower = FIRE_FAST_ATK_POWER[index];
   }
	   
	  /**
	   * Randomly picks an attack from type interface attack arrays.
	   */
   protected void chooseSpecialAttack() {
         //randomly choose to get grass or poison attack
      Random randGen = new Random();
      int index;	     
      index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
      specialAttack = FIRE_SPECIAL_ATTACKS[index];
      specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
   }
	   
	   /**
	   * Game-play fast attack simulation.
	   * Creates an output String stating attack details
	   * checks for weakness/strength adjustment based on 
	   * victim Pokemon's type and attack type
	   * (only need to check latter for dual-type)
	   * Calls beAttacked method on attacked victim.
	   *
	   * @param victim the Pokemon being attacked
	   * @return String explaining attack and effectiveness
	   */
   public String performFastAttack(Pokemon victim) {
         
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
         
      String s = "";
      String vType = victim.getType1();
         
         //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;      
      s = name + " performed " + fastAttack + " on " + victim.getSpecies();
         //check effectiveness of attack
      if (vType.equals("Grass") || vType.equals("Ice") 
                || vType.equals("Bug") || vType.equals("Steel")) {
               
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Fire") || vType.equals("Water") 
                || vType.equals("Rock") || vType.equals("Dragon")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
        
         //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
         //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
            * attackPower * (specialAttackPower + 2) * modifier;      
         //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
	   
	  /**
	   * Game-play special attack simulation.
	   * Creates an output String stating attack details
	   * checks for weakness/strength adjustment based on 
	   * victim Pokemon's type and attack type
	   * (only need to check latter for dual-type)
	   * uses Damage formula from here: 
	   * http://bulbapedia.bulbagarden.net/wiki/Damage
	   * Calls beAttacked method on attacked victim.
	   * @param victim the Pokemon being attacked.
	   * @return String explaining attack and effectiveness.
	   */
   public String performSpecialAttack(Pokemon victim) {
      Random rand = new Random();
      double damage = 0.0;
      double modifier = 1.0;
      double damageDivisor = 250.0;
         
      String s = "";
      String vType = victim.getType1();
         
         //random modifier .85 - 1.00
      modifier = (double) (rand.nextInt(16) + 85) / 100.0;       
      s = name + " performed " + specialAttack + " on " + victim.getSpecies();
         
         //check effectiveness of attack
      if (vType.equals("Grass") || vType.equals("Ice") 
                   || vType.equals("Bug") || vType.equals("Steel")) {
                  
         s = s + "\n It was super effective!";
         modifier = modifier * 2.0;          
      } else if (vType.equals("Fire") || vType.equals("Water") 
                   || vType.equals("Rock") || vType.equals("Dragon")) { 
         s = s + "\n It was not very effective.";
         modifier = modifier * 0.5;
      }
   	     
         //check for same types for bonus
      if (type1.equals(vType) && type2.equals(victim.getType2())) {
         modifier = modifier *  1.5;
      }
         //bulbapedia damage formula:
      damage = (((2 * level) + 10) / damageDivisor) 
             * attackPower * (specialAttackPower + 2) * modifier;
        
         //perform hit on victim pokemon
      victim.beAttacked((int) damage);
      return s;
   }
	   
	   /**
	   * Reduces Pokemon's HP by damage/defensePower.
	   * Doesn't allow HP to go less than 0
	   * Implementation of "fainting" not done here
	   * @param damage Hit points to take off HP
	   */
   protected void beAttacked(int damage) {
         //part of bulbapedia damage formula
      damage = damage / defensePower;
         
      if (hP > damage) {
         hP = hP - damage;
      } else {
         hP = 0; //"Pokemon fainted"
      }
   }     




}
