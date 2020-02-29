layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider','form'], function() {
    var laydate = layui.laydate //日期
        , laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , carousel = layui.carousel //轮播
        , upload = layui.upload //上传
        , element = layui.element //元素操作
        , slider = layui.slider //滑块
    //jquery $
    var $ = layui.jquery;

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        , height: 420
        , url: 'http://api.tianapi.com/txapi/rumour/index?key=72f9c9446efde8c044ca8f09397ee3e6' //数据接口
        , parseData: function (res) { //res 即为原始返回的数据
            return {
                "code":0, //解析接口状态
                 "msg": res.message, //解析提示文本
               // "count": res.total, //解析数据长度
                "data": res.newslist //解析数据列表
            }
        }
        , title: '用户表'
        , page: false //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: false //开启合计行
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'date', title: '时间', width: 200, align: "center"}
            , {field: 'title', title: '定义', width: 200, align: "center"}
            , {field: 'explain', title: '解释', width:80,align: "center"}
            , {field: 'desc', title: '描述', align: 'center'}
        ]]
    });


});