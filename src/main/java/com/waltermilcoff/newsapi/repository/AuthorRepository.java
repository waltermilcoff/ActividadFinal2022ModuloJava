package com.waltermilcoff.newsapi.repository;

import com.waltermilcoff.newsapi.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFullnameContaining(String word);
    List <Author> findByCreatedAtIsAfter(LocalDate date);

}
