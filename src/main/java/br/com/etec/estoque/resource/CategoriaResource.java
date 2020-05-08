package br.com.etec.estoque.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.etec.estoque.model.Categoria;
import br.com.etec.estoque.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/todas")
	public List<Categoria> listarTodasCategorias() {
		return categoriaService.listarTodasCategorias();
	}

	@GetMapping()
	public Page<Categoria> pesquisar(@RequestParam(required = false,
			defaultValue = "") String nome, Pageable pageable) {
		return categoriaService.pesquisar(nome, pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findCategoria(@PathVariable Integer id) {
		Categoria categoria = categoriaService.findCategoria(id);
		return ResponseEntity.ok().body(categoria);
	}

	@PostMapping()
	public ResponseEntity<Void> insert(Categoria categoria) {
		categoria = categoriaService.insert(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, Categoria categoria) {
		categoria = categoriaService.update(categoria);
		return ResponseEntity.ok().build();
	}

}
