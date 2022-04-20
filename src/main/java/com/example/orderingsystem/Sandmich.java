package com.example.orderingsystem;

import java.util.Arrays;

public class Sandmich {
	String[] choices;

	public static class Option {
		String name;
		String[] options;

		public Option(String name, String[] options) {
			this.name = name;
			this.options = options;
		}
	}

	public Sandmich(String[] choices) {
		this.choices = choices;
	}

	@Override
	public String toString() {
		String choicesString = "";
		for(int i = 0; i < this.choices.length; i++) {
			if(choices[i] == "") continue;
			choicesString += this.choices[i] + ((i == this.choices.length) ? "" : ", ");
		}
		return "Current Choices: " + choicesString;
	}

}
