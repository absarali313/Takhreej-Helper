package PresentationLayer;

import BusinessLogicLayer.ArrayConverterBO;
import BusinessLogicLayer.FascadeBLL;
import BusinessLogicLayer.IConverterBO;
import BusinessLogicLayer.IFascadeBLL;
import BusinessLogicLayer.StringConverter;
import TransferObject.Filter;
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
        jTextArea2.setAlignmentX(50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterTypeBtnGroup = new javax.swing.ButtonGroup();
        PanelRound newFilterBackPanel;
        newFilterBackPanel = new PanelRound();
        keywordTextField = new javax.swing.JTextField();
        filterLbl = new javax.swing.JLabel();
        filterExpressionTextField = new javax.swing.JTextField();
        notCheckSelected = new javax.swing.JCheckBox();
        applyFilterBtn = new javax.swing.JButton();
        filterOperatorsComboBox = new javax.swing.JComboBox<>();
        ahadeesInResearchTableScrollPane = new javax.swing.JScrollPane();
        hadithTable = new javax.swing.JTable();
        PanelRound allFiltersBackPanel;
        allFiltersBackPanel = new PanelRound();
        filterNumComboBox = new javax.swing.JComboBox<>();
        newFilterRadioBtn = new javax.swing.JRadioButton();
        existingFilterRadioBtn = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        applyFilterBtn1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(7, 7, 57));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newFilterBackPanel.setBackground(new java.awt.Color(47, 18, 76));
        newFilterBackPanel.setAllCornersRound(25);

        keywordTextField.setBackground(new java.awt.Color(196, 182, 182));
        keywordTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        keywordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keywordTextFieldKeyPressed(evt);
            }
        });

        filterLbl.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        filterLbl.setForeground(new java.awt.Color(254, 194, 96));
        filterLbl.setText("Filter:");

        filterExpressionTextField.setBackground(new java.awt.Color(196, 182, 182));
        filterExpressionTextField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        notCheckSelected.setBackground(new java.awt.Color(47, 18, 76));

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
                        .addComponent(filterExpressionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(applyFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addComponent(filterLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notCheckSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(notCheckSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filterLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(19, 19, 19))
                    .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterOperatorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filterExpressionTextField)
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
        filterNumComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterNumComboBoxActionPerformed(evt);
            }
        });

        filterTypeBtnGroup.add(newFilterRadioBtn);
        newFilterRadioBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        newFilterRadioBtn.setForeground(new java.awt.Color(254, 194, 96));
        newFilterRadioBtn.setText("New");
        newFilterRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFilterRadioBtnActionPerformed(evt);
            }
        });

        filterTypeBtnGroup.add(existingFilterRadioBtn);
        existingFilterRadioBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        existingFilterRadioBtn.setForeground(new java.awt.Color(254, 194, 96));
        existingFilterRadioBtn.setSelected(true);
        existingFilterRadioBtn.setText("Existing");
        existingFilterRadioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existingFilterRadioBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout allFiltersBackPanelLayout = new javax.swing.GroupLayout(allFiltersBackPanel);
        allFiltersBackPanel.setLayout(allFiltersBackPanelLayout);
        allFiltersBackPanelLayout.setHorizontalGroup(
            allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                        .addComponent(newFilterRadioBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(existingFilterRadioBtn))
                    .addComponent(filterNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        allFiltersBackPanelLayout.setVerticalGroup(
            allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(filterNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFilterRadioBtn)
                    .addComponent(existingFilterRadioBtn))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        add(allFiltersBackPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 210, 120));

        jScrollPane2.setBackground(new java.awt.Color(47, 18, 76));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(47, 18, 76), 5, true));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea2.setBackground(new java.awt.Color(196, 182, 182));
        jTextArea2.setColumns(15);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(null);
        jScrollPane2.setViewportView(jTextArea2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 380, 120));

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
        System.out.println("Start");
        if (isFilterValid() && filterExpressionArr.size() >= 1) {
            System.out.println("valid filter");
            if (newFilterRadioBtn.isSelected()) {
                if (createFilter()) {
                    System.out.println(research.getFilters().size());
                    applyFilter();
                    existingFilterRadioBtn.setSelected(true);
                    JOptionPane.showMessageDialog(null, "New Filter Applied! ");

                } else {
                    JOptionPane.showMessageDialog(null, "Error while making new filter");
                }
            } else if (existingFilterRadioBtn.isSelected()) {
                System.out.println("Existing Filter");
                if (updateFilter()) {
                    System.out.println("Upadting");
                    applyFilter();
                    JOptionPane.showMessageDialog(null, " Filter Updated! ");

                } else {
                    JOptionPane.showMessageDialog(null, "Error while updating the filter at index " + filterNumComboBox.getSelectedIndex());
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Last value of filter must be a word.");
        }


    }//GEN-LAST:event_applyFilterBtnActionPerformed

    private void addFilterToResearch() {

        research.getFilters().add(new Filter(this.research.getResearchId(), filterNumComboBox.getSelectedIndex(), filterExpressionTextField.getText()));
    }

    private boolean insertFilter() {
        return fascadeBLL.createFilter(research.getResearchId(), filterNumComboBox.getSelectedIndex(), filterExpressionTextField.getText().toString());
    }

    private boolean deleteFilter() {
        return fascadeBLL.deleteFilter(research.getResearchId());
    }

    private boolean createFilter() {
        // deleteFilter();
        addFilterToResearch();
        int filterIndex = 1 + filterNumComboBox.getSelectedIndex();
        filterNumComboBox.addItem(Integer.toString(filterIndex));
        filterNumComboBox.setSelectedIndex(filterIndex);
        return insertFilter();
    }

    private boolean updateFilter() {
        research.getFilters().get(filterNumComboBox.getSelectedIndex()).setExpression(filterExpressionTextField.getText());
        return fascadeBLL.updateFilterExpression(research.getResearchId(), filterNumComboBox.getSelectedIndex(), filterExpressionTextField.getText());
    }

    private void keywordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordTextFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String word = getCleanWord();
            if (!word.equals("")) {
                if (isOperandAllowed()) {
                    if (notCheckSelected.isSelected()) {
                        word = "!".concat(word);
                    }
                    if (filterOperatorsComboBox.getSelectedItem().equals(" ")) { // first or last word

                        filterExpressionArr.add(word);
                        keywordTextField.setText("");
//                  
                    } else if (filterOperatorsComboBox.getSelectedItem().equals("AND") || filterOperatorsComboBox.getSelectedItem().equals("OR")) {
                        filterExpressionArr.add(word);
                        filterExpressionArr.add(filterOperatorsComboBox.getSelectedItem().toString());

                    }
                    fillFilterTextField();
                    keywordTextField.setText("");
                    filterOperatorsComboBox.setSelectedIndex(0);
                    notCheckSelected.setSelected(false);
                }
            }
        }
    }//GEN-LAST:event_keywordTextFieldKeyPressed

    private void fillFilterTextField() {
        ArrayConverterBO converter = new ArrayConverterBO();
        filterExpressionTextField.setText(converter.convert(filterExpressionArr));
    }

    private String getCleanWord() {
        String word = keywordTextField.getText();
        String[] arr = word.split(" ");
        word = arr[0];
        return word;
    }

    private void filterOperatorsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterOperatorsComboBoxActionPerformed
        String word = getCleanWord();
        if (notCheckSelected.isSelected()) {
            word = "!".concat(word);
        }
        switch (filterOperatorsComboBox.getSelectedIndex()) {

            case 0:
                if (!word.equals("")) {
                    filterExpressionArr.add(word);
                }
                break;
            default:
                if (!word.equals("") && isOperandAllowed()) {
                    filterExpressionArr.add(word);
                    filterExpressionArr.add(filterOperatorsComboBox.getSelectedItem().toString());
                } else if (isOperatorAllowed() && !word.equals("")) {
                    filterExpressionArr.add(filterOperatorsComboBox.getSelectedItem().toString());
                    filterExpressionArr.add(word);

                } else if (isOperatorAllowed()) {
                    filterExpressionArr.add(filterOperatorsComboBox.getSelectedItem().toString());
                }

                break;
        }
        fillFilterTextField();
        keywordTextField.setText("");
        filterOperatorsComboBox.setSelectedIndex(0);
        notCheckSelected.setSelected(false);
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

    private void filterNumComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterNumComboBoxActionPerformed
        loadFilterExpression();
        applyFilter();
//        
    }//GEN-LAST:event_filterNumComboBoxActionPerformed

    private void newFilterRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFilterRadioBtnActionPerformed
        filterExpressionArr.removeAll(filterExpressionArr);
        fillFilterTextField();
    }//GEN-LAST:event_newFilterRadioBtnActionPerformed

    private void existingFilterRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existingFilterRadioBtnActionPerformed
        loadFilterExpression();
    }//GEN-LAST:event_existingFilterRadioBtnActionPerformed

    public void setReseach(Research research) {
        this.research = research;
        loadFilters(research);
        initAsync(research);
    }

    private void loadFilters(Research research) {
        int filterIndex = 0;
        if (!research.getFilters().isEmpty()) {
            for (Filter filter : research.getFilters()) {
                filterNumComboBox.addItem(Integer.toString(filterIndex));
                filterIndex++;
            }
        }
        loadFilterExpression();
    }

    private void loadFilterExpression() {
        if (!research.getFilters().isEmpty() && filterNumComboBox.getSelectedIndex() != -1) {
            StringConverter converter = new StringConverter();
            filterExpressionArr = converter.convert(research.getFilters().get(filterNumComboBox.getSelectedIndex()).getExpression());
            fillFilterTextField();
        }
    }

    public void initAsync(Research research) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {
            setActive(false);
            init(research);

            // Optionally, you can perform additional tasks after init() completes
            // For example, update UI components, notify other parts of your application, etc.
            executorService.shutdown(); // Shutdown the executor when done
        });

    }

    public void init(Research research) {
        if (!research.getFilters().isEmpty()) {
            existingFilterRadioBtn.setSelected(true);
        } else {
            newFilterRadioBtn.setSelected(true);
        }

        ArrayList<Hadith> hadiths = fascadeBLL.getAllHadiths(research.getSearchBaseLine());
        System.out.println(hadiths.get(3107).getNarrators().size());
        populateHadithTable(hadiths);
        filterNumComboBox.setSelectedIndex(research.getFilters().size()-1);
        setActive(true);

    }

    private boolean isOperandAllowed() {
        return isOperatorEntered() || filterExpressionArr.isEmpty();
    }

    private boolean isOperatorEntered() {
        if (filterExpressionArr.isEmpty()) {
            return true;
        }
        return filterExpressionArr.getLast().equals("AND") || filterExpressionArr.getLast().equals("OR");
    }

    private boolean isOperatorAllowed() {
        if (!filterExpressionArr.isEmpty()) {
            return !filterExpressionArr.getLast().equals("AND") || !filterExpressionArr.getLast().equals("OR");
        }
        return false;
    }

    private boolean isFilterValid() {
        return filterExpressionArr.size() % 2 != 0 && !filterExpressionArr.isEmpty();
    }

    private void applyFilter() {
        ArrayList<Hadith> hadiths = fascadeBLL.searchHadiths(research, filterNumComboBox.getSelectedIndex());
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> {

            populateHadithTable(hadiths); // Optionally, you can perform additional tasks after init() completes
            // For example, update UI components, notify other parts of your application, etc.
            executorService.shutdown(); // Shutdown the executor when done
        });
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
            ArrayConverterBO converter = new ArrayConverterBO();
            DefaultTableModel model = (DefaultTableModel) hadithTable.getModel();
            model.setRowCount(0);
            hadithTable.setModel(model);
        }

    }
    private void setActive(boolean value){
        applyFilterBtn.setEnabled(value);
        filterNumComboBox.setEnabled(value);
        newFilterRadioBtn.setEnabled(value);
        existingFilterRadioBtn.setEnabled(value);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ahadeesInResearchTableScrollPane;
    private javax.swing.JPanel allFiltersBackPanel;
    private javax.swing.JButton applyFilterBtn;
    private javax.swing.JButton applyFilterBtn1;
    private javax.swing.JRadioButton existingFilterRadioBtn;
    private javax.swing.JTextField filterExpressionTextField;
    private javax.swing.JLabel filterLbl;
    private javax.swing.JComboBox<String> filterNumComboBox;
    private javax.swing.JComboBox<String> filterOperatorsComboBox;
    private javax.swing.ButtonGroup filterTypeBtnGroup;
    public javax.swing.JTable hadithTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField keywordTextField;
    private javax.swing.JPanel newFilterBackPanel;
    private javax.swing.JRadioButton newFilterRadioBtn;
    private javax.swing.JCheckBox notCheckSelected;
    // End of variables declaration//GEN-END:variables
}
