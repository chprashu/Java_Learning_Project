package learn.configurations.commonBeans;

import jakarta.persistence.EntityManagerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

@Configuration
@Slf4j
public class TransactionManagerLogging {

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory factory){
        return new JpaTransactionManager(factory){
            @Override
            protected void doBegin(Object transaction, TransactionDefinition definition){
                super.doBegin(transaction, definition);
                log.debug("Txn logger --> new Transaction started, with Propagation Behavior: {} and Name: {}", definition.getPropagationBehavior(), definition.getName());
            }

            @Override
            protected void doCommit(DefaultTransactionStatus status){
                super.doCommit(status);
                log.debug("Txn logger --> Transaction COMMITTED, Name: {}", status.getTransactionName());
            }

            @Override
            protected void doRollback(DefaultTransactionStatus status){
                super.doRollback(status);
                log.debug("Txn logger --> Transaction ROLLBACK, name: {}", status.getTransactionName());
            }

        };
    }
}
