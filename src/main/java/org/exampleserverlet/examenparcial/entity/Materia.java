package org.exampleserverlet.examenparcial.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "materias")
public class Materia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El código es obligatorio")
    @Size(min = 6, max = 6, message = "El código debe tener 6 caracteres")
    @Column(nullable = false, unique = true, length = 6)
    private String codigo;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 5, max = 80, message = "El nombre debe tener entre 5 y 80 caracteres")
    @Column(nullable = false, length = 80)
    private String nombre;

    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "Los créditos deben ser mínimo 1")
    @Max(value = 6, message = "Los créditos deben ser máximo 6")
    @Column(nullable = false)
    private Integer creditos;

    @NotNull(message = "El semestre es obligatorio")
    @Min(value = 1, message = "El semestre debe ser mínimo 1")
    @Max(value = 10, message = "El semestre debe ser máximo 10")
    @Column(nullable = false)
    private Integer semestre;

    @Column(nullable = false)
    private Boolean activa = true;

    public Long getId() { return id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }

    public Integer getSemestre() { return semestre; }
    public void setSemestre(Integer semestre) { this.semestre = semestre; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }
}