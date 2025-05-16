package com.example.kt_model_3.controller;

import com.example.kt_model_3.service.PhongTroDAO;
import com.example.kt_model_3.model.PhongTro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PhongTroServlet", urlPatterns = "/Phongtro")
public class PhongTroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PhongTroDAO phongTroDAO;

    public void init() {
        phongTroDAO = new PhongTroDAO();
        System.out.println("PhongTroServlet init");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(request, response);
                break;
            case "view":
//                showDetail(request, response);
                break;
            case "delete":
                break;
            case "update":
                break;
            default:
                showListForm(request, response);
                break;
        }
    }

//    private void showDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        PhongTro phongTro = phongTroDAO.findById(id);
//        request.setAttribute("phongTro", phongTro);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("views/detail.jsp");
//        dispatcher.forward(request, response);
//    }

    private void showFormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/add.jsp");
        dispatcher.forward(request, response);
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhongTro> phongTroList = phongTroDAO.findAllPhongTro("");
        request.setAttribute("ListPhongTro", phongTroList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                FormSearch(request, response);
                break;
            case "add":
                FormAdd(request, response);
            default:
                break;
        }
    }

    private void FormAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("tenNguoiThue");
        String sdt = request.getParameter("sdt");
        String ngay = request.getParameter("ngayBatDau");
//        int mathanhtoan = Integer.parseInt(request.getParameter("mathanhtoan"));
        String hinhthuc = request.getParameter("hinhThuc");
        String ghiChu = request.getParameter("ghiChu");
        PhongTro phongTro = new PhongTro();
        phongTro.setTen_nguoi_thue(ten);
        phongTro.setSdt_nguoi_thue(sdt);
        phongTro.setNgay_bat_dau(ngay);
//        phongTro.setMa_thanh_toan(mathanhtoan);
        phongTro.setHinh_thuc(hinhthuc);
        phongTro.setGhi_chu(ghiChu);
        phongTroDAO.savePhongTro(phongTro);
        response.sendRedirect("/Phongtro");
    }

    private void FormSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<PhongTro> exitstingPhongTro = phongTroDAO.findAllPhongTro(keyword);
        request.setAttribute("ListPhongTro", exitstingPhongTro);
        request.setAttribute("keyword", keyword);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/list.jsp");
        dispatcher.forward(request, response);
    }
}
