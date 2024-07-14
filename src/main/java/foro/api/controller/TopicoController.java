package foro.api.controller;


import foro.api.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

  @Autowired
  private TopicoRepository topicoRepository;

  @PostMapping
  public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                              UriComponentsBuilder uriComponentsBuilder) {
    Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
    DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
        topico.getCurso());

    URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
    return ResponseEntity.created(url).body(datosRespuestaTopico);

  }

  @GetMapping
  public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 2) Pageable paginacion) {
    return ResponseEntity.ok(topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
  }

  @PutMapping
  @Transactional
  public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
    Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
    topico.actualizarDatos(datosActualizarTopico);
    return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
        topico.getCurso()));
  }

  // DELETE LOGICO
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity eliminarTopico(@PathVariable Long id) {
    Topico topico = topicoRepository.getReferenceById(id);
    topico.desactivarTopico();
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<DatosRespuestaTopico> retornaDatosMedico(@PathVariable Long id) {
    Topico topico = topicoRepository.getReferenceById(id);
    var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
        topico.getCurso());
    return ResponseEntity.ok(datosTopico);
  }

}
