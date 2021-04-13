package TrabalhoDeConslusaoDeModulo2;

import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Locacao {
	// atributos da classe abstrata
	
	private double valor;
	private String dataLocacao; 
	private String dataDevolucao; 
	private int tipo;
	boolean disponivel; // atributo que retorna true ou false
	private int CodigoID;

	// contrutores
	
	public int getCodigoID() {
		return CodigoID;
	}


	public void setCodigoID(int codigoID) {
		CodigoID = codigoID;
	}


	public Locacao () {// construtor vazio
		
	}
	
	
	public Locacao(double valor,int x) {//verifica a disponibilidade do produto
		
		disponivel=true;
		this.valor=valor;
		tipo=x;
		
	}
	
	abstract String getModelo(); // permite que as subclasse se comunique com a classe superior loca��o
	abstract String getTamanho();
	// metodos
	
	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getDataLocacao() {// retorna a data ja formatada
		DateTimeFormatter parserData = DateTimeFormatter.ofPattern("ddMMuuuu");
        LocalDate data = LocalDate.parse(dataLocacao, parserData);
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(data);
        return dataFormatada;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getDataDevolucao() {// retorna a data ja formatada
		DateTimeFormatter parserData = DateTimeFormatter.ofPattern("ddMMuuuu");
        LocalDate data = LocalDate.parse(dataDevolucao, parserData);
        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(data);
        return dataFormatada;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	public String formatarMoeda() {// retorna com a moeda formatada
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(2);
        String formatoMoeda = nf.format(valor);
        return formatoMoeda;
    }
}