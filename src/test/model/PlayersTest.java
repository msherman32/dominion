package model;

import org.junit.Before;
import org.junit.Test;
import sample.model.Node;
import sample.model.Players;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayersTest {

    private int numPlayers = 3;
    private Players players;

    @Before
    public void setup() {
        players = new Players(numPlayers);
    }

    @Test
    public void test_construction() {
        assertFalse("Head is null", players.get(0) == null);
        assertFalse("Tail is null", players.get(2) == null);
    }

    @Test
    public void test_circular() {
        assertTrue( players.get(2).getNext() == players.get(0));
    }

    @Test
    public void test_no_null_nodes() {
        int i = 0;
        while (i < numPlayers) {
            Node node = players.get(i);
            assertTrue("Node is null", node != null);
            assertTrue("Node's next is null", node.getNext() != null);
            i++;
        }
    }

}