
import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class GameOFLifeTest
{
    @Test
    public void givenOneClusterWithAllDead_whenApplyNoCondition_thenReturnEvolveClusterOFAllDead()
    {
        int[] initialCluster ={0,0,0,0};
        int[] evolvedCluster ={0,0,0,0};

        assertArrayEquals(initialCluster,evolvedCluster);
    }

    @Test
    public void givenOneClusterWithAllDead_whenApplyOneCondition_thenReturnEvolveClusterOFAllDead()
    {
        int[] initialCluster ={0,0,0,0};
        Rule rule=new Rule(0,0,0);
        int[] evolvedCluster ={0,0,0,0};

        assertArrayEquals(initialCluster,evolvedCluster);
    }
}
