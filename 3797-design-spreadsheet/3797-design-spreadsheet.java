class Spreadsheet {
HashMap<String,Integer> map;
    public Spreadsheet(int rows) {
        map=new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        map.put(cell,value);
    }
    
    public void resetCell(String cell) {
        map.put(cell,0);
    }
    
    public int getValue(String formula) {
        int idx=-1;
        for(int i=0;i<formula.length();i++)
        {
            if(formula.charAt(i)=='+')
            {
                idx=i;
                break;
            }
        }
        String s1=formula.substring(1,idx);
        String s2=formula.substring(idx+1,formula.length());
        int a=0;
        int b=0;
        if(s1.charAt(0)>='A'&&s1.charAt(0)<='Z')
        {
            a=map.getOrDefault(s1,0);
        }
        else
        {
            a=Integer.parseInt(s1);
        }
        if(s2.charAt(0)>='A'&&s2.charAt(0)<='Z')
        {
            b=map.getOrDefault(s2,0);
        }
        else
        {
            b=Integer.parseInt(s2);
        }
        return a+b;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */