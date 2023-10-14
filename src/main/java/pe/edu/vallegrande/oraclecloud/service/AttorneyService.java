package pe.edu.vallegrande.oraclecloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.oraclecloud.model.entity.Attorney;
import pe.edu.vallegrande.oraclecloud.repository.AttorneyRepository;

@Service
@RequiredArgsConstructor
public class AttorneyService {
    private final AttorneyRepository AttorneyRepository;

    public List<Attorney> findAll() {
        return AttorneyRepository.findAllByStatus("A");
    }

    public Attorney save(Attorney person) {
        return AttorneyRepository.save(person);
    }

    public Optional<Attorney> findById(Long id) {
        return AttorneyRepository.findById(id);
    }

    @Transactional
    public Optional<Attorney> inactive(Long id) {
    	AttorneyRepository.inactiveAttorney(id);
        return AttorneyRepository.findById(id);
    }

    @Transactional
    public Optional<Attorney> active(Long id) {
    	AttorneyRepository.activeAttorney(id);
        return AttorneyRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
    	AttorneyRepository.deleteAttorney(id);
    }

}
