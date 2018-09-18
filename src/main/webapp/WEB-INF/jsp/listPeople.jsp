<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div align="center">

</div>

<div style="width:500px;margin:20px auto;text-align: center">
    <table align='center' border='1' cellspacing='0'>
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="editPeople?id=${c.id}">编辑</a></td>
                <td><a href="deletePeople?id=${c.id}">删除</a></td>
            </tr>
        </c:forEach>

    </table>
    <br>
    <div>
        <p>一共${page.pages}页,共条${page.total}记录</p>
        <p>第${page.pageNum}页</p>
        <a href="?start=${page.firstPage}">第一页</a>
        <c:if test="${page.pageNum != 1}">
            <a href="?start=${page.prePage}">上一页</a>
        </c:if>
        <c:set var="salary" scope="session" value="${page.pageNum}"/>
        <c:if test="${page.pageNum < page.pages}">
            <a href="?start=${page.nextPage}">下一页</a>
        </c:if>
        <a href="?start=${page.lastPage}">最后页</a>
    </div>
    <br>
    <form action="addPeople" method="post">

        name: <input name="name"> <br>
        <button type="submit">提交</button>

    </form>
</div>