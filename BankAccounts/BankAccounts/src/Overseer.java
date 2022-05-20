import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

// Runs the program through the constructor with a bunch of JOptionPane chains
public class Overseer {

    // Not gonna break it down part by part, this is just a long list of JOptionPanes that circles around easily to navigate the bank menu
    public Overseer() {
        JOptionPane.showMessageDialog(null,
                Account.introMessage(),
                "Summary",
                JOptionPane.PLAIN_MESSAGE, null);
        while(true) {
            String[] mainOptionArr = new String[]
                    {"Summarize Finances", "Search the Registry", "Modify the Registry", "Close"};
            int main = JOptionPane.showOptionDialog(null,
                    Account.mainMessage(),
                    "Home",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    mainOptionArr, mainOptionArr[mainOptionArr.length-1]);
            if(main == 0) {
                Account.displaySummary();
                continue;
            }
            if(main == 1) {
                String[] stringSearchOptions = new String[] {"Search by Name", "Search by Number", "Back"};
                int searchOption = JOptionPane.showOptionDialog(null,
                        searchMessage(),
                        "Search the Registry",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        stringSearchOptions, stringSearchOptions[2]);
                if(searchOption == 0) {
                    boolean _continue = true;
                    while(_continue) {
                        String s = JOptionPane.showInputDialog(null, "Enter a name.\n");
                        if(s == null) _continue = false;
                        else if (s.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter a valid name.");
                        else {
                            if(!Account.stringSearchByName(s).isEmpty()) {
                                JOptionPane.showMessageDialog(null, Account.stringSearchByName(s));
                                _continue = false;
                            }
                            else JOptionPane.showMessageDialog(null, "Account not found!\nTry using different search criteria.");
                        }
                    }
                }
                else if(searchOption == 1) {
                    boolean _continue = true;
                    while(_continue) {
                        String s = JOptionPane.showInputDialog(null, "Enter a number.\n");
                        if(s == null) _continue = false;
                        else if (s.isEmpty()) JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                        else {
                            if(!Account.stringSearchByNumber(s).isEmpty()) {
                                JOptionPane.showMessageDialog(null, Account.stringSearchByNumber(s));
                                _continue = false;
                            }
                            else JOptionPane.showMessageDialog(null, "Account not found!\nTry using different search criteria.");
                        }
                    }
                }
            }
            else if(main == 2) {
                try {
                        String[] option1 = { "Existing Account", "New Account" };
                        if(JOptionPane.showOptionDialog(null, "Would you like to modify an existing account or create a new account?",
                                "Choose What to Do",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                null, option1, option1[0]) == 0) {
                            boolean _continue = true;
                            while (_continue) {
                                String input = JOptionPane.showInputDialog(null, "For security reasons, searching to modify by name is not allowed.\nInput an account number.", "Find an Account to Modify", JOptionPane.QUESTION_MESSAGE);
                                if(input == null) { _continue = false; continue; }
                                Account acc = Account.findAccount(input);
                                if (acc == null)
                                    JOptionPane.showMessageDialog(null, "No account was found with that number. Please try again.");
                                else {
                                    String[] option2 = {"Deposit", "Withdraw", "Change Status", "Delete Account", "Close"};
                                    int optionChosen2 = JOptionPane.showOptionDialog(null, acc + "What would you like to do with this account?", "Account of " + acc.getName(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option2, option2[0]);
                                    if (optionChosen2 == 0) {
                                        acc.deposit();
                                    }
                                    else if (optionChosen2 == 1) {
                                        acc.withdraw();
                                    }
                                    else if (optionChosen2 == 2) {
                                        if(JOptionPane.showConfirmDialog(null, "Should the account be frozen?", "Change Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                                            acc.freeze();
                                        }
                                        else acc.unfreeze();
                                    }
                                    else if (optionChosen2 == 3) {
                                        String message1 = "";
                                        if(acc.getOriginal()) message1 += "Please refrain from deleting already pre-existing accounts!\nAre you sure you want to delete this account?";
                                        else message1 += "Are you sure you want to delete the account?";
                                        if(JOptionPane.showConfirmDialog(null, message1, "Delete Account", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0)
                                        { acc.delAccount(); _continue = false; }
                                    }
                                    else _continue = false;
                                }
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, Account.addAccount());
                        }
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Something went wrong.");
                }
            }
            else {
                String[] optionsLeave = new String[] { "Return to the Main Menu", "Close the Application"};
                if(JOptionPane.showOptionDialog(null,
                        "Would you like to close the application?", "Leaving so soon?",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsLeave, optionsLeave[0]) == 1) {
                    if(!Account.getDeletedOriginal() && !Account.getAllowedFugitive()) {
                        URL url = getClass().getClassLoader().getResource("default.png");
                        ImageIcon display = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
                        JOptionPane.showMessageDialog(null, "", "The Next Day...", JOptionPane.PLAIN_MESSAGE, display);
                    }
                    else if(Account.getDeletedOriginal() && Account.getAllowedFugitive()) {
                        URL url = getClass().getClassLoader().getResource("doublewhammy.png");
                        ImageIcon display = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
                        JOptionPane.showMessageDialog(null, "", "The Next Day...", JOptionPane.PLAIN_MESSAGE, display);                    }
                    else if(Account.getDeletedOriginal()) {
                        URL url = getClass().getClassLoader().getResource("deletedoriginal.png");
                        ImageIcon display = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
                        JOptionPane.showMessageDialog(null, "", "The Next Day...", JOptionPane.PLAIN_MESSAGE, display);
                    }
                    else {
                        URL url = getClass().getClassLoader().getResource("escapedfugitive.png");
                        ImageIcon display = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
                        JOptionPane.showMessageDialog(null, "", "The Next Day...", JOptionPane.PLAIN_MESSAGE, display);
                    }
                    break;
                }
            }
        }
    }

    // Determines whether to search by name or number
    public static String searchMessage() {
        String retVal = "";
        retVal += "Do you want to search by the name listed on the account\nor by the account number?";
        return retVal;
    }
    
    // Useless
    public static String casinoQuestion1() {
        return "Do you want to gamble away all your money?";
    }

}
