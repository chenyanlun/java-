package generator.mapper;

import generator.com.atguigu.pojo.TCustomer;

/**
* @author chenyanlun
* @description 针对表【t_customer】的数据库操作Mapper
* @createDate 2024-09-17 15:58:44
* @Entity generator.com.atguigu.pojo.TCustomer
*/
public interface TCustomerMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TCustomer record);

    int insertSelective(TCustomer record);

    TCustomer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCustomer record);

    int updateByPrimaryKey(TCustomer record);

}
