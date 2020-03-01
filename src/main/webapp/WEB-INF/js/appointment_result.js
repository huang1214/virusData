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

    table.render({
        elem: '#demo'
        ,height: 820
        ,url: '/index/mask/query_result' //数据接口,
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
            ,{field: 'aid', title: 'ID', width:180, sort: true,align:'center'}
            ,{field: 'userId', title: '申请使用账号', width:180}
            ,{field: 'name', title: '申请人姓名', align:'center'}
            ,{field: 'nums', title: '预约数量', sort:true}
            ,{field: 'phone', title: '联系电话', sort:true}
            ,{field: 'result', title: '预约结果',  sort: true, align:'center',
                templet:function (e) {
                    if(e.status==0){
                        return "预约失败;"
                    }
                    else{
                        return  "预约成功"
                    }
                }
            }
        ]]
    });
// 当点击搜索按钮时
    $("#submit_result").on("click",function(){
        //防止表单的默认事件提交
        event.preventDefault();
        // 搜索 表格重载函数
        console.log("要进行表格重载");
        table.reload('demo', {
            url:"/index/mask/query_result", // 会把page 和limit（在页面的分页参数里） 加到路径后边
            where: { //设定异步数据接口的额外参数，任意设
                identity:$("#identity").val(),
                phone:$("#phone").val()
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据

    })
});