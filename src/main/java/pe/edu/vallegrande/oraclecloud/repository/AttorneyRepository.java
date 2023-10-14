package pe.edu.vallegrande.oraclecloud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import pe.edu.vallegrande.oraclecloud.model.entity.Attorney;

public interface AttorneyRepository extends JpaRepository<Attorney, Long> {

    List<Attorney> findAllByStatus(String status);

    @Modifying
    @Query("update Attorney a set a.status = 'I' where a.id = ?1")
    void inactiveAttorney(Long id);

    @Modifying
    @Query("update Attorney a set a.status = 'A' where a.id = ?1")
    void activeAttorney(Long id);

    @Modifying
    @Query("delete from Attorney a where a.id = ?1")
    void deleteAttorney(Long id);
}
