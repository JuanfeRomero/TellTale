package com.telltale.main.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comentario", schema = "telltale")
@EntityListeners(AuditingEntityListener.class)
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_comentario;

    @Column(name = "comentario", nullable = false, columnDefinition = "VARCHAR(255)")
    private String comentario;

    @Column(name = "meGusta", nullable = false, columnDefinition = "INT")
    private Integer meGusta;

    @Column(name = "noMeGusta", nullable = false, columnDefinition = "INT")
    private Integer noMeGusta;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(nullable=false)
    private Historia historia;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDate fechaCreacion;

    @LastModifiedDate
    private LocalDate fechaUltModificacion;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean alta;

}
