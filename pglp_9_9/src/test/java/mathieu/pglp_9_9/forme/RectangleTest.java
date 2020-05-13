package mathieu.pglp_9_9.forme;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Rectangle r = new Rectangle("r", new Position(1,1), 10, 5);
        assertEquals(r.getVariableName(), "r");
        assertTrue(r.getTopLeft().toString().equals("(1,1)"));
        assertTrue(r.getLongueur() == 10);
        assertTrue(r.getLargeur() == 5);
    }
    @Test
    public void testAffiche() throws Exception {
        Rectangle r = new Rectangle("r", new Position(1,1), 10, 5);
        r.affiche();
    }
    @Test
    public void testDeplace() throws Exception {
        Rectangle r = new Rectangle("r", new Position(1,1), 10, 5);
        r.deplace(10, 20);
        assertTrue(r.getTopLeft().toString().equals("(11,21)"));
    }
    @SuppressWarnings("unused")
    @Test (expected = Exception.class)
    public void testConstructorEchecLongueur() throws Exception {
        Rectangle r = new Rectangle("r", new Position(1,1), -10, 5);
    }
    @SuppressWarnings("unused")
    @Test (expected = Exception.class)
    public void testConstructorEchecLargeur() throws Exception {
        Rectangle r = new Rectangle("r", new Position(1,1), 10, -5);
    }
}
