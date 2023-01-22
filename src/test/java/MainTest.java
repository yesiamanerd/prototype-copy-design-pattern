import org.example.Point;
import org.junit.Test;
import org.example.Line;
import static org.example.Main.deepCopy;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testDeepCopyUsingCopyConstructor() {
        Line line = new Line(new Point(1, 1), new Point(10, 10));
        Line line2 = line.deepCopy();

        assertNotSame(line, line2);
        assertEquals(line.start.x, line2.start.x);
        assertEquals(line.start.y, line2.start.y);
        assertEquals(line.end.x, line2.end.x);
        assertEquals(line.end.y, line2.end.y);
    }

    @Test
    public void testDeepCopyUsingReflection() throws Exception {
        Line line = new Line(new Point(1, 1), new Point(10, 10));
        Line line3 = (Line) deepCopy(line);

        assertNotSame(line, line3);
        assertEquals(line.start.x, line3.start.x);
        assertEquals(line.start.y, line3.start.y);
        assertEquals(line.end.x, line3.end.x);
        assertEquals(line.end.y, line3.end.y);
    }
}

