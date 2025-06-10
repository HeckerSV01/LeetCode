public class Codec {
HashMap<String,String> encoded=new HashMap<>();
HashMap<String,String> decoded=new HashMap<>();
String charset="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
Random r=new Random();
public String randomst()
{
    char c[]=new char[6];
    for(int i=0;i<6;i++)
    {
        c[i]=charset.charAt(r.nextInt(62));
    }
    return "http://tinyurl.com/"+String.valueOf(c);
}

    public String encode(String longUrl) {
        if(encoded.containsKey(longUrl))
        {
            return encoded.get(longUrl);
        }
        String code=randomst();
        while(decoded.containsKey(code))
        {
            code=randomst();
        }
        encoded.put(longUrl,code);
        decoded.put(code,longUrl);
        return code;
    }

    public String decode(String shortUrl) {
        return decoded.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));