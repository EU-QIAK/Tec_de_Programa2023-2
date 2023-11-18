package apresentação;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.LerDados;

public class ListarClientes extends JPanel{
	private Label label;
	private JTable Table;
	private LerDados dados;
	private DefaultTableModel modelo;
	public JScrollPane scrollPane;
	
	public ListarClientes() {
		setLayout(new BorderLayout());
		dados = new LerDados();
		
		String[] nomeDasColunas = {("alunos"), ("matriculas")};
		modelo = new DefaultTableModel(nomeDasColunas, 0);
		
		try {
			for (String string : dados.lerDados("dados\\Alunos")) {
				String[] dadosDaPartida = string.split(";");
//				System.out.println(string);
				modelo.addRow(dadosDaPartida);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Table = new JTable(modelo);
		scrollPane = new JScrollPane(Table);
		scrollPane.setPreferredSize(new Dimension(600,600));
		add(scrollPane, BorderLayout.CENTER);
		
		
		this.setVisible(true);	
	}
	public void ExibirTabela() {
		JOptionPane.showMessageDialog(null, scrollPane, "Listas de Clientes", JOptionPane.INFORMATION_MESSAGE);
	}
}
