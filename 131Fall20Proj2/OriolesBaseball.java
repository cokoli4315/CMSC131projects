import java.util.Scanner;
public class OriolesBaseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner myInput=new Scanner(System.in);
		System.out.println("Type 1 to enter a number or 2 to enter a name:");
		int numSelection=myInput.nextInt();

		final int DAVIS_NUM=19;  
		final int COBB_NUM=17;
		final int IGLESIAS_NUM=11;
		final int MANCINI_NUM=16;

		if(numSelection==1) {
			System.out.println("Enter player number:");
			int playerNumber=myInput.nextInt();
			if(playerNumber==DAVIS_NUM) {
				System.out.println("Which player wears number " +playerNumber+ " on his jersey?");
				myInput.nextLine();
				String player1=myInput.nextLine();
				if(player1.equalsIgnoreCase("Davis")) {
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");

				}
			}else if(playerNumber==COBB_NUM) {
				System.out.println("Which player wears number " +playerNumber+ " on his jersey?");
				myInput.nextLine();
				String player2=myInput.nextLine();
				if(player2.equalsIgnoreCase("Cobb")) {
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");

				}

			}else if(playerNumber==IGLESIAS_NUM) {
				System.out.println("Which player wears number " +playerNumber+ " on his jersey?");
				myInput.nextLine();
				String player3=myInput.nextLine();
				if(player3.equalsIgnoreCase("Iglesias")) {
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");
				}

			}else if(playerNumber==MANCINI_NUM) {
				System.out.println("Which player wears number " +playerNumber+ " on his jersey?");
				myInput.nextLine();
				String player4=myInput.nextLine();
				if(player4.equalsIgnoreCase("Mancini")) {
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");
				}

			}else {
				System.out.println("Invalid choice.");
			}

		}

		else if(numSelection==2) {
			myInput.nextLine();
			System.out.println("Choose a name:");
			String playerName=myInput.nextLine();
			if(playerName.equalsIgnoreCase("Davis")) {
				System.out.println("What number does davis wear?");
				int davisNumber=myInput.nextInt();
				if(davisNumber==DAVIS_NUM) {
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");
				}
			}else if(playerName.equalsIgnoreCase("Cobb")) {
				System.out.println("What number does Cobb wear?");
				int cobbNumber=myInput.nextInt();
				if(cobbNumber==COBB_NUM) {
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");
				}
			}else if(playerName.equalsIgnoreCase("Iglesias")) {
				System.out.println("What number does Iglesias wear?");
				int iglesiasNumber=myInput.nextInt();
				if(iglesiasNumber==IGLESIAS_NUM) {
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");
				}
			}else if(playerName.equalsIgnoreCase("Mancini")) {
				System.out.println("What number does Mancini wear?");
				int manciniNumber=myInput.nextInt();
				if(manciniNumber==MANCINI_NUM){
					System.out.println("Correct!");
				}else {
					System.out.println("Incorrect!");
				}

			}else {
				System.out.println("Invalid choice.");
			}
		}
		myInput.close();
	}
}