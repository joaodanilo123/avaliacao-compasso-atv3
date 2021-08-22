import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class FilmeDAO {
	
	private EntityManager entityManager;
	
	public FilmeDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Filme> listarComPaginacao(int pagina, int quantidade) {
		
		int listarApartirDe = (int) (pagina-1)*quantidade;
		
		String jpql = "SELECT f FROM Filme AS f";
		return entityManager.createQuery(jpql, Filme.class)
			.setFirstResult(listarApartirDe)
			.setMaxResults(quantidade)
			.getResultList();
	}
	
	public void cadastrar(Filme filme) {
		entityManager.persist(filme);
	}
	
	public void limparTabela() {
		entityManager.createQuery("DELETE FROM Filme").executeUpdate();
	}
	
	
}
