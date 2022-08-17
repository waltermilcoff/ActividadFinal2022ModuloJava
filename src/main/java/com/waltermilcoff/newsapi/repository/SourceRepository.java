package com.waltermilcoff.newsapi.repository;

import com.waltermilcoff.newsapi.domain.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {

    List<Source> findByNameContaining(String palabra);

}
