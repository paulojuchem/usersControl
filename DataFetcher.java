import java.io.*;

class DataFetcher {
	
	private String fileName;

	public DataFetcher(String fileName){

		this.fileName=fileName;

	}

	public void setFile(String fileName){

		this.fileName = fileName;

	}

	public void fetchData(){

		File file = new File(this.fileName);
        StringBuilder contents = new StringBuilder();
        BufferedReader reader = null;
		//pegar os dados do arquivo

         try {

            reader = new BufferedReader(new FileReader(file));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {

            	//a variavel txt corresponde a cada linha do arquivo
                System.out.println(text);

            }
            
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (reader != null) {

                    reader.close();

                }

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

	}

}