package com.waltermilcoff.newsapi.converter;

import com.waltermilcoff.newsapi.domain.Author;
import com.waltermilcoff.newsapi.dto.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {
    public AuthorDTO toDTO(Author author) {
        return new AuthorDTO( author.getId(), author.getFirstname(), author.getLastname(),
                author.getFullname(), author.getCreatedAt());
    }
}
