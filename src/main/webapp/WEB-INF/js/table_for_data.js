layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider','form'], function() {
    var laydate = layui.laydate //日期
        , laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , carousel = layui.carousel //轮播
        , upload = layui.upload //上传
        , element = layui.element //元素操作
        , slider = layui.slider //滑块
    // 不用单独引入  jquery 了  jquery已经  封到layui.js里
    var $ = layui.jquery;

    //向世界问个好
    //layer.msg('Hello World');
    //执行一个 table 实例
    var tableIns = table.render({
        elem: '#demo'
        , height: 420
        , url: '../data/sum' //数据接口,
        , parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": res.status, //解析接口状态 要求是"0"
                "msg": res.message, //解析提示文本
                "count": res.total, //解析数据长度
                "data": res.item //解析数据列表
            };
        }
        , title: '各省数据情况'
        , page: true //开启分页
        , toolbar: '#bar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: true //开启合计行
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'provincename', title: '省份', align: 'center'}
            , {field: 'provinceConfirmedcount', title: '确诊病例', align: 'center',sort: true, edit: "text"}
            , {field: 'provinceSuspectedcount', title: '疑似病例', align: 'center',sort: true, edit: "text"}
            , {field: 'provinceCuredcount', title: '治愈人数', align: 'center', sort: true,edit: "text"}
            , {field: 'provinceDeadcount', title: '死亡人数', align: 'center',sort: true, edit: "text"}
            , {
                field: 'provinceZipcode', title: '详情', align: 'center',
                templet: function (e) {
                    var provinceZipCode = e.province_zipCode;
                    return "<button class='layui-btn layui-btn-normal' onclick='details(provinceZipCode)'>查看详情</button>"
                }
            }

        ]]
    });

});