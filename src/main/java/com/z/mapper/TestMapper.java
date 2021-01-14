package com.z.mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TestMapper {

    @Select("select * from account")
    List<Map<String,Object>> getAllByAnnotations();

    List<Map<String,Object>> getAllByXml();

}
