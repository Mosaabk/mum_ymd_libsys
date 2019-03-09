package com.ymd.libsys.controller;

import java.util.Collection;

import com.alibaba.fastjson.JSON;
import com.ymd.libsys.Author;
import com.ymd.libsys.Book;
import com.ymd.libsys.BookCopy;
import com.ymd.libsys.Books;
import com.ymd.libsys.MyTool;
import com.ymd.libsys.ui.SystemObj;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	@FXML
	private TableColumn<Book, String> copyNum;
	
	public BookController() {
		thisBook = new Book();	
	}
	
	@FXML
    private void initialize() 
    {
	   try {
		   
		   title.setCellValueFactory(		 new PropertyValueFactory<Book, String>("title"));
		   isbn.setCellValueFactory(		 new PropertyValueFactory<Book, String>("ISBN"));
		   author.setCellValueFactory(       new PropertyValueFactory<Book, String>("authorsAll"));
//		   checkoutLimit.setCellValueFactory(new PropertyValueFactory<Book, String>("borrowLimit"));
		   copyNum.setCellValueFactory(      new PropertyValueFactory<Book, String>("copyNum"));
		   
		   listBooks();  
	   }
	   catch(Exception ex) {
			System.out.println("TEST: "+ex.getMessage());
	   }
	   
    }
    
    @FXML
    public void listBooks(){
        Task<ObservableList<Book>> task = new GetAllBooks();
        booksTV.itemsProperty().bind(task.valueProperty());

//        task.setOnSucceeded(e -> progressBar.setVisible(false));
//        task.setOnFailed(e -> progressBar.setVisible(false));
        new Thread(task).start();
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
	
	class GetAllBooks extends Task {

	    @Override
	    public ObservableList<Book> call(){
	    	String filePath = "src/com/ymd/libsys/dataaccess/books";
			String res = MyTool.readStringFromFile(filePath);
			Books books = JSON.parseObject(res, Books.class);
	        Collection<Book> listOfBooks = books.getBooks().values(); 
         	
			for(Book b : listOfBooks) {
				for(Author author: b.authors) {
//					System.out.println(author.getFirstName());
				}
			}
	        return FXCollections.observableArrayList(listOfBooks);
	               

	    }


	}
}
