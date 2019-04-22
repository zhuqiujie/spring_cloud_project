package cn.com.sandi.qywx.book.service.impl;

import ch.qos.logback.classic.Logger;
import cn.com.sandi.qywx.base.jpa.dao.GenericDao;
import cn.com.sandi.qywx.base.myBatis.dao.QueryDao;
import cn.com.sandi.qywx.book.model.Book;
import cn.com.sandi.qywx.book.query.BookCriteria;
import cn.com.sandi.qywx.book.service.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value="bookService")
public class BookServiceImpl implements BookService {
	private static Logger logger = (Logger) LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Resource
	private QueryDao queryDao;
	
	@Resource
	private GenericDao<Book, Long> bookDao;
	
	
	public void insertBook(Book book) {
		Book book2 = bookDao.save(book);
		logger.info("book msg:"+book2.getBookName()+",id:"+book2.getBookId());
	}

	@Override
	public void updateBook(Book book) {
		bookDao.update(book);		
	}

	@Override
	public Book getBookById(Long id) {
		Book book =  bookDao.get(id);
		logger.info("test book,bookId="+book.getBookId()+",bookname="+book.getBookName());
		return book;
	}
	
	public Book findByBookName(String name){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bookName", "test");
		List<Book> list = bookDao.findByWhere("bookName=:bookName", paramMap, 0, 20);
		Book book = list.get(0);
		logger.info("test book,bookId="+book.getBookId()+",bookname="+book.getBookName()+",num="+book.getBookNumber());
		return book;
	}

	@Override
	public List<Book> queryBookSQL(String name) {
		BookCriteria criteria =new BookCriteria();
		criteria.setIndex(0);
		criteria.setRows(5);
		criteria.setName(name);
		List<Book> list = queryDao.queryForList("book.queryAll", criteria);
		for(Book book:list){
			logger.info("test book,bookId="+book.getBookId()+",bookname="+book.getBookName()+",num="+book.getBookNumber());
		}
		return list;
	}
}
