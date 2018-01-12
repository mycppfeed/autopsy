/*
 * Autopsy Forensic Browser
 *
 * Copyright 2017-18 Basis Technology Corp.
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
package org.sleuthkit.autopsy.communications;

import com.google.common.eventbus.Subscribe;
import java.util.List;
import java.util.stream.Collectors;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ProxyLookup;
import org.openide.windows.Mode;
import org.openide.windows.RetainLocation;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
import org.sleuthkit.autopsy.coreutils.ThreadConfined;

/**
 * Top component which displays the Communications Visualization Tool.
 */
@TopComponent.Description(preferredID = "CVTTopComponent", persistenceType = TopComponent.PERSISTENCE_NEVER)
@TopComponent.Registration(mode = "cvt", openAtStartup = false)
@RetainLocation("cvt")
@NbBundle.Messages("CVTTopComponent.name= Communications Visualization")
public final class CVTTopComponent extends TopComponent {

    private static final long serialVersionUID = 1L;

    @ThreadConfined(type = ThreadConfined.ThreadType.AWT)
    public CVTTopComponent() {
        initComponents();
        setName(Bundle.CVTTopComponent_name());

        /*
         * Associate a Lookup with the GlobalActionContext (GAC) so that
         * selections in the sub views can be exposed to context-sensitive
         * actions.
         */
        ProxyLookupImpl proxyLookup = new ProxyLookupImpl(accountsBrowser.getLookup());
        associateLookup(proxyLookup);
        // Make sure the GAC is proxying the selection of the active tab.
        browseVisualizeTabPane.addChangeListener(changeEvent -> {
            Lookup.Provider selectedComponent = (Lookup.Provider) browseVisualizeTabPane.getSelectedComponent();
            proxyLookup.changeLookups(selectedComponent.getLookup());
        });


        /*
         * Connect the filtersPane to the accountsBrowser and visualizaionPanel
         * via an Eventbus
         */
        CVTEvents.getCVTEventBus().register(this);
        CVTEvents.getCVTEventBus().register(vizPanel);
        CVTEvents.getCVTEventBus().register(accountsBrowser);
    }

    @Subscribe
    public void pinAccount(CVTEvents.PinAccountsEvent pinEvent) {
        browseVisualizeTabPane.setSelectedIndex(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseVisualizeTabPane = new javax.swing.JTabbedPane();
        accountsBrowser = new org.sleuthkit.autopsy.communications.AccountsBrowser();
        vizPanel = new org.sleuthkit.autopsy.communications.VisualizationPanel();
        filtersPane = new org.sleuthkit.autopsy.communications.FiltersPanel();

        browseVisualizeTabPane.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        browseVisualizeTabPane.addTab(org.openide.util.NbBundle.getMessage(CVTTopComponent.class, "CVTTopComponent.accountsBrowser.TabConstraints.tabTitle_1"), new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/communications/images/table.png")), accountsBrowser); // NOI18N
        browseVisualizeTabPane.addTab(org.openide.util.NbBundle.getMessage(CVTTopComponent.class, "CVTTopComponent.vizPanel.TabConstraints.tabTitle_1"), new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/communications/images/emblem-web.png")), vizPanel); // NOI18N

        filtersPane.setMinimumSize(new java.awt.Dimension(256, 495));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(filtersPane, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(browseVisualizeTabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(filtersPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(browseVisualizeTabPane)
                .addContainerGap())
        );

        browseVisualizeTabPane.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(CVTTopComponent.class, "CVTTopComponent.browseVisualizeTabPane.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.sleuthkit.autopsy.communications.AccountsBrowser accountsBrowser;
    private javax.swing.JTabbedPane browseVisualizeTabPane;
    private org.sleuthkit.autopsy.communications.FiltersPanel filtersPane;
    private org.sleuthkit.autopsy.communications.VisualizationPanel vizPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        super.componentOpened();
        WindowManager.getDefault().setTopComponentFloating(this, true);
    }

    @Override
    public void open() {
        super.open();
        /*
         * when the window is (re)opened make sure the filters and accounts are
         * in an up to date and consistent state.
         *
         * Re-applying the filters means we will lose the selection...
         */
        filtersPane.updateAndApplyFilters();
    }

    @Override
    public List<Mode> availableModes(List<Mode> modes) {
        /*
         * This looks like the right thing to do, but online discussions seems
         * to indicate this method is effectively deprecated. A break point
         * placed here was never hit.
         */
        return modes.stream().filter(mode -> mode.getName().equals("cvt"))
                .collect(Collectors.toList());
    }

    final private static class ProxyLookupImpl extends ProxyLookup {

        ProxyLookupImpl(Lookup... l) {
            super(l);
        }

        protected void changeLookups(Lookup... l) {
            setLookups(l);
        }
    }
}
