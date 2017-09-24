package de.exxcellent.java9.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;

public class HttpClientExample {

    /**
     * The HTTP API functions asynchronously &amp; synchronously. In asynchronous mode,
     * work is done on the threads supplied by the client's ExecutorService.
     */
    public static void main(String[] args) throws Exception {
        String response = HttpClient.newHttpClient()
                .send(
                        HttpRequest.newBuilder(URI.create("https://www.baidu.com"))
                                .GET()
                                .build(),
                        HttpResponse.BodyHandler.asString()
                )
                .body();
        System.out.println(response);

        Thread.sleep(999); // Give worker thread some time.
    }
}