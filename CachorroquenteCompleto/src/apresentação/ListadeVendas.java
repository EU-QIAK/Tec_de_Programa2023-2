package apresentação;

import java.io.*;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import persistencia.LerDados;

public class ListadeVendas extends JPanel{

	private Label label;
	private JTable Table;
	private LerDados dados;
	private DefaultTableModel modelo;
	public JScrollPane scrollPane;
	
	public ListadeVendas(){
		setLayout(new BorderLayout());
		dados = new LerDados();
		
	String[] nomeDasColunas = {("proteinas"),("queijos"), ("ingredientes"), ("bebidas"), ("valores em R$")};
		modelo = new DefaultTableModel(nomeDasColunas, 0);
		
		try {
			for (String string : dados.lerDados("dados\\Cachorros")){
				String[] dadosDaPartida = string.split(";");
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
		JOptionPane.showMessageDialog(null, scrollPane, "Listas de venda", JOptionPane.INFORMATION_MESSAGE);
	}
}
