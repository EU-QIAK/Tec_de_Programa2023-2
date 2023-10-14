package negocio;

import java.util.ArrayList;

public class Memoria {

	public ArrayList<String> numeros;

	public Memoria() {
		numeros = new ArrayList<String>();
	}
	

	//mostra os numeros no display
	public String getNumeros() {
		String resultado = "";
		
		for (String num : numeros) {
			if(!num.equals("+")) {
				if(!num.equals("-"))
					if(!num.equals("*"))
						if(!num.equals("/"))
							resultado += num;
			}
			if(num.equals("+")) {
				resultado += " " + num + " ";
			}
			if(num.equals("-")) {
				resultado += " " + num + " ";
			}
			if(num.equals("*")) {
				resultado += " " + num + " ";
			}
			if(num.equals("/")) {
				resultado += " " + num + " ";
			}
		
		}
			return resultado;
	}
	
//	primeiraParte operacao segundaParte =  resultado
	
	//pegar os numeros 
	public void setNumero(String numero) {
		numeros.add(numero);
		
	}
	
	public double calcular(double parte1, String operacao, double parte2) {
		
		switch(operacao) {
			case "+":
				double resultado = parte1 + parte2;
				return resultado;
			case "-":
				double resultado2 = parte1 - parte2;
				return resultado2;
			case "*":
				double resultado3 = parte1 * parte2;
				return resultado3;
			case "/":
				if(parte2!=0) {
					double resultado4 = parte1 / parte2;
					return resultado4;
				}else {
					return 0;
				}
			default:
				return 0;
		}
	}
	

	public String resultado() {
		
		String conta = getNumeros();
		String[] partes = conta.trim().split(" ");
		String resul = "";
		
		if (partes.length ==3) {
			double parte1 = Integer.parseInt(partes[0]);
			String operacao = partes[1];
			double parte2 = Integer.parseInt(partes[2]); 
		
			double resultado = calcular(parte1, operacao, parte2);
			
			resul  = Double.toString(resultado);
			
			return resul;
		}
		return resul;
	}
}