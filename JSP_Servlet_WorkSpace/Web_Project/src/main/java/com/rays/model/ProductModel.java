package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.ProductBean;
import com.rays.util.JDBCDataSource;

public class ProductModel {

	public void create() throws Exception {

		Connection c = null;

		try {

			c = JDBCDataSource.getConnection();

			c.setAutoCommit(false);

			PreparedStatement pstmt = c.prepareStatement("create table product" + "(id bigInt primary key,"
					+ "productName varchar(45)," + "price double," + "quantity int," + "category varchar(45))");

			int i = pstmt.executeUpdate();

			c.commit();

			System.out.println("table created successfully: " + i);

		} catch (Exception e) {

			e.printStackTrace();
			c.rollback();
		} finally {
			c.close();
		}
	}

	public int nextPk() throws SQLException {

		Connection c = null;
		int pk = 0;

		try {

			c = JDBCDataSource.getConnection();
			PreparedStatement pstmt = c.prepareStatement("select max(id) from product");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pk = rs.getInt(1);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			JDBCDataSource.closeConnection(c);
		}

		return pk + 1; // return next auto - increment non-business primary key
	}

	public void add(ProductBean bean) throws SQLException {

		Connection c = null;

		int pk = 0;

		try {

			pk = nextPk();

			c = JDBCDataSource.getConnection();

			c.setAutoCommit(false);

			PreparedStatement p = c.prepareStatement("insert into product values(?, ?, ?, ?, ?)");

			p.setInt(1, pk);
			p.setString(2, bean.getProductName());
			p.setDouble(3, bean.getPrice());
			p.setInt(4, bean.getQuantity());
			p.setString(5, bean.getCategory());

			int i = p.executeUpdate();

			c.commit();

			System.out.println("recored inserted succesfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(c);

		} finally {
			JDBCDataSource.closeConnection(c);
		}
	}

	public void update(ProductBean bean) throws Exception {

		Connection c = null;

		try {

			c = JDBCDataSource.getConnection();

			c.setAutoCommit(false);

			PreparedStatement p = c.prepareStatement(
					"update product set productName = ?, price = ?, quantity = ?, category = ? where id = ?");

			p.setString(1, bean.getProductName());
			p.setDouble(2, bean.getPrice());
			p.setInt(3, bean.getQuantity());
			p.setString(4, bean.getCategory());
			p.setLong(5, bean.getProductId());

			int i = p.executeUpdate();

			c.commit();

			System.out.println("record successfully updated: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			c.rollback();
		} finally {
			c.close();
		}
	}

	public void search() throws Exception {

		Connection c = null;

		try {

			c = JDBCDataSource.getConnection();

			c.setAutoCommit(false);

			PreparedStatement p = c.prepareStatement("select * from product");

			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getLong("productId"));
				System.out.println(rs.getString("productName"));
				System.out.println(rs.getDouble("price"));
				System.out.println(rs.getInt("quantity"));
				System.out.println(rs.getString("category"));

				System.out.println("--------------------------");

			}

			c.commit();

		} catch (Exception e) {

			e.printStackTrace();
			c.rollback();
		} finally {
			c.close();
		}
	}

	public void delete(ProductBean bean) throws Exception {

		Connection c = null;

		try {

			c = JDBCDataSource.getConnection();

			c.setAutoCommit(false);

			PreparedStatement p = c.prepareStatement("delete from product where id = ?");

			p.setLong(1, bean.getProductId());

			int i = p.executeUpdate();

			c.commit();

			System.out.println("record deleted succesfully: " + i);

		} catch (Exception e) {

			e.printStackTrace();
			c.rollback();

		} finally {

			c.close();
		}

	}

	public ProductBean findByPk(long productId) throws Exception {

		Connection c = null;
		ProductBean bean = null;

		try {

			c = JDBCDataSource.getConnection();

			c.setAutoCommit(false);

			PreparedStatement p = c.prepareStatement("select * from product where id = ?");

			p.setLong(1, productId);

			ResultSet rs = p.executeQuery();

			while (rs.next()) {
				bean = new ProductBean();
				bean.setProductId(rs.getLong("id"));
				bean.setProductName(rs.getString("productName"));
				bean.setPrice(rs.getDouble("price"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setCategory(rs.getString("category"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			c.rollback();

		} finally {

			c.close();
		}

		return bean;
	}

	public List<ProductBean> search(ProductBean bean, int pageNo, int pageSize) throws Exception {

		Connection c = null;

		List<ProductBean> list = new ArrayList<ProductBean>();

		try {

			StringBuffer sql = new StringBuffer("select * from product where 1=1 ");

			if (bean != null) {

				if (bean.getProductName() != null && bean.getProductName().length() > 0) {
					sql.append("and ProductName like '" + bean.getProductName() + "%' ");

				}

				if (bean.getPrice() != 0) {
					sql.append("and price like '" + bean.getPrice() + "%' ");
				}

				if (bean.getQuantity() != 0 && bean.getCategory().length() > 0) {
					sql.append("and quantity like '" + bean.getCategory() + "%' ");
				}

				if (bean.getCategory() != null && bean.getCategory().length() > 0) {
					sql.append("and category like '%" + bean.getCategory() + "%' ");
				}
			}

			if (pageSize > 0) {

				int index = (pageNo - 1) * pageSize;
				sql.append("limit " + index + "," + pageSize);

			}

			c = JDBCDataSource.getConnection();

			System.out.println("sql search query ====> " + sql.toString());

			PreparedStatement pstmt = c.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new ProductBean();
				bean.setProductId(rs.getLong("id"));
				bean.setProductName(rs.getString("productName"));
				bean.setPrice(rs.getDouble("price"));
				bean.setQuantity(rs.getInt("quantity"));
				bean.setCategory(rs.getString("category"));
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
