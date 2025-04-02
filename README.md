# Advanced-Object-Oriented-Programming

Java programming

### Part A: Union Find with Path Compression

You will have to implement the following methods to complete the data structure:

1.   public UnionFind(int N) creates a Union Find data structure with N elements: 0 through N-1.   Initially, each element is in its own group.

2.   public void validate(int p) checks whether p is a valid element.   It throws an IllegalArgumentException if p is not a valid index.

3.   public int sizeOf(int p) returns the size of the group the element p belongs to.

4.  public int find(int p) returns the group identity number which is the root of the tree element p belongs to.  Assume p is a valid element.  The path compression operation is applied in this method to reduce the finding root's running time.  Note that now, the given method public boolean isSameGroup(int p, int q) is then implemented by simply calling validate on p and q, and then checking whether find(p) is the same as find(q).

5.  public void union(int p, int q) connects two elements p and q together, by combining the groups containing them, connecting the root of the smaller size tree to the root of the larger size tree.  If the sizes of the trees are equal, break the tie by connecting p's root to q's root.  It throws an IllegalArgumentException if p or q is not a valid index.





### Part B: Connect Coins
 
Complete a skeleton code of the ConnectCoins class in order to figure out where to place a coin to maximally connect them, and how many coins can be maximally connected.

1.       public ConnectCoins(boolean[ ][ ] ccMatrix).  Each ConnectCoins instance is bound to a single 2-D space, which is passed in through its constructor.       You may assume this space is valid, i.e., there is at least one empty coordinate to place a new coin.

2.       public int[ ] placeMaxConnCoins().   The method returns a 2-element integer array that represents the coordinate in [row, column] so that a coin that is placed in that coordinate will give the maximum number of newly connected coins.  If there are multiple possible such placements, return the upper-leftmost coordinate.

3.       public int maxConnCoins( ).  The method returns the maximum number of newly connected coins after placing a new coin.


Test case 1

Input ccMatrix = [[T, F, T, T], [T, F, T, F], [T, F, T, F], [F, T, F, T], [F, T, F, T], [T, F, F, T]]

Output of placeMaxConnCoins = [2, 1]

Output of maxConnCoins = 10

![image](https://github.com/user-attachments/assets/50b2378a-bc79-47c6-be8b-e07a6aef77f5)

Explanation:

Placing a coin at coordinate [2, 1] will connect 10 coins, which is the maximum number of newly connected coins in this instance of the game.

Placing a coin at coordinate [3, 2] will also connect 10 coins, but the upper-leftmost coordinate with the same score must be returned instead.


