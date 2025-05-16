use `room_for_rent`;

create table Nguoi_Thue (
	ma_nguoi_thue int auto_increment primary key not null,
    ten_nguoi_thue varchar(100) not null,
    sdt_nguoi_thue varchar(10) not null
);

drop table Thanh_toan;
create table Thanh_Toan (
	ma_thanh_toan int auto_increment primary key not null,
    hinh_thuc varchar(20) not null
);

create table Phong_Tro (
	ma_phong_tro int auto_increment primary key not null,
    ngay_bat_dau date,
    ghi_chu varchar(255),
    ma_nguoi_thue int,
    ma_thanh_toan int,
    FOREIGN KEY (ma_nguoi_thue) REFERENCES Nguoi_Thue (ma_nguoi_thue),
    FOREIGN KEY (ma_thanh_toan) REFERENCES Thanh_toan (ma_thanh_toan)
);

insert into Nguoi_Thue (ten_nguoi_thue, sdt_nguoi_thue) values 
('Nguyen Van A', '0912345678'),
('Tran Thi B', '0987654321'),
('Le Van C', '0909123456');

insert into Thanh_Toan (hinh_thuc) values 
('Theo tháng'),
('Theo quý'),
('Theo năm');

insert into Phong_Tro (ngay_bat_dau, ghi_chu, ma_nguoi_thue, ma_thanh_toan) values 
('2025-06-01', 'Thuê gần trường học', 1, 1),
('2025-06-05', 'Cần hóa đơn', 2, 2),
('2025-07-01', NULL, 3, 3);

delimiter //
create procedure sp_find_all_phong_tro (
	in keyword varchar(100)
)
begin
	SELECT 
			pt.ma_phong_tro, 
			nt.ten_nguoi_thue, 
			nt.sdt_nguoi_thue, 
			pt.ngay_bat_dau, 
			tt.hinh_thuc, 
			pt.ghi_chu
		FROM Phong_Tro pt
		JOIN Nguoi_Thue nt ON pt.ma_nguoi_thue = nt.ma_nguoi_thue
		JOIN Thanh_Toan tt ON pt.ma_thanh_toan = tt.ma_thanh_toan
		WHERE pt.ma_phong_tro LIKE CONCAT('%', keyword, '%') 
		   OR nt.ten_nguoi_thue LIKE CONCAT('%', keyword, '%') 
		   OR nt.sdt_nguoi_thue LIKE CONCAT('%', keyword, '%');
end //
delimiter ;

call sp_find_all_phong_tro ('Nguyen Van A');


delimiter //
CREATE PROCEDURE sp_insert_phong_tro (
    IN p_ten_nguoi_thue VARCHAR(100),
    IN p_sdt_nguoi_thue VARCHAR(10),
    IN p_ngay_bat_dau DATE,
    IN p_ma_thanh_toan INT,
    IN p_ghi_chu VARCHAR(255)
)
BEGIN
    DECLARE v_ma_nguoi_thue INT;

    -- Kiểm tra người thuê đã tồn tại chưa (theo sdt)
    SELECT ma_nguoi_thue INTO v_ma_nguoi_thue
    FROM Nguoi_Thue
    WHERE sdt_nguoi_thue = p_sdt_nguoi_thue
    LIMIT 1;

    -- Nếu chưa tồn tại, thì insert mới
    IF v_ma_nguoi_thue IS NULL THEN
        INSERT INTO Nguoi_Thue (ten_nguoi_thue, sdt_nguoi_thue)
        VALUES (p_ten_nguoi_thue, p_sdt_nguoi_thue);
        SET v_ma_nguoi_thue = LAST_INSERT_ID();
    END IF;

    -- Thêm vào bảng Phong_Tro
    INSERT INTO Phong_Tro (ngay_bat_dau, ghi_chu, ma_nguoi_thue, ma_thanh_toan)
    VALUES (p_ngay_bat_dau, p_ghi_chu, v_ma_nguoi_thue, p_ma_thanh_toan);
END //

delimiter ;

call sp_insert_phong_tro ('Khanh', '0985409566', '2025-12-10', 3, 'khong can hoa don');