/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PresentationLayer;

import BusinessLogicLayer.ArrayConverterBO;
import BusinessLogicLayer.FascadeBLL;
import BusinessLogicLayer.IFascadeBLL;
import TransferObject.Hadith;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ch-sa
 */
public class SmartSearchPanel extends javax.swing.JPanel {

    IFascadeBLL fascadeBLL;

    public SmartSearchPanel() {
        initComponents();
        fascadeBLL = new FascadeBLL();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRound newFilterBackPanel;
        newFilterBackPanel = new PanelRound();
        filterLbl = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        hadithTextArea = new javax.swing.JTextArea();
        ahadeesInResearchTableScrollPane = new javax.swing.JScrollPane();
        hadithTable = new javax.swing.JTable();
        translateBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(7, 7, 57));

        newFilterBackPanel.setBackground(new java.awt.Color(47, 18, 76));
        newFilterBackPanel.setAllCornersRound(25);

        filterLbl.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        filterLbl.setForeground(new java.awt.Color(254, 194, 96));
        filterLbl.setText("Enter Hadith:");

        searchBtn.setBackground(new java.awt.Color(254, 194, 96));
        searchBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(59, 24, 95));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        hadithTextArea.setBackground(new java.awt.Color(196, 182, 182));
        hadithTextArea.setColumns(20);
        hadithTextArea.setRows(5);
        jScrollPane1.setViewportView(hadithTextArea);

        javax.swing.GroupLayout newFilterBackPanelLayout = new javax.swing.GroupLayout(newFilterBackPanel);
        newFilterBackPanel.setLayout(newFilterBackPanelLayout);
        newFilterBackPanelLayout.setHorizontalGroup(
            newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newFilterBackPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(newFilterBackPanelLayout.createSequentialGroup()
                        .addComponent(filterLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        newFilterBackPanelLayout.setVerticalGroup(
            newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newFilterBackPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(newFilterBackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

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
            hadithTable.getColumnModel().getColumn(0).setMinWidth(40);
            hadithTable.getColumnModel().getColumn(0).setMaxWidth(40);
            hadithTable.getColumnModel().getColumn(1).setMinWidth(60);
            hadithTable.getColumnModel().getColumn(1).setMaxWidth(60);
            hadithTable.getColumnModel().getColumn(2).setMinWidth(120);
            hadithTable.getColumnModel().getColumn(2).setMaxWidth(120);
            hadithTable.getColumnModel().getColumn(4).setMinWidth(300);
            hadithTable.getColumnModel().getColumn(4).setMaxWidth(500);
        }

        translateBtn.setBackground(new java.awt.Color(254, 194, 96));
        translateBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        translateBtn.setForeground(new java.awt.Color(59, 24, 95));
        translateBtn.setText("Translate");
        translateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateBtnActionPerformed(evt);
            }
        });

        jScrollPane4.setBackground(new java.awt.Color(47, 18, 76));
        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(47, 18, 76), 5, true));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(196, 182, 182));
        jTextArea2.setColumns(15);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(null);
        jScrollPane4.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(translateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(newFilterBackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(ahadeesInResearchTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newFilterBackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(translateBtn)
                .addGap(29, 29, 29)
                .addComponent(ahadeesInResearchTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String matn = hadithTextArea.getText();
        ArrayList<String> topics = fascadeBLL.getTopics(matn);
        search();

    }//GEN-LAST:event_searchBtnActionPerformed

    private void hadithTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hadithTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        if (hadithTable.getValueAt(row, 3) != null) {
            String matn = hadithTable.getValueAt(row, 3).toString();
            jTextArea2.setText(matn);
        }
    }//GEN-LAST:event_hadithTableMouseClicked

    private void translateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateBtnActionPerformed
        if (!jTextArea2.getText().equals("")) {
            String englishHadith = fascadeBLL.getTranslationToEnglish(jTextArea2.getText());
            jTextArea2.setText(englishHadith);
        } else
        JOptionPane.showMessageDialog(null, "Please select a hadith from below table.", "Warning", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_translateBtnActionPerformed

    private void search() {
        if (hadithTextArea.getText().replaceAll(" ", "") != "" && !hadithTextArea.getText().equals("")) {
            ArrayList<Hadith> hadiths = fascadeBLL.Search(hadithTextArea.getText());
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
        System.out.println("done");

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ahadeesInResearchTableScrollPane;
    private javax.swing.JLabel filterLbl;
    public javax.swing.JTable hadithTable;
    private javax.swing.JTextArea hadithTextArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JPanel newFilterBackPanel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton translateBtn;
    // End of variables declaration//GEN-END:variables
}
