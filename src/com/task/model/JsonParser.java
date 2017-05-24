package com.task.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	public double parse(String base, String currency) throws IOException, ParseException {

		URL oracle = new URL("http://api.fixer.io/latest?base=" + base); // URL to Parse
		URLConnection yc = oracle.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		JSONParser parser = new JSONParser();
		String s = "[0" + in.readLine() + "]";

		Object obj = parser.parse(s);
		JSONArray array = (JSONArray) obj;

		JSONObject obj2 = (JSONObject) array.get(1);
		// System.out.println("Field \"rates\"");
		// System.out.println(obj2.get("rates"));
		JSONObject obj3 = (JSONObject) obj2.get("rates");
		// System.out.println(obj3.get(currency));
		return (double) obj3.get(currency);
	}

}
