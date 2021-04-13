package TrabalhoFinalPackage;



	public class cadastroUsuario {
		// atributos
		public String nome;
		private int codigoID;
		//contrutor
		
		cadastroUsuario (String nome, int codigoID) {
			this.nome = nome;
			this.codigoID = codigoID;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getCodigoID() {
			return codigoID;
		}

		public void setCodigoID(int codigoID) {
			this.codigoID = codigoID;
		}
	}
