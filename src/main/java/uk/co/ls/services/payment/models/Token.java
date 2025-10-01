package uk.co.ls.services.payment.models;

import com.squareup.moshi.Json;

public class Token {

    @Json(name = "access_token")
    private final String accessToken;

    @Json(name = "issued_at")
    private final Long issuesAtTimeStamp;

    @Json(name = "expires_in")
    private final Long expiresInSeconds;

    @Json(name = "error")
    private final String error;

    public Token(String accessToken, Long issuesAtTimeStamp, Long expiresInSeconds, String error) {
        this.accessToken = accessToken;
        this.issuesAtTimeStamp = issuesAtTimeStamp;
        this.expiresInSeconds = expiresInSeconds;
        this.error = error;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Long getIssuesAtTimeStamp() {
        return issuesAtTimeStamp;
    }

    public Long getExpiresInSeconds() {
        return expiresInSeconds;
    }

    public String getError() {
        return error;
    }
}
