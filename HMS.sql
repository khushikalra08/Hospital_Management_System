create database hospital_management_system;
use hospital_management_system;


create table login(ID varchar(20), PW varchar(20));
select * from login;
insert into login value("medicare", "123456789");


create table patient_info(ID varchar(20), Number varchar(40), Name varchar(20), Gender varchar(20), Patient_Disease varchar(20), Room_Number varchar(20), Time varchar(100), Deposite varchar(20));
select * from patient_info;


create table Room(Room_no varchar(20), Availability varchar(20), Price varchar(20), Room_Type varchar(100));
select * from Room;
insert into Room values("100","Available","500","G Bed 1");
insert into Room values("101","Available","500","G Bed 2");
insert into Room values("102","Available","500","G Bed 3");
insert into Room values("103","Available","500","G Bed 4");
insert into Room values("200","Available","1500","Private Room");
insert into Room values("201","Available","1500","Private Room");
insert into Room values("202","Available","1500","Private Room");
insert into Room values("203","Available","1500","Private Room");
insert into Room values("300","Available","3500","ICU Bed 1");
insert into Room values("301","Available","3500","ICU Bed 2");
insert into Room values("302","Available","3500","ICU Bed 3");
insert into Room values("303","Available","3500","ICU Bed 4");
insert into Room values("304","Available","3500","ICU Bed 5");
insert into Room values("305","Available","3500","ICU Bed 6");


create table department(Department varchar(100), Phone_no varchar(20));
select * from department;
insert into department values("Surgical department", "123456789");
insert into department values("Nursing department", "123456789");
insert into department values("Operation Theater Complex (OT)", "123456789");
insert into department values("Paramedical department", "123456789");


create table EMP_INFO(Name varchar(20), Age varchar(20), Phone_Number varchar(20), salary varchar(20), Gmail varchar(20), Aadhar_Number varchar(20));
select * from EMP_INFO;
insert into EMP_INFO values("Doctor1","30","123456789","50000","ABC@gmail.com","123456839421");
insert into EMP_INFO values("Doctor2","34","123456749","35000","XYZ@gmail.com","123454537829");


create table Ambulance(Name varchar(20), Gender varchar(20), Car_name varchar(20), Available varchar(20), Location varchar(20));
insert into Ambulance values("Mansi", "Female","ZEN", "Available", "Area 16");
select * from Ambulance;


