package foro.api.domain.topico;

public record DatosListadoTopico(Long id, String titulo, String mensaje, String curso) {

  public DatosListadoTopico(Topico topico) {
    this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso());
  }
}
