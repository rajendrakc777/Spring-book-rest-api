package com.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BookDTO;

import com.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	BookService bookService;


//fetch all books
	@GetMapping("/books")
	public List<BookDTO> fetchAll() {
		List<BookDTO> bookDtoList = bookService.findAllBooks();
		return bookDtoList;

	}
//insert the new books information 
	@PostMapping("/books")
	public String saveBook(@RequestBody BookDTO bookDto) {
		bookService.saveBook(bookDto);
		return "Books inserted Successsfully!!";

	}

	// fetch the particular record on the basis of book id
	@GetMapping("/books/{id}")
	public BookDTO findBookById(@PathVariable int id) {
		BookDTO bookDto = bookService.findBookById(id);

		return bookDto;

	}
	//delete the records when we given the required book id
	@DeleteMapping("/books/{id}")
	public String  deleteBookById(@PathVariable int id) {
		bookService.deleteById(id);
		return "delete operation successfully!!";
	}
	
	@PutMapping("books/{id}")
	public String  updateBook(@RequestBody BookDTO bookDto) {
		bookService.updateBook(bookDto);
		return "update operation Successfull!!!";
		
		
	}
}

