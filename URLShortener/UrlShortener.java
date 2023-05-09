import org.json.JSONObject;

import java.util.HashMap;

public class UrlShortener {
    HashMap<String, String> hm = new HashMap<>();
    String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public JSONObject encode(String l) {
        String r = (Math.random() * (999 - 100 + 1) + 100) + "";
        String a = "";
        for (int i = 0, j = 0; i < 7; i++) {
            if (i % 2 == 0) {
                a += A.charAt((int) (Math.random() * A.length()));
            } else {
                a += r.charAt(j);
                j++;
            }
        }
        while (hm.containsKey(r)) {

            r = (Math.random() * (999 - 100 + 1) + 100) + "";
            a = "";
            for (int i = 0, j = 0; i < 7; i++) {
                if (i % 2 == 0)
                    a += A.charAt((int) (Math.random() * A.length()));
                else {
                    a += r.charAt(j);
                    j++;
                }
            }
        }
        hm.put(r, l);
        String shortUrl = "http://short.est/" + r;
        JSONObject json = new JSONObject();
        json.put("short.est", shortUrl);
        return json;
    }

    public JSONObject decode(String s) {
        String[] sarr = s.split("/");
        String o = hm.get(sarr[sarr.length - 1]);
        JSONObject json = new JSONObject();
        json.put("originalUrl", o);
        return json;
    }
}
