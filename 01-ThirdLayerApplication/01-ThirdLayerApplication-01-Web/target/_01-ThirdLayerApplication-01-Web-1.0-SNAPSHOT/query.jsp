<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分页查询</title>
</head>
<body>
<table width="500px" align="center" border="1px">
    <caption><h3>学生信息表</h3></caption>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>信息</th>
    </tr>

    <c:if test="${not empty pageInfo.list}">
        <c:forEach var="student" items="${pageInfo.list}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>${student.gender}</td>
                <td>${student.info}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<form action="query" method="get">
    <table align="center">
        <tr>
            <td><a href="query?pageNo=1">首页</a></td>
            <td>
                <c:if test="${1 == pageInfo.pageNo}">
                    <a disabled>上一页</a>
                </c:if>

                <c:if test="${1 != pageInfo.pageNo}">
                    <a href="query?pageNo=${pageInfo.pageNo - 1}">上一页</a>
                </c:if>

            </td>
            <c:forEach var="pageNo" varStatus="pageStatus" begin="1" end="${pageInfo.pageCount}">
                <td>
                    <c:if test="${pageNo == pageInfo.pageNo}">
                        <input disabled type="submit" name="pageNo" value="${pageNo}">
                    </c:if>

                    <c:if test="${pageNo != pageInfo.pageNo}">
                        <input  type="submit" name="pageNo" value="${pageNo}">
                    </c:if>
                </td>
            </c:forEach>
            <td>
                <%--如果当前页为最后一页--%>
                <c:if test="${pageInfo.pageCount == pageInfo.pageNo}">
                    <a disabled>下一页</a>
                </c:if>

                <c:if test="${pageInfo.pageCount != pageInfo.pageNo}">
                    <a href="query?pageNo=${pageInfo.pageNo + 1}">下一页</a>
                </c:if>

            </td>
            <td><a href="query?pageNo=${pageInfo.pageCount}">尾页</a></td>
            <td>共${pageInfo.totalCount}条内容，共${pageInfo.pageCount}页</td>
        </tr>
    </table>
</form>
</body>
</html>
