package mathieu.pglp_9_9.forme;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

    @Test
    public void testConstructorAndGetters() {
        Triangle t = new Triangle("t", new Position(1,1), new Position(2,1), new Position(1,0));
        assertEquals(t.getVariableName(), "t");
        assertTrue(t.getPosition(0).toString().equals("(1,1)"));
        assertTrue(t.getPosition(1).toString().equals("(2,1)"));
        assertTrue(t.getPosition(2).toString().equals("(1,0)"));
    }
    @Test
    public void testAffiche() {
        Triangle t = new Triangle("t", new Position(1,1), new Position(2,1), new Position(1,0));
        t.affiche();
    }
    @Test
    public void testDeplace() {
        Triangle t = new Triangle("t", new Position(1,1), new Position(2,1), new Position(1,0));
        t.deplace(10, 20);
        assertTrue(t.getPosition(0).toString().equals("(11,21)"));
        assertTrue(t.getPosition(1).toString().equals("(12,21)"));
        assertTrue(t.getPosition(2).toString().equals("(11,20)"));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testUp() {
        Triangle t = new Triangle("t", new Position(1,1), new Position(2,1), new Position(1,0));
        t.getPosition(3);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testDown() {
        Triangle t = new Triangle("t", new Position(1,1), new Position(2,1), new Position(1,0));
        t.getPosition(-1);
    }
}
