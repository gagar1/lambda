package uk.co.ls.services.payment.config;

import dagger.Module;
import dagger.Provides;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.services.lambda.LambdaClient;

import javax.inject.Named;
import javax.inject.Singleton;
import java.net.URI;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Module
public class AwsModule {

    @Singleton
    @Provides
    public LambdaClient lambdaClient(@Named("lambdaEndpoint") URI lamdaEndpoint, SdkHttpClient sdkHttpClient) {
        return LambdaClient.builder().endpointOverride(lamdaEndpoint).httpClient(sdkHttpClient).build();
    }

    @Singleton
    @Provides
    public SdkHttpClient providesHttpClient(@Named("connectTimeOut") Integer connectTimeOut,
                                            @Named("readTimeOut") Integer readTimeOut) {
        return UrlConnectionHttpClient.builder()
                .connectionTimeout(Duration.of(connectTimeOut, ChronoUnit.MILLIS))
                .socketTimeout(Duration.of(readTimeOut, ChronoUnit.MILLIS))
                .build();
    }
}
