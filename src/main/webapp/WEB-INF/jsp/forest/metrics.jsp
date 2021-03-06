<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Metrics</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.5 -->
    <jsp:include page="../common/style.jsp"></jsp:include>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">
    <jsp:include page="../header.jsp"/>
    <jsp:include page="../siderbar.jsp"/>
    <div class="content-wrapper">

        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class=" box  box-solid">
                        <div class="box-header with-border">
                            <section class="content-header">
                                <h1>
                                    监控列表
                                </h1>
                                <ol class="breadcrumb">
                                    <li><a href="/app/index.do"><i class="fa fa-dashboard"></i> Home</a></li>
                                    <li class="active">
                                        ${param.serviceName}
                                    </li>
                                </ol>
                            </section>
                        </div>
                        <div class="box-body ">
                            <table id="table" class="table table-bordered">
                                <div id="toolbar">
                                    <div class="form-inline" role="form">
                                        <div class="form-group extend_query_choice">
                                            <span>服务名:</span>
                                            <select id="serviceNameSelector" class="form-control">
                                                <c:forEach var="app" items="${appList}">
                                                    <option value="${app.serviceName}"
                                                            <c:if test="${app.serviceName==serviceName}">
                                                                selected
                                                            </c:if>
                                                    > ${app.serviceName}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <button id="ok" type="submit" class=" form-control btn btn-default">查询
                                        </button>
                                    </div>
                                </div>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
    <jsp:include page="../footer.jsp"/>
    <jsp:include page="../control-siderbar.jsp"/>

    <div class="control-sidebar-bg"></div>
</div>

<%--<script src="/dist/js/pages/dashboard.js"></script>--%>
<jsp:include page="../common/script.jsp"/>
<script>

    $('#ok').click(function () {
        console.log("fresh");
        $('#table').bootstrapTable('refresh');
    });

    $(function () {
        window.initHandle = {
            initTable: function () {
                $('#table').bootstrapTable('destroy');
                $('#table').bootstrapTable({
                    columns: [
                        {
                            field: 'message',
                            title: '信息',
                            sortable: 'true',
                            visible: true,
                            align: 'center',
                            width: '15%'
                            /*formatter: function (val, row, index) {
                                var serviceName = $('#serviceNameSelector' + " option:selected").val();
                                return '<a href="/metric/detail.do?serviceName=' + serviceName + '&uri=' + row._id + '">' + row._id + '</a>';
                            }*/
                        },
                        {
                            field: 'status',
                            title: '处理状态',
                            sortable: 'true',
                            visible: true,
                            align: 'center',
                            width: '15%',
                            formatter: function (val, row, index) {
                                var labelClass = "";
                                var showLabel = "";
                                if (val == "fault" && row.dealType == "mail") {
                                    labelClass = "bg-red";
                                    showLabel = "故障中";
                                } else if (val == "fault") {
                                    labelClass = "bg-yellow";
                                    showLabel = "故障中";
                                } else {
                                    labelClass = "bg-green";
                                    showLabel = "已经恢复";
                                }
                                return '<span class="badge ' + labelClass + '">' + showLabel + '</span>';
                            }
                        },
                        {
                            field: 'warningTime',
                            title: '报警/恢复时间',
                            sortable: 'true',
                            visible: true,
                            align: 'center',
                            width: '15%',
                            //获取日期列的值进行转换
                            formatter: function (value, row, index) {
                                return changeDateFormat(value)
                            }
                        },
                        {
                            field: 'lastAcceptTime',
                            title: '最后接数时间',
                            sortable: 'true',
                            visible: true,
                            align: 'center',
                            width: '15%',
                            //获取日期列的值进行转换
                            formatter: function (value, row, index) {
                                if (row.status == "normal") {
                                    return "";
                                }
                                return changeDateFormat(value)
                            }
                        },
                    /*  {field: 'maxTime', title: 'maxTime(毫秒)', sortable: 'true', align: 'center', width: '15%'},
                        {field: 'minTime', title: 'minTime(毫秒)', sortable: 'true', align: 'center', width: '15%'},
                        {
                            field: 'lastAcceptTime', title: 'avgTime(毫秒)', sortable: 'true', align: 'center', width: '15%',
                            formatter: function (val, row, index) {
                                var labelClass = "";
                                var avgTime = (row.time / row.count).toFixed(2);
                                if (avgTime < 200) {
                                    labelClass = "bg-green";
                                } else if (avgTime < 1000) {
                                    labelClass = "bg-light-blue";
                                } else if (avgTime < 2000) {
                                    labelClass = "bg-yellow";
                                } else {
                                    labelClass = "bg-red";
                                }
                                return '<span class="badge ' + labelClass + '">' + avgTime + '</span>';
                            }
                        },
                        {
                            field: 'successCount', title: '成功率', sortable: 'true', align: 'center', width: '15%',
                            formatter: function (val, row, index) {
                                var html = '<span class="badge bg-yellow">70%</span>';
                                var successPercent = 95;
                                var labelClass = "";
                                if (successPercent > 98) {
                                    labelClass = "bg-green";
                                } else if (successPercent > 90) {
                                    labelClass = "bg-light-blue";
                                } else if (successPercent > 80) {
                                    labelClass = "bg-yellow";
                                } else {
                                    labelClass = "bg-red";
                                }
                                return '<span class="badge ' + labelClass + '">' + successPercent + '%</span>';
                            }
                        }*/
                        /*{
                            field: 'id',
                            title: '操作',
                            align: 'center',
                            width: '20%',
                            formatter: function (val, row, index) {
                                var serviceName = $('#serviceNameSelector' + " option:selected").val();
                                return '<a href="/metric/detail.do?serviceName=' + serviceName + '&uri=3">' + '<i class="fa fa-bar-chart-o"></i>'+ '</a>';
                            }
                        },*/
                    ],
                    cache: false,
                    striped: true,
                    showRefresh: true,
                    showToggle: true,
                    showColumns: false,
                    pagination: true,
                    pageList: [5, 10, 20, 30, 50],
                    search: true,
                    sidePagination: "client",
                    toolbar: '#toolbar',
                    url: '/record/groupByUri.do',
                    queryParams: function queryParams(params) {   //设置查询参数
                        var serviceName = $('#serviceNameSelector' + " option:selected").val();
                        var param = {serviceName: serviceName};
                        return param;
                    },
                    onLoadSuccess: function(){  //加载成功时执行
                        var serviceName = "a";
                        if(serviceName == "a"){
                            $('#table').bootstrapTable('hideColumn', 'status');
                            $('#table').bootstrapTable('hideColumn', 'lastAcceptTime');
                        }
                    }
                });

            }
        };

        // 初始化table
        initHandle.initTable();

    });

    function changeDateFormat(cellval) {
        if (cellval != null) {
            var dateVal = cellval + "";
            var date = new Date(parseInt(dateVal));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
        return "";
    }
</script>

</body>
</html>
