package com.chen.boot05webadmin.mapper;

import com.chen.boot05webadmin.bean.KikuchuPage;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KikuchuPageMapper {

    public KikuchuPage getKiku(Integer id);
}
