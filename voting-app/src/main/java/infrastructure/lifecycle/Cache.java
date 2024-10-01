package infrastructure.lifecycle;

import infrastructure.repository.RedisElectionRepository;
import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@Startup
@ApplicationScoped
public class Cache {
    private static final Logger LOGGER = Logger.getLogger(RedisElectionRepository.class);

    public Cache(RedisElectionRepository repository) {
        LOGGER.info("Startup: Cache");
        repository.findAll();
    }
}
