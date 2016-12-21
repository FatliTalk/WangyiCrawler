import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Liqq on 2016/12/9.
 * 网络爬虫，爬取挖段子网的段子。
 */
public class Test {
    public static void main(String[] args) throws IOException{    //psvm_main方法快捷键
        //1.请求Dom文档（网络请求）
        Document document = Jsoup.connect("http://www.waduanzi.com/page/1").get();
        //2.Dom解析（编写元素选择器，类似jQuery选择器；选择元素）
        String selector = "div[class=panel panel20 post-item post-box]>div[class=item-detail]>div[class=item-content]";
        Elements contents = document.select(selector);
        for(org.jsoup.nodes.Element element:contents){
            System.out.println(element.text());   //快捷键sout，回车即可
        }
    }
}
