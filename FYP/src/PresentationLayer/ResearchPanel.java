package PresentationLayer;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ResearchPanel extends javax.swing.JPanel {

    private ArrayList<String> filterExpressionArr;

    public ResearchPanel() {
        initComponents();
        filterExpressionArr = new ArrayList<>();
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
        ahadeesInResearchTablePanel = new javax.swing.JPanel();
        ahadeesInResearchTableScrollPane = new javax.swing.JScrollPane();
        ahadeesInResearchTable = new javax.swing.JTable();
        PanelRound allFiltersBackPanel;
        allFiltersBackPanel = new PanelRound();
        filterNumComboBox = new javax.swing.JComboBox<>();
        filterOutputTxtField = new javax.swing.JTextField();
        newFilterRadioBtn = new javax.swing.JRadioButton();
        existingFilterRadioBtn = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(182, 141, 64));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newFilterBackPanel.setBackground(new java.awt.Color(244, 235, 208));
        newFilterBackPanel.setAllCornersRound(25);

        filterTxtField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        filterTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filterTxtFieldKeyPressed(evt);
            }
        });

        filterLbl.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        filterLbl.setForeground(new java.awt.Color(46, 103, 90));
        filterLbl.setText("Filter:");

        finalFilterTxtField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        applyFilterBtn.setBackground(new java.awt.Color(244, 235, 208));
        applyFilterBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        applyFilterBtn.setForeground(new java.awt.Color(46, 103, 90));
        applyFilterBtn.setText("Apply");
        applyFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyFilterBtnActionPerformed(evt);
            }
        });

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

        ahadeesInResearchTablePanel.setBackground(new java.awt.Color(244, 235, 208));

        ahadeesInResearchTable.setBackground(new java.awt.Color(244, 235, 208));
        ahadeesInResearchTable.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ahadeesInResearchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book", "Hadith ID", "Hadith", "Sanad"
            }
        ));
        ahadeesInResearchTableScrollPane.setViewportView(ahadeesInResearchTable);

        javax.swing.GroupLayout ahadeesInResearchTablePanelLayout = new javax.swing.GroupLayout(ahadeesInResearchTablePanel);
        ahadeesInResearchTablePanel.setLayout(ahadeesInResearchTablePanelLayout);
        ahadeesInResearchTablePanelLayout.setHorizontalGroup(
            ahadeesInResearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ahadeesInResearchTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
        );
        ahadeesInResearchTablePanelLayout.setVerticalGroup(
            ahadeesInResearchTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ahadeesInResearchTablePanelLayout.createSequentialGroup()
                .addComponent(ahadeesInResearchTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(ahadeesInResearchTablePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 870, 330));

        allFiltersBackPanel.setBackground(new java.awt.Color(244, 235, 208));
        allFiltersBackPanel.setAllCornersRound(25);

        filterNumComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        filterNumComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));

        filterOutputTxtField.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        filterTypeBtnGroup.add(newFilterRadioBtn);
        newFilterRadioBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        newFilterRadioBtn.setForeground(new java.awt.Color(46, 103, 90));
        newFilterRadioBtn.setSelected(true);
        newFilterRadioBtn.setText("New");

        filterTypeBtnGroup.add(existingFilterRadioBtn);
        existingFilterRadioBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        existingFilterRadioBtn.setForeground(new java.awt.Color(46, 103, 90));
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
            String word = filterTxtField.getText();
            String[] arr = word.split(" ");
            word = arr[0];
            if (!word.equals("")) {
                if (filterOperatorsComboBox.getSelectedItem().equals(" ")) { // first or last word
                    if (filterExpressionArr.isEmpty()) { // when no expression
                        filterExpressionArr.add(word);
                        finalFilterTxtField.setText(word);
                    } else { //  when there is expression
                        filterExpressionArr.add(word);
                        String expression = "";
                        for (int i = 0; i < filterExpressionArr.size(); ++i) {
                            expression += filterExpressionArr.get(i) + " ";
                        }
                        finalFilterTxtField.setText(expression);
                    }
                    filterTxtField.setText("");
                    applyFilterBtn.doClick();
                }
            }
        }
    }//GEN-LAST:event_filterTxtFieldKeyPressed

    private void filterOperatorsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterOperatorsComboBoxActionPerformed
        String word = filterTxtField.getText();
        String[] arr = word.split(" ");
        word = arr[0];
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ahadeesInResearchTable;
    private javax.swing.JPanel ahadeesInResearchTablePanel;
    private javax.swing.JScrollPane ahadeesInResearchTableScrollPane;
    private javax.swing.JPanel allFiltersBackPanel;
    private javax.swing.JButton applyFilterBtn;
    private javax.swing.JRadioButton existingFilterRadioBtn;
    private javax.swing.JLabel filterLbl;
    private javax.swing.JComboBox<String> filterNumComboBox;
    private javax.swing.JComboBox<String> filterOperatorsComboBox;
    private javax.swing.JTextField filterOutputTxtField;
    private javax.swing.JTextField filterTxtField;
    private javax.swing.ButtonGroup filterTypeBtnGroup;
    private javax.swing.JTextField finalFilterTxtField;
    private javax.swing.JPanel newFilterBackPanel;
    private javax.swing.JRadioButton newFilterRadioBtn;
    private javax.swing.JCheckBox wordNegateChckBox;
    // End of variables declaration//GEN-END:variables
}
