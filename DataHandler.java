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

	public void list(){

		this.fileName = "users.txt";
		this.fileData = null;
		this.fetchData();

		if(this.fileData!=null){

			String[] rs = this.fileData.split(";");
			System.out.println("|   ID  |          NOME         |        EMAIL");
			for(int i = 0; i < rs.length; i++){

				//dividir as linhas
				System.out.println(rs[i]);

			}

		} else {

			System.out.println("No data was found.");

		}


	}

	public void fetchData(){

		this.fileData = "";
		File file = new File(this.fileName);
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

}