package com.waltermilcoff.newsapi.dto;

import org.hibernate.loader.collection.OneToManyJoinWalker;

import java.time.LocalDate;
import java.util.*;

public class AuthorDTO {
    private Long id;
    private String firstname;
    private String lastname;
    private String fullname;
    private LocalDate createdAt;
    private Set<ArticleDTO> articleDTOS = new HashSet<>();

    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String firstname,
                     String lastname, String fullname,
                     LocalDate createdAt, Set<ArticleDTO> articleDTOS) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = fullname;
        this.createdAt = createdAt;
        this.articleDTOS = articleDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<ArticleDTO> getArticleDTOS() {
        return articleDTOS;
    }

    public void setArticleDTOS(Set<ArticleDTO> articleDTOS) {
        this.articleDTOS = articleDTOS;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDTO authorDTO = (AuthorDTO) o;
        return Objects.equals(id, authorDTO.id) && Objects.equals(firstname, authorDTO.firstname) && Objects.equals(lastname, authorDTO.lastname) && Objects.equals(fullname, authorDTO.fullname) && Objects.equals(createdAt, authorDTO.createdAt) && Objects.equals(articleDTOS, authorDTO.articleDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, fullname, createdAt, articleDTOS);
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", createdAt=" + createdAt +
                ", articleDTOS=" + articleDTOS +
                '}';
    }
}
