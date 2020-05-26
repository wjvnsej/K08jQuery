package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ZipcodeDAO {

	//멤버변수 (클래스 전체 멤버메소드에서 접근가능)
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	
	public ZipcodeDAO() {
		try {
			Context initctx = new InitialContext();
			DataSource source = 
					(DataSource)initctx.lookup("java:comp/env/jdbc/myoracle");
			
			con = source.getConnection();
		}
		catch (Exception e) {
			System.out.println("DBCP 연결실패");
			e.printStackTrace();
		}
	}
	
	//DB자원해제 : DB연결 자체를 끊는것이 아니라 커넥션풀에 커넥션객체를 반납하는 것
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
		} 
		catch (Exception e) {
			System.out.println("자원반납시 예외발생");
			e.printStackTrace();
		}
	}
	
	//우편번호 테이블에서 시/도 가져오기
	public ArrayList<String> getSido() {
		
		ArrayList<String> sidoAddr = new ArrayList<String>();
		
		String sql = "SELECT sido FROM zipcode "
				+ "	WHERE 1=1"
				+ "	GROUP BY sido"
				+ "	ORDER BY sido ASC";
		
		try {
			
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				sidoAddr.add(rs.getString(1));
			}
		} 
		catch (Exception e) {}
		
		return sidoAddr;
	}
	
	//우편번호 테이블에서 각 시/도에 해당하는 구/군 가져오기
	public ArrayList<String> getGugun(String sido) {
		
		ArrayList<String> gugunAddr = new ArrayList<String>();
		
		String sql = "SELECT DISTINCT gugun FROM zipcode "
				+ "	WHERE sido = ? "
				+ "	ORDER BY gugun DESC ";
		
		try {
			
			psmt = con.prepareStatement(sql);
			psmt.setString(1, sido);
			rs = psmt.executeQuery();
			while(rs.next()) {
				gugunAddr.add(rs.getString(1));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return gugunAddr;
	}
	
}

























