package br.com.fiap.jpa.dao;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.entity.Produto;

public class ProdutoDaoImpl extends GenericDaoImpl<Produto, Integer> implements ProdutoDao{

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
