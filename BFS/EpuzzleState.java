

import java.util.ArrayList;
import java.util.Arrays;

/**
 * this is a searchState for EightPuzzle
 *
 * @author KaiXin on 2022-04-29
 * @version 1.8
 * @since1.5
 */
public class EpuzzleState extends SearchState{

    private int[][] now = new int[3][3];


    public EpuzzleState(int[][] start) {
        this.now = start;

    }

    public int[][] getNow() {
        return now;
    }

    public void setNow(int[][] now) {
        this.now = now;
    }


    /**
     * goalPredicate takes a SearchNode & returns a boolean if it's a goal
     * @param searcher
     */
    @Override
    boolean goalPredicate(Search searcher) {

        if(searcher instanceof EpuzzleSearch){
            EpuzzleSearch eSearch = (EpuzzleSearch) searcher;
            return isEqual(eSearch.goal);
        }
        return false;
    }

    /**
     * getSuccessors returns an ArrayList of states which are successors to the
     * current state in a given search
     * @param searcher
     */
    @Override
    ArrayList<SearchState> getSuccessors(Search searcher) {
        ArrayList<SearchState> res = new ArrayList<>();
        EpuzzleState state = (EpuzzleState)searcher.currentNode.getState();

        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};


        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j){
                if(state.now[i][j] == 0){

                    for(int k = 0; k < 4; ++k){
                        int tx = i + dir[k][0];
                        int ty = j + dir[k][1];

                        if(tx >= 0 && tx < 3 && ty >= 0 && ty < 3){
                            int[][] temp = new int[3][3];
                            for(int l = 0; l < 3; ++l)
                                System.arraycopy(state.now[l], 0, temp[l], 0, 3);

                            temp[tx][ty] = 0;
                            temp[i][j] = state.now[tx][ty];
                            EpuzzleState epuzzleState = new EpuzzleState(temp);
                            res.add(epuzzleState);
                        }
                    }
                    break;
                }
            }
        return res;
    }

    /**
     * sameState: is this state identical to a given one?
     * @param n2
     */
    @Override
    boolean sameState(SearchState n2) {
        if(n2 instanceof EpuzzleState){
            EpuzzleState eState = (EpuzzleState) n2;
            return isEqual(eState.now);
        }
        System.out.println("different state");
        return false;
    }

    @Override
    public String toString() {
       String res = "\n";
        for(int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                res += now[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }

    /**
    * @Description: two matrix is Equal
    * @Param: [m2]
    * @return: boolean
    * @Date: 2022-05-01
    */
    public boolean isEqual(int [][] m2){
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j)
                if(now[i][j] != m2[i][j]) {
                    return false;
                }
        return true;
    }
}
