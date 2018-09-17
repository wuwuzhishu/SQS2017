-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2018-01-05 08:36:57
-- 服务器版本： 10.1.16-MariaDB
-- PHP Version: 5.6.24



--
-- Database: `StuCourse`
--

-- 教务系统
SET FOREIGN_KEY_CHECKS=0;
DROP DATABASE IF EXISTS StuCourse;
CREATE DATABASE StuCourse CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE StuCourse;

-- 用户权限表
create table usertype
(
	typeId int(10) primary key AUTO_INCREMENT,-- 自动编号
	typeName char(20) not null -- 不同用户
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into usertype(typeName) values('学生');
insert into usertype(typeName) values('教师');
insert into usertype(typeName) values('管理员');

-- 学生表
create table student
(
	stuId char(15) primary key,-- 学号
	stuName char(20) not null,-- 姓名
	stuPwd char(20) not null,-- 密码
	stuMajor char(20) not null, -- 专业
	stuBirth date, -- 生日
	typeId int(10) not null
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 教师表
create table teacher
(
	tecId char(15) primary key,-- 工号
	tecName char(20) not null,-- 姓名
	tecPwd char(20) not null,-- 密码
	tecDept char(20) not null, -- 部门
	tecBirth date, -- 生日
	typeId int(10) not null 
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 课程表
create table course
(
	courId int(10) primary key AUTO_INCREMENT,-- 课程编号
	courName char(40),-- 课程名称
	courHour int, -- 课时
	courCredit int -- 学分
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 教师授课表
create table tec_cls
(
	tcId int(10) primary key AUTO_INCREMENT,
	tecId char(15) not null,-- 工号
	courId int(10) not null-- 课程编号
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 学生选课表
create table stu_cls
(
	scId int(10) primary key AUTO_INCREMENT,
	stuId char(15) not null,-- 学号
	courId int(10) not null,-- 课程编号
	tecId char(15) not null-- 工号
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 成绩表
create table grade
(
	gradeId int(10) primary key AUTO_INCREMENT,	
	courId int(10) not null,-- 课程编号
	stuId char(15) not null,-- 学号
	tecId char(15) not null,-- 工号
	score int not null -- 成绩
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;







