public class GameOfLife
{
    Rule rule;

    public GameOfLife(Rule rule)
    {
        this.rule = rule;
    }

    public int[] evolvePattern(int[] initialCluster)
    {
        for(int i=0;i<=initialCluster.length;i++)
        {
            boolean flag=false;
            if(initialCluster[i]==rule.current && initialCluster[i-1]==rule.left && initialCluster[i+1]==rule.right)
            {
                flag=true;
            }
            if(flag)
            {
                initialCluster[i]=1;
            }
        }
        return initialCluster;
    }

}
