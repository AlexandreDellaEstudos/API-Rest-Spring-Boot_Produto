package com.DesafioBackEndjr.Produto.service;

import com.DesafioBackEndjr.Produto.dto.ProdutoDTO;
import com.DesafioBackEndjr.Produto.model.ProdutoModel;
import com.DesafioBackEndjr.Produto.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoDTO produtoDTO) {
        var produtoModel = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO, produtoModel);
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listarTodosProdutos() {
        return produtoRepository.findAllByOrderByNomeAscPrecoAsc();
    }

    public Optional<ProdutoModel> buscaUmProduto(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletaUmProduto(Long id) {
        produtoRepository.deleteById(id);
    }

}
