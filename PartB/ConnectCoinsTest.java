import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ConnectCoinsTest {

    @Test
    public void givenTestCase() {
        boolean[][] ccMatrix = {{true,  false, true,  true},
                                {true,  false, true,  false},
                                {true,  false, true,  false},
                                {false, true,  false, true},
                                {false, true,  false, true},
                                {true,  false, false, true}};
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 10;
        assertEquals(scores, cc.maxConnCoins());
        int[] pos = {2, 1};
        System.out.println(cc.placeMaxConnCoins()[0]);
        System.out.println(cc.placeMaxConnCoins()[1]);
        assertArrayEquals(pos, cc.placeMaxConnCoins());
    }

    @Test
    public void givenTestCase1() {
        boolean[][] ccMatrix = {{true,  false, true,  true},
                                {true,  false, true,  false}};
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 6;
        assertEquals(scores, cc.maxConnCoins());
        int[] pos = {0, 1};
        System.out.println(cc.placeMaxConnCoins()[0]);
        System.out.println(cc.placeMaxConnCoins()[1]);
        assertArrayEquals(pos, cc.placeMaxConnCoins());
    }

    @Test
    public void givenTestCase2() {
        boolean[][] ccMatrix = {{false}};
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 1;
        assertEquals(scores, cc.maxConnCoins());
        int[] pos = {0, 0};
        System.out.println(cc.placeMaxConnCoins()[0]);
        System.out.println(cc.placeMaxConnCoins()[1]);
        assertArrayEquals(pos, cc.placeMaxConnCoins());
    }

    @Test
    public void givenTestCase3() {
        boolean[][] ccMatrix = {{false,  false, true,  true},
                                {false,  false, true,  false},
                                {false,  false, true,  false},
                                {true, true,  false, true},
                                {false, false,  true, false},
                                {false,  false, true, true}};
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 11;
        assertEquals(scores, cc.maxConnCoins());
        int[] pos = {3, 2};
        System.out.println(cc.placeMaxConnCoins()[0]);
        System.out.println(cc.placeMaxConnCoins()[1]);
        assertArrayEquals(pos, cc.placeMaxConnCoins());
    }

    @Test
    public void givenTestCase4() {
        boolean[][] ccMatrix = {{false,  false, false,  false},
                                {false,  false, false,  false},
                                {false,  false, false,  false},
                                {false,  false, false,  false},
                                {false,  false, false,  false},
                                {false,  false, false,  false}};
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 1;
        assertEquals(scores, cc.maxConnCoins());
        int[] pos = {0, 0};
        System.out.println(cc.placeMaxConnCoins()[0]);
        System.out.println(cc.placeMaxConnCoins()[1]);
        assertArrayEquals(pos, cc.placeMaxConnCoins());
    }

    @Test
    public void givenTestCase5() {
        boolean[][] ccMatrix = {{true,  true, true,  true},
                                {true,  true, true,  true},
                                {true,  true, true,  true},
                                {true,  true, true,  true},
                                {true,  true, false,  true},
                                {true,  true, true,  true}};
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 24;
        assertEquals(scores, cc.maxConnCoins());
        int[] pos = {4, 2};
        System.out.println(cc.placeMaxConnCoins()[0]);
        System.out.println(cc.placeMaxConnCoins()[1]);
        assertArrayEquals(pos, cc.placeMaxConnCoins());
    }

    @Test
    public void givenTestCase6() {
        boolean[][] ccMatrix = {{true,  false},
                                {false,  false}};
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 2;
        assertEquals(scores, cc.maxConnCoins());
        int[] pos = {0, 1};
        System.out.println(cc.placeMaxConnCoins()[0]);
        System.out.println(cc.placeMaxConnCoins()[1]);
        assertArrayEquals(pos, cc.placeMaxConnCoins());
    }

    @Test
    public void givenTestCase7() {
        boolean[][] ccMatrix = new boolean[1000][1000];
        for (int i = 0; i < 1000; i++){
            for (int k = 0; k < 999; k++){
                ccMatrix[i][k] = false;
            }
            ccMatrix[i][999] = true;
        }
        ConnectCoins cc = new ConnectCoins(ccMatrix);
        int scores = 1001;
        int[] location = {0, 998};
        assertEquals(scores, cc.maxConnCoins());
        assertArrayEquals(location, cc.placeMaxConnCoins());
    }

}

