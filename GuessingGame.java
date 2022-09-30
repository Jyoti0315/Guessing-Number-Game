import java.util.*;
interface ModelType
{
	void Welcome() throws InvalidInputException ;
	void Check() throws InvalidInputException ;
	void Scores();
}
class InvalidInputException extends Exception
{
	public String toString()
	{
		return "Teh value enterd is not valid";
	}
}
class GuessGame implements ModelType
{
	private int auto_generated=(int) (Math.random() * (49)) + 1;
	int user_input;
	private boolean game_on=true;
	String difficulty;
	private int life_lines;
	Scanner sc = new Scanner(System.in);
	GuessGame()
	{
		System.out.println("WELCOME TO THE GUESS THE NUMBER GUESSING GAME!");
		try {
			Welcome();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void Welcome() throws InvalidInputException {
		System.out.println("I'm thinking of a number Between 1 to 50"+"🤔🤔");
		System.out.println("Choose a Difficulty: Type 'easy'😉 or 'hard'😶. ");
		difficulty = sc.nextLine();
		if(difficulty.equalsIgnoreCase("easy"))
		{
			life_lines=5;
			System.out.println("You have a total of 5 attempts");
			for(int i=0;i<life_lines;i++)
			{
				System.out.print("| ");
			}
			System.out.println("");
			Check();
		}
		if(difficulty.equalsIgnoreCase("hard"))
		{
			life_lines=3;
			System.out.println("You have a total of 3 attempts");
			for(int i=0;i<life_lines;i++)
			{
				System.out.print("| ");
			}
			System.out.println("");
			Check();
		}
		try {
		if(difficulty.equalsIgnoreCase("hard")==false&&difficulty.equalsIgnoreCase("easy")==false)
		{
			throw new InvalidInputException();
		}}
		catch (InvalidInputException e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public void Check() throws InvalidInputException  {
		while(game_on)
		{
			System.out.println("Make a Guess: ");
			user_input=sc.nextInt();
			if(user_input==auto_generated)
			{
				System.out.println("Hurray!! You won..😎😎");
				break;
			}
			if(user_input!=auto_generated&&life_lines!=0)
			{
				Scores();
			}
			try {
			if(user_input>50)
			{
				throw new InvalidInputException();
			}}
			catch(InvalidInputException e)
			{
				e.printStackTrace();
			}
				
		}
	}
	@Override
	public void Scores() {
		if(auto_generated>user_input&&life_lines!=0)
		{
			if(life_lines>0) {
				if(life_lines==0)
				{
					game_on=false;
					System.out.println("YOU LOST😓😓 The number was "+auto_generated);
				}
				else {
			System.out.println("Enter a number greater than this");
			life_lines=life_lines-1;
			System.out.println("Total number of attempts left "+life_lines);
			for(int i=0;i<life_lines;i++)
			{
				System.out.print("| ");
			}
			System.out.println("");
		}}}
		if(user_input>auto_generated&&life_lines!=0)
		{
			System.out.println("Enter a number less than this ");
			if(life_lines>0)
			{
				if(life_lines==0)
				{
					game_on=false;
					System.out.println("YOU LOST😓😓 The number was "+auto_generated);
				}
				else {
				life_lines=life_lines-1;
				System.out.println("Total number of attempts left "+life_lines);
				for(int i=0;i<life_lines;i++)
				{
					System.out.print("| ");
				}
				System.out.println("");
			}}
		}
		if(life_lines==0)
		{
			game_on=false;
			System.out.println("YOU LOST😓😓 The number was "+auto_generated);
		}
	}
}
public class GuessingGame {

	public static void main(String[] args){
		GuessGame g = new GuessGame();
	}
}
