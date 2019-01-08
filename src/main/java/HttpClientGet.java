import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpClientGet {
    public static void main(String[] args) throws IOException {
        HttpGet httpGet = new HttpGet("https://www.google.com.vn/");
        HttpClient client = HttpClients.createDefault();
        HttpResponse httpResponse = client.execute(httpGet);
        System.out.println("Protocol: " + httpResponse.getProtocolVersion());
        System.out.println("Status: " + httpResponse.getStatusLine().toString());
        System.out.println("Content Type: " + httpResponse.getEntity().getContent());
        System.out.println("Locale: " + httpResponse.getLocale());
        System.out.println("Header:");
        for (Header header : httpResponse.getAllHeaders()) {
            System.out.println("     " + header.getName() + ":" + header.getValue());
        }
        System.out.println("Content: ");
        String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
        System.out.println(content);

    }
}
