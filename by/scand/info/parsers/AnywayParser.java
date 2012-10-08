package by.scand.info.parsers;

import org.htmlparser.Node;
import org.htmlparser.util.ParserException;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nasgor
 * Date: 08.10.12
 * Time: 23:28
 */
public class AnywayParser extends AbstractParser {
    private static final String URL = "http://anyway.by/";

    public static void main(String[] args){               //TODO nasgor parse subpages to get info
        AnywayParser parser = new AnywayParser();
        parser.getHotTourRefs();
    }

    private List<String> getHotTourRefs(){
        List<String> refs = new ArrayList<String>();
        try {
            Node[] nodes = getNodes(URL);
            for (Node node : nodes){
                if (node.getText().contains("class=\"latestnews\"") && node.getText().length() > 40){
                    refs.add(URL.substring(0, URL.length() - 2) + node.getText().split("\"")[1]);
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return refs;
    }
}
