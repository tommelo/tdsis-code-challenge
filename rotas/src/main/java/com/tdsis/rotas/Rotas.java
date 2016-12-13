package com.tdsis.rotas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Rotas {
	
    public static void main(String[] args) {
        Rotas rotas = new Rotas();
    	rotas.run();    	
    }
    
    public void run() {
    	try {			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Digite a quantidade de casos de teste: ");
			int cases = scanner.nextInt();
			if (cases < 1 || cases > 1000) {
				System.out.print("Quantidade de casos de teste inválida");
				System.exit(1);
			}
			
			List<TestCase> testCases = new ArrayList<>();
			for (int i = 1; i <= cases; i++) {
				scanner = new Scanner(System.in);
				
				System.out.println();
				System.out.println("Caso " + i);
				System.out.print("Digite a quantidade de cidades: ");
				int quantidade = scanner.nextInt();
				
				if (quantidade < 2 || quantidade > 100) {
					System.out.print("Quantidade de cidades inválida");
					System.exit(1);
				}
				
				scanner = new Scanner(System.in);
				System.out.print("Digite o número de rotas separados por espaço: ");
				String line = scanner.nextLine();				
				int[] cidades = parseRoutes(line);
				
				for (int cidade : cidades) {
					if (cidade < 1 || cidade > 1000) {
						System.out.print("Rota acima do permitido(1 <= Ni <= 1000)");
						System.exit(1);
					}
				}
				
				TestCase testCase = new TestCase();
				testCase.setQuantidadeCidades(quantidade);
				testCase.setCidades(cidades);
				testCase.setRotas(cidades[cidades.length - 1]);
				
				testCases.add(testCase);
			}
			
			for (int i = 1; i <= testCases.size(); i++) {
				System.out.println();
				System.out.println("Caso de teste " + i);
				TestCase testCase = testCases.get(i - 1);
				int [] cidades = testCase.getCidades();
				
				int total = 0;				
				int sum = 0;
				for (int x = 0; x < cidades.length - 1; x++) {
					sum += cidades[x];
				}
				
				total = sum * testCase.getRotas();
				System.out.println("Total de rotas: " + total);
				System.out.println();
			}
			
	
		} catch (NumberFormatException | InputMismatchException e) {
			System.out.println("Somente caracteres numéricos são permitidos, tente novamente.");
			System.exit(1);
		}
    }
    
    /**
	 * 
	 * @param sizes
	 * @return
	 */
	public int [] parseRoutes(String routes) throws NumberFormatException {
		return Arrays.asList(routes.split("\\s+"))
			.stream()
			.mapToInt(Integer::parseInt)				
			.toArray();
	}
}
