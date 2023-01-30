package com.baidu.mybatisplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.baidu.mybatisplus.pojo.TProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author dongyangwei
* @description 针对表【t_product】的数据库操作Mapper
* @createDate 2022-10-06 00:01:39
* @Entity generator.domain.TProduct
*/
public interface TProductMapper extends BaseMapper<TProduct> {
    int insertBatch(@Param("tProductCollection") Collection<TProduct> tProductCollection);

    List<TProduct> selectAllByIdAfterAndId(@Param("id") Long id, @Param("oldId") Long oldId);

    int updateIdAndName(@Param("id") Long id, @Param("name") String name);
}




