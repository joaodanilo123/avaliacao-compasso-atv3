import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		try(FilmeController fc = new FilmeController()){
		
			Filme f1 = new Filme("Sherek 1", "Sherek filme hd", 2001);
			Filme f2 = new Filme("Sherek 2", "Sherek filme hd", 2002);
			Filme f3 = new Filme("Sherek 3", "Sherek filme hd", 2003);
			Filme f4 = new Filme("Sherek 4", "Sherek filme hd", 2004);
			Filme f5 = new Filme("Sherek 5", "Sherek filme hd", 2005);
			Filme f6 = new Filme("Sherek 6", "Sherek filme hd", 2006);
			Filme f7 = new Filme("Sherek 7", "Sherek filme hd", 2007);
			Filme f8 = new Filme("Sherek 8", "Sherek filme hd", 2008);
			Filme f9 = new Filme("Sherek 9", "Sherek filme hd", 2009);
			Filme f10 = new Filme("Sherek 10", "Sherek filme hd", 2010);
			Filme f11 = new Filme("Sherek 11", "Sherek filme hd", 2011);
			Filme f12 = new Filme("Sherek 12", "Sherek filme hd", 2012);
			Filme f13 = new Filme("Sherek 13", "Sherek filme hd", 2013);
			Filme f14 = new Filme("Sherek 14", "Sherek filme hd", 2014);
			Filme f15 = new Filme("Sherek 15", "Sherek filme hd", 2015);
			Filme f16 = new Filme("Sherek 16", "Sherek filme hd", 2016);
			Filme f17 = new Filme("Sherek 17", "Sherek filme hd", 2017);
			Filme f18 = new Filme("Sherek 18", "Sherek filme hd", 2018);
			Filme f19 = new Filme("Sherek 19", "Sherek filme hd", 2019);
			Filme f20 = new Filme("Sherek 20", "Sherek filme hd", 2020);
			
			fc.cadastrar(f1);
			fc.cadastrar(f2);
			fc.cadastrar(f3);
			fc.cadastrar(f4);
			fc.cadastrar(f5);
			fc.cadastrar(f6);
			fc.cadastrar(f7);
			fc.cadastrar(f8);
			fc.cadastrar(f9);
			fc.cadastrar(f10);
			fc.cadastrar(f11);
			fc.cadastrar(f12);
			fc.cadastrar(f13);
			fc.cadastrar(f14);
			fc.cadastrar(f15);
			fc.cadastrar(f16);
			fc.cadastrar(f17);
			fc.cadastrar(f18);
			fc.cadastrar(f19);
			fc.cadastrar(f20);
			
			System.out.println("\n\n\n PAGINAÇÃO DE FILMES");
	        System.out.println("-Este projeto foi configurado para MySQL;");
	        System.out.println("-Configure as credenciais do banco de dados no Arquivo src/main/resources/META-INF/persistence.xml;");
	        System.out.println("-Crie um banco de dados no MySQL chamado \"cinema\" ( CREATE DATABASE cinema ); \n\n\n");
	        System.out.println("-Digite 0 a qualquer momento para sair da aplicação. \n\n");
			
			boolean rodar = true;
	
			try(Scanner scanner = new Scanner(System.in)){
			
				while(rodar) {
					
					System.out.println("Digite qual página deseja acessar");
					int pagina = scanner.nextInt();
					System.out.println("Digite quantos registros quer mostrar por página");
					int quantidade = scanner.nextInt();
					
					if(pagina < 0 || quantidade < 0) {
						System.out.println("Entrada inválida");
						continue;
					}
				
					if(pagina == 0 || quantidade == 0) {
						System.out.println("Saindo da aplicação...");
						rodar = false;
						break;
					}
					
					List<Filme> filmes = fc.listarFilmes(pagina, quantidade);
					
					for (Filme filme : filmes) {
						System.out.println(
							String.format(
								"%s, %s, %d", 
								filme.getNome(), 
								filme.getDescricao(), 
								filme.getAno()
							)
						);
					}
					
					System.out.println("\n");
					
				}
			
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
