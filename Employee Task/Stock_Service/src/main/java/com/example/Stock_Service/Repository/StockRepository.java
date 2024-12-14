package com.example.Stock_Service.Repository;

import com.example.Stock_Service.Entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class StockRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addStock(Stock stock) {

        String sql = "Insert into Stock(id,category,dress_name,price,quantity)Values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, stock.getId(), stock.getCategory(), stock.getDress_name(),stock.getPrice(), stock.getQuantity());

    }

    public List<Stock> getAllStock() {
        String sql = "SELECT id, category, dress_name, price, quantity FROM Stock";
        return jdbcTemplate.query(sql, new StockRowMapper());
    }

    private static class StockRowMapper implements RowMapper<Stock> {
        @Override
        public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
            Stock stock = new Stock();
            stock.setId(rs.getLong("id"));
            stock.setCategory(rs.getString("category"));
            stock.setDress_name(rs.getString("dress_name"));
            stock.setPrice(rs.getDouble("price"));
            stock.setQuantity(rs.getLong("quantity"));
            return stock;
        }
    }

    public List<Stock> getStockByCategory(String category) {
        String sql = "SELECT id, category, dress_name, price,quantity FROM Stock WHERE category LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + category + "%"}, new StockRowMapper());
    }
}
