

/**
 * this is a class to search in EightPuzzle
 *
 * @author KaiXin on 2022-04-29
 * @version 1.8
 * @since1.5
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
