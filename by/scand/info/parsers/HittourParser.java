package by.scand.info.parsers;

import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 08.10.12
 * Time: 23:52
 */
public class HittourParser extends AbstractParser {
    private static final String URL = "http://hittour.by/specialnye-predlozheniya/";

    public static void main(String[] args){
        try {
            Node[] nodes = getNodes(URL);
            for(Node node : nodes){
                if (node.getText().contains("tr") && node.getChildren() != null && node.getChildren().size() == 13)
                    for (Node n : node.getChildren().toNodeArray()){
                        if (n.getLastChild() != null)
                            System.out.println(n.getLastChild().getText());
                    }
//                    System.out.println(node.getChildren().size());
            }
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
