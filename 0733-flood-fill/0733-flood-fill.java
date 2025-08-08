class Solution {
    public void dfs(int vis[][],int image[][],int i,int j,int st,int color)
    {
        vis[i][j]=1;
        image[i][j]=color;
        int row=0;
        int col=0;
        row=i-1;
        col=j;
        if(row>=0&&row<image.length&&image[row][col]==st&&vis[row][col]==0)
        {
            image[row][col]=color;
            dfs(vis,image,row,col,st,color);
        }
        row=i+1;
        col=j;
        if(row>=0&&row<image.length&&image[row][col]==st&&vis[row][col]==0)
        {
            image[row][col]=color;
            dfs(vis,image,row,col,st,color);
        }
        row=i;
        col=j-1;
        if(col>=0&&col<image[0].length&&image[row][col]==st&&vis[row][col]==0)
        {
            image[row][col]=color;
            dfs(vis,image,row,col,st,color);
        }
        row=i;
        col=j+1;
        if(col>=0&&col<image[0].length&&image[row][col]==st&&vis[row][col]==0)
        {
            image[row][col]=color;
            dfs(vis,image,row,col,st,color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int vis[][]=new int[image.length][image[0].length];
        dfs(vis,image,sr,sc,image[sr][sc],color);
        return image;
    }
}