package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.BranchBean;
import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class BranchModel {
	
	public int nextPk() throws SQLException {
		
		Connection c = null;
		int pk = 0;
		
		try {
			
			c = JDBCDataSource.getConnection();
			PreparedStatement pstmt =  c.prepareStatement("select max(id) from branches");
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pk = rs.getInt(1);
			}
			
		} catch (Exception e) {
     
			e.printStackTrace();
			
		} finally {
			JDBCDataSource.closeConnection(c);
		}
		
		return pk + 1; //return next auto - increment non-business primary key
	}

	public void add(BranchBean bean) throws SQLException {

		Connection conn = null;

		BranchBean existBean = findByBranchName(bean.getBranchName());
		
		int pk = 0;
		
		if (existBean != null) {
			throw new RuntimeException("branch already exist");
		}

		try {

			pk = nextPk();
			
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into branches values(?, ?, ?, ?, ?)");

			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getBranchName());
			pstmt.setString(3, bean.getCity());
			pstmt.setString(4, bean.getManagerName());
			pstmt.setString(5, bean.getContactNo());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public void update(BranchBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement(
					"update branches set branchName = ?, city = ?, managerName = ?, contactNo = ? where id = ?");

			pstmt.setString(1, bean.getBranchName());
			pstmt.setString(2, bean.getCity());
			pstmt.setString(3, bean.getManagerName());
			pstmt.setString(4, bean.getContactNo());
			pstmt.setInt(5, bean.getId());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void delete(int id) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from branches where id = ?");

			pstmt.setInt(1, id);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record delete successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public BranchBean findByPk(int id) throws Exception {

		Connection c = null;

		BranchBean bean = null;

		try {

			c = JDBCDataSource.getConnection();

			PreparedStatement pstmt = c.prepareStatement("select * from branches where id = ?");

			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new BranchBean();
				bean.setId(rs.getInt("id"));
				bean.setBranchName(rs.getString("branchName"));
				bean.setCity(rs.getString("city"));
				bean.setManagerName(rs.getString("managerName"));
				bean.setContactNo(rs.getString("contactNo"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			c.close();
		}

		return bean;
	}

	public BranchBean findByBranchName(String branchName) throws SQLException {

		Connection c = null;

		BranchBean bean = null;

		try {

			c = JDBCDataSource.getConnection();

			PreparedStatement pstmt = c.prepareStatement("select * from branches  where branchName = ?");

			pstmt.setString(1, branchName);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new BranchBean();
				bean.setId(rs.getInt("id"));
				bean.setBranchName(rs.getString("branchName"));
				bean.setCity(rs.getString("city"));
				bean.setManagerName(rs.getString("managerName"));
				bean.setContactNo(rs.getString("contactNo"));
				}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			c.close();
		}
		return bean;
	}


	public List<BranchBean> search(BranchBean bean, int pageNo, int pageSize) throws Exception {

		Connection c = null;

		List<BranchBean> list = new ArrayList<BranchBean>();

		try {

			// 1=1 sql injection
			StringBuffer sql = new StringBuffer("select * from branches where 1=1 "); // pagging bar bar change hogi
																						// easliye StringBuffer use kiya
																						// kyuki immutable hota he ye

			if (bean != null) {

				if (bean.getBranchName() != null && bean.getBranchName().length() > 0) {
					sql.append("and branchName like '" + bean.getBranchName() + "%' ");

				}

				if (bean.getCity() != null && bean.getCity().length() > 0) {
					sql.append("and ciy like '" + bean.getCity() + "%' ");

				}

				if (bean.getManagerName() != null && bean.getManagerName().length() > 0) {
					sql.append("and ManagerName like '" + bean.getManagerName() + "%' ");

				}
				if (bean.getContactNo() != null && bean.getContactNo().length() > 0) {
					sql.append("and contactNo like '" + bean.getContactNo() + "%' ");

				}

			}

			if (pageSize > 0) {

				int index = (pageNo - 1) * pageSize;
				sql.append("limit " + index + ", " + pageSize);

			}

			c = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = c.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new BranchBean();
				bean.setId(rs.getInt("id"));
				bean.setBranchName(rs.getString("branchName"));
				bean.setCity(rs.getString("city"));
				bean.setManagerName(rs.getString("managerName"));
				bean.setContactNo(rs.getString("contactNo"));
				list.add(bean);

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			c.close();
		}
		return list;
	}
	
}
