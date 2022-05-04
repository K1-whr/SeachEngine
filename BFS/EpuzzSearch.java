

/**
 * this is a class to search in EightPuzzle
 *
 * @author Haoran on 2022-04-29
 */
public class EpuzzleSearch extends Search{

    int[][] goal = new int[3][3];

    public EpuzzleSearch(int[][] goal) {
        this.goal = goal;
    }

    /**
     * run a search
     *
     * @param initState initial state
     * @param strategy  - String specifying strategy
     * @return indication of success or failure
     */

    public String runSearch(EpuzzleState initState, String strategy) {
        return super.runSearch(initState, strategy);
    }
}
