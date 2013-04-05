import java.io.*;

class Application {

	private DataHandler dh = new DataHandler("users.txt" , "tmp.txt");
	String helper;
	
	public static void main(String[] asas){

		Application a = new Application();

	}

	public Application (){

		this.showMenu();

	}	

	public void showMenu(){

			System.out.println("Bem Vindos a UsersControl");
			System.out.println("Por favor selecione uma opcao");
			System.out.println("1 - Adicionar");
			System.out.println("2 - Listar");
			System.out.println("3 - Remover");
			System.out.println("4 - Exportar");
			System.out.println("5 - Importar");

			int option = Integer.parseInt(this.getUserInput());

			if(option==1){

				this.adicionar();

			} else if(option==2) {

				this.listar();

			} else if(option==3){

				this.remover();

			} else if(option==4){

				this.exportar();

			} else if(option==5){

				this.importar();

			}


			//trampo do gustavo

	}

	public void adicionar(){
			System.out.println(dh.getLastIndex());
			System.out.println("Digite o nome do usuario: ");
			String nome=this.getUserInput();
			System.out.println("Digite o email: ");
			String email=this.getUserInput();
			User u=new User(0, nome,email);
			this.dh.add(u);
			System.out.println("Pressione uma tecla para continuar...");
			helper = this.getUserInput();
			this.showMenu();
	}

	public void listar(){

			this.dh.list();
			System.out.println("Pressione uma tecla para continuar...");
			helper = this.getUserInput();
			this.showMenu();
			//trampo do paulo
	}

	public void remover(){

			//trampo do felipe
	}

	public void exportar(){

			//trampo do felipe
	}

	public void importar(){

			//trampo do felipe
	}

	private String getUserInput(){

		String inputLine = null;

		try {

			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			inputLine = bf.readLine();
			
			if(inputLine.length() != 0){

				try{

					return inputLine;

				} catch (Exception e){

					System.out.println("Falha ao converter dado para inteiro");

				}
				

			}

		} catch(IOException e) {

			System.out.println("Algum pane ao ler o que voce escreveu");

		}

		return null;

		//trampo do livro de java

	}

}