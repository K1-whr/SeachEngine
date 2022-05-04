
/**
 * @author Haoran on 2022-05-01
 * @version 1.8
 * @since1.5
 */
public class EpuzzleSearch extends Search{

    int[][] goal = new int[3][3];

    public EpuzzleSearch(int[][] goal) {
        this.goal = goal;
    }

    public String runSearch(EpuzzleState initState, String strat) {
        return super.runSearch(initState, strat);
    }
}
