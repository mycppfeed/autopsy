/*
 * Autopsy Forensic Browser
 *
 * Copyright 2019 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.keywordsearch.multicase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import org.openide.explorer.ExplorerManager;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.sleuthkit.autopsy.casemodule.multiusercasesbrowser.MultiUserCasesBrowserPanel;

/**
 * Panel for multi-user case selection
 */
public class SelectMultiUserCasesPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;
    private final JDialog parentDialog;
    private final MultiUserCasesBrowserPanel caseBrowserPanel;
    private final List<ActionListener> listeners;

    /**
     * Constructs a JPanel that allows a user to open a multi-user case.
     *
     * @param parentDialog The parent dialog of the panel, may be null. If
     *                     provided, the dialog is hidden when this poanel's
     *                     cancel button is pressed.
     */
    SelectMultiUserCasesPanel(JDialog parentDialog) {
        initComponents();
        this.parentDialog = parentDialog;
        initComponents(); // Machine generated code 
        caseBrowserPanel = new MultiUserCasesBrowserPanel(new ExplorerManager(), new SelectMultiUserCaseDialogCustomizer());
        multiUserCaseScrollPane.add(caseBrowserPanel);
        multiUserCaseScrollPane.setViewportView(caseBrowserPanel);
        listeners = new ArrayList<>();
    }

    /**
     * Refreshes the child component that displays the multi-user cases known to
     * the coordination service..
     */
    void refreshDisplay() {
        caseBrowserPanel.displayCases();
    }

    /**
     * Subscribes to the selections when the user presses the OK button.
     *
     * @param listener
     */
    void subscribeToNewCaseSelections(ActionListener listener) {
        listeners.add(listener);
    }

    /**
     * Sets the selections in the panel
     *
     * @param selections
     *
     * @throws PropertyVetoException
     */
    void setSelections(Node[] selections) throws PropertyVetoException {
        caseBrowserPanel.getExplorerManager().setSelectedNodes(selections);
        caseBrowserPanel.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        multiUserCaseScrollPane = new javax.swing.JScrollPane();
        selectAllButton = new javax.swing.JButton();
        deselectAllButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        confirmSelections = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        org.openide.awt.Mnemonics.setLocalizedText(selectAllButton, org.openide.util.NbBundle.getMessage(SelectMultiUserCasesPanel.class, "SelectMultiUserCasesPanel.selectAllButton.text")); // NOI18N
        selectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(deselectAllButton, org.openide.util.NbBundle.getMessage(SelectMultiUserCasesPanel.class, "SelectMultiUserCasesPanel.deselectAllButton.text")); // NOI18N
        deselectAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deselectAllButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(SelectMultiUserCasesPanel.class, "SelectMultiUserCasesPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(confirmSelections, org.openide.util.NbBundle.getMessage(SelectMultiUserCasesPanel.class, "SelectMultiUserCasesPanel.confirmSelections.text")); // NOI18N
        confirmSelections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmSelectionsActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cancelButton, org.openide.util.NbBundle.getMessage(SelectMultiUserCasesPanel.class, "SelectMultiUserCasesPanel.cancelButton.text")); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(refreshButton, org.openide.util.NbBundle.getMessage(SelectMultiUserCasesPanel.class, "SelectMultiUserCasesPanel.refreshButton.text")); // NOI18N
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(multiUserCaseScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deselectAllButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmSelections, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(multiUserCaseScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(selectAllButton)
                    .addComponent(deselectAllButton)
                    .addComponent(confirmSelections)
                    .addComponent(cancelButton)
                    .addComponent(refreshButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void selectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllButtonActionPerformed
        try {
            caseBrowserPanel.getExplorerManager().setSelectedNodes(caseBrowserPanel.getExplorerManager().getRootContext().getChildren().getNodes());
        } catch (PropertyVetoException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_selectAllButtonActionPerformed

    private void deselectAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deselectAllButtonActionPerformed
        try {
            caseBrowserPanel.getExplorerManager().setSelectedNodes(new Node[0]);
        } catch (PropertyVetoException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_deselectAllButtonActionPerformed

    private void confirmSelectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmSelectionsActionPerformed
        listeners.forEach((l) -> {
            //Pass along the selected nodes in the event.
            l.actionPerformed(new ActionEvent(caseBrowserPanel.getExplorerManager().getSelectedNodes(), -1, ""));
        });
        parentDialog.setVisible(false);
    }//GEN-LAST:event_confirmSelectionsActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        parentDialog.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        caseBrowserPanel.displayCases();
    }//GEN-LAST:event_refreshButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmSelections;
    private javax.swing.JButton deselectAllButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane multiUserCaseScrollPane;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton selectAllButton;
    // End of variables declaration//GEN-END:variables
}
