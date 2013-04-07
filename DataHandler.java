import java.io.*;

class DataHandler {
	
	private String fileName;
	private String fileData;

	public DataHandler(String fileName){

		this.fileName	= fileName;
	}

	public void setFile(String fileName){

		this.fileName = fileName;

	}

	private String blankFill(String lbl , int sz){

		while(lbl.length() < sz){

			lbl+=" ";

		}
		return lbl;

	}

	public void list(){

		this.fileData = null;
		this.fetchData();

		if(this.fileData!=null){

			String[] rs = this.fileData.split(";");
			System.out.println("| ID |           NOME           |               EMAIL                |");
			System.out.println("+----+--------------------------+------------------------------------+");

			for(int i = 0; i < rs.length; i++){

				String[] s = rs[i].split(",");
				System.out.println("| "+this.blankFill(s[0] , 3)+"| "+this.blankFill(s[1],25)+"| "+this.blankFill(s[2] , 35)+"|");

			}

		} else {

			System.out.println("No data was found.");

		}


	}

	public void importar(String fileName){

		this.fetchData();

		String fileData = this.fileData();

		this.fetchData(fileName+".txt");

		String[] d0 = fileData.split(";");
		String[] d1 = this.fileData.split(";");

		for(int i = 0; i < d0.length; i++){

			String[] 	d0_split 	= d0[i].split(",");

			for(int j = 0; j < d1.length; j++){

				String[]	d1_split	= d1[j].split(",");

				if(Integer.parseInt(d0_split[0])==Integer.parseInt(d1_split[0])){

					System.out.println("id "+d0_split[0]+" ja cadastrado, o que deseja fazer?");

					//leave the loop;
					j = d1.length;

				} else if(d0_split[1].equals[d1_split[1]]){

					System.out.println("nome "+d0_split[1]+" ja cadastrado, o que deseja fazer?");

				} else if(d0_split[2].equals[d1_split[2]]){

					System.out.println("email "+d0_split[1]+" ja cadastrado, o que deseja fazer?");

				} else {

					//add defauls

				}

			}

		}


		this.fetchData();


	}

	public void export(String fileName){

		this.fetchData();
		if(this.fileData!=null){

			try{

				String[] rs = this.fileData.split(";");
				FileWriter outFile = new FileWriter(fileName+".txt" , true);
	  			PrintWriter out = new PrintWriter(outFile);

	  			int i;

	  			for(i = 0; i < rs.length; i++){

					out.println(rs[i]+";");
							
				}

				out.close();

				System.out.println(Integer.toString(i)+" registers were written into "+fileName+".txt");
			
			} catch(IOException x){

				System.out.println(x.getMessage());
				System.out.println("problemas ao exportar arquivo");

			}
			
			

		} else {

			System.out.println("no data was found to export");

		}

	}

	private boolean checkData(int id){

		this.fileData = null;
		this.fetchData();

		if(this.fileData!=null){

			String[] rs = this.fileData.split(";");
			for(int i = 0; i < rs.length; i++){

				String[] s = rs[i].split(",");

				if(Integer.parseInt(s[0] == null ? "0" : s[0])==id){

					this.fileData = this.fileData.replace(rs[i]+";","");
					return true;

				}	

			}

			//System.out.println(this.fileData)

		} else {

			System.out.println("No data was found.");

		}

		return false;

	}

	public void rm(int id){

		if(this.checkData(id)){

			String[] rs = this.fileData.split(";");

			for(int i = 0; i < rs.length; i++){

				this.writeToFile(rs[i]+";" , i == 0 ? false : true);	

			}

			System.out.println("Usuario "+Integer.toString(id)+" encontrado e removido com sucesso!");

		} else {

			System.out.println("Usuario "+Integer.toString(id)+" nao encontrado.");

		}

	}

	public void add(User u){

		if (this.writeToFile(u.getId()==0 ? Integer.toString(this.getLastIndex()+1 : u.getId())+","+u.getNome()+","+u.getEmail()+";")) {

			System.out.println("Usuario "+Integer.toString(this.getLastIndex())+" adicionado com sucesso!");

		} else {

			System.out.println("Nao foi possivel adicionar "+u.getNome());

		}

	}

	public void fetchData(String fileName){

		this.fileData = "";
		
		File file = new File(fileName!=null ? fileName : this.fileName);
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
        String text;
		//pegar os dados do arquivo

         try {

            reader = new BufferedReader(new FileReader(file));

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {


            	//a variavel txt corresponde a cada linha do arquivo
                this.fileData+=text;

            }

        } catch (IOException e) {

            e.printStackTrace();
            this.fileData = null;

        } finally {

            try {

                if (reader != null) {

                    reader.close();

                }

            } catch (IOException e) {

            	this.fileData = null;
                e.printStackTrace();

            }

        }

	}

	public int getLastIndex(){

		this.fileData = "";
		
		File file = new File(fileName!=null ? fileName : this.fileName);
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
        int lastIndex=0;
        String text = "";
		//pegar os dados do arquivo

         try {

            reader = new BufferedReader(new FileReader(file));

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {

            	String[] s = text.split(",");
            	lastIndex = Integer.parseInt(s[0]) > lastIndex ? Integer.parseInt(s[0]) : lastIndex;

            }

            return lastIndex;

        } catch (IOException e) {

            e.printStackTrace();
            this.fileData = null;

        } finally {

            try {

                if (reader != null) {

                    reader.close();

                }

            } catch (IOException e) {

            	this.fileData = null;
                e.printStackTrace();

            }

        }

        return 0;

	}

	public boolean writeToFile(String line){

		return this.writeToFile(line , true);

	}

	public boolean writeToFile(String line , boolean start){

		try {
			
			FileWriter outFile = new FileWriter(this.fileName , start);
  			PrintWriter out = new PrintWriter(outFile);
  			out.println(line);
  			out.close();
			return true;
		
		} catch(IOException x){

			System.out.println(x.getMessage());
			return false;

		}


	}

	public void fetchData(){

		this.fetchData(null);

	}

}