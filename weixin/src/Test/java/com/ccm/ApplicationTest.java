package com.ccm;

import com.ccm.dto.DetailInfoDTO;
import com.ccm.bean.ComputersDetail;
import com.ccm.bean.SwiperInfo;
import com.ccm.service.SwiperService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Resource
    private SwiperService swiperService;

    @Test
    public void testClass(){
        ComputersDetail computersDetail = new ComputersDetail();
        computersDetail.setPrice("$123");
        computersDetail.setGoodsDescribe("哇哈哈");
        SwiperInfo swiperInfo = new SwiperInfo();
        swiperInfo.setFirUrl("/123");
        swiperInfo.setSecUrl("/456");
        DetailInfoDTO detailInfoDTO = swiperService.alterDetailInfo(computersDetail, swiperInfo);
        System.out.println(detailInfoDTO);
    }
}
