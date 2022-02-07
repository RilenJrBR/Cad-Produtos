package com.example.demo.view.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.demo.model.Produto;

public class AtualizacaoDeEstoqueDTO {
    @NotBlank(message = "O id precisa ser preenchido com valores válidos.")
    @NotEmpty(message = "O id precisa ser preenchido.")
    @NotNull(message = "O id precisa ser um valor válido.")
    private String id;

    @Min(value = 0, message = "A quantidade de estoque deve ser maior do que zero.")
    private int quantidadeEstoque;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public static AtualizacaoDeEstoqueDTO parse(Produto produto) {
        AtualizacaoDeEstoqueDTO dto = new AtualizacaoDeEstoqueDTO();
        dto.setId(produto.getId());
        dto.setQuantidadeEstoque(produto.getQuantidadeEstoque());
        return dto;
    }
}

