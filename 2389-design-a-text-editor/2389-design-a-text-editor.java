class TextEditor {
StringBuilder sb;
int idx;
    public TextEditor() {
        sb=new StringBuilder();
        idx=0;
    }
    
    public void addText(String text) {
        sb.insert(idx,text);
        idx=idx+text.length();
    }
    
    public int deleteText(int k) {
        int del=Math.min(k, idx);
        sb.delete(idx-del, idx);
        idx=idx-del;
        return del;
    }
    
    public String cursorLeft(int k) {
        idx=Math.max(0,idx-k);
        int st=Math.max(0,idx-10);
        return sb.substring(st,idx);
    }
    
    public String cursorRight(int k) {
        idx=Math.min(sb.length(),idx+k);
        int st=Math.max(0,idx-10);
        return sb.substring(st,idx);
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */