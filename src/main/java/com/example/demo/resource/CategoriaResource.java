package com.example.demo.resource;

        import com.example.demo.event.RecursoCriadoEvent;
        import com.example.demo.model.Categoria;
        import com.example.demo.repository.CategoriaRepository;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.ApplicationEventPublisher;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.security.access.prepost.PreAuthorize;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

        import javax.servlet.http.HttpServletResponse;
        import javax.validation.Valid;
        import java.net.URI;
        import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

   @Autowired
   private ApplicationEventPublisher publisher;
    /*---------------------------------------------------------------------------------------------------*/
    //@CrossOrigin(maxAge = 10, origins = {"http://localhost:8000"}) //permitir com que todas as origens sejam autorizadas[no canso espeficado para port8000] a fazer a chamada do metodo
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    /*---------------------------------------------------------------------------------------------------*/
    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA') and #oauth2.hasScope('write')")
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
        Categoria categoriasalva = categoriaRepository.save(categoria);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriasalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriasalva);

    }
    /*---------------------------------------------------------------------------------------------------*/
    @GetMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA') and #oauth2.hasScope('read')")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        return this.categoriaRepository.findById(codigo)
                .map(categoria -> ResponseEntity.ok(categoria))
                .orElse(ResponseEntity.notFound().build());
    }


}