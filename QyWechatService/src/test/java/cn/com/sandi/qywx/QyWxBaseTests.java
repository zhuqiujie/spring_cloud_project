package cn.com.sandi.qywx;

import javax.annotation.Resource;

import cn.com.sandi.qywx.book.model.Book;
import cn.com.sandi.qywx.book.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.sandi.qywx.base.jpa.service.GenericService;
import cn.com.sandi.qywx.wxapp.model.Wxapp;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QyWxBaseTests {
    @Resource
	private BookService bookService;
    
    @Resource
    private GenericService<Wxapp,Long> wxappService;
    
	
    @Test
	public void contextLoads() {
	}
 
    @Test
	public void testInsertBook(){
	   Book book = new Book();
	   book.setBookName("test787");
	   book.setBookNumber(20);
	   bookService.insertBook(book);
	}
    
    @Test
    public void testInsertWxapp(){
    	Wxapp wxapp = new Wxapp("999", "appXXXXXXXXXXXXXXXXX", 20);
    	wxappService.save(wxapp);
    }
    
    @Test
    public void testGetByPk(){
    	bookService.getBookById(252151217386557440L);
    }
    
    
    @Test
    public void testFindByName(){
    	bookService.findByBookName("test");
    }
    
    @Test
    public void testUpdate(){
    	Book book = new Book(295257753226711040L, "test321", 49);
    	bookService.updateBook(book);
    }
    
    @Test
    public void testUpdateWxapp(){
    	Wxapp wxapp = new Wxapp("6666", "appXXXXXXXXXXXXXXXXX", 90);
    	wxapp.setId(306130051106213888L);
    	wxappService.update(wxapp);
    }
    
    @Test
    public void testQueryByMyBatisSql(){
    	bookService.queryBookSQL("test");
    }
    
    @Test
    public void testRemoveWxapp(){
    	wxappService.remove(306111117242011648L);
    }
    
}

