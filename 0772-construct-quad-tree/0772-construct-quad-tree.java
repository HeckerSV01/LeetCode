/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public boolean checksame(int a[][],int x,int y,int width)
    {
        int val=a[x][y];
        for(int i=x;i<x+width;i++)
        {
            for(int j=y;j<y+width;j++)
            {
                if(a[i][j]!=val)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public Node build(int a[][],int i,int j,int width)
    {
        if(checksame(a,i,j,width))
        {
            return new Node(a[i][j]==1?true:false,true);
        }
        Node root=new Node(true,false);
        root.topLeft=build(a,i,j,width/2);
        root.topRight=build(a,i,j+width/2,width/2);
        root.bottomLeft=build(a,i+width/2,j,width/2);
        root.bottomRight=build(a,i+width/2,j+width/2,width/2);
        return root;
    }
    public Node construct(int[][] grid) {
        return build(grid,0,0,grid.length);
    }
}