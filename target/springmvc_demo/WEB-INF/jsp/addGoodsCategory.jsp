<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2016/10/26
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>增加商品类型</title>
    <link href="<%=request.getContextPath()%>/resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container jumbotron">
    <div class="panel panel-success">
        <div class="panel-heading">添加商品类型</div>
        <div class="panel-body">
            <form:form action="${pageContext.request.contextPath }/goodsCategory" cssClass="form" method="post" modelAttribute="goodsCategory">
                <c:if test="${goodsCategory.goodsCategoryId == null}">
                    <input type="hidden" name="_method" value="PUT"/>
                </c:if>
                <div class="row">
                    <div class="col-md-1">
                        <div class="form-group">
                            <label for="goodsCategoryName">商品类型</label>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <form:input path="goodsCategoryName" id="goodsCategoryName"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-1">
                        <div class="form-group">
                            <label for="createPerson">创建人</label>
                        </div>
                    </div>
                    <div class="col-md-11">
                        <form:input path="createPerson" id="createPerson"/>
                    </div>
                </div>
                <c:if test="${goodsCategory.goodsCategoryId != null}">
                    <form:hidden path="goodsCategoryId"/>
                    <div class="row">
                        <div class="col-md-1">
                            <div class="form-group">
                                <label for="createPerson">创建时间</label>
                            </div>
                        </div>
                        <div class="col-md-11">
                            <form:input path="createTime" id="createTime"/>
                        </div>
                    </div>
                </c:if>
                <br>
                <button type="submit" class="btn btn-primary">提交</button>
            </form:form>
        </div>
        <div class="panel-footer"></div>
    </div>
</div>
</body>
<script src="/resources/js/jquery-3.0.0.js"></script>
<script src="/resources/js/bootstrap.js"></script>
</html>
