package com.tdsis.palindromo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Palindromo {
	
    public static void main( String[] args ) {
    	Palindromo palindormo = new Palindromo();
    	palindormo.run();        	    	
    }
    
    public void run() {
    	try {			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Digite a palavra: ");
			String word = scanner.next();
			if (word.length() < 2 || word.length() > 1000000) {
				System.out.print("A palavra possui o tamanho inválido, tente novamente");
				System.exit(1);
			}
			
			if (!word.matches("\\d+")) {
				System.out.print("A palavra contém número(s)(permitido somente [a-z])");
				System.exit(1);
			}
										
			String reversedWord = new StringBuilder(word).reverse().toString();
			
			scanner = new Scanner(System.in);
			System.out.print("Digite a quantidade de verificações: ");
			int checks = scanner.nextInt();			
			
			if (checks < 1 || checks > 333333) {
				System.out.print("Quantidade de verificações inválida");
				System.exit(1);
			}
			
			List<int[]> indexes = new ArrayList<>();
			for(int x = 1; x <= checks; x++) {
				scanner = new Scanner(System.in);
				System.out.print("Digite os indices da verificação " + x + " separados por espaço: ");
				String indexLine = scanner.nextLine();
				
				int [] idxArray = parseIndexes(indexLine);
				int i = idxArray[0];
				int j = idxArray[1];
				int k = idxArray[2];
				int l = idxArray[3];
				
				if (i < 1 || i > j || j > word.length()
					|| k < 1 || k > l || l > word.length()) {
					System.out.print("Indice de verificação " + x + " inválido, tente novamente");
					System.exit(1);
				}
				
				indexes.add(idxArray);				
			}
			
			for (int [] indexArray : indexes) {
				StringBuilder builder = new StringBuilder();
				for (int index : indexArray) {
					builder.append(reversedWord.charAt(index - 1));
				}
				
				String wrd = builder.toString();
				String rev = builder.reverse().toString();
																	
				if (wrd.equals(rev))
					System.out.println("YES");
				else
					System.out.println("NO");
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
	public int [] parseIndexes(String line) throws NumberFormatException {
		return Arrays.asList(line.split("\\s+"))
			.stream()
			.mapToInt(Integer::parseInt)				
			.toArray();
	}
}
