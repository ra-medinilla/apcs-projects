import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Generates problems for use in the program
public class Generator {

    public static final int ABADDITION = -50000;
    public static final int ADDITION = -4074;
    public static final int ADDITIONWP = ADDITION/2;
    public static final int ABSUBTRACTION = -45000;
    public static final int SUBTRACTION = -3974;
    public static final int SUBTRACTIONWP = SUBTRACTION/2;
    public static final int ABMULTIPLICATION = -40000;
    public static final int MULTIPLICATION1 = -3875;
    public static final int MULTIPLICATION2 = -3873;
    public static final int ABDIVISION = -35000;
    public static final int DIVISION1 = -3775;
    public static final int DIVISION2 = -3773;
    public static final int FOIL = -3725;
    public static final int ABFACTORING = -30000;
    public static final int FACTORING1 = -3701;
    public static final int FACTORING2 = -3700;
    public static final int ABEXPONENTIATION = -25000;
    public static final int EXPONENTIATION1 = -3675;
    public static final int EXPONENTIATION2 = -3673;
    public static final int DERIVATIVE = -3574;
    public static final int INTEGRAL = -3474;

    public static final int[] allProblems = new int[]{ADDITION, ADDITIONWP, SUBTRACTION, SUBTRACTIONWP, MULTIPLICATION1, MULTIPLICATION2,
            DIVISION1, DIVISION2, FOIL, FACTORING1, FACTORING2, EXPONENTIATION1, EXPONENTIATION2, DERIVATIVE, INTEGRAL};
    public static final int[] abProblems = new int[]{ABADDITION, ABSUBTRACTION, ABMULTIPLICATION, ABDIVISION, FOIL, ABFACTORING, ABEXPONENTIATION, DERIVATIVE, INTEGRAL};

    public static final int[] basicArithmetic = new int[]{ADDITION, SUBTRACTION, MULTIPLICATION1, DIVISION1};
    public static final int[] difficultArithmetic = new int[]{ADDITION, SUBTRACTION, MULTIPLICATION2, DIVISION2};
    public static final int[] abArithmetic = new int[]{ABADDITION, ABSUBTRACTION, ABMULTIPLICATION, ABDIVISION};
    public static final int[] allArithmetic = new int[]{ADDITION, SUBTRACTION, MULTIPLICATION1, MULTIPLICATION2, DIVISION1, DIVISION2};
    
    public static final int[] basicAlgebra = new int[]{FOIL, FACTORING1, EXPONENTIATION1};
    public static final int[] difficultAlgebra = new int[]{FOIL, FACTORING2, EXPONENTIATION2};
    public static int[] abAlgebra = new int[]{FOIL, ABFACTORING};
    public static final int[] allAlgebra = new int[]{FOIL, FACTORING1, FACTORING2, EXPONENTIATION1, EXPONENTIATION2};
    
    public static final int[] basicCalculus = new int[]{DERIVATIVE, INTEGRAL};
    
    public static final int[] basicWordProblems = new int[]{ADDITIONWP, SUBTRACTIONWP};

    private Problem problem;
    private JFrame frame;
    private JPanel panel;
    private int problems;
    private int wrongProblems;

    // Runs the program
    public Generator() {
        customizeScreen();
    }

    // Returns a random problem
    public Problem generate(ArrayList<Integer> list) {
        int i = (int)(Math.random()*list.size());
        Problem p = new Problem(list.get(i));
        if(Problem.hasNotBeenAnswered(p)) return p;
        else return generate(list);
    }

    // Sets up the basic screen
    private void customizeScreen() {

        panel = new JPanel(null);

        ArrayList<Integer> selectedList = new ArrayList<>();

        JLabel title = new JLabel("RXL"); title.setFont(title.getFont().deriveFont(30F));
        title.setBounds(95, 15, 100, 35);

        JLabel mathLabel = new JLabel("All Mathematics"); mathLabel.setFont(mathLabel.getFont().deriveFont(20F));
        mathLabel.setBounds(55, 50, 170, 30);
        JCheckBox mathCheckbox = new JCheckBox();
        mathCheckbox.setBounds(20, 55, 190, 20);
        JCheckBox[] mathArr = new JCheckBox[3];

            JLabel arithmeticLabel = new JLabel("Arithmetic"); arithmeticLabel.setFont(arithmeticLabel.getFont().deriveFont(16F));
            arithmeticLabel.setBounds(80, 80, 100, 20);
            JCheckBox arithmeticCheckbox = new JCheckBox();
            arithmeticCheckbox.setBounds(45, 80, 120, 20);
            JCheckBox[] arithmeticArr = new JCheckBox[4];

                JLabel additionLabel = new JLabel("Addition");
                additionLabel.setBounds(105, 100, 100, 20);
                JCheckBox additionCheckbox = new JCheckBox();
                additionCheckbox.setBounds(70, 100, 120, 20);
                Helper.addToListIfChecked(selectedList, ABADDITION, additionCheckbox, arithmeticCheckbox, mathCheckbox);
                arithmeticArr[0] = additionCheckbox;

                JLabel subtractionLabel = new JLabel("Subtraction");
                subtractionLabel.setBounds(105, 120, 100, 20);
                JCheckBox subtractionCheckbox = new JCheckBox();
                subtractionCheckbox.setBounds(70, 120, 120, 20);
                Helper.addToListIfChecked(selectedList, ABSUBTRACTION, subtractionCheckbox, arithmeticCheckbox, mathCheckbox);
                arithmeticArr[1] = subtractionCheckbox;

                JLabel multiplicationLabel = new JLabel("Multiplication");
                multiplicationLabel.setBounds(105, 140, 100, 20);
                JCheckBox multiplicationCheckbox = new JCheckBox();
                multiplicationCheckbox.setBounds(70, 140, 120, 20);
                Helper.addToListIfChecked(selectedList, ABMULTIPLICATION, multiplicationCheckbox, arithmeticCheckbox, mathCheckbox);
                arithmeticArr[2] = multiplicationCheckbox;

                JLabel divisionLabel = new JLabel("Division");
                divisionLabel.setBounds(105, 160, 100, 20);
                JCheckBox divisionCheckbox = new JCheckBox();
                divisionCheckbox.setBounds(70, 160, 120, 20);
                Helper.addToListIfChecked(selectedList, ABDIVISION, divisionCheckbox, arithmeticCheckbox, mathCheckbox);
                arithmeticArr[3] = divisionCheckbox;

            Helper.subsectionCheckbox(arithmeticArr, arithmeticCheckbox);
            Helper.addToListIfChecked(selectedList, abArithmetic, arithmeticCheckbox, mathCheckbox, arithmeticArr);

            JLabel algebraLabel = new JLabel("Algebra"); algebraLabel.setFont(algebraLabel.getFont().deriveFont(16F));
            algebraLabel.setBounds(80, 180, 100, 20);
            JCheckBox algebraCheckbox = new JCheckBox();
            algebraCheckbox.setBounds(45, 180, 120, 20);
            JCheckBox[] algebraArr = new JCheckBox[3];

                JLabel foilLabel = new JLabel("Expansion");
                foilLabel.setBounds(105, 200, 100, 20);
                JCheckBox foilCheckbox = new JCheckBox();
                foilCheckbox.setBounds(70, 200, 120, 20);
                Helper.addToListIfChecked(selectedList, FOIL, foilCheckbox, algebraCheckbox, mathCheckbox);
                algebraArr[0] = foilCheckbox;

                JLabel factoringLabel = new JLabel("Factoring");
                factoringLabel.setBounds(105, 220, 100, 20);
                JCheckBox factoringCheckbox = new JCheckBox();
                factoringCheckbox.setBounds(70, 220, 120, 20);
                Helper.addToListIfChecked(selectedList, ABFACTORING, factoringCheckbox, algebraCheckbox, mathCheckbox);
                algebraArr[1] = factoringCheckbox;

                JLabel exponentiationLabel = new JLabel("Exponentiation");
                exponentiationLabel.setBounds(105, 240, 120, 20);
                JCheckBox exponentiationCheckbox = new JCheckBox();
                exponentiationCheckbox.setBounds(70, 240, 140, 20);
                Helper.addToListIfChecked(selectedList, ABEXPONENTIATION, exponentiationCheckbox, algebraCheckbox, mathCheckbox);
                algebraArr[2] = exponentiationCheckbox;

            Helper.subsectionCheckbox(algebraArr, algebraCheckbox);
            Helper.addToListIfChecked(selectedList, abAlgebra, algebraCheckbox, mathCheckbox, algebraArr);

            JLabel calculusLabel = new JLabel("Calculus"); calculusLabel.setFont(calculusLabel.getFont().deriveFont(16F));
            calculusLabel.setBounds(80, 260, 100, 20);
            JCheckBox calculusCheckbox = new JCheckBox();
            calculusCheckbox.setBounds(45, 260, 120, 20);
            JCheckBox[] calculusArr = new JCheckBox[2];

                JLabel derivativeLabel = new JLabel("Derivation");
                derivativeLabel.setBounds(105, 280, 100, 20);
                JCheckBox derivativeCheckbox = new JCheckBox();
                derivativeCheckbox.setBounds(70, 280, 120, 20);
                Helper.addToListIfChecked(selectedList, DERIVATIVE, derivativeCheckbox, calculusCheckbox, mathCheckbox);
                calculusArr[0] = derivativeCheckbox;

                JLabel integralLabel = new JLabel("Integration");
                integralLabel.setBounds(105, 300, 100, 20);
                JCheckBox integralCheckbox = new JCheckBox();
                integralCheckbox.setBounds(70, 300, 120, 20);
                Helper.addToListIfChecked(selectedList, INTEGRAL, integralCheckbox, calculusCheckbox, mathCheckbox);
                calculusArr[1] = integralCheckbox;

            Helper.subsectionCheckbox(calculusArr, calculusCheckbox);
            Helper.addToListIfChecked(selectedList, basicCalculus, calculusCheckbox, mathCheckbox, calculusArr);

        arithmeticCheckbox.addActionListener(e -> {
            additionCheckbox.setSelected(arithmeticCheckbox.isSelected());
            subtractionCheckbox.setSelected(arithmeticCheckbox.isSelected());
            multiplicationCheckbox.setSelected(arithmeticCheckbox.isSelected());
            divisionCheckbox.setSelected(arithmeticCheckbox.isSelected());
            if(!arithmeticCheckbox.isSelected()) mathCheckbox.setSelected(false);
        });
        mathArr[0] = arithmeticCheckbox;

        algebraCheckbox.addActionListener(e -> {
            foilCheckbox.setSelected(algebraCheckbox.isSelected());
            factoringCheckbox.setSelected(algebraCheckbox.isSelected());
            exponentiationCheckbox.setSelected(algebraCheckbox.isSelected());
            if(!algebraCheckbox.isSelected()) mathCheckbox.setSelected(false);
        });
        mathArr[1] = algebraCheckbox;

        calculusCheckbox.addActionListener(e -> {
            derivativeCheckbox.setSelected(calculusCheckbox.isSelected());
            integralCheckbox.setSelected(calculusCheckbox.isSelected());
            if(!calculusCheckbox.isSelected()) mathCheckbox.setSelected(false);
        });
        mathArr[2] = calculusCheckbox;

        mathCheckbox.addActionListener(e -> {
            arithmeticCheckbox.setSelected(mathCheckbox.isSelected());
            algebraCheckbox.setSelected(mathCheckbox.isSelected());
            calculusCheckbox.setSelected(mathCheckbox.isSelected());
            additionCheckbox.setSelected(mathCheckbox.isSelected());
            subtractionCheckbox.setSelected(mathCheckbox.isSelected());
            multiplicationCheckbox.setSelected(mathCheckbox.isSelected());
            divisionCheckbox.setSelected(mathCheckbox.isSelected());
            foilCheckbox.setSelected(mathCheckbox.isSelected());
            factoringCheckbox.setSelected(mathCheckbox.isSelected());
            exponentiationCheckbox.setSelected(mathCheckbox.isSelected());
            derivativeCheckbox.setSelected(mathCheckbox.isSelected());
            integralCheckbox.setSelected(mathCheckbox.isSelected());

        });

        Helper.subsectionCheckbox(mathArr, mathCheckbox);
        Helper.addToListIfChecked(selectedList, abProblems, mathCheckbox, arithmeticArr, algebraArr, calculusArr);

        JComboBox difficultyCombobox = new JComboBox(new String[] {"Easy", "Hard"}); difficultyCombobox.setSelectedIndex(0);
        difficultyCombobox.setBounds(20, 330, 80, 25);

        JTextField amountField = new JTextField(); Helper.addPlaceholder(amountField, "5");
        Helper.addPlaceholder(amountField, "#");
        amountField.setBounds(95, 330, 40, 25);

        JButton submitButton = new JButton("Generate"); submitButton.setBounds(130, 330, 100, 25);
        JLabel errorLabel = new JLabel(); errorLabel.setForeground(Color.RED); errorLabel.setFont(errorLabel.getFont().deriveFont(10F));


        submitButton.addActionListener(e -> {
           try {
                boolean isHard = difficultyCombobox.getSelectedIndex() == 1;
                ArrayList<Integer> finalList = new ArrayList<>();

                if(selectedList.contains(ABADDITION)) {
                    if(isHard) finalList.add(ADDITIONWP);
                    else finalList.add(ADDITION);
                }
                if(selectedList.contains(ABSUBTRACTION)) {
                    if(isHard) finalList.add(SUBTRACTIONWP);
                    else finalList.add(SUBTRACTION);
                }
                if(selectedList.contains(ABMULTIPLICATION)) {
                    if(isHard) finalList.add(MULTIPLICATION2);
                    else finalList.add(MULTIPLICATION1);
                }
               if(selectedList.contains(ABDIVISION)) {
                   if(isHard) finalList.add(DIVISION2);
                   else finalList.add(DIVISION1);
               }

               if(selectedList.contains(FOIL)) finalList.add(FOIL);
               if(selectedList.contains(ABFACTORING)) {
                   if(isHard) finalList.add(FACTORING2);
                   else finalList.add(FACTORING1);
               }
               if(selectedList.contains(ABEXPONENTIATION)) {
                   if(isHard) finalList.add(EXPONENTIATION2);
                   else finalList.add(EXPONENTIATION1);
               }

               if(selectedList.contains(DERIVATIVE)) finalList.add(DERIVATIVE);
               if(selectedList.contains(INTEGRAL)) finalList.add(INTEGRAL);

               int numProblems = Integer.parseInt(amountField.getText());

               run(finalList, numProblems);
           }
           catch(Exception exception) {
               errorLabel.setText("Something went wrong.");
           }
        });

        panel.add(title);

        panel.add(mathLabel); panel.add(mathCheckbox);

        panel.add(arithmeticLabel); panel.add(arithmeticCheckbox);
        panel.add(additionLabel); panel.add(additionCheckbox);
        panel.add(subtractionLabel); panel.add(subtractionCheckbox);
        panel.add(multiplicationLabel); panel.add(multiplicationCheckbox);
        panel.add(divisionLabel); panel.add(divisionCheckbox);

        panel.add(algebraLabel); panel.add(algebraCheckbox);
        panel.add(foilLabel); panel.add(foilCheckbox);
        panel.add(factoringLabel); panel.add(factoringCheckbox);
        panel.add(exponentiationLabel); panel.add(exponentiationCheckbox);

        panel.add(calculusLabel); panel.add(calculusCheckbox);
        panel.add(derivativeLabel); panel.add(derivativeCheckbox);
        panel.add(integralLabel); panel.add(integralCheckbox);

        panel.add(difficultyCombobox); panel.add(amountField); panel.add(submitButton);

        frame = new JFrame(); frame.add(panel);
        frame.setSize(250, 400); frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    // Runs the program
    private void run(ArrayList<Integer> problemList, int numProblems) {
        problems = 0;
        wrongProblems = 0;
        for(int i = 0; i < numProblems; i++) {
            problem = generate(problemList);
            String guess = Msg.problemMsg(problem);
            if(guess == null) {
                String quit = "You quit the session early.\nWith ";
                if(problems != 0) {
                    quit += problems + " question"; if(problems != 1) quit += "s";
                    quit += " answered, of which " + (problems - wrongProblems) + " were correct and " +
                            wrongProblems + " were incorrect,\nyou earned a score of " + (((int) (((((double) problems - wrongProblems) / (problems)) * 1000.0) + 0.5)) / 10.0) + "%.";
                }
                else quit += "no questions answered, you did not earn a score.";
                Msg.msg(quit);
                return;
            }
            problems++;
            if(!problem.guess(guess)) wrongProblems++;
        }
        String finalAnswers = "With ";
        if(problems != 0) {
            finalAnswers += problems + " question"; if(problems != 1) finalAnswers += "s";
            finalAnswers += " answered, of which " + (problems - wrongProblems) + " were correct and " +
                    wrongProblems + " were incorrect,\nyou earned a score of " + (((int) (((((double) problems - wrongProblems) / (problems)) * 1000.0) + 0.5)) / 10.0) + "%.";
        }
        else finalAnswers += "no questions answered, you did not earn a score.";
        Msg.msg(finalAnswers);
    }

}
