import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Liqq on 2016/12/9.
 * 网络爬虫，爬取新闻。
 */
public class WangyiCrawler {
    public static void main(String[] args) throws IOException{    //psvm_main方法快捷键
        //1.请求Dom文档（网络请求）
        Document document = Jsoup.connect("http://news.sohu.com/guoneixinwen_11142.shtml").get();
        //2.Dom解析（编写元素选择器，类似jQuery选择器；选择元素）
        String selector = "div[class=article-list]>div[class=article]>h3>a";
        Elements titles = document.select(selector);
        for(org.jsoup.nodes.Element title:titles){
            System.out.println(title.text());   //快捷键sout，回车即可
            //再次请求a标签，获取新闻内容
            String url = title.absUrl("href");
            Document document1 = Jsoup.connect(url).get();
            System.out.println(document1.select("#contentText").text());
        }
    }
}
