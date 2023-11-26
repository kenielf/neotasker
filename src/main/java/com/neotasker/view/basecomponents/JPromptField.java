package com.neotasker.view.basecomponents;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

/**
 * This class is responsible for managing input fields.
 */
public class JPromptField extends JTextField {
    /**
     * Instantiates the prompt field.
     *
     * @param promptText the text to be set when input is not active or filled.
     */
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

