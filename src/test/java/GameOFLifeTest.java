
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GameOFLifeTest
{
    @Test
    public void givenOneClusterWithAllDead_whenApplyNoCondition_thenReturnEvolveClusterOFAllDead()
    {
        int[] initialCluster ={0,0,0,0};
        int[] evolvedCluster ={0,0,0,0};

        assertArrayEquals(evolvedCluster, initialCluster);
    }
}
