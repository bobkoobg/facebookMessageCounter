/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Friend;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import master.Controller;
import protocol.ProtocolStrings;

/**
 *
 * @author root
 */
public class FBmsgCounter extends javax.swing.JFrame {

    /**
     * Creates new form FBmsgCounter
     */
    private List<String> peopleToRemove;

    Controller controller;

    public FBmsgCounter() {

        initComponents();

        jPanelProgram.setVisible( false );
        jPanelCredits.setVisible( false );
        jPanelHome.setVisible( true );

        setLocationRelativeTo( null );

        controller = new Controller();
        peopleToRemove = new ArrayList();
        jLabelMainPicture.setIcon( new javax.swing.ImageIcon( getClass().getResource( "/view/pics/bfmr.jpg" ) ) );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelProgram = new javax.swing.JPanel();
        jTextFieldOwnerInfo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFriends = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButtonExecute = new javax.swing.JButton();
        jLabelState = new javax.swing.JLabel();
        jTextFieldFileLocation = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextFieldName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jComboBoxForbiddenNames = new javax.swing.JComboBox();
        jPanelCredits = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaCredits = new javax.swing.JTextArea();
        jPanelHome = new javax.swing.JPanel();
        jLabelMainPicture = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuHome = new javax.swing.JMenu();
        jSubMenuProgram = new javax.swing.JMenu();
        jSubMenuMenuCredits = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bobkoo's Facebook Message Reader");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        jTextFieldOwnerInfo.setText("jTextField1");

        jTableFriends.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "#", "Friend Name", "Messages", "First Message", "Last Message", "Chat Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableFriends);
        if (jTableFriends.getColumnModel().getColumnCount() > 0) {
            jTableFriends.getColumnModel().getColumn(0).setMinWidth(10);
            jTableFriends.getColumnModel().getColumn(0).setPreferredWidth(59);
            jTableFriends.getColumnModel().getColumn(0).setMaxWidth(10);
            jTableFriends.getColumnModel().getColumn(1).setResizable(false);
            jTableFriends.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setText("Find the location of message.htm");

        jButtonExecute.setText("Execute");
        jButtonExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExecuteActionPerformed(evt);
            }
        });

        jLabelState.setText("jLabel2");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Exclude people (including your previous names)");

        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Remove");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelProgramLayout = new javax.swing.GroupLayout(jPanelProgram);
        jPanelProgram.setLayout(jPanelProgramLayout);
        jPanelProgramLayout.setHorizontalGroup(
            jPanelProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProgramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelProgramLayout.createSequentialGroup()
                        .addComponent(jTextFieldName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxForbiddenNames, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProgramLayout.createSequentialGroup()
                        .addComponent(jTextFieldFileLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(jTextFieldOwnerInfo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(jPanelProgramLayout.createSequentialGroup()
                        .addGroup(jPanelProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelProgramLayout.createSequentialGroup()
                                .addComponent(jButtonExecute)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelState))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelProgramLayout.setVerticalGroup(
            jPanelProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProgramLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jTextFieldOwnerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(jPanelProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFileLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExecute)
                    .addComponent(jLabelState))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(jPanelProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonRemove)
                    .addComponent(jComboBoxForbiddenNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jLabel3.setText("CREDITS <#,3,3,3,3#<,3,,3,33");

        jTextAreaCredits.setColumns(20);
        jTextAreaCredits.setRows(5);
        jScrollPane2.setViewportView(jTextAreaCredits);

        javax.swing.GroupLayout jPanelCreditsLayout = new javax.swing.GroupLayout(jPanelCredits);
        jPanelCredits.setLayout(jPanelCreditsLayout);
        jPanelCreditsLayout.setHorizontalGroup(
            jPanelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreditsLayout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelCreditsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanelCreditsLayout.setVerticalGroup(
            jPanelCreditsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCreditsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelHomeLayout = new javax.swing.GroupLayout(jPanelHome);
        jPanelHome.setLayout(jPanelHomeLayout);
        jPanelHomeLayout.setHorizontalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabelMainPicture)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHomeLayout.setVerticalGroup(
            jPanelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMainPicture)
                .addContainerGap(482, Short.MAX_VALUE))
        );

        jMenuHome.setText("Home");
        jMenuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuHomeMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuHome);

        jSubMenuProgram.setText("Program");
        jSubMenuProgram.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSubMenuProgramMouseClicked(evt);
            }
        });
        jSubMenuProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubMenuProgramActionPerformed(evt);
            }
        });
        jMenuBar1.add(jSubMenuProgram);

        jSubMenuMenuCredits.setText("Credits");
        jSubMenuMenuCredits.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSubMenuMenuCreditsMouseClicked(evt);
            }
        });
        jSubMenuMenuCredits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSubMenuMenuCreditsActionPerformed(evt);
            }
        });
        jMenuBar1.add(jSubMenuMenuCredits);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCredits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelProgram, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog( null );
        File file = fileChooser.getSelectedFile();
        String filePath = file.getAbsolutePath();
        jTextFieldFileLocation.setText( filePath );
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonExecuteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonExecuteActionPerformed
    {//GEN-HEADEREND:event_jButtonExecuteActionPerformed
        String filePath = jTextFieldFileLocation.getText();
        int lastDotIndex = filePath.lastIndexOf( '.' );
        String fileExtension = filePath.substring( lastDotIndex );
        System.out.println( "fileExtension: " + fileExtension );
        if ( ProtocolStrings.exactFileExtension.equals( fileExtension ) ) {
            if ( controller.formatData( filePath ) ) {
                controller.omitParticularUserAlias( peopleToRemove );
                populatejTableFriends( controller.getResults() );
                jTextFieldOwnerInfo.setText( controller.ownerInformation() );
                jLabelState.setText( "The whole data was loaded correctly" );
            } else {
                jLabelState.setText( "500 Internal Server Error :D" );
            }

        } else {
            jLabelState.setText( "Wrong file" );
        }
        jTextFieldOwnerInfo.setVisible( true );
        jLabelState.setVisible( true );
    }//GEN-LAST:event_jButtonExecuteActionPerformed

    private void jSubMenuProgramActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jSubMenuProgramActionPerformed
    {//GEN-HEADEREND:event_jSubMenuProgramActionPerformed
        //Misleading and not working event
    }//GEN-LAST:event_jSubMenuProgramActionPerformed

    private void jSubMenuMenuCreditsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jSubMenuMenuCreditsActionPerformed
    {//GEN-HEADEREND:event_jSubMenuMenuCreditsActionPerformed
        //Misleading and not working event
    }//GEN-LAST:event_jSubMenuMenuCreditsActionPerformed

    private void jSubMenuProgramMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jSubMenuProgramMouseClicked
    {//GEN-HEADEREND:event_jSubMenuProgramMouseClicked
        jPanelProgram.setVisible( true );
        jPanelCredits.setVisible( false );
        jPanelHome.setVisible( false );

        jTextFieldFileLocation.setEditable( false );
        jLabelState.setVisible( false );
        jTextFieldOwnerInfo.setVisible( false );
        jTextFieldOwnerInfo.setEditable( false );
    }//GEN-LAST:event_jSubMenuProgramMouseClicked

    private void jSubMenuMenuCreditsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jSubMenuMenuCreditsMouseClicked
    {//GEN-HEADEREND:event_jSubMenuMenuCreditsMouseClicked
        jPanelCredits.setVisible( true );
        jPanelProgram.setVisible( false );
        jPanelHome.setVisible( false );
        creditsText();
    }//GEN-LAST:event_jSubMenuMenuCreditsMouseClicked

    private void jMenuHomeMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jMenuHomeMouseClicked
    {//GEN-HEADEREND:event_jMenuHomeMouseClicked
        jPanelHome.setVisible( true );
        jPanelCredits.setVisible( false );
        jPanelProgram.setVisible( false );
    }//GEN-LAST:event_jMenuHomeMouseClicked

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonAddActionPerformed
    {//GEN-HEADEREND:event_jButtonAddActionPerformed

        if ( jTextFieldName.getText().length() <= 30 ) {
            jComboBoxForbiddenNames.addItem( jTextFieldName.getText() );
            peopleToRemove.add( jTextFieldName.getText() );
            jLabelState.setText( "Name added successfully" );
        } else {
            jLabelState.setText( "Name is too long" );
        }
        jLabelState.setVisible( true );
        jTextFieldName.setText( "" );
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonRemoveActionPerformed
    {//GEN-HEADEREND:event_jButtonRemoveActionPerformed

        for ( Iterator<String> iter = peopleToRemove.listIterator(); iter.hasNext(); ) {
            String a = iter.next();
            if ( a.equals( jComboBoxForbiddenNames.getSelectedItem() ) ) {
                iter.remove();
            }
        }
        jComboBoxForbiddenNames.removeItemAt( jComboBoxForbiddenNames.getSelectedIndex() );
        jLabelState.setText( "Name removed successfully" );
        jTextFieldName.setText( "" );
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void populatejTableFriends( List<Friend> friends ) {
        clearTable( jTableFriends );
        String[] friendsTableColumnNames = new String[]{
            "#", "Friend Name", "Messages", "First Message", "Last Message", "Chat Duration"
        };
        List<Friend> listOfFriends = friends;
        Object[][] data = new Object[ listOfFriends.size() ][ 6 ];
        for ( int i = 0; i < listOfFriends.size(); i++ ) {
            int messageCounter = listOfFriends.get( i ).getCounter();
            Date firstMessage = listOfFriends.get( i ).getFirstMessage();
            Date lastMessage = listOfFriends.get( i ).getLastMessage();
            int chatDuration = controller.daysBetween( firstMessage, lastMessage );

            data[ i ][ 0 ] = i + 1;
            data[ i ][ 1 ] = listOfFriends.get( i ).getName();
            data[ i ][ 2 ] = messageCounter;
            data[ i ][ 3 ] = firstMessage;
            data[ i ][ 4 ] = lastMessage;
            data[ i ][ 5 ] = chatDuration + " days";
        }
        jTableFriends.setModel( new DefaultTableModel( data, friendsTableColumnNames ) {
            @Override
            public boolean isCellEditable( int row, int column ) {
                return false;
            }
        } );

//        jTableFriends.getColumnModel().getColumn(0).setPreferredWidth(3);
//        jTableFriends.getColumnModel().getColumn(1).setPreferredWidth(10);
//        jTableFriends.getColumnModel().getColumn(2).setPreferredWidth(5);
//        jTableFriends.getColumnModel().getColumn(3).setPreferredWidth(10);
//        jTableFriends.getColumnModel().getColumn(4).setPreferredWidth(10);
//        jTableFriends.getColumnModel().getColumn(5).setPreferredWidth(7);
    }

    public static void clearTable( final JTable table ) {
        for ( int i = 0; i < table.getRowCount(); i++ ) {
            for ( int j = 0; j < table.getColumnCount(); j++ ) {
                table.setValueAt( "", i, j );
            }
        }
    }

    private void creditsText() {
        jTextAreaCredits.setEditable( false );
        jTextAreaCredits.setText( "This program is working based on a messages.htm, which can be \n"
                + "found in the copy of your Facebook data. Your can retrieve a copy \n"
                + "by pressing \"Download a copy of your Facebook data.\" in your\n"
                + "\"Setting\" menu on Facebook. In few minutes you should receive\n"
                + "an e-mail containing all your information in an archive. You should\n"
                + "extract a specific file out of the archive located in \"html\"\n"
                + "folder named \"messages.html\". This file contains all your message\n"
                + "history. You should locate this file via the \"Browse\" button in\n"
                + "the sub-menu called \"Program\". Then you should press \"Execute\".\n"
                + "After that you will receive statistics concerning you message history.\n\n"
                + "What can go wrong?\n"
                + "The program is working with HTML file, Facebook can always decide to\n"
                + "change the format, so then that whole code won't work\n"
                + "This code was released on 29.04.2015\n"
                + "If a user had changed his/her name he/she will be considered as 2 or\n"
                + "more different people, depending on the amount of name changes and\n"
                + "this cannot be omitted, because of the format of the HTML file itself.\n"
                + "If you have added HTML code to any message in a facebook chat, you\n"
                + "will most probably slightly disturb the resuts made by this program\n\n"
                + "How can I be sure that the calculations are correct?\n"
                + "Believe me, I calculated manually my chat messages several times\n"
                + "just to double check. (Yes, I am crazy, I know) The differences\n"
                + "were not that big (usually with 100-200messages less than what I\n"
                + "calculated manually)\n\n"
                + "Are you stealing my information, you FGT?\n"
                + "Nope, this program is open-source product and if you do not believe\n"
                + "me, you better check the code itself on github. It's just taking\n"
                + "your data, refactoring then it's making some calculations... I guess\n"
                + "this sums it up. Everything is done locally, of course. I am not\n"
                + "that pro :P\n\n"
                + "I think there is something wrong with this program, can I edit it?\n"
                + "Yes, you can. This is an open sourcep project and I will be happy\n"
                + "if someone gives me some feedback, so that I can develope my skills.\n\n"
                + "Info and credits:\n"
                + "Github project : https://github.com/bobkoobg/facebookMessageCounter\n"
                + "My linked-in : https://www.linkedin.com/profile/view?id=299306525\n\n"
                + "Thank you and I hope that this program serves you well ^^\n\n"
                + "Namaste to Cristi, who helped me with my small bug." );
    }

    /**
     * @param args the command line arguments
     */
    public static void main( String args[] ) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels() ) {
                if ( "Nimbus".equals( info.getName() ) ) {
                    javax.swing.UIManager.setLookAndFeel( info.getClassName() );
                    break;

                }
            }
        } catch ( ClassNotFoundException ex ) {
            java.util.logging.Logger.getLogger( FBmsgCounter.class
                    .getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( InstantiationException ex ) {
            java.util.logging.Logger.getLogger( FBmsgCounter.class
                    .getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( IllegalAccessException ex ) {
            java.util.logging.Logger.getLogger( FBmsgCounter.class
                    .getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        } catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
            java.util.logging.Logger.getLogger( FBmsgCounter.class
                    .getName() ).log( java.util.logging.Level.SEVERE, null, ex );
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater( new Runnable() {
            public void run() {
                new FBmsgCounter().setVisible( true );
            }
        } );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonExecute;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JComboBox jComboBoxForbiddenNames;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelMainPicture;
    private javax.swing.JLabel jLabelState;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuHome;
    private javax.swing.JPanel jPanelCredits;
    private javax.swing.JPanel jPanelHome;
    private javax.swing.JPanel jPanelProgram;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu jSubMenuMenuCredits;
    private javax.swing.JMenu jSubMenuProgram;
    private javax.swing.JTable jTableFriends;
    private javax.swing.JTextArea jTextAreaCredits;
    private javax.swing.JTextField jTextFieldFileLocation;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldOwnerInfo;
    // End of variables declaration//GEN-END:variables
}
