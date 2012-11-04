package by.scand.info.problem;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import javax.print.DocFlavor;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nasgor
 * Date: 02.11.12
 * Time: 23:34
 */
public class Request {
    private static final String REQUEST_URL = "http://hottravel-sbsoft.rhcloud.com/tours";
//    private static String country = "Египет";
    private static String country = "Egypt";
//    private static String resort = "Хургада";
    private static String resort = "Hurgada";
//    private static String departure = "Киев";
private static String departure = "Kiev";
    private static String price = "380 USD";
    private static String date = "7 ноября 2012";
    private static String duration = "7";
//    private static String firm_name = "Коллекция путешествий";
    private static String phones = "+375 (17) 334-88-48, +375 (29) 388-45-44, +375 (44) 589-33-01,+375 (33) 364-88-48";

    public static void main(String[] args) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(REQUEST_URL);

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("utf8", "%E2%9C%93"));
            nameValuePairs.add(new BasicNameValuePair("authenticity_token", "6c7CK0bfrnRSBWe8dipdrZt6Zobx%2Fxt0V8fmzOqkh%2FQ%3D"));
            nameValuePairs.add(new BasicNameValuePair("tour[country]", country));
            nameValuePairs.add(new BasicNameValuePair("tour[city]", resort));
            nameValuePairs.add(new BasicNameValuePair("tour[departure_country]", departure));
            nameValuePairs.add(new BasicNameValuePair("tour[duration]", duration));
//            nameValuePairs.add(new BasicNameValuePair("tour[firm_name]", firm_name));
            nameValuePairs.add(new BasicNameValuePair("tour[hotel]", ""));
            nameValuePairs.add(new BasicNameValuePair("tour[phones]", phones));
            nameValuePairs.add(new BasicNameValuePair("tour[price]", price));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpclient.execute(httppost);

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
    }
}
