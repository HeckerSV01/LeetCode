class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int firstidx[]=new int[26];
        int lastidx[]=new int[26];
        Arrays.fill(firstidx,-1);
        Arrays.fill(lastidx,-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(firstidx[c-'a']==-1){
                firstidx[c-'a']=i;
            }else{
                lastidx[c-'a']=i;
            }
        }
        for(int i=0;i<26;i++){
            if(firstidx[i]!=-1&&lastidx[i]==-1){
                lastidx[i]=firstidx[i];
            }
        }
        List<Character> list=new ArrayList<>();
        for(char c='a';c<='z';c++){
            if(firstidx[c-'a']!=-1){
                list.add(c);
            }
        }
        List<int[]> intervals=new ArrayList<>();
        for(char c:list){
            int l=firstidx[c-'a'];
            int r=lastidx[c-'a'];
            boolean valid=true;
            for(int k=l;k<=r;k++){
                if(firstidx[s.charAt(k)-'a']<l){
                    valid=false;
                    break;
                }
                r=Math.max(r,lastidx[s.charAt(k)-'a']);
            }
            if(valid){
                intervals.add(new int[]{l,r});
            }
        }
        List<String> res=new ArrayList<>();
        List<int[]> taken=new ArrayList<>();
        Collections.sort(intervals,(a,b)->(a[1]-a[0])-(b[1]-b[0]));
        for (int curr[] : intervals) {
            int l = curr[0];
            int r = curr[1];
            boolean overlap = false;
            for (int[] prev : taken) {
                int pl = prev[0];
                int pr = prev[1];
                if (!(r < pl || l > pr)) {
                    overlap = true;
                    break;
                }
            }
            if (!overlap) {
                taken.add(curr);
                res.add(s.substring(l, r + 1));
            }
        }
        return res;
    }
}