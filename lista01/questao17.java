package lista;

public class questao17 {

	public static void main(String[] args) {
		
		int A = 9;
		int B = 9;
		
		if(A > 10 || A + B ==20) {
			System.out.println("numero valido");
		}else if(A == B) {
			System.out.println("A é igual B");
			
			if(A != 10 && B != 10){
				
				if(A<10) {
				System.out.println("A é menor que 10");
				}
			}
		}else
			System.out.println("numero nao valido");
		
	}

}
