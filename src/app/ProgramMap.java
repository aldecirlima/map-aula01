package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramMap {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Map<String, Integer> map = new HashMap<>();

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

//		Path	
//		/home/aldecir/JAVA/temp/registro.csv

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");

				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);

				if (map.containsKey(name)) {
					map.put(name, map.get(name) + votes);
				} else {
					map.put(name, votes);
				}

				line = br.readLine();
			}

			for (String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();
	}
}
