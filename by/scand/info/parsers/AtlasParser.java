package by.scand.info.parsers;

import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 10/8/12
 * Time: 3:51 PM
 */
public class AtlasParser extends AbstractParser{
    private static final String URL = "http://www.atlasmira.by/hottour.php";
    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Node[] nodes = AbstractParser.getNodes(URL);
            for (Node node : nodes){
                if (node.getText().contains("#FFFFFF")){
                    for (Node n : node.getChildren().toNodeArray()){
                        stringBuilder.append(n.getText() + "    ");
                    }
                    System.out.println(new String(stringBuilder));
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
    }
}
