package lista;

public class questao04 {

	public static void main(String[] args) {

		int A = 8;
		int B = 8;
		
		if(A > 10 || A + B == 20) {
			System.out.println("numero valido");
		}else if (A == B) {
			System.out.println("A é igual B");
			System.out.println("A e B são diferentes de 10");
			System.out.println("A é menor que 10)");
		}
		else
			System.out.println("numero invalido");
	}

}
