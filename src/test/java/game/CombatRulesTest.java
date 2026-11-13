package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CombatRulesTest {

    @ParameterizedTest(name = "current HP {0}, amount {2} gives HP {3}")
    @CsvSource({
            "50, 100, 10, 60, false",
            "90, 100, 10, 100, false",
            "95, 100, 10, 100, false",
            "50, 100, 0, 50, false",
            "10, 100, -5, 5, false",
            "10, 100, -9, 1, false",
            "10, 100, -10, 0, true",
            "10, 100, -11, -1, true"
    })
    void calculateNewHpHandlesHealthChangesAndBoundaries(
            int currentHp, int maxHp, int amount, int expectedHp, boolean expectedDead) {
        int actualHp = CombatRules.calculateNewHp(currentHp, maxHp, amount);

        assertEquals(expectedHp, actualHp);
        assertEquals(expectedDead, CombatRules.isDead(actualHp));
    }

    @ParameterizedTest(name = "HP {0} is dead: {1}")
    @CsvSource({
            "-1, true",
            "0, true",
            "1, false"
    })
    void isDeadChangesAtOneHp(int hp, boolean expectedDead) {
        assertEquals(expectedDead, CombatRules.isDead(hp));
    }
}
