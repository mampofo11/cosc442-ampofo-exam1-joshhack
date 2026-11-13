package game;

/**
 * Holds the health calculations and death rules used during combat.
 */
public class CombatRules {

    /**
     * Adds an amount to the current HP without allowing it to exceed max HP.
     */
    public static int calculateNewHp(int currentHp, int maxHp, int amount) {
        int newHp = currentHp + amount;
        if (newHp > maxHp) {
            return maxHp;
        }
        return newHp;
    }

    /**
     * Returns whether the given HP value means the creature is dead.
     */
    public static boolean isDead(int hp) {
        return hp < 1;
    }
}
