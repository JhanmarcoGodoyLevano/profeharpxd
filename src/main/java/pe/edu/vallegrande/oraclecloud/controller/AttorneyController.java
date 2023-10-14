package pe.edu.vallegrande.oraclecloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.oraclecloud.model.entity.Attorney;
import pe.edu.vallegrande.oraclecloud.service.AttorneyService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/attorney")
public class AttorneyController {

    private final AttorneyService AttorneyService;

    @GetMapping
    public ResponseEntity<List<Attorney>> findAll() {
        return ResponseEntity.ok(AttorneyService.findAll());
    }

    @PostMapping
    public ResponseEntity<Attorney> save(@RequestBody Attorney attorney) {
        return ResponseEntity.ok(AttorneyService.save(attorney));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Attorney>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(AttorneyService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    	AttorneyService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<Optional<Attorney>> inactive(@PathVariable Long id) {
        return ResponseEntity.ok(AttorneyService.inactive(id));
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<Optional<Attorney>> active(@PathVariable Long id) {
        return ResponseEntity.ok(AttorneyService.active(id));
    }

}
