package model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_dentista")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dentista")
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "cop", nullable = false, length = 6)
    private String cop;

    @Column(name = "nombre_completo", nullable = false, length = 50)
    private String nombreCompleto;

    @Column(name = "fecha_inicio_contrato", nullable = false)
    private Date fechaInicioContrato;

    @Column(name = "turno", nullable = false, length = 1)
    private String turno;

    @Column(name = "correo", nullable = false, length = 50, unique = true)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidad especialidad;
    
    @Override
	public String toString() {
		return nombreCompleto;
	}
}
