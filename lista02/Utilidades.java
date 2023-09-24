package lista;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Utilidades {
	
	//questao01
	public static float somatorio2(float vet[]) { 
		float sum=0;
			 
		 for (int i = 2; i < vet.length-2; i++) {
			sum+=vet[i];
		}
		 return sum;
	}
	
	//questao02
	public static void numerospares(int comeco, int fim) {
		
		for (int i = comeco; i <= fim; i++) {
			if(i%2==0){
			System.out.print(i+" ");
			}
		}		
	}
	
	
	//questao03
	public static double media(int vet1[], int vet2[]) {
		
		float soma = 0;
		
		for (int i = 0; i < vet2.length; i++) {
			soma+=vet1[i]+vet2[i];
			
		}
		return soma/(vet2.length*2);
	}
	
	//questao04
	public static double mediapond(int vet1[], int vet2[]){
		
		float produto = 0;
		double dmn = 0;
		
		
		for (int i = 0; i < vet2.length; i++) {
			produto+=vet1[i]*vet2[i];
			
			dmn += vet2[i];
		}
		return produto/dmn;
	}
	
	//questao05
	public static int contagem(int vet1[], int vet2[]) {
		
		int repetido = 0;
		
		for (int i = 0; i < vet2.length; i++) {
			if(vet1[i]==2){
				repetido++;
			}if(vet2[i]==2){
				repetido++;
			}
		}
		return repetido;
	}
	
	//questao06
	public static int[] copia(int vet1[]) {
		
		int copia[]=new int[vet1.length];
		
		for (int i = 0; i < vet1.length; i++) {
			copia[i]=vet1[i];
		}
	
		return copia;
	}
	
	//questao07
	public static int[] ordenacao(int[] vet1) {
		
		int n = vet1.length;		
		
		for (int i = 0; i < n-1 ; i++) {
			for (int j = 0; j < n-1 ; j++) {
				if(vet1[j]<vet1[j+1]) {
					int temp =vet1[j];
					vet1[j]=vet1[j+1];
					vet1[j+1]= temp;
					}
				}
			}
		return vet1;
	}
	
	//questao08
	public static boolean verificacao(int[] vet1) {
		
		for (int i = 0; i < vet1.length - 1; i++) {
			if(vet1[i]>vet1[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	//questao09
	public static int kesimomaiorvalor(int[] vet1, int k) {
	
		if(k<1 || k> vet1.length) {
			System.out.println("valor não esta contido em vet1");
			return -1;
		}
		
		// funciona de maneira similar ao método clone, oferecendo apenas o recurso de possibilitar a cópia dos n primeiros elementos do vetor origem
		int[] copvet = Arrays.copyOf(vet1, vet1.length);
		
		//ordena os elementos do próprio array e retorna o array
		Arrays.sort(copvet);
		
		int indice = vet1.length- k ;
		
		
		return copvet[indice];
	}
	
	//questao10
	public static int kesimomenorvalor(int[] vet1, int k) {
		
		if(k<=0 || k > vet1.length) {
			System.out.println("valor não esta contido em vet1");
			return -1;
		}
		
		//ordena os elementos do próprio array e retorna o array
		Arrays.sort(vet1);
		
		return vet1[k -1];
	}
	
	//questao11
	public static boolean verificacaoo(int[] vet1, int[] vet2) {
		
		for (int i = 0; i < vet2.length-1; i++) {
			
			if(vet1.length<vet2.length) {
				return false;
			}
			if(vet1[i]!=vet2[i]) {
				return false;
			}
		}
		return true;
	}
	
	//questao12
	public static int potencia(int k,int v) {
		
		int resultado= 1;
		
		for (int i = 0; i < v; i++) {
			resultado*= k;
		}
		return resultado;
	}
	
	//questao13
	public static boolean primo(int k) {
		
		if(k<=1) {
			return false;
		}
		//math.sqrt retorna a rais quadrada do numero
		for (int i = 2; i <= Math.sqrt(k); i++) {
			if(k%i==0) {
				return false;
			}
		}
		return true;
	}
	
	//questao14
	public static int[] newvet(int[] vet1, int[]vet2) {
		
		int tamanhovet = vet1.length + vet2.length;
		int[] newvet = new int[tamanhovet];
		
		for (int i = 0; i < vet1.length; i++) {
			newvet[i]=vet1[i];
		}
		for (int i = 0; i < vet2.length; i++) {
			newvet[i+vet1.length] = vet2[i];
		}
		
		return newvet;
	}
	
	//questao15
	public static int[] remocao(int[]vet1, int elemento) {
		
		int tamanho = vet1.length-1;
		int[] newvet = new int[tamanho];
		
		int indexnewvet = 0;
		
		for (int i : vet1) {
			if(i!= elemento) {
				newvet[indexnewvet] = i;
				
				indexnewvet++;
			}
		}
		
		return newvet;
	}
	
	//questao16
	public static boolean palindromo(String palavra) {
				
		int esquerda = 0;
		int direita = palavra.length()-1;
		
		while(esquerda < direita) {
			
			if(palavra.charAt(esquerda)!=palavra.charAt(direita)) {
				return false;
			
			}
			esquerda++;
			direita--;
		}
		return true;
	}
	
	//questao17
	public static boolean primo2(int numero) {
		
		if(numero<=1) {
			return false;
		}
		for (int i = 2; i < Math.sqrt(numero); i++) {
			if(numero%i==0) {
				return false;
			}
		}
		
		return true;
	}
	
	//questao18
	public static String inversaodestring(String palavra) {
		
		StringBuilder novapalavra =new StringBuilder() ;
		
		for (int i = palavra.length()-1; i >= 0; i--) {
			novapalavra.append(palavra.charAt(i));
		}
		return novapalavra.toString();
		
	}
	
	//questao19
	public static float juros(double valor, double taxa, int periodo) {
		
		//Math. pow() retorna a base elevada ao expoente power
		double valorfinal=valor*Math.pow(1+taxa, periodo);
				
		return (float) valorfinal;
		
	}
	
	//questao20
	public static boolean perfectnumber(int numero) {
		
		int somadosdivisores = 0;
		
		for (int i = 1; i <= numero/2; i++) {
			if(numero %i == 0){
				somadosdivisores+=i;
			}
		}
		
		if(somadosdivisores == numero) {
		return true ;
		}
		return false;
	}
	
	//questao21
	public static int[] diminuicao(int numero) {
		
		int[] vet = new int[numero];
		
		for (int i = 0; i < numero; i++) {
			vet[i]=numero;
			numero--;
		}
		return vet;
	}
	
	//questao22
	public static void imprimirA(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(j + " ");
			}
		System.out.println();
		}	
	}
	public static void imprimirB(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				System.out.print((j + i) % 2 == 0 ? "@" : "*");
				System.out.print(" ");
		}
		System.out.println();
		}	
	}
	public static void imprimirC(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if(i == j || j==tamanho -1 -i) {
					System.out.print("* ");
				}else {
					System.out.print(i + " ");
				}
		}
		System.out.println();
		}	
	}
	public static void imprimirD(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if(i == 0 || i ==tamanho -1 || j==0 || j ==tamanho-1) {
					System.out.print("# ");
				}else if((i+j) % 2 ==0){
					System.out.print("! ");
				}else {
					System.out.print("* ");
				}
		}
		System.out.println();
		}	
	}
	public static void imprimirE(int tamanho) {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				if(i == j || j ==tamanho -1 -i) {
					System.out.print("0 ");
				}else if(j > i && j < tamanho - 1 - i){
					System.out.print("* ");
				}else if(j < i && j > tamanho - 1 - i){
					System.out.print("% ");
				}else {
					System.out.print("1 ");
				}
		}
		System.out.println();
		}	
	}
	
	public static void main(String[] args){

//		1) Somatório: Seu método deverá receber um vetor como parâmetro e retornar
//		a soma de todos elementos do vetor, sendo que as primeiras duas e as
//		últimas posições do vetor de entrada não devem ser consideradas;
//		float vet[]= {10,10,3,2,23,4};
//		
//		System.out.println(somatorio2(vet)); 
		
//		2) Números pares: Seu método deverá imprimir todos os números pares dentre
//		um número inicial e final informado como parâmentro do método.
//		int comeco = 0;
//		int fim = 40;
//		
//		numerospares(comeco, fim);

		
//		3) Média: Seu método deverá receber dois vetores como entrada e retornar a
//		média dos valores presentes nos vetores.
//		int vet[] = {1,2,3};
//		int vet2[] = {3,2,3};
//		
//		System.out.println(media(vet,vet2));
		
//		4) Média ponderada: Seu método deverá receber um vetor de notas e um vetor
//		de pesos correspondentes. Seu método deve retornar a média ponderada
//		das notas. Exemplo: [7, 8, 6], [2, 3, 1] -> 7.33
//		int vet1[] = {7, 8, 6};
//		int vet2[] = {2, 3, 1};
//		
//		System.out.println(mediapond(vet1,vet2));
		
//		5) Contagem de elementos: Seu método deverá receber dois vetores e um
//		elemento a ser contado. A função deve retornar a quantidade de vezes que
//		esse elemento aparece nos vetores. Exemplo: [1,3, 3, 2, 5],[1, 2, 3, 2, 4],
//		2 -> 3
//		int vet1[] = {1, 2, 3, 2, 5};
//		int vet2[] = {1, 2, 3, 2, 2};
		
//		System.out.println("numeros iguais a 2 -> " + contagem(vet1,vet2));

//		6) Cópia de vetor: Seu método deverá receber um vetor e retornar uma cópia
//		exata desse vetor.
//		int vet2[] = {1, 2, 3, 2, 2};
//		int vetorcop[] = copia(vet2);
//		
//		for (int i = 0; i < vetorcop.length; i++) {
//			System.out.print(" " + vetorcop[i]);
//		}
		
//		7) Ordenação crescente: Seu método deverá receber um vetor e retornar o
//		vetor ordenado em ordem crescente. Exemplo: [5, 2, 9, 1, 7] -> [1, 2, 5, 7, 9]
//		int vet1[] = {5, 2, 9, 1, 7};
//		
//		ordenacao(vet1);
//		
//		for (int i = 0; i < vet1.length; i++) {
//			System.out.println("o vetor ordenado é" + vet1[i]);
//		}
		
//		8) Verificação de ordenação: Seu método deverá receber um vetor e verificar
//		se ele está ordenado em ordem crescente. Se sim retornar true.
//		int vet1[] = {1,2,4,5,3,2};
//		
//		if(verificacao(vet1)) {
//			System.out.println("vetor ordenado");
//		}else {
//			System.out.println("vetor não ordenado");
//		}
		
//		9) K-ésimo maior valor: Seu método deverá receber um vetor e um K e
//		retornar o K-ésimo maior valor presente no vetor.
//		int vet1[] = {1,2,3,4,4,3,2,5,6};
//		int k = 5;
//		int kesimomaiorvalor = kesimomaiorvalor(vet1, k);
//		
//		if(kesimomaiorvalor != 1) {
//		System.out.println("o " + k + "-ésimo maior do vetor vet1 é " + kesimomaiorvalor);
//		}
		
//		10) K-ésimo menor valor: Seu método deverá receber um vetor e um K e
//		retornar o K-ésimo menor valor presente no vetor.
//		int vet1[] = {1,2,3,4,4,5,2,5,6};
//		int k = 5;
//		int kesimenor = kesimomenorvalor(vet1, k);
//		
//		if(kesimenor != 1) {
//		System.out.println("o " + k + "-ésimo menor do vetor vet1 é " + kesimenor);
//		}

//		11) Verificação de igualdade: Seu método deverá receber dois vetores e
//		verificar se eles são iguais, ou seja, se possuem os mesmos elementos na
//		mesma ordem.
//		int vet1[]= {1,1,1,1};
//		int vet2[]= {1,1,1,1};
//		
//		if(verificacaoo(vet1, vet2)) {
//			System.out.println("vetores iguais bro");
//		}else {
//			System.out.println("vetores diferentes bro");
//		}
		
//		12)Potenciação: Seu método deverá receber dois números, a base e o
//		expoente, e retornar a potência da base elevada ao expoente.
//		int k = 5;
//		int v = 5;
//		int resultado = potencia(k, v);
//		
//		System.out.println("o valor de " + k + " elevado a " + v + " é igual á: " + resultado);
		
//		13)Primo: Seu método deverá receber um número inteiro e verificar se ele é
//		primo, ou seja, se é divisível apenas por 1 e por ele mesmo.
//		int k = 7;
//		boolean primo = primo(k);
//		
//		if(primo){
//			System.out.println(k + " é um numero primo");
//		}else {
//			System.out.println(k + " é um numero nao primo irmao");
//		}
		
//		14) Busca por ocorrências: Seu método deverá receber dois vetores e deverá
//		retornar um novo vetor com todos os elementos que aparecem em ambos os
//		vetores.
//		int[] vet1 = {1,2,3,4};
//		int[] vet2 = {5,6,7,8};
//		
//		int[] newvet = newvet(vet1, vet2);
//		
//		for (int element : newvet) {
//			System.out.print(element + " ");
//		}
		
//		15)Remoção de elemento do vetor: Seu método deverá receber um vetor e um
//		elemento a ser removido. A função deve remover todas as ocorrências desse
//		elemento no vetor. Um novo vetor, apenas com elementos mantindos, deve
//		ser retornado: Exemplo: [1, 2, 3, 2, 4], 2 -> [1, 3, 4]
//		int[] vet1 = {1,2,3,3,4,6,5};
//		int elemento = 3;
//		
//		int[] novovet = remocao(vet1, elemento);
//		
//		for (int i : novovet) {
//			System.out.print(i);
//		}
		
//		16)Verificação de palíndromo: Seu método deverá receber uma string e
//		verificar se ela é um palíndromo, ou seja, se pode ser lida da mesma forma
//		de trás para frente. Exemplo: "ana" -> True.
//		String palavra = "ana";
//		
//		if(palindromo(palavra)) {
//			System.out.println("polínmedro hein, ai papai macetei");
//		}else {
//			System.out.println("é polínmedro não kkkkkkkkkkk");
//		}
		
//		17)Verificação de número primo: Seu método deverá receber um número
//		inteiro e verificar se ele é um número primo. Exemplo: 7 -> True.
//		int numero = 3;
//		boolean primo = primo2(numero);
//		
//		if(primo) {
//			System.out.println("é primo meu mano");
//		}else {
//			System.out.println("não é primo irmão");
//		}
		
//		18)Inversão de string: Seu método deverá receber uma string e retornar a
//		mesma string invertida. Exemplo: "hello" -> "olleh".
//		String palavra = "KAIQUE";
//		String inverterpalavra= inversaodestring(palavra);
//		
//		System.out.println("a palavra " + palavra + " invertida fica " + inverterpalavra) ;
		
//		19)Cálculo de juros compostos: Seu método deverá receber um valor inicial,
//		uma taxa de juros e um número de períodos. A função deve retornar o valor
//		final após a aplicação dos juros compostos. Exemplo: 1000, 0.05, 3 ->
//		1157.63
//		double valor = 1000;
//		double taxa = 0.05;
//		int periodo = 3;
//		
//		double valorfinal = juros(valor, taxa, periodo);
//		
//		System.out.println("o valor de " + valor + " com a taxa de " + taxa + " num período de " + periodo + "é igual a: " + valorfinal);
		
//		20)Verificação de número perfeito: Seu método deverá receber um número
//		inteiro e verificar se ele é um número perfeito, ou seja, se a soma dos seus
//		divisores próprios é igual a ele mesmo. Exemplo: 6 -> True
//		int numero = 6;
//		boolean perfectnumber = perfectnumber(numero);
//		
//		if(perfectnumber) {
//			System.out.println("numero perfeito cabra");
//		}else {
//			System.out.println("numero não perfeito");
//		}
		
//		21)Diminuição do vetor: Seu método deverá receber um número qualquer que
//		represente e criar um vetor com o tamanho informado. Este vetor deverá ter
//		sucessivas diminuições do seu tamanho em um unidade até que seu
//		tamanho seja igual a 1.	
//		int numero = 5;
//		int[] vet1 = diminuicao(numero);
//		
//		System.out.println(Arrays.toString(vet1));
		
//		22) Imprimir elementos: Faça um método para cada item abaixo e imprima as
//		formas apresentadas. Permita que o usuário escolha o número de linhas e
//		colunas desejadas. No exemplo abaixo, para cada matriz foram utilizadas 5
//		linhas e 5 colunas. Porém, independentemente do número de linhas e
//		colunas, as formas devem ser mantidas. As matrizes sempre serão
//		quadradas.
		
//		int tamanho = 5;
//		
//		System.out.println("forma A: ");
//		imprimirA(tamanho);
//		
//		System.out.println("");
//		System.out.println("forma B: ");
//		imprimirB(tamanho);
//		
//		System.out.println("");
//		System.out.println("forma c: ");
//		imprimirC(tamanho);
//		
//		System.out.println("");
//		System.out.println("forma D: ");
//		imprimirD(tamanho);
//		
//		System.out.println("");
//		System.out.println("forma E: ");
//		imprimirE(tamanho);
		
	}
}
