package generator.mapper;

import generator.com.atguigu.pojo.TOrder;

/**
* @author chenyanlun
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2024-09-17 15:58:44
* @Entity generator.com.atguigu.pojo.TOrder
*/
public interface TOrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);

}
