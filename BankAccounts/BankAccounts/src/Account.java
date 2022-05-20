import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

// Account stores all the information for a certain bank account and allows modifications
public class Account implements Comparable<Account> {

    // Instance Variables, Getters, and Setters
    private String _name;
    public String getName() { return _name; }

    private String _actNum;
    public String getActNum() { return _actNum; }
    
    // Generates an unused account number
    private String generate() {
        boolean _continue = true;
        while(true) {
            String rand = String.valueOf((int)(Math.random() * 90000) + 10000);
            boolean isMatched = false;
            for(Account a : registry) {
                if(rand.equals(a.getActNum())) isMatched = true;
            }
            if(!isMatched) { return rand; }
        }
    }
    private double _bal;
    public double getBal() { return _bal; }
    public void changeBal(double b) { _bal += b; }
    public void setBal(double b) { _bal = b; }
    private static final NumberFormat defaultFormat = NumberFormat.getCurrencyInstance();
    private static boolean DELETEDORIGINALACCOUNT = false;
    private boolean _originalAccount = false;
    public boolean getOriginal() { return _originalAccount; }
    private static boolean CONVICTEDFUGITIVEALLOWED = false;
    public static boolean getAllowedFugitive() { return CONVICTEDFUGITIVEALLOWED; }
    public static boolean getDeletedOriginal() { return DELETEDORIGINALACCOUNT; }

    // Adds money to an account
    public void deposit() {
        boolean _cont = true;
        if(!this._isFrozen) {
            while (_cont) {
                String s = JOptionPane.showInputDialog(null, "Please enter an amount of money." +
                        "\nNumbers and a period only, please.");
                try {
                    if(s == null) break;
                    double d = Double.valueOf(s);
                    if (d > 0) {
                        _bal += d;
                        _bal = ((int)((_bal * 100) + 0.5)) / 100.0;
                        JOptionPane.showMessageDialog(null, defaultFormat.format(d) + " was deposited into the account. It now has a balance of " + this.getStringBal() + ".");
                        _cont = false;
                    } else if (d == 0) {
                        _cont = false;
                        JOptionPane.showMessageDialog(null, "No modifications inputted, so the balance was not changed.");
                    } else JOptionPane.showMessageDialog(null, "Please input a number greater than 0. ");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "bro what did i say i told you not to input anything that " +
                            "wasn't a number or one period\nscrew formality you deserve to die\ni extend myself to you so that you can " +
                            "take advantage of my resources but NOOOOOO you had to break\n my ONE rule\n\ndie");
                }
            }
        }
        else JOptionPane.showMessageDialog(null, "The account is frozen, so its balance cannot be modified.");
    }
    
    // Removes money from account
    public void withdraw() {
        boolean _cont = true;
        if (!this._isFrozen) {
            while (_cont) {
                String s = JOptionPane.showInputDialog(null, "Please enter an amount of money." +
                        "\nNumbers and a period only, please.");
                try {
                    if(s == null) break;
                    double d = Double.valueOf(s);
                    if (d > 0 && (_bal - d) >= 0) {
                        _bal -= d;
                        _bal = ((int)((_bal * 100) + 0.5)) / 100.0;
                        JOptionPane.showMessageDialog(null, defaultFormat.format(d) +  " was withdrawn from the account. It now has a balance of " + this.getStringBal() + ".");
                        _cont = false;
                    } else if (d == 0) {
                        _cont = false;
                        JOptionPane.showMessageDialog(null, "No modifications inputted, so the balance was not changed.");
                    } else if (d < 0) JOptionPane.showMessageDialog(null, "Please input a number greater than 0. ");
                    else {
                        JOptionPane.showMessageDialog(null, "ERROR: You are overdrawing your account. Try a smaller number.");
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "bro what did i say i told you not to input anything that " +
                            "wasn't a number or one period\nscrew formality you deserve to die\ni extend myself to you so that you can " +
                            "take advantage of my resources but NOOOOOO you had to break\n my ONE rule\n\ndie");
                }
            }
        }
    }
    
    private boolean _isFrozen;
    public boolean isFrozen() { return _isFrozen; }
    public void freeze() { _isFrozen = true; }
    public void unfreeze() { _isFrozen = false; }
    public void changeStatus(boolean b) { _isFrozen = b; }

    private String _creationDate;
    public String getCreationDate() { return _creationDate; }

    private boolean _isMarkedForDeletion;

    private static ArrayList<Account> registry = new ArrayList<Account>();

    // Creates a bank account with random values apart from the name and adds it to the registry
    public Account(String name) {
        _name = name;
        _actNum = generate();
        _bal = 0;
        _isFrozen = false;
        _creationDate = java.util.Calendar.getInstance().getTime().toString();
        _isMarkedForDeletion = false;
        registry.add(this);
    }
       
    // Creates an original bank account with given values and adds it to the registry
    public Account(String name, String actNum, double bal, String creationDate, boolean original) {
        _name = name;
        _actNum = actNum;
        _bal = bal;
        _isFrozen = false;
        _creationDate = creationDate;
        _isMarkedForDeletion = false;
        _originalAccount = original;
        registry.add(this);
    }
    
    // Creates a bank account with given name, account number, and balance
    public Account(String name, String actNum, double bal) {
        _name = name;
        _actNum = actNum;
        _bal = bal;
        _isFrozen = false;
        _creationDate = java.util.Calendar.getInstance().getTime().toString();
        _isMarkedForDeletion = false;
        registry.add(this);
    }
    
    // Creates a bank account with given name and balance
    public Account(String name, double bal) {
        _name = name;
        int tempNum = 0;
        _actNum = generate();
        _bal = bal;
        _isFrozen = false;
        _creationDate = java.util.Calendar.getInstance().getTime().toString();
        _isMarkedForDeletion = false;
        registry.add(this);
    }

    // Creates a new bank account with given values
    public Account(String name, String actNum, double bal, boolean isFrozen, String creationDate) {
        _name = name;
        _actNum = actNum;
        _bal = bal;
        _isFrozen = isFrozen;
        _creationDate = creationDate;
        _isMarkedForDeletion = false;
        registry.add(this);
    }

    // Main screen/summary display method using JOptionPane
    public static void displaySummary() {
        String displayVal = "";
        displayVal += "Welcome to Riquense Central Bank!\n";
        displayVal += "The bank currently has " + registry.size() + " accounts, and has a total of " + getTotalBal() + " deposited.";
        String[] options = {"Show List of Accounts", "Back"};
        int option = JOptionPane.showOptionDialog(null, displayVal, "", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        if(option == 0) {
            JOptionPane.showMessageDialog(null, getList());
        }
    }

    // Creates a new account with JOptionPane
    public static Account addAccount() {
        Account acc = new Account(JOptionPane.showInputDialog("What will be the name registered to the account?\nPlease do not let Rodrigo, the convicted fugitive, register an account here."));
        if(acc.getName().equalsIgnoreCase("Rodrigo")) CONVICTEDFUGITIVEALLOWED = true;
        return acc;
    }

    // Shows an introduction message
    public static String introMessage() {
        String retVal = "";
        retVal += "Greetings, stranger!\nThis is the internal mainframe of Riquense Central Bank.\n\n" +
                "Thensday, Julieth 26, 2013, is our annual \"Open Access\" Day, which lets anyone access the resources\n" +
                "& information this bank possesses.";
        return retVal;
    }

    // Shows a screen to perform actions
    public static String mainMessage() {
        String retVal = "What do you want to do?";
        return retVal;
    }

    // Deletes an account
    public void delAccount() {
        if(this._originalAccount) DELETEDORIGINALACCOUNT = true;
        _isMarkedForDeletion = true;
        registry.remove(this);
    }

    // Deletes accounts with a certain name
    public static void delNameAccounts(ArrayList<Account> search) {
        for(Account a : search) {
            if(registry.contains(a)) { unregister(a); a.delAccount(); }
        }
    }

    // Deletes accounts with a certain account number
    public static void delNumAccounts(String search) {

    }

    // Returns the full registry of bank accounts
    public static ArrayList<Account> getRegistry() {
        if(registry == null) registry = new ArrayList<Account>();
        return registry;
    }

    // Removes an account from the registry
    public static void unregister(Account a) {
        registry.remove(a);
    }

    // Returns a list of accounts with a certain string in alphabetical order
    public static ArrayList<Account> searchByName(String search) {
        ArrayList<Account> retList = new ArrayList<>();
        for(Account a : registry) {
            if(!a._isMarkedForDeletion) {
                System.out.println(a.getName().toLowerCase().contains(search.toLowerCase()) + "\n" + a.getName() + "\n");
                if (a.getName().toLowerCase().contains(search.toLowerCase())) retList.add(a);
            }
        }
        Collections.sort(retList, nameComparator);
        return retList;
    }

    // Returns a list of accounts with a certain account number substring in order
    public static ArrayList<Account> searchByNumber(String search) {
        ArrayList<Account> retList = new ArrayList<>();
        for(Account a : registry) {
            if(!a._isMarkedForDeletion) if(a.getActNum().toLowerCase().contains(search.toLowerCase())) retList.add(a);
        }
        Collections.sort(retList, actNumComparator);
        return retList;
    }

    // Returns a list.toString() of searched accounts by name
    public static String stringSearchByName(String search) {
        String retVal = "";
        for(Account a : searchByName(search)) {
            retVal += a + "\n";
        }
        return retVal;
    }

    // Returns a list.toString() of searched accounts by number
    public static String stringSearchByNumber(String search) {
        String retVal = "";
        for(Account a : searchByNumber(search)) {
            retVal += a + "\n";
        }
        return retVal;
    }

    // Account finder looking by account number
    public static Account findAccount(String actNum) {
        ArrayList<Account> list = new ArrayList<>();
        for(Account a : registry) {
            if(!a._isMarkedForDeletion && a.getActNum().equals(actNum)) list.add(a);
        }
        if(list.size() == 1) return list.get(0);
        else if(list.size() > 1) {
            String[] names = new String[list.size()];
            for(Account a : list) { names[0] = list.get(0).getName(); }
            int index = JOptionPane.showOptionDialog(null, "Your search is unclear, since multiple accounts use this number. Which account are you referring to?", "Choose an Account", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, names, names[0]);
        }
        return null;
    }
    
    // Prints registry to console
    public static void printList() {
        for(Account a : registry) {
            System.out.println(a);
        }
        System.out.println();
    }

    // Returns registry.toString()
    public static String getList() {
        String retVal = "";
        for(Account a : registry) {
            retVal += a.toString() + "\n";
        }
        return retVal;
    }

    // Prints total balance in the bank
    public static void printTotal() {
        double total = 0;
        for(Account a : registry) {
            total += a.getBal();
        }
        String sTotal = String.valueOf(total);
        int index = sTotal.indexOf(".");
        String subTotal = sTotal.substring(0, index);
        String subTotal2 = sTotal.substring(index);
        String retVal = "$";
        for(int i = 0; i < index; i++) {
            if((subTotal.length() - i) % 3 == 0 && i != 0) retVal += ",";
            retVal += subTotal.charAt(i);
        }
        retVal += subTotal2;
        System.out.println(retVal);
    }

    // Returns total balance in the bank
    public static String getTotalBal() {
        double total = 0;
        for (Account a : registry) {
            total += a.getBal();
        }
        return defaultFormat.format(total);
    }

    // Returns balance of account in $money form
    public String getStringBal() {
        return defaultFormat.format(_bal);
    }

    // Converts Account to String-able form
    public String toString() {
        if(_name.endsWith("s") && !_isFrozen)
            return _name + "' account at Riquense Central Bank has a balance of " +
                    getStringBal() + ".\n" + "Account number: " + _actNum + "\n" +
                    "It was created on " + _creationDate + " and is currently unfrozen.\n";
        else if(_name.endsWith("s") && _isFrozen)
            return _name + "' account at Riquense Central Bank has a balance of " +
                    getStringBal() + ".\n" + "Account number: " + _actNum + "\n" +
                    "It was created on " + _creationDate + " and is currently frozen.\n";
        else if(_isFrozen)
            return _name + "'s account at Riquense Central Bank has a balance of " +
                    getStringBal() + ".\n" + "Account number: " + _actNum + "\n" +
                    "It was created on " + _creationDate + " and is currently frozen.\n";
        else
            return _name + "'s account at Riquense Central Bank has a balance of " +
                    getStringBal() + ".\n" + "Account number: " + _actNum + "\n" +
                    "It was created on " + _creationDate + " and is currently unfrozen.\n";
    }

    public int compareTo(Account other) {
        return _name.compareTo(other._name);
    }

    // Creates a new comparator by name
    public static Comparator<Account> nameComparator = new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o1._name.compareTo(o2._name);
        }
    };

    // Creates a new comparator by number
    public static Comparator<Account> actNumComparator = new Comparator<Account>() {
        @Override
        public int compare(Account o1, Account o2) {
            return o1._actNum.compareTo(o2._actNum);
        }
    };

}
