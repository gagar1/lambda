package uk.co.ls.services.payment.models;

public enum PaymentStatus {
    APPLIED("Applied"),
    UNAPPLIED("Unapplied");

    private final String payStatus;

    PaymentStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatus() {
        return payStatus;
    }
}
