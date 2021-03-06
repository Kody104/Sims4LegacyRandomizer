package com.gmail.jpk.stu.Randomizer;

import java.awt.Toolkit;
import java.util.Random;
import java.util.Scanner;

public class Randomizer {
	
	private Scanner scan;
	private int selection;
	private Random rand;
	private boolean isRunning;
	private boolean isAgeUp;
	
	public static void main(String[] args) {
		Randomizer r = new Randomizer();
		r.start();
	}
	
	private void start() {
		scan = new Scanner(System.in);
		rand = new Random();
		isRunning = true;
		isAgeUp = false;
		while(isRunning)
		{
			writeLine("Welcome to The Sims 4 Legacy Randomizer!\nPlease select your catergory to randomize from the list below!");
			writeLine("[1] - Roll Traits   [2] - Roll Career\n[3] - Toggle Age-Up [" + isAgeUp + "]");
			getInput(scan.nextLine());
			switch(selection) {
				case 1:
				{
					writeLine("What is the age of your sim?\n[1] - Toddler   [2] - Child\n[3] - Teen      [4] - Young Adult & Up");
					getInput(scan.nextLine());
					switch(selection) {
						case 1:
						{
							int random = rand.nextInt(Traits.Toddler.getSize());
							writeLine("Your randomized trait has been served to you!");
							countdown();
							writeLine("Trait: " + Traits.Toddler.values()[random].toString() + "!");
							isRunning = false;
							break;
						}
						case 2:
						{
							int aspiration = rand.nextInt(Aspirations.Child.getSize());
							int trait1 = rand.nextInt(Traits.Child.getSize());
							writeLine("Your asipration and randomized traits have been served to you!");
							countdown();
							writeLine("Aspiration: " + Aspirations.Child.values()[aspiration].toString() + "!");
							writeLine("Trait 1: " + Traits.Child.values()[trait1].toString() + "!");
							isRunning = false;
							break;
						}
						case 3:
						{
							int aspiration = rand.nextInt(Aspirations.Adult.getSize());
							Traits.Teen trait1;
							Traits.Teen trait2;
							//while(trait2 == trait1) {
								//trait2 = Traits.Teen.values()[rand.nextInt(Traits.Teen.getSize())];
							//}
							writeLine("Your asipration and randomized traits have been served to you!");
							countdown();
							writeLine("Aspiration: (" + Aspirations.Adult.values()[aspiration].getMasterName() + ") " +  Aspirations.Adult.values()[aspiration].toString() + "!");
							if(isAgeUp) {
								do {
									trait1 = Traits.Teen.values()[rand.nextInt(Traits.Teen.getSize())];
									writeLine("Trait: " + trait1.toString());
									writeLine("Do you already have this trait?\n[1] - Yes   [2] - No");
									getInput(scan.nextLine());
								}while(selection != 2);
							}
							else {
								trait1 = Traits.Teen.values()[rand.nextInt(Traits.Teen.getSize())];
								trait2 = Traits.Teen.values()[rand.nextInt(Traits.Teen.getSize())];
								while(trait2 == trait1) {
									trait2 = Traits.Teen.values()[rand.nextInt(Traits.Teen.getSize())];
								}
								writeLine("Trait 1: " + trait1.toString() + "!");
								writeLine("Trait 2: " + trait2.toString() + "!");
							}
							isRunning = false;
							break;
						}
						case 4:
						{
							int aspiration = rand.nextInt(Aspirations.Adult.getSize());
							Traits.Adult trait1;
							Traits.Adult trait2;
							Traits.Adult trait3;
							if(isAgeUp) {
								do {
									trait1 = Traits.Adult.values()[rand.nextInt(Traits.Adult.getSize())];
									writeLine("Trait: " + trait1.toString());
									writeLine("Do you already have this trait?\n[1] - Yes   [2] - No");
									getInput(scan.nextLine());
								}while(selection != 2);
							}
							else {
								trait1 = Traits.Adult.values()[rand.nextInt(Traits.Adult.getSize())];
								trait2 = Traits.Adult.values()[rand.nextInt(Traits.Adult.getSize())];
								trait3 = Traits.Adult.values()[rand.nextInt(Traits.Adult.getSize())];
								while(trait2 == trait1) {
									trait2 = Traits.Adult.values()[rand.nextInt(Traits.Adult.getSize())];
								}
								while(trait3 == trait2 || trait3 == trait1) {
									trait3 = Traits.Adult.values()[rand.nextInt(Traits.Adult.getSize())];
								}
								writeLine("Your asipration and randomized traits have been served to you!");
								countdown();
								writeLine("Aspiration: (" + Aspirations.Adult.values()[aspiration].getMasterName() + ") " +  Aspirations.Adult.values()[aspiration].toString() + "!");
								writeLine("Trait 1: " + trait1.toString() + "!");
								writeLine("Trait 2: " + trait2.toString() + "!");
								writeLine("Trait 3: " + trait3.toString() + "!");
							}
							isRunning = false;
							break;
						}
						default:
						{
							writeLine("Invalid selection!");
							Toolkit.getDefaultToolkit().beep();
							createTension(1500);
							break;
						}
					}
					break;
				}
				case 2:
				{
					Careers career = Careers.values()[rand.nextInt(Careers.getSize())];
					int daysToFind = rand.nextInt(6);
					int maxCareerLevel = rand.nextInt(10) + 1;
					writeLine("The randomized career path is optional!");
					writeLine("Your career and it's intricacies has been served to you!");
					countdown();
					if(career == Careers.FREELANCE_AUTHOR || career == Careers.FREELANCE_MUSICIAN || career == Careers.FREELANCE_PAINTER || career == Careers.FREELANCE_PROGRAMMER) {
						writeLine("Career: " + career.toString() + "!");
					}
					else {
						writeLine("Career: " + career.toString() + " (Max: " + maxCareerLevel + ")!");
					}
					writeLine("Number of days to find this job: " + daysToFind + "!");
					isRunning = false;
					break;
				}
				case 3:
				{
					isAgeUp = !isAgeUp;
					break;
				}
				default:
				{
					writeLine("Invalid selection!");
					Toolkit.getDefaultToolkit().beep();
					createTension(1500);
					break;
				}
			}
		}
	}
	
	private void getInput(String input) {
		selection = parseFromStringToInt(input);
	}
	
	private void countdown() {
		createTension(1000);
		System.out.print("In 3");
		createTension(333);
		System.out.print(".");
		createTension(333);
		System.out.print(".");
		createTension(333);
		System.out.print(".");
		System.out.print("2");
		createTension(333);
		System.out.print(".");
		createTension(333);
		System.out.print(".");
		createTension(333);
		System.out.print(".");
		System.out.print("1");
		createTension(333);
		System.out.print(".");
		createTension(333);
		System.out.print(".");
		createTension(333);
		System.out.print(".\n");
		createTension(1500);
	}
	
	private void createTension(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void writeLine(String line) {
		System.out.println(line);
	}
	
	private int parseFromStringToInt(String parsee) {
		try {
			return Integer.parseInt(parsee);
		} catch(NumberFormatException e) {
			return -90210;
		}
	}
}
