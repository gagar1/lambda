package uk.co.ls.services.payment.rule;

public enum PaymentRuleOrder {

    RULE_1(1),
    RULE_2(2),
    RULE_3(3),
    CATCH_ALL(99);

    private final int value;

    PaymentRuleOrder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
