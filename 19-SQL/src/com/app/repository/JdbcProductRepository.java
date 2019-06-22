package com.app.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.app.db.SQLConnectionFactory;
import com.app.model.Product;
import com.app.model.ProductType;

public class JdbcProductRepository implements ProductRepository {

	@Override
	public void save(Product product) {
		Connection connection=null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "insert into PRODUCTS(id,name,price,product_type) values(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setLong(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getType().name());

			int count = ps.executeUpdate();
			if (count == 1)
				System.out.println("New record inserted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public Optional<Product> findById(int id) {
		Connection connection=null;
		Product product = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "select * from products where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			 
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setType(ProductType.valueOf(rs.getString("product_type")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return Optional.ofNullable(product);
		
	}

	@Override
	public void delete(int id) {
		
		Connection connection=null;
		Product product = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "delete from products where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			 
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			if(count==1)
				System.out.println("Record deleted");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public void update(int id, double price) {
		
		Connection connection=null;
		Product product = null;
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "update products set price=? where id=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			 
			ps.setDouble(1, price);
			ps.setInt(2, id);
			
			int count = ps.executeUpdate();
			if(count==1)
				System.out.println("Record updated");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public List<Product> findAl() {
		
		Connection connection=null;
		List<Product> products = new ArrayList<>();		List<Product> list = new ArrayList<Product>();
		try {
			connection = SQLConnectionFactory.getConnection();

			String sql = "select * from products";
			PreparedStatement ps = connection.prepareStatement(sql);
			 
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getDouble("price"));
				product.setType(ProductType.valueOf(rs.getString("product_type")));
				list.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	
}