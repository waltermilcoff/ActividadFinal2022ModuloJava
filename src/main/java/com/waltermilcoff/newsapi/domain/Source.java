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
    @OneToMany(mappedBy = "source", cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Article> article = new ArrayList<>();

    /* modifique cascade y agregué otros atributos
    formula original del video APIMOVIE: CascadeType.ALL, orphanRemoval = false
    * AGREGADO: {CascadeType.DETACH,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
    * */

    public Source() {
    }

    public Source(String name, String code, LocalDate cratedAt, List<Article> article) {
        this.name = name;
        this.code = code;
        this.cratedAt = cratedAt;
        this.article = article;
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

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(id, source.id) && Objects.equals(name, source.name) && Objects.equals(code, source.code) && Objects.equals(cratedAt, source.cratedAt) && Objects.equals(article, source.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, cratedAt, article);
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cratedAt=" + cratedAt +
                ", article=" + article +
                '}';
    }
}
