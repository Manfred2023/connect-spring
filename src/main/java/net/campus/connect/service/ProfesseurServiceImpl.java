package net.campus.connect.service;

import net.campus.connect.model.Professeur;
import net.campus.connect.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    private final ProfesseurRepository repository;

    public ProfesseurServiceImpl(ProfesseurRepository repository) {
        this.repository = repository;
    }

    @Override
    public Professeur save(Professeur professeur) {
        return repository.save(professeur);
    }

    @Override
    public List<Professeur> getAll() {
        return repository.findAll();
    }

    @Override
    public Professeur getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professeur not found with id: " + id));
    }

   /* @Override
    public List<Professeur> getBySpecialite(String specialite) {
        return repository.findBySpecialite(specialite);
    }
*/
   /* @Override
    public List<Professeur> getByGrade(String grade) {
        return repository.findByGrade(grade);
    }*/

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}