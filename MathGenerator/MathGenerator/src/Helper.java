import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

// Helper methods for use with JFrames
public class Helper {

    public static void addPlaceholder(JTextField field, String text) {
        if(isEmptyWithPlaceholder(field)) field.setText(text);
        field.setForeground(Color.gray);
        if(field.getFocusListeners() != null) field.removeFocusListener(field.getFocusListeners()[0]);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(field.getText().equals(text) && field.getForeground() == Color.gray) {
                    field.setText(""); field.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(field.getText().isEmpty()) {
                    field.setText(text);
                    field.setForeground(Color.gray);
                }
            }
        });
    }

    public static void addPlaceholder(JTextField field, String text, Color phBg, Color phBorder, Color phColor, Color ogColor) {
        if(isEmptyWithPlaceholder(field)) field.setText(text);
        field.setBackground(phBg);
        field.setBorder(new LineBorder(phBorder, 1));
        field.setText(text);
        field.setForeground(phColor);
        if(field.getFocusListeners() != null) field.removeFocusListener(field.getFocusListeners()[0]);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(field.getText().equals(text) && field.getForeground() == phColor) {
                    field.setText(""); field.setForeground(ogColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(field.getText().isEmpty()) {
                    field.setText(text);
                    field.setForeground(phColor);
                }
            }
        });
    }

    public static boolean isEmptyWithPlaceholder(JTextField field) {
        return field.getText().isEmpty() || field.getForeground() == Color.gray;
    }

    public static void copy2DIntArray(int[][] original, int[][] other) {
        other = new int[original.length][original[0].length];
        for(int r = 0; r < original.length; r++) System.arraycopy(original[r], 0, other[r], 0, original[0].length);
    }

    public static void safeRemoveFromList(ArrayList<Integer> list, Integer o) {
        boolean found = false;
        for(Integer o1 : list) if(o1.equals(o)) found = true;
        if(found) list.remove(o);
    }

    public static void addToListIfChecked(ArrayList<Integer> list, Integer o, JCheckBox checkBox, JCheckBox checkBox2, JCheckBox checkBox3) {
        checkBox.addActionListener(e -> {
            if(checkBox.isSelected()) {
                list.add(o);
            }
            else {
                safeRemoveFromList(list, o);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
            }
        });
    }

    public static void addToListIfChecked(ArrayList<Integer> list, int[] arr, JCheckBox checkBox, JCheckBox checkBox2, JCheckBox[] subSection) {
        checkBox.addActionListener(e -> {
            if(checkBox.isSelected()) {
                for(int i : arr)
                    if(!list.contains(i)) list.add(i);
            }
            else {
                for(int i : arr)
                    safeRemoveFromList(list, i);
                checkBox2.setSelected(false);
                for(JCheckBox box : subSection)
                    box.setSelected(false);
            }
        });
    }

    public static void addToListIfChecked(ArrayList<Integer> list, int[] arr, JCheckBox checkBox, JCheckBox[] subSection, JCheckBox[] subSection2, JCheckBox[] subSection3) {
        checkBox.addActionListener(e -> {
            if(checkBox.isSelected()) {
                for(int i : arr)
                    if(!list.contains(i)) list.add(i);
            }
            else {
                for(int i : arr)
                    safeRemoveFromList(list, i);
                for(JCheckBox box : subSection)
                    box.setSelected(false);
                for(JCheckBox box : subSection2)
                    box.setSelected(false);
                for(JCheckBox box : subSection3)
                    box.setSelected(false);
            }
        });
    }

    public static void subsectionCheckbox(JCheckBox[] arrBoxes, JCheckBox sectionHeader) {
        for(int i = 0; i < arrBoxes.length; i++) {
            arrBoxes[i].addChangeListener(e -> {
                boolean allSelected = true;
                for (JCheckBox jCheckBox : arrBoxes) if (!jCheckBox.isSelected()) allSelected = false;
                if (allSelected) sectionHeader.setSelected(true);
            });
        }
    }

    public static String removeSpaces(String s) {
        String retVal = "";
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) != ' ') retVal += s.charAt(i);
        return retVal;
    }

}
