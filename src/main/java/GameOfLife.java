
import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    private List<Rule> rule;
    private List<Integer> evolvedCluster = new ArrayList<>();
    private List<Integer> paddedCluster = new ArrayList<>();

    public GameOfLife(List<Rule> rule) {
        this.rule = rule;
    }

    public List<Integer> evolvePattern(List<Integer> initialCluster) {

        paddedCluster = paddingEvolvedCluster(initialCluster);
        for (int i = 0; i < initialCluster.size(); i++) {
            evolvedCluster.add(0);
        }

        for (Rule currentRule : rule) {
            for (int i = 1; i < paddedCluster.size() - 1; i++) {
               evolvePattern(i,currentRule);
            }
        }
        return evolvedCluster;
    }

    private void evolvePattern(int i,Rule currentRule)
    {
        if (paddedCluster.get(i) == currentRule.current && paddedCluster.get(i - 1) == currentRule.left && paddedCluster.get(i + 1) == currentRule.right) {
            evolvedCluster.set(i - 1, 1);
        }
    }

    private List<Integer> paddingEvolvedCluster(List<Integer> clusterToPad) {
        int valueAtEnds = 0;

        paddedCluster.add(valueAtEnds);
        for (Object i : clusterToPad) {
            paddedCluster.add((Integer) i);
        }
        paddedCluster.add(valueAtEnds);

        return paddedCluster;
    }
}
