package cn.merryyou.jpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@Entity
@Table(name = "book_detail")
@Data
public class BookDetail implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "number_of_pages")
    private Integer numberOfPages;

    public BookDetail() {
    }

    public BookDetail(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
