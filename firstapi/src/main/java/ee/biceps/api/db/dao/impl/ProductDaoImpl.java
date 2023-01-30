package ee.biceps.api.db.dao.impl;

import ee.biceps.api.db.DbUtil;
import ee.biceps.api.db.dao.ProductDao;
import ee.biceps.api.db.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private Connection connection;

    public ProductDaoImpl() {
        this.connection = DbUtil.getConnection();
    }

    public ProductDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Product selectProductById(Long id) {
        Product product = Product.builder().build();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id=?");
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                setProduct(product, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public Product selectProductByName(String name) {
        Product product = Product.builder().build();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name=?");
            preparedStatement.setString(1, name);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                setProduct(product, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> selectProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from product");
            while (rs.next()) {
                Product product = Product.builder().build();
                setProduct(product, rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> selectProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from product where category=?");
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product product = Product.builder().build();
                setProduct(product, rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Long createProduct(Product product) {
        Long createdId = null;
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into product(" + COLUMN_NAMES_NO_ID + ") values (?, ?, ?, ?, ?, ?, ?)");
            // Parameters start with 1
            setPreparedStatement(product, ps);
            ps.executeUpdate();
            connection.commit();

            ResultSet id = ps.getGeneratedKeys();
            if (id.next()) {
                createdId = id.getLong(1);
            }
            ps.close();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return createdId;
    }

    public int createProducts(List<Product> products) {
        int addedProducts = 0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into product(" + COLUMN_NAMES_NO_ID + ") values (?, ?, ?, ?, ?, ?, ?)");
            for (Product product : products) {
                setPreparedStatement(product, ps);
                ps.addBatch();
            }
            addedProducts = Arrays.stream(ps.executeBatch()).sum();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addedProducts;
    }

    @Override
    public boolean updateProductById(Long id, Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement("update product" + " set name=?, description=?, price=?, unit=?, available_amount=?, category=?, image_path=?" + " where id=?");
            // Parameters start with 1
            setPreparedStatement(product, ps);
            ps.setLong(8, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateProductByName(String name, Product product) {
        try {
            PreparedStatement ps = connection.prepareStatement("update product" + " set name=?, description=?, price=?, unit=?, available_amount=?, category=?, image_path=?" + " where name=?");
            // Parameters start with 1
            setPreparedStatement(product, ps);
            ps.setString(8, name);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProductById(Long id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from product where id=?");
            ps.setLong(1, id);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProductByName(String name) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from product where name=?");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    private void setProduct(Product product, ResultSet rs) throws SQLException {
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getInt("price"));
        product.setUnit(rs.getString("unit"));
        product.setAvailableAmount(rs.getInt("available_amount"));
        product.setCategory(rs.getString("category"));
        product.setImagePath(rs.getString("image_path"));
    }

    private void setPreparedStatement(Product product, PreparedStatement ps) {
        try {
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            if (product.getPrice() == null) {
                ps.setNull(3, Types.INTEGER);
            } else {
                ps.setInt(3, product.getPrice());
            }
            ps.setString(4, product.getUnit());
            if (product.getAvailableAmount() == null) {
                ps.setNull(5, Types.INTEGER);
            } else {
                ps.setInt(5, product.getAvailableAmount());
            }
            ps.setString(6, product.getCategory());
            ps.setString(7, product.getImagePath());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to set prepared statement from product", e);
        }
    }

}
