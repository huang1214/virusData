
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
    var ajax=layui.ajax;

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        , height: 420
        , url: 'http://www.dzyong.top:3005/yiqing/news?pageSize=10' //数据接口
        , parseData: function (res) { //res 即为原始返回的数据
            $.ajax({
                type:"post",
                data:JSON.stringify(res),
                url:"/virusData/news/getNews",
                dataType:"json",
                async: false,
                cache: false,
                processData: false,
                contentType: false,
                success:function (res) {

                }
            })
            return {
                "code": 0, //解析接口状态
                "msg": res.message, //解析提示文本
                "count":100, //解析数据长度
                "data": res.data //解析数据列表
            }
        }
        , title: '用户表'
        , page: true //开启分页
        , toolbar: '#bar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: true //开启合计行
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: 'ID', width: 80, sort: true, align: "center"}
            , {field: 'pubDate', title: '发布时间', width: 200}
            , {field: 'title', title: '标题', align: "center",edit:"text"}
            , {field: 'summary', title: '内容', align: 'center',edit:"text"}
        ]]
    });

    //监听单元格编辑
    table.on('edit(newsTable)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
        console.log(obj.value); //得到修改后的值
        console.log(obj.field); //当前编辑的字段名
        console.log(obj.data); //所在行的所有相关数据

        $.ajax({
            type:"post",
            url:"/virusData/news/update",
            data:{
                "id":obj.data.id,
                "field":obj.field,
                "value":obj.value
            },
            dataType:"json",
            success:function (res) {
                //弹出消息
                layer.msg(res.message);
            }

        })
    });

    //监听头工具栏事件
    table.on('toolbar(newsTable)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        // 用来群删除的数组
        var ids=[];
        for(var i=0;i<data.length;i++) {
            ids[i] = data[i].id;
        }
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                //打开视频添加窗口 弹出一个层
                layer.open({
                    type:2,
                    title:"添加视频",//iframe 框架窗口
                    shade:0.8, //窗口外部阴影配置
                    shadeClose:true,
                    area:['60%','60%'],
                    content:"/virusData/templates/add_news.html"
                })
                break;
            case 'update':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else if(data.length > 1){
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：'+ checkStatus.data[0].id);
                }
                break;
            case 'del':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                    $.ajax({
                        type:"post",
                        url:"/virusData/news/delete",
                        data:{
                            "ids":ids
                        },
                        dataType:"json",
                        traditional:true,
                        success:function (res) {
                            var message=res.message;
                            var code = res.status;
                            if(code=="200"){
                                layer.alert(message,{icon:1},function (index) {

                                    layer.close(index);

                                    tableIns.reload();
                                })
                            }
                        }
                    })
                }
                break;
        };
    });




    $("#submit").on("click",function () {
        //获取表单的原生对象 指的是javascript 节点对象
        var fd1 =document.getElementById("form");
       // var fd2 = $("#form")[0];

        var formdata=new FormData(fd1);


        //video_url
        //获取input 视频文件名

     //   var zhi = document.getElementById("video_url").value;
      //  formdata.append("videoPath",zhi);


        // ajax 与后台传值
        $.ajax({
            url:"/virusData/news/add",
            type:"post",
            data:formdata,
            dataType:'json',
            async: false,
            cache: false,
            processData: false,
            contentType: false,
            success:function(res){
                parent.layer.alert(res.message,{icon:1},function(){
                    window.parent.location.reload();
                });
            },
            error:function(res){

            }
        })
    })

    //点击搜索按钮时 会进行表格的重载
    $("#re").on("click",function () {
        //表格重载函数 搜索

        table.reload('demo', {
            url:"/virusData/news/query" ,//会把page和limit （在页面的分页参数里）加到路径后面
            where: { //设定异步数据接口的额外参数，任意设
                title: $("#titleLike").val()

            }
            , parseData: function (res) { //res 即为原始返回的数据
                return {
                    "code": 0, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count":100, //解析数据长度
                    "data": res.item //解析数据列表
                }
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据

    })
})