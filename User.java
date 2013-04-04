class User {
	
	private int id;
	private String nome;
	private String email;

	public User(int id , String nome , String email){

		this.id = id;
		this.nome = nome;
		this.email = email;

	}

	public int getId(){

		return this.id;

	}

	public String getNome(){

		return this.nome;

	}

	public String getEmail(){

		return this.email;

	}

	public void setId(int id){

		this.id = id;

	}

	public void setNome(String nome){

		this.nome = nome;

	}

	public void setEemail(String email){

		this.email = email;

	}

}