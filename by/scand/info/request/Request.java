package by.scand.info.request;

import by.scand.info.model.Tour;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nasgor
 * Date: 02.11.12
 * Time: 23:34
 */
public class Request {
    private static final String REQUEST_URL = "http://hottravel-sbsoft.rhcloud.com/tours";

    public void insert(Tour tour){
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(REQUEST_URL);

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("tour[country]", tour.getCountry()));
            nameValuePairs.add(new BasicNameValuePair("tour[city]", tour.getResort()));
            nameValuePairs.add(new BasicNameValuePair("tour[departure_country]", tour.getDeparture()));
            nameValuePairs.add(new BasicNameValuePair("tour[duration]", tour.getDuration()));
            nameValuePairs.add(new BasicNameValuePair("tour[firm_name]", tour.getFirm().getName()));
            nameValuePairs.add(new BasicNameValuePair("tour[hotel]", tour.getHotel()));
            nameValuePairs.add(new BasicNameValuePair("tour[phones]", tour.getFirm().getPhones()));
            nameValuePairs.add(new BasicNameValuePair("tour[price]", tour.getPrice()));
            //---
            nameValuePairs.add(new BasicNameValuePair("tour[start_date(1i)]", tour.getDate().split(" ")[2]));
            nameValuePairs.add(new BasicNameValuePair("tour[start_date(2i)]", tour.getDate().split(" ")[1]));
            nameValuePairs.add(new BasicNameValuePair("tour[start_date(3i)]", tour.getDate().split(" ")[0]));
            //---

            UrlEncodedFormEntity form;
            form = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            form.setContentEncoding(HTTP.UTF_8);
            httppost.setEntity(form);

            HttpResponse response = httpclient.execute(httppost);
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
    }

    public void removeAll() throws UnsupportedEncodingException {
        int i = 104;

        while(i < 941){
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(REQUEST_URL + "/" + i);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("_method", "delete"));
            nameValuePairs.add(new BasicNameValuePair("authenticity_token", "HTzq23xsX3eeBLZyozVCfIPrYVjM4W77LgeT6PmBHnM="));
            UrlEncodedFormEntity form;
            form = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            form.setContentEncoding(HTTP.UTF_8);
            httppost.setEntity(form);
            try{
                HttpResponse response = httpclient.execute(httppost);
            }catch (Exception e){
                continue;
            }
            i ++;
        }
    }

    public static void main(String[] args) throws IOException {
        int i = 1659;

        while(i < 1715){
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(REQUEST_URL + "/" + i);
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("_method", "delete"));
            nameValuePairs.add(new BasicNameValuePair("authenticity_token", "HTzq23xsX3eeBLZyozVCfIPrYVjM4W77LgeT6PmBHnM="));
            UrlEncodedFormEntity form;
            form = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            form.setContentEncoding(HTTP.UTF_8);
            httppost.setEntity(form);
            try{
                HttpResponse response = httpclient.execute(httppost);
            }catch (Exception e){
                continue;
            }
            i ++;
        }
    }
}
