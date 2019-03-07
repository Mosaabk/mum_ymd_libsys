package com.ymd.libsys.controller;

import com.ymd.libsys.Book;
import com.ymd.libsys.ui.SystemObj;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class BookController {
	
	@FXML
	private TextField titleT;
	@FXML
	private TextField isbnT;
	@FXML
	private ComboBox<String> authors;
	@FXML
	private TextField checkoutLimitT;
	
	
	@FXML
	private TableView<Book> booksTV;
	
	@FXML
	private TableColumn<Book, String> checkoutLimit;
	@FXML
	private TableColumn<Book, String> title;
	@FXML
	private TableColumn<Book, String> isbn;
	@FXML
	private TableColumn<Book, String> author;
	
	
	@FXML
	private void close() {
		SystemObj.openMenu();
	}
	
	@FXML
	public void showNewBookForm() {
		
	}
	
	@FXML
	public void deleteBook() {
		
	}
	
	@FXML
	public void editBook() {
		
	}
	
	@FXML
	public void addBook() {
		
	}
	
	@FXML
	public void back() {
		SystemObj.openMenu();
	}
}
