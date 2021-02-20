package com.example.freemarkerdemo.controller;

import com.example.freemarkerdemo.entity.GoodsInfo;
import com.example.freemarkerdemo.entity.PayedOrder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {
    @Autowired
    private Configuration configuration;

    @RequestMapping(value = "/freemarker/demo")
    public String demo() {
        try {
            Template template = configuration.getTemplate("demo.ftl");
            /** 已支付订单 */
            // 1
            PayedOrder payedOrder1 = new PayedOrder();
            payedOrder1.setNo(1);
            payedOrder1.setOrderNo("1688888");
            payedOrder1.setCreateTime("2021-01-07 14:42:58");
            payedOrder1.setOrderSource("生态商城");
            payedOrder1.setCustName("北京好数科技有限公司");
            payedOrder1.setCustNo("72398981");
            payedOrder1.setProvince("海南");
            payedOrder1.setPlatform("PBOSS");

            /*GoodsInfo goodsInfo1 = new GoodsInfo();
            goodsInfo1.setGoodsName("位置定位（B类）");
            goodsInfo1.setPackageName("5000元服务包");
            goodsInfo1.setOrderCount("2");*/
            payedOrder1.setGoodsName("位置定位（B类）");
            payedOrder1.setPackageName("5000元服务包");
            payedOrder1.setOrderCount("2");
            GoodsInfo goodsInfo2 = new GoodsInfo();
            goodsInfo2.setGoodsName("位置定位（A类）");
            goodsInfo2.setPackageName("20000元服务包");
            goodsInfo2.setOrderCount("1");
            List<GoodsInfo> goodsInfoList = new ArrayList<>();
            //goodsInfoList.add(goodsInfo1);
            goodsInfoList.add(goodsInfo2);
            payedOrder1.setGoodsInfoList(goodsInfoList);
            payedOrder1.setGoodsInfoSize(String.valueOf(goodsInfoList.size()+1));
            payedOrder1.setOrderBill("30000");

            payedOrder1.setPayStatus("已支付");
            payedOrder1.setPayTime("2021-01-07 14:42:58");

            // 2
            PayedOrder payedOrder2 = new PayedOrder();
            payedOrder2.setNo(2);
            payedOrder2.setOrderNo("7768899");
            payedOrder2.setCreateTime("2021-01-07 14:42:58");
            payedOrder2.setOrderSource("能开平台");
            payedOrder2.setCustName("深圳好数科技有限公司");
            payedOrder2.setCustNo("8723801768");
            payedOrder2.setProvince("山东");
            payedOrder2.setPlatform("CMIOT");

            payedOrder2.setGoodsName("位置定位（B类）");
            payedOrder2.setPackageName("5000元服务包");
            payedOrder2.setOrderCount("1");
            List<GoodsInfo> goodsInfoList2 = new ArrayList<>();
            payedOrder2.setGoodsInfoList(goodsInfoList2);
            payedOrder2.setGoodsInfoSize(String.valueOf(goodsInfoList2.size()+1));
            payedOrder2.setOrderBill("5000");

            payedOrder2.setPayStatus("已支付");
            payedOrder2.setPayTime("2021-01-07 14:42:58");

            List<PayedOrder> payedOrderList = new ArrayList<>();
            payedOrderList.add(payedOrder1);
            payedOrderList.add(payedOrder2);

            /** 未支付订单*/
            PayedOrder unPayedOrder = new PayedOrder();
            unPayedOrder.setNo(1);
            unPayedOrder.setOrderNo("1688888");
            unPayedOrder.setCreateTime("2021-01-08 14:42:58");
            unPayedOrder.setOrderSource("能开平台");
            unPayedOrder.setCustName("北京好数科技有限公司");
            unPayedOrder.setCustNo("89398981777688888");
            unPayedOrder.setProvince("重庆");
            unPayedOrder.setPlatform("CMIOT");

            unPayedOrder.setGoodsName("位置定位（B类）");
            unPayedOrder.setPackageName("5000元服务包");
            unPayedOrder.setOrderCount("2");
            GoodsInfo unPayedgoodsInfo = new GoodsInfo();
            unPayedgoodsInfo.setGoodsName("位置定位（A类）");
            unPayedgoodsInfo.setPackageName("20000元服务包");
            unPayedgoodsInfo.setOrderCount("1");
            List<GoodsInfo> unPayedGoodsInfoList = new ArrayList<>();
            unPayedGoodsInfoList.add(unPayedgoodsInfo);
            unPayedOrder.setGoodsInfoList(unPayedGoodsInfoList);
            unPayedOrder.setGoodsInfoSize(String.valueOf(unPayedGoodsInfoList.size()+1));

            unPayedOrder.setOrderBill("30000");
            unPayedOrder.setPayStatus("未支付");

            List<PayedOrder> unPayedOrderList = new ArrayList<>();
            unPayedOrderList.add(unPayedOrder);

            Map<String, Object> map = new HashMap<>();
            map.put("orderTotal", 2);
            map.put("orderContent", "已支付订单2张，未支付订单1张");
            map.put("payedOrderList", payedOrderList);
            map.put("unPayedOrderList", unPayedOrderList);

            template.process(map, new FileWriter(new File("F:\\testFreeMarker.html"), false));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "end";
    }
}
