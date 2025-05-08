class Solution {
    public String convert(int num)
    {
        String ones[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String tens[]={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String hundreds[]={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String res="";
        if(num>99)
        {
            res=res+ones[num/100]+" Hundred ";
        }
        num=num%100;
        if(num<20&&num>9)
        {
            res=res+tens[num%10]+" ";
        }
        else
        {
            if(num>19)
            {
                res=res+hundreds[num/10]+" ";
            }
            num=num%10;
            if(num>0)
            {
                res=res+ones[num]+" ";
            }
        }
        return res;
    }
    public String numberToWords(int num) {
        String large[]={"Thousand","Million","Billion"};
        if(num==0)
        {
            return "Zero";
        }
        String res="";
        res=convert(num%1000);
        num=num/1000;
        if(num>0&&num%1000>0)
        {
            res=convert(num%1000)+"Thousand "+res;
        }
        num=num/1000;
        if(num>0&&num%1000>0)
        {
            res=convert(num%1000)+"Million "+res;
        }
        num=num/1000;
        if(num>0)
        {
            res=convert(num%1000)+"Billion "+res;
        }
        return res.trim();
    }
}