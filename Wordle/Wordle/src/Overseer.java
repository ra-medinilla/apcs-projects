import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Overseer {

    private Word word;

    private String guess1;
    private String guess2;
    private String guess3;
    private String guess4;
    private String guess5;
    private String guess6;
    private ArrayList<String> guesses;

    private String state1;
    private String state2;
    private String state3;
    private String state4;
    private String state5;
    private String state6;
    private ArrayList<String> states;

    private ArrayList<String> includedLetters;
    private ArrayList<String> unincludedLetters;
    private ArrayList<String> unattemptedLetters;
    

    public Overseer() {
        Word.setWordList();
        Msg.msg("Welcome to a horrible fork of Wordle that I spent way too much time working on just to scrap most of the features!");
        Msg.msg("The basic rules:\n\n" +
                "Guess the word in six tries.\n\n" +
                "Each guess must be a valid five-letter word. Hit the enter button to submit.\n\n" +
                "After each guess, text will display to show how close your guess was to the word.\n\n" +
                "If a letter you typed is displayed, that letter is in the correct spot and is in the word.\n" +
                "If a plus (+) is displayed, the letter in that spot goes in another spot, but is in the word.\n" +
                "If an asterisk (*) is displayed, the letter in that spot is not in the word.\n\n" +
                "Have fun!\n\n" +
                "(P.S. You can prematurely quit the game by leaving a guess empty and submitting.)"
        );
        while(true) {
            word = Word.generate();
            while(true) {
                guesses = new ArrayList<>();
                states = new ArrayList<>();
                includedLetters = new ArrayList<>();
                unincludedLetters = new ArrayList<>();
                unattemptedLetters = new ArrayList<>();
                for(int c = 97; c < 123; c++)
                    unattemptedLetters.add(String.valueOf((char)c));
                guess1 = Msg.in("The word has been generated.\nPlease input a five-letter-long word to guess." +
                        "\n(You are on guess #1.)").toLowerCase();
                System.out.println(guess1);
                if(guess1 == null || guess1.isEmpty())
                    if(Msg.yN("Are you sure you want to quit?", "") == JOptionPane.YES_OPTION) System.exit(0);
                    else continue;
                else if (guess1.length() != 5) {
                    Msg.msg("Invalid length! The guess must be five letters long.");
                    continue;
                }
                 try {
                    if (Word.isInvalid(guess1)) {
                        Msg.msg("Invalid word! This word is not in the database.");
                        continue;
                    }
                } catch(Exception e) {
                    Msg.msg("Invalid word! This word is not in the database.");
                    continue;
                }
                break;
            }
            state1 = word.getHint(guess1);
            if(checkVictory(state1)) { Msg.victoryMsg("Lucky guess, getting it on the first turn.", 1); continue; }
            else {
                Msg.incorrectMsg(guess1, state1, "It's only the first turn, so I didn't reasonably\nexpect you to get it right now anyway.\nDon't beat yourself up about it!");
                guesses.add(guess1); states.add(state1);
                Word.addLetters(includedLetters, unattemptedLetters, unincludedLetters, guess1, state1);
                while(true) {
                    guess2 = Msg.nextStageMsg(2, guesses, states, includedLetters, unincludedLetters, unattemptedLetters).toLowerCase();
                    System.out.println(guess2);
                    if(guess2 == null || guess2.isEmpty())
                        if(Msg.yN("Are you sure you want to quit?", "") == JOptionPane.YES_OPTION) System.exit(0);
                        else continue;
                    else if (guess2.length() != 5) {
                        Msg.msg("Invalid length! The guess must be five letters long.");
                        continue;
                    }
                    else if (guesses.contains(guess2.toLowerCase())) {
                        Msg.msg("You already guessed this!"); continue;
                    }
                    try {
                        if (Word.isInvalid(guess2)) {
                            Msg.msg("Invalid word! This word is not in the database.");
                            continue;
                        }
                    } catch(Exception e) {
                        Msg.msg("Invalid word! This word is not in the database.");
                        continue;
                    }
                    break;
                }
                state2 = word.getHint(guess2);
                if(checkVictory(state2)) { Msg.victoryMsg("You're either a master of Wordle or you just got really lucky.", 2); continue; }
                else {
                    Msg.incorrectMsg(guess2, state2, "It's only the second turn, so you're still good\nfor a couple more guesses.");
                    guesses.add(guess2); states.add(state2);
                    Word.addLetters(includedLetters, unattemptedLetters, unincludedLetters, guess2, state2);
                    while(true) {
                        guess3 = Msg.nextStageMsg(3, guesses, states, includedLetters, unincludedLetters, unattemptedLetters).toLowerCase();
                        System.out.println(guess3);
                        if(guess3 == null || guess3.isEmpty())
                            if(Msg.yN("Are you sure you want to quit?", "") == JOptionPane.YES_OPTION) System.exit(0);
                            else continue;
                        else if (guess3.length() != 5) {
                            Msg.msg("Invalid length! The guess must be five letters long.");
                            continue;
                        }
                        else if (guesses.contains(guess3.toLowerCase())) {
                            Msg.msg("You already guessed this!"); continue;
                        }
                        try {
                            if (Word.isInvalid(guess3)) {
                                Msg.msg("Invalid word! This word is not in the database.");
                                continue;
                            }
                        } catch(Exception e) {
                            Msg.msg("Invalid word! This word is not in the database.");
                            continue;
                        }
                        break;
                    }
                    state3 = word.getHint(guess3);
                    if(checkVictory(state3)) { Msg.victoryMsg("Hey, you did pretty good this time!", 3); continue; }
                    else {
                        Msg.incorrectMsg(guess3, state3, "You're not cutting it close just yet, so don't worry.");
                        guesses.add(guess3);
                        states.add(state3);
                        Word.addLetters(includedLetters, unattemptedLetters, unincludedLetters, guess3, state3);
                        while(true) {
                            guess4 = Msg.nextStageMsg(4, guesses, states, includedLetters, unincludedLetters, unattemptedLetters).toLowerCase();
                            System.out.println(guess4);
                            if(guess4 == null || guess4.isEmpty())
                                if(Msg.yN("Are you sure you want to quit?", "") == JOptionPane.YES_OPTION) System.exit(0);
                                else continue;
                            else if (guess4.length() != 5) {
                                Msg.msg("Invalid length! The guess must be five letters long.");
                                continue;
                            }
                            else if (guesses.contains(guess4.toLowerCase())) {
                                Msg.msg("You already guessed this!"); continue;
                            }
                            try {
                                if (Word.isInvalid(guess4)) {
                                    Msg.msg("Invalid word! This word is not in the database.");
                                    continue;
                                }
                            } catch(Exception e) {
                                Msg.msg("Invalid word! This word is not in the database.");
                                continue;
                            }
                            break;
                        }
                        state4 = word.getHint(guess4);
                        if(checkVictory(state4)) { Msg.victoryMsg("You didn't do half bad! Good job.", 4); continue; }
                        else {
                            Msg.incorrectMsg(guess4, state4, "Just focus and you'll be able to make it. Stay locked.");
                            guesses.add(guess4);
                            states.add(state4);
                            Word.addLetters(includedLetters, unattemptedLetters, unincludedLetters, guess4, state4);
                            while(true) {
                                guess5 = Msg.nextStageMsg(5, guesses, states, includedLetters, unincludedLetters, unattemptedLetters).toLowerCase();
                                System.out.println(guess5);
                                if(guess5 == null || guess5.isEmpty())
                                    if(Msg.yN("Are you sure you want to quit?", "") == JOptionPane.YES_OPTION) System.exit(0);
                                    else continue;
                                else if (guess5.length() != 5) {
                                    Msg.msg("Invalid length! The guess must be five letters long.");
                                    continue;
                                }
                                else if (guesses.contains(guess5.toLowerCase())) {
                                    Msg.msg("You already guessed this!"); continue;
                                }
                                try {
                                    if (Word.isInvalid(guess5)) {
                                        Msg.msg("Invalid word! This word is not in the database.");
                                        continue;
                                    }
                                } catch(Exception e) {
                                    Msg.msg("Invalid word! This word is not in the database.");
                                    continue;
                                }
                                break;
                            }
                            state5 = word.getHint(guess5);
                            if(checkVictory(state5)) { Msg.victoryMsg("You cut it a little close, but you made it in the end!", 5); continue; }
                            else {
                                Msg.incorrectMsg(guess5, state5, "Last chance! Focus up and get this right.");
                                guesses.add(guess5);
                                states.add(state5);
                                Word.addLetters(includedLetters, unattemptedLetters, unincludedLetters, guess5, state5);
                                while(true) {
                                    guess6 = Msg.nextStageMsg(6, guesses, states, includedLetters, unincludedLetters, unattemptedLetters).toLowerCase();
                                    System.out.println(guess6);
                                    if(guess6 == null || guess6.isEmpty())
                                        if(Msg.yN("Are you sure you want to quit?", "") == JOptionPane.YES_OPTION) System.exit(0);
                                        else continue;
                                    else if (guess6.length() != 5) {
                                        Msg.msg("Invalid length! The guess must be five letters long.");
                                        continue;
                                    }
                                    else if (guesses.contains(guess6.toLowerCase())) {
                                        Msg.msg("You already guessed this!"); continue;
                                    }
                                    try {
                                        if (Word.isInvalid(guess6)) {
                                            Msg.msg("Invalid word! This word is not in the database.");
                                            continue;
                                        }
                                    } catch(Exception e) {
                                        Msg.msg("Invalid word! This word is not in the database.");
                                        continue;
                                    }
                                    break;
                                }
                                state6 = word.getHint(guess6);
                                if(checkVictory(state6)) { Msg.victoryMsg("Phew! That was a close one, but you were able to make it.", 6); }
                                else {
                                    Msg.defeatMsg(word);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean checkVictory(String state) {
        return !(state.contains("+") || state.contains("*"));
    }
}
