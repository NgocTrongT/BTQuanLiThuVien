create database quanlythuvien
go
use quanlythuvien
go
create table BangQuanTri
(
	MaNV char(5) not null primary key,
	Hoten nvarchar(50) not null,
	Ngaysinh char(10) not null,
	Gioitinh nvarchar(3) null,
	Chucvu nvarchar(15) null,
	Diachi nvarchar(100) null,
	tkNV char(20) not null,
	mkNV char(20) not null
)
insert into BangQuanTri
	values('NV01',N'Nguyễn Văn Tuấn','20/11/1998',N'Nam',N'Thủ thư',N'Đà Nẵng','nvtuan','1'),
		  ('NV02',N'Phạm Văn Minh','15/11/1996',N'Nam',N'Thủ thư',N'Đà Nẵng','nvminh','1'),
		  ('NV03',N'Nguyễn Ngọc Minh Anh','24/02/1995',N'Nữ',N'Thủ thư',N'Đà Nẵng','nmanh','1'),
		  ('NV04',N'Nguyễn Thị Diễm Quỳnh','03/11/1998',N'Nữ',N'Thủ kho',N'Đà Nẵng','ndquynh','1'),
		  ('NV05',N'Nguyễn Văn Anh','24/05/1997',N'Nam',N'Thủ kho',N'Đà Nẵng','nvanh','1');
create table LoaiSach
(
	Maloai char(10) not null primary key,
	Tenloai nvarchar(20) null 
	)
insert into LoaiSach
	values('S001',N'sách giáo khoa'),
		  ('S002',N'sách giáo trinh'),
		  ('S003',N'sách bài tập'),
		  ('S004',N'sách giải bài tâp'),
		  ('S005',N'truyện');

create table NhaXuatBan
(
	MAXB char(5) primary key,
	TenXB char(20) ,
	Diachi nvarchar(100) null
	
)
insert into NhaXuatBan
	values('BGD','Bo GD-DT',N'Hà Nội'),
		  ('HDQG','Đai hoc Quoc gia',N'Hà Nội'),
		  ('KD','Kim Dong',N'Hà Nội');
create table Sach
(
	Masach char(10) not null primary key,
	Tensach nvarchar(50) not null ,
	Tacgia nvarchar(20) ,
	TenXB nvarchar(20),
	NamXB int,
	Sotrang int,
	Gia int,
	Maloai char(10),
	
)
 insert into Sach
	values('TCC1',N'Toán cao cấp 1', N'Phạm Văn Bình',N'Đại Học Quốc Gia',1998,100,89000,'S002' ),
		  ('TCC2',N'Toán cao cấp 2', N'Phạm Văn Bình',N'Đại Học Quốc Gia',1998,100,49000,'S002' );

create table TheDocgia
(
	Mathe char(5) not null primary key,
	Hoten nvarchar(50) not null ,
	Ngaycap date,
	Ngayhethan date,
	Diachi nvarchar(100) null,
	tk char(20) null,
	mk char(20) null
)

insert into TheDocgia
	values('DG01',N'Nguyễn Văn Nam','11/11/2020','11/11/2020',N'Đà Nẵng','vnam', '1'),
		  ('DG02',N'Nguyễn Văn Nhân','11/11/2020','11/11/2020',N'Đà Nẵng','vnhan', '1');
create table TheoDoiMuonTra
(
	Mathe char(5) primary key,
	Hoten nvarchar(50) not null,
	Ngaymuon char(20),
	Ngayhentra char(20),
	Ngaytra char(20),
	Masachmuon char not null,
	Maschluongtra char not null
)
create table Docgia
(
	MaDocgia char(5) not null primary key,
	Tendocgia nvarchar(50) not null ,
	Tendangnhap nvarchar(50),
	Matkhau varchar(20),
	Namsinh nvarchar(100) null,
	Gioitinh nvarchar(10) null,
	Lop nvarchar(20) null
)

insert into Docgia
	values('MDG01',N'Nguyễn Văn Nam','NguyenNam','12345','2002',N'Nam', '20T1'),
		  ('MDG02',N'Nguyễn Văn Nhân','NguyenNhan','23456',N'2001',N'Nam', '21D2');