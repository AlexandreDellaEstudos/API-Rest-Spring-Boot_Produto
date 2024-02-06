package com.DesafioBackEndjr.Produto.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProdutoDTO(

        @NotBlank(message = "O Nome do Produto não pode ser nulo")
        @Size(min = 3, max = 120, message = "O Nome do Produto precisar ter entre 3 até 120 caracteres")
        String nome,
        @NotBlank(message = "A Descrição do Produto não pode ser nula")
        @Size(min = 3, max = 255, message = "A descrição do Produto precisar ter entre 3 até 255 caracteres")
        String descricao,
        @NotNull (message = "O Valor do Produto não pode ser nulo")
        @DecimalMin(value = "0.01", message = "O Valor tem que ser maior que 0.00")
        BigDecimal preco,
        @NotNull(message = "A Quantidade de Produto no Estoque não pode ser Nulo")
        @Min(value = 1, message = "A Quantidade de Produto no Estoque não pode ser igual a zero ou negativo")
        Integer quantidadeEstoque) {
}
