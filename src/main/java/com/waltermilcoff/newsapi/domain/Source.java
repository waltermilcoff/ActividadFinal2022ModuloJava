package com.waltermilcoff.newsapi.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private LocalDate cratedAt;
    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Article> articles = new ArrayList<>();


    public Source() {
    }

    public Source(String name, String code, LocalDate cratedAt, List<Article> articles) {
        this.name = name;
        this.code = code;
        this.cratedAt = cratedAt;
        this.articles = articles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDate cratedAt) {
        this.cratedAt = cratedAt;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(id, source.id) && Objects.equals(name, source.name) && Objects.equals(code, source.code) && Objects.equals(cratedAt, source.cratedAt) && Objects.equals(articles, source.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, cratedAt, articles);
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cratedAt=" + cratedAt +
                ", articles=" + articles +
                '}';
    }
}
