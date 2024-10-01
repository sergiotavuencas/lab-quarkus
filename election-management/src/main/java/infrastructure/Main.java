package infrastructure;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.jboss.logging.Logger;

// Executar por IDE não permite utilizar o modo dev, o que atrapalha nos testes
@QuarkusMain
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String... args) {
        LOGGER.info("Running main method");
        Quarkus.run(args);
    }
}
