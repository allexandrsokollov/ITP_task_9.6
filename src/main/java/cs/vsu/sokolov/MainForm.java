package cs.vsu.sokolov;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import cs.vsu.sokolov.Logic.ListHandler;
import cs.vsu.sokolov.Logic.StringHandler;
import cs.vsu.sokolov.argsHeandler.FileHandler.FileReader;
import cs.vsu.sokolov.argsHeandler.FileHandler.FileWriter;
import cs.vsu.sokolov.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Locale;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JTextField textFieldInput;
    private JButton buttonLoadInputFile;
    private JButton buttonSaveOutputToFile;
    private JTextField textFieldInput2;
    private JButton buttonExecuteTask;
    private JTextField textFieldResult;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;

    public MainForm() {
        this.setContentPane(panelMain);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        buttonLoadInputFile.addActionListener(e -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    textFieldInput.setText("");
                    textFieldInput2.setText("");

                    List<Integer> list1;
                    List<Integer> list2;

                    String[] strFromFile;

                    strFromFile = FileReader.getFileData(fileChooserOpen.getSelectedFile().getPath());

                    list1 = StringHandler.StringToIntsList(strFromFile[0]);
                    list2 = StringHandler.StringToIntsList(strFromFile[1]);


                    textFieldInput.setText(IntListToString(list1));
                    textFieldInput2.setText(IntListToString(list2));

                }
            } catch (Exception exception) {
                SwingUtils.showErrorMessageBox(exception);
            }
        });

        buttonSaveOutputToFile.addActionListener(e -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    FileWriter.writeStringToFile(fileChooserSave.getSelectedFile(),
                             textFieldResult.getText());
                }
            } catch (Exception exception) {
                SwingUtils.showErrorMessageBox(exception);
            }
        });

        buttonExecuteTask.addActionListener(e -> {

            List<Integer> list1;
            List<Integer> list2;
            List<Integer> result;

            list1 = StringHandler.StringToIntsList(textFieldInput.getText());
            list2 = StringHandler.StringToIntsList(textFieldInput2.getText());

            result = ListHandler.inList1NotInList2(list1, list2);

            textFieldResult.setText(IntListToString(result));
        });
    }

    private static String IntListToString(List<Integer> list) {
        StringBuilder result = new StringBuilder();

        for (Integer i : list) {
            result.append(i);
            result.append(" ");
        }

        return result.toString();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayoutManager(7, 2, new Insets(10, 10, 10, 10), -1, -1));
        Font panelMainFont = this.$$$getFont$$$(null, -1, 16, panelMain.getFont());
        if (panelMainFont != null) panelMain.setFont(panelMainFont);
        textFieldInput = new JTextField();
        Font textFieldInputFont = this.$$$getFont$$$(null, -1, 16, textFieldInput.getFont());
        if (textFieldInputFont != null) textFieldInput.setFont(textFieldInputFont);
        panelMain.add(textFieldInput, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textFieldInput2 = new JTextField();
        Font textFieldInput2Font = this.$$$getFont$$$(null, -1, 16, textFieldInput2.getFont());
        if (textFieldInput2Font != null) textFieldInput2.setFont(textFieldInput2Font);
        panelMain.add(textFieldInput2, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        buttonSaveOutputToFile = new JButton();
        Font buttonSaveOutputToFileFont = this.$$$getFont$$$(null, -1, 16, buttonSaveOutputToFile.getFont());
        if (buttonSaveOutputToFileFont != null) buttonSaveOutputToFile.setFont(buttonSaveOutputToFileFont);
        buttonSaveOutputToFile.setText("Save output data to file");
        panelMain.add(buttonSaveOutputToFile, new GridConstraints(6, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldResult = new JTextField();
        Font textFieldResultFont = this.$$$getFont$$$(null, -1, 16, textFieldResult.getFont());
        if (textFieldResultFont != null) textFieldResult.setFont(textFieldResultFont);
        panelMain.add(textFieldResult, new GridConstraints(5, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("List 1:");
        panelMain.add(label1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("List 2:");
        panelMain.add(label2, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonLoadInputFile = new JButton();
        Font buttonLoadInputFileFont = this.$$$getFont$$$(null, -1, 16, buttonLoadInputFile.getFont());
        if (buttonLoadInputFileFont != null) buttonLoadInputFile.setFont(buttonLoadInputFileFont);
        buttonLoadInputFile.setText("Read file");
        panelMain.add(buttonLoadInputFile, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonExecuteTask = new JButton();
        Font buttonExecuteTaskFont = this.$$$getFont$$$(null, -1, 16, buttonExecuteTask.getFont());
        if (buttonExecuteTaskFont != null) buttonExecuteTask.setFont(buttonExecuteTaskFont);
        buttonExecuteTask.setText("Execute Task");
        panelMain.add(buttonExecuteTask, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
