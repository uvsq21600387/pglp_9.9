package mathieu.pglp_9_9.forme;

import static org.junit.Assert.*;

import org.junit.Test;

public class CercleTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Cercle r = new Cercle("r", new Position(1,1), 10);
        assertEquals(r.getVariableName(), "r");
        assertTrue(r.getCentre().toString().equals("(1,1)"));
        assertTrue(r.getRayon() == 10);
    }
    @Test
    public void testAffiche() throws Exception {
        Cercle r = new Cercle("r", new Position(1,1), 10);
        r.affiche();
    }
    @Test
    public void testDeplace() throws Exception {
        Cercle r = new Cercle("r", new Position(1,1), 10);
        r.deplace(10, 20);
        assertTrue(r.getCentre().toString().equals("(11,21)"));
    }
    @SuppressWarnings("unused")
    @Test (expected = Exception.class)
    public void testConstructorEchecLongueur() throws Exception {
        Cercle r = new Cercle("r", new Position(1,1), -10);
    }
}
