package com.example.kt_model_3.service;

import com.example.kt_model_3.model.PhongTro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroDAO implements GenneralDAO<PhongTro> {
    String GET_ALL_PHONG_TRO = "{CALL sp_find_all_phong_tro (?)}";
    String INSERT_PHONG_TRO = "{CALL sp_insert_phong_tro(?, ?, ?, ?, ?)}";
    String GET_PHONG_TRO_BY_ID = "{CALL sp_find_phong_tro_by_id(?)}";

    public PhongTro findById(int id) {
        PhongTro phongTro = null;
        try (Connection connection = DBConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(GET_PHONG_TRO_BY_ID)) {
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            if (resultSet.next()) {
                phongTro = new PhongTro();
                phongTro.setMa_phong_tro(resultSet.getInt("ma_phong_tro"));
                phongTro.setTen_nguoi_thue(resultSet.getString("ten_nguoi_thue"));
                phongTro.setSdt_nguoi_thue(resultSet.getString("sdt_nguoi_thue"));
                phongTro.setNgay_bat_dau(resultSet.getString("ngay_bat_dau"));
                phongTro.setHinh_thuc(resultSet.getString("hinh_thuc"));
                phongTro.setGhi_chu(resultSet.getString("ghi_chu"));
            }
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
        return phongTro;
    }

    @Override
    public List<PhongTro> findAllPhongTro(String keyword) {
        List<PhongTro> phongTroList = new ArrayList<PhongTro>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PHONG_TRO)) {
             preparedStatement.setString(1, keyword);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()) {
                 PhongTro phongTros = new PhongTro();
                 phongTros.setMa_phong_tro(resultSet.getInt("ma_phong_tro"));
                 phongTros.setTen_nguoi_thue(resultSet.getString("ten_nguoi_thue"));
                 phongTros.setSdt_nguoi_thue(resultSet.getString("sdt_nguoi_thue"));
                 phongTros.setNgay_bat_dau(resultSet.getString("ngay_bat_dau"));
                 phongTros.setHinh_thuc(resultSet.getString("hinh_thuc"));
                 phongTros.setGhi_chu(resultSet.getString("ghi_chu"));
                 phongTroList.add(phongTros);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phongTroList;
    }

    @Override
    public void savePhongTro(PhongTro entity) {
        try (Connection connection = DBConnection.getConnection();
             CallableStatement callableStatement = connection.prepareCall(INSERT_PHONG_TRO)) {
             callableStatement.setString(1, entity.getTen_nguoi_thue());
             callableStatement.setString(2, entity.getSdt_nguoi_thue());
             callableStatement.setString(3, entity.getNgay_bat_dau());
             callableStatement.setInt(4, entity.getMa_thanh_toan());
             callableStatement.setString(5, entity.getGhi_chu());
             callableStatement.executeUpdate();
        } catch (SQLException e) {
            DBConnection.printSQLException(e);
        }
    }

}
