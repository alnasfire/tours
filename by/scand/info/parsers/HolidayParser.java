package by.scand.info.parsers;

import com.sun.jndi.toolkit.url.UrlUtil;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 10/9/12
 * Time: 3:36 PM
 */
public class HolidayParser extends AbstractParser{
    private static final String URL = "http://www.holiday.by/tours/lastminute";

    public static void main(String[] args) throws ParserException {
        NodeList listMain = new NodeList ();
        NodeList listtd = new NodeList ();
        NodeFilter filter = new TagNameFilter("TD");

        Node[] nodes = getNodes(URL);
        for (Node node : nodes){
            if (node.getText().contains("item item-expanded")){
                listMain.add(node);
            }
        }

        for (NodeIterator e = listMain.elements(); e.hasMoreNodes ();)
            e.nextNode().collectInto(listtd, filter);

        for (Node node : listtd.toNodeArray()){
            if (node.getText().length() < 14 || node.getText().equals("td class=\"sorted\""))
                listtd.remove(node);
        }

        for (Node node : listtd.toNodeArray()){
            System.out.println(node.getText());
        }
    }
}
