/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package PresentationLayer;

import BusinessLogicLayer.*;
import TransferObject.Research;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ch-sa
 */
public class ResearchListPanel extends javax.swing.JPanel {

    IFascadeBLL fascadeBLL;

    /**
     * Creates new form ResearchListPanel
     */
    public ResearchListPanel() {
        initComponents();
        fascadeBLL = new FascadeBLL();
        populateResearchTable(fascadeBLL.getAllResearches());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        researchTable = new javax.swing.JTable();
        createResearchBtn = new javax.swing.JButton();
        updateResearchBtn = new javax.swing.JButton();
        deleteResearchBtn = new javax.swing.JButton();
        mergeResearchBtn = new javax.swing.JButton();
        actionPanel = new javax.swing.JPanel();
        blankPanel = new javax.swing.JPanel();
        updatePanel = new PresentationLayer.PanelRound();
        openAddBtn1 = new javax.swing.JButton();
        openBackBtn1 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        createResearchLbl4 = new javax.swing.JLabel();
        createResearchLbl5 = new javax.swing.JLabel();
        createPanel = new PresentationLayer.PanelRound();
        createAddBtn = new javax.swing.JButton();
        createBackBtn = new javax.swing.JButton();
        createResearchNameTextField = new javax.swing.JTextField();
        createResearchLbl2 = new javax.swing.JLabel();
        createResearchLbl3 = new javax.swing.JLabel();
        openPanel = new PresentationLayer.PanelRound();
        openAddBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        createResearchLbl1 = new javax.swing.JLabel();
        createResearchLbl = new javax.swing.JLabel();
        openResearchNameTextField = new javax.swing.JTextField();
        openResearchBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(7, 7, 57));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        researchTable.setBackground(new java.awt.Color(196, 182, 182));
        researchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Serial", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        researchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                researchTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(researchTable);
        if (researchTable.getColumnModel().getColumnCount() > 0) {
            researchTable.getColumnModel().getColumn(0).setMinWidth(70);
            researchTable.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 147, 377, 412));

        createResearchBtn.setBackground(new java.awt.Color(254, 194, 96));
        createResearchBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        createResearchBtn.setForeground(new java.awt.Color(59, 24, 95));
        createResearchBtn.setText("Create  Research");
        createResearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createResearchBtnActionPerformed(evt);
            }
        });
        add(createResearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 71, -1, 33));

        updateResearchBtn.setBackground(new java.awt.Color(254, 194, 96));
        updateResearchBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        updateResearchBtn.setForeground(new java.awt.Color(59, 24, 95));
        updateResearchBtn.setText("Update Research");
        updateResearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateResearchBtnActionPerformed(evt);
            }
        });
        add(updateResearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 71, -1, 33));

        deleteResearchBtn.setBackground(new java.awt.Color(254, 194, 96));
        deleteResearchBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        deleteResearchBtn.setForeground(new java.awt.Color(59, 24, 95));
        deleteResearchBtn.setText("Delete Research");
        deleteResearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteResearchBtnActionPerformed(evt);
            }
        });
        add(deleteResearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 71, -1, 33));

        mergeResearchBtn.setBackground(new java.awt.Color(254, 194, 96));
        mergeResearchBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        mergeResearchBtn.setForeground(new java.awt.Color(59, 24, 95));
        mergeResearchBtn.setText("Merge Research");
        mergeResearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mergeResearchBtnActionPerformed(evt);
            }
        });
        add(mergeResearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 71, -1, 33));

        actionPanel.setBackground(new java.awt.Color(7, 7, 57));
        actionPanel.setLayout(new java.awt.CardLayout());

        blankPanel.setBackground(new java.awt.Color(7, 7, 57));

        javax.swing.GroupLayout blankPanelLayout = new javax.swing.GroupLayout(blankPanel);
        blankPanel.setLayout(blankPanelLayout);
        blankPanelLayout.setHorizontalGroup(
            blankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        blankPanelLayout.setVerticalGroup(
            blankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        actionPanel.add(blankPanel, "blankPanel");

        updatePanel.setBackground(new java.awt.Color(47, 18, 76));
        openPanel.setAllCornersRound(40);

        openAddBtn1.setBackground(new java.awt.Color(254, 194, 96));
        openAddBtn1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        openAddBtn1.setForeground(new java.awt.Color(59, 24, 95));
        openAddBtn1.setText("ADD");
        openAddBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAddBtn1ActionPerformed(evt);
            }
        });

        openBackBtn1.setBackground(new java.awt.Color(254, 194, 96));
        openBackBtn1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        openBackBtn1.setForeground(new java.awt.Color(59, 24, 95));
        openBackBtn1.setText("BACK");
        openBackBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBackBtn1ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(196, 182, 182));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        createResearchLbl4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createResearchLbl4.setForeground(new java.awt.Color(254, 194, 96));
        createResearchLbl4.setText("Enter New Name");

        createResearchLbl5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        createResearchLbl5.setForeground(new java.awt.Color(254, 194, 96));
        createResearchLbl5.setText("Update Research");

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(createResearchLbl5))
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(createResearchLbl4))
                    .addGroup(updatePanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(updatePanelLayout.createSequentialGroup()
                                .addComponent(openBackBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(openAddBtn1))
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(87, 87, 87))
        );
        updatePanelLayout.setVerticalGroup(
            updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updatePanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(createResearchLbl5)
                .addGap(58, 58, 58)
                .addComponent(createResearchLbl4)
                .addGap(15, 15, 15)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openBackBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openAddBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        actionPanel.add(updatePanel, "updatePanel");

        createPanel.setBackground(new java.awt.Color(47, 18, 76));
        createPanel.setAllCornersRound(40);

        createAddBtn.setBackground(new java.awt.Color(254, 194, 96));
        createAddBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        createAddBtn.setForeground(new java.awt.Color(59, 24, 95));
        createAddBtn.setText("ADD");
        createAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAddBtnActionPerformed(evt);
            }
        });

        createBackBtn.setBackground(new java.awt.Color(254, 194, 96));
        createBackBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        createBackBtn.setForeground(new java.awt.Color(59, 24, 95));
        createBackBtn.setText("BACK");
        createBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBackBtnActionPerformed(evt);
            }
        });

        createResearchNameTextField.setBackground(new java.awt.Color(196, 182, 182));
        createResearchNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createResearchNameTextFieldActionPerformed(evt);
            }
        });

        createResearchLbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createResearchLbl2.setForeground(new java.awt.Color(254, 194, 96));
        createResearchLbl2.setText("Enter Name");

        createResearchLbl3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        createResearchLbl3.setForeground(new java.awt.Color(254, 194, 96));
        createResearchLbl3.setText("Create New Research");

        javax.swing.GroupLayout createPanelLayout = new javax.swing.GroupLayout(createPanel);
        createPanel.setLayout(createPanelLayout);
        createPanelLayout.setHorizontalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(createResearchLbl3))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(createResearchLbl2))
                    .addGroup(createPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(createPanelLayout.createSequentialGroup()
                                .addComponent(createBackBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(createAddBtn))
                            .addComponent(createResearchNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(87, 87, 87))
        );
        createPanelLayout.setVerticalGroup(
            createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(createResearchLbl3)
                .addGap(58, 58, 58)
                .addComponent(createResearchLbl2)
                .addGap(15, 15, 15)
                .addComponent(createResearchNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(createPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        actionPanel.add(createPanel, "createPanel");

        openPanel.setBackground(new java.awt.Color(47, 18, 76));
        openPanel.setAllCornersRound(40);

        openAddBtn.setBackground(new java.awt.Color(254, 194, 96));
        openAddBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        openAddBtn.setForeground(new java.awt.Color(59, 24, 95));
        openAddBtn.setText("OPEN");
        openAddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAddBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(254, 194, 96));
        backBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(59, 24, 95));
        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        createResearchLbl1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        createResearchLbl1.setForeground(new java.awt.Color(254, 194, 96));
        createResearchLbl1.setText("Select Research");

        createResearchLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        createResearchLbl.setForeground(new java.awt.Color(254, 194, 96));
        createResearchLbl.setText("Open Research");

        openResearchNameTextField.setEditable(false);
        openResearchNameTextField.setBackground(new java.awt.Color(196, 182, 182));
        openResearchNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openResearchNameTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout openPanelLayout = new javax.swing.GroupLayout(openPanel);
        openPanel.setLayout(openPanelLayout);
        openPanelLayout.setHorizontalGroup(
            openPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openPanelLayout.createSequentialGroup()
                .addGroup(openPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(openPanelLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(createResearchLbl))
                    .addGroup(openPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(openPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(createResearchLbl1)
                            .addGroup(openPanelLayout.createSequentialGroup()
                                .addComponent(backBtn)
                                .addGap(129, 129, 129)
                                .addComponent(openAddBtn))
                            .addComponent(openResearchNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        openPanelLayout.setVerticalGroup(
            openPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(openPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(createResearchLbl)
                .addGap(57, 57, 57)
                .addComponent(createResearchLbl1)
                .addGap(18, 18, 18)
                .addComponent(openResearchNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(openPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openAddBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        actionPanel.add(openPanel, "openPanel");

        add(actionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(686, 147, 420, 360));

        openResearchBtn.setBackground(new java.awt.Color(254, 194, 96));
        openResearchBtn.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        openResearchBtn.setForeground(new java.awt.Color(59, 24, 95));
        openResearchBtn.setText("Open Research");
        openResearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openResearchBtnActionPerformed(evt);
            }
        });
        add(openResearchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 71, -1, 33));
    }// </editor-fold>//GEN-END:initComponents

    private void createResearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createResearchBtnActionPerformed
        CardLayout cardLayout = (CardLayout) actionPanel.getLayout();
        cardLayout.show(actionPanel, "createPanel");

    }//GEN-LAST:event_createResearchBtnActionPerformed

    private void updateResearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateResearchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateResearchBtnActionPerformed

    private void deleteResearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteResearchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteResearchBtnActionPerformed

    private void mergeResearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mergeResearchBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mergeResearchBtnActionPerformed

    private void openResearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openResearchBtnActionPerformed
        CardLayout cardLayout = (CardLayout) actionPanel.getLayout();
        cardLayout.show(actionPanel, "openPanel");
    }//GEN-LAST:event_openResearchBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        CardLayout cardLayout = (CardLayout) actionPanel.getLayout();
        cardLayout.show(actionPanel, "blankPanel");
    }//GEN-LAST:event_backBtnActionPerformed

    private void openAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAddBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openAddBtnActionPerformed

    private void createAddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAddBtnActionPerformed
        if (fascadeBLL.createResearch(createResearchNameTextField.getText())) {
            populateResearchTable(fascadeBLL.getAllResearches());
            JOptionPane.showMessageDialog(null, "Research Created .", "New Research", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Reseach with this name already exists.", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_createAddBtnActionPerformed

    private void createBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBackBtnActionPerformed
        CardLayout cardLayout = (CardLayout) actionPanel.getLayout();
        cardLayout.show(actionPanel, "blankPanel");
    }//GEN-LAST:event_createBackBtnActionPerformed

    private void createResearchNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createResearchNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createResearchNameTextFieldActionPerformed

    private void openAddBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openAddBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openAddBtn1ActionPerformed

    private void openBackBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBackBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openBackBtn1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void researchTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_researchTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        String researchName = researchTable.getValueAt(row, 1).toString();
        openResearchNameTextField.setText(researchName);
    }//GEN-LAST:event_researchTableMouseClicked

    private void openResearchNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openResearchNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openResearchNameTextFieldActionPerformed

    private void populateResearchTable(ArrayList<Research> researches) {
        if (!researches.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) researchTable.getModel();
            model.setRowCount(0);
            int count = 1;
            for (Research research : researches) {
                Object[] row = {count, research.getName()};
                count++;
                model.addRow(row);
            }
            researchTable.setModel(model);
        } else {
            JOptionPane.showMessageDialog(null, "No Reseaches Found.", "Warning", JOptionPane.WARNING_MESSAGE);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel blankPanel;
    private javax.swing.JButton createAddBtn;
    private javax.swing.JButton createBackBtn;
    private PresentationLayer.PanelRound createPanel;
    private javax.swing.JButton createResearchBtn;
    private javax.swing.JLabel createResearchLbl;
    private javax.swing.JLabel createResearchLbl1;
    private javax.swing.JLabel createResearchLbl2;
    private javax.swing.JLabel createResearchLbl3;
    private javax.swing.JLabel createResearchLbl4;
    private javax.swing.JLabel createResearchLbl5;
    private javax.swing.JTextField createResearchNameTextField;
    private javax.swing.JButton deleteResearchBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton mergeResearchBtn;
    private javax.swing.JButton openAddBtn;
    private javax.swing.JButton openAddBtn1;
    private javax.swing.JButton openBackBtn1;
    private PresentationLayer.PanelRound openPanel;
    private javax.swing.JButton openResearchBtn;
    private javax.swing.JTextField openResearchNameTextField;
    private javax.swing.JTable researchTable;
    private PresentationLayer.PanelRound updatePanel;
    private javax.swing.JButton updateResearchBtn;
    // End of variables declaration//GEN-END:variables
}
