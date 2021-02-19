各位领导、同事：
本周完成订单${orderTotal}张，其中${orderContent}。明细如下：
<#list payedOrderList>
【已支付订单】
<table>
    <tr>
        <td></td>
        <td colspan="3">订单信息</td>
        <td colspan="4">客户信息</td>
        <td colspan="4">商品信息</td>
        <td colspan="2">支付信息</td>
    </tr>
    <tr>
        <td>序号</td>
        <td>订单编号</td>
        <td>创建时间</td>
        <td>订购渠道</td>
        <td>客户名称</td>
        <td>客户编号</td>
        <td>归属省份</td>
        <td>所属平台</td>
        <td>商品名称</td>
        <td>资费包名称</td>
        <td>订购数量</td>
        <td>订单金额</td>
        <td>支付状态</td>
        <td>支付时间</td>
    </tr>
    <#items as payedOrder>
        <tr aria-rowspan="${goodsSize}">

        </tr>
    </#items>
</table>
</#list>