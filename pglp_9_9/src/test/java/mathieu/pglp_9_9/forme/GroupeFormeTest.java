package mathieu.pglp_9_9.forme;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class GroupeFormeTest {

    @Test
    public void testConstructor() {
        GroupeForme g = new GroupeForme("g");
        assertTrue(g.getList().isEmpty() && g.getVariableName().equals("g"));
    }
    @Test
    public void testAdd() throws Exception {
        GroupeForme g = new GroupeForme("g");
        Cercle c = new Cercle("c", new Position(1,1),10);
        g.add(c);
        g.add(c);
        g.add(g);
        assertTrue(g.getList().size() == 1 && g.getList().get(0) == c);
    }
    @Test
    public void testDelete() throws Exception {
        GroupeForme g = new GroupeForme("g");
        Cercle c = new Cercle("c", new Position(1,1),10);
        g.add(c);
        g.remove(c);
        assertTrue(g.getList().isEmpty());
    }
    @Test
    public void testIterate() throws Exception {
        GroupeForme g = new GroupeForme("g");
        Cercle c = new Cercle("c", new Position(1,1),10);
        g.add(c);
        Iterator<Forme> itf = g.iterator();
        assertTrue(itf.hasNext() && itf.next() == c && itf.hasNext() == false);
    }
    @Test
    public void testAffiche() throws Exception {
        GroupeForme g = new GroupeForme("g");
        Cercle c = new Cercle("c", new Position(1,1),10);
        g.add(c);
        g.affiche();
    }
    @Test
    public void testDeplace() throws Exception {
        GroupeForme g = new GroupeForme("g");
        Cercle c = new Cercle("c", new Position(1,1),10);
        g.add(c);
        g.deplace(123,121);
        assertTrue(c.getCentre().toString().equals("(124,122)"));
    }
}
