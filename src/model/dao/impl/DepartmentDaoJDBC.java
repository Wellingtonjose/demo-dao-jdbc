package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	private Connection conn;
	public DepartmentDaoJDBC(Connection connection) {
		this.conn = connection;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO department "
					+ "(Name) "
					+ "VALUES (?) ", Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNome());
			int rows = st.executeUpdate();
			if(rows > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
				int id = rs.getInt(1);
				obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			
		} catch (SQLException e) {
			throw new DbException("Unexpected erro! No rows affected! ");
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE department"
					+ " SET Name = ? "
					+ "WHERE Id = ?");
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getId());
			st.executeUpdate();
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department"
					+ " WHERE Id = ?  ");
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setNome(rs.getString("Name"));
				return dep;
			}
			return null;
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		st = conn.prepareStatement("SELECT * FROM department");
		
		rs = st.executeQuery();
		List<Department> lis = new ArrayList<>();
		Map<Integer,Department> map = new HashMap<>();
		while (rs.next()) {
			Department dep = map.get(rs.getInt("Id"));
			if(dep == null) {
				dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setNome(rs.getString("Name"));
				map.put(rs.getInt("Id"), dep);
			}
			lis.add(dep);
			
		}
		return lis;
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}
