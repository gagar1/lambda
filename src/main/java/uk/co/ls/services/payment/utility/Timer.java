package uk.co.ls.services.payment.utility;

import org.slf4j.MDC;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class Timer {

    private final Supplier<Instant> instantSupplier;

    public Timer(Supplier<Instant> instantSupplier) {
        this.instantSupplier = instantSupplier;
    }

    public <T> T meansure(String label, Supplier<T> call) {
        Instant start = instantSupplier.get();
        T result;

        try {
            result = call.get();
        } finally {
            Instant finish = instantSupplier.get();

            long duration = Duration.between(start, finish).toMillis();
            MDC.put(label, Long.toString(duration));
        }
        return result;
    }
}
