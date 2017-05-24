package com.task.controller;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.task.model.ProductList;

public class Menu {

	ProductList prl = new ProductList();

	public void displayChoiceList() {
		for (Command c : Command.values()) {
		}

	}

	public void runCommand(String choice) throws IOException, ParseException {
		String[] getChoise = choice.split(" ", 2);
		Command command = Command.get(getChoise[0]);

		switch (command) {
		case ADD: {
			prl.add(getChoise[1]);
			break;
		}
		case CLEAR: {
			prl.delete(getChoise[1]);
			break;
		}
		case LIST: {
			prl.list();
			break;
		}
		case TOTAL: {
			prl.total(getChoise[1]);
			break;
		}
		case EXIT: {
			System.exit(0);
			break;
		}
		}
	}

}
