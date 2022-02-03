package com.example.demo.view.controllers;

import java.util.List;

import com.example.demo.model.Produto;
import com.example.demo.services.ProdutoServices;
import com.example.demo.view.model.AtualizacaoDeEstoqueDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoServices servico;
    
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto produtoCreiado = servico.criarProduto(produto);
        return new ResponseEntity<>(produtoCreiado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> obterTodps(){
        List<Produto> produto = servico.obterTodos();
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @PutMapping("/{id}{quantidadeEstoque}")
    public ResponseEntity<Produto> atualizarEstoque(@PathVariable String id, @PathVariable int quantidadeEstoque){
        Produto produto = servico.atualizar(id, quantidadeEstoque);

        if(produto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(produto, HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<Produto> atualizarEstoque(@RequestBody AtualizacaoDeEstoqueDTO dto){
        return new ResponseEntity<>(servico.atualizar(dto.getId(), dto.getQuantidadeEstoque()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> obterProduto(@PathVariable String id){
        return new ResponseEntity<>(servico.obterProduto(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProduto(@PathVariable String id){
        servico.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
