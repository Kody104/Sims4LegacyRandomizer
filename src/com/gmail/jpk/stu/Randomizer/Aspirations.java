package com.gmail.jpk.stu.Randomizer;

public class Aspirations {
	
	public enum Child {
		CREATIVITY, MENTAL, MOTOR, SOCIAL;
		
		public static int getSize() {
			return Child.values().length;
		}
	}
	
	public enum Adult {
		FRIEND_OF_THE_ANIMALS("Animal"), BODYBUILDER("Athletic"), PAINTER_EXTRAORDINAIRE("Creativity"), MUSICAL_GENIUS("Creativity"), BESTSELLING_AUTHOR("Creativity"),
		PUBLIC_ENEMY("Deviance"), CHIEF_OF_MISCHIEF("Deviance"), SUCCESSFUL_LINEAGE("Family"), BIG_HAPPY_FAMILY("Family"), MASTER_CHEF("Food"), MASTER_MIXOLOGIST("Food"),
		FABIOUSLY_WEALTHY("Fortune"), MANSION_BARON("Fortune"), RENAISSANCE_SIM("KNOWLEDGE"), NERD_BRAIN("Knowledge"), COMPUTER_WHIZ("Knowledge"), CITY_NATIVE("Location"),
		SERIAL_ROMANTIC("Love"), SOULMATE("Love"), FREELANCE_BOTANIST("Nature"), THE_CURATOR("Nature"), ACE_ANGLER("Nature"), LEADER_OF_THE_PACK("Popularity"), FRIEND_OF_THE_WORLD("Popularity"),
		JOKE_STAR("Poplarity"), PARTY_ANIMAL("Popularity");
		
		private String masterName;
		
		Adult(String name) {
			masterName = name;
		}
		
		public String getMasterName() {
			return masterName;
		}
		
		public static int getSize() {
			return Adult.values().length;
		}
	}
}
