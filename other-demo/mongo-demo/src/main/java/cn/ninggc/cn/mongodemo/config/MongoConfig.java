package cn.ninggc.cn.mongodemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;


/**
 * @description: TODO
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/5/15 9:44
 * @version:v1.0
 */
@Configuration
public class MongoConfig {

    @Bean
    public TransactionManager MongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
        return new MongoTransactionManager(mongoDatabaseFactory) {

            @Override
            protected Object doGetTransaction() throws TransactionException {
                return super.doGetTransaction();
            }

            @Override
            protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
                super.doBegin(transaction, definition);
            }

            @Override
            protected void doCommit(MongoTransactionObject transactionObject) throws Exception {
                super.doCommit(transactionObject);
            }

            @Override
            protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
                super.doRollback(status);
            }
        };
    }

}
