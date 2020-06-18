package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

// db접속 후 작업
public class MemberDAOImpl implements MemberDAO{
	
	// JdbcTemplate 객체를 저장할 변수
	private JdbcTemplate jdbcTemplate;
	
	// action-dataSource.xml에서 호출 당하는 메소드로.. <property>태그를 사용했다.
	// 커넥션풀을 매개변수로 전달 받아... JdbcTemplate 객체의 생성자로 전달 후 저장.
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// 모든 회원정보 조회
	@Override
	public List<MemberVO> selectAllMembers() throws DataAccessException {
		
		String query = "select id, pwd, name, email, joinDate from t_member order by joinDate desc";
		
		List<MemberVO> membersList = null;
		
		// JdbcTemplate 클래스의 query() 호출시 인자로 query와, 전달해 조회한 레코드의 갯수만큼 MemberVO객체를 생성 후 저장한다.
		// MemberVO객체들을 ArrayList배열에 저장 후 반환함.
		membersList = jdbcTemplate.query(query, new RowMapper<MemberVO>(){

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO memberVO = new MemberVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getDate("joinDate"));
				return memberVO;
			}
		});
		
		// MemberServiceImpl 에게 조회한 회원정보들을 반환
		return membersList;
	}

	// 회원 추가
	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		
		return 0;
	}
	
}
