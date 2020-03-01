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
            elem: '#demo'
            ,url:'/index/patient/selectAll'  //数据接口,
            ,parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": res.status, //解析接口状态 要求是"0"
                    "msg": res.message, //解析提示文本
                    "count": res.total, //解析数据长度
                    "data": res.item //解析数据列表
                };
            }
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板11111111111111
            ,title: '用户数据表'
            ,cols: [[ //表头
                {type: 'checkbox', fixed: 'left'}
                ,{field:'id', title:'ID', width:170, fixed: 'left', unresize: true, sort: true}
                ,{field:'name', title:'姓名', width:170, edit: 'text'}
                ,{field:'address', title:'地址', width:205, edit: 'text'}
                ,{field:'type', title:'类型', width:130, edit: 'text', sort: true}
                ,{field:'temperate', title:'体温', width:130,edit: 'text'}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:270}//操作
            ]]
            ,page: true
        });

        //监听单元格编辑
        table.on('edit(patientTable)', function(obj){ //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
            console.log("修改后的值是"+obj.value); //得到修改后的值
            console.log("修改的对应字段"+obj.field); //当前编辑的字段名
            console.log(obj.data); //所在行的所有相关数据
            console.log("patient的id是"+obj.data.id); //所在行的所有相关数据
            //通过ajax 往后台发送消息到后台控制层 PatientController 修改update 方法参数 （videos）

            $.ajax({
                type:"post",  // 传输的方式
                url:"/index/patient/update", // 传输到后台的路径
                data:{ // 传输的数据
                    "id":obj.data.id,
                    "field":obj.field,
                    "value":obj.value
                },
                dataType:"json",//传输返回来的类型
                success:function(res){// 传输的回调函数
                    // 弹出消息
                    layer.msg(res.message);
                }
            })
        });


    //监听工具条
    table.on('tool(patientTable)', function(obj){
        var data = obj.data;
        if(obj.event === 'detail'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        }
        else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                //obj.del();
                console.log(obj);
                console.log(data);
                //layer.close(index);
                $.ajax({
                    url: "/index/patient/delete",
                    type: "POST",
                    data:{'id':data.id},
                    dataType: "json",
                    success: function(data){
                        if(data==null){
                            layer.msg("删除失败", {icon: 5});
                        }else{
                            //删除这一行
                            obj.del();
                            //关闭弹框
                            layer.close(index);
                            layer.alert("已删除id为"+data.id+"的行");
                            layer.msg("删除成功", {icon: 6});
                            layer.closeAll();

                            // parent.location.reload();
                            // Load(); //删除完需要加载数据
                            window.parent.location.reload();

                        }
                    },
                    error:function(){
                        alert(data);
                    },

                });
            });
        }else if(obj.event === 'edit') {
            layer.msg('编辑病例');
            // 打开视频编辑窗口   弹出一个层
            layer.open({
                type: 2,// iframe  框架窗口
                title: "编辑病例",
                shade: 0.8, // 窗口外部阴影配置
                shadeClose: true,// 点击窗口外部时  窗口消失
                area: ['60%', '60%'],
                closeBtn: false,
                btn: ['确认更改', '取消'],
                btnAlign: 'c',
                content: "/index/templates/updatepatient.html",
                yes: function (index) {
                    var fd = document.getElementById("form");
                    // 需要
                    var formdata = new FormData(fd);
                    console.log(formdata);
                    $.ajax({
                        url: '/index/patient/edit',
                        type: 'post',
                        data: formdata,
                        dataType: 'json',
                        contentType: "false",
                        success: function (data) {
                            layer.msg(res.message);
                        },
                        error: function () {
                            alert("编辑错误,请重新编写!");
                        }
                    });
                }


            });
            //layer.close(index);
        }
    });


    // 当点击搜索按钮时
    $("#re").on("click",function(){
        // 搜索 表格重载函数
        console.log("要进行表格重载");
        table.reload('demo', {
            url:"/index/patient/query", // 会把page 和limit（在页面的分页参数里） 加到路径后边
            where: { //设定异步数据接口的额外参数，任意设
                patientId:$("#patientLike").val()
            }
            ,page: {
                curr: 1 //重新从第 1 页开始
            }
        }); //只重载数据

    })
    //
    // for (const key in data) {
    //     formdata.append(key, data[key]);
    // }

            //病人病例相关信息 表单上传
            $("#submit").on("click", function () {
                //获取表单的原生对象  指的的是 javascript  节点对象
                var fd1 = document.getElementById("form");
                // 需要
                var formdata = new FormData(fd1);
                console.log(formdata);

                // ajax 与后台传值
                $.ajax({
                    url: "/index/patient/add",
                    type: "post",
                    data: formdata,
                    dataType: 'json',
                    contentType: false,// 防止jquery  对其操作
                    processData: false,//当设置为true  jquery ajax 不会序列化 直接使用data
                    async: false,
                    cache: false,
                    success: function (res) {
                        parent.layer.alert(res.message, {icon: 1}, function () {
                            // parent.layer 父窗口弹出信息
                            // 参数1   res.message  后台返回的信息
                            // 参数2  icon:1 信息窗的图标
                            //  can
                            //  刷新父窗口
                            window.parent.location.reload();
                        });
                    },
                    error: function (res) {
                    }
                })
            });


            //头工具栏事件
            table.on('toolbar(patientTable)', function (obj) {
                var checkStatus = table.checkStatus(obj.config.id) //表格的id
                    ,data = checkStatus.data; //获取选中的数据
                // 用来群删除的数组
                var ids=[];
                for(var i=0;i<data.length;i++){
                    ids[i] = data[i].id;

                }

                switch (obj.event) {
                    case 'delA':
                        if(data.length === 0){
                            layer.msg('请选择一行');
                        } else {
                            layer.msg('删除');
                            // 通过ids  id 数组进行删除
                            $.ajax({
                                type:"post",
                                url:"/index/patient/deleteA",
                                data:{
                                    "ids":ids
                                },
                                dataType:"json",
                                traditional:true, //如果传输的是数组  要求是 这个参数
                                success:function(res){
                                    var message = res.message;
                                    var code = res.status;
                                    if(code=="200"){
                                        // 弹出信息框  点击信息框 表格刷新
                                        // 参数1 弹出的信息  参数2 图标  参数3点击按钮触发事件
                                        layer.alert(message,{icon:1},function(index){
                                            // 关掉  信息框
                                            layer.close(index);
                                            // 表格进行重载
                                            // tableIns.reload();
                                            window.parent.location.reload();

                                        })

                                    }
                                }

                            })
                        }
                        break;
                    case 'getCheckData':
                        var data = checkStatus.data;
                        layer.alert(JSON.stringify(data));
                        break;
                    case 'getCheckLength':
                        var data = checkStatus.data;
                        layer.msg('选中了：' + data.length + ' 个');
                        break;
                    case 'isAll':
                        layer.msg(checkStatus.isAll ? '全选' : '未全选');
                        break;


                }
                ;
            });

            // 当点击搜索按钮时
            $("#re").on("click", function () {
                // 搜索 表格重载函数
                console.log("要进行表格重载");
                table.reload('demo', {
                    url: "/index/patient/query", // 会把page 和limit（在页面的分页参数里） 加到路径后边
                    where: { //设定异步数据接口的额外参数，任意设
                        userId: $("#patientLike").val()
                    }
                    , page: {
                        curr: 1 //重新从第 1 页开始
                    }
                }); //只重载数据

            })




});



        // //监听行工具事件
        // table.on('tool(patientTable)', function(obj){
        //     var data = obj.data;
        //     //console.log(obj)
        //     if(obj.event === 'del'){
        //         layer.confirm('真的删除行么', function(index){
        //             obj.del();
        //             layer.close(index);
        //         });
        //     } else if(obj.event === 'edit'){
        //         layer.prompt({
        //             formType: 2
        //             ,value: data.email
        //         }, function(value, index){
        //             obj.update({
        //                 email: value
        //             });
        //             layer.close(index);
        //         });
        //     }
        // });



