import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

public class Overseer {

    private final Lightboard board = new Lightboard();
    URL url = getClass().getClassLoader().getResource("stellarboardlogo.png");

    public Overseer() {
        boolean _cont;
        ImageIcon mainLogo = new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
        JOptionPane.showMessageDialog(null, null, "StellarBoard™ Boot Screen", JOptionPane.PLAIN_MESSAGE, mainLogo);
        while(true) {
            String s = JOptionPane.showInputDialog(null, "How many rows and columns do you want to have in your StellarBoard™?\n" +
                    "Enter text in the form \"numberOfRows,numberOfColumns\", not including the quotation marks.",
                    "StellarBoard™ Generator", JOptionPane.QUESTION_MESSAGE);
            String[] sArr = s.split(",");
            try {
                int numRows = Integer.parseInt(sArr[0]); int numCols = Integer.parseInt(sArr[1]);
                board.generate(numRows, numCols, 40); break;
            }
            catch(NumberFormatException | ArrayIndexOutOfBoundsException e) { JOptionPane.showMessageDialog(null,
                    "We didn't catch that. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);}
        }
        while(true) {
            _cont = true;
            String[] sArr;
            String[] options = new String[] { "Set", "Toggle", "Randomize", "Create", "Close" };
            int optionChosen = JOptionPane.showOptionDialog(null, drawMap(),
                    "StellarBoard™", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
            switch(optionChosen) {
                case 0:
                    // This is set
                    options = new String[] { "Set Individual Light", "Set Row", "Set Column", "Set Grid", "Set Whole Board", "Back" };
                    optionChosen = JOptionPane.showOptionDialog(null, "Choose what to set.", "StellarBoard™ Setting Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                    switch(optionChosen) {
                        case 0:
                            // This is set individual light
                            while (_cont) {
                                try {
                                    sArr = JOptionPane.showInputDialog("Please enter the coordinates of the light and the\nstate of the light in the following format:\n" +
                                            "row,column,onOrOff").split(",");
                                    if (sArr[2].equalsIgnoreCase("true") || sArr[2].equalsIgnoreCase("on")) {
                                        board.setLight(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), true);
                                        _cont = false;
                                    } else if (sArr[2].equalsIgnoreCase("false") || sArr[2].equalsIgnoreCase("off")) {
                                        board.setLight(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), false);
                                        _cont = false;
                                    } else
                                        JOptionPane.showMessageDialog(null, "The state of the light is invalid. Please reinput.");
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "We didn't catch that. Please try again.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Those coordinates are invalid for the current StellarBoard™.\n" +
                                            "Please input the coordinates of the light again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            _cont = true;
                            break;
                        case 1:
                            // This is set row
                            while (_cont) {
                                try {
                                    sArr = JOptionPane.showInputDialog("Please enter the row you want to change and the\ndesired state of the light in the following format:\n" +
                                            "row,onOrOff").split(",");
                                    if (sArr[1].equalsIgnoreCase("true") || sArr[1].equalsIgnoreCase("on")) {
                                        board.setRow(Integer.parseInt(sArr[0]), true);
                                        _cont = false;
                                    } else if (sArr[1].equalsIgnoreCase("false") || sArr[1].equalsIgnoreCase("off")) {
                                        board.setRow(Integer.parseInt(sArr[0]), false);
                                        _cont = false;
                                    } else
                                        JOptionPane.showMessageDialog(null, "The state of the light is invalid. Please reinput.");
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "We didn't catch that. Please try again.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "This row is invalid for the current StellarBoard™.\n" +
                                            "Please input the row again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            _cont = true;
                            break;
                        case 2:
                            // This is set column
                            while (_cont) {
                                try {
                                    sArr = JOptionPane.showInputDialog("Please enter the column you want to change and the\ndesired state of the light in the following format:\n" +
                                            "column,onOrOff").split(",");
                                    if (sArr[1].equalsIgnoreCase("true") || sArr[1].equalsIgnoreCase("on")) {
                                        board.setCol(Integer.parseInt(sArr[0]), true);
                                        _cont = false;
                                    } else if (sArr[1].equalsIgnoreCase("false") || sArr[1].equalsIgnoreCase("off")) {
                                        board.setCol(Integer.parseInt(sArr[0]), false);
                                        _cont = false;
                                    } else
                                        JOptionPane.showMessageDialog(null, "The state of the light is invalid. Please reinput.");
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "We didn't catch that. Please try again.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "This column is invalid for the current StellarBoard™.\n" +
                                            "Please input the column again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            _cont = true;
                            break;
                        case 3:
                            // This is set grid
                            while (_cont) {
                                try {
                                    sArr = JOptionPane.showInputDialog(null, "Please input the vertices of the grid and the desired state of the grid in the following format:\n" +
                                            "startingRow,startingColumn,endRow,endColumn,onOrOff", "Input StellarBoard™ Vertices", JOptionPane.QUESTION_MESSAGE).split(",");
                                    if (sArr[4].equalsIgnoreCase("true") || sArr[4].equalsIgnoreCase("on")) {
                                        board.setGrid(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]), Integer.parseInt(sArr[3]), true);
                                        _cont = false;
                                    } else if (sArr[4].equalsIgnoreCase("false") || sArr[4].equalsIgnoreCase("off")) {
                                        board.setGrid(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]), Integer.parseInt(sArr[3]), false);
                                        _cont = false;
                                    } else
                                        JOptionPane.showMessageDialog(null, "The state of the light is invalid. Please reinput.");
                                    _cont = false;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "We didn't catch that. Please try again.");
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Those dimensions are invalid for the current StellarBoard™.\n" +
                                            "Please input the dimensions of the grid again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            break;
                        case 4:
                            // This is set all
                            options = new String[]{"On", "Off"};
                            String s = (String) JOptionPane.showInputDialog(null, "Would you like the StellarBoard™ to be on or off?", null, JOptionPane.QUESTION_MESSAGE, null, options, null);
                            board.setAll(s.equals(options[0]));
                            break;
                        default:
                            break;
                    }
                case 1:
                    // This is the toggle
                    options = new String[] { "Toggle Individual Light", "Toggle Row", "Toggle Column", "Toggle Grid", "Toggle Whole Board", "Back" };
                    optionChosen = JOptionPane.showOptionDialog(null, "Choose what to set.", "StellarBoard™ Toggling Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                    switch(optionChosen) {
                        case 0:
                            // This is toggle individual light
                            while (_cont) {
                                try {
                                    sArr = JOptionPane.showInputDialog("Please enter the coordinates of the light you want to toggle in the following format:\n" +
                                            "row,column").split(",");
                                    board.toggleLight(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]));
                                    _cont = false;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "We didn't catch that. Please try again.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Those coordinates are invalid for the current StellarBoard™.\n" +
                                            "Please input the coordinates of the light again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            break;
                        case 1:
                            // This is toggle row
                            while (_cont) {
                                try {
                                    String s = JOptionPane.showInputDialog("Please enter the row you want to toggle.");
                                    if(s.isEmpty()) break;
                                    board.toggleRow(Integer.parseInt(s)); _cont = false;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "We didn't catch that. Please try again.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "This row is invalid for the current StellarBoard™.\n" +
                                            "Please input the row again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            break;
                        case 2:
                            // This is toggle column
                            while (_cont) {
                                try {
                                    String s = JOptionPane.showInputDialog("Please enter the column you want to toggle.");
                                    if(s.isEmpty()) break;
                                    board.toggleCol(Integer.parseInt(s)); _cont = false;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null,
                                            "We didn't catch that. Please try again.",
                                            "Error", JOptionPane.ERROR_MESSAGE);
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "This column is invalid for the current StellarBoard™.\n" +
                                            "Please input the column again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            break;
                        case 3:
                            // This is toggle grid
                            while (_cont) {
                                try {
                                    sArr = JOptionPane.showInputDialog(null, "Please input the vertices of the grid in the following format:\n" +
                                            "startingRow,startingColumn,endRow,endColumn", "Input StellarBoard™ Vertices", JOptionPane.QUESTION_MESSAGE).split(",");
                                        board.toggleGrid(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]), Integer.parseInt(sArr[3]));
                                        _cont = false;
                                } catch (NumberFormatException e) {
                                    JOptionPane.showMessageDialog(null, "We didn't catch that. Please try again.");
                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Those dimensions are invalid for the current StellarBoard™.\n" +
                                            "Please input the dimensions of the grid again.");
                                } catch(NullPointerException ignored) { break; }
                            }
                            break;
                        case 4:
                            // This is toggle all
                            board.toggleAll();
                            break;
                        default:
                            break;
                    }

                    break;
                case 2:
                    // This is randomize
                    options = new String[] {"Randomize Entire Board", "Randomize Section", "Back"};
                    optionChosen = JOptionPane.showOptionDialog(null, "Would you like to " +
                            "randomize a section of the board, or the entire board?", "StellarBoard™ Randomization Options",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                    switch(optionChosen) {
                        case 0:
                            // This is entire board
                            while(_cont) {
                                options = new String[] {"Random Chance", "Input Chance", "Cancel"};
                                optionChosen = JOptionPane.showOptionDialog(null, "Would you like to " +
                                                "have a random chance for each\nlight to be on, or determine " +
                                                "a certain percent to compare to?", "StellarBoard™ Randomization Options",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                                switch(optionChosen) {
                                    case 0:
                                        board.randomize(); _cont = false;
                                        break;
                                    case 1:
                                        while(true) {
                                            try {
                                                double percent = Double.parseDouble(JOptionPane.showInputDialog("What are the chances you want each light to be on?\n" +
                                                     "Please input the chances as a percent, but without the percent sign.\nExample: 54.72"));
                                                board.randomize(percent); _cont = false;
                                            break;
                                            } catch (NumberFormatException e) {
                                                JOptionPane.showMessageDialog(null,
                                                    "We didn't catch that. Please try again.",
                                                    "Error", JOptionPane.ERROR_MESSAGE);}
                                        }
                                        break;
                                    default:
                                        break;
                                }
                            }
                    case 1:
                            // This is section
                        while(_cont) {
                            options = new String[] {"Random Chance", "Input Chance", "Cancel"};
                            optionChosen = JOptionPane.showOptionDialog(null, "Would you like to " +
                                            "have a random chance for each\nlight to be on, or determine " +
                                            "a certain percent to compare to?", "StellarBoard™ Randomization Options",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
                            switch(optionChosen) {
                                case 0:
                                    while(_cont) {
                                        try {
                                            sArr = JOptionPane.showInputDialog(null, "Please input the vertices of your grid in the following format:\n" +
                                                    "startingRow,startingColumn,endRow,endColumn", "Input StellarBoard™ Vertices", JOptionPane.QUESTION_MESSAGE).split(",");
                                            board.randomizeGrid(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]), Integer.parseInt(sArr[3]));
                                            _cont = false;
                                        } catch(NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null, "We didn't catch that. Please try again.");
                                        } catch(IOException e) {
                                            JOptionPane.showMessageDialog(null, "Those dimensions are invalid for the current StellarBoard™.\n" +
                                                    "Please input the dimensions of the grid again.");
                                        }
                                    }
                                    break;
                                case 1:
                                    while(true) {
                                        try {
                                            double percent = Double.parseDouble(JOptionPane.showInputDialog("What are the chances you want each light to be on?\n" +
                                                    "Please input the chances as a percent, but without the percent sign.\nExample: 54.72"));
                                            sArr = JOptionPane.showInputDialog(null, "Please input the vertices of your grid in the following format:\n" +
                                                    "startingRow,startingColumn,endRow,endColumn", "Input StellarBoard™ Vertices", JOptionPane.QUESTION_MESSAGE).split(",");
                                            board.randomizeGrid(Integer.parseInt(sArr[0]), Integer.parseInt(sArr[1]), Integer.parseInt(sArr[2]), Integer.parseInt(sArr[3]), percent);
                                            _cont = false;
                                            break;
                                        } catch (NumberFormatException e) {
                                            JOptionPane.showMessageDialog(null,
                                                    "We didn't catch that. Please try again.",
                                                    "Error", JOptionPane.ERROR_MESSAGE);
                                        } catch(IOException e) {
                                            JOptionPane.showMessageDialog(null, "Those dimensions are invalid for the current StellarBoard™.\n" +
                                                    "Please input the dimensions of the grid again.");
                                        }
                                    }
                                    break;
                                default:
                                    break;
                            }
                        }
                        default:
                            // This is back/close
                            break;
                    }

                    break;
                case 3:
                    // This is create
                    while(true) {
                        try {
                            sArr = JOptionPane.showInputDialog(null, "How many rows and columns do you want to have in your StellarBoard™?\n" +
                                            "What are the chances you want each light to be on?\n" +
                                            "Enter text in the form \"numberOfRows,numberOfColumns,percent\", not including the quotation marks.",
                                    "StellarBoard™ Generator", JOptionPane.QUESTION_MESSAGE).split(",");
                            int numRows = Integer.parseInt(sArr[0]); int numCols = Integer.parseInt(sArr[1]);
                            double percent = Double.parseDouble(sArr[2]);
                            board.generate(numRows, numCols, percent); break;
                        }
                        catch(NumberFormatException | ArrayIndexOutOfBoundsException e) { JOptionPane.showMessageDialog(null,
                                "We didn't catch that. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);}
                        catch(NullPointerException ignored) { break; }
                    }
                    break;
                default: return;
            }
        }
    }

    public String drawMap() {
        StringBuilder retStr = new StringBuilder();
        String off = "\u2588";
        String on = "\u25A2";
        String space = "  ";
        boolean[][] map = board.getBoard();
        for (boolean[] booleans : map) {
            for (int c = 0; c < booleans.length; c++) {
                if (c < booleans.length - 1)
                    if (booleans[c]) retStr.append(on).append(space);
                    else retStr.append(off).append(space);
                else if (booleans[c]) retStr.append(on);
                else retStr.append(off);
            }
            retStr.append("\n");
        }
        return retStr.toString();
    }

}
