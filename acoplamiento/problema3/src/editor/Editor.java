package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Editor {
	
	public void checkSpelling(String text) {
		ArrayList<String> errors = this.check(text);
		if(errors != null)
			this.displayErrors(errors);
		else
			this.displaySuccessMessage();
	}
	
	public void displayErrors(ArrayList<String> errors) {
		for(int i=0; i<errors.size(); i++) {
			System.out.println("ERROR: " + errors.get(i));
		}
	}
	
	public Object displaySuccessMessage() {
		System.out.println("No errors found!");
		return null;
	}
	
	public ArrayList<String> check(String text) {
		String[] words = text.split("");
		ArrayList<String> errors = new ArrayList<String>();
		for(int i=0; i< words.length; i++) {
			String[] realWords = {"foo", "bar"};
			for(int j=0; j<realWords.length; j++) {
				if(!words[i].equalsIgnoreCase(realWords[j])) {
					errors.add(words[i]);
				}
			}
		}
		return errors;
	}
	
	public void runEditor() {
		this.printInConsole();
		String text = processInput();
		this.checkSpelling(text);
	}
	
	public static void main(String[] args) {
		Editor editor = new Editor();
		editor.runEditor();
	}
	
	private void printInConsole() {
		System.out.println("Running editor...");
		System.out.println("Enter text:");
	}
	
	private String processInput() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = "";
		try {
			text = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}
}
