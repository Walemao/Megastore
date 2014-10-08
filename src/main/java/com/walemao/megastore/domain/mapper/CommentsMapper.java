package com.walemao.megastore.domain.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.walemao.megastore.domain.Comments;
import com.walemao.megastore.domain.OrderDetail;
import com.walemao.megastore.domain.ProductInfo;

public class CommentsMapper implements RowMapper<Comments> {

	@Override
	public Comments mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Comments c = new Comments();
		c.setId(rs.getInt("c_id"));
		c.setUsername(rs.getString("c_username"));
		c.setContent(rs.getString("c_content"));
		c.setType(rs.getInt("c_type"));
		
		OrderDetail orderdetail = new OrderDetail();
		ProductInfo producttype = new ProductInfo();
		producttype.setName(rs.getString("pd_name"));
		orderdetail.setProducttype(producttype);
		c.setOrderdetail(orderdetail);
		
		c.setCreatetime(rs.getDate("c_createtime"));
		return c;
	}

}
