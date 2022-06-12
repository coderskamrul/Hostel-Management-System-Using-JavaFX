-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 12, 2022 at 02:20 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hostel`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `mobileNo` varchar(20) NOT NULL,
  `name` varchar(40) NOT NULL,
  `father` varchar(40) NOT NULL,
  `mother` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `address` varchar(40) NOT NULL,
  `idNo` varchar(40) NOT NULL,
  `designation` varchar(40) NOT NULL,
  `status` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`mobileNo`, `name`, `father`, `mother`, `email`, `address`, `idNo`, `designation`, `status`) VALUES
('123456789', 'Akksa Ali', 'Koddus', 'lolsum', 'Akksa@gmail.com', 'dhaka', '123', 'Cook', 'Not Working');

-- --------------------------------------------------------

--
-- Table structure for table `fees`
--

CREATE TABLE `fees` (
  `mobileNo` varchar(20) NOT NULL,
  `month` varchar(50) NOT NULL,
  `amount` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `fees`
--

INSERT INTO `fees` (`mobileNo`, `month`, `amount`) VALUES
('01871070499', '11-2021', '7000');

-- --------------------------------------------------------

--
-- Table structure for table `hmd`
--

CREATE TABLE `hmd` (
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hmd`
--

INSERT INTO `hmd` (`name`, `email`) VALUES
('trhyjytg', 'tyujgtujt'),
('hmd kamrul', 'kamrul@gmail.com'),
('yutgy', 'gjuyui');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `mobileNo` varchar(40) NOT NULL,
  `month` varchar(40) NOT NULL,
  `amount` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`mobileNo`, `month`, `amount`) VALUES
('123456789', '12-2021', '12000');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `number` varchar(10) NOT NULL,
  `activate` varchar(50) NOT NULL,
  `roomstatus` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`number`, `activate`, `roomstatus`) VALUES
('101', 'Yes', 'Bocked'),
('111', 'No', 'Bocked'),
('112', 'Yes', 'Not Bocked'),
('222', 'Yes', 'Not Bocked');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `mobileNo` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `father` varchar(200) NOT NULL,
  `mother` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `address` varchar(100) NOT NULL,
  `collage` varchar(100) NOT NULL,
  `idNo` varchar(50) NOT NULL,
  `roomNo` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`mobileNo`, `name`, `father`, `mother`, `email`, `address`, `collage`, `idNo`, `roomNo`, `status`) VALUES
('01635499808', 'Hmd Kamrul', 'Belayet Hossain', 'Rokeya Begum', 'mdkamrul2058@gmail.com', 'Cumilla', 'IUBAT', '20103178', '101', 'living'),
('01871070499', 'Shariful Islam', 'aaaaa', 'bbbbbb', 'Shariful@gmail.com', 'laksham', 'iubat', '20103153', '112', 'leaved');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`mobileNo`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`number`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`mobileNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
