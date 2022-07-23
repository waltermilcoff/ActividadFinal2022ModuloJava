package com.waltermilcoff.newsapi.controller;

import com.waltermilcoff.newsapi.domain.Source;
import com.waltermilcoff.newsapi.repository.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SourceController {

    private final SourceRepository sourceRepository;

    @Autowired
    public SourceController(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    @PostMapping("/source")
    public Source createSource(@RequestBody Source source) {
        return sourceRepository.save(source);

    }
}
