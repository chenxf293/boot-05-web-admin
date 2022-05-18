package com.chen.boot05webadmin.service;

import com.chen.boot05webadmin.bean.KikuchuPage;
import com.chen.boot05webadmin.mapper.KikuchuPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KikuchuService {

    @Autowired
    KikuchuPageMapper kikuchuPageMapper;

    public KikuchuPage getKikuchuPageById(Integer id){
        return kikuchuPageMapper.getKiku(id);
    }
}
