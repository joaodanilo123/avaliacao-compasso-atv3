import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Util {
	
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("cinema");
	
	public static EntityManager recuperarConexao() {
		return FACTORY.createEntityManager();
	}
	
}
