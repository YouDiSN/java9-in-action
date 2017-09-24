package de.exxcellent.java9.http;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;

public class HttpClientExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        String url = "https://www.baidu.com";
        System.out.println(sendRequestAsync(url));
        System.out.println(sendRequest(url));

        Thread.sleep(999); // Give worker thread some time.
    }

    private static String sendRequest(String url) throws IOException, InterruptedException {
        return HttpClient.newHttpClient()
                .send(
                        HttpRequest.newBuilder(URI.create(url))
                                .GET()
                                .build(),
                        HttpResponse.BodyHandler.asString()
                ).body();
    }

    private static String sendRequestAsync(String url) throws InterruptedException, java.util.concurrent.ExecutionException {
        return HttpClient.newHttpClient()
                .sendAsync(
                        HttpRequest.newBuilder(URI.create(url))
                                .GET()
                                .build(),
                        HttpResponse.BodyHandler.asString()
                )
                .handleAsync((stringHttpResponse, throwable) -> stringHttpResponse.body())
                .get();
    }
}