package com.ymd.libsys.controller;

import com.ymd.libsys.Book;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BookController {
	
	
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
	public void showNewBookForm() {
		
	}
	
	@FXML
	public void deleteBook() {
		
	}
	
	@FXML
	public void editBook() {
		
	}
	
	@FXML
	public void back() {
		
	}
}
