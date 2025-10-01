package uk.co.ls.services.payment.client;

import com.squareup.moshi.JsonReader;
import retrofit2.Call;
import retrofit2.http.*;
import uk.co.ls.services.payment.models.CreatePaymentRequest;
import uk.co.ls.services.payment.models.ThirdPartyResponse;
import uk.co.ls.services.payment.models.Token;

public interface ThirdPartyClientService {

    String ACCEPT = "Accept: application/json:v=1";
    String AUTHORIZATION = "Authorization";
    String REQUEST_ID = "Request-Id";
    String CLIENT_CORELLATION_ID = "Client-Correlation-Id";
    String CHANNEL_TYPE = "Chanel-Type";
    String CONTENT_TYPE_APPLICATION_JSON = "Content-Type: application/json";
    String SAVE_QUOTE_URI = "qouteURI";
    String CONTENT_TYPE_APPLICATION_JSON_X_WWW_FORM_URLENCODED = "Content-Type: application/x-ww-form-urlencoded";
    String OAUAT2_TOKEN_URI = "/oauth2/token";


    @POST(SAVE_QUOTE_URI)
    @Headers({ACCEPT, CONTENT_TYPE_APPLICATION_JSON})
    Call<ThirdPartyResponse> saveQuote(
            @Header(AUTHORIZATION) String authorization,
            @Body CreatePaymentRequest createPaymentRequest);

    @FormUrlEncoded
    @POST(OAUAT2_TOKEN_URI)
    @Headers({CONTENT_TYPE_APPLICATION_JSON_X_WWW_FORM_URLENCODED})
    Call<Token> postToken(
            @Header(REQUEST_ID) String requestId,
            @Header(CLIENT_CORELLATION_ID) String clientCorrelationId,
            @Header(CHANNEL_TYPE) String channelType,
            @Header(AUTHORIZATION) String authorization,
            @Body CreatePaymentRequest createPaymentRequest);
}
