package PresentationLayer;

import BusinessLogicLayer.ArrayConverterBO;
import BusinessLogicLayer.FascadeBLL;
import BusinessLogicLayer.IConverterBO;
import BusinessLogicLayer.IFascadeBLL;
import TransferObject.Hadith;
import TransferObject.Research;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResearchPanel extends javax.swing.JPanel {

    private Research research;
    private IFascadeBLL fascadeBLL;
    private ArrayList<String> filterExpressionArr;

    public ResearchPanel() {
        initComponents();
        filterExpressionArr = new ArrayList<>();
        fascadeBLL = new FascadeBLL();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterTypeBtnGroup = new javax.swing.ButtonGroup();
        PanelRound newFilterBackPanel;
        newFilterBackPanel = new PanelRound();
        filterTxtField = new javax.swing.JTextField();
        filterLbl = new javax.swing.JLabel();
        finalFilterTxtField = new javax.swing.JTextField();
        wordNegateChckBox = new javax.swing.JCheckBox();
        applyFilterBtn = new javax.swing.JButton();
        filterOperatorsComboBox = new javax.swing.JComboBox<>();
        ahadeesInResearchTableScrollPane = new javax.swing.JScrollPane();
        hadithTable = new javax.swing.JTable();
        PanelRound allFiltersBackPanel;
        allFiltersBackPanel = new PanelRound();
        filterNumComboBox = new javax.swing.JComboBox<>();
        filterOutputTxtField = new javax.swing.JTextField();
        newFilterRadioBtn = new javax.swing.JRadioButton();
        existingFilterRadioBtn = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        applyFilterBtn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(7, 7, 57));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newFilterBackPanel.setBackground(new java.awt.Color(47, 18, 76));
        newFilterBackPanel.setAllCornersRound(25);

        filterTxtField.setBackground(new java.awt.Color(196, 182, 182));
        filterTxtField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        filterTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTxtFieldKeyPressed(evt);
            }
        });

        filterLbl.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        filterLbl.setForeground(new java.awt.Color(254, 194, 96));
        filterLbl.setText("Filter:");

        finalFilterTxtField.setBackground(new java.awt.Color(196, 182, 182));
        finalFilterTxtField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        wordNegateChckBox.setBackground(new java.awt.Color(47, 18, 76));

        applyFilterBtn.setBackground(new java.awt.Color(254, 194, 96));
        applyFilterBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        applyFilterBtn.setForeground(new java.awt.Color(59, 24, 95));
        applyFilterBtn.setText("Apply");
        applyFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyFilterBtnActionPerformed(evt);
            }
        });

        filterOperatorsComboBox.setBackground(new java.awt.Color(196, 182, 182));
        filterOperatorsComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        filterOperatorsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AND", "OR" }));
        filterOperatorsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterOperatorsComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newFilterBackPanelLayout = new javax.swing.GroupLayout(newFilterBackPanel);
        newFilterBackPanel.setLayout(newFilterBackPanelLayout);
        newFilterBackPanelLayout.setHorizontalGroup(
            newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newFilterBackPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addComponent(finalFilterTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(applyFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addComponent(filterLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(wordNegateChckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filterTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filterOperatorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        newFilterBackPanelLayout.setVerticalGroup(
            newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(wordNegateChckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filterLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterOperatorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(finalFilterTxtField)
                    .addComponent(applyFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        add(newFilterBackPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 440, 120));

        hadithTable.setAutoCreateRowSorter(true);
        hadithTable.setBackground(new java.awt.Color(196, 182, 182));
        hadithTable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        hadithTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sr.", "Hadith ID", "Book", "Hadith", "Sanad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        hadithTable.getTableHeader().setReorderingAllowed(false);
        hadithTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hadithTableMouseClicked(evt);
            }
        });
        ahadeesInResearchTableScrollPane.setViewportView(hadithTable);
        if (hadithTable.getColumnModel().getColumnCount() > 0) {
            hadithTable.getColumnModel().getColumn(0).setMinWidth(50);
            hadithTable.getColumnModel().getColumn(0).setMaxWidth(50);
            hadithTable.getColumnModel().getColumn(1).setMinWidth(80);
            hadithTable.getColumnModel().getColumn(1).setMaxWidth(100);
            hadithTable.getColumnModel().getColumn(2).setMinWidth(100);
            hadithTable.getColumnModel().getColumn(2).setMaxWidth(120);
            hadithTable.getColumnModel().getColumn(4).setMinWidth(300);
            hadithTable.getColumnModel().getColumn(4).setMaxWidth(400);
        }
        hadithTable.getColumnModel().getColumn(3).setCellRenderer(new TableAlignment());
        hadithTable.getColumnModel().getColumn(4).setCellRenderer(new TableAlignment());

        add(ahadeesInResearchTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 220, 1170, 340));

        allFiltersBackPanel.setBackground(new java.awt.Color(47, 18, 76));
        allFiltersBackPanel.setAllCornersRound(25);

        filterNumComboBox.setBackground(new java.awt.Color(196, 182, 182));
        filterNumComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        filterNumComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));

        filterOutputTxtField.setBackground(new java.awt.Color(196, 182, 182));
        filterOutputTxtField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        filterTypeBtnGroup.add(newFilterRadioBtn);
        newFilterRadioBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        newFilterRadioBtn.setForeground(new java.awt.Color(254, 194, 96));
        newFilterRadioBtn.setSelected(true);
        newFilterRadioBtn.setText("New");

        filterTypeBtnGroup.add(existingFilterRadioBtn);
        existingFilterRadioBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        existingFilterRadioBtn.setForeground(new java.awt.Color(254, 194, 96));
        existingFilterRadioBtn.setText("Existing");

        javax.swing.GroupLayout allFiltersBackPanelLayout = new javax.swing.GroupLayout(allFiltersBackPanel);
        allFiltersBackPanel.setLayout(allFiltersBackPanelLayout);
        allFiltersBackPanelLayout.setHorizontalGroup(
            allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(filterOutputTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(newFilterRadioBtn)
                        .addGap(85, 85, 85)
                        .addComponent(existingFilterRadioBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filterNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        allFiltersBackPanelLayout.setVerticalGroup(
            allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterOutputTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFilterRadioBtn)
                    .addComponent(existingFilterRadioBtn))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(allFiltersBackPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 400, 120));

        jTextArea2.setBackground(new java.awt.Color(196, 182, 182));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(47, 18, 76))); // NOI18N
        jScrollPane2.setViewportView(jTextArea2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 270, 120));

        applyFilterBtn1.setBackground(new java.awt.Color(254, 194, 96));
        applyFilterBtn1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        applyFilterBtn1.setForeground(new java.awt.Color(59, 24, 95));
        applyFilterBtn1.setText("Translate");
        applyFilterBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyFilterBtn1ActionPerformed(evt);
            }
        });
        add(applyFilterBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 160, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void applyFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyFilterBtnActionPerformed

        if (filterExpressionArr.size() % 2 != 0) { // when last index value is word
            if (newFilterRadioBtn.isSelected()) {
                int numOfFilters = filterNumComboBox.getItemCount();
                String lastFilterNum = filterNumComboBox.getItemAt((numOfFilters - 1));
                int num = Integer.parseInt(lastFilterNum);
                num++;
                filterNumComboBox.addItem((num + ""));
                filterNumComboBox.setSelectedIndex(filterNumComboBox.getItemCount() - 1);
                newFilterRadioBtn.setSelected(false);
                existingFilterRadioBtn.setSelected(true);
            } else if (existingFilterRadioBtn.isSelected()) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Last value of filter must be a word.");
        }


    }//GEN-LAST:event_applyFilterBtnActionPerformed

    private void filterTxtFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterTxtFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String word = getCleanWord();
            if (!word.equals("")) {
                if (isOperandAllowed() ) {
                   
                    if (filterOperatorsComboBox.getSelectedItem().equals(" ")) { // first or last word
                        filterExpressionArr.add(word);
                        filterTxtField.setText("");
//                  
                    } else if (filterOperatorsComboBox.getSelectedItem().equals("AND")) {
                        filterExpressionArr.add(word);
                        filterExpressionArr.add(filterOperatorsComboBox.getSelectedItem().toString());
                       
                    }
                    ArrayConverterBO converter = new ArrayConverterBO();
                    finalFilterTxtField.setText(converter.convert(filterExpressionArr));
                }
            }
        }
    }//GEN-LAST:event_filterTxtFieldKeyPressed

    private String getCleanWord() {
        String word = filterTxtField.getText();
        String[] arr = word.split(" ");
        word = arr[0];
        return word;
    }

    private void filterOperatorsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterOperatorsComboBoxActionPerformed
        String word = getCleanWord();
        if (filterExpressionArr.size() % 2 != 0) { // when last index value is word
            if (!filterExpressionArr.get(filterExpressionArr.size() - 1).contains(word)) { // when last index value is same as curr word

            } else {
                filterExpressionArr.add(filterOperatorsComboBox.getSelectedItem().toString());
            }
        } else { // when last index value is operator
            filterExpressionArr.add(word);
            filterExpressionArr.add(filterOperatorsComboBox.getSelectedItem().toString());
        }
        String expression = "";
        for (int i = 0; i < filterExpressionArr.size(); ++i) {
            expression += filterExpressionArr.get(i) + " ";
        }
        finalFilterTxtField.setText(expression);
        filterTxtField.setText("");
        filterOperatorsComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_filterOperatorsComboBoxActionPerformed

    private void applyFilterBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyFilterBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applyFilterBtn1ActionPerformed

    private void hadithTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hadithTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        if (hadithTable.getValueAt(row, 3) != null) {
            String matn = hadithTable.getValueAt(row, 3).toString();
            jTextArea2.setText(matn);
        }
    }//GEN-LAST:event_hadithTableMouseClicked

    public void setReseach(Research research) {
        this.research = research;
        initAsync(research);
    }

    public void initAsync(Research research) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            init(research);

            // Optionally, you can perform additional tasks after init() completes
            // For example, update UI components, notify other parts of your application, etc.
            executorService.shutdown(); // Shutdown the executor when done
        });
    }

    public void init(Research research) {

        ArrayList<Hadith> hadiths = fascadeBLL.getAllHadiths(research.getSearchBaseLine());
        System.out.println(hadiths.get(3107).getNarrators().size());
        populateHadithTable(hadiths);

    }

    private boolean isOperandAllowed() {
        return isOperatorEntered() || filterExpressionArr.isEmpty();
    }

    private boolean isOperatorEntered() {
        if(filterExpressionArr.isEmpty())
            return true;
        return filterExpressionArr.getLast().equals("AND") || filterExpressionArr.getLast().equals("OR");
    }

    private void populateHadithTable(ArrayList<Hadith> hadiths) {
        if (!hadiths.isEmpty()) {
            ArrayConverterBO converter = new ArrayConverterBO();
            DefaultTableModel model = (DefaultTableModel) hadithTable.getModel();
            model.setRowCount(0);

            int count = 1;
            for (Hadith hadith : hadiths) {
                Object[] row = {hadith.getIndex(), hadith.getId(), hadith.getBookName(), hadith.getMatn(), converter.convertNarratorsListToString(hadith.getNarrators())};
                count++;
                model.addRow(row);
            }
            hadithTable.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No Hadith Found.", "Warning", JOptionPane.WARNING_MESSAGE);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ahadeesInResearchTableScrollPane;
    private javax.swing.JPanel allFiltersBackPanel;
    private javax.swing.JButton applyFilterBtn;
    private javax.swing.JButton applyFilterBtn1;
    private javax.swing.JRadioButton existingFilterRadioBtn;
    private javax.swing.JLabel filterLbl;
    private javax.swing.JComboBox<String> filterNumComboBox;
    private javax.swing.JComboBox<String> filterOperatorsComboBox;
    private javax.swing.JTextField filterOutputTxtField;
    private javax.swing.JTextField filterTxtField;
    private javax.swing.ButtonGroup filterTypeBtnGroup;
    private javax.swing.JTextField finalFilterTxtField;
    public javax.swing.JTable hadithTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel newFilterBackPanel;
    private javax.swing.JRadioButton newFilterRadioBtn;
    private javax.swing.JCheckBox wordNegateChckBox;
    // End of variables declaration//GEN-END:variables
}
