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

    //向世界问个好
    layer.msg('城市数据');

    //执行一个 table 实例
    var tableIns =  table.render({
        elem: '#demo'
        ,height: 420
        ,url: '/virusData/city/selectAll' //数据接口
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
            ,{field: 'id', title: 'ID', width:80, sort: true,align:'center'}
            ,{field: 'cityName', title: '城市名', width:80,edit:"text"}
            ,{field: 'addNum', title: '新增确诊人数', align:'center',edit:"text"}
            ,{field: 'confirmedNum', title: '现确诊人数', align:'center',edit:"text"}
            ,{field: 'cureNum', title: '治愈人数', align:'center',edit:"text"}
            ,{field: 'deathNum', title: '死亡人数', align:'center',edit:"text"}
        ]]
    });
    //监听单元格编辑
    table.on('edit(cityTable)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
        console.log("修改后的值是："+obj.value); //得到修改后的值
        console.log("修改后的对应字段是："+obj.field); //当前编辑的字段名
        console.log("修改后的数据是："+obj.data); //所在行的所有相关数据
        console.log("videotable的id是"+obj.data.id); //打印所在行的id

        //通过ajax往后台发送消息 发送到控制层 修改update方法
        $.ajax({
            type :"post",
            url :"/virusData/city/update",
            data : {
                "id": obj.data.id,
                "field":obj.field,
                "value":obj.value
            },
            dataType :"json",
            success : function(res) {
                //弹出一个修改成功的消息
                layer.msg(res.message);
            }
        })
    });
    table.on('toolbar(cityTable)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id)
            ,data = checkStatus.data; //获取选中的数据
        console.log(obj.config.id);
        console.log(data);
        switch(obj.event){
            case 'add':
                layer.msg('添加');
                //需要打开添加层,打开视频添加窗口 弹出一个层
                layer.open({
                    type:2,  //框架窗口
                    title :"添加城市",
                    shape :0.8,  //外部阴影配置
                    shadeClose:true, //点击窗口外部时，窗口消失
                    area : ['60%','60%'],
                    content : "/virusData/templates/addcity.html"
                });
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
            case 'delete':
                if(data.length === 0){
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                    //通过isd 删除
                }
                break;
        }
    });
    //城市相关信息 表单上传
    $("#submit").on("click",function () {
         alert("你要增加城市了！");
        //获取表单的原生对象 两种获得方法 指的是JavaScript的节点对象
        //ajax与后台传值
        var fd2 = $("#form")[0];
        var formdata = new FormData(fd2);

        $.ajax({
            url :"/virusData/city/add",
            type :"post",
            data :formdata,
            dataType :"json",
            async: false,
            cache: false,
            contentType : false, //防止jQuery对其操作产生不好的影响
            processData : false, // 当设置为true时，jQuery ajax不会序列化，直接使用data
            success: function (res) {
                parent.layer.alert(res.message,{icon:1},function () {
                    // 点击确定之后刷新父窗口
                    window.parent.location.reload();
                });
            },
            error : function(res){
                parent.layer.alert(res.message,{icon: 2});
            }
        })
    })

});


