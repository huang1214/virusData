layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider','form'], function(){
    var laydate = layui.laydate //日期
        ,laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,table = layui.table //表格
        ,carousel = layui.carousel //轮播
        ,upload = layui.upload //上传
        ,element = layui.element //元素操作
        ,slider = layui.slider //滑块
    // 不用单独引入  jquery 了  jquery已经  封到layui.js里
    var $ = layui.jquery;

    table.render({
        elem: '#appTable'
        ,height: 520
        ,url: '/index/mask/app_query' //数据接口,
        ,parseData: function(res) { //res 即为原始返回的数据
            return {
                "code": res.status, //解析接口状态 要求是"0"
                "msg": res.message, //解析提示文本
                "count": res.total, //解析数据长度
                "data": res.item //解析数据列表
            };
        }
        ,title: '用户表'
        ,page: true //开启分页
        ,toolbar: '#bar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        ,totalRow: true //开启合计行
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'id', title: 'ID', width:70, sort: true,align:'center'}
            ,{field: 'shopname', title: '店铺名称', width:180}
            ,{field: 'appname', title: 'app', align:'center'}
            ,{field: 'masktype', title: '口罩类型', align:'center'}
            ,{field: 'buytype', title: '购买方式', align:'center'}
            ,{field: 'price', title: '多少大洋一个', align:'center'}
            ,{field: 'time', title: '蹲点时间', align:'center'}
            ,{field: 'notice', title: '过来人的经验', align:'center'}
            ,{field: 'coverPath', title: '购买界面',  align:'center', width:100,height:350,
                templet:function (e) {
                    return "<img src='../"+e.coverPath+"'style='width:150px;height:400px;'/>"
                }
            }
        ]]
    });
});