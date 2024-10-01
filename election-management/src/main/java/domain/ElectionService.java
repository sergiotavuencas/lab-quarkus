package domain;

import domain.annotations.Principal;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import java.util.List;

@ApplicationScoped
public class ElectionService {
    private final Instance<ElectionRepository> repositories;
    private final CandidateService candidateService;
    private final ElectionRepository repository;

    public ElectionService(@Any Instance<ElectionRepository> repositories,
                           CandidateService candidateService,
                           @Principal ElectionRepository repository) {
        this.repositories = repositories;
        this.candidateService = candidateService;
        this.repository = repository;
    }

    public List<Election> findALl() {
        return repository.findAll();
    }

    public void submit() {
        Election election = Election.create(candidateService.findAll());
        repositories.forEach(repository -> repository.submit(election));
    }
}
