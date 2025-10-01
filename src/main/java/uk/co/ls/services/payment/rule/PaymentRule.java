package uk.co.ls.services.payment.rule;

import uk.co.ls.services.payment.models.PaymentDetails;
import uk.co.ls.services.payment.models.PaymentDto;

public interface PaymentRule {

    int getPriorityOrder();

    boolean doesApply(PaymentDetails paymentsDetails);

    PaymentDto apply(PaymentDetails paymentDetails);

}
