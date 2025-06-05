package model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "tbl_equipo_dental")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class Equipo_Dental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_equipo")
    private int nroEquipo;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "costo", nullable = false, precision = 10, scale = 2)
    private double costo;

    @Column(name = "fecha_adquisicion", nullable = false, columnDefinition = "CURRENT_TIMESTAMP")
    private LocalDateTime fechaAdquisicion;

    @Column(name = "estado", nullable = false, length = 1)
    @EqualsAndHashCode.Include
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dentista")
    private Dentista dentista;
    
    public Equipo_Dental(String nombre, double costo, LocalDateTime fechaAdquisicion, String estado, Dentista dentista) {
        this.nombre = nombre;
        this.costo = costo;
        this.fechaAdquisicion = fechaAdquisicion;
        this.estado = estado;
        this.dentista = dentista;
    }

}

