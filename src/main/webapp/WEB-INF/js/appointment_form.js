var areaData;
var $form;
var form;
var $;
layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider','form'], function(){
    $ = layui.jquery;
    form = layui.form;
    var table = layui.table ;//表格
    $form = $('form');
    areaData = Area;
    loadProvince();

    //加载省数据
    function loadProvince() {
        var proHtml = '';
        for (var i = 0; i < areaData.length; i++) {
            proHtml += '<option value="' + areaData[i].provinceCode + '_' + areaData[i].mallCityList.length + '_' + i + '">' + areaData[i].provinceName + '</option>';
        }
        //初始化省数据
        $form.find('select[name=province]').append(proHtml);
        form.render();
        form.on('select(province)', function(data) {
            $form.find('select[name=area]').html('<option value="">请选择县/区</option>').parent().hide();
            var value = data.value;
            var d = value.split('_');
            var code = d[0];
            var count = d[1];
            var index = d[2];
            if (count > 0) {
                loadCity(areaData[index].mallCityList);
            } else {
                $form.find('select[name=city]').parent().hide();
            }
        });
    }
    //加载市数据
    function loadCity(citys) {
        var cityHtml = '';
        for (var i = 0; i < citys.length; i++) {
            cityHtml += '<option value="' + citys[i].cityCode + '_' + citys[i].mallAreaList.length + '_' + i + '">' + citys[i].cityName + '</option>';
        }
        $form.find('select[name=city]').html(cityHtml).parent().show();
        form.render();
        form.on('select(city)', function(data) {
            var value = data.value;
            var d = value.split('_');
            var code = d[0];
            var count = d[1];
            var index = d[2];
            if (count > 0) {
                loadArea(citys[index].mallAreaList);
            } else {
                $form.find('select[name=area]').parent().hide();
            }
        });
    }
    //加载县/区数据
    function loadArea(areas) {
        var areaHtml = '';
        for (var i = 0; i < areas.length; i++) {
            areaHtml += '<option value="' + areas[i].areaCode + '">' + areas[i].areaName + '</option>';
        }
        $form.find('select[name=area]').html(areaHtml).parent().show();
        form.render();
        form.on('select(area)', function(data) {
            //console.log(data);
        });
    }
    //口罩预约信息的上传
    $("#submit").on("click",function () {

        //防止表单的默认事件提交
        event.preventDefault();

        var fd = $("#appform")[0];
        //通过formdata抓取表单
        var formdata = new FormData(fd);

        console.log("获取表单数据"+formdata.get("name"));

        //ajax与后台传值
        $.ajax({
            url:"/index/mask/application_add",
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
    })
    //选择附近药店弹出层
    function chooseStoreLayer() {
        layer.open({
            type: 1  //1为页面层
            , title: '选择附近药店'  //弹出层标题
            , area: ['800px', '434px']    //设置弹出层大小[宽，高]
            , offset: 'auto'   //设置弹出层位置
            , id: 'layerDemo_storeId' //防止重复弹出，点击这个input只能有一个弹出层
            , content: $("#layer_storeId")   //弹出层内容为layer_storeId块，不能直接是表格id
            , btnAlign: 'c' //按钮居中
            , shade: 0 //不显示遮罩
            , yes: function () {  //确定按钮回调方法， 需要手动关闭弹出层
                layer.closeAll();
            }
        });
    }
    //附近药店弹出层表格
    $(document).on('click', '#storeId', function () {
        chooseStoreLayer();
        // 比赛名称弹出层>>表格
        table.render({
            elem: '#layer_store_table'
            , height: 312
            , url: '/index/store/querry_store' //数据接口
            ,parseData: function(res) { //res 即为原始返回的数据
                return {
                    "code": res.status, //解析接口状态 要求是"0"
                    "msg": res.message, //解析提示文本
                    "count": res.total, //解析数据长度
                    "data": res.item //解析数据列表
                };
            }
            , method: "get"
            , page: true //开启分页
            , toolbar: '#toolbar_storeId'
            , cols: [
                [ //表头
                    {type: 'radio'}
                    , {field: 'storeId', title: '药店Id', width: 103, sort: true}
                    , {field: 'storename', title: '药店名称', width: 350}
                    , {field: 'location', title: '详细地址', width: 350}
                ]
            ]
        });

    })
    //附近药店信息获取
    table.on('toolbar(layer_store_table)', function (obj) {
        //注：tool 是工具条事件名，layer_store_table 是 table 原始容器的属性 lay-filter="对应的值"
        var checkStatus = table.checkStatus(obj.config.id); //获取选中行状态
        switch (obj.event) {
            case 'getCheckData_storeId':
                var data = checkStatus.data;  //获取选中行数据
                document.getElementById("storeId").value = data[0].storeId;  //将获取的数据中的dno值给input

                layer.closeAll(); //疯狂模式，关闭所有层
                break;
        }
    })


});