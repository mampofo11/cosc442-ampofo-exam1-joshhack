package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void horizontalLineIncludesBothEndpointsInOrder() {
        List<Point> points = points(new Line(1, 3, 4, 3));

        assertEquals(4, points.size());
        assertEquals(new Point(1, 3, 0), points.get(0));
        assertEquals(new Point(4, 3, 0), points.get(points.size() - 1));
    }

    @Test
    void lineFromPointToItselfContainsOnePoint() {
        List<Point> points = points(new Line(2, 5, 2, 5));

        assertEquals(List.of(new Point(2, 5, 0)), points);
    }

    private List<Point> points(Line line) {
        return StreamSupport.stream(line.spliterator(), false).collect(Collectors.toList());
    }
}
