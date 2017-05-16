package nl.ing.wiremock.transformer;

import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.extension.ResponseTransformer;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

/**
 * Created by thage on 16-5-17.
 */
public class ExampleTransformer extends ResponseTransformer {

    @Override
    public Response transform(Request request, Response response, FileSource files, Parameters parameters) {

        return Response.Builder.like(response)
                .but().status(204)
                .build();
    }

    @Override
    public String getName() {
        return "exampleTransformer";
    }
}
