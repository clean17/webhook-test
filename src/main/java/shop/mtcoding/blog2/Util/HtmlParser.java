package shop.mtcoding.blog2.Util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser {
    
    public static String thumbnailString(String html){
        Document d = Jsoup.parse(html);
        Elements els = d.select("img");
        if ( els.size() == 0 ){
            return  "/images/dora1.png";
        }else{
            String result = els.attr("src");
            return  result;
        }
    }
}
