<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Chi tiết người thuê trọ</title>
    <style>
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
        }
        .info-card {
            border: 1px solid #ddd;
            padding: 20px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        .info-row {
            margin: 10px 0;
        }
        .label {
            font-weight: bold;
            width: 150px;
            display: inline-block;
        }
        .back-button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Thông tin chi tiết người thuê trọ</h2>
        <div class="info-card">
            <div class="info-row">
                <span class="label">Mã phòng trọ:</span>
                <span>PT-${phongTro.ma_phong_tro}</span>
            </div>
            <div class="info-row">
                <span class="label">Tên người thuê:</span>
                <span>${phongTro.ten_nguoi_thue}</span>
            </div>
            <div class="info-row">
                <span class="label">Số điện thoại:</span>
                <span>${phongTro.sdt_nguoi_thue}</span>
            </div>
            <div class="info-row">
                <span class="label">Ngày bắt đầu:</span>
                <span>${phongTro.ngay_bat_dau}</span>
            </div>
            <div class="info-row">
                <span class="label">Hình thức thanh toán:</span>
                <span>${phongTro.hinh_thuc}</span>
            </div>
            <div class="info-row">
                <span class="label">Ghi chú:</span>
                <span>${phongTro.ghi_chu}</span>
            </div>
        </div>
        <a href="/Phongtro" class="back-button">Quay lại danh sách</a>
    </div>
</body>
</html> 