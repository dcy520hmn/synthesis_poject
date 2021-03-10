package com.dcy.alibaba;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.asynchttpclient.*;
import org.junit.Test;

/**
 *2020-2-25
 * Java Asynchronous non-blocking programming
 */
public class AsyncCall {
    private final static String URL="http://localhost:8080/ioTest";

    /**
     * simple sync Call
     */
    @Test
    public void blockingIO(){
        CloseableHttpClient httpClient;
        try{
            httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(URL);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        //IO blocking in java.net.SocketInputStream#socketRead0
    }

    /**
     * JDK NIO & Future
     */
    @Test
    public void futureBlockingGet(){
        AsyncHttpClient httpClient;
        try {
            httpClient = new DefaultAsyncHttpClient();
            ListenableFuture<Response> future = httpClient.prepareGet(URL).execute();
            Response response = future.get();
            System.out.println(response.getResponseBody());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
