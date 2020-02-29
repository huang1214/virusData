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
        ,url: '/virus/mask/query_result' //数据接口,
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
            ,{field: 'aid', title: 'ID', width:80, sort: true,align:'center'}
            ,{field: 'userId', title: '申请使用账号', width:80}
            ,{field: 'name', title: '申请人姓名', align:'center',edit:"text"}
            ,{field: 'province', title: '所在省', align:'center',edit:"text"}
            ,{field: 'city', title: '所在城市', align:'center'}
            ,{field: 'area', title: '所在地区', align:'center'}
            ,{field: 'street', title: '隶属街道', sort:true,edit:"text"}
            ,{field: 'storeId', title: '药店id',align:'center',edit:"text"}
            /*,{field: 'date', title: '创建时间',  sort: true, align:'center',edit:"text",
                templet:function (e) {
                    return showTime(e.createTime);
                }
            }*/
        ]]
    });
// 当点击搜索按钮时
    $("#submit_result").on("click",function(){
        //防止表单的默认事件提交
        event.preventDefault();
        // 搜索 表格重载函数
        console.log("要进行表格重载");
        table.reload('demo', {
            url:"/virus/mask/query_result", // 会把page 和limit（在页面的分页参数里） 加到路径后边
            where: { //设定异步数据接口的额外参数，任意设
                identity:$("#identity").val(),
                phone:$("#phone").val()
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据

    })

    /*//口罩预约信息的上传
    $("#submit_result").on("click",function () {

       /!* //防止表单的默认事件提交
        event.preventDefault();*!/

        var fd = $("#result")[0];
        //通过formdata抓取表单
        var formdata = new FormData(fd);

        //ajax与后台传值
        $.ajax({
            url:"/virus/mask/query_result",
            type:"post",
            data:formdata,
            dataType:'json',
            contentType:false,//防止jQuery对其操作
            processData:false,//当设置为true时，jQuery ajax不会序列化 直接使用data
            success:function (res) {
                console.log(res);
                parent.layer.alert(res.message,{icon:1},function () {

                });
            },
            error:function (res) {

            }

        })
    })*/


});