package com.service;



import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.dao.BookDao;
import com.dto.BookDTO;

import com.entity.BookEntity;




@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired 
	BookDao bookDao;
	
	
	//save the book
	@Override
	public void saveBook(BookDTO bookDto) {
		BookEntity bookEntity= new BookEntity();
		//copy object from booDto to bookEntity
		BeanUtils.copyProperties(bookDto, bookEntity);
		bookDao.save(bookEntity);	
	}
	

	@Override
	public List<BookDTO> findAllBooks() {
		List<BookEntity> bookEntity =bookDao.findAll();//collection of record in bookentity
		
		List<BookDTO> bookDtoList= new ArrayList<>();//blank arraylist
		for (BookEntity temp : bookEntity) {
			BookDTO bookDto = new BookDTO();
			BeanUtils.copyProperties(temp, bookDto);
			bookDtoList.add(bookDto);
		}
		return bookDtoList;
	}

	
	//for finding list by book id
	@Override
	public BookDTO findBookById(int id) {
		Optional<BookEntity> optional = bookDao.findById(id);
		BookEntity bookEntity = optional.get();
		BookDTO bookDto = new BookDTO();
		// copy from bookEntity object to bookDto object
		BeanUtils.copyProperties(bookEntity, bookDto);
		return bookDto;//bookDto forwarede to restcontroller

	}
	//logic for deletion by book id
	@Override
	public void  deleteById(int id) {
		bookDao.deleteById(id);	
	}
	
	public void updateBook(BookDTO bookDto) {
		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(bookDto, bookEntity);
		bookDao.save(bookEntity);
		
		
	}

}
