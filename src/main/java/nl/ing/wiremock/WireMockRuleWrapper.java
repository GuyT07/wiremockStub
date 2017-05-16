package nl.ing.wiremock;

import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import nl.ing.wiremock.transformer.ExampleTransformer;
import org.apache.commons.lang.ArrayUtils;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * Created by thage on 16-5-17.
 */
public class WireMockRuleWrapper extends WireMockRule {


//    @Rule
//    public WireMockRule d = new WireMockRule(wireMockConfig().port(8089).extensions(StubResponseTransformerWithRequestBody.class));

    public static WireMockRule wrap(Class<ResponseTransformer>... classes){
        return new WireMockRule(wireMockConfig().port(8089).extensions(allTransformers(classes)));
    }

    private WireMockRuleWrapper(){}

    public static Class[] twilioTransformers(){
        Class[] classes = new Class[]{
                // All twilio transformer classes here
                ExampleTransformer.class

        };
        return classes;
    }

    private static Class[] allTransformers(Class<ResponseTransformer>... classes){
        return (Class[])ArrayUtils.addAll(classes, twilioTransformers());
    }

}
