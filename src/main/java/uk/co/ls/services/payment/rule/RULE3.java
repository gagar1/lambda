package uk.co.ls.services.payment.rule;

import uk.co.ls.services.payment.models.PaymentDetails;
import uk.co.ls.services.payment.models.PaymentDto;

public class RULE3 implements PaymentRule{
    @Override
    public int getPriorityOrder() {
        return PaymentRuleOrder.RULE_3.getValue();
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
