package com.example.freemarkerdemo.controller;

import com.example.freemarkerdemo.entity.GoodsInfo;
import com.example.freemarkerdemo.entity.Order;
import com.example.freemarkerdemo.entity.PayedOrder;
import com.sun.org.apache.xpath.internal.operations.Or;
import freemarker.cache.StringTemplateLoader;
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

    @RequestMapping(value = "/freemarker/demo1")
    public String demo1() {
        try {
            StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
            stringTemplateLoader.putTemplate("demo1", "<!DOCTYPE html> <html lang=\"en\"> <head> <style type=\"text/css\"> table { border-collapse:collapse; }  table, td, th { border:1px solid black; } </style> </head> <body> <div style=\"width: 800px; margin: 0 auto;\">   <h3>新增订单提示</h3> <p>中国移动物联卡能力开放平台（<a style=\"color: #1875f0;\" href=\"https://api.iot.10086.cn\">https://api.iot.10086.cn</a>）收到${custName}的订单，共${goodsNum}个商品，总金额为${totalPrice}元，列表如下:</p> <table> <tbody> <tr> <th>商品名称</th> <th>数量</th> <th>资费包名称</th> <th>订单编号</th> <th>创建时间</th> </tr> <#list orderList as order> <tr> <td>${order.goodsName}</td> <td>${order.num}</td> <td>${order.packageName}</td> <td>${order.orderPkgNum}</td> <td>${order.createTime}</td> </tr> </#list>            </tbody> </table> <br/> <br/> <p>创建时间:${createTime}</p> <p>付款时间:${paymentTime}</p> <p style=\"text-align: right;\">${postTime}</p> </div> </body> </html>");

            configuration.setTemplateLoader(stringTemplateLoader);

            Template template = configuration.getTemplate("demo1");

            Map<String, Object> map = new HashMap<>();
            map.put("custName", "中移物联网");
            map.put("goodsNum", "1");
            map.put("totalPrice", "10000");

            List<Order> list = new ArrayList<>();
            Order order = new Order();
            order.setGoodsName("111");
            order.setCreateTime("111");
            order.setNum("111");
            order.setOrderPkgNum("111");
            order.setPackageName("111");
            list.add(order);
            Order order1 = new Order();
            order1.setGoodsName("111");
            order1.setCreateTime("111");
            order1.setNum("111");
            order1.setOrderPkgNum("111");
            order1.setPackageName("111");
            list.add(order1);

            map.put("orderList", list);
            map.put("createTime", "2021-03-02 22:15:00");
            map.put("paymentTime", "2021-03-02 22:15:00");
            map.put("postTime", "2021-03-02 22:15:00");

            template.process(map, new FileWriter(new File("E:\\testFreeMarker1.html"), false));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "end";
    }
}
