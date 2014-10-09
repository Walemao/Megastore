package com.walemao.megastore.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.walemao.megastore.domain.ProductImage;
import com.walemao.megastore.domain.mapper.ProductImageMapper;
import com.walemao.megastore.repository.ProductImageDao;
import com.walemao.megastore.util.ToolUtil;

@Repository
public class ProductImageDaoImpl extends CommonDaoImpl implements
		ProductImageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(ProductImage pi) {
		// TODO Auto-generated method stub
		String sql = "insert into t_product_images(pi_src,pi_md5,pi_sort) values(?,?,?)";
		return this.addIntoDB(sql,
				new Object[] { pi.getPicSrc(), pi.getPicMd5(), pi.getSort() });
	}

	@Override
	public void update(int productId, int[] ids) {
		// TODO Auto-generated method stub
		if (ids.length > 0) {
			String sql = "update t_product_images set pi_productid=? where pi_id in "
					+ ToolUtil.IntDataToString(ids);
			this.jdbcTemplate.update(sql, new Object[] { productId });
		}
	}

	@Override
	public List<ProductImage> getProductImages(int productId) {
		// TODO Auto-generated method stub
		String sql = "select pi_id,pi_src,pi_md5,pi_sort,pi_productid from t_product_images where pi_productid=? order by pi_sort";
		return this.jdbcTemplate.query(sql, new Object[] { productId },
				new ProductImageMapper());
	}

}