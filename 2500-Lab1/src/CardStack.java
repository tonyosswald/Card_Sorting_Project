
//	My code takes the array size as an input. Then, one at a time, it initializes
//	a stack, converts card OSV inputs to numbers using the "card" class, pushes that
//	number to the stack, and then inserts that number to an array.

//	Next, using 4 variables to track the edges of the array, I performed each
//	transformation and set the variable equal to the edge. The purpose of this was to
//	select whichever row or column has to be transformed each time a transformation
//	is read.

//	Last, I used a "results" stack to reverse the order of the cards so that they
//	would be printed properly. I removed the face-up cards from the stack, and converted
//	the cards from numbers back to the correct format for the required output. Then the
//	cards were pushed onto the results stack. After that, the cards were printed to the
//	output one at a time.

//	Then the code checks for 0 0 as an input and repeats if that's not the case.


import java.util.*;

public class CardStack {
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		try {
			//GETTING INPUTS AND SETTING EVERYTHING UP:
			
			//GET ARRAY SIZE INPUT
			int n = input.nextInt(); //number of rows
			int m = input.nextInt(); //number of columns
			
			//CHECK IF INPUT IS 0 0 - END IF SO
			while ((n != 0) && (m != 0)) {
				int topRow = 0; //top row index
				int leftCol = 0; //left column index
				int botRow = n - 1; //bottom row index
				int rightCol = m - 1; //right column index
				
				//READ INPUT, PLACE LIST INSIDE OF ARRAY, PLACE INPUT INTO EACH LIST
				StackInterface[][] cardArray = new StackInterface[n][m];
				
				for (int i = 0; i < n; i++) {
					for (int k = 0; k < m; k++) {
						Card card = new Card(input.next());
						
						StackInterface<Integer> cardStack = new LinkedStack<Integer>();
						cardStack.push(card.getCardCode());
						
						cardArray[i][k] = cardStack;	
					}
				}
				//////////////////////////////////////////////////////////////
				
				//COMPLETING TRANSFORMATIONS:
				
				//CHECK IF INPUT IS 1 1 - THERE IS NO OPERATIONS IF IT IS
				if (! ((n == 1) && (m == 1))) {
					//INPUT OPERATIONS
					String operations = new String(input.next());
					
					//READ OPERATIONS, THEN DO OPERATIONS
					for (int a = 0; a < operations.length(); a++) {
						
						//TOP FLIP
						if (operations.charAt(a) == 'T') {
							for (int k = 0; k < m; k++) {
								while (! cardArray[topRow][k].isEmpty()) {
									int cardCode = (int) cardArray[topRow][k].top();
									cardCode = cardCode * (-1);
									cardArray[topRow + 1][k].push(cardCode);
									cardArray[topRow][k].pop();
								}
							}
							topRow++;
						}
						////////////
						
						//BOTTOM FLIP
						if (operations.charAt(a) == 'B') {
							for (int k = 0; k < m; k++) {
								while (! cardArray[n - 1][k].isEmpty()) {
									int cardCode = (int) cardArray[botRow][k].top();
									cardCode = cardCode * (-1);
									cardArray[botRow - 1][k].push(cardCode);
									cardArray[botRow][k].pop();
								}
							}
							botRow--;
						}
						/////////////
						
						//LEFT FLIP
						if (operations.charAt(a) == 'L') {
							for (int i = 0; i < n; i++) {
								while (! cardArray[i][leftCol].isEmpty()) {
									int cardCode = (int) cardArray[i][leftCol].top();
									cardCode = cardCode * (-1);
									cardArray[i][leftCol + 1].push(cardCode);
									cardArray[i][leftCol].pop();
								}
							}
							leftCol++;
						}
						/////////////
						
						//RIGHT FLIP
						if (operations.charAt(a) == 'R') {
							for (int i = 0; i < n; i++) {
								while (! cardArray[i][rightCol].isEmpty()) {
									int cardCode = (int) cardArray[i][rightCol].top();
									cardCode = cardCode * (-1);
									cardArray[i][rightCol - 1].push(cardCode);
									cardArray[i][rightCol].pop();
								}
							}
							rightCol--;
						}
						/////////////
					}
				}
				//////////////////////////////////////////////////////////////
				
				//REVERSING RESULTS AND FORMATIING FOR OUTPUT
				
				StackInterface<String> results = new LinkedStack<String>();
	
				for (int i = 0; i < n; i++) {
					for (int k = 0; k < m; k++) {
						if (! cardArray[i][k].isEmpty()) {
							while (! cardArray[i][k].isEmpty()) {
								if ((int) cardArray[i][k].top() < 0) { //only negative values
									Card card = new Card((int)cardArray[i][k].top());
									results.push(card.getBaseCard());
								}
								cardArray[i][k].pop();
							}
						}
					}
				}
				//////////////////////////////////////////////////////////////
				
				//PRINTING RESULTS
				System.out.print("Test 1:");
				
				while(! results.isEmpty()) {
					System.out.print(" " + results.top());
					results.pop();
				}
				
				System.out.println("");
				//////////////////////////////////////////////////////////////
				
				//GET NEW INPUT
				n = input.nextInt(); //number of rows
				m = input.nextInt(); //number of columns
				//////////////////////////////////////////////////////////////
			}
			
		} finally {
			System.exit(0); 
		}
		
	}
}