package uk.co.ls.services.payment.rule;

import uk.co.ls.services.payment.models.PaymentDetails;
import uk.co.ls.services.payment.models.PaymentDto;

public class CatchAllRule implements PaymentRule {
    @Override
    public int getPriorityOrder() {
        return PaymentRuleOrder.CATCH_ALL.getValue();
    }

    @Override
    public boolean doesApply(PaymentDetails paymentsDetails) {
        //evaluate conditions
        return false;
    }

    @Override
    public PaymentDto apply(PaymentDetails paymentDetails) {

        //business logic
        return null;
    }
}
