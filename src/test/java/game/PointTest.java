package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void equalCoordinatesProduceEqualPointsAndHashCodes() {
        Point first = new Point(2, 4, 1);
        Point second = new Point(2, 4, 1);

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
        assertNotEquals(first, new Point(2, 4, 2));
    }

    @Test
    void neighbors8ReturnsEveryAdjacentPointOnTheSameLevel() {
        Point center = new Point(3, 5, 2);
        Set<Point> neighbors = new HashSet<>(center.neighbors8());

        assertEquals(8, neighbors.size());
        for (Point neighbor : neighbors) {
            assertEquals(2, neighbor.z);
            assertTrue(Math.abs(neighbor.x - center.x) <= 1);
            assertTrue(Math.abs(neighbor.y - center.y) <= 1);
            assertNotEquals(center, neighbor);
        }
    }
}
