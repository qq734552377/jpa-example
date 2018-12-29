package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pj on 2018/12/10.
 */
public interface BookRepository extends JpaRepository<Book,Integer> {
}
