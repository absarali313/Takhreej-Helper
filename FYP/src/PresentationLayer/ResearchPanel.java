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
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
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
        selectedHadithTextArea.setAlignmentX(50);
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
        searchTypeComboBox = new javax.swing.JComboBox<>();
        filterLbl2 = new javax.swing.JLabel();
        undoBtn = new javax.swing.JLabel();
        ahadeesInResearchTableScrollPane = new javax.swing.JScrollPane();
        hadithTable = new javax.swing.JTable();
        PanelRound allFiltersBackPanel;
        allFiltersBackPanel = new PanelRound();
        filterNumComboBox = new javax.swing.JComboBox<>();
        newFilterRadioBtn = new javax.swing.JRadioButton();
        existingFilterRadioBtn = new javax.swing.JRadioButton();
        resetIcon = new javax.swing.JLabel();
        filterLbl1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedHadithTextArea = new javax.swing.JTextArea();
        translateBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(7, 7, 57));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newFilterBackPanel.setBackground(new java.awt.Color(47, 18, 76));
        newFilterBackPanel.setAllCornersRound(25);

        keywordTextField.setBackground(new java.awt.Color(196, 182, 182));
        keywordTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        keywordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                keywordTextFieldKeyPressed(evt);
            }
        });

        filterLbl.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        filterLbl.setForeground(new java.awt.Color(254, 194, 96));
        filterLbl.setText("Filter:");

        filterExpressionTextField.setBackground(new java.awt.Color(196, 182, 182));
        filterExpressionTextField.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

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
        filterOperatorsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AND", "OR", "NOT", "OPTIONAL", "WILDCARD", "REPITITION", " " }));
        filterOperatorsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterOperatorsComboBoxActionPerformed(evt);
            }
        });

        searchTypeComboBox.setBackground(new java.awt.Color(196, 182, 182));
        searchTypeComboBox.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        searchTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pattern", "Lemma", "Root" }));
        searchTypeComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                searchTypeComboBoxItemStateChanged(evt);
            }
        });
        searchTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTypeComboBoxActionPerformed(evt);
            }
        });

        filterLbl2.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        filterLbl2.setForeground(new java.awt.Color(254, 194, 96));
        filterLbl2.setText("Search Type:");

        undoBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/undo (1).png"))); // NOI18N
        undoBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                undoBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout newFilterBackPanelLayout = new javax.swing.GroupLayout(newFilterBackPanel);
        newFilterBackPanel.setLayout(newFilterBackPanelLayout);
        newFilterBackPanelLayout.setHorizontalGroup(
            newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(undoBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterExpressionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterLbl2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newFilterBackPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(filterLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notCheckSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(filterOperatorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(applyFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(149, 149, 149))
        );
        newFilterBackPanelLayout.setVerticalGroup(
            newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newFilterBackPanelLayout.createSequentialGroup()
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notCheckSelected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filterLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addComponent(undoBtn))
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keywordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterOperatorsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applyFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterExpressionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterLbl2))))
                .addGap(25, 25, 25))
        );

        add(newFilterBackPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 540, 120));

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

        resetIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trash (1).png"))); // NOI18N
        resetIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetIconMouseClicked(evt);
            }
        });

        filterLbl1.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        filterLbl1.setForeground(new java.awt.Color(254, 194, 96));
        filterLbl1.setText("Delete Filter");

        javax.swing.GroupLayout allFiltersBackPanelLayout = new javax.swing.GroupLayout(allFiltersBackPanel);
        allFiltersBackPanel.setLayout(allFiltersBackPanelLayout);
        allFiltersBackPanelLayout.setHorizontalGroup(
            allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, allFiltersBackPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                        .addComponent(newFilterRadioBtn)
                        .addGap(24, 24, 24)
                        .addComponent(existingFilterRadioBtn))
                    .addComponent(filterNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                        .addComponent(filterLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resetIcon)))
                .addGap(32, 32, 32))
        );
        allFiltersBackPanelLayout.setVerticalGroup(
            allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(allFiltersBackPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resetIcon)
                    .addComponent(filterLbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterNumComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(allFiltersBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFilterRadioBtn)
                    .addComponent(existingFilterRadioBtn))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        add(allFiltersBackPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 210, 120));

        jScrollPane2.setBackground(new java.awt.Color(47, 18, 76));
        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(47, 18, 76), 5, true));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        selectedHadithTextArea.setBackground(new java.awt.Color(196, 182, 182));
        selectedHadithTextArea.setColumns(15);
        selectedHadithTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectedHadithTextArea.setLineWrap(true);
        selectedHadithTextArea.setRows(5);
        selectedHadithTextArea.setBorder(null);
        jScrollPane2.setViewportView(selectedHadithTextArea);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 380, 120));

        translateBtn.setBackground(new java.awt.Color(254, 194, 96));
        translateBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        translateBtn.setForeground(new java.awt.Color(59, 24, 95));
        translateBtn.setText("Translate");
        translateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateBtnActionPerformed(evt);
            }
        });
        add(translateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 160, 110, -1));
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

        research.getFilters().add(new Filter(this.research.getResearchId(), filterNumComboBox.getItemCount(), filterExpressionTextField.getText(), searchTypeComboBox.getSelectedItem().toString()));
    }

    private boolean insertFilter() {
        return fascadeBLL.createFilter(research.getResearchId(), findHighestValueFromComboBox(filterNumComboBox), filterExpressionTextField.getText().toString(), searchTypeComboBox.getSelectedItem().toString());
    }

    private int findHighestValueFromComboBox(JComboBox<String> comboBox) {
        int highestValue = -1; // Initialize with the smallest possible integer value

        ComboBoxModel<String> model = comboBox.getModel();
        int itemCount = model.getSize();
        for (int i = 0; i < itemCount; i++) {
            String item = model.getElementAt(i);
            try {
                int value = Integer.parseInt(item);
                if (value > highestValue) {
                    highestValue = value;
                }
            } catch (NumberFormatException e) {
                // Handle parsing error if necessary
                e.printStackTrace();
            }
        }

        System.out.println(highestValue);
        return highestValue;
    }

    private boolean deleteFilter() {
        return fascadeBLL.deleteFilter(research.getResearchId(), filterNumComboBox.getSelectedIndex());
    }

    private boolean createFilter() {
        // deleteFilter();
        addFilterToResearch();
        int filterIndex = 1 + findHighestValueFromComboBox(filterNumComboBox);
        filterNumComboBox.addItem(Integer.toString(filterIndex));

        filterNumComboBox.setSelectedIndex(filterNumComboBox.getItemCount() - 1);
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

                    } else {
                        filterExpressionArr.add(word);
                    }
                    fillFilterTextField();
                    setSearchType();
                    keywordTextField.setText("");
                    filterOperatorsComboBox.setSelectedIndex(0);
                    notCheckSelected.setSelected(false);
                }
            }
        }
    }//GEN-LAST:event_keywordTextFieldKeyPressed

    private void fillFilterTextField() {
        ArrayConverterBO converter = new ArrayConverterBO();
        filterExpressionTextField.setText(converter.convertToFilter(filterExpressionArr));
    }

    private void setSearchType() {
        if (filterNumComboBox.getItemCount() > 0) {
            switch (this.research.getFilters().get(filterNumComboBox.getSelectedIndex()).getType()) {
                case "Pattern":
                    searchTypeComboBox.setSelectedItem("Pattern");
                    break;
                case "Lemma":
                    searchTypeComboBox.setSelectedItem("Lemma");
                    break;
                case "Root":
                    searchTypeComboBox.setSelectedItem("Root");
                    break;

                default:
                    searchTypeComboBox.setSelectedItem("Pattern");
                    break;

            }
        }
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
        switch (filterOperatorsComboBox.getSelectedItem().toString()) {

            case " ":
                if (!word.equals("")) {
                    filterExpressionArr.add(word);
                }
                fillFilterTextField();
                keywordTextField.setText("");
                filterOperatorsComboBox.setSelectedIndex(0);
                notCheckSelected.setSelected(false);
                break;
            case "NOT":
                if (!word.equals("") && isOperandAllowed() && (filterExpressionArr.getLast().equals("AND") || filterExpressionArr.getLast().equals("OR"))) {
                    filterExpressionArr.add("!" + word);

                } else if (isOperatorAllowed() && !word.equals("")) {
                    filterExpressionArr.add("AND");
                    filterExpressionArr.add("!" + word);

                }
                fillFilterTextField();
                keywordTextField.setText("");
                filterOperatorsComboBox.setSelectedIndex(0);
                notCheckSelected.setSelected(false);
                break;
            case "WILDCARD":
                if (searchTypeComboBox.getSelectedItem().toString().equals("Pattern")) {
                    keywordTextField.setText(keywordTextField.getText() + ".");
                } else {
                    JOptionPane.showMessageDialog(null, "This operator is only valid for Pattern search", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "REPITITION":
                if (searchTypeComboBox.getSelectedItem().toString().equals("Pattern")) {
                    keywordTextField.setText(keywordTextField.getText() + "*");
                } else {
                    JOptionPane.showMessageDialog(null, "This operator is only valid for Pattern search", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case "OPTIONAL":
                System.out.println("Adding optinal");
                if (searchTypeComboBox.getSelectedItem().toString().equals("Pattern")) {
                    System.out.println("Added optinal");
                    keywordTextField.setText(keywordTextField.getText() + "?");
                } else {
                    JOptionPane.showMessageDialog(null, "This operator is only valid for Pattern search", "Warning", JOptionPane.WARNING_MESSAGE);
                }

                break;

            case "MATCH END":
                if (searchTypeComboBox.getSelectedItem().toString().equals("Pattern")) {
                    keywordTextField.setText(keywordTextField.getText() + "$");
                } else {
                    JOptionPane.showMessageDialog(null, "This operator is only valid for Pattern search", "Warning", JOptionPane.WARNING_MESSAGE);
                }
                break;
            case "MATCH START":
                if (searchTypeComboBox.getSelectedItem().toString().equals("Pattern")) {
                    keywordTextField.setText(keywordTextField.getText() + "^");
                } else {
                    JOptionPane.showMessageDialog(null, "This operator is only valid for Pattern search", "Warning", JOptionPane.WARNING_MESSAGE);
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

                fillFilterTextField();
                keywordTextField.setText("");
                filterOperatorsComboBox.setSelectedIndex(0);
                notCheckSelected.setSelected(false);
                break;
        }

    }//GEN-LAST:event_filterOperatorsComboBoxActionPerformed

    private void translateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateBtnActionPerformed
        if (!selectedHadithTextArea.getText().equals("")) {
            String englishHadith = fascadeBLL.getTranslationToEnglish(selectedHadithTextArea.getText());
            selectedHadithTextArea.setText(englishHadith);
        } else
            JOptionPane.showMessageDialog(null, "Please select a hadith from below table.", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_translateBtnActionPerformed

    private void hadithTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hadithTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        if (hadithTable.getValueAt(row, 3) != null) {
            String matn = hadithTable.getValueAt(row, 3).toString();
            selectedHadithTextArea.setText(matn);
        }
    }//GEN-LAST:event_hadithTableMouseClicked

    private void filterNumComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterNumComboBoxActionPerformed
        loadFilterExpression();
        if (filterNumComboBox.getItemCount() != 0) {
            applyFilter();
        }
//        
    }//GEN-LAST:event_filterNumComboBoxActionPerformed

    private void newFilterRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFilterRadioBtnActionPerformed
        filterExpressionArr.removeAll(filterExpressionArr);
        fillFilterTextField();
    }//GEN-LAST:event_newFilterRadioBtnActionPerformed

    private void existingFilterRadioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existingFilterRadioBtnActionPerformed
        loadFilterExpression();
    }//GEN-LAST:event_existingFilterRadioBtnActionPerformed

    private void searchTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTypeComboBoxActionPerformed
        if (existingFilterRadioBtn.isSelected())
            fascadeBLL.updateFilterType(this.research.getResearchId(), filterNumComboBox.getSelectedIndex(), searchTypeComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_searchTypeComboBoxActionPerformed

    private void searchTypeComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_searchTypeComboBoxItemStateChanged

        //       fascadeBLL.updateFilterType(this.research.getResearchId(),filterNumComboBox.getSelectedIndex(), searchTypeComboBox.getSelectedItem().toString());
    }//GEN-LAST:event_searchTypeComboBoxItemStateChanged

    private void resetIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetIconMouseClicked
        if (existingFilterRadioBtn.isSelected()) {
            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the selected filter?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                fascadeBLL.deleteFilter(this.research.getResearchId(), this.research.getFilters().get(filterNumComboBox.getSelectedIndex()).getOrderNo());
                filterExpressionArr.removeAll(filterExpressionArr);
                fillFilterTextField();
                loadFilterExpression();

                int currentIndex = filterNumComboBox.getSelectedIndex();
                if (currentIndex > 0) {
                    filterNumComboBox.removeItem(currentIndex);
                    filterNumComboBox.setSelectedIndex(currentIndex - 1);
                } else {
                    newFilterRadioBtn.setSelected(true);
                    filterExpressionArr.removeAll(filterExpressionArr);
                    fillFilterTextField();
                }
                Research newResearch = fascadeBLL.getResearch(this.research.getName());
                setReseach(newResearch);
            }
        } else {
            filterExpressionArr.removeAll(filterExpressionArr);
            fillFilterTextField();
            // loadFilterExpression();
        }
    }//GEN-LAST:event_resetIconMouseClicked

    private void undoBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoBtnMouseClicked

        if (!filterExpressionArr.isEmpty()) {
            filterExpressionArr.remove(filterExpressionArr.size() - 1);

            if (!filterExpressionArr.isEmpty() && (filterExpressionArr.getLast().equals("AND") || filterExpressionArr.getLast().equals("OR"))) {
                filterExpressionArr.remove(filterExpressionArr.size() - 1);
            }

            fillFilterTextField();
            updateFilter();
            loadFilterExpression();
        }

    }//GEN-LAST:event_undoBtnMouseClicked

    public void setReseach(Research research) {
        this.research = research;
        filterNumComboBox.removeAllItems();
        loadFilters(research);
        initAsync(research);
    }

    private void loadFilters(Research research) {
        int filterIndex = 0;
        if (!research.getFilters().isEmpty()) {
            for (Filter filter : research.getFilters()) {
                filterNumComboBox.addItem(Integer.toString(filter.getOrderNo()));
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
            setSearchType();
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
        filterNumComboBox.setSelectedIndex(research.getFilters().size() - 1);
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
        if (!fascadeBLL.getResearch(this.research.getName()).getFilters().isEmpty()) {
            ArrayList<Hadith> hadiths = fascadeBLL.searchHadiths(fascadeBLL.getResearch(this.research.getName()), filterNumComboBox.getSelectedIndex());
            ExecutorService executorService = Executors.newSingleThreadExecutor();

            executorService.execute(() -> {

                populateHadithTable(hadiths); // Optionally, you can perform additional tasks after init() completes
                // For example, update UI components, notify other parts of your application, etc.
                executorService.shutdown(); // Shutdown the executor when done
            });
        }
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

    private void setActive(boolean value) {
        applyFilterBtn.setEnabled(value);
        filterNumComboBox.setEnabled(value);
        newFilterRadioBtn.setEnabled(value);
        existingFilterRadioBtn.setEnabled(value);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ahadeesInResearchTableScrollPane;
    private javax.swing.JPanel allFiltersBackPanel;
    private javax.swing.JButton applyFilterBtn;
    private javax.swing.JRadioButton existingFilterRadioBtn;
    private javax.swing.JTextField filterExpressionTextField;
    private javax.swing.JLabel filterLbl;
    private javax.swing.JLabel filterLbl1;
    private javax.swing.JLabel filterLbl2;
    private javax.swing.JComboBox<String> filterNumComboBox;
    private javax.swing.JComboBox<String> filterOperatorsComboBox;
    private javax.swing.ButtonGroup filterTypeBtnGroup;
    public javax.swing.JTable hadithTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField keywordTextField;
    private javax.swing.JPanel newFilterBackPanel;
    private javax.swing.JRadioButton newFilterRadioBtn;
    private javax.swing.JCheckBox notCheckSelected;
    private javax.swing.JLabel resetIcon;
    private javax.swing.JComboBox<String> searchTypeComboBox;
    private javax.swing.JTextArea selectedHadithTextArea;
    private javax.swing.JButton translateBtn;
    private javax.swing.JLabel undoBtn;
    // End of variables declaration//GEN-END:variables
}
