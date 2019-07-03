package model;

import org.junit.Test;
import sample.model.Players;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PlayersTest {

    @Test
    public void test_construction() {
        Players players = new Players(3);
        assertFalse("Head is null", players.get(0) == null);
        assertFalse("Tail is null", players.get(2) == null);
    }

}