package foro.api.domain.topico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String mensaje;
  private String curso;

  private Boolean activo;


  public Topico(DatosRegistroTopico datosRegistroTopico) {
    this.activo = true;
    this.titulo = datosRegistroTopico.titulo();
    this.mensaje = datosRegistroTopico.mensaje();
    this.curso = datosRegistroTopico.curso();
  }

  public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
    if (datosActualizarTopico.titulo() != null) {
      this.titulo = datosActualizarTopico.titulo();
    }
    if (datosActualizarTopico.mensaje() != null) {
      this.mensaje = datosActualizarTopico.mensaje();
    }
    if (datosActualizarTopico.curso() != null) {
      this.mensaje = datosActualizarTopico.curso();
    }
  }

  public void desactivarTopico() {
    this.activo = false;
  }
}

