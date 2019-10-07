
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameOFLifeTest {
    @Test
    public void givenOneClusterWithAllDead_whenApplyOneCondition_thenReturnEvolveClusterOFAllAlive() {
        List<Integer> initialCluster = Arrays.asList(0,0,0,0);
        Rule rule = new Rule(0, 0, 0);
        GameOfLife gameOfLife = new GameOfLife(rule);
        List<Integer> evolvedCluster = Arrays.asList(1,1,1,1);

        assertEquals(evolvedCluster, gameOfLife.evolvePattern(initialCluster));
    }


}
