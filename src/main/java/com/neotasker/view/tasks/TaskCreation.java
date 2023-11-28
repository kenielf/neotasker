package com.neotasker.view.tasks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdesktop.swingx.JXDatePicker;

import com.neotasker.controllers.TaskController;
import com.neotasker.model.Tag;
import com.neotasker.model.Task;
import com.neotasker.model.TaskState;
import com.neotasker.utils.Constants;
import com.neotasker.view.basecomponents.JPromptField;

import net.miginfocom.swing.MigLayout;

public class TaskCreation extends JPanel {
    public static final String IDENTIFIER = "Criar Tarefa";
    
    public JLabel identifierLabel;
    public JSeparator identifierSeparator;


    public JLabel titlePrompt;
    public JTextField titleField;
    public JLabel titleCharacterCount;
    public JLabel titleWarningField;

    public JLabel descriptionPrompt;
    public JTextField descriptionField;
    public JLabel descriptionCharacterCount;
    public JLabel descriptionWarningField;

    public JLabel dueDatePrompt;
    public JXDatePicker dueDatePicker;
    public JLabel dueDateWarningField;

    public JLabel dueTimePrompt;
    public JPromptField dueTimeField;
    public JLabel dueTimeWarningField;

    public JLabel tagPrompt;
    public JTextField tagField;
    public JLabel tagWarningField;

    public JButton addButton;
    public JLabel addErrorMessage;

    public TaskCreation() {
        super();

        // Set layout
        setLayout(
            new MigLayout("fillx", "10%[left][right]10%")
        );

        // Create components
        this.identifierLabel = new JLabel(IDENTIFIER);
        this.identifierLabel.setFont(
            this.identifierLabel.getFont().deriveFont(22f)
        );
        this.identifierSeparator = new JSeparator(JSeparator.HORIZONTAL);

        // Title
        this.titlePrompt = new JLabel("Título");
        this.titlePrompt.setFont(
            this.titlePrompt.getFont().deriveFont(18f)
        );
        this.titleCharacterCount = new JLabel(
            String.format("%d/%d", 0, Constants.TITLE_SIZE)
        );
        this.titleField = new JTextField();
        this.titleField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent arg0) {
                updateCharacterCount(
                    titleCharacterCount,
                    titleField,
                    Constants.TITLE_SIZE,
                    titleWarningField
                );
            } 
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                updateCharacterCount(
                    titleCharacterCount,
                    titleField,
                    Constants.TITLE_SIZE,
                    titleWarningField
                );
            }
            @Override
            public void removeUpdate(DocumentEvent arg0) {
                updateCharacterCount(
                    titleCharacterCount,
                    titleField,
                    Constants.TITLE_SIZE,
                    titleWarningField
                );
            }
        });
        this.titleWarningField = new JLabel();

        // Description
        this.descriptionPrompt = new JLabel("Descrição");
        this.descriptionPrompt.setFont(
            this.descriptionPrompt.getFont().deriveFont(18f)
        );
        this.descriptionCharacterCount = new JLabel();
        this.descriptionCharacterCount.setText(
            String.format("%4d/%4d", 0, Constants.DESCRIPTION_SIZE)
        );
        this.descriptionField = new JTextField();
        this.descriptionField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent arg0) {
                updateCharacterCount(
                    descriptionCharacterCount,
                    descriptionField,
                    Constants.DESCRIPTION_SIZE,
                    descriptionWarningField
                );
            } 
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                updateCharacterCount(
                    descriptionCharacterCount,
                    descriptionField,
                    Constants.DESCRIPTION_SIZE,
                    descriptionWarningField
                );
            }
            @Override
            public void removeUpdate(DocumentEvent arg0) {
                updateCharacterCount(
                    descriptionCharacterCount,
                    descriptionField,
                    Constants.DESCRIPTION_SIZE,
                    descriptionWarningField
                );
            }
        });
        this.descriptionWarningField = new JLabel();

        // Due Date
        this.dueDatePrompt = new JLabel("Data Limite");
        this.dueDatePrompt.setFont(this.dueDatePrompt.getFont().deriveFont(18f));
        this.dueDatePicker = new JXDatePicker(new Locale("pt", "BR"));
        this.dueDateWarningField = new JLabel();

        // Due Time
        this.dueTimePrompt = new JLabel("Hora Limite (24 Horas)");
        this.dueTimePrompt.setFont(this.dueTimePrompt.getFont().deriveFont(18f));
        this.dueTimeField = new JPromptField("00:00");
        this.dueTimeWarningField = new JLabel();

        // Tags
        this.tagPrompt = new JLabel("Tags (Separado por vírgulas)");
        this.tagPrompt.setFont(this.tagPrompt.getFont().deriveFont(18f));
        this.tagField = new JTextField();
        this.tagWarningField = new JLabel();


        // Add Button
        this.addButton = new JButton("Adicionar Tarefa");
        this.addButton.addActionListener(
            (ActionEvent e) -> addTask()
        );
        this.addErrorMessage = new JLabel();

        // Identifier
        add(this.identifierLabel, "wrap");
        add(this.identifierSeparator, "align center, grow, span, wrap");

        // Title
        add(this.titlePrompt, "");
        add(this.titleCharacterCount, "wrap");
        add(this.titleField, "grow, span, wrap");
        add(this.titleWarningField, "wrap");

        // Description
        add(this.descriptionPrompt, "");
        add(this.descriptionCharacterCount, "wrap");
        add(this.descriptionField, "grow, span, wrap");
        add(this.descriptionWarningField, "grow, span, wrap");

        // Due Date
        add(this.dueDatePrompt, "wrap");
        add(this.dueDatePicker, "grow, span, wrap");
        add(this.dueDateWarningField, "wrap");

        // Due Time
        add(this.dueTimePrompt, "wrap");
        add(this.dueTimeField, "grow, span, wrap");
        add(this.dueTimeWarningField, "wrap");

        // Tags
        add(this.tagPrompt, "wrap");
        add(this.tagField, "grow, span, wrap");
        add(this.tagWarningField, "grow, span, wrap");

        // Add Button
        add(this.addErrorMessage, "grow, align left");
        add(this.addButton, "align right, wrap");
    }

    private void updateCharacterCount(JLabel characterCount, JTextField field, int limit, JLabel warningLabel) {
        int count = field.getText().length();
        characterCount.setText(String.format("%4d/%4d", count, limit));
        warningLabel.setText((count > limit || count == 0)? "Tamanho inválido!" : "");
    }

    private void cleanInput() {
        this.titleField.setText("");
        this.descriptionField.setText("");
        this.dueDatePicker.setDate(null);
        this.dueTimeField.setText("");
        this.tagField.setText("");
    }

    private void addTask() {
        TaskController taskController = new TaskController();
        Task task = new Task();
        boolean valid = false;
        // Validate and add fields
        String title = this.titleField.getText();
        boolean titleIsValid = false;
        if (title.length() > 0 && title.length() < Constants.TITLE_SIZE) {
            titleIsValid = true;
        }

        String description = this.descriptionField.getText();
        boolean descriptionIsValid = false;
        if (description.length() > 0 && description.length() < Constants.DESCRIPTION_SIZE) {
            descriptionIsValid = true;
        }

        Date dueDate = dueDatePicker.getDate();
        boolean dueDateIsValid = true;
        if (dueDate != null) {
            if (dueDate.compareTo(new Date(System.currentTimeMillis())) < 0) {
                this.dueDateWarningField.setText("Data Inválida: Não é possível criar tarefas para o passado!");
                dueDateIsValid = false;
            } else {
                this.dueDateWarningField.setText("");
            }
        }

        valid = titleIsValid && descriptionIsValid && dueDateIsValid;
        // Commit
        if (valid) {
            task.setTitle(this.titleField.getText().strip());
            task.setDescription(this.descriptionField.getText().strip());
            task.setStatus(false);
            this.addErrorMessage.setText("Tarefa Adicionada com Sucesso");
            cleanInput();
            this.titleWarningField.setText("");
            this.descriptionWarningField.setText("");
            taskController.registerTask(task);
        } else {
            this.addErrorMessage.setText("Existem Campos Inválidos!");
        }
        //
        // Commit
    }
}
