package com.service;

import java.util.List;

import com.dto.BookDTO;

public interface BookService {

	void saveBook(BookDTO bookDto);

	List<BookDTO> findAllBooks();

	BookDTO findBookById(int id);

	void deleteById(int id);

	void updateBook(BookDTO bookDto);

}
