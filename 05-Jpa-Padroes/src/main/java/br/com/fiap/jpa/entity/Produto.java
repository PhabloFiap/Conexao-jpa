package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_JAVA_PRODUTO")
@SequenceGenerator(name="invs",
sequenceName ="Sq_JAVA_PRODUTO", allocationSize = 1)


public class Produto {

	@Id
	@Column(name="id_Produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invs")
	private Integer id_produto;
	
	@Column (name="nm_produto", nullable =false, length = 40)
	private String nome_produto;
	
	@Column (name ="nm_descricao", nullable = false, length = 30)
	private String descricao_produto;
	
	@Column (name ="vl_preco", nullable = false, length = 30)
	private Integer preco;

	public Produto() {
		super();
	}



	public Produto(String nome_produto, String descricao_produto, Integer preco) {
		super();
		this.nome_produto = nome_produto;
		this.descricao_produto = descricao_produto;
		this.preco = preco;
	}



	public Integer getPreco() {
		return preco;
	}



	public void setPreco(Integer preco) {
		this.preco = preco;
	}



	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_produto() {
		return nome_produto;
	}

	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	public String getDescricao_produto() {
		return descricao_produto;
	}

	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}
	
	
	
}
