package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set <Integer> setStudents = new HashSet<Integer>(); //conjunto
		System.out.println("Número de cursos do professor:");
		int numberOfCourses = sc.nextInt();
		numberOfCourses = Math.min(numberOfCourses, 26);//máximo de 26 salas
		//for em ordem alfabetica
		for(char letter = 'A'; letter < 'A' + numberOfCourses; letter++) {
			System.out.print("Número de alunos do curso " + letter + ":");
			int n = sc.nextInt();
			System.out.println();
			for(int aux = 1; aux <= n; aux++) {
				System.out.print("Código único do aluno " + aux + ":" );
				int cod = sc.nextInt();
				if(!setStudents.contains(cod)) {
					setStudents.add(cod);
				}
			}
		}
		System.out.println();
		System.out.printf("Total de alunos no curso: %d",setStudents.size());
		sc.close();
	}

}
