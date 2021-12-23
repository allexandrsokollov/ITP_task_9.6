package cs.vsu.sokolov;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import cs.vsu.sokolov.Logic.ListHandler;
import cs.vsu.sokolov.Logic.StringHandler;
import cs.vsu.sokolov.argsHeandler.FileHandler.FileReader;
import cs.vsu.sokolov.argsHeandler.FileHandler.FileWriter;
import cs.vsu.sokolov.util.JTableUtils;
import cs.vsu.sokolov.util.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.io.File;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class MainForm extends JFrame {
    private JPanel panelMain;
    private JButton buttonLoadInputFile;
    private JButton buttonSaveOutputToFile;
    private JButton buttonExecuteTask;
    private JTextField textFieldResult;
    private JTable tableInput2;
    private JTable tableInput;
    private JScrollPane JTableInput;
    private JScrollPane JTableInput2;
    private JTable tableResult;

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

                    List<Integer> list1;
                    List<Integer> list2;

                    String[] strFromFile;

                    strFromFile = FileReader.getFileData(fileChooserOpen.getSelectedFile().getPath());

                    list1 = StringHandler.StringToIntsList(strFromFile[0]);
                    list2 = StringHandler.StringToIntsList(strFromFile[1]);

                    JTableUtils.writeArrayToJTable(tableInput, ListHandler.IntListToArr(list1));
                    JTableUtils.writeArrayToJTable(tableInput2, ListHandler.IntListToArr(list2));
                }
            } catch (Exception exception) {
                SwingUtils.showErrorMessageBox(exception);
            }
        });

        buttonSaveOutputToFile.addActionListener(e -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    FileWriter.writeStringToFile(fileChooserSave.getSelectedFile(),
                            StringHandler.IntListToString(
                                    Objects.requireNonNull(ListHandler.IntArrToList(
                                            Objects.requireNonNull(JTableUtils.readIntArrayFromJTable(tableResult))))));
                }
            } catch (Exception exception) {
                SwingUtils.showErrorMessageBox(exception);
            }
        });

        buttonExecuteTask.addActionListener(e -> {

            List<Integer> list1;
            List<Integer> list2;
            List<Integer> result;

            try {
                list1 = ListHandler.IntArrToList(Objects.requireNonNull(JTableUtils.readIntArrayFromJTable(tableInput)));
                list2 = ListHandler.IntArrToList(Objects.requireNonNull(JTableUtils.readIntArrayFromJTable(tableInput2)));

                result = ListHandler.inList1NotInList2(list1, list2);

                JTableUtils.writeArrayToJTable(tableResult, ListHandler.IntListToArr(result));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        });
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
        panelMain.setLayout(new GridLayoutManager(8, 3, new Insets(10, 10, 10, 10), -1, -1));
        Font panelMainFont = this.$$$getFont$$$(null, -1, 16, panelMain.getFont());
        if (panelMainFont != null) panelMain.setFont(panelMainFont);
        buttonSaveOutputToFile = new JButton();
        Font buttonSaveOutputToFileFont = this.$$$getFont$$$(null, -1, 16, buttonSaveOutputToFile.getFont());
        if (buttonSaveOutputToFileFont != null) buttonSaveOutputToFile.setFont(buttonSaveOutputToFileFont);
        buttonSaveOutputToFile.setText("Save output data to file");
        panelMain.add(buttonSaveOutputToFile, new GridConstraints(7, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, -1, 16, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("List 1:");
        panelMain.add(label1, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, -1, 16, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("List 2:");
        panelMain.add(label2, new GridConstraints(3, 0, 1, 3, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonLoadInputFile = new JButton();
        Font buttonLoadInputFileFont = this.$$$getFont$$$(null, -1, 16, buttonLoadInputFile.getFont());
        if (buttonLoadInputFileFont != null) buttonLoadInputFile.setFont(buttonLoadInputFileFont);
        buttonLoadInputFile.setText("Read file");
        panelMain.add(buttonLoadInputFile, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonExecuteTask = new JButton();
        Font buttonExecuteTaskFont = this.$$$getFont$$$(null, -1, 16, buttonExecuteTask.getFont());
        if (buttonExecuteTaskFont != null) buttonExecuteTask.setFont(buttonExecuteTaskFont);
        buttonExecuteTask.setText("Execute Task");
        panelMain.add(buttonExecuteTask, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        JTableInput = new JScrollPane();
        panelMain.add(JTableInput, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableInput = new JTable();
        JTableInput.setViewportView(tableInput);
        JTableInput2 = new JScrollPane();
        panelMain.add(JTableInput2, new GridConstraints(4, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableInput2 = new JTable();
        JTableInput2.setViewportView(tableInput2);
        final Spacer spacer1 = new Spacer();
        panelMain.add(spacer1, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        panelMain.add(scrollPane1, new GridConstraints(6, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableResult = new JTable();
        scrollPane1.setViewportView(tableResult);
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
