package game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CreatureDeathNotificationTest {

    @Test
    void deathNotifiesTheCreature() {
        Tile[][][] tiles = new Tile[3][3][1];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                tiles[x][y][0] = Tile.FLOOR;
            }
        }

        World world = new World(tiles);
        Creature creature = new Creature(world, '@', Color.GRAY, "josh", 100, 10, 5);
        List<String> notifications = new ArrayList<>();
        new CreatureAi(creature) {
            @Override
            public void onNotify(String message) {
                notifications.add(message);
            }
        };
        creature.x = 1;
        creature.y = 1;
        creature.z = 0;
        world.add(creature);

        creature.modifyHp(-100, "test damage");

        assertTrue(notifications.contains("You die."));
    }
}
