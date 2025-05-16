<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/16/2025
  Time: 9:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post">
  <input type="hidden" name="action" value="add" />

  <label>Tên người thuê:</label>
  <input type="text" name="tenNguoiThue" required /><br/>

  <label>Số điện thoại:</label>
  <input type="text" name="sdt" required /><br/>

  <label>Ngày bắt đầu thuê:</label>
  <input type="date" name="ngayBatDau" required /><br/>

  <label>Hình thức thanh toán:</label>
  <select name="hinhThuc" required>
    <option value="1">Theo tháng</option>
    <option value="2">Theo quý</option>
    <option value="3">Theo năm</option>
  </select><br/>

  <label>Ghi chú:</label>
  <textarea name="ghiChu" maxlength="200"></textarea><br/>

  <button type="submit">Tạo mới</button>
  <button type="button">Hủy</button>
</body>
</html>
