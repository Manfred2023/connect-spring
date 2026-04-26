package net.campus.connect.service;

import net.campus.connect.model.GroupeType;
import net.campus.connect.repository.GroupeTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GroupeTypeServiceImpl implements GroupeTypeService{

    private final GroupeTypeRepository repository;

    public GroupeTypeServiceImpl(GroupeTypeRepository repository) {
        this.repository = repository;
    }
    @Override
    public GroupeType create(GroupeType groupeType) {

        repository.findByCode(groupeType.getCode())
                .ifPresent(gt -> {
                    throw new RuntimeException("Code déjà utilisé");
                });

        repository.findByLabel(groupeType.getLabel())
                .ifPresent(gt -> {
                    throw new RuntimeException("Label déjà utilisé");
                });

        return repository.save(groupeType);

    }

    @Override
    public GroupeType update(Integer id, GroupeType groupeType) {
        GroupeType existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("GroupeType introuvable"));

        existing.setLabel(groupeType.getLabel());
        existing.setCode(groupeType.getCode());
        existing.setDescription(groupeType.getDescription());

        return repository.save(existing);
    }

    @Override
    public void delete(Integer id) {
        GroupeType existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("GroupeType introuvable"));

        repository.delete(existing);
    }

    @Override
    public GroupeType getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("GroupeType introuvable"));
    }

    @Override
    public List<GroupeType> getAll() {
        return repository.findAll();
    }
}
