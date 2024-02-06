package com.DesafioBackEndjr.Produto.controller;

import com.DesafioBackEndjr.Produto.dto.ProdutoDTO;
import com.DesafioBackEndjr.Produto.model.ProdutoModel;
import com.DesafioBackEndjr.Produto.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody @Valid ProdutoDTO produtoEntradaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.criarProduto(produtoEntradaDTO));
    }

    @GetMapping
    @Transactional
    public ResponseEntity<List<ProdutoModel>> buscarTodosProdutos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarTodosProdutos());
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> buscaUmProduto(@PathVariable Long id) {
        var retornoBanco = produtoService.buscaUmProduto(id);
        if (retornoBanco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrando nenhum registro com esse ID");
        }
        return ResponseEntity.status(HttpStatus.OK).body(retornoBanco);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletaUmProduto(@PathVariable Long id) {
             produtoService.deletaUmProduto(id);
            return ResponseEntity.noContent().build();
    }

}
