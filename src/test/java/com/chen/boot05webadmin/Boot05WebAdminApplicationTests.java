package com.chen.boot05webadmin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class Boot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {

        Long along = jdbcTemplate.queryForObject("select count(*) from sample_db.kikuchu_page", Long.class);
        log.info("记录总数:{}",along);
        log.info("数据源类型：{}",dataSource.getClass());
    }

}
