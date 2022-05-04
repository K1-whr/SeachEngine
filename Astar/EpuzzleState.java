



import java.util.ArrayList;

/**
 * @author Haoran on 2022-04-20
 */
public class EpuzzleState extends SearchState{

    private int[][] now = new int[3][3];


    public EpuzzleState(int[][] now,int localCost,int estCost) {
        this.now = now;
        this.localCost = localCost;
        this.estRemCost = estCost;
    }


    public int[][] getNow() {
        return now;
    }
    public void setNow(int[][] now) {
        this.now = now;
    }

    @Override
    boolean goalPredicate(Search searcher) {
        if(searcher instanceof EpuzzleSearch){
            EpuzzleSearch eSearch = (EpuzzleSearch) searcher;
            return isEqual(eSearch.goal);
        }
        return false;
    }

    @Override
    ArrayList<SearchState> getSuccessors(Search searcher) {

        ArrayList<SearchState> res = new ArrayList<>();
        EpuzzleSearch search = (EpuzzleSearch)searcher;
        EpuzzleState preState = (EpuzzleState)searcher.currentNode.get_State();
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j){

                if(preState.now[i][j] == 0) {
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dir[k][0];
                        int ty = j + dir[k][1];
                        if(tx >= 0 && tx < 3 && ty >= 0 && ty < 3){
                            int[][] temp = new int[3][3];
                            for(int l = 0; l < 3; ++l)
                                System.arraycopy(preState.now[l], 0, temp[l], 0, 3);
                            temp[tx][ty] = 0;
                            temp[i][j] = preState.now[tx][ty];

                            // use hammingDistance
                            int dis = hammingDistance(temp,search.goal);
                            //or use manhattan
                            //int dis = manhattanDistance()(temp,search.goal);
                            EpuzzleState newState = new EpuzzleState(temp,1,dis);
                            res.add(newState);
                        }
                    }
                }
            }
        return res;
    }
    /**
     * calculate the hammingDistance
     */
    int hammingDistance(int sta[][],int goal[][]){
        int dis = 0;
        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j)
                if(sta[i][j] != goal[i][j]) dis++;

        return dis;
    }

    /**
     * calculate the manhattanDistance
     */
    int manhattanDistance(int sta[][],int goal[][]){
        int dis = 0;

        for(int i = 0; i < 3; ++i)
            for(int j = 0; j < 3; ++j){
                int temp = sta[i][j];

                for(int k = 0; k < 3; ++k) {
                    boolean find = false;
                    for (int l = 0; l < 3; ++l) {
                        if(temp == goal[k][l]){
                            dis += Math.abs(i + j - ( k + l));
                            find = true;
                            break;
                        }
                    }
                    if(find) break;
                }
            }
        return dis;
    }



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
