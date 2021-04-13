package TrabalhoFinalPackage;


	public class patinete extends Locacao {// a classe patinete usa itens polimorficos da classe locação
		//declaração de atributos

		private String Modelo;//Eletrico ou normal
		private String tamanho;//Infantil ou adulto
		// construtores
		
		public patinete()// construtor vazio é o padrão
		{
			
		}
		
		public patinete (String Modelo, String tamanho, double valor, int x)
		{
			super(valor,x);// valores adquiridos da superclasse
			this.Modelo = Modelo;
			this.tamanho = tamanho;

		}

		public String getModelo() {
			return Modelo;
		}

		public void setModelo(String modelo) {
			Modelo = modelo;
		}

		public String getTamanho() {
			return tamanho;
		}

		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}
		
		
	}




