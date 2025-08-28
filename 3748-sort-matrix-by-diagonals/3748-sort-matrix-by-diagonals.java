class Solution {
    public void sort(int a[][],int i,int j,boolean b,int m)
    {
        int x=i;
        int y=j;
        ArrayList<Integer> list=new ArrayList<>();
        while(x<m&&y<m)
        {
            list.add(a[x][y]);
            x++;
            y++;
        }
        if(b==true)
        {
            Collections.sort(list,Collections.reverseOrder());
        }
        else
        {
            Collections.sort(list);
        }
        x=i;
        y=j;
        int idx=0;
        while(x<m&&y<m)
        {
            a[x][y]=list.get(idx);
            idx++;
            x++;
            y++;
        }
    }
    public int[][] sortMatrix(int[][] grid) {
        int m=grid.length;
        int row=0;
        int col=0;
        for(row=0;row<m;row++)
        {
            sort(grid,row,0,true,m);
        }
        for(col=1;col<m;col++)
        {
            sort(grid,0,col,false,m);
        }
        return grid;
    }
}