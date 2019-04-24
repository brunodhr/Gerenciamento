// Aluno : Bruno Filipe Ramos Martins
package POO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Gerenciamento{
	
	public static void Print(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
	public static void main(String[] args) {
		List<People> peoples = new ArrayList<People>();
		int button = 0;
		int opcaoselecionada = 0;
		int id_pessoa = 0;
		
		String[] buttons = { "Cadastrar", "Consultar", "Atualizar", "Excluir", "Listar", "Sair"};
		do {
			opcaoselecionada = JOptionPane.showOptionDialog(null, "Selecione a ação desejada", "Menu de ações",
			        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[button]);
			switch (opcaoselecionada) {
				case 0:
					System.out.println("Cadastrar");
						People p = new People();
						p.codigo = peoples.size()+1;
						do {
							p.nome = JOptionPane.showInputDialog("Digite o nome (obrigatório)");
						} while (p.nome == null);
						p.email = JOptionPane.showInputDialog("Digite o email");
						p.cidade = JOptionPane.showInputDialog("Digite a cidade");
						p.estado = JOptionPane.showInputDialog("Digite o estado");

						peoples.add(p);
					break;
				case 1:
					System.out.println("Consultar");
						id_pessoa = Byte.parseByte(JOptionPane.showInputDialog("Digite o código da pessoa em que deseja procurar"));
						for(int i = 0 ; i < peoples.size() ; i++) {
							if(peoples.get(i).codigo == id_pessoa) {
								System.out.printf("Pessoa número : %d\n",i+1);
								System.out.printf("Código: %d\n",peoples.get(i).codigo);
								System.out.printf("Nome: %s\n",peoples.get(i).nome);
								System.out.printf("Email: %s\n",peoples.get(i).email);
								System.out.printf("Cidade: %s\n",peoples.get(i).cidade);
								System.out.printf("Estado: %s\n\n",peoples.get(i).estado);
							} else {
								JOptionPane.showMessageDialog(null, "Não existe uma pessoa com esse código", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
					break;
				case 2:
					System.out.println("Atualizar");
						id_pessoa = Byte.parseByte(JOptionPane.showInputDialog("Digite o código da pessoa em que deseja atualizar"));
						for(int i = 0 ; i < peoples.size() ; i++) {
							if(peoples.get(i).codigo == id_pessoa) {
								People newp = new People();
								newp.codigo = peoples.get(i).codigo;
								do {
									newp.nome = JOptionPane.showInputDialog("Digite o nome (obrigatório)");
								} while (newp.nome == null);
								newp.email = JOptionPane.showInputDialog("Digite o novo email");
								newp.cidade = JOptionPane.showInputDialog("Digite a nova cidade");
								newp.estado = JOptionPane.showInputDialog("Digite o novo estado");
								peoples.set(i,newp);
							} else {
								JOptionPane.showMessageDialog(null, "Não existe uma pessoa com esse código", "Erro", JOptionPane.ERROR_MESSAGE);
							}
						}
					break;
				case 3:
					System.out.println("Excluir");
					id_pessoa = Byte.parseByte(JOptionPane.showInputDialog("Digite o código da pessoa em que deseja excluir"));
					for(int i = 0 ; i < peoples.size() ; i++) {
						if(peoples.get(i).codigo == id_pessoa) {
							peoples.remove(i);
						} else {
							JOptionPane.showMessageDialog(null, "Não existe uma pessoa com esse código", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
					break;
				case 4:
					System.out.println("Listar");
					if(peoples.size() == 0) {
						JOptionPane.showMessageDialog(null, "Não existem pessoas cadastradas ainda", "Erro", JOptionPane.ERROR_MESSAGE);
					} else {
						for(int i = 0 ; i < peoples.size() ; i++) {
							System.out.printf("Objeto de Pessoa número : %d\n",i+1);
							System.out.printf("Código: %d\n",peoples.get(i).codigo);
							System.out.printf("Nome: %s\n",peoples.get(i).nome);
							System.out.printf("Email: %s\n",peoples.get(i).email);
							System.out.printf("Cidade: %s\n",peoples.get(i).cidade);
							System.out.printf("Estado: %s\n\n\n",peoples.get(i).estado);
						}
					}
					break;
			}
		} while (opcaoselecionada != 5);
	}
}
