package by.scand.info.parsers;

import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 09.10.12
 * Time: 0:07
 */
public class KomarkParser extends AbstractParser {
    private static final String URL = "http://www.komark.by/index/news/7";

    public static void main(String[] args){
        try {
            Node[] nodes = getNodes(URL);
            for (Node node : nodes){
                if (node.getText().contains("strong")){
                    if (node.getLastChild() != null)
                        System.out.println(node.getLastChild().getText());
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
