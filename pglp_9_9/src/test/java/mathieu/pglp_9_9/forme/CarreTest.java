package mathieu.pglp_9_9.forme;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarreTest {

    @Test
    public void testConstructorAndGetters() throws Exception {
        Carre r = new Carre("r", new Position(1,1), 10);
        assertEquals(r.getVariableName(), "r");
        assertTrue(r.getTopLeft().toString().equals("(1,1)"));
        assertTrue(r.getLongueur() == 10);
    }
    @Test
    public void testAffiche() throws Exception {
        Carre r = new Carre("r", new Position(1,1), 10);
        r.affiche();
    }
    @Test
    public void testDeplace() throws Exception {
        Carre r = new Carre("r", new Position(1,1), 10);
        r.deplace(10, 20);
        assertTrue(r.getTopLeft().toString().equals("(11,21)"));
    }
    @SuppressWarnings("unused")
    @Test (expected = Exception.class)
    public void testConstructorEchecLongueur() throws Exception {
        Carre r = new Carre("r", new Position(1,1), -10);
    }
}
