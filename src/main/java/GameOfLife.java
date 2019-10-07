import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameOfLife {
    private Rule rule;
    private List<Integer> evolvedCluster = new ArrayList<>();
    private List<Integer> paddedCluster= new ArrayList<>();;

    public GameOfLife(Rule rule) {
        this.rule = rule;
    }

    public List<Integer> evolvePattern(List<Integer> initialCluster) {
        paddedCluster = paddingEvolvedCluster(initialCluster);

        for (int i = 1; i < paddedCluster.size() - 1; i++) {
            if (paddedCluster.get(i) == rule.current && paddedCluster.get(i - 1) == rule.left && paddedCluster.get(i + 1) == rule.right) {
                evolvedCluster.add(1);
            } else {
                evolvedCluster.add(0);
            }
        }

        return evolvedCluster;
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
