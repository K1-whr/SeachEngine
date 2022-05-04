
/**
 * @author Haoran on 2022-04-20
 */
public class EpuzzleSearch extends Search{

    int[][] goal = new int[3][3];

    public EpuzzleSearch(int[][] goal) {
        this.goal = goal;
    }

    public String runSearch(EpuzzleState initState, String strategy) {
        return super.runSearch(initState, strategy);
    }
}
