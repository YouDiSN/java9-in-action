package de.exxcellent.java9.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Random;

public class InputStreamExample {

    private static final String JSON_PATH = "/Users/xiwang/Documents/java9-in-action/playground/src/main/resource/package1/test.json";

    /**
     * Stream utilities.
     */
    public static void main(String[] args) throws IOException {
        // 128 random bytes
        byte[] buf = new byte[128];
        new Random().nextBytes(buf);
        byte[] result = new ByteArrayInputStream(buf).readAllBytes();
//         Directly redirect an InputStream to an OutputStream
        new ByteArrayInputStream(result).transferTo(System.out);

        // All bytes from an InputStream at once
        byte[] fileByte = Files.readAllBytes(FileSystems.getDefault().getPath(JSON_PATH));
        String json = new String(fileByte, "UTF-8");
        System.out.println(json);
    }

}