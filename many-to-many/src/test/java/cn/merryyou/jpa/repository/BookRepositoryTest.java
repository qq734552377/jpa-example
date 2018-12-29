package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import cn.merryyou.jpa.domain.Publisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Test
    public void saveTest() throws Exception {

        Publisher publisherA = new Publisher("Publisher One");
        Publisher publisherB = new Publisher("Publisher Two");
        publisherRepository.save(publisherA);
        publisherRepository.save(publisherB);

        Book bookA = new Book("Book One");
        bookA.setPublishers(new HashSet<Publisher>() {{
            add(publisherA);
            add(publisherB);
        }});

        bookRepository.save(bookA);

    }

    @Test
    public void saveTest1() throws Exception{
        Publisher publisher = publisherRepository.findOne(24);
        Book bookA = new Book("Book Two");
        bookA.getPublishers().add(publisher);
        bookRepository.save(bookA);
    }

    @Test
    public void saveTest2() throws Exception{
        Book two = bookRepository.findOne(18);
        Publisher publisher = publisherRepository.findOne(25);
        two.getPublishers().add(publisher);
        bookRepository.save(two);
    }

    @Test
    public void findPublisherTest() throws Exception{
        Publisher publisher = publisherRepository.findOne(20);
        Set<Book> books = publisher.getBooks();
        for(Book book: books){
            System.out.println(book.getName()+"..."+book.getId());
        }
        Assert.assertNotNull(publisher);
        Assert.assertNotNull(publisher.getName());
    }

    @Test
    public void findAllTest() throws Exception {
        List<Book> books = bookRepository.findAll();
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    @Test
    public void findBookTest() throws Exception{
        Book book = bookRepository.findOne(16);
        Set<Publisher> publishers = book.getPublishers();
        for(Publisher publisher: publishers){
            System.out.println(publisher.getName()+"..."+publisher.getId());
        }
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getName());
    }
}