package com.baidu.mybatisplus.service.impl;

import com.baidu.mybatisplus.service.TProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baidu.mybatisplus.pojo.TProduct;
import com.baidu.mybatisplus.mapper.TProductMapper;
import org.springframework.stereotype.Service;

/**
* @author dongyangwei
* @description 针对表【t_product】的数据库操作Service实现
* @createDate 2022-10-06 00:01:39
*/
@Service
public class TProductServiceImpl extends ServiceImpl<TProductMapper, TProduct>
    implements TProductService {

}




