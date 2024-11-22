package com.auchan.data;

import org.springframework.data.repository.CrudRepository;

import com.auchan.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}