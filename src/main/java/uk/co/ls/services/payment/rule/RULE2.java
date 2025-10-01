package uk.co.ls.services.payment.rule;

import uk.co.ls.services.payment.models.PaymentDetails;
import uk.co.ls.services.payment.models.PaymentDto;

public class RULE2 implements PaymentRule{
    @Override
    public int getPriorityOrder() {
        return PaymentRuleOrder.RULE_2.getValue();
    }

    @Override
    public boolean doesApply(PaymentDetails paymentsDetails) {
        return false;
    }

    @Override
    public PaymentDto apply(PaymentDetails paymentDetails) {
        //business logic
        return null;
    }
}
