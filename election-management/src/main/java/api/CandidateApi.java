package api;

import api.dto.in.CreateCandidate;
import api.dto.in.UpdateCandidate;
import api.dto.out.Candidate;
import domain.CandidateService;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;


@ApplicationScoped
public class CandidateApi {
    private final CandidateService service;

    public CandidateApi(CandidateService service) {
        this.service = service;
    }

    public void create(CreateCandidate dto) {
        service.save(dto.toDomain());
    }

    public Candidate update(String id, UpdateCandidate dto) {
        service.save(dto.toDomain(id));
        return Candidate.fromDomain(service.findById(id));
    }

    public List<Candidate> list() {
        return service.findAll().stream().map(Candidate::fromDomain).toList();
    }
}
