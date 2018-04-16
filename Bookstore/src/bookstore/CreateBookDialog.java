package bookstore;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class CreateBookDialog {


private final static int TABLE_SIZE = 29;
Random rand = new Random();

ArrayList<Book> bookList;

HashMap<Integer, Book> table = new HashMap<Integer, Book>();

public void put(int key, Book value){
	int hash = (key%TABLE_SIZE);

	while(table.containsKey(key)){
		hash = hash+1;
	}
	table.put(hash, value);
}

// Constructor code based on that for the Create and Edit dialog classes in the Shapes exercise.

JLabel titleLabel, authorLabel, priceLabel, categoryLabel;


JTextField titleTextField;
final JTextField authorTextField, priceTextField, categoryTextField;

CreateBookDialog(HashMap accounts) {
	
	super("Add Book Details");
	
	table = books;
	
	setLayout(new BorderLayout());
	
	JPanel dataPanel = new JPanel(new MigLayout());
	
	
	titleLabel = new JLabel("Title: ");
	titleTextField = new JTextField(15);
	titleTextField.setEditable(true);
	
	dataPanel.add(titleLabel, "growx, pushx");
	dataPanel.add(titleTextField, "growx, pushx, wrap");

	authorLabel = new JLabel("Author: ");
	authorTextField = new JTextField(15);
	authorTextField.setEditable(true);
	
	dataPanel.add(authorLabel, "growx, pushx");
	dataPanel.add(authorTextField, "growx, pushx, wrap");

	priceLabel = new JLabel("Price: ");
	priceTextField = new JTextField(15);
	priceTextField.setEditable(true);
	
	dataPanel.add(priceLabel, "growx, pushx");
	dataPanel.add(priceTextField, "growx, pushx, wrap");

	categoryLabel = new JLabel("Category: ");
	categoryTextField = new JTextField(5);
	categoryTextField.setEditable(true);
	
	dataPanel.add(categoryLabel, "growx, pushx");	
	dataPanel.add(categoryTextField, "growx, pushx, wrap");
	
	
	add(dataPanel, BorderLayout.CENTER);
	
	JPanel buttonPanel = new JPanel(new FlowLayout());
	JButton addButton = new JButton("Add");
	JButton cancelButton = new JButton("Cancel");
	
	buttonPanel.add(addButton);
	buttonPanel.add(cancelButton);
	
	add(buttonPanel, BorderLayout.SOUTH);
	
	addButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			
			String Title = titleTextField.getText();
			
			String Author = authorTextField.getText();
			String Price = priceTextField.getText();
			String Category = categoryTextField.getText();

	cancelButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	
	setSize(400,800);
	pack();
	setVisible(true);

		}
}
	

