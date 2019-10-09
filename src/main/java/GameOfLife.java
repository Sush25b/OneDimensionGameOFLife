
import java.util.ArrayList;
import java.util.List;

public class GameOfLife {
    private List<Rule> rules;
    private List<Integer> evolvedCluster = new ArrayList<>();
    private List<Integer> paddedCluster = new ArrayList<>();
    private List<Integer> initialCluster;

    public GameOfLife(List<Rule> rules, List<Integer> initialCluster) {
        this.rules = rules;
        this.initialCluster = initialCluster;
    }

    private void initializeEvolveCluster(List<Integer> initialCluster) {
        for (int i = 0; i < initialCluster.size(); i++) {
            evolvedCluster.add(0);
        }
    }

    public List<Integer> evolvePattern() {
        paddedCluster = pad(initialCluster);
        initializeEvolveCluster(initialCluster);

        for (Rule currentRule : rules) {
            for (int i = 1; i < paddedCluster.size() - 1; i++) {         // TODO - name your loops (private methods)
                patternMatcher(i, currentRule);
            }
        }
        return evolvedCluster;
    }

    private void patternMatcher(int i, Rule currentRule) {
         boolean checkCurrent = paddedCluster.get(i) == currentRule.current;
         boolean checkLeft= paddedCluster.get(i - 1) == currentRule.left;
         boolean checkRight=paddedCluster.get(i + 1) == currentRule.right;

        if (checkCurrent && checkLeft && checkRight) {
            evolvedCluster.set(i - 1, 1);
        }
    }

    private List<Integer> pad(List<Integer> cluster) {
        int valueAtEnds = 0;

        paddedCluster.add(valueAtEnds);
        paddedCluster.addAll(cluster);
        paddedCluster.add(valueAtEnds);

        return paddedCluster;
    }

   public GameOfLife getEvolvedGameOfLife()
   {
       return new GameOfLife(this.rules,this.evolvePattern());
       
   }
}
