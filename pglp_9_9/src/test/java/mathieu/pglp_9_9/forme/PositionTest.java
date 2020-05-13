package mathieu.pglp_9_9.forme;

import static org.junit.Assert.*;

import java.io.CharConversionException;

import org.junit.Test;

public class PositionTest {

    @Test
    public void testConstructor1() {
        Position p = new Position();
        assertTrue(p.getX() == 0 && p.getY() == 0);
    }
    @Test
    public void testConstructor2() {
        Position p = new Position(15,12);
        assertTrue(p.getX() == 15 && p.getY() == 12);
    }
    @Test
    public void testConstructor3() throws CharConversionException {
        Position p = new Position("(14,36)");
        assertTrue(p.getX() == 14 && p.getY() == 36);
    }
    @SuppressWarnings("unused")
    @Test  (expected = CharConversionException.class)
    public void testConstructor3EchecParenthese() throws CharConversionException {
        Position p = new Position("14,36");
    }
    @SuppressWarnings("unused")
    @Test  (expected = NumberFormatException.class)
    public void testConstructor3EchecValeurs() throws CharConversionException {
        Position p = new Position("(14,a)");
    }
    @SuppressWarnings("unused")
    @Test (expected = CharConversionException.class)
    public void testConstructor3EchecNbValeurs() throws CharConversionException {
        Position p = new Position("(14,36,58)");
    }
    @Test
    public void testDeplace() {
        Position p = new Position(15,12);
        p.deplace(100, 1000);
        assertTrue(p.getX() == 115 && p.getY() == 1012);
    }
    @Test
    public void testToString() {
        Position p = new Position(15,12);
        p.deplace(100, 1000);
        assertTrue(p.toString().equals("(115,1012)"));
    }
    @Test
    public void testClone() {
        Position p = new Position(1456,1236);
        Position p2 = p.clone();
        assertTrue(p2.getX() == p.getX() && p2.getY() == p.getY() && p != p2);
    }
}
