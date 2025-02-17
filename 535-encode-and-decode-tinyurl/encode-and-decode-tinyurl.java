public class Codec {

    Map<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longUrl==""){
            return "";
        }
        String strs[] = longUrl.split("/");
        int n = strs.length;

        map.put(strs[n-1],longUrl);

        return strs[n-1];

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        
        if(shortUrl==""){
            return "";
        }

        if(map.containsKey(shortUrl)){
            return map.get(shortUrl);
        }

        return "";

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));