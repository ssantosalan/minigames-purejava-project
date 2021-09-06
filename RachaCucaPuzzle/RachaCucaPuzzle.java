import java.util.Scanner;

public class RachaCucaPuzzle {

	public static Scanner entrada = new Scanner(System.in);
	public static int numeroDeMovimentos = 0;

	public static void main(String[] args) {

		int quebraCabeca[][] = new int[3][3];

		gerarQuebraCabeca(quebraCabeca);

		do {

			imprimirQuebraCabeca(quebraCabeca);
			realizarMovimento(quebraCabeca);

		} while (!verificarOrdenacao(quebraCabeca));

		imprimirQuebraCabeca(quebraCabeca);

		System.out.println("Parabéns! Você conseguiu montar o quebra cabeça!");

		System.out.println("Foram realizados " + numeroDeMovimentos + " movimentos.");

	}

	public static void gerarQuebraCabeca(int matriz[][]) {

		int i, j, contador = 0;

		do {

			i = (int) (Math.random() * 3);
			j = (int) (Math.random() * 3);

			if (matriz[i][j] == 0) {

				matriz[i][j] = contador;
				contador++;

			}

		} while (contador <= 8);

	}

	public static void imprimirQuebraCabeca(int matriz[][]) {	
		
		System.out.println("|---|---|---|"); 
		
		for (int i = 0; i < 3; i++) {
		
			System.out.print("|");
		
			for (int j = 0; j < 3; j++) { 
							
			    if (matriz[i][j] == 0) {
		
			    	System.out.print("   |"); 
			    	
			    } else
		
			    	System.out.print(" " + matriz[i][j] + " |");
		
			}
			
			System.out.println("\n|---|---|---|"); 
			
		}
		
	}
	
	public static void realizarMovimento(int matriz[][]) { 
		
		System.out.print("Informe o movimento (2 (v), 4 (<), 6 (>) ou 8 (^)): ");
		
		int tecla = entrada.nextInt();
		
		if ((tecla != 2) && (tecla != 4) && (tecla != 6) && (tecla != 8)) {
		
			System.out.println("Movimento inválido!");
		
		}else {
		
			boolean sair = false;
			
			for (int i = 0; i < matriz.length && !sair; i++) {
			
				for (int j = 0; j < matriz[0].length; j++) {
			
					if (matriz[i][j] == 0 && tecla == 2 && (i - 1) >= 0) {
			
						numeroDeMovimentos++;
						
						matriz[i][j] = matriz[i - 1][j];
						
						matriz[i - 1][j] = 0;
						
						sair = true;
						
						break; 
						
					} else if (matriz[i][j] == 0 && tecla == 4 && (j + 1) <= 2) {
		
						
						numeroDeMovimentos++; 
						
						matriz[i][j] = matriz[i][j + 1];
						
						matriz[i][j + 1] = 0;
						
						sair = true;
						
					} else if (matriz[i][j] == 0 && tecla == 6 && (j - 1) >= 0) {	
						
						numeroDeMovimentos++;
						
						matriz[i][j] = matriz[i][j - 1];
						
						matriz[i][j - 1] = 0;
						
						sair = true;
						
						break;
						
					} else if (matriz[i][j] == 0 && tecla == 8 && (i + 1) <= 2) {
	
						numeroDeMovimentos++; 
						
						matriz[i][j] = matriz[i + 1][j]; 
						
						matriz[i + 1][j] = 0;
						
						
						i++;
						
						sair = true; 
						
						break; 
						
					}	
						
				}		
						
			}			
						
		}
	
	}
						
						
	public static boolean verificarOrdenacao(int matriz[][]) { 
		 
		for (int j = 0; j < 3; j++) { 
			if ((matriz[0][j] != j) || (matriz[1][j] != j + 3) || (matriz[2][j] != j + 6)) { 
				return false; 
		    } 
		} 
		return true; 
		  
	} 
	
}				
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
	
