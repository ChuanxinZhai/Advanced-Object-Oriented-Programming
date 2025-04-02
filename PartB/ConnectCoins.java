import java.util.ArrayList;       // optional

public class ConnectCoins {

    private final UnionFind uf1;
    private final UnionFind uf2;  // optional
    private final boolean[][] ccMatrix;   // optional
    private final int row;        // optional
    private final int column;     // optional


    /*
     *****  DO NOT CHANGE ANY INSTANCE VARIABLES ABOVE *****
     *****  DO NOT ADD ANY INSTANCE VARIABLES **************
     *****  DO NOT ADD ANY LIBRARIES ******** **************
     *****  VIOLATION = 0 MARKS IN PART B ******************
     */



    /*
     ***** HELPER METHODS START *****
     */

    // Add your own helper methods here
    // INCLUDE your helper methods in your submission !


    //warn!   :  partB must use uf1    by Erick

    //initCoins  初始金币
    private void initCoins() {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (ccMatrix[i][j] & j > 0) {
                    if (ccMatrix[i][j - 1])
                        uf1.union(i * column + j, i * column + j - 1);
                }
                if (ccMatrix[i][j] & i > 0) {
                    if (ccMatrix[i - 1][j])
                        uf1.union(i * column + j, (i - 1) * column + j);
                }
            }
        }
    }

    // temConnCoins 连接金币
    private int tempConnCoins(int i, int j) {
        ArrayList<Integer> heaps = new ArrayList<>();
        int coins = 1;
        if (i - 1 >= 0 && ccMatrix[i - 1][j]) {
            int heap = uf1.find((i - 1) * column + j);
            if (!heaps.contains(heap)) heaps.add(heap);
        }
        if (i + 1 < row && ccMatrix[i + 1][j]) {
            int heap = uf1.find((i + 1) * column + j);
            if (!heaps.contains(heap)) heaps.add(heap);
        }
        if (j - 1 >= 0 && ccMatrix[i][j - 1]) {
            int heap = uf1.find(i * column + j - 1);
            if (!heaps.contains(heap)) heaps.add(heap);
        }
        if (j + 1 < column && ccMatrix[i][j + 1]) {
            int heap = uf1.find(i * column + j + 1);
            if (!heaps.contains(heap)) heaps.add(heap);
        }
        for (int heap : heaps) {
            coins += uf1.sizeOf(heap);
        }
        return coins;

    }

    /*
     ***** HELPER METHODS END *****
     */



    // COURSEWORK 3 PART B.1 Connect Coin CONSTRUCTOR

    /**
     * Initializes the instance variable including a UnionFind data structure.
     *
     * @param ccMatrix is s a 2-D boolean array of true (T) and false (F) values         T means have/ F means empty
     *                 to represent the 2-D space where A T in a coordinate indicates that there is a coin
     *                 at that position in the 2-D space, while an F indicates an empty space
     */
    public ConnectCoins(boolean[][] ccMatrix) {   //矩阵
        this.ccMatrix = ccMatrix;
        row = ccMatrix.length;
        column = ccMatrix[0].length;
        uf1 = new UnionFind(row * column);  //uf1  初始化
        uf2 = null;   //uf2
    }

    // COURSEWORK 3 PART B.2 Connect Coins PLACE MAX CONNECTED COINS

    /**
     * @return a 2-element integer array that represents the coordinate in [row, column],
     * so that a coin that is placed in that coordinate will give the maximum number of newly connected coins.
     * If there are multiple possible such placements, return the left-and-topmost coordinate.
     */

    public int[] placeMaxConnCoins() {       //放金币
        int max = 0;
        int[] place = new int[]{row - 1, column - 1};
        initCoins();
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (!ccMatrix[i][j]) {
                    if (tempConnCoins(i, j) >= max) {
                        max = tempConnCoins(i, j);
                        place[0] = i;
                        place[1] = j;
                    }
                }
            }
        }
        return place;
    }


// COURSEWORK 3 PART B.3 Connect Coins MAX CONNECTED COINS

    /**
     * @return the maximum number of newly connected coins after placing a new coin.
     */

    public int maxConnCoins() {
        int[] bestPlace = placeMaxConnCoins();
        return tempConnCoins(bestPlace[0], bestPlace[1]);

    }

}
