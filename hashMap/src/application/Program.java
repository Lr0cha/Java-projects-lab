package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o caminho completo do arquivo a ser lido:");
		String path = sc.next();
		Map<String,Integer> mapVotes = new HashMap<>();
		
		// try-with-resources
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String row = br.readLine(); //ler linha do arq
			while(row != null) {
				String[] fields = row.split(",");
				String nameCandidate = fields[0];
				int countVotes = Integer.parseInt(fields[1]);
				if(mapVotes.containsKey(nameCandidate)){
					// incrementa os votos na chave(nome do candidato)
					mapVotes.put(nameCandidate, countVotes + mapVotes.get(nameCandidate));
				}
				else {
					mapVotes.put(nameCandidate, countVotes); //adiciona a chave e valor
				}
				row = br.readLine();
			}
			StringBuilder sb = new StringBuilder();
			for(String key : mapVotes.keySet()) {
				sb.append("\n")
				.append(key)
				.append(": ")
				.append(mapVotes.get(key));
			}
			System.out.println(sb.toString());
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		sc.close();
	}

}
