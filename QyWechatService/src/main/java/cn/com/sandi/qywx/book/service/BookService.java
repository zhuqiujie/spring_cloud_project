package cn.com.sandi.qywx.book.service;

import cn.com.sandi.qywx.book.model.Book;

import java.util.List;


public interface BookService {
    public void insertBook(Book book);
    public void updateBook(Book book);
    
    public Book getBookById(Long id);
    public Book findByBookName(String name);
    
    public List<Book> queryBookSQL(String name);
}
