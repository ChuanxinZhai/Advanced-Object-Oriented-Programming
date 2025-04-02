import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {

    @Test
    public void testDS_1() {
        UnionFind uf = new UnionFind(4);
        uf.union(1, 0);
        assertTrue(uf.isSameGroup(1, 0));
        assertEquals(2, uf.sizeOf(1));
        assertEquals(0, uf.parent(1));
        assertEquals(-2, uf.parent(0));
        uf.union(3, 2);
        assertFalse(uf.isSameGroup(3, 1));
        uf.union(3, 1);
        assertEquals(2, uf.parent(3));
        assertTrue(uf.isSameGroup(3, 1));
        assertEquals(0, uf.parent(3));
    }

        @Test
        public void testDS_2() {
            UnionFind uf = new UnionFind(19);
            uf.printParent();
            assertEquals(1, uf.sizeOf(16));
            assertFalse(uf.isSameGroup(16, 0));
            for (int i = 1; i <= 15; i += 2)
                uf.union(i + 1, i);
            uf.printParent();
            assertFalse(uf.isSameGroup(0, 16));
            assertTrue(uf.isSameGroup(15, 16));
            assertEquals(1, uf.sizeOf(0));
            assertEquals(2, uf.sizeOf(15));
            assertEquals(2, uf.sizeOf(16));
            for (int i = 1; i <= 15; i += 2)
                uf.union(i + 1, i);
            uf.printParent();
            uf.union(1, 3);
            uf.union(5, 8);
            uf.union(10, 11);
            uf.union(14, 16);
            uf.printParent();
            assertEquals(4, uf.sizeOf(6));
            assertEquals(4, uf.sizeOf(13));
            assertFalse(uf.isSameGroup(1, 8));
            assertFalse(uf.isSameGroup(11, 15));
            uf.union(2, 5);
            uf.union(14, 10);
            assertTrue(uf.isSameGroup(1, 8));
            assertTrue(uf.isSameGroup(11, 15));
            uf.printParent();
            assertEquals(8, uf.sizeOf(2));
            assertEquals(8, uf.sizeOf(10));
            assertEquals(8, uf.sizeOf(7));
            assertEquals(8, uf.sizeOf(3));
            uf.union(8, 7);
            uf.union(14, 12);
            uf.printParent();
            assertFalse(uf.isSameGroup(1, 13));
            uf.union(14, 2);
            assertTrue(uf.isSameGroup(13, 1));
            uf.printParent();
            assertEquals(16, uf.sizeOf(14));
            assertEquals(16, uf.sizeOf(2));
            uf.union(0, 14);
            uf.printParent();
            assertEquals(17, uf.sizeOf(0));
            uf.union(17, 18);
            uf.union(16, 17);
            uf.printParent();
            assertEquals(19, uf.sizeOf(17));
        }
    }



