import java.util.ArrayList;

public class Problem {

    public static final int ADDITION = -4074;
    public static final int ADDITIONWP = ADDITION/2;
    public static final int SUBTRACTION = -3974;
    public static final int SUBTRACTIONWP = SUBTRACTION/2;
    public static final int MULTIPLICATION1 = -3875;
    public static final int MULTIPLICATION2 = -3873;
    public static final int DIVISION1 = -3775;
    public static final int DIVISION2 = -3773;
    public static final int FOIL = -3725;
    public static final int FACTORING1 = -3701;
    public static final int FACTORING2 = -3700;
    public static final int EXPONENTIATION1 = -3675;
    public static final int EXPONENTIATION2 = -3673;
    public static final int DERIVATIVE = -3574;
    public static final int INTEGRAL = -3474;

    public static final int[] basicArithmetic = new int[]{ADDITION, SUBTRACTION, MULTIPLICATION1, DIVISION1};
    public static final int[] difficultArithmetic = new int[]{ADDITION, SUBTRACTION, MULTIPLICATION2, DIVISION2};
    public static final int[] allArithmetic = new int[]{ADDITION, SUBTRACTION, MULTIPLICATION1, MULTIPLICATION2, DIVISION1, DIVISION2};
    public static final int[] basicAlgebra = new int[]{FOIL, FACTORING1, EXPONENTIATION1};
    public static final int[] difficultAlgebra = new int[]{FOIL, FACTORING2, EXPONENTIATION2};
    public static final int[] allAlgebra = new int[]{FOIL, FACTORING1, FACTORING2, EXPONENTIATION1, EXPONENTIATION2};
    public static final int[] basicCalculus = new int[]{DERIVATIVE, INTEGRAL};

    private static ArrayList<Problem> correctRegistry;
    public static ArrayList<Problem> getCorrectRegistry() { return correctRegistry; }

    private static final boolean I_AM_DEBUGGING = false;

    private String expression; public String getExpression() { return expression; }
    private int type; public int getType() { return type; }
    private String answer; public String getAnswer() { return answer; }
    private String answer2; public String getAnswer2() { return answer2; }
    private int factor1; public int getFactor1() { return factor1; }
    private int factor2; public int getFactor2() { return factor2; }
    private int factor3; public int getFactor3() { return factor3; }
    private int factor4; public int getFactor4() { return factor4; }
    private int tries;

    // Creates a problem using a certain number to generate a type
    public Problem(int type) {
        if(correctRegistry == null) correctRegistry = new ArrayList<>();
        boolean cont = true;
        switch(type) {
            case ADDITION:
                type = ADDITION;
                if(I_AM_DEBUGGING) System.out.println("Type: Addition");
                while(cont) {
                    factor1 = (int)((Math.random() * 999) + 1);
                    factor2 = (int)((Math.random() * 999) + 1);
                    factor3 = (int)((Math.random() * 999) + 1);
                    if (I_AM_DEBUGGING) System.out.println(factor1 + "\n" + factor2 + ", " + factor3);
                    if (factor1 + factor2 + factor3 > 1000) { if(I_AM_DEBUGGING) System.out.println("Greater than 1000"); continue; }
                    cont = false;
                    if(I_AM_DEBUGGING) System.out.println("Loop ended.");
                }
                answer = String.valueOf(factor1 + factor2 + factor3);
                if(I_AM_DEBUGGING) System.out.println("Answer: " + answer);
                expression = "What is " + factor1 + " + " + factor2 + " + " + factor3 + "? ";
                if(I_AM_DEBUGGING) System.out.println(expression + "\n");
                break;
            case ADDITIONWP:
                type = ADDITIONWP;
                if(I_AM_DEBUGGING) System.out.println("Type: Addition Word Problems");
                int rand = (int)(Math.random() * 4);
                if(rand == 0) {
                    while(cont) {
                        factor1 = (int)(Math.random() * 10) + 1; factor2 = (int)(Math.random() * 10) + 1;
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 + factor2 > 20) { if(I_AM_DEBUGGING) System.out.println("Greater than 20"); continue; }
                        cont = false;
                    }
                    expression = "Jack has " + factor1 + " chocolate chip cookies in his cookie jar.\n" +
                            "He bakes " + factor2 + " more cookies and puts them in the cookie jar.\n" +
                            "How many cookies are now in the jar? ";
                    answer = String.valueOf(factor1 + factor2);
                }
                else if(rand == 1) {
                    while(cont) {
                        factor1 = (int)(Math.random() * 30) + 1; factor2 = (int)(Math.random() * 30) + 1;
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 + factor2 > 50) { if(I_AM_DEBUGGING) System.out.println("Greater than 50"); continue; }
                        cont = false;
                    }
                    expression = "Joseph has " + factor1 + " tennis balls.\n" +
                            "He goes to the store and buys " + factor2 + " more tennis balls.\n" +
                            "How many tennis balls does Joseph have now? ";
                    answer = String.valueOf(factor1 + factor2);
                }
                else if(rand == 2) {
                    while(cont) {
                        factor1 = (int)(Math.random() * 70) + 1; factor2 = (int)(Math.random() * 70) + 1;
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 + factor2 > 100) { if(I_AM_DEBUGGING) System.out.println("Greater than 100"); continue; }
                        cont = false;
                    }
                    expression = "Lucas has " + factor1 + " Pokemon cards.\n" +
                            "He buys a pack of " + factor2 + " more Pokemon cards.\n" +
                            "How many Pokemon cards does Lucas have now? ";
                    answer = String.valueOf(factor1 + factor2);
                }
                else {
                    factor1 = (int)(Math.random() * 500) + 1; factor2 = (int)(Math.random() * 500) + 1;
                    if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                    expression = "Arlette has " + factor1 + " pins.\n" +
                            "She goes to the mall and buys " + factor2 + " more pins.\n" +
                            "How many pins does Arlette have now? ";
                    answer = String.valueOf(factor1 + factor2);
                }
                if(I_AM_DEBUGGING) { System.out.println(expression + "\n"); System.out.println("Answer: " + answer);  }
                break;
            case SUBTRACTION:
                type = SUBTRACTION;
                if(I_AM_DEBUGGING) System.out.println("Type: Subtraction");
                while(cont) {
                    factor1 = (int)((Math.random() * 999) + 1);
                    factor2 = (int)((Math.random() * 999) + 1);
                    factor3 = (int)((Math.random() * 999) + 1);
                    if(I_AM_DEBUGGING) System.out.println(factor1 + "\n" + factor2 + ", " + factor3);
                    if (factor1 - factor2 - factor3 < 0) { if(I_AM_DEBUGGING) System.out.println("Less than 0"); continue; }
                    cont = false; if(I_AM_DEBUGGING) System.out.println("Loop ended.");
                }
                answer = String.valueOf(factor1 - factor2 - factor3);
                expression = "What is " + factor1 + " - " + factor2 + " - " + factor3 + "? ";
                if(I_AM_DEBUGGING) { System.out.println(expression + "\n"); System.out.println("Answer: " + answer);  }
                break;
            case SUBTRACTIONWP:
                rand = (int)(Math.random() * 5);
                if(I_AM_DEBUGGING) System.out.println("Type: Subtraction Word Problems");
                if(rand == 0) {
                    while(cont) {
                        factor1 = (int)(Math.random() * 20) + 1; factor2 = (int)(Math.random() * 20) + 1;
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 - factor2 <= 0) { if(I_AM_DEBUGGING) System.out.println("Less than/equal to zero"); continue; }
                        cont = false;
                    }
                    expression = "Jonathan has " + factor1 + " chocolate bars in his backpack.\n" +
                            "He gets hungry and ends up eating " + factor2 + " chocolate bars.\n" +
                            "How many chocolate bars are still in his backpack? ";
                    answer = String.valueOf(factor1 - factor2);
                }
                else if(rand == 1) {
                    while(cont) {
                        factor1 = (int)(Math.random() * 100) + 1; factor2 = (int)(Math.random() * 100) + 1;
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 - factor2 <= 0) { if(I_AM_DEBUGGING) System.out.println("Less than/equal to zero"); continue; }
                        cont = false;
                    }
                    expression = "Billy has " + factor1 + " watermelons in his truck.\n" +
                            "He drives over a pothole and " + factor2 + " watermelons fall out of his truck.\n" +
                            "How many watermelons are still in his truck? ";
                    answer = String.valueOf(factor1 - factor2);
                }
                else if(rand == 2) {
                    while(cont) {
                        factor1 = (int)(Math.random() * 1000) + 1; factor2 = (int)(Math.random() * 1000) + 1;
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 - factor2 <= 0) { if(I_AM_DEBUGGING) System.out.println("Less than/equal to zero"); continue; }
                        cont = false;
                    }
                    expression = "Ivy has " + factor1 + " ants in her ant farm.\n" +
                            "She bumps into it and cracks the glass, letting " + factor2 + " ants escape the ant farm.\n" +
                            "How many ants are still in her ant farm? ";
                    answer = String.valueOf(factor1 - factor2);
                }
                else if (rand == 3) {
                    while(cont) {
                        factor1 = (int)(Math.random() * 5000) + 1; factor2 = (int)(Math.random() * 5000) + 1;
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 - factor2 <= 0) { if(I_AM_DEBUGGING) System.out.println("Less than/equal to zero"); continue; }
                        cont = false;
                    }
                    expression = "Robbie has " + factor1 + " marbles in his toy box.\n" +
                            "Suddenly, he tips the box over and " + factor2 + " marbles fall out of the box.\n" +
                            "How many marbles are still in his toy box? ";
                    answer = String.valueOf(factor1 - factor2);
                }
                else {
                    while(cont) {
                        factor1 = (int) (Math.random() * 8 + 1);
                        factor2 = (int) (Math.random() * 8 + 1);
                        if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                        if(factor1 - factor2 <= 0) { if(I_AM_DEBUGGING) System.out.println("Less than/equal to zero."); continue; }
                        cont = false;
                    }
                    expression = "You have " + factor1 + " slices of pizza left in a box.\n" +
                            "You eat " + factor2 + " slices.\n" +
                            "How many slices are left in the box? ";
                    answer = String.valueOf(factor1 - factor2);
                }
                if(I_AM_DEBUGGING) { System.out.println(expression + "\n"); System.out.println("Answer: " + answer);  }
                break;
            case MULTIPLICATION1:
                type = MULTIPLICATION1;
                if(I_AM_DEBUGGING) System.out.println("Type: Easy Multiplication");
                while(cont) {
                    factor1 = (int) (Math.random() * 11) + 2;
                    factor2 = (int) (Math.random() * 11) + 2;
                    if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                    if (factor1 * factor2 > 144) { System.out.println("Greater than 144"); continue; }
                    cont = false;
                    if(I_AM_DEBUGGING) System.out.println("Loop ended.");
                }
                answer = String.valueOf(factor1 * factor2);
                expression = "What is " + factor1 + " times " + factor2 + "? ";
                if(I_AM_DEBUGGING) { System.out.println("Answer: " + answer); System.out.println(expression + "\n"); }
                break;
            case MULTIPLICATION2:
                type = MULTIPLICATION2;
                if(I_AM_DEBUGGING) System.out.println("Type: Hard Multiplication");
                while(cont) {
                    factor1 = (int) (Math.random() * 11) + 2;
                    factor2 = (int) (Math.random() * 11) + 2;
                    factor3 = (int) (Math.random() * 11) + 2;
                    if(I_AM_DEBUGGING) System.out.println(factor1 + "\n" + factor2 + ", " + factor3);
                    if (factor1 * factor2 * factor3 > 1000) { if(I_AM_DEBUGGING) System.out.println("Greater than 1000"); continue; }
                    else if (factor1 <= 2 || factor2 <= 2 || factor3 <= 2) { if(I_AM_DEBUGGING) System.out.println("Factor too simple"); continue; }
                    cont = false;
                    if(I_AM_DEBUGGING) System.out.println("Loop ended.");
                }
                answer = String.valueOf(factor1 * factor2 * factor3);
                expression = "What is " + factor1 + " times " + factor2 + " times " + factor3 + "? ";
                if(I_AM_DEBUGGING) { System.out.println("Answer: " + answer); System.out.println(expression + "\n"); }
                    break;
            case DIVISION1:
                type = DIVISION1;
                if(I_AM_DEBUGGING) System.out.println("Type: Easy Division");
                while(cont) {
                    factor1 = (int) ((Math.random() * 143) + 1);
                    factor2 = (int) ((Math.random() * 11) + 1);
                    if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                    if (factor1 % factor2 != 0) { if(I_AM_DEBUGGING) System.out.println("Not evenly divisible"); continue; }
                    else if (factor2 == 1) { if(I_AM_DEBUGGING) System.out.println("Divisor is 1"); continue; }
                    else if (factor1 == factor2) { if(I_AM_DEBUGGING) System.out.println("Quotient is 1"); continue; }
                    cont = false; if(I_AM_DEBUGGING) System.out.println("Loop ended.");
                }
                answer = String.valueOf(factor1 / factor2);
                expression = "What is " + factor1 + " divided by " + factor2 + "? ";
                if(I_AM_DEBUGGING) System.out.println("Answer: " + answer + "\n" + expression + "\n");
                break;
            case DIVISION2:
                type = DIVISION2;
                if(I_AM_DEBUGGING) System.out.println("Type: Hard Division");
                while(cont) {
                    factor1 = (int) ((Math.random() * 999) + 1);
                    factor2 = (int) ((Math.random() * 999) + 1);
                    if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                    if (factor1 % factor2 != 0) { if(I_AM_DEBUGGING) System.out.println("Not evenly divisible"); continue; }
                    else if (factor2 == 1) { if(I_AM_DEBUGGING) System.out.println("Divisor is 1"); continue; }
                    else if (factor2 < 9 || factor2 == 10) { if(I_AM_DEBUGGING) System.out.println("Divisor is too simple"); continue; }
                    else if (factor1 == factor2) { if(I_AM_DEBUGGING) System.out.println("Quotient is 1"); continue; }
                    cont = false; if(I_AM_DEBUGGING) System.out.println("Loop ended.");
                }
                answer = String.valueOf(factor1 / factor2);
                expression = "What is " + factor1 + " divided by " + factor2 + "? ";
                if(I_AM_DEBUGGING) System.out.println("Answer: " + answer + "\n" + expression + "\n");
                break;
            case FOIL:
                type = FOIL;
                if(I_AM_DEBUGGING) System.out.println("Type: FOIL");
                factor1 = (int)(Math.random() * 5) + 1; factor2 = (int)(Math.random() * 21) - 10;
                factor3 = (int)(Math.random() * 5) + 1; factor4 = (int)(Math.random() * 21) - 10;
                expression = "Expand the following expression in standard form: ";
                expression += "("; if(factor1 != 1) expression += factor1; expression += "x";
                if(factor2 > 0) expression += " + " + factor2;
                else if(factor2 < 0) expression += " - " + Math.abs(factor2);
                expression += ")";
                expression += "("; if(factor3 != 1) expression += factor3; expression += "x";
                if(factor4 > 0) expression += " + " + factor4;
                else if(factor4 < 0) expression += " - " + Math.abs(factor4);
                expression += ")";
                if(factor1*factor3 != 1) answer = (factor1*factor3) + "x^2 ";
                else answer = "x^2 ";
                if((factor1*factor4) + (factor2*factor3) > 1) answer += "+ " + ((factor1*factor4) + (factor2*factor3)) + "x ";
                else if((factor1*factor4) + (factor2*factor3) < -1) answer += "- " + Math.abs(((factor1*factor4) + (factor2*factor3))) + "x ";
                else if((factor1*factor4) + (factor2*factor3) == 1) answer += "+ x ";
                else if((factor1*factor4) + (factor2*factor3) == -1) answer += "- x ";
                if(factor2*factor4 > 0) answer += "+ " + (factor2*factor4);
                else if(factor2*factor4 < 0) answer += "- " + Math.abs(factor2*factor4);
                if(I_AM_DEBUGGING) System.out.println(expression + "\nAnswer: " + answer);
                break;
            case FACTORING1:
                type = FACTORING1;
                if(I_AM_DEBUGGING) System.out.println("Type: Simple Factoring");
                factor1 = (int)(Math.random() * 21) - 10; factor2 = (int)(Math.random() * 21) - 10;
                if(factor2 > factor1) { int temp1 = factor1; factor1 = factor2; factor2 = temp1; }
                if(factor1 == 0 && factor2 != 0) { int temp1 = factor1; factor1 = factor2; factor2 = temp1; }
                expression = "Factor out the following expression: x^2 ";
                if(factor1 + factor2 > 1) expression += "+ " + (factor1 + factor2) + "x ";
                else if(factor1 + factor2 < -1) expression += "- " + Math.abs(factor1 + factor2) + "x ";
                else if((factor1) + (factor2) == 1) expression += "+ x ";
                else if((factor1) + (factor2) == -1) expression += "- x ";
                if(factor1 * factor2 > 0) expression += "+ " + (factor1*factor2);
                else if(factor1 * factor2 < 0) expression += "- " + Math.abs(factor1*factor2);
                expression +=
                        "\nPut the factor with the number A " +
                        "higher first for (x + A).\nFor example, (x + 4)(x - 1) rather than (x - 1)(x + 4).\n" +
                        "Additionally, put all zeros at the end.\nFor example, (x - 6)(x - 0) rather than (x - 0)(x - 6).";
                answer = "(x";
                if(factor1 > 0) answer += " + " + factor1 + ")(x";
                else if(factor1 < 0) answer += " - " + Math.abs(factor1) + ")(x";
                else answer += " - 0)(x";
                if(factor2 > 0) answer += " + " + factor2 + ")";
                else if(factor2 < 0) answer += " - " + Math.abs(factor2) + ")";
                else answer += " - 0)";
                if(I_AM_DEBUGGING) System.out.println(expression + "\n" + "Answer: " + answer + "\n");
                break;
            case FACTORING2:
                type = FACTORING2;
                if(I_AM_DEBUGGING) System.out.println("Type: Difficult Factoring");
                factor1 = (int)(Math.random() * 5) + 1; factor2 = (int)(Math.random() * 21) - 10; 
                factor3 = (int)(Math.random() * 5) + 1; factor4 = (int)(Math.random() * 21) - 10;
                if(factor3 > factor1) {
                    int temp1 = factor1, temp2 = factor2;
                    factor1 = factor3; factor2 = factor4;
                    factor3 = temp1; factor4 = temp2;
                } else if(factor3 == factor1 && factor4 > factor2) {
                    int temp1 = factor2;
                    factor2 = factor4; factor4 = temp1;
                }
                if(factor2 == 0 && factor4 != 0) { int temp1 = factor2; factor2 = factor4; factor4 = temp1; }
                if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2 + "; " + factor3 + ", " + factor4);
                expression = "Factor out the following expression: ";
                if(factor1*factor3 != 1) expression += (factor1*factor3); expression += "x^2 ";
                if((factor1*factor4) + (factor2*factor3) > 1) expression += "+ " + ((factor1*factor4) + (factor2*factor3)) + "x ";
                else if((factor1*factor4) + (factor2*factor3) < -1) expression += "- " + Math.abs(((factor1*factor4) + (factor2*factor3))) + "x ";
                else if((factor1*factor4) + (factor2*factor3) == 1) expression += "+ x ";
                else if((factor1*factor4) + (factor2*factor3) == -1) expression += "- x ";
                if(factor2*factor4 > 0) expression += "+ " + (factor2*factor4);
                else if(factor2*factor4 < 0) expression += "- " + Math.abs(factor2*factor4);
                expression += "\nThe highest coefficient of x should go first.\nFor example, (4x - 1)(2x + 3) rather than " +
                        "(2x + 3)(4x - 1).\n" +
                        "Additionally, in the case where the coefficients are the same, put the zero with the number A " +
                        "higher first for (x + A).\nFor example, (5x + 4)(5x - 1) rather than (5x - 1)(5x + 4).\n" +
                        "Put all zeros at the end.\nFor example, (x - 6)(x - 0) rather than (x - 0)(x - 6).";
                answer = "(";
                if(factor1 != 1) answer += factor1; answer += "x";
                if(factor2 > 0) answer += " + " + factor2 + ")("; else if(factor2 < 0) answer += " - " + Math.abs(factor2) + ")("; else answer += " - 0)(";
                if(factor3 != 1) answer += factor3; expression += "x";
                if(factor4 > 0) answer += " + " + factor4 + ")"; else if(factor4 < 0) answer += " - " + Math.abs(factor4) + ")"; else answer += " - 0)";
                if(I_AM_DEBUGGING) System.out.println(expression + "\nAnswer: " + answer);
                break;
            case EXPONENTIATION1:
                type = EXPONENTIATION1;
                if(I_AM_DEBUGGING) System.out.println("Type: Easy Exponentiation");
                while(cont) {
                    factor1 = (int) (Math.random() * 9) + 2;
                    factor2 = (int) (Math.random() * 4);
                    if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                    if(factor2 == 1) { if(I_AM_DEBUGGING) System.out.println("Power is 1"); continue; }
                    cont = false;
                }
                answer = String.valueOf((int)Math.pow(factor1, factor2));
                expression = "What is " + factor1 + " to the ";
                if(factor2 == 0) expression += "zeroth power? ";
                else if(factor2 == 2) expression += "second power? ";
                else if(factor2 == 3) expression += "third power? ";
                if(I_AM_DEBUGGING) { System.out.println(expression); System.out.println("Answer: " + answer);  }
                break;
            case EXPONENTIATION2:
                type = EXPONENTIATION2;
                if(I_AM_DEBUGGING) System.out.println("Type: HARD Exponentiation");
                while(cont) {
                    factor1 = (int) (Math.random() * 9) + 2;
                    factor2 = (int) (Math.random() * 6);
                    if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                    if(factor2 == 1) { if(I_AM_DEBUGGING) System.out.println("Power is 1"); continue; }
                    else if(Math.pow(factor1, factor2) > 1000) { if(I_AM_DEBUGGING) System.out.println("Greater than 1000"); continue; }
                    cont = false;
                }
                answer = String.valueOf((int)Math.pow(factor1, factor2));
                expression = "What is " + factor1 + " to the ";
                if(factor2 == 0) expression += "zeroth power? ";
                else if(factor2 == 2) expression += "second power? ";
                else if(factor2 == 3) expression += "third power? ";
                else if(factor2 == 4) expression += "fourth power? ";
                else if(factor2 == 5) expression += "fifth power? ";
                if(I_AM_DEBUGGING) System.out.println(expression + "\nAnswer: " + answer);
                break;
            case DERIVATIVE:
                type = DERIVATIVE;
                if(I_AM_DEBUGGING) System.out.println("Type: Simple Derivatives");
                factor1 = (int) (Math.random() * 20) + 1;
                factor2 = (int) (Math.random() * 5) + 1;
                answer = String.valueOf(factor1 * factor2);
                if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                if(factor2 > 2) answer += "x^" + (factor2 - 1);
                else if(factor2 == 2) answer += "x";
                expression = "What is the derivative with respect to x of ";
                if(factor1 > 1) expression += factor1; expression += "x";
                if(factor2 > 1) expression += "^" + factor2 + "? "; else expression += "? ";
                if(I_AM_DEBUGGING) { System.out.println(expression); System.out.println("Answer: " + answer);  }
                break;
            case INTEGRAL:
                type = INTEGRAL;
                if(I_AM_DEBUGGING) System.out.println("Type: Simple Integrals");
                while(cont) {
                    factor1 = (int) (Math.random() * 100) + 1;
                    factor2 = (int) (Math.random() * 5);
                    if(I_AM_DEBUGGING) System.out.println(factor1 + ", " + factor2);
                    if(factor1 % (factor2 + 1) != 0) { if(I_AM_DEBUGGING) System.out.println("Decimal coefficient"); continue; }
                    cont = false;
                }
                if(factor1 / (factor2 + 1) != 1) answer = String.valueOf(factor1 / (factor2 + 1)) + "x";
                else answer = "x";
                if(factor2 >= 1) answer += "^" + (factor2 + 1);
                expression = "(Do not include the constant of integration.)\nWhat is the integral with respect to x of " + factor1;
                if(factor2 > 1) expression += "x^" + factor2;
                else if(factor2 == 1) expression += "x";
                expression += "? ";
                if(I_AM_DEBUGGING) { System.out.println(expression); System.out.println("Answer: " + answer);  }
                break;
            default:
                type = ADDITION;
                factor1 = 2;
                factor2 = 2;
                answer = String.valueOf(4);
                expression = "What is 2 + 2? ";
                break;
        }
        if(searchForProblem(this) != null) expression = "Review:\n" + expression;
    }
    
    // Checks a guess against a problem
    public boolean guess(String guess) {
            if(guess == null) return false;
            String trimmedGuess = Helper.removeSpaces(guess);
            String trimmedAnswer = Helper.removeSpaces(answer);
            boolean isCorrect = trimmedGuess.equals(trimmedAnswer);
            if(isCorrect) {
                String victoryMsg = "";
                victoryMsg += "Correct!";
                Msg.msg(victoryMsg);
                if(I_AM_DEBUGGING) System.out.println("correct!");
                correctRegistry.add(this);
                return true;
            }
            else {
                String incorrectMsg = "";
                incorrectMsg += "Incorrect.\nThe answer was " + answer + ".";
                Msg.msg(incorrectMsg);
                if (I_AM_DEBUGGING) System.out.println("wrong!");
                return false;
            }
    }

    // Returns a problem as a string
    public String toString() {
        return expression + "Answer: " + answer;
    }

    // Checks what problems have not been written
    public static boolean hasNotBeenAnswered(Problem p1) {
        for(Problem p2 : correctRegistry) if(p1.equals(p2)) return false;
        return true;
    }

    // Searches for a certain problem in the registry
    public static Problem searchForProblem(Problem p) {
        for(Problem p2 : correctRegistry) if(p.equals(p2)) return p2;
        return null;
    }

    // Overrides the equals method of an object for problems
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Problem)) return false;
        Problem p = (Problem) o;
        if(factor3 == 0) {
            return this.getType() == p.getType() && this.getFactor1() == p.getFactor1() && this.getFactor2() == p.getFactor2();
        }
        else if (factor4 == 0){
            return this.getType() == p.getType() && this.getFactor1() == p.getFactor1() && this.getFactor2() == p.getFactor2() && this.getFactor3() == p.getFactor3();
        }
        else {
            return this.getType() == p.getType() && this.getFactor1() == p.getFactor1() && this.getFactor2() == p.getFactor2() && this.getFactor3() == p.getFactor3() && this.getFactor4() == p.getFactor4();
        }
    }


}
