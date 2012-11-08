package by.scand.info.parsers;

import by.scand.info.model.Firm;
import by.scand.info.model.Tour;
import by.scand.info.request.Request;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.ArrayList;
import java.util.List;

/**
 * User: nasgor
 * Date: 10/9/12
 * Time: 3:36 PM
 */
public class HolidayParser extends AbstractParser {
    private static final String URL = "http://www.holiday.by/tours/lastminute";

    public static void main(String[] args) throws ParserException {
        List<Tour> tours = new ArrayList<Tour>();
        NodeList listMain = new NodeList();
        NodeList listtd = new NodeList();
        NodeFilter filter = new TagNameFilter("TR");
        Request request = new Request();
        for (int i = 1; i < 4; i++) {
            Node[] nodes;
            if (i == 1)
                nodes = getNodes(URL);
            else
                nodes = getNodes(URL + "?p=" + i);

            for (Node node : nodes) {
                if (node.getText().contains("item item-collapsed")) {
                    listMain.add(node);
                }
            }

            for (NodeIterator e = listMain.elements(); e.hasMoreNodes(); )
                e.nextNode().collectInto(listtd, filter);

            for (Node node : listtd.toNodeArray()) {
                if (node.getText().length() > 3)
                    listtd.remove(node);
            }

            for (Node node : listtd.toNodeArray()) {
                Tour tour = new Tour();
                for (Node n : node.getChildren().toNodeArray()) {
                    if (n.getText().contains("class=\"place\"")) {
                        for (Node ns : n.getChildren().toNodeArray()) {
                            if (ns.getText().contains("country") && ns.getChildren() != null && ns.getChildren().elementAt(1).getLastChild().getLastChild() != null) {
//                                System.out.println("country = " + ns.getChildren().elementAt(1).getLastChild().getLastChild().getText());//country
                                tour.setCountry(ns.getChildren().elementAt(1).getLastChild().getLastChild().getText());
                            }
                            if (ns.getText().contains("resort") && ns.getChildren() != null) {
//                                System.out.println("resort =" + ns.getChildren().elementAt(1).getLastChild().getText());//resort
                                tour.setResort(ns.getChildren().elementAt(1).getLastChild().getText());
                            }
                            if (ns.getText().contains("hotel") && ns.getChildren() != null && ns.getChildren().elementAt(0).getLastChild() != null) {
//                                System.out.println("hotel = " + ns.getChildren().elementAt(0).getLastChild().getText());//hotel
                                tour.setHotel(ns.getChildren().elementAt(0).getLastChild().getText());
                            }
                            if (ns.getText().contains("departure")) {
//                                System.out.println("вылет " + ns.getLastChild().getText());//departure
                                tour.setDeparture(ns.getLastChild().getText());
                            }
                        }
                    } else if (n.getText().contains("class=\"price\"")) {
                        for (Node ns : n.getChildren().toNodeArray()) {
                            if (ns.getChildren() != null && ns.getChildren().elementAt(0).getLastChild() != null) {
//                                System.out.print("price = " + ns.getChildren().elementAt(0).getChildren().elementAt(1).getText());//price
//                                System.out.println(ns.getChildren().elementAt(0).getLastChild().getText()); //curency
                                tour.setPrice(convertPrice(ns.getChildren().elementAt(0).getChildren().elementAt(1).getText()));
                            }
                        }
                    } else if (n.getText().contains("class=\"date sorted\"")) {
                        for (Node ns : n.getChildren().toNodeArray()) {
                            if (ns.getChildren() != null && ns.getChildren().elementAt(1) != null && !"br/".equals(ns.getChildren().elementAt(1).getText())) {
//                                System.out.println("date = " + ns.getChildren().elementAt(1).getText());   //date
                                tour.setDate(convertDate(ns.getChildren().elementAt(1).getText()));
                            } else if (ns.getText().contains("note") && ns.getChildren() != null && ns.getChildren().elementAt(0) != null) {
//                                System.out.println("days = " + ns.getChildren().elementAt(0).getText().trim().substring(0, 15).trim());   //days
                                tour.setDuration(ns.getChildren().elementAt(0).getText().trim().substring(0, 15).trim());
                            }
                        }
                    } else if (n.getText().contains("class=\"partner\"")) {
                        for (Node ns : n.getChildren().toNodeArray()) {
                            Firm firm = new Firm();
                            if (ns.getChildren() != null) {
//                                System.out.println("firm name = " + ns.getChildren().elementAt(1).getLastChild().getLastChild().getText()); // firm name
                                firm.setName(ns.getChildren().elementAt(1).getLastChild().getLastChild().getText());
                            }
                            if (ns.getChildren() != null && ns.getChildren().elementAt(3).getText().contains("class=\"list phones\"")) {//
                                StringBuilder phones = new StringBuilder();
                                for (Node nst : ns.getChildren().elementAt(3).getChildren().toNodeArray()) {  //phones
                                    if (nst.getLastChild() != null) {
//                                        System.out.println(nst.getLastChild().getChildren().elementAt(0).getText());
                                        phones.append(nst.getLastChild().getChildren().elementAt(0).getText() + " ");
                                    }
                                }
                                firm.setPhones(new String(phones));
                            }
                            if (firm != null && !firm.getName().equals("") && !firm.getPhones().equals("")){
                                tour.setFirm(firm);
                            }
                        }
//                        System.out.println("==========================");
                    }
                }
                if (tour.getFirm() != null && !tour.getResort().equals("") && !tour.getHotel().equals("") && !tour.getFirm().getPhones().equals("")){
                    tours.add(tour);
//                        System.out.println(tour);
                }
            }
        }
        for (Tour tour : tours){
            request.insert(tour);
        }
    }

    private static String convertDate(String date){
        if (date.contains("янв")){
            return date.split(" ")[0] + " " + 1 + " " + date.split(" ")[2];
        } else if (date.contains("фев")){
            return date.split(" ")[0] + " " + 2 + " " + date.split(" ")[2];
        } else if (date.contains("мар")){
            return date.split(" ")[0] + " " + 3 + " " + date.split(" ")[2];
        } else if (date.contains("апр")){
            return date.split(" ")[0] + " " + 4 + " " + date.split(" ")[2];
        } else if (date.contains("май") || date.contains("мая")){
            return date.split(" ")[0] + " " + 5 + " " + date.split(" ")[2];
        } else if (date.contains("июн")){
            return date.split(" ")[0] + " " + 6 + " " + date.split(" ")[2];
        } else if (date.contains("июл")){
            return date.split(" ")[0] + " " + 7 + " " + date.split(" ")[2];
        } else if (date.contains("авг")){
            return date.split(" ")[0] + " " + 8 + " " + date.split(" ")[2];
        } else if (date.contains("сен")){
            return date.split(" ")[0] + " " + 9 + " " + date.split(" ")[2];
        } else if (date.contains("окт")){
            return date.split(" ")[0] + " " + 10 + " " + date.split(" ")[2];
        } else if (date.contains("ноя")){
            return date.split(" ")[0] + " " + 11 + " " + date.split(" ")[2];
        } else if (date.contains("дек")){
            return date.split(" ")[0] + " " + 12 + " " + date.split(" ")[2];
        }
        return date;
    }

    private static String convertPrice(String price){
        if (price.split(" ").length > 1)
            return price.split(" ")[0]+price.split(" ")[1];
        return price;
    }
}
