package uk.co.ls.services.payment.models;

public class ThirdPartyResponse {
    Integer id;
    String text;
    String devText;

    public ThirdPartyResponse(Integer id, String text, String devText) {
        this.id = id;
        this.text = text;
        this.devText = devText;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getDevText() {
        return devText;
    }
}
