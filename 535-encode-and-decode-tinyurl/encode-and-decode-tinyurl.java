public class Codec {

    String base= "http://tinyurl.com/";
    Map<String,String> encodeMap = new HashMap<>();
    Map<String,String> decodeMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        
        if(encodeMap.containsKey(longUrl)){
            return encodeMap.get(longUrl);
        }

        //else
        String shortUrl = base+String.valueOf(encodeMap.size());
        encodeMap.put(longUrl,shortUrl);
        decodeMap.put(shortUrl,longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));