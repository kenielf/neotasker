package com.neotasker.view.components;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class JPromptField extends JTextField {
    public JPromptField(String promptText) {
        super(promptText);

        addFocusListener(
                new FocusListener() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        if (getText().isEmpty()) {
                            setText(promptText);
                        }
                    }

                    @Override
                    public void focusGained(FocusEvent e) {
                        if (getText().equals(promptText)) {
                            setText("");
                        }
                    }
                });
    }
}
