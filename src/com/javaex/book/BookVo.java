package com.javaex.book;

public class BookVo {

	private int bookId, authorId;
	private String bookTitle, bookPub, bookPubDate;

	public BookVo() {

	}

	public BookVo(int bookId, String bookTitle, String bookPub, String bookPubDate, int authorId) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookPub = bookPub;
		this.bookPubDate = bookPubDate;
		this.authorId = authorId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookPub() {
		return bookPub;
	}

	public void setBookPub(String bookPub) {
		this.bookPub = bookPub;
	}

	public String getBookPubDate() {
		return bookPubDate;
	}

	public void setBookPubDate(String bookPubDate) {
		this.bookPubDate = bookPubDate;
	}

	@Override
	public String toString() {
		return "BookVo [bookId=" + bookId + ", authorId=" + authorId + ", bookTitle=" + bookTitle + ", bookPub="
				+ bookPub + ", bookPubDate=" + bookPubDate + "]";
	}

}
