package github.alessandrofazio.design.patter.factorymethod.playground;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class TableModelMess {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(TableModelMess::init);
    }

    private static void init() {
        JFrame frame = new JFrame("What a meSSS - 3x4 table");
        new MyCustomTable(3,4);
        MyCustomTable table = new MyCustomTable(3,4);
        frame.add(new JScrollPane(table));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(-900, 500);
    }

    private static class MyCustomTable extends JTable {
        private final int rows, cols;
        private static int[] rowcol;

        public MyCustomTable(int rows, int cols) {
            super(saveRowCol(rows, cols));
            this.rows = rows;
            this.cols = cols;
            rowcol = null;
        }

        private static TableModel saveRowCol(int rows, int cols) {
            rowcol = new int[] {rows, cols};
            return null;
        }

        protected TableModel createDefaultDataModel() {
            if(rowcol != null) {
                return new DefaultTableModel(rowcol[0], rowcol[1]);
            } else {
                return new DefaultTableModel(rows, cols);
            }
        }
    }
}