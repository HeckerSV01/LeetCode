class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int prev=0;
        for(int i=0;i<version1.length();i++){
            if(version1.charAt(i)=='.'){
                l1.add(Integer.parseInt(version1.substring(prev,i)));
                prev=i+1;
            }
        }
        l1.add(Integer.parseInt(version1.substring(prev,version1.length())));
        prev=0;
        for(int i=0;i<version2.length();i++){
            if(version2.charAt(i)=='.'){
                l2.add(Integer.parseInt(version2.substring(prev,i)));
                prev=i+1;
            }
        }
        l2.add(Integer.parseInt(version2.substring(prev,version2.length())));
        int i=0;
        int j=0;
        while(i<l1.size()||j<l2.size()){
            int a=(i<l1.size())?l1.get(i):0;
            int b=(j<l2.size())?l2.get(j):0;
            if(a<b){
                return -1;
            }else if(a>b){
                return 1;
            }else{
                i++;
                j++;
            }
        }
        return 0;
    }
}