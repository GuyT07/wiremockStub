package nl.ing.wiremock;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import nl.ing.wiremock.transformer.ExampleTransformer;
import org.junit.Rule;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.util.function.Function;

/**
 * Created by thage on 16-5-17.
 */
public class ExampleTest {


    @Rule
    public WireMockRule d = WireMockRuleWrapper.wrap();

    @Test
    public void test2(){
        TwilioCall c = new TwilioCall();
        c.doIt();
    }

    @Test
    public void test(){

        Response response = invokeClient("http://localhost:8089/some/thing", r->r.get());

        System.out.println(response.getStatus());
    }



    private Response invokeClient(String url, Function<Invocation.Builder, Response> f){
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);

        Invocation.Builder invocationBuilder =  webTarget.request();
        Response response = f.apply(invocationBuilder);
        return response;
    }

}
