package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConn;
import model.Product;
import model.ProductType;

public class ProductRepository {
	private static final String TAG = "Repository : ";
	private static ProductRepository instance = new ProductRepository();

	private ProductRepository() {
	}

	public static ProductRepository getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public List<Product> findAll() {
		final String SQL = "SELECT ID, NAME, TYPE, PRICE, COUNT FROM PRODUCT ORDER BY ID ASC ";
		List<Product> products = null;
		try {
			conn = DbConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				products = new ArrayList<>();
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(ProductType.valueOf(rs.getString(3)))
						.price(rs.getInt(4))
						.count(rs.getInt(5)).build();

				products.add(product);

				while (rs.next()) {

					Product product1 = Product.builder()
							.id(rs.getInt(1))
							.name(rs.getString(2))
							.type(ProductType.valueOf(rs.getString(3)))
							.price(rs.getInt(4))
							.count(rs.getInt(5)).build();

					products.add(product1);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DbConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public int deleteById(int id) {

		final String SQL = "DELETE FROM product WHERE id = ?";

		List<Product> products = null;
		try {
			conn = DbConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();

			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById : " + e.getMessage());
		} finally {
			DbConn.close(conn, pstmt, rs);
		}
		return -1;
	}

	public List<Product> findAllPriceAsc() {
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY Price Asc";

		List<Product> products = null;
		try {
			conn = DbConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				products = new ArrayList<>();

				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(ProductType.valueOf(rs.getString(3)))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();

				products.add(product);

				while (rs.next()) {

					Product product1 = Product.builder()
							.id(rs.getInt(1))
							.name(rs.getString(2))
							.type(ProductType.valueOf(rs.getString(3)))
							.price(rs.getInt(4))
							.count(rs.getInt(5))
							.build();

					products.add(product1);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG + "PriceASC : " + e.getMessage());
		} finally {
			DbConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<Product> findAllCountDesc() {
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY count DESC";
		List<Product> products = null;
		try {
			conn = DbConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				products = new ArrayList<>();
				Product product = Product.builder().id(rs.getInt(1)).name(rs.getString(2))
						.type(ProductType.valueOf(rs.getString(3))).price(rs.getInt(4)).count(rs.getInt(5)).build();

				products.add(product);

				while (rs.next()) {

					Product product1 = Product.builder().id(rs.getInt(1)).name(rs.getString(2))
							.type(ProductType.valueOf(rs.getString(3))).price(rs.getInt(4)).count(rs.getInt(5)).build();

					products.add(product1);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG + "countDesc : " + e.getMessage());
		} finally {
			DbConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public List<Product> findAllPriceDesc() {
		final String SQL = "SELECT id, name, type, price, count FROM product ORDER BY Price DESC";


		List<Product> products = null;
		try {
			conn = DbConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				products = new ArrayList<>();
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(ProductType.valueOf(rs.getString(3)))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();

				products.add(product);

				while (rs.next()) {

					Product product1 = Product.builder().id(rs.getInt(1)).name(rs.getString(2))
							.type(ProductType.valueOf(rs.getString(3))).price(rs.getInt(4)).count(rs.getInt(5)).build();

					products.add(product1);
				}
			}
			return products;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(TAG + "pricedesc : " + e.getMessage());
		} finally {
			DbConn.close(conn, pstmt, rs);
		}
		return null;
	}
}