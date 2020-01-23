import java.util.Random;
/**
 * Object class for Charizard.
 * @author Jatin P
 * @since 10/3/2018
 */
 // Template taken from Bulbasaur.java
public class Charizard extends Charmeleon implements FlyingType {
	 /** The minimum attack power for species. */
   static final int BASE_ATTACK_POWER = 223;
	   /** The minimum defense power for species. */
   static final int BASE_DEFENSE_POWER = 176;
	   /** The minimum stamina power for species. */
   static final int BASE_STAMINA_POWER = 156;
	   
	   //booleans for telling which type attack to use for dual type Pokemon
	   /** Indicator for fast attack type. */
   protected boolean fastIsFire = true;
	   /** Indicator for special attack type. */
   protected boolean specialIsFire = true;
	   /**
      * Constructor for Charizard.
      */
   public Charizard() {
      super("Charizard", "Charizard", 6, 1.7, 90.5, 
              FIRE_TYPE, FLYING_TYPE, BASE_ATTACK_POWER, 
              BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   	      //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }
   
    /**
      * Constructor for Charizard.
      *@param name is set by user
      */
   public Charizard(String name) {
      super("Charizard", name, 6, 1.7, 90.5, 
              FIRE_TYPE, FLYING_TYPE, BASE_ATTACK_POWER, 
              BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
   	      //pick Attacks after construct
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
      *@param typeOne primary type.
      *@param typeTwo secondary type.
	   */
   protected Charizard(String species, String name, int num, 
   	       double ht, double wt, String typeOne, String typeTwo, 
             int baseAttackPwr, int baseDefensePwr, int baseStaminaPwr) {
   	       
      super(species, name, num, ht, wt, FIRE_TYPE, 
              FLYING_TYPE, baseAttackPwr, baseDefensePwr, baseStaminaPwr);
   
      chooseFastAttack();
      chooseSpecialAttack();
   }
   /**
   * Selecting if the Fast attack is Fire or flying.
   */
   protected void chooseFastAttack() {
   	      //randomly choose to get Fire or Flying attack
      Random randGen = new Random();
      int index;
   	      //set attack type boolean
      fastIsFire = randGen.nextBoolean();
   	      
      if (fastIsFire) {
         index = randGen.nextInt(FIRE_FAST_ATTACKS.length);
         fastAttack = FIRE_FAST_ATTACKS[index];
         fastAttackPower = FIRE_FAST_ATK_POWER[index];
      } else { //is flying
         index = randGen.nextInt(FLYING_FAST_ATTACKS.length);
         fastAttack = FLYING_FAST_ATTACKS[index]; 
         fastAttackPower = FLYING_FAST_ATK_POWER[index];
         fastIsFire = false;  
      }
   }
   /**
   * Selecting if the Special attack is Fire or flying.
   */
   protected void chooseSpecialAttack() {
   	      //randomly choose to get fire or flying attack
      Random randGen = new Random();
      int index;
   	      //set type choice boolean
      specialIsFire = randGen.nextBoolean();
   	      
      if (specialIsFire) {
         index = randGen.nextInt(FIRE_SPECIAL_ATTACKS.length);
         specialAttack = FIRE_SPECIAL_ATTACKS[index];
         specialAttackPower = FIRE_SPECIAL_ATK_POWER[index];
      } else { //is Flying
         index = randGen.nextInt(FLYING_SPECIAL_ATTACKS.length);
         specialAttack =  FLYING_SPECIAL_ATTACKS[index];
         specialAttackPower = FLYING_SPECIAL_ATK_POWER[index];  
                
      }
   }
   /**
   * Performing if the Fast attack is Fire or flying.
   *@param victim is pokemon being attacked
   *@return effectiveness of attack
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
      if (fastIsFire) { //if attack is fire-type
         if (vType.equals("Grass") || vType.equals("Ice") 
          	             || vType.equals("Bug") || vType.equals("Steel")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Fire") || vType.equals("Water") 
          	             || vType.equals("Rock") || vType.equals("Dragon")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         } 
      } else { //is flying attack
         if (vType.equals("Grass") || vType.equals("Fighting")
             || vType.equals("Bug")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
                  
         } else if (vType.equals("Rock") || vType.equals("Electric") 
                   || vType.equals("Steel")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         } 
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
   * Performing if the Special attack is Fire or flying.
   *@param victim is pokemon being attacked
   *@return effectiveness of attack.
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
      if (specialIsFire) { //if attack is fire-type
         if (vType.equals("Grass") || vType.equals("Ice") 
                      || vType.equals("Bug") || vType.equals("Steel")) {
                     
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;          
         } else if (vType.equals("Fire") || vType.equals("Water") 
                      || vType.equals("Rock") || vType.equals("Dragon")) { 
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         }
       	     
      } else { //is flying attack
         if (vType.equals("Grass") || vType.equals("Fighting")
             || vType.equals("Bug")) {
            s = s + "\n It was super effective!";
            modifier = modifier * 2.0;
                  
         } else if (vType.equals("Electric") || vType.equals("Rock") 
                   || vType.equals("Steel")) {
                   
            s = s + "\n It was not very effective.";
            modifier = modifier * 0.5;
         } 
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
		   
}
