package com.tdsis.loja;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Loja {
    
	public static void main(String[] args) {        
		Loja loja = new Loja();
		loja.run();
    }
	
	public void run() {		
		int stackSize = 0;
		int[] sizes;
		
		try {			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Digite a quantidade de meias existentes na pilha: ");
			stackSize = scanner.nextInt();			
			
			scanner = new Scanner(System.in);
			System.out.print("Digite o tamanho de cada meia separados por espaço: ");
			String sockSizes = scanner.nextLine();			
			
			sizes = parseSockSizes(sockSizes);
			Arrays.sort(sizes);
			
			if (isInputValid(stackSize, sizes)) {
				System.out.println("Quantidade de meias e tamanhos devem respeitar o limite: min 1 | max 100");
				System.exit(1);
			}
			
			int max = 0;
			for(int i = 1; i < sizes.length; i++) {
			    if(sizes[i] == sizes[i - 1]) {
			    	max++;
			        i++;
			    }
			}
			
			String msg = max > 0 ? 
					"Quantidade máxima de pares: " + max : 
						"Não existem pares a serem vendidos";
			
			System.out.println(msg);			
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
	public int [] parseSockSizes(String sizes) throws NumberFormatException {
		return Arrays.asList(sizes.split("\\s+"))
			.stream()
			.mapToInt(Integer::parseInt)				
			.toArray();
	}
	
	/**
	 * 
	 * @param stackSize
	 * @param sockSizes
	 * @return
	 */
	public boolean isInputValid(int stackSize, int [] sockSizes) {
		return (stackSize > 0 || stackSize <= 100) 
				&& (sockSizes[0] > 0 || sockSizes[sockSizes.length - 1] <= 100);		
	}
	
	
}
