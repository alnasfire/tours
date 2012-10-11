package by.scand.info.heplers;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 * User: nasgor
 * Date: 10/4/12
 * Time: 12:30 PM
 */
public class FirmInfoHelper {
    private  Node[] nodes;
    private String url;
    public FirmInfoHelper(String url) throws ParserException {
        Parser parser = new Parser(url);
        this.url = url;
        NodeList list = parser.parse(new AndFilter());
        this.nodes = list.toNodeArray();
    }

    public String getFirmWebSite() throws ParserException {
        int i = 0;
        for(Node node : this.nodes){
            if (node.getText().indexOf(url.split("/")[4]) != -1 || node.getText().startsWith("http://")){
                i ++;
                if ((node.getText().startsWith("http://") || i == 8) && node.getText().length() < 40)
                    return node.getText();
            }
        }
        return "";
    }

    public static void main(String[] args) throws ParserException {
        String url = "http://www.holiday.by/agencies/parallel";
        FirmInfoHelper helper = new FirmInfoHelper(url);
        System.out.println(helper.getFirmWebSite());
    }
}