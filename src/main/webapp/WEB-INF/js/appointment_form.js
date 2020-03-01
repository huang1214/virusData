var areaData;
var $form;
var form;
var $;
layui.use(['jquery', 'form'], function() {
    $ = layui.jquery;
    form = layui.form;
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


});