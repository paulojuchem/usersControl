import java.io.*;

class DataHandler {
	
	private String fileName;
	private String fileData;

	public DataHandler(String fileName){

		this.fileName=fileName;

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

		//handle this

	}

	public void exportar(String fileName){

		//handle this

	}

	public void rm(int id){

		//handle this

	}

	public int add(User u){

		if (this.writeToFile(Integer.toString(this.getLastIndex())+","+u.getNome()+","+u.getEmail()+";")) {

			return this.getLastIndex();

		} else {

				return 0;

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

		FileWritter wr = new FileWritter(this.fileName , true);
		System.out.println("Dado Salvo com sucesso.");

	}

	public void fetchData(){

		this.fetchData(null);

	}

}