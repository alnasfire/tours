package by.scand.info.heplers;

import by.scand.info.model.Firm;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nasgor
 * Date: 10/3/12
 * Time: 9:25 AM
 */
public class InfoHelper {
    private Node[] nodes;

    public InfoHelper(String url) throws ParserException {
        Parser parser = new Parser(url);
        NodeList list = parser.parse(new AndFilter());
        this.nodes = list.toNodeArray();
    }

    public static void main(String[] args) throws ParserException {
        String url = "http://www.holiday.by/agencies";
        List<String> urls;
        List<String> list;
        InfoHelper helper = null;
        List<List<String>> allUrls = new ArrayList<List<String>>();
        List<List<String>> allWebSites = new ArrayList<List<String>>();
        for (int i = 1; i < 7; i++) {
            if (i == 1)
                helper = new InfoHelper(url);
            else
                helper = new InfoHelper(url + "?p=" + i);
            urls = helper.getFirmsURLs(helper.nodes);
            allUrls.add(urls);
        }

        for (List<String> urlList : allUrls){
            list = helper.getFirmsWebSites(urlList);
            allWebSites.add(list);
        }

//        for(List<String> ls : allWebSites){
//            for(String s : ls){
//                System.out.println(s);
//            }
//        }
    }

    private List<Firm> getFirms(Node[] nodes) {
        List<Firm> firms = new ArrayList<Firm>();
        String name = null;
        String address = null;
        String phones = null;
        for (Node node : nodes) {
            name = getFirmName(node);
            address = getFirmAddress(node);
            phones = getFirmPhones(node);
            if (name != null && address != null && phones != null) {
                firms.add(new Firm(name, phones));
            }
        }
        return firms;
    }

    private List<String> getFirmsWebSites(List<String> urls) throws ParserException {
        List<String> webSites = new ArrayList<String>();
        FirmInfoHelper helper = null;
        String str;
        for (String url : urls) {
            helper = new FirmInfoHelper(url);
            if (!"".equals(str = helper.getFirmWebSite())){
                webSites.add(str);
                System.out.println(str);
            }
        }
        return webSites;
    }

    private List<String> getFirmsURLs(Node[] nodes) {
        List<String> urls = new ArrayList<String>();
        for (Node node : nodes) {
            if (node.getText().indexOf("a class=\"title\"") != -1) {
                urls.add("http://www.holiday.by" + node.getText().split("\"")[3]);
            }
        }
        return urls;
    }

    private String getFirmName(Node node) {
        StringBuilder name = null;
        if (node.getText().indexOf("a class=\"title\"") != -1) {
            if (name == null)
                name = new StringBuilder();
            name.append(node.getFirstChild().getText());
        }
        return new String(name);
    }

    private String getFirmAddress(Node node) {
        StringBuilder adress = null;
        if (node.getText().indexOf("class=\"column3\"") != -1) {//
            if (node.getChildren().elementAt(1) != null && node.getChildren().elementAt(1).getLastChild() != null) {
                if (adress == null)
                    adress = new StringBuilder();
                adress.append(node.getChildren().elementAt(1).getLastChild().getText());
            }
        }
        return new String(adress);
    }

    private String getFirmPhones(Node node) {
        StringBuilder phones = null;
        if (node.getText().indexOf("class=\"list phones\"") != -1) {
            if (phones == null)
                phones = new StringBuilder();
            Node[] nds = node.getChildren().toNodeArray();
            for (Node n : nds) {
                if (n.getLastChild() != null) {
                    Node[] pnd = n.getChildren().toNodeArray();
                    for (Node pn : pnd) {
                        if (pn.getLastChild() != null)
                            phones.append(pn.getLastChild().getText() + ",");
                    }
                }
            }
        }
        return new String(phones);
    }
}