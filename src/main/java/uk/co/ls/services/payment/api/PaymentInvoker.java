package uk.co.ls.services.payment.api;

import uk.co.ls.services.payment.client.RetrofitClientService;
import uk.co.ls.services.payment.models.PaymentSearchResponse;
import uk.co.ls.services.payment.utility.Timer;

import javax.inject.Inject;

import java.time.Instant;
import java.util.function.Supplier;

public class PaymentInvoker {

    private final RetrofitClientService retrofitClientService;
    private final Timer timer;

    @Inject
    public PaymentInvoker(RetrofitClientService retrofitClientService, Supplier<Instant> instantSupplier) {
        this.retrofitClientService = retrofitClientService;
        this.timer = new Timer(instantSupplier);
    }

    public PaymentSearchResponse searchPayment() {
        return timer.meansure(
                "paymentSearchDuration",
                () -> {
                    try {
                        return new PaymentSearchResponse();
                    } catch (Exception e) {
                    }
                    return new PaymentSearchResponse();
                });
    }
}
