import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;


public class Msg {
	
	// Print to console without skipping a line.
	public static void print(Object o) {
		System.out.print(o);
	}

	// Print to console and skip a line.
	public static void println(Object o) {
		System.out.println(o);
	}
	
	// Send a message
	public static void msg(Object o) {
		JOptionPane.showMessageDialog(null, o, "", JOptionPane.PLAIN_MESSAGE);
	}

	public static void victoryMsg(Object o, int guessNum) { if(!(opt(new String[]{"Retry", "Quit"}, "Congratulations! You guessed the word correctly on guess #" + guessNum + "!\n(" +
			o + ")\n\n" +
			"Click \"Quit\" to end the game, or hit \"Retry\"\n" +
			"to go for another round.", "") == 0)) System.exit(0); }

	public static void incorrectMsg(Object guess, Object state, Object o) { msg("\"" + guess + "\" was incorrect. \nIts status is the following:\n" + state
			+ "\n\n(" + o + ")");}

	public static void defeatMsg(Word word) {
		if(!(opt(new String[]{"Retry", "Quit"}, "Sorry, but you didn't guess the word correctly this time.\n" +
				"(It was " + word.getWord() + ".)\n" +
				"Better luck next time!\n\n" +
				"Click \"Quit\" to end the game, or hit \"Retry\"\n" +
				"to go for another round.", "") == 0)) System.exit(0);
	}

	public static String nextStageMsg(int guessNum, List<String> guesses, List<String> states, ArrayList<String> usedLetters, ArrayList<String> unusedLetters, ArrayList<String> unattemptedLetters) {
		StringBuilder msgVal = new StringBuilder();
		msgVal.append("Please input a five-letter-long word to guess.\n(You are on guess #" + guessNum + ".)\n\n");
		msgVal.append("Previous guesses:\n");
		for(int i = 0; i < guesses.size() - 1; i++) {
			msgVal.append("Guess: ").append(guesses.get(i)).append(" / Status: ").append(states.get(i)).append("\n");
		}
		msgVal.append("Guess: ").append(guesses.get(guesses.size()-1)).append(" / Status: ").append(states.get(guesses.size()-1)).append("\n\n");
		if(!usedLetters.isEmpty()) {
			msgVal.append("Letters in the word:\n");
			for(int i = 0; i < usedLetters.size() - 1; i++) msgVal.append(usedLetters.get(i)).append(", ");
			msgVal.append(usedLetters.get(usedLetters.size() - 1)).append("\n");
		}
		if(!unusedLetters.isEmpty()) {
			msgVal.append("Letters not in the word:\n");
			for (int i = 0; i < unusedLetters.size() - 1; i++) msgVal.append(unusedLetters.get(i)).append(", ");
			msgVal.append(unusedLetters.get(unusedLetters.size() - 1)).append("\n");
		}
		if(!unattemptedLetters.isEmpty()) {
			msgVal.append("Letters not tried yet:\n");
			for (int i = 0; i < unattemptedLetters.size() - 1; i++) msgVal.append(unattemptedLetters.get(i)).append(", ");
			msgVal.append(unattemptedLetters.get(unattemptedLetters.size() - 1)).append("\n");
		}
		return in(msgVal.toString());
	}
	// User input
	public static String in(Object o) {
		return JOptionPane.showInputDialog(null, o, "", JOptionPane.PLAIN_MESSAGE);
	}
	
	// Yes or No Option
	public static int yN(String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
	}
	
	// Yes, No or Cancel Option
	public static int yNC(String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
	}
	
	// Custom Options
	// Note: Options can be String Arrays or
	// Image arrays or other things.
	public static int opt(Object[] options, String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, 0);
	}
	

	
}
