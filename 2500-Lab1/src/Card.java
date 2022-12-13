
//	I used this card class to get and format the input of cards. It also tests the
//	inputed cards to make sure they're valid.

//	There's two constructors. The first takes a string, checks if its valid, and
//	converts it to a number to represent that card. The second takes an int and
//	converts it back into a string for that card.

//	Additionally, there's one main getter called "getBaseCard" which is used to
//	get the proper format for outputting the card. The other remaining getters
//	are just for testing.


public class Card {
	//INITIALIZE VARIABLES
	String card;
	String orientation;
	String suit;
	String value;
	int cardCode = 0;

	public Card(String newCard) throws Exception {
		
		//GET OSV VALUES FROM CARD STRING
		card = newCard;
		orientation = String.valueOf(card.charAt(0));
		suit = String.valueOf(card.charAt(1));
		value = String.valueOf(card.charAt(2));
		//////////////////////////////////////////////////////////////
		
		
		//CHECK OSV CODE TO MAKE SURE IT'S CORRECT
		if ( !(	orientation.contains("U") || orientation.contains("u") || 
				orientation.contains("F") || orientation.contains("f") )) {
			
			System.exit(0); 
		}
		
		if ( !(	suit.contains("C") || suit.contains("c") || 
				suit.contains("D") || suit.contains("d") || 
				suit.contains("H") || suit.contains("h") || 
				suit.contains("S") || suit.contains("s") )) {
			
			System.exit(0); 
		}
		
		if ( !(	value.contains("2") || 
				value.contains("3") || 
				value.contains("4") || 
				value.contains("5") ||
				value.contains("6") ||
				value.contains("7") ||
				value.contains("8") ||
				value.contains("9") ||
				value.contains("T") || value.contains("t") ||
				value.contains("J") || value.contains("j") ||
				value.contains("Q") || value.contains("q") ||
				value.contains("K") || value.contains("k") ||
				value.contains("A") || value.contains("a") )) {
			
			System.exit(0); 
		}
		//////////////////////////////////////////////////////////////
		
		
		//CONVERT OSV CODE TO NUMBER
		if (suit.contains("D") || suit.contains("d")) {
			cardCode = cardCode + 13;
		}
		
		if (suit.contains("H") || suit.contains("h")) {
			cardCode = cardCode + 26;
		}
		
		if (suit.contains("S") || suit.contains("s")) {
			cardCode = cardCode + 39;
		}
		
		if (value.contains("A") || value.contains("a")) {
			cardCode = cardCode + 1;
		}
		
		if ((	value.contains("2") || 
				value.contains("3") || 
				value.contains("4") || 
				value.contains("5") ||
				value.contains("6") ||
				value.contains("7") ||
				value.contains("8") ||
				value.contains("9") )) {
			
			int val = Integer.parseInt(value);
			cardCode = cardCode + val;
		}
		
		if (value.contains("T") || value.contains("t")) {
			cardCode = cardCode + 10;
		}
		
		if (value.contains("J") || value.contains("j")) {
			cardCode = cardCode + 11;
		}
		
		if (value.contains("Q") || value.contains("q")) {
			cardCode = cardCode + 12;
		}
		
		if (value.contains("K") || value.contains("k")) {
			cardCode = cardCode + 13;
		}
		
		if (orientation.contains("F") || orientation.contains("f")) {
			cardCode = (cardCode * (-1));
		}
		//////////////////////////////////////////////////////////////

	}
	
	public Card(int cardCode) throws Exception {
		
		//TURN CARD NUMBER INTO OSV CODE
		this.cardCode = cardCode;
		
		if (Math.abs(cardCode) <= 13) {
			suit = "C";
			
			if (cardCode > 0) {orientation = "U";}
			else {orientation = "F";}
			
			int number = Math.abs(cardCode);
			
			if (number == 1) {value = "A";}
			if (number == 2) {value = "2";}
			if (number == 3) {value = "3";}
			if (number == 4) {value = "4";}
			if (number == 5) {value = "5";}
			if (number == 6) {value = "6";}
			if (number == 7) {value = "7";}
			if (number == 8) {value = "8";}
			if (number == 9) {value = "9";}
			if (number == 10) {value = "T";}
			if (number == 11) {value = "J";}
			if (number == 12) {value = "Q";}
			if (number == 13) {value = "K";}

			card = orientation + suit + value;
		}
		
		else if ((Math.abs(cardCode) > 13) && (Math.abs(cardCode) <= 26)) {
			suit = "D";
			
			if (cardCode > 0) {orientation = "U";}
			else {orientation = "F";}
			
			int number = Math.abs(cardCode) - 13;
			
			if (number == 1) {value = "A";}
			if (number == 2) {value = "2";}
			if (number == 3) {value = "3";}
			if (number == 4) {value = "4";}
			if (number == 5) {value = "5";}
			if (number == 6) {value = "6";}
			if (number == 7) {value = "7";}
			if (number == 8) {value = "8";}
			if (number == 9) {value = "9";}
			if (number == 10) {value = "T";}
			if (number == 11) {value = "J";}
			if (number == 12) {value = "Q";}
			if (number == 13) {value = "K";}
			
			card = orientation + suit + value;
		}
		
		else if ((Math.abs(cardCode) > 26) && (Math.abs(cardCode) <= 39)) {
			suit = "H";
			
			if (cardCode > 0) {orientation = "U";}
			else {orientation = "F";}
			
			int number = Math.abs(cardCode) - 26;
			
			if (number == 1) {value = "A";}
			if (number == 2) {value = "2";}
			if (number == 3) {value = "3";}
			if (number == 4) {value = "4";}
			if (number == 5) {value = "5";}
			if (number == 6) {value = "6";}
			if (number == 7) {value = "7";}
			if (number == 8) {value = "8";}
			if (number == 9) {value = "9";}
			if (number == 10) {value = "T";}
			if (number == 11) {value = "J";}
			if (number == 12) {value = "Q";}
			if (number == 13) {value = "K";}
			
			card = orientation + suit + value;
		}
		
		else if ((Math.abs(cardCode) > 39) && (Math.abs(cardCode) <= 52)) {
			suit = "S";
			
			if (cardCode > 0) {orientation = "U";}
			else {orientation = "F";}
			
			int number = Math.abs(cardCode) - 39;
			
			if (number == 1) {value = "A";}
			if (number == 2) {value = "2";}
			if (number == 3) {value = "3";}
			if (number == 4) {value = "4";}
			if (number == 5) {value = "5";}
			if (number == 6) {value = "6";}
			if (number == 7) {value = "7";}
			if (number == 8) {value = "8";}
			if (number == 9) {value = "9";}
			if (number == 10) {value = "T";}
			if (number == 11) {value = "J";}
			if (number == 12) {value = "Q";}
			if (number == 13) {value = "K";}
			
			card = orientation + suit + value;
		}
		//////////////////////////////////////////////////////////////
	}
	
	public String getCard() {
		//RETURN CARD OSV CODE (For testing purposes)
		String cardOSV = orientation + suit + value;
		return cardOSV;
	}
	
	public String getBaseCard() {
		//RETURN CARD SV CODE FOR FINAL RESULT
		String cardSV = suit + value;
		return cardSV;
	}
	
	public String getOrientation() {
		//For testing
		return orientation;
	}
	
	public String getSuit() {
		//For testing
		return suit;
	}
	
	public String getValue() {
		//For testing
		return value;
	}
	
	public int getCardCode() {
		//For testing
		return cardCode;
	}
	
}


