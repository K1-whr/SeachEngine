



import org.junit.Test;

/**
 * test the Astar search
 *
 * @author Haoran on 2022-04-20
 */
public class RunEpuzzleAstar {
    static int[][] goal = new int[][]{{1,2,3},{4,5,6},{7,8,0}};
    static EpuzzleSearch search = new EpuzzleSearch(goal);
    static String chooseMethod = "a*";


    public static void main(String[] args) {
        test01();
    }

    /**
     * test first target
     */
    public static void test01(){
        int[][] now = new int[][]{{1,0,3},{4,2,6},{7,2,5}};
        EpuzzleState state = new EpuzzleState(now,0,0);

        String res =  search.runSearch(state,chooseMethod);
        System.out.println(res);


    }

    /**
     * test second target
     */
    public static void test02(){
        int[][] now = new int[][]{{4,1,3},{7,2,5},{0,8,6}};
        EpuzzleState state = new EpuzzleState(now,0,0);

        String res =  search.runSearch(state,chooseMethod);
        System.out.println(res);


    }


    /**
     * test third target
     */
    public static void test03(){
        int[][] now = new int[][]{{2,3,6},{1,5,8},{4,7,0}};
        EpuzzleState state = new EpuzzleState(now,0,0);

        String res =  search.runSearch(state,chooseMethod);
        System.out.println(res);


    }

    /**
     * test fourth target
     */
    @Test
    public  void test04(){
        int[][] now = new int[][]{{4,1,3},{7,2,5},{0,8,6}};
        int[][] end = new int[][]{{4,1,3},{0,2,5},{7,8,6}};

       EpuzzleSearch search = new EpuzzleSearch(end);
       EpuzzleState state = new EpuzzleState(now,0,0 );

        String res =  search.runSearch(state,chooseMethod);
        System.out.println(res);


    }




}
