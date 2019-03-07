package com.ymd.libsys.controller;

import com.ymd.libsys.Author;
import com.ymd.libsys.Book;
import com.ymd.libsys.BookCopy;
import com.ymd.libsys.ui.SystemObj;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;

public class BookController {
	private Book thisBook;
	@FXML
	private TextField titleT;
	@FXML
	private TextField isbnT;
	@FXML
	private Label copiesLbl;
	
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
	
	public BookController() {
		thisBook = new Book();	
	}
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
		Book b = new Book(isbnT.getText(),titleT.getText(),0);
		for(Author o : thisBook.authors) {
			b.addAuthor(o);
		}
		for(BookCopy c : thisBook.copies) {
			b.addCopy();
		}
		thisBook.editBook(b);
		thisBook = b;
	}
	
	@FXML
	public void addBook() {
		Book b = new Book(isbnT.getText(),titleT.getText(),0);
		for(Author o : thisBook.authors) {
			b.addAuthor(o);
		}
		for(BookCopy c : thisBook.copies) {
			b.addCopy();
		}
		
		Book.addBook(b);
	}
	
	public void setAuthor() {
		
	}

	@FXML
	public void addBookAuthor() {
		Book b = new Book(isbnT.getText(),titleT.getText(),0);
		for(Author o : thisBook.authors) {
			b.addAuthor(o);
		}
		for(BookCopy c : thisBook.copies) {
			b.addCopy();
		}
		thisBook = b;
		Window thisWindow = SystemObj.cw;
		
		FXMLLoader f = SystemObj.openWindow("NewAuthorForm", this);
		
		AuthorController controller = f.<AuthorController>getController();
		controller.initBookAuthor(thisBook, thisWindow);
	}
	@FXML
	public void addCopy() {
		int id = thisBook.addCopy();
		copiesLbl.setText((id>1? copiesLbl.getText() + ", ":"") + String.valueOf(id));
	}
	@FXML
	public void back() {
		SystemObj.openMenu();
	}
	@FXML
	public void openBook() {

		thisBook = Book.getBook(isbnT.getText());
		if(thisBook!= null) {
			
			copiesLbl.setText("");
			titleT.setText(thisBook.getTitle());
			checkoutLimitT.setText("0");
			Boolean fst = false;
			for(BookCopy c : thisBook.copies) {
				copiesLbl.setText(copiesLbl.getText() + (fst? ", ":"") + String.valueOf(c.copyId));
				fst = true;
			}
		}
	}
}
