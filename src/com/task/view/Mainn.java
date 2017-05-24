package com.task.view;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.task.controller.Menu;

public class Mainn {

	public static void main(String[] args) {
		Menu menu = new Menu();
		String input = null;
		while (true) {
			menu.displayChoiceList();
			Scanner sc = new Scanner(System.in);
			if (sc.hasNext()) {
				input = sc.nextLine();
			}
			try {
				menu.runCommand(input);
			} catch (IOException e) {

				e.printStackTrace();
			} catch (ParseException e) {

				e.printStackTrace();
			} catch (NullPointerException e) {
				// e.printStackTrace();
				System.out.println("Error: command is " + e.getMessage());
			}
		}

	}

}
