package hangman;

import java.util.Random;
import java.util.Scanner;


public class Hangman
{
Scanner keyboard = new Scanner(System.in);
Random rand = new Random();
// The following routine will determine if the character c
// is inside the String str.  A true is returned if it is inside.
// It is very useful to call the isIn routine inside of printCurrStatus ...
// Seethe comments in the Hint for printCurrStatus.
boolean isIn(char c, String str)
{
	if(str.contains(String.valueOf(c))){
		return true;
	}
	else{
		return false;}

}
// ******   printCurrStatus 
// If userInputs contains "ard" and strToGuess contains "aardvark" then
// the following routine prints out an output that looks something like:
//
// Current Status for userInpts=ard
// a a r d _ a r _
// This routine returns true if all letters were guessed, otherwise false is returned.
// HINT:  It is useful to have a for loop that goes through each of the characters in
//         strToGuess.    Call isIn for each character (note the second parameter would 
//         be userInputs).   If isIn returns true, just print out the character, if isIn
//returns false, then print out  '_'.  
//         Additionally, you can have a variable like:
//         boolean success = true;
//         Whenever you output at least one '_', you can set success = false.  
//         Your code can just return the variable "success" and it will return true if
//         the user has picked all of the letters.
boolean printCurrStatus(String strToGuess, String userInputs)
{
int lenW = strToGuess.length();
int lenU = userInputs.length();
String s = "";
int slen = s.length();
char charU = userInputs.charAt(lenU-1);

String now = strToGuess.replaceAll("[^" + userInputs + "]", "_");	


if (isIn(charU, strToGuess)){
	System.out.print(now);

}
else{
	System.out.println("That letter isnt in the word.");
	System.out.print(now);
}

if (now.contains("_")){
	return false;
}
else{
	System.out.println();
	System.out.print("Congratulations you guessed the word!");
	return true;
}
	

}

String getNextWordToGuess()
{String str = "";
final int num_words=10; 
int num = rand.nextInt(num_words);
if(num == 0){
	num = 1;}
switch(num){
case 1: str = "elephant";break;
case 2: str = "tiger"; break;
case 3: str = "monkey"; break;
case 4: str = "baboon"; break;
case 5: str = "barbeque"; break;
case 6: str = "giraffe"; break;
case 7: str = "simple"; break;
case 8: str = "zebra"; break;
case 9: str = "porcupine"; break;
case 10: str = "aardvark"; break;
}

return str;
}
// The following routine plays the hangman game. It calls getNextWordToGuess to
// get the word that should be guessed.  It then has a loop which outputs the 
// following prompt:
// Enter next letter
//
// A String named userInputs stores all letters selected already.  
// Then the routine printCurrStatus is called to print out the current status of
// the guessed word.  If printCurrStatus returns true, we are done.
void playGame()
{

	String sguess = "", userInputs ="";

String word = getNextWordToGuess();
String now1 = word.replaceAll("[(a-z)]", "-");

System.out.println("Lets Play Hangman! ");
System.out.println(now1);

System.out.print("Enter a letter: ");
sguess = keyboard.next().toLowerCase().trim();
userInputs = userInputs + sguess;
while(!printCurrStatus(word, userInputs)){
System.out.println();
System.out.print("Enter another letter: ");
sguess = keyboard.next().toLowerCase().trim();
userInputs = userInputs + sguess;}
	
}
// main will call playGame to play the hangman game.
// Then main will issue the prompt:
// Do you want to play again (y or n)
// If the answer is "y", then call playGame again, otherwise exit
public static void main(String[] args)
{
Hangman hangman = new Hangman();
String response="";
do{hangman.playGame();
System.out.println();
System.out.print("Do you want to play object oriented Hangman again? (y or n): ");
response = hangman.keyboard.next();
} while (response.charAt(0) == 'y');{
}
System.out.println("Bye");
}
}