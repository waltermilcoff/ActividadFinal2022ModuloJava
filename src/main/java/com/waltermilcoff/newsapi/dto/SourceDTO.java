package com.waltermilcoff.newsapi.dto;

import java.time.LocalDate;
import java.util.*;

public class SourceDTO {
    private Long id;
    private String name;
    private String code;
    private LocalDate cratedAt;
    private Set<ArticleDTO> articleDTOS = new HashSet<>();

    public SourceDTO() {
    }

    public SourceDTO(Long id, String name, String code, LocalDate cratedAt, Set<ArticleDTO> articleDTOS) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.cratedAt = cratedAt;
        this.articleDTOS = articleDTOS;
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
        SourceDTO sourceDTO = (SourceDTO) o;
        return Objects.equals(id, sourceDTO.id) && Objects.equals(name, sourceDTO.name) && Objects.equals(code, sourceDTO.code) && Objects.equals(cratedAt, sourceDTO.cratedAt) && Objects.equals(articleDTOS, sourceDTO.articleDTOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, cratedAt, articleDTOS);
    }

    @Override
    public String toString() {
        return "SourceDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cratedAt=" + cratedAt +
                ", articleDTOS=" + articleDTOS +
                '}';
    }
}
