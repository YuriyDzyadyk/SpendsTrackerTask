package com.task.controller;

public enum Command {

	ADD("add", "Add record"), LIST("list", "List all records"), CLEAR("clear", "Delete a Record"), TOTAL("total",
			"total ammount"), EXIT("exit", "Exit");

	private final String message;
	private final String code;

	private Command(String code, String message) {
		this.message = message;
		this.code = code;
	}

	public static Command get(String code) {
		for (Command c : Command.values()) {
			if ((c.code).equals(code)) {
				return c;
			}
		}
		return null;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

}
