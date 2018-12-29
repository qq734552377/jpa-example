package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.BookPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on 2018/2/5.
 *
 * @author zlf
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookPublisherRespository bookPublisherRespository;

    @Test
    public void manyToManyExtraColumnsTest() throws Exception{
//        Book bookA = new Book("Book A");
//
//        Publisher publisherA = new Publisher("Publisher A");

//        Book b1 = bookRepository.getOne(26);
//        Publisher p1 = publisherRepository.getOne(29);

//        BookPublisher bookPublisher = new BookPublisher();
//        bookPublisher.setBook(bookA);
//        bookPublisher.setPublisher(publisherA);
//        bookPublisher.setPublishedDate(new Date());
//        bookA.getBookPublishers().add(bookPublisher);
//        BookPublisher bookPublisher = new BookPublisher();
//        bookPublisher.setBook(b1);
//        bookPublisher.setPublisher(p1);
//        bookPublisher.setPublishedDate(new Date());
//
//        publisherRepository.save(publisherA);
//        bookRepository.save(bookA);

//        List<Book> books = bookRepository.findAll();
//        List<Publisher> publishers = publisherRepository.findAll();
//        books.size();


//        bookPublisherRespository.save(bookPublisher);
//        List<BookPublisher> bookPublishers = bookPublisherRespository.findAll();
        List<BookPublisher> bookPublishers = bookPublisherRespository.getALLBookPublisherByPublishedId(29);
        List<BookPublisher> bookPublishers1 = bookPublisherRespository.getAllBookPublisherByBookId(26);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = format.parse("2017-01-01 00:00:00");
        Date endDate = format.parse("2018-11-01 00:00:00");
        Sort sort = new Sort(Sort.Direction.DESC,"published_date");
        List<BookPublisher> bookPublishers2 = bookPublisherRespository.getBookPublisherByStartDateWithEndDate(startDate,endDate);


        bookPublishers.size();

//        // test
//        System.out.println(bookA.getBookPublishers().size());
//
//        // update
//        bookA.getBookPublishers().remove(bookPublisher);
//        bookRepository.save(bookA);
//
//        // test
//        System.out.println(bookA.getBookPublishers().size());
    }

}