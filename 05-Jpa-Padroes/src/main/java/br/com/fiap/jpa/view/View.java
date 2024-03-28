package br.com.fiap.jpa.view;

import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.InvestimentoDao;
import br.com.fiap.jpa.dao.InvestimentoDaoImpl;
import br.com.fiap.jpa.dao.ProdutoDao;
import br.com.fiap.jpa.dao.ProdutoDaoImpl;
import br.com.fiap.jpa.entity.Investimento;
import br.com.fiap.jpa.entity.Produto;
import br.com.fiap.jpa.entity.TipoInvestimento;
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
		InvestimentoDao dao = new InvestimentoDaoImpl(em);
		
		//Instanciar um investimento (implementar um construtor na classe)
		
		Produto produto = new Produto( "TV Tranquila", "CAAALMA", 500);
		Produto produto2 = new Produto( "Celular calminho", "TRANQUILO", 1900);
		
		Investimento investimento = new Investimento("CDB TranquiloCoin", 1000001.0, TipoInvestimento.CRIPTO);
		
		//cadastrar (CREATE -> INSERT)
		try {
			dao.salvar(investimento);
			dao.commit();
			System.out.println("Investimento cadastrado!");
		}catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
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
		
		try {
			//Pesquisar (READ -> SELECT)
			Investimento busca = dao.buscar(1);
			System.out.println(busca.getNome());
		
			//Atualizar um investimento (UPDATE -> UPDATE)
			busca.setValor(5000000.0);
			dao.salvar(busca);
			dao.commit();
			System.out.println("Investimento atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		} catch (IdNaoEncontradoException e) {
			System.out.println(e.getMessage());
		}
		/*
		//remover um investimento (DELETE -> DELETE)
		try {
			dao.remover(2);
			dao.commit();
			System.out.println("Investimento removido!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
	}	
}