function forDetail(provinceZipCode) {
    layui.use(['table','layer','jquery'],function () {
        let table = layui.table;
        let layer = layui.layer;
        let $=layui.jquery;
        console.log(provinceZipCode);
        let data;
        // 使用ajax查出数据，直接写入content
        $.ajax({
            type:"get",
            url:"/index/data/detail?provinceId="+provinceZipCode,
            dataType:"json",
            success:function (res) {
                console.log(res.item);
                // 渲染表格
                data = res.item;
                // 拼接变量字符
                let tempstr;
                for (let i = 0;i<data.length;i++){
                    tempstr +=
                        "    <tr>\n" +
                        "      <td>"+data[i].cityname+"</td>\n" +
                        "      <td>"+data[i].cityConfirmedcount+"</td>\n" +
                        "      <td>"+data[i].citySuspectedcount+"</td>\n" +
                        "      <td>"+data[i].cityCuredcount+"</td>\n" +
                        "      <td>"+data[i].cityDeadcount+"</td>\n" +
                        "    </tr>\n";
                }
                // 字符串拼接一个静态表格
                let loadstr = "<table class=\"layui-table\">\n" +login.html
                    "  <colgroup>\n" +
                    "    <col width=\"150\">\n" +
                    "    <col width=\"200\">\n" +
                    "    <col>\n" +
                    "  </colgroup>\n" +
                    "  <thead>\n" +
                    "    <tr>\n" +
                    "      <th>城市</th>\n" +
                    "      <th>确诊病例</th>\n" +
                    "      <th>疑似病例</th>\n" +
                    "      <th>治愈人数</th>\n" +
                    "      <th>死亡人数</th>\n" +
                    "    </tr> \n" +
                    "  </thead>\n" +
                    "  <tbody>\n" +
                    tempstr
                    +"  </tbody>\n" +
                    "</table>";

                layer.open({
                    type:1,
                    title:"市级数据",
                    shade:0.8, // 窗口外部阴影配置
                    shadeClose:true,// 点击窗口外部时  窗口消失
                    area: ['80%', '80%'],
                    content:loadstr
                });
            }
        });


        // table.render({
        //     elem: '#showdetail'
        //     , height: 420
        //     , parseData: function (res) { //res 即为原始返回的数据
        //         return {
        //             "code": res.status, //解析接口状态 要求是"0"
        //             "msg": res.message, //解析提示文本
        //             "count": res.total, //解析数据长度
        //             "data": res.item //解析数据列表
        //         };
        //     }
        //     , data:data
        //     , title: '各省数据情况'
        //     , page: true //开启分页
        //     , toolbar: '#bar' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        //     , totalRow: true //开启合计行
        //     , cols: [[ //表头
        //         {type: 'checkbox', fixed: 'left'}
        //         , {field: 'cityname', title: '城市', align: 'center'}
        //         , {field: 'cityConfirmedcount', title: '确诊病例', align: 'center', sort: true, edit: "text"}
        //         , {field: 'citySuspectedcount', title: '疑似病例', align: 'center', sort: true, edit: "text"}
        //         , {field: 'cityCuredcount', title: '治愈人数', align: 'center', sort: true, edit: "text"}
        //         , {field: 'cityDeadcount', title: '死亡人数', align: 'center', sort: true, edit: "text"}
        //
        //     ]]
        // });



    });
}

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

    // 弹出窗口，然后利用参数查询省份中的市级信息


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
                    var provinceZipCode = e.provinceZipcode;
                    return "<button class='layui-btn layui-btn-normal' onclick='forDetail(\""+provinceZipCode+"\")'>详情</button>"
                }
            }

        ]]
    });


});