package by.scand.info.parsers;

import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 08.10.12
 * Time: 23:43
 */
public class GudauriParser extends AbstractParser{
    private static final String URL = "http://www.gudauritours.com/specialnie-predlojeniya-akcii.html";

    public static void main (String[] args){
        try {
            Node[] nodes = getNodes(URL);
            for (Node node : nodes){

            }
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
