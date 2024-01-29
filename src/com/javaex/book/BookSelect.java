package com.javaex.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaex.author.AuthorVo;

public class BookSelect {

	public static void main(String[] args) {

		List<BookVo> BookList = new ArrayList<BookVo>();

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/book_db";
			conn = DriverManager.getConnection(url, "book", "book");

			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			String query = "";
			query += "select *";
			query += " from book ";

			// 바인딩
			pstmt = conn.prepareStatement(query);

			// 실행
			rs = pstmt.executeQuery();

			// 검색결과에서 데이터 꺼내기
			while (rs.next()) {

				int id = rs.getInt("book_id");
				String title = rs.getString("title");
				String pub = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				int no = rs.getInt("author_id");

				// Vo묶기
				BookVo BookVo = new BookVo(id, title, pub, pubDate, no);

				// 리스트에 추가
				BookList.add(BookVo);
			}

			// 4.결과처리
//			System.out.println(BookList.toString());

			// 리스트를 이용해서 출력
			for (int i = 0; i < BookList.size(); i++) {
				int id = BookList.get(i).getBookId();
				String title = BookList.get(i).getBookTitle();
				String pub = BookList.get(i).getBookPub();
				String pubDate = BookList.get(i).getBookPubDate();
				int no = BookList.get(i).getAuthorId();
				System.out.println(id + "." + title + pub + pubDate + no);

			}

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}
		}

	}

}
