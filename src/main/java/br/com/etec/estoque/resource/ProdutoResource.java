package br.com.etec.estoque.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.estoque.model.Produto;
import br.com.etec.estoque.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/todos")
	public List<Produto> listarTodosProdutos() {
		return produtoService.listarTodosProdutos();
	}
	
	@GetMapping()
	public Page<Produto> pesquisar(@RequestParam(required = false, defaultValue = "")String nome, Pageable pageable) {
		return produtoService.pesquisar(nome, pageable);
	}
}
