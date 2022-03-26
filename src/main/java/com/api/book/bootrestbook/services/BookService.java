package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

	
//	private static List<Book> list = new ArrayList<>();
	
//	static {
//		list.add(new Book(123,"Java Complete Ref","Sagar"));
//		list.add(new Book(456,"Think in Java ","Anubhav"));
//		list.add(new Book(789,"Live with Java","Anukalp"));
//	}
	@Autowired
	private BookRepository bookRepository;
		
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)this.bookRepository.findAll();
		return list;
	}
	
	// get single book
	
	public Book getBookById(int id) {
		Book book = null;
		try {
//		book = list.stream().filter(e->e.getId()==id).findFirst().get();
		book = this.bookRepository.findById(id);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
				return book;
	}
	
	// adding the book
	
	public Book addBook(Book b) {
		Book result = bookRepository.save(b);
		return result;
		
	}
	
	public void deleteBook(int bid) {

		bookRepository.deleteById(bid);
//		list = list.stream().filter(book->{
//			if (book.getId() != bid)
//				return true;
//			else
//				return false;
//		}).collect(Collectors.toList());
		
//		list = list.stream().filter(book->book.getId() != bid).collect(Collectors.toList());
	}	
	public void updateBook(Book book, int bookid) {
		book.setId(bookid);
		bookRepository.save(book);
//		list =list.stream().map(b -> {
//			if (b.getId() == book.bid) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
	
	}
}
