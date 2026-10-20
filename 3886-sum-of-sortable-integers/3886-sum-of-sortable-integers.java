class Solution {
    private boolean check(int a1[],int a2[],int n){
        int len=a1.length;
        for(int i=0;i<len/n;i++){
            int st=i*n;
            int count=0;
            int idx=-1;
            for(int j=0;j<n-1;j++){
                if(a1[st+j]>a1[st+j+1]){
                    count++;
                    idx=j;
                    if(count>1){
                        return false;
                    }
                }
            }
            if(count==0){
                for(int j=0;j<n;j++){
                    if(a1[st+j]!=a2[st+j]){
                        return false;
                    }
                }
            }else if(count==1){
                for(int j=0;j<n;j++){
                    if(a1[st+(idx+1+j)%n]!=a2[st+j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int res=0;
        int  arr[]=nums.clone();
        Arrays.sort(arr);
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
                if(check(nums,arr,i)){
                    res=res+i;
                }
                if(i!=n/i){
                if(check(nums,arr,n/i)){
                    res=res+n/i;
                }
            }  
        }
        }
        return res;
    }
}