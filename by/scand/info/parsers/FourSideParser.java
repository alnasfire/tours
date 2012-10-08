package by.scand.info.parsers;

import com.sun.jndi.toolkit.url.UrlUtil;
import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 10/8/12
 * Time: 4:26 PM
 */
public class FourSideParser {
    private static final String URL = "http://www.4cc.by/goryaschie-turi.html";
    public static void main(String[] args){
        try {
            Node[] nodes = AbstractParser.getNodes(URL);
            for (Node node : nodes){

            }
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
