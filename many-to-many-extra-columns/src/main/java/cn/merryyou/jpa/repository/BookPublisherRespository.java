package cn.merryyou.jpa.repository;

import cn.merryyou.jpa.domain.Book;
import cn.merryyou.jpa.domain.BookPublisher;
import com.sun.istack.internal.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by pj on 2018/12/21.
 */
public interface BookPublisherRespository extends JpaRepository<BookPublisher,Integer>{

    @Query(value = "select * from book_publisher where publisher_id=?1",nativeQuery = true)
    List<BookPublisher> getALLBookPublisherByPublishedId(Integer publisherId);

    @Query(value = "select * from book_publisher where book_id=?1",nativeQuery = true)
    List<BookPublisher> getAllBookPublisherByBookId(Integer bookId);

    @Query(value = "select b.* from book_publisher b where b.published_date >= :startDate and b.published_date <=:endDate order by b.published_date DESC ", nativeQuery = true)
    List<BookPublisher> getBookPublisherByStartDateWithEndDate(@Param("startDate")Date startDate, @Param("endDate")Date endDate);


}
