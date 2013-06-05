package com.pcbje.maltegoimporter.app;

import static com.pcbje.maltegoimporter.app.GraphImporterDummyApp.logger;
import com.pcbje.maltegoimporter.model.impl.MaltegoEntity;
import com.pcbje.maltegoimporter.receiver.impl.CSVFileReceiver;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author pcbje
 */
public class GraphImporterComponentApp extends javax.swing.JFrame {

    private final static String PROP_FILE = "maltego-importer.properties";
    private static String DELIMETER = ";";
    private DefaultTableModel tmodel = new DefaultTableModel();
    private DefaultTableModel rmodel = new DefaultTableModel();
    private Map<Integer, MaltegoEntity> types;
    private Map<String, Integer> typesc;
    private Properties prop;
    private BufferedReader reader;
    private String[] header;
    private boolean initial;

    /**
     * Creates new form GraphImporterComponentApp
     */
    public GraphImporterComponentApp() {
        initComponents();

        initial = true;

        jTable1.setModel(tmodel);

        tmodel.addColumn("Column");
        tmodel.addColumn("Entity type");

        jTable2.setModel(rmodel);
        rmodel.addColumn("Source column");
        rmodel.addColumn("Target column");
        rmodel.addColumn("Label");

        prop = new Properties();

        if (new File(PROP_FILE).exists()) {
            try {
                prop.load(new FileInputStream(PROP_FILE));
            } catch (Exception ex) {
                Logger.getLogger(GraphImporterComponentApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        JComboBox entities = new JComboBox();

        entities.setRenderer(new ComboBoxRenderer());

        entities.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateEntityType(e);
            }
        });

        Map<String, MaltegoEntity> sorted = new TreeMap<String, MaltegoEntity>();

        for (MaltegoEntity me : MaltegoEntity.values()) {
            sorted.put(me.getName(), me);
        }

        for (MaltegoEntity me : sorted.values()) {
            entities.addItem(me);
        }

        DefaultCellEditor cellEditor = new DefaultCellEditor(entities);

        TableColumn typeCol = jTable1.getColumnModel().getColumn(1);

        typeCol.setCellEditor(cellEditor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Value based CSV");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Input format:");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Header based CSV");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Input file:");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Column", "Entity type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton4.setText("Convert to Maltego");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setText("Column mapping:");

        jButton2.setText("Clear stored mappings");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Relations");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Souorce column", "Target column", "Label"
            }
        ));
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable2);

        jButton3.setText("Add relation");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Remove relation");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Debug");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel1)
                                    .add(jLabel2))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jButton1)
                                        .add(0, 0, Short.MAX_VALUE))
                                    .add(layout.createSequentialGroup()
                                        .add(jRadioButton2)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jRadioButton1)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 245, Short.MAX_VALUE)
                                        .add(jCheckBox1))))))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jButton4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jButton2))
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jScrollPane1))
                    .add(layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane2)
                            .add(layout.createSequentialGroup()
                                .add(jLabel4)
                                .add(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jButton3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton5)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(10, 10, 10)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jRadioButton2)
                    .add(jRadioButton1)
                    .add(jCheckBox1))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 159, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton3)
                    .add(jButton5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton4)
                    .add(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            jTextField1.setText(fileChooser.getSelectedFile().getAbsolutePath());

            getMappings();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateEntityType(ActionEvent e) {
        if (types != null && jTable1.getSelectedRow() >= 0) {
            MaltegoEntity me = (MaltegoEntity) ((JComboBox) e.getSource()).getSelectedItem();

            types.put(((JComboBox) e.getSource()).getSelectedIndex(), me);

            prop.put(tmodel.getValueAt(jTable1.getSelectedRow(), 0), me.getName());

            try {
                prop.store(new FileOutputStream(PROP_FILE), null);
            } catch (IOException ex) {
                Logger.getLogger(GraphImporterComponentApp.class.getName()).log(Level.SEVERE, null, ex);
            }

            getMappings();
        }
    }

    private void getMappings() {
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);

        if (jRadioButton2.isSelected()) {
            while (tmodel.getRowCount() > 0) {
                tmodel.removeRow(0);
            }

            try {
                reader = new BufferedReader(new FileReader(jTextField1.getText()));
                String headerline = reader.readLine();

                if (headerline.contains(";")) {
                    DELIMETER = ";";
                } else if (headerline.contains(",")) {
                    DELIMETER = ",";
                }

                header = headerline.split(DELIMETER);

                for (int i = 0; i < header.length; i++) {
                    header[i] = header[i].trim();
                }

                Set<String> headerc = new HashSet<String>();

                headerc.addAll(Arrays.asList(header));

                String src;
                String[] rel;
                String[] label;

                if (initial) {
                    for (String key : prop.stringPropertyNames()) {
                        if (key.startsWith("relation.")) {
                            src = key.substring("relation.".length(), key.length());

                            if (headerc.contains(src)) {
                                rel = prop.getProperty(key).split(",");

                                for (String r : rel) {
                                    label = r.split(":");

                                    rmodel.addRow(new Object[]{src, label[0], label.length == 2 ? label[1] : ""});
                                }
                            }
                        }
                    }
                }

                types = new HashMap<Integer, MaltegoEntity>();
                typesc = new HashMap<String, Integer>();

                Map<String, MaltegoEntity> entities = new HashMap<String, MaltegoEntity>();

                for (MaltegoEntity me : MaltegoEntity.values()) {
                    entities.put(me.getName().toLowerCase().replaceAll("[^a-z]", ""), me);
                }

                String col;
                int ed;

                JComboBox columns = new JComboBox();

                for (int i = 0; i < header.length; i++) {
                    header[i] = header[i].trim();

                    typesc.put(header[i], i);

                    columns.addItem(header[i]);

                    col = header[i].toLowerCase().replaceAll("[^a-z]", "");

                    if (prop.containsKey(header[i])) {
                        types.put(i, entities.get(prop.getProperty(header[i]).toLowerCase().replaceAll("[^a-z]", "")));
                        tmodel.addRow(new Object[]{header[i], types.get(i)});
                        continue;
                    }

                    int min = Integer.MAX_VALUE;

                    for (String me : entities.keySet()) {
                        ed = editDistance(me, col);

                        if (ed < min) {
                            min = ed;
                            types.put(i, entities.get(me));

                            if (ed == 0) {
                                break;
                            }
                        }
                    }

                    if (min >= col.length() / 2) {
                        min = Integer.MAX_VALUE;

                        boolean found = false;

                        for (String me : entities.keySet()) {
                            if (me.contains(col) || col.contains(me)) {
                                ed = editDistance(me, col);

                                if (ed < min) {
                                    types.put(i, entities.get(me));
                                    found = true;
                                    min = ed;
                                }

                            }
                        }

                        if (!found) {
                            types.put(i, MaltegoEntity.UNKNOWN);
                        }
                    }

                    tmodel.addRow(new Object[]{header[i], types.get(i)});
                }

                DefaultCellEditor columnEditor = new DefaultCellEditor(columns);


                TableColumn typeSourceCol = jTable2.getColumnModel().getColumn(0);
                TableColumn typeTargetCol = jTable2.getColumnModel().getColumn(1);

                typeSourceCol.setCellEditor(columnEditor);
                typeTargetCol.setCellEditor(columnEditor);

                reader.close();
            } catch (Exception ex) {
                Logger.getLogger(GraphImporterComponentApp.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

        initial = false;
    }

    private class ComboBoxRenderer extends JLabel
            implements ListCellRenderer {

        public ComboBoxRenderer() {
        }

        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            this.setText(((MaltegoEntity) value).getName());

            return this;
        }
    }

    /**
     * Source: http://professorjava.weebly.com/edit-distance.html
     */
    private static int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] d = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            d[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            d[0][j] = j;
        }
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = min((d[i - 1][j] + 1), (d[i][j - 1] + 1), (d[i - 1][j - 1] + 1));
                }
            }
        }
        return (d[m][n]);
    }

    public static int min(int a, int b, int c) {
        return (Math.min(Math.min(a, b), c));
    }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jTable1.setEnabled(true);
        jButton3.setEnabled(true);
        jButton5.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jTable1.setEnabled(false);
        jButton3.setEnabled(false);
        jButton5.setEnabled(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        File input = null;

        if (jRadioButton2.isSelected()) {
            try {
                reader = new BufferedReader(new FileReader(jTextField1.getText()));

                reader.readLine();

                Map<String, Set<String>> relations = new HashMap<String, Set<String>>();

                String source;
                String rel;

                for (int i = 0; i < rmodel.getRowCount(); i++) {
                    source = (String) rmodel.getValueAt(i, 0);
                    if (!relations.containsKey(source)) {
                        relations.put(source, new HashSet<String>());
                    }

                    rel = (String) rmodel.getValueAt(i, 1);

                    if ((String) rmodel.getValueAt(i, 2) != null) {
                        rel += ":" + (String) rmodel.getValueAt(i, 2);
                    }

                    relations.get(source).add(rel);
                }

                StringBuilder targets;

                for (String col : relations.keySet()) {
                    targets = new StringBuilder();
                    boolean first = true;
                    for (String target : relations.get(col)) {
                        if (!first) {
                            targets.append(",");
                        }

                        targets.append(target);

                        first = false;
                    }
                    prop.put("relation." + col, targets.toString());
                }

                prop.store(new FileOutputStream(PROP_FILE), null);

                input = File.createTempFile("maltego-importer", null);

                BufferedWriter writer = new BufferedWriter(new FileWriter(input));

                String line;
                String[] parts;

                while ((line = reader.readLine()) != null) {
                    if (DELIMETER.equals(";")) {
                        line = line.replaceAll(",", "");
                    } else if (DELIMETER.equals(",")) {
                        String copy = "";
                        boolean inQuotes = false;

                        for (int i = 0; i < line.length(); ++i) {
                            if (line.charAt(i) == '"') {
                                inQuotes = !inQuotes;
                            }
                            if (line.charAt(i) == ',' && inQuotes) {
                                copy += "-";
                            } else {
                                copy += line.charAt(i);
                            }
                        }

                        line = copy;
                    }

                    line = line.replaceAll(DELIMETER, " " + DELIMETER);
                    line = line.replaceAll("\"", "");

                    parts = line.split(DELIMETER);

                    String src, dst, label;
                    MaltegoEntity srcType, dstType;

                    for (int i = 0; i < rmodel.getRowCount(); i++) {
                        src = ((String) rmodel.getValueAt(i, 0)).trim();
                        dst = ((String) rmodel.getValueAt(i, 1)).trim();
                        label = (String) rmodel.getValueAt(i, 2);

                        if (parts[typesc.get(src)].trim().length() > 0 && parts[typesc.get(dst)].trim().length() > 0) {
                            srcType = types.get(typesc.get(src));
                            dstType = types.get(typesc.get(dst));

                            writer.write(String.format("%s,%s,%s,%s,%s\n", srcType.getName(), parts[typesc.get(src)], dstType.getName(), parts[typesc.get(dst)], label));
                        }
                    }
                }

                writer.close();

            } catch (IOException ex) {
                Logger.getLogger(GraphImporterComponentApp.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else {
            input = new File(jTextField1.getText());
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element element = new CSVFileReceiver().receive(document, input);
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();
            Source src = new DOMSource(element);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            Result dest = new StreamResult(baos);
            aTransformer.transform(src, dest);

            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(new StringSelection(new String(baos.toByteArray())), null);

            if (jCheckBox1.isSelected()) {
                JFrame dbg = new JFrame();
                dbg.setTitle("Debug");
                dbg.setSize(new Dimension(400, 300));
                dbg.setLocationRelativeTo(null);

                JScrollPane sp = new JScrollPane();

                JTextArea ta = new JTextArea();

                ta.setText(new String(baos.toByteArray()));

                sp.getViewport().add(ta);

                dbg.getContentPane().add(sp);

                dbg.setVisible(true);
            }

            JOptionPane.showMessageDialog(null, "Transformed! Now click \"Paste\" under the tab \"Investigate\" in Maltego.");
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage(), e);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new File(PROP_FILE).delete();

        while (rmodel.getRowCount() > 0) {
            rmodel.removeRow(0);
        }

        prop = new Properties();

        getMappings();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        rmodel.addRow(new Object[]{header[0], header[0]});
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (jTable2.getSelectedRow() >= 0) {
            rmodel.removeRow(jTable2.getSelectedRow());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GraphImporterComponentApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphImporterComponentApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphImporterComponentApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphImporterComponentApp.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphImporterComponentApp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
}
