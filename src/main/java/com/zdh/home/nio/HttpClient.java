package com.zdh.home.nio;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class HttpClient {


    public static void main(String[] args) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder("http://localhost:8801/");
        List<NameValuePair> list = new LinkedList<>();
        BasicNameValuePair param1 = new BasicNameValuePair("key", "value");

        list.add(param1);
        CloseableHttpClient httpClient = HttpClients.createDefault();

        uriBuilder.setParameters(list);
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.addHeader("X-Requested-With", "XMLHttpRequest");
        HttpResponse httpResponse = httpClient.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        HttpEntity entity = httpResponse.getEntity();
    }
}
