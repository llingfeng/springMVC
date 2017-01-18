<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/10/24
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@include file="common/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>商品类型</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        th, td {
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<div class="container jumbotron">
    <div class="panel panel-success">
        <div class="panel-heading">商品类型列表</div>
        <div class="panel-body">
            <form id="categoryForm" class="form-inline" role="form" action="categoryList" method="post">
                <input type="hidden" id="categoryId" name="categoryId" value="">
                <div class="row">
                    <div class="col-md-3">
                        <div class="form-group">
                            <button class="btn btn-primary" type="button" onclick="jumpToAdd()">增加</button>
                            <button class="btn btn-danger" type="button" onclick="deleteBatch()">删除</button>
                        </div>
                    </div>
                    <div class="col-md-9" style="text-align: right;">
                        <div class="form-group">
                            <label for="goodsCategoryName">商品类型</label>
                            <input class="form-control" name="goodsCategoryName" id="goodsCategoryName" placeholder="请输入商品类型名称" value="${goodsCategoryName}">
                        </div>
                        <div class="form-group">
                            <label for="createPerson">创建人</label>
                            <input class="form-control" name="createPerson" id="createPerson" placeholder="请输入创建人名字" value="${createPerson}">
                        </div>
                        <button class="btn btn-primary" type="submit">查询</button>
                    </div>
                </div>
                <table class="table table-striped" style="margin-top: 10px">
                    <thead>
                    <tr>
                        <th>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="selectAll" id="selectAll">
                                </label>
                            </div>
                        </th>
                        <th>序号</th>
                        <th>ID</th>
                        <th>商品类型</th>
                        <th>创建人</th>
                        <th>创建时间</th>
                        <th>更新时间</th>
                        <th>编辑</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${goodsCategoryList}" var="goodsCategory" varStatus="statu">
                        <tr>
                            <td>
                                <div class="checkbox">
                                    <label>
                                        <input name="categoryIds" type="checkbox" class="check_children" value="${goodsCategory.goodsCategoryId}">
                                    </label>
                                </div>
                            </td>
                            <td>${statu.index+1}</td>
                            <td>${goodsCategory.goodsCategoryId}</td>
                            <td>${goodsCategory.goodsCategoryName}</td>
                            <td>${goodsCategory.createPerson}</td>
                            <td><fmt:formatDate value="${goodsCategory.createTime}" pattern="yyyy-MM-dd"/></td>
                            <td><fmt:formatDate value="${goodsCategory.updateTime}" pattern="yyyy-MM-dd"/></td>
                            <td>
                                <button type="button" class="btn btn-primary" onclick="modify(${goodsCategory.goodsCategoryId})">修改</button>
                                <button type="button" class="btn btn-danger" onclick="deleteOne(${goodsCategory.goodsCategoryId})">删除</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="panel-footer"></div>
    </div>
    <div class="modal fade" id="mymodal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">提示</h4>
                </div>
                <div class="modal-body">
                    <p>确定删除该类商品吗？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="sureToDeleteOne()">确定</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
</div>
</body>
<script src="<%=basePath%>resources/js/jquery-3.0.0.js"></script>
<script src="<%=basePath%>resources/js/bootstrap.js"></script>
<script type="text/javascript">
    $(function () {
        //全选
        $("#selectAll").change(function () {
            $(".check_children").prop("checked",this.checked);
        });
        //取消全选标记
        $(".check_children").change(function () {
            if(!this.checked){
                $("#selectAll").prop("checked",false);
            }
        });
    });

    //提示用户是否要删除
    function deleteOne(categoryId){
        $("#categoryId").val(categoryId);
        $("#mymodal").modal("toggle");
        return false;
    }

    //删除单条记录
    function sureToDeleteOne() {
        var category = {"goodsCategoryId":$("#categoryId").val()};
        $.ajax({
            type:"delete",
            url:"categoryList",
            data:JSON.stringify(category),
            dataType:"json",
            contentType:"application/json",
            success:function (result) {
                if(result == 1){
                    $("#mymodal").modal("hide");
                    location.replace(location.href);
                }
            }
        });
    }

    //批量删除
    function  deleteBatch() {
        $("#categoryId").append("<input type='hidden' name='_method' value='delete'>");
        $("#categoryForm").attr("action","deleteBatch").submit();
    }

    //跳转到新增页面
    function jumpToAdd() {
        window.location.href = "goodsCategory";
    }

    //修改
    function modify(id) {
        window.open("goodsCategory/"+id);
    }
</script>
</html>
