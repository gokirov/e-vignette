package si.modern.toll.jms.consumer;

import io.quarkus.logging.Log;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class NumberPlateConsumer implements Runnable {

    @Inject
    ConnectionFactory connectionFactory;

    private final ExecutorService scheduler = Executors.newSingleThreadExecutor();

    private volatile String lastNumberPlate;

    public String getLastNumberPlate() {
        return lastNumberPlate;
    }

    void onStart(@Observes StartupEvent ev) {
        scheduler.submit(this);
    }

    void onStop(@Observes ShutdownEvent ev) {
        scheduler.shutdown();
    }

    @Override
    public void run() {
        try (JMSContext context = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE)) {
            JMSConsumer consumer = context.createConsumer(context.createQueue("numberPlates"));
            while (true) {
                Message message = consumer.receive();
                if (message == null) return;
                lastNumberPlate = message.getBody(String.class);
                Log.info("lastNumberPlate: %s".formatted(lastNumberPlate));
            }
        } catch (JMSException e) {
            Log.info("NumberPlateConsumer, Error: %s", e);
            throw new RuntimeException(e);
        }
    }
}