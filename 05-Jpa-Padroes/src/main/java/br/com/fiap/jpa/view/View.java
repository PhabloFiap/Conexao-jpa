package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ProdutoDao;
import br.com.fiap.jpa.dao.ProdutoDaoImpl;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNaoEncontradoException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class View {

	public static void main(String[] args) {
		//Obter o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		//Instanciar o DAO do investimento
		//GenericDao<Investimento, Integer> dao = new GenericDaoImpl<Investimento, Integer>(em) {};
		
		ProdutoDao  daoProd = new ProdutoDaoImpl(em);
	
		
		//Instanciar um investimento (implementar um construtor na classe)
		
		Produto produto = new Produto( "TV Tranquila", "CAAALMA", 500);
		Produto produto2 = new Produto( "Celular calminho", "TRANQUILO", 1900);
		
	
		
	
	
		
		try {
			daoProd.salvar(produto2);
			daoProd.commit();
			System.out.println("Produto cadastrado!");
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Produto buscar = daoProd.buscar(2);
			System.out.print(buscar.getNome_produto());
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	
	}	
}