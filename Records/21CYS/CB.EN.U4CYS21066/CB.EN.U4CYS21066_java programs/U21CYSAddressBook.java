package com.amrita.sanjai;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class U21CYSAddressBook extends JFrame {

    private JTable contactTable;
    private DefaultTableModel tableModel;

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;

    /**
     * Constructs the U21CYSAddressBook frame.
     * Initializes the GUI components and sets up the layout.
     */
    public U21CYSAddressBook() {
        setTitle("21CYS Address Book");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the table with default table model
        tableModel = new DefaultTableModel(new Object[]{"Name", "Phone Number", "Email"}, 0);
        contactTable = new JTable(tableModel);

        // Create the scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // Create the main panel and set layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the form panel and add labels and text fields
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(phoneLabel);
        formPanel.add(phoneField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);

        // Create the button panel and add buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new AddButtonListener());
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new EditButtonListener());
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteButtonListener());
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Add scroll pane, form panel, and button panel to the main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the content pane
        Container container = getContentPane();
        container.add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    /**
     * Validates a phone number.
     *
     * @param phone the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    private boolean isValidPhoneNumber(String phone) {
        // Perform validation logic for phone number (e.g., length, format, etc.)
        return true;
    }

    /**
     * Validates an email address.
     *
     * @param email the email address to validate
     * @return true if the email address is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        // Perform validation logic for email (e.g., format, etc.)
        return true;
    }

    /**
     * Clears the form fields.
     */
    private void clearFormFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    /**
     * ActionListener for the Add button.
     * Adds a new contact to the address book.
     */
    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Invalid phone number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Object[] contact = {name, phone, email};
            tableModel.addRow(contact);
            clearFormFields();
        }
    }

    /**
     * ActionListener for the Edit button.
     * Edits an existing contact in the address book.
     */
    private class EditButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Please select a contact to edit", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Invalid phone number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Invalid email address", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Object[] updatedContact = {name, phone, email};
            for (int i = 0; i < updatedContact.length; i++) {
                tableModel.setValueAt(updatedContact[i], selectedRow, i);
            }
            clearFormFields();
        }
    }

    /**
     * ActionListener for the Delete button.
     * Deletes a contact from the address book.
     */
    private class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(U21CYSAddressBook.this,
                        "Please select a contact to delete", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(U21CYSAddressBook.this,
                    "Are you sure you want to delete this contact?", "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                tableModel.removeRow(selectedRow);
                clearFormFields();
            }
        }
    }

    /**
     * Entry point of the application.
     * Creates and displays the U21CYSAddressBook frame.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new U21CYSAddressBook().setVisible(true));
    }
}