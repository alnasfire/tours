package by.scand.info.parsers;

import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.util.ParserException;


/**
 * User: nasgor
 * Date: 10/8/12
 * Time: 3:51 PM
 */
public abstract class AbstractParser {
    public static Node[] getNodes(String url) throws ParserException {
        Parser parser = new Parser(url);
        return parser.parse(new AndFilter()).toNodeArray();
    }
}
