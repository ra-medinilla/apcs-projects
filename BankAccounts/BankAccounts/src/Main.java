import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Account gary = new Account("Gary", "101", 31.03, "Mon Aug 23 07:50:00 EST 2021", true);
        Account nussy = new Account("Nussy", "102", 32.25, "Mon Aug 23 08:40:00 EST 2021", true);
        Account eddy = new Account("Eddy", "103", 31.24, "Mon Aug 23 09:30:00 EST 2021", true);
        Account alvy = new Account("Alvy", "94", 22.10, "Tue Sep 1 09:35:00 EST 2020", true);
        Account mary = new Account("Mary", "93", 31.07, "Mon Aug 31 09:35:00 EST 2020", true);
        Account ivy = new Account("Ivy", "106", 41.10, "Mon Aug 23 13:25:00 EST 2021", true);
        Account wuttky = new Account("Wuttky", "91", 41.07, "Mon Aug 31 07:20:00 EST 2020", true);
        Account robby = new Account("Robby", "92", 33.23, "Tue Sep 1 07:20:00 EST 2020", true);
        Account army = new Account("Army", "95", 33.02, "Mon Aug 31 12:25:00 EST 2020", true);
        Account lissy = new Account("Lissy", "96", 22.01, "Tue Sep 1 12:25:00 EST 2020", true);
        Overseer o = new Overseer();
    }
}
