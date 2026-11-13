package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreatureTest {
    private World world;
    private Creature creature;

    @BeforeEach
    void setUp() {
        Tile[][][] tiles = new Tile[3][3][1];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tiles[x][y][0] = Tile.FLOOR;
            }
        }
        world = new World(tiles);
        creature = new Creature(world, '@', Color.GRAY, "josh", 100, 10, 5);
        new CreatureAi(creature);
        creature.x = 1;
        creature.y = 1;
        creature.z = 0;
    }

    @Test
    void modifyHpCapsHealingAndKeepsCreatureAlive() {
        world.add(creature);

        creature.modifyHp(10, "test healing");

        assertEquals(100, creature.hp());
        assertEquals("test healing", creature.causeOfDeath());
        assertEquals(creature, world.creature(1, 1, 0));
    }

    @Test
    void modifyHpRemovesDeadCreatureAndLeavesCorpse() {
        world.add(creature);

        creature.modifyHp(-100, "test damage");

        assertEquals(0, creature.hp());
        assertEquals("test damage", creature.causeOfDeath());
        assertNull(world.creature(1, 1, 0));
        assertNotNull(world.item(1, 1, 0));
    }
}
