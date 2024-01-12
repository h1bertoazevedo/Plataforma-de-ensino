package application;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;


public class Program {

	public Program() {

	}

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Dados da "+(i+1)+"a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char aula = sc.next().charAt(0);
			sc.nextLine();
			if(aula == 'c') {
				System.out.print("Título: ");
				String title = sc.nextLine();
				//sc.nextLine();
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();
				System.out.println();
				
				list.add(new Video(title, url, seconds));
			}else {
				if(aula == 't') {
					System.out.print("Título: ");
					String title = sc.nextLine();
					//sc.nextLine();
					System.out.print("Descrição: ");
					String description = sc.nextLine();
					System.out.print("Quantidade de questões: ");
					int questionCount = sc.nextInt();
					
					list.add(new Task(title, description, questionCount));
				}
			}
		}
		sc.close();
		
		int sum = 0;
		for (Lesson lesson : list) {
			sum += lesson.duration();
		}
		
		System.out.println();
		System.out.print("DURAÇÃO TOTAL DO CURSO = "+sum+" segundos");

	}

}
