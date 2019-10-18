-- phpMyAdmin SQL Dump
-- version phpStudy 2014
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2019 年 10 月 18 日 14:32
-- 服务器版本: 5.5.53
-- PHP 版本: 5.4.45

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `exam_out`
--

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `subid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`id`, `name`, `subid`) VALUES
(1, 'Java', 1),
(2, '英语', 1);

-- --------------------------------------------------------

--
-- 表的结构 `exam`
--

CREATE TABLE IF NOT EXISTS `exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `userid` int(11) NOT NULL,
  `catid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

--
-- 转存表中的数据 `exam`
--

INSERT INTO `exam` (`id`, `name`, `userid`, `catid`) VALUES
(5, '实验1', 1, 1),
(3, 'examname', 1, 1),
(6, '作业1', 1, 1),
(7, '作业2', 1, 1),
(8, '实验1题2', 1, 1),
(9, '实验2', 1, 1);

-- --------------------------------------------------------

--
-- 表的结构 `examitems`
--

CREATE TABLE IF NOT EXISTS `examitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) NOT NULL,
  `examid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- 转存表中的数据 `examitems`
--

INSERT INTO `examitems` (`id`, `content`, `examid`) VALUES
(1, '编写HelloWorld类，要求实现在屏幕输出”HelloWorld”，请按OOP的思想把变化的部分封装起来。', 3),
(2, '创建Person类，Person的属性有Strng name姓名、String sex性别、Integer age年龄String idNo身份证号,Boolean isMerried是否已婚。请生成相应的getter、setter方法，并创建两个构造方法:Person()，Person((String idNo)，把Person编译成.class文件。请过反射技术，为Person生成相应的java代码，Java代码中的方法的方法体为空，即方法的方法体为空，即方法内部代码不用生成。请注意生成的Java代码的格式', 5),
(3, '请为第1题中Person类创建实例(对象)，并为每个属性赋值,然后采用反射技术，把创建的Person实例的属性值存入文本文件中', 5),
(4, '请采用反射技术,读取第2题生成的文本文件中的数据,把相应值赋值给一个创建的Person实例。', 5),
(5, '编写HelloWorld类，要求实现在屏幕输出”HelloWorld”，请按OOP的思想把变化的部分封装起来。', 6),
(6, '“阿里巴巴Java开发手册v1.5.0”读后感。', 6),
(7, '编写Student类，主要属性包括学号、姓名、性别、班级', 7),
(8, '编写Score类，主要属性包括：学号、课程名、分数', 7),
(9, '用 Collection 中 List 实现一个简单的学生信息管理系统。学生信息有：学号、姓名、年龄、三门课成绩等。在其上实现增删改查的操作', 8),
(10, '用 Map 实现电话簿 管理程序。根据姓名查询电话号码', 8),
(11, '实现利用 BIO 模型（传统阻塞 IO 模型）实现多用户访问,要求实现服务器与 客户端代码。提示服务器端需要多线程响应客户端请求。', 9),
(12, '实现简单 WebServer，要求服务器可以处理返回给客户单一段字符串，该字符 串信息是读取服务器文件系统的文件，文件格式可以是 XML 文件或者 txt 文件', 9);

-- --------------------------------------------------------

--
-- 表的结构 `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catid` int(11) NOT NULL,
  `content` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- 转存表中的数据 `question`
--

INSERT INTO `question` (`id`, `catid`, `content`) VALUES
(1, 1, '编写HelloWorld类，要求实现在屏幕输出”HelloWorld”，请按OOP的思想把变化的部分封装起来。'),
(2, 1, '“阿里巴巴Java开发手册v1.5.0”读后感。'),
(3, 1, '编写Student类，主要属性包括学号、姓名、性别、班级'),
(4, 1, '编写Score类，主要属性包括：学号、课程名、分数'),
(5, 1, '创建Person类，Person的属性有Strng name姓名、String sex性别、Integer age年龄String idNo身份证号,Boolean isMerried是否已婚。请生成相应的getter、setter方法，并创建两个构造方法:Person()，Person((String idNo)，把Person编译成.class文件。请过反射技术，为Person生成相应的java代码，Java代码中的方法的方法体为空，即方法的方法体为空，即方法内部代码不用生成。请注意生成的Java代码的格式'),
(6, 1, '请为第1题中Person类创建实例(对象)，并为每个属性赋值,然后采用反射技术，把创建的Person实例的属性值存入文本文件中'),
(7, 1, '请采用反射技术,读取第2题生成的文本文件中的数据,把相应值赋值给一个创建的Person实例。'),
(8, 1, '用 Collection 中 List 实现一个简单的学生信息管理系统。学生信息有：学号、姓名、年龄、三门课成绩等。在其上实现增删改查的操作'),
(9, 1, '用 Map 实现电话簿 管理程序。根据姓名查询电话号码'),
(10, 1, '实现利用 BIO 模型（传统阻塞 IO 模型）实现多用户访问,要求实现服务器与 客户端代码。提示服务器端需要多线程响应客户端请求。'),
(11, 1, '实现简单 WebServer，要求服务器可以处理返回给客户单一段字符串，该字符 串信息是读取服务器文件系统的文件，文件格式可以是 XML 文件或者 txt 文件'),
(12, 1, '多线程排序，即把数据存放在一维数组中，首先对数据进行分段，接着对每 一段数据采用经典排序算法实现排序，最后把各段数据进行合并排序。请完成 程序编写。'),
(13, 1, '多线程求数组最大值，即把数据存放在一维数组中，首先对数据进行分段， 接着对每一段数据求得最大值，最后把各段数据最大值进行比较从而得出整个 数组的最大值。请完成程序编写。'),
(14, 1, '采用线程实现“生产者-消费者”编程的基础模型。');

-- --------------------------------------------------------

--
-- 表的结构 `subject`
--

CREATE TABLE IF NOT EXISTS `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `subject`
--

INSERT INTO `subject` (`id`, `name`) VALUES
(1, '软件学院'),
(2, '外国语学院');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(30) NOT NULL,
  `subid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `subid`) VALUES
(1, 'root', 'root', 1),
(2, 'qweasd', '123456', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
