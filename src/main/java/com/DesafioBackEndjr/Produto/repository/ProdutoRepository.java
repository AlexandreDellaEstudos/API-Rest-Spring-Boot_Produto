package com.DesafioBackEndjr.Produto.repository;

import com.DesafioBackEndjr.Produto.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    List<ProdutoModel> findAllByOrderByNomeAscPrecoAsc();
}
