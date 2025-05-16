package com.example.kt_model_3.model;

import javax.enterprise.inject.Model;
import java.util.Date;

public class PhongTro {
    private int ma_phong_tro;
    private String ten_nguoi_thue;
    private String sdt_nguoi_thue;
    private String ngay_bat_dau;
    private String hinh_thuc;
    private int ma_thanh_toan;
    private String ghi_chu;

    public PhongTro(int ma_phong_tro, String ten_nguoi_thue, String sdt_nguoi_thue, String ngay_bat_dau, String hinh_thuc, int ma_thanh_toan, String ghi_chu) {
        this.ma_phong_tro = ma_phong_tro;
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.sdt_nguoi_thue = sdt_nguoi_thue;
        this.ngay_bat_dau = ngay_bat_dau;
        this.hinh_thuc = hinh_thuc;
        this.ma_thanh_toan = ma_thanh_toan;
        this.ghi_chu = ghi_chu;
    }

    public int getMa_thanh_toan() {
        return ma_thanh_toan;
    }

    public void setMa_thanh_toan(int ma_thanh_toan) {
        this.ma_thanh_toan = ma_thanh_toan;
    }

    public PhongTro() {

    }

    public PhongTro(int ma_phong_tro, String ten_nguoi_thue, String sdt_nguoi_thue, String ngay_bat_dau, String hinh_thuc, String ghi_chu) {
        this.ma_phong_tro = ma_phong_tro;
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.sdt_nguoi_thue = sdt_nguoi_thue;
        this.ngay_bat_dau = ngay_bat_dau;
        this.hinh_thuc = hinh_thuc;
        this.ghi_chu = ghi_chu;
    }

    public int getMa_phong_tro() {
        return ma_phong_tro;
    }

    public void setMa_phong_tro(int ma_phong_tro) {
        this.ma_phong_tro = ma_phong_tro;
    }

    public String getTen_nguoi_thue() {
        return ten_nguoi_thue;
    }

    public void setTen_nguoi_thue(String ten_nguoi_thue) {
        this.ten_nguoi_thue = ten_nguoi_thue;
    }

    public String getSdt_nguoi_thue() {
        return sdt_nguoi_thue;
    }

    public void setSdt_nguoi_thue(String sdt_nguoi_thue) {
        this.sdt_nguoi_thue = sdt_nguoi_thue;
    }

    public String getNgay_bat_dau() {
        return ngay_bat_dau;
    }

    public void setNgay_bat_dau(String ngay_bat_dau) {
        this.ngay_bat_dau = ngay_bat_dau;
    }

    public String getHinh_thuc() {
        return hinh_thuc;
    }

    public void setHinh_thuc(String hinh_thuc) {
        this.hinh_thuc = hinh_thuc;
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
}
