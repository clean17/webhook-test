package shop.mtcoding.blog2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class HtmlParser {

    
    @Test
    public void ddd_test() throws Exception{
    
        String html = "<p>3<img src=\"data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAAMCAgMCAgMDAwMEAwMEBQgFBQQEB\">";
        Document d = Jsoup.parse(html);
        Elements els = d.select("img");
        if ( els.size() == 0 ){
            // 임시
        }else{
            String result = els.attr("src");
            System.out.println("테스트 : "+ result);
        }
    }
}