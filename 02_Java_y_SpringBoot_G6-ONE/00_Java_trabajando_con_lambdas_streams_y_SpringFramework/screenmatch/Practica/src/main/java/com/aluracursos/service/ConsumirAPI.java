package com.aluracursos.service;

import java.io.IOException;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.Scanner;

public class ConsumirAPI {
	public String obtenerDatos(String endpoint) {
		try {
			URL url = new URL(endpoint);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);
			}

			StringBuilder inline = new StringBuilder();
			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNext()) {
				inline.append(scanner.nextLine());
			}

			scanner.close();
			return inline.toString();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}

