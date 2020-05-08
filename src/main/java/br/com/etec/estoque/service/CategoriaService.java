package br.com.etec.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.etec.estoque.model.Categoria;
import br.com.etec.estoque.repository.CategoriaRepository;
import br.com.etec.estoque.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listarTodasCategorias() {
		return categoriaRepository.findAll();
	}
	
	public Page<Categoria> pesquisar(String nome, Pageable pageable) {
		return categoriaRepository.findByNomeContaining(nome, pageable);
}

	private Categoria find(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada! Id: " + id + " Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public Categoria update(Categoria categoria) {
		find(categoria.getId());
		return categoriaRepository.save(categoria);
	}

	public void delete(Integer id) {
		find(id);
		categoriaRepository.deleteById(id);
	}

	public Categoria findCategoria(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!!! Id: " + id + "Tipo: " + Categoria.class.getName()));
	}

}
