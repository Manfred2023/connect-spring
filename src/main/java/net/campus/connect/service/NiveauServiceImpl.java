package net.campus.connect.service;

import net.campus.connect.model.Niveau;
import net.campus.connect.repository.EtudiantRepository;
import net.campus.connect.repository.NiveauRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauServiceImpl implements NiveauService{

    private final NiveauRepository repository;

    public NiveauServiceImpl(NiveauRepository repository) {
        this.repository = repository;
    }


    @Override
    public Niveau save(Niveau niveau) {
        return repository.save(niveau);
    }

    @Override
    public List<Niveau> getAll() {
        return repository.findAll();
    }
}
