package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		String pathFolder = "C:\\Users\\Johnes\\Desktop\\ADS\\Udemy\\Curso JAVA COMPLETO 2020 Programação Orientada a Objetos +Projetos\\Arquivos";
		String pathSource = pathFolder + "\\sourcefile\\product.txt";
		String pathOut = pathFolder + "\\summary\\out.txt";

		new File(pathFolder + "\\summary").mkdir();

		try (BufferedReader br = new BufferedReader(new FileReader(pathSource))) {
			String line = br.readLine();

			while (line != null) {

				String[] products = new String[3];
				products = line.split(",");

				String name = products[0];
				double value = Double.parseDouble(products[1]);
				int quantity = Integer.parseInt(products[2]);

				Product product = new Product(name, value, quantity);

				line = br.readLine();

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathOut, true));) {
					bw.write(product.toString());
					bw.newLine();
				} catch (IOException e) {
					System.out.println("Writing error: " + e.getMessage());
				}
			}
		} catch (IOException e) {
			System.out.println("Reading error: " + e.getMessage());
		}
	}
}
