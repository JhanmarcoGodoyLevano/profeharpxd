package pe.edu.vallegrande.oraclecloud.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "attorney")
public class Attorney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "names")
    private String Names;

    @Column(name = "last_names")
    private String lastNames;

    @Column(name = "document_type")
    private String document_type;

    @Column(name = "email")
    private String email;

    @Column(name = "document_number")
    private String document_number;

    @Column(name = "cell_phone")
    private String cell_phone;

    @Column(name = "status")
    private String status;

}
