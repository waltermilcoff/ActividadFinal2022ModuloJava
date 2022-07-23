package com.waltermilcoff.newsapi.repository;

import com.waltermilcoff.newsapi.domain.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {


}
