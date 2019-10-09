import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameOFLifeTest {
    @Test
    public void givenOneClusterWithAllDead_whenApplyOneCondition_thenReturnEvolveClusterOFAllAlive() {
        List<Integer> initialCluster = Arrays.asList(0,0,0,0);
        Rule rule = new Rule(0, 0, 0);
        List<Rule> ruleList= Arrays.asList(rule);
        GameOfLife gameOfLife = new GameOfLife(ruleList,initialCluster);

        List<Integer> evolvedCluster = Arrays.asList(1,1,1,1);

        assertEquals(evolvedCluster, gameOfLife.evolvePattern());
    }

    @Test
    public void givenOneClusterWithOnlyOneAlive_whenApplyOneCondition_thenReturnEvolveClusterOFTwoAlive() {
        List<Integer> initialCluster = Arrays.asList(0,0,0,1);
        Rule rule = new Rule(0, 0, 0);
        List<Rule> ruleList= Arrays.asList(rule);
        GameOfLife gameOfLife = new GameOfLife(ruleList,initialCluster);

        List<Integer> evolvedCluster = Arrays.asList(1,1,0,0);

        assertEquals(evolvedCluster, gameOfLife.evolvePattern());
    }

    @Test
    public void givenOneClusterWithOnlyTwoAlive_whenApplyTwoCondition_thenReturnEvolveClusterOFThreeAlive()
    {
        List<Integer> initialCluster = Arrays.asList(1,0,0,1);
        Rule firstRule = new Rule(0, 1, 0);
        Rule secondRule = new Rule(0, 0, 1);
        List<Rule> ruleList= Arrays.asList(firstRule,secondRule);
        GameOfLife gameOfLife = new GameOfLife(ruleList,initialCluster);

        List<Integer> evolvedCluster = Arrays.asList(1,0,1,1);

        assertEquals(evolvedCluster, gameOfLife.evolvePattern());
    }

    @Test
    public void givenOneClusterWithOnlyTwoAlive_whenApplyTwoCondition_thenReturnEvolveClusterOFOneAlive()
    {
        List<Integer> initialCluster = Arrays.asList(0,1,1,0);
        Rule firstRule = new Rule(0, 1, 0);
        Rule secondRule = new Rule(0, 0, 1);
        List<Rule> ruleList= Arrays.asList(firstRule,secondRule);
        GameOfLife gameOfLife = new GameOfLife(ruleList,initialCluster);

        List<Integer> evolvedCluster = Arrays.asList(1,0,0,0);

        assertEquals(evolvedCluster, gameOfLife.evolvePattern());
    }


    @Test
    public void givenOneClusterWithOnlyTwoAlive_whenApplyTwoConditionAndEvolveTwice_thenReturnEvolveClusterOFOneAlive() {
        List<Integer> initialCluster = Arrays.asList(0, 1, 1, 0);
        Rule firstRule = new Rule(0, 1, 0);
        Rule secondRule = new Rule(0, 0, 1);
        List<Rule> ruleList = Arrays.asList(firstRule, secondRule);
        GameOfLife gameOfLife = new GameOfLife(ruleList, initialCluster);

        List<Integer> evolvedCluster = Arrays.asList(1, 0, 0, 0);

        assertEquals(evolvedCluster, gameOfLife.getEvolvedGameOfLife().evolvePattern());
    }
}
