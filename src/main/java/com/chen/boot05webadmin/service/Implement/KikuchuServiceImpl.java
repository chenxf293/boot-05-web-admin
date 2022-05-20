package com.chen.boot05webadmin.service.Implement;

import com.chen.boot05webadmin.bean.KikuchuPage;
import com.chen.boot05webadmin.mapper.KikuchuPageMapper;
import com.chen.boot05webadmin.service.KikuchuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KikuchuServiceImpl implements KikuchuService {

    @Autowired
    KikuchuPageMapper kikuchuPageMapper;

    public KikuchuPage getKikuchuPageById(Integer id){
        return kikuchuPageMapper.getKiku(id);
    }
}
