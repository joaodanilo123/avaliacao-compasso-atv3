import java.util.List;

import javax.persistence.EntityManager;

public class FilmeController implements AutoCloseable{
	
	private EntityManager entityManager;
	private FilmeDAO filmeDao;
	
	public FilmeController() {
		this.entityManager = Util.recuperarConexao();
		this.filmeDao = new FilmeDAO(entityManager);
		
		entityManager.getTransaction().begin();
		this.filmeDao.limparTabela();
		entityManager.getTransaction().commit();
		entityManager.clear();
		
	}
	
	public void cadastrar(Filme filme) {
		entityManager.getTransaction().begin();
		filmeDao.cadastrar(filme);
		entityManager.getTransaction().commit();
		entityManager.clear();
	}
	
	public List<Filme> listarFilmes(int pagina, int quantidade){
		return filmeDao.listarComPaginacao(pagina, quantidade);
	}
	
	@Override
	public void close() throws Exception {
		entityManager.close();
	}
	
}
