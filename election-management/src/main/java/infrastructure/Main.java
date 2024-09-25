package infrastructure;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

// Executar por IDE não permite utilizar o modo dev, o que atrapalha nos testes
@QuarkusMain
public class Main {

    public static void main(String... args) {
        Quarkus.run(args);
    }
}
