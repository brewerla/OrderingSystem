package com.example.orderingsystem;

import java.util.Arrays;

public class Sandmich {
	//Array of strings representing the choices
	String[] choices;

	//Constructor for the Sandmich class
	public Sandmich(String[] choices) {
		this.choices = choices;
	}

	@Override

	//To string method for the sandmich
	public String toString() {
		String choicesString = "";
		for(int i = 0; i < this.choices.length; i++) {
			//If the option is a blank string go to the next iteration
			if(choices[i] == "") continue;

			//If there is a choice add the choice to the choicesString
			choicesString += this.choices[i] + ((i == this.choices.length) ? "" : ", ");
		}

		//Return the string
		return "Current Choices: " + choicesString;
	}

}
