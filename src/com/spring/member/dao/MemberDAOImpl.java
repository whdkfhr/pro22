package com.spring.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.member.vo.MemberVO;

// db���� �� �۾�
public class MemberDAOImpl implements MemberDAO{
	
	// JdbcTemplate ��ü�� ������ ����
	private JdbcTemplate jdbcTemplate;
	
	// action-dataSource.xml���� ȣ�� ���ϴ� �޼ҵ��.. <property>�±׸� ����ߴ�.
	// Ŀ�ؼ�Ǯ�� �Ű������� ���� �޾�... JdbcTemplate ��ü�� �����ڷ� ���� �� ����.
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// ��� ȸ������ ��ȸ
	@Override
	public List<MemberVO> selectAllMembers() throws DataAccessException {
		
		String query = "select id, pwd, name, email, joinDate from t_member order by joinDate desc";
		
		List<MemberVO> membersList = null;
		
		// JdbcTemplate Ŭ������ query() ȣ��� ���ڷ� query��, ������ ��ȸ�� ���ڵ��� ������ŭ MemberVO��ü�� ���� �� �����Ѵ�.
		// MemberVO��ü���� ArrayList�迭�� ���� �� ��ȯ��.
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
		
		// MemberServiceImpl ���� ��ȸ�� ȸ���������� ��ȯ
		return membersList;
	}

	// ȸ�� �߰�
	@Override
	public int addMember(MemberVO memberVO) throws DataAccessException {
		
		return 0;
	}
	
}
