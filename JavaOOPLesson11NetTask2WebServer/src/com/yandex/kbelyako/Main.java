package com.yandex.kbelyako;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		String answer = "";

		answer += "<html><head><title>Server</title> <meta charset='utf-8'></head><body><p>System information: "
				+ "</p><br>";
		answer += "<body>";
		answer += "<p>" + "Total memory (bytes): " + Runtime.getRuntime().totalMemory() + "</p>";
		answer += "<p>" + "Free memory (bytes): " + Runtime.getRuntime().freeMemory() + "</p>";
		answer += "<p>" + "available Processors : " + Runtime.getRuntime().availableProcessors() + "</p>";
		answer += "</body>";
		answer += "</table></body></html>";

		try (ServerSocket soc = new ServerSocket(8080)) {
			int counter = 0;
			for (;;) {
				Socket clisoc = soc.accept();
				counter = counter + 1;
				String rn = "Request number:" + counter;
				Client cli = new Client(clisoc, answer + rn);
				

			}
		} catch (IOException e) {
			System.out.println("Error to server Socket Open!!!");
		}

	}
}
