<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/16/2025
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Danh sách phòng trọ</title>
    <style>
        .container {
            width: 90%;
            margin: 0 auto;
            padding: 20px;
        }
        .search-bar {
            margin-bottom: 20px;
        }
        .search-input {
            padding: 8px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .button {
            background-color: #4CAF50;
            color: white;
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-right: 10px;
        }
        .button:hover {
            background-color: #45a049;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        .action-buttons {
            display: flex;
            gap: 5px;
        }
        .view-button {
            background-color: #2196F3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Danh sách phòng trọ</h2>
        <div class="search-bar">
            <form method="post" style="display: inline-block;">
                <input type="hidden" name="action" value="search" />
                <input type="text" name="keyword" value="${keyword}" placeholder="Tìm kiếm..." class="search-input">
                <button type="submit" class="button">Tìm kiếm</button>
            </form>
            <a href="/Phongtro?action=add">
                <button class="button">Thêm mới</button>
            </a>
        </div>
        
        <table>
            <thead>
                <tr>
                    <th>Mã phòng trọ</th>
                    <th>Tên người thuê</th>
                    <th>SĐT</th>
                    <th>Ngày bắt đầu</th>
                    <th>Hình thức thanh toán</th>
                    <th>Ghi chú</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="pt" items="${ListPhongTro}">
                    <tr>
                        <td>PT-${pt.ma_phong_tro}</td>
                        <td>${pt.ten_nguoi_thue}</td>
                        <td>${pt.sdt_nguoi_thue}</td>
                        <td>${pt.ngay_bat_dau}</td>
                        <td>${pt.hinh_thuc}</td>
                        <td>${pt.ghi_chu}</td>
                        <td>
                            <div class="action-buttons">
                                <a href="/Phongtro?action=view&id=${pt.ma_phong_tro}">
                                    <button class="button view-button">Xem chi tiết</button>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
