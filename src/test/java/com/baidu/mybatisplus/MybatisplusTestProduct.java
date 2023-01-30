package com.baidu.mybatisplus;

import com.baidu.mybatisplus.mapper.ProductMapper;
import com.baidu.mybatisplus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MybatisplusTestProduct {
    @Autowired
    private ProductMapper productMapper;

    @Test
    public void testProduct(){
        Product productLi = productMapper.selectById(1);
        System.out.println(productLi.getPrice());

        Product productWang = productMapper.selectById(1);
        System.out.println(productWang.getPrice());

        productLi.setPrice(productLi.getPrice()+50);
        productMapper.updateById(productLi);


        productWang.setPrice(productWang.getPrice()-30);
        int result = productMapper.updateById(productWang);
        if (result == 0){
            Product productNew = productMapper.selectById(1);
            productNew.setPrice(productLi.getPrice()-30);
            productMapper.updateById(productNew);
        }

        System.out.println(productMapper.selectById(1).getPrice());


    }
}
