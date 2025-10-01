package uk.co.ls.services.payment.api;

import com.squareup.moshi.JsonAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import uk.co.ls.services.payment.client.ThirdPartyClientService;
import uk.co.ls.services.payment.models.ThirdPartyErrorResponse;
import uk.co.ls.services.payment.utility.Timer;

import java.time.Instant;
import java.util.Map;
import java.util.function.Supplier;

public class ThirdPartyInvoker {

    private static final Logger LOG = LoggerFactory.getLogger(ThirdPartyInvoker.class);
    private static final String TOKEN_NOT_EXISTS = "token not exists";
    private static final String MEDIA_TYPE_JSON = "application/json";

    private final ThirdPartyClientService thirdPartyClient;
    private final Timer timer;
    private final Integer retryAttempts;
    private final JsonAdapter<ThirdPartyErrorResponse> responseJsonAdapter;

    public ThirdPartyInvoker(ThirdPartyClientService thirdPartyClient,
                             Supplier<Instant> instantSupplier, Integer retryAttempts,
                             JsonAdapter<ThirdPartyErrorResponse> responseJsonAdapter) {
        this.thirdPartyClient = thirdPartyClient;
        this.timer = new Timer(instantSupplier);
        this.retryAttempts = retryAttempts;
        this.responseJsonAdapter = responseJsonAdapter;
    }

    public String saveQuote(String value, Map<String, String> mdcMap) throws Exception {
        String savedValue;
        mdcMap.forEach(MDC::put);
        try {
            for (int retry = 0; retry <= retryAttempts; retry++) {
                savedValue = attemptToSave(value);
                if (savedValue != null) {
                    return savedValue;
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            LOG.error("message");
            Thread.currentThread().interrupt();
        }
        throw new Exception("Max retries attempt exceedeed");
    }

    private String attemptToSave(String value) {
        return null;
    }
}
