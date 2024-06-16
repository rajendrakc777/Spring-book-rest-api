package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.entity.BookEntity;

@Repository
public interface BookDao extends JpaRepository<BookEntity, Integer>{

}