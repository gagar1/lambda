package uk.co.ls.services.payment.config;

import dagger.Component;

import javax.inject.Singleton;

@Component(
        modules = {
                AwsModule.class,
                DynamoDbModule.class,
                MoshiModule.class,
                RestrofitModule.class,
                SecretModule.class,
                SqsModule.class,
                SupplierModule.class
        }
)

@Singleton
public interface Config {

}
