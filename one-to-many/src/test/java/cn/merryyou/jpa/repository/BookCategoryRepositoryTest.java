package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import cn.merryyou.jpa.domain.BookCategory;
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
public class BookCategoryRepositoryTest {

    @Autowired
    private BookCategoryRepository repository;
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void findAllBooks(){
        List<Book> books = bookRepository.findAll();
        for(Book item : books){
            System.out.println(item.getName());
        }
    }

    @Test
    public void saveCategoryTest(){
        BookCategory categoryOne = new BookCategory("Category One");
        Set books = new HashSet<Book>(){{
            add(new Book("诛仙", categoryOne));
            add(new Book("凡人修仙传", categoryOne));
            add(new Book("仙逆", categoryOne));
        }};
        categoryOne.setBooks(books);

        BookCategory categoryTwo = new BookCategory("Category Two");
        Set bookBs = new HashSet<Book>(){{
            add(new Book("Book Four", categoryTwo));
            add(new Book("Book Five", categoryTwo));
            add(new Book("Book Six", categoryTwo));
        }};
        categoryTwo.setBooks(bookBs);

        Set allBooks = new HashSet();

        allBooks.add(categoryOne);
        allBooks.add(categoryTwo);

        List list = repository.save(allBooks);

        Assert.assertNotNull(list);
    }

    @Test
    public void findAll() throws Exception{
        List<BookCategory> results = repository.findAll();
        for (BookCategory bookCategory : results) {
            System.out.println(bookCategory.toString());
        }
    }
}