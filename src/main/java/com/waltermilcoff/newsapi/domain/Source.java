package com.waltermilcoff.newsapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private LocalDate cratedAt;

    public Source() {
    }

    public Source(String name, String code, LocalDate cratedAt) {
        this.name = name;
        this.code = code;
        this.cratedAt = cratedAt;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Source source = (Source) o;
        return Objects.equals(id, source.id) && Objects.equals(name, source.name) && Objects.equals(code, source.code) && Objects.equals(cratedAt, source.cratedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, cratedAt);
    }

    @Override
    public String toString() {
        return "Source{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cratedAt=" + cratedAt +
                '}';
    }
}
