package by.scand.info.parsers;

import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 10/8/12
 * Time: 4:51 PM
 */
public class TuriParser extends AbstractParser{
    private static final String URL = "http://turi.by/hot/";
    public static void main(String[] args){          //TODO nasgor make correct method
        try {
            Node[] nodes = getNodes(URL);
            for (Node node : nodes){
                if (node.getText().contains("a class='link' href='/contacts/'")){
                    for (Node n : node.getChildren().toNodeArray()){
                        if (n.getFirstChild() != null)                           //cost and hotel
                            System.out.println(n.getFirstChild().getText());
                        if (n.getLastChild() != null)                            //cost and resort
                            System.out.println(n.getLastChild().getText());
                    }
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
