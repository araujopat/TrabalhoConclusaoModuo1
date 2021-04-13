package TrabalhoDeConslusaoDeModulo2;

//cadastrar cliente - nome + códigoID
//listar clientes - exibir clientes cadastrados
//obter cliente pelo códigoID ou pelo nome
//pesquisar clientes - condição de existencia do cliente
//status clientes - se está alugando, se tem alguma multa, etc.


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class projetoUsuario {
	public static void main(String[] args) {
		// atributos
		
		int codigoID = 0;
		String nomeNovo;
		boolean condicao;
		int op;
				
		Scanner scanner = new Scanner (System.in);
		List<cadastroUsuario> usuarios = new ArrayList<cadastroUsuario>(); // leitura da collection lista do tipo array
		List<Locacao> locacoes = new ArrayList<Locacao>();
		
		do {// menu de opções
			
		//cadastro/login do usuário
			
		System.out.println("\n(0) Cadastrar usuário \n(1) Cadastrar veículo\n(2) Entrar \n(3) Remover usuário\n(4) Remover veículo\n(5) para encerrar o programa");
		op = scanner.nextInt();
		
		switch (op) {
			default:
				System.err.println("Opção inválida");// caso o usuário na escolha um dos itens do menu
				break;
			case 0:
				System.out.println("\nCadastro do cliente: ");
				System.out.println("Nome: ");
				nomeNovo = scanner.next().toLowerCase();// le um  nome cadastrado pelo usuario com caracteres minusculos independente de como foi digitado pelo usuario
				codigoID++;// incrementa mais 1
				System.out.println("Seu ID será: "+codigoID);
				cadastroUsuario cliente = new cadastroUsuario(nomeNovo,codigoID);// recebe um novo usuario
				usuarios.add(cliente);// adiciona um novo cliente a lista de clientes
				break;
			
			case 2:
				System.out.println("Informe seu nome: ");
				String nomeCadastrado = scanner.next().toLowerCase();
				condicao = false;// usuario não cadastrado não aluga veiculo
				
				for(cadastroUsuario loop: usuarios) {
			       
					if(loop.getNome().equals(nomeCadastrado)) {// se seu nome foi igual a um nome ja cadastrado
			        	condicao = true;// agora esta apto a elugar
			        	int loo=loop.getCodigoID();
			        	System.out.println("Menu de opções: ");
						System.out.println("(0) alugar \n(1) devolver \n(2) verificar status de usuário\n(3) Listar clientes\n(4) Buscar cliente\n(5) Voltar ao menu inicial");
						int op2 = scanner.nextInt();
						
						
						switch (op2) {
						default:
							System.err.println("Opção inválida");
							break;
						case 0: // busca usuarios pelo número de id para evitar que 2 pessoas com o mesmo nome se confundam
							System.out.println("Digite seu ID:");
							int id=scanner.nextInt();
							System.out.println("O que prefere alugar?\n1-Patinete  2-Bicicleta  3-Cancelar");
							int op3 =scanner.nextInt();
							switch (op3) {
							default:
								System.err.println("Opção inválida");
								break;
								case 1://patinetes cadastrados disponiveis
									System.out.println("Patinetes Disponíveis, digite  o número da que deseja alugar:");
									
									for(int i=0;i<locacoes.size();i++) {
										
										if(locacoes.get(i).isDisponivel()&&locacoes.get(i).getTipo()==0) {// se o veiculo esta disponivel e foi escolhida a opção patinete
											
											System.out.println(i+" - "+locacoes.get(i).getModelo()+" Tamanho "+locacoes.get(i).getTamanho());
										}
									}
									int cont=scanner.nextInt();// recebe inteiros do teclado
									System.out.println("Alugar de:(ddMMaaaa)");
									String scan=scanner.next();
									locacoes.get(cont).setDataLocacao(scan);
									System.out.println("Alugar até:(ddMMaaaa)");
									scan=scanner.next();
									locacoes.get(cont).setDataDevolucao(scan);
									locacoes.get(cont).setDisponivel(false);
									locacoes.get(cont).setCodigoID(id);
									System.out.println("Alugado!");
									break;
								
									
								
								case 2:// mostra as biciletas cadastradas disponiveis
									
									System.out.println("Bicicletas Disponíveis, digite  o número da que deseja alugar:");
									
									for(int i=0;i<locacoes.size();i++) {
										
										if(locacoes.get(i).isDisponivel()&&locacoes.get(i).getTipo()==1) {
											
											System.out.println(i+" - "+locacoes.get(i).getModelo()+" Tamanho "+locacoes.get(i).getTamanho());
										}
									}
									 cont=scanner.nextInt();
									System.out.println("Alugar de:(ddMMaaaa)");
									scan=scanner.next();
									locacoes.get(cont).setDataLocacao(scan);
									System.out.println("Alugar até:(ddMMaaaa)");
									scan=scanner.next();
									locacoes.get(cont).setDataDevolucao(scan);
									locacoes.get(cont).setDisponivel(false);
									locacoes.get(cont).setCodigoID(loo);
									System.out.println("Alugado!");
									

									break;
								case 3:
									break;
							}
							break;
						
						case 1:
							System.out.println("Digite o ID a verificar:");
							int cod=scanner.nextInt();
							System.out.println("Data da devolucao:(ddMMaaaa)");
							int data=scanner.nextInt();
							condicao=false;
							for(Locacao loop2: locacoes) {
							       
								if(loop2.getCodigoID()==cod) {
									condicao=true;
									System.out.println("foi alugado "+loop2.getModelo()+" no dia "+loop2.getDataLocacao()+" e deveria ser devolvido até o dia "+loop2.getDataDevolucao());
									System.out.println("Valor a ser cobrado: "+loop2.formatarMoeda()+", caso esteja em atraso,multa de 50%");
									loop2.setDisponivel(true);
									loop2.setCodigoID(-1);
								}
							}
							if(!condicao) {
								System.out.println("Não há alugado nenhum item.");
							}
							break;
						
						case 2:
							System.out.println("Digite o ID a verificar:");
							cod=scanner.nextInt();
							condicao=false;
							for(Locacao loop2: locacoes) {
							       
								if(loop2.getCodigoID()==cod) {
									condicao=true;
									System.out.println("foi alugado "+loop2.getModelo()+" no dia "+loop2.getDataLocacao()+" e deve ser devolvido até o dia "+loop2.getDataDevolucao());
								}
							}
							if(!condicao) {
								System.out.println("Não há alugado nenhum item.");
							}
						break;
						case 3:
							//listar os clientes
							System.out.println("---------------------------");
							
							for (cadastroUsuario loop4 : usuarios) {
								System.out.println(loop4.getNome());
								System.out.println(loop4.getCodigoID());
								System.out.println("---------------------------");
							}
							break;
						case 4:
							
							//buscar clientes
								System.out.println("Buscar clientes: ");
								System.out.println("Deseja buscar por: \n(0) nome \n(1) código de usuário");
								int op4 = scanner.nextInt();
								
								
								switch (op4) {
								default:
									System.err.println("Opção inválida");
									break;
								case 0:
									System.out.println("Informe o nome do cliente: ");
									String nome = scanner.next().toLowerCase();
									condicao = false;
									for(cadastroUsuario loop3: usuarios) {
								        if(loop3.getNome().equals(nome)) {
								        	condicao = true;
								        	System.out.println(nome + " é cadastrado na loja com o código " + loop3.getCodigoID());
								        }
									}
								if (condicao = false) {
									System.out.println(nome + " não é cadastrado na loja");
								}
								break;
								
								case 1:
									System.out.println("Informe o código do cliente: ");
									int codigo = scanner.nextInt();
									condicao = false;
									for(cadastroUsuario loop3: usuarios) {
								       if (loop3.getCodigoID() == codigo) {
								    	   condicao = true;
								    	   System.out.println(codigo + " é cadastrado na loja no nome de " + loop3.getNome());
								       }
								}
									if (condicao = false) {
									 System.out.println(codigo + " não é cadastrado na loja");
									}
							}
							break;
						case 5:
							break;
						}
			   
			        }
				}
			if (condicao = false) {
				System.out.println(nomeCadastrado + " não é cadastrado na loja");
			}
			break;
			case 1://adicionar veiculo
				System.out.println("\nCadastro do Veículo: ");
				System.out.println("Tipo:1-Patinete\n     2-Bicicleta ");
				int op4 =scanner.nextInt();
				
				switch (op4) {
				default:
					System.err.println("Opção inválida");
					break;
						case 1://patinete
							System.out.println("Insira os dados do veículo:\n modelo:");
							String Modelo=scanner.next().toLowerCase();
							System.out.println("Tamanho ");
							String Tamanho=scanner.next().toLowerCase();
							System.out.println("Valor do aluguel:");
							double valor=scanner.nextDouble();
							patinete patinete = new patinete(Modelo,Tamanho,valor,0);
							patinete.setDisponivel(true);
							locacoes.add(patinete);	
							break;
						case 2://bicicleta
							System.out.println("Insira os dados do veículo:\n modelo:");
							String Modelo1=scanner.next().toLowerCase();
							System.out.println("Tamanho:");
							String Tamanho1=scanner.next().toLowerCase();
							System.out.println("Valor do aluguel:");
							double valor1=scanner.nextDouble();		
							Bicicletas bike = new Bicicletas(Modelo1,Tamanho1,valor1,1);
							bike.setDisponivel(true);
							locacoes.add(bike);
							break;
				}
				break;
			case 3:
				System.out.println("Insira o ID do cliente a ser removido:");
				int id=scanner.nextInt();// proximo inteiro digitado e armazena na variavel
				condicao=false;
				for (int i=0;i<usuarios.size();i++) {// usuario é uma lista que vem do cadastro usuarios
					if(usuarios.get(i).getCodigoID()==id) {
						usuarios.remove(i);
						condicao=true;
						System.out.println("Usuário removido");
					}
				}
				if(!condicao) {
					System.out.println("ID não existe");

				}
				break;
			case 4:
				System.out.println("Insira o modelo do veículo a ser removido:");
				String modelo=scanner.next().toLowerCase();
				condicao=false;
				for (int i=0;i<locacoes.size();i++) {
					if(locacoes.get(i).getModelo().equals(modelo)) {
						locacoes.remove(i);
						condicao=true;
						System.out.println("veículo removido");
					}
				}
				if(!condicao) {
					System.out.println("Veículo não existe");

				}
				break;
		} 
		
		} while (op != 5);
		
		
	}
}