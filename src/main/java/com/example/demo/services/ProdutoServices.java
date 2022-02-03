package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServices {

    @Autowired
    private ProdutoRepository repositorio;
    
    public Produto criarProduto(Produto produto){
        return repositorio.save(produto);
    }

    public List<Produto> obterTodos(){
        return repositorio.findAll();
    }

    public Produto atualizar(String id, int quantidadeEstoque){
        Optional<Produto> registro = repositorio.findById(id);

        if(!registro.isEmpty()){
            Produto produto = registro.get();
            produto.setQuantidadeEstoque(quantidadeEstoque);
            return repositorio.save(produto);

        }else{
            return null;
        }
    }

    public Produto obterProduto(String id){
        Optional<Produto> optional = repositorio.findById(id);
        return optional.isEmpty() ? null : optional.get();
    }

    public void deletarProduto(String id){
        repositorio.deleteById(id);
    }
} 
