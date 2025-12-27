package com.example.produtosapi.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  private ProdutoRepository produtoRepository;

  public ProdutoController(ProdutoRepository produtoRepository) {
    this.produtoRepository = produtoRepository;
  }

  @PostMapping
  public Produto salvar(@RequestBody Produto produto) {
    System.out.println(produto.toString());
    if (produto.getId() == null || produto.getId().isEmpty()) {
      produto.setId(UUID.randomUUID().toString());
    }
    return produtoRepository.save(produto);
  }

  @GetMapping
  public Produto[] listar() {
    return produtoRepository.findAll().toArray(new Produto[0]);
  }

  @GetMapping("/{id}")
  public Produto buscarPorId(@PathVariable("id") String id) {
    return produtoRepository.findById(id).orElse(null);
  }

  @PutMapping("path/{id}")
  public Produto atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {

    Produto produtoExistente = produtoRepository.findById(id).orElse(null);
    if (produtoExistente == null) {
      return null;
    }
    if (produto.getNome() != null) {
      produtoExistente.setNome(produto.getNome());
    }
    if (produto.getDescricao() != null) {
      produtoExistente.setDescricao(produto.getDescricao());
    }
    if (produto.getPreco() != null) {
      produtoExistente.setPreco(produto.getPreco());
    }
    return produtoRepository.save(produtoExistente);
  }

  @DeleteMapping("/{id}")
  public void deletar(@PathVariable("id") String id) {
    produtoRepository.deleteById(id);
  }

}
