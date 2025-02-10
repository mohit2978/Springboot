package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="books")
public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByName(@Param("name") String name);
}
