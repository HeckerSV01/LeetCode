class Solution {
    public int countGoodNumbers(long n) {
        int MOD=1000000007;
        long oddplace;
        long evenplace;
        if(n%2==0)
        {
            evenplace=oddplace=n/2;
        }
        else
        {
            oddplace=n/2;
            evenplace=oddplace+1;
        }
        long result = 1;
        long base = 5;
        long exp = evenplace;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }

        base=4;
        exp=oddplace;
        long temp=1;
        while(exp>0) {
            if((exp&1)==1) temp=(temp*base)%MOD;
            base=(base*base)%MOD;
            exp>>=1;
        }
        result=(result*temp)%MOD;
        return (int)result;
    }
}