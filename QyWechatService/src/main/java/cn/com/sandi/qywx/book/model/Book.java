package cn.com.sandi.qywx.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="book")
public class Book {
	@Id
	@Column(name="book_id")
	private long bookId;// 图书ID

	@Column(name="bookName")
    private String bookName;// 图书名称

	@Column(name="bookNumber")
    private int bookNumber;// 馆藏数量

	public Book(){}

	public Book(long bookId, String bookName, int bookNumber) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookNumber = bookNumber;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
    
}
