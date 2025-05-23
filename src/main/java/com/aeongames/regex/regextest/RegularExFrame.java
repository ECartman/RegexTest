/* 
 *  Copyright © 2024 Eduardo Vindas Cordoba. All rights reserved.
 *  
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 * 
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.aeongames.regex.regextest;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Eduardo Vindas
 */
public class RegularExFrame extends javax.swing.JFrame {

    private static final String CHECKMARK = "✔",
            CROSSMARK = "❌";

    private Matcher WorkingMatcher = null;

    /**
     * Creates new form RegexTexterFrame and initializes the DocumentListener
     * for changes on the Regex text.
     */
    public RegularExFrame() {
        initComponents();
        txtregex.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                resetMatcher(false);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                resetMatcher(false);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                resetMatcher(false);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtregex = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtseveral = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmatches = new javax.swing.JTextField();
        txtWholeMatch = new javax.swing.JLabel();
        btExecute = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtData = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtRegGroups = new javax.swing.JLabel();
        txtError = new javax.swing.JLabel();
        cbStopWhole = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Regular Expression Tester");

        jLabel1.setText("Regular Expresion");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Results"));

        txtseveral.setColumns(20);
        txtseveral.setRows(5);
        jScrollPane2.setViewportView(txtseveral);

        jLabel2.setText("Whole Text Match: ");

        jLabel3.setText("Total Matches:");

        txtmatches.setEditable(false);

        txtWholeMatch.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtWholeMatch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtmatches, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtWholeMatch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmatches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btExecute.setText("Execute");
        btExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExecuteActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Text To Test Match"));

        txtData.setColumns(20);
        txtData.setRows(5);
        jScrollPane1.setViewportView(txtData);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jLabel5.setText("Regular Expresion Capturing Groups:");

        txtRegGroups.setText("0 Groups");

        txtError.setForeground(new java.awt.Color(255, 0, 0));

        cbStopWhole.setSelected(true);
        cbStopWhole.setText("Stop on Whole match");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtregex))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRegGroups)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbStopWhole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtregex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtRegGroups))
                        .addComponent(txtError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbStopWhole))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExecute)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(476, 381));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExecuteActionPerformed
        clearText();
        processandMatch();
    }//GEN-LAST:event_btExecuteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExecute;
    private javax.swing.JCheckBox cbStopWhole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtData;
    private javax.swing.JLabel txtError;
    private javax.swing.JLabel txtRegGroups;
    private javax.swing.JLabel txtWholeMatch;
    private javax.swing.JTextField txtmatches;
    private javax.swing.JTextField txtregex;
    private javax.swing.JTextArea txtseveral;
    // End of variables declaration//GEN-END:variables

    /**
     * resets the Pattern Matcher used by this frame.<br/>
     * if the text value from {@link RegularExFrame#txtregex} is empty or blanks
     * we will proceed to set the {@link RegularExFrame#WorkingMatcher} to null
     * as the regular expression is no longer required
     * <br/>
     * Otherwise if the WorkingMatcher is not null and the pattern matches with
     * the current regex and if {@code forceReset==true} then we reset the
     * matcher and set the data to match to the current
     * {@link RegularExFrame#txtData} otherwise we just return
     * <br/>
     * if {@link RegularExFrame#WorkingMatcher} is null, or the patter is
     * different. we reset the matcher to the current setup value at
     * {@link RegularExFrame#txtregex} however if we encounter a error setting
     * the next matching pattern (invalid pattern for example) we show a error
     * at {@link  RegularExFrame#txtError} and set the
     * {@link RegularExFrame#WorkingMatcher} as {@code null}.
     *
     * @param forceReset
     */
    private void resetMatcher(boolean forceReset) {
        var hasRegex = !txtregex.getText().isBlank();
        if (hasRegex && WorkingMatcher != null && WorkingMatcher.pattern().pattern().equals(txtregex.getText())) {
            if (forceReset) {
                WorkingMatcher.reset(txtData.getText());
            }
            //no further change is required
            return;
        }
        WorkingMatcher = null;
        if (!hasRegex) {
            return;
        }
        //at this point we have a regex text to set, the matecher is null, we are to set the matcher. 
        Pattern pattern;
        try {
            pattern = Pattern.compile(txtregex.getText());
            txtError.setText("");
        } catch (PatternSyntaxException exception) {
            txtError.setText("Regex Pattern is invalid");
            return;
        }
        WorkingMatcher = pattern.matcher(txtData.getText());
        //--- done setting the variable now look at a few properties of the pattern
        txtRegGroups.setText(String.format("%d", WorkingMatcher.groupCount()));
    }

    private void processandMatch(){
        resetMatcher(true);
        if (WorkingMatcher == null) {
            return;
        }
        boolean matches = WorkingMatcher.matches();
        txtWholeMatch.setText(matches ? CHECKMARK : CROSSMARK);
        if (matches) {
            try {
                txtseveral.getDocument().insertString(txtseveral.getDocument().getEndPosition().getOffset() - 1, "Whole String Match!\n", null);
                if (WorkingMatcher.groupCount() > 0) {
                    txtseveral.getDocument().insertString(txtseveral.getDocument().getEndPosition().getOffset() - 1, createGroupStringForMatch(WorkingMatcher, null), null);
                    txtseveral.getDocument().insertString(txtseveral.getDocument().getEndPosition().getOffset() - 1, "\n", null);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(RegularExFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            //should we stop if the whole string matches? 
            if (cbStopWhole.isSelected()) {
                txtmatches.setText("1*");
                return;
            }
        }
        WorkingMatcher.reset();
        int matched = 0;
        while (WorkingMatcher.find()) {
            matched++;
            //pull groups from this match 
            try {
                txtseveral.getDocument().insertString(txtseveral.getDocument().getEndPosition().getOffset() - 1, String.format("Match #%d\n", matched), null);
                txtseveral.getDocument().insertString(txtseveral.getDocument().getEndPosition().getOffset() - 1, String.format("[Match%d]\t\"%s\"\n", matched, WorkingMatcher.group()), null);
                if (WorkingMatcher.groupCount() > 0) {
                    txtseveral.getDocument().insertString(txtseveral.getDocument().getEndPosition().getOffset() - 1, createGroupStringForMatch(WorkingMatcher, String.format("[Match%d]\t", matched)), null);
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(RegularExFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        txtmatches.setText(String.format("%d", matched));
        WorkingMatcher.reset();
    }
    
    /**
     * clear the UI to the default or clear state. 
     */
    private void clearText() {
        txtError.setText("");
        txtseveral.setText("");
        txtWholeMatch.setText("");
        txtmatches.setText("");
    }

    /**
     * creates a String that contains the information of the available Capture groups
     * for this {@code Match}. 
     * for example: if the match has no capture groups. it returns an empty string
     * if there are at least one capture group (besides the "whole match") it will 
     * create a new string that is as follows:
     * <p>{@code <prepend String> Group <Match Number> match <the captured String><new line>}
     * <p>this repeated for as many groups there are for this {@code Match}. 
     * 
     * @param Match the MatchResult to process the result from. 
     * @param Prepend a String to pre-append to the Resulting String 
     * @return a String that contains the information for the capture groups of this match
     */
    private String createGroupStringForMatch(MatchResult Match, String Prepend) {
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < Match.groupCount(); index++) {
            builder.append(Prepend == null?"":Prepend);
            builder.append(String.format("Group %d match\"%s\"", index + 1, Match.group(index + 1)));
            builder.append('\n');
        }
        return builder.toString();
    }
}
