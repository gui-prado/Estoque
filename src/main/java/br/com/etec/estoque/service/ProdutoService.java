package br.com.etec.estoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.etec.estoque.model.Produto;
import br.com.etec.estoque.repository.ProdutoRepository;
import br.com.etec.estoque.service.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listarTodosProdutos() {
		return produtoRepository.findAll();
	}
	
	public Page<Produto> pesquisar(String nome, Pageable pageable) {
		return produtoRepository.findByNomeContaining(nome, pageable);
}

	private Produto find(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrada! Id: " + id + " Tipo: " + Produto.class.getName()));
	}
	
	public Produto insert(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto update(Produto produto) {
		find(produto.getId());
		return produtoRepository.save(produto);
	}

	public void delete(Integer id) {
		find(id);
		produtoRepository.deleteById(id);
	}

	public Produto findProduto(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado!!! Id: " + id + "Tipo: " + Produto.class.getName()));
	}

}