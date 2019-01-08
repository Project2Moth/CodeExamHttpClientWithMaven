import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.io.IOException;

public class FluentGet {
    public static void main(String[] args) throws IOException {
        Response response = Request.Get("https://www.google.com.vn/").execute();
        HttpResponse httpResponse = response.returnResponse();
        System.out.println("Protocol: " + httpResponse.getProtocolVersion());
        System.out.println("Status: " + httpResponse.getStatusLine().getStatusCode());
        System.out.println("Content Type: " + httpResponse.getEntity().getContent());
        System.out.println("Locale: " + httpResponse.getLocale());
        System.out.println("Header: ");
        for (Header header : httpResponse.getAllHeaders()) {
            System.out.println("    " + header.getName() + ":" + header.getValue());
        }
        System.out.println("Content: ");
        String content = IOUtils.toString(httpResponse.getEntity().getContent(),"UTF-8");
        System.out.println(content);
    }
}
