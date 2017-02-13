-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2016 at 02:57 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

CREATE DATABASE iseq;
USE iseq;


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `iseq`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `getCompanyByID`(IN `companyID` INT(5))
    READS SQL DATA
Select * FROM prices WHERE companynum = companyID$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `prices`
--

CREATE TABLE IF NOT EXISTS `prices` (
`companynum` int(11) NOT NULL,
  `Company` text NOT NULL,
  `Current_Price` decimal(10,5) NOT NULL,
  `Yesterdays_Price` decimal(10,5) NOT NULL,
  `Shares_Traded_Yesterday` int(11) NOT NULL,
  `Yearly_Low` decimal(10,5) NOT NULL,
  `Yearly_High` decimal(10,5) NOT NULL,
  `Listing_Date` date NOT NULL,
  `image` text NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=98580 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prices`
--

INSERT INTO `prices` (`companynum`, `Company`, `Current_Price`, `Yesterdays_Price`, `Shares_Traded_Yesterday`, `Yearly_Low`, `Yearly_High`, `Listing_Date`, `image`) VALUES
(6, 'Aer Lingus', '2.94078', '0.62000', 56, '0.74000', '0.99000', '2013-01-16', '6.jpg'),
(7, 'Abbey', '0.59049', '2.00000', 3, '2.00000', '4.00000', '2013-01-16', '7.jpg'),
(8, 'C&C', '8.81614', '3.09000', 898, '2.10000', '3.19000', '1976-06-22', '8.jpg'),
(11, 'Cpl Resources', '7.21840', '2.51000', 462, '1.54000', '2.62000', '1977-10-27', '11.jpg'),
(12, 'Crh', '1.00000', '1.30000', 4, '0.01000', '1.09000', '1982-04-06', '12.jpg'),
(13, 'Datalex', '0.02612', '0.37000', 0, '0.60000', '1.47000', '1990-08-27', '13.jpg'),
(15, 'Diageo', '3179.57032', '15.41000', 3245, '13.43000', '14.51000', '1995-12-10', '15.jpg'),
(17, 'Dragon Oil Plc', '16.03452', '5.62000', 543, '4.64000', '5.72000', '1987-12-12', '17.jpg'),
(18, 'Elan Corporation', '31.09897', '10.34000', 453, '9.91000', '10.99000', '2001-01-12', '18.jpg'),
(19, 'Fbd Holdings', '20.39980', '6.56000', 3453, '6.16000', '7.24000', '1992-02-10', '19.jpg'),
(20, 'First Derivatives', '16.12013', '5.65000', 567, '4.66000', '5.74000', '1999-07-22', '20.jpg'),
(21, 'Fyffes', '1.38000', '1.38000', 1, '0.60000', '0.88000', '2011-08-10', '21.jpg'),
(22, 'Glanbias', '13.98029', '4.90000', 234, '3.91000', '5.00000', '1998-10-17', '22.jpg'),
(25, 'Greencore', '1.79747', '0.63000', 234, '0.35000', '0.72000', '1990-05-31', '25.jpg'),
(27, 'Ifg Group', '2.85313', '1.00000', 234, '0.01000', '1.09000', '1989-03-05', '27.jpg'),
(28, 'Independent News & Media', '0.59916', '0.45000', 45, '0.77000', '0.89120', '2005-12-13', '28.jpg'),
(29, 'Irish Continental Group', '41.45580', '14.53000', 35, '13.54000', '14.62000', '2012-01-23', '29.jpg'),
(30, 'Irish Life & Permanent', '0.57070', '0.02000', 89, '0.96000', '0.99000', '2000-01-05', '30.jpg'),
(32, 'Karelian Diamond Resources', '0.57070', '0.02000', 784, '0.60000', '0.89200', '2010-03-24', '32.jpg'),
(33, 'Kenmare Resources', '1.71188', '0.60000', 42, '0.37000', '0.70000', '2010-01-04', '33.jpg'),
(34, 'Kerry Group', '81.71326', '28.64000', 568, '27.65000', '28.73000', '1988-03-09', '34.jpg'),
(35, 'Kingspan Group', '18.74499', '6.78000', 90, '5.58000', '6.67000', '2002-04-09', '35.jpg'),
(36, 'Merrion Pharmaceuticals', '0.48505', '0.34000', 32, '0.81000', '1.26000', '2003-08-19', '36.jpg'),
(37, 'Origin Enterprises', '8.98732', '3.56000', 342, '2.16000', '3.24000', '2000-01-31', '37.jpg'),
(38, 'Ormonde Mining', '1.28533', '0.56000', 432, '0.69000', '0.87000', '2002-09-22', '38.jpg'),
(39, 'Ovoca Gold', '0.88448', '0.81000', 7897, '0.67000', '0.94000', '1988-09-22', '39.jpg'),
(16, 'GREAT WESTERN MINING CORPORATION PLC - ESM', '0.48510', '0.29800', 5, '0.20800', '0.89120', '2014-05-01', '16.jpg'),
(14, 'TESCO PLC', '16.36000', '16.36000', 0, '16.30000', '16.36000', '2002-01-08', '14.jpg'),
(10, 'GREEN REIT PLC', '4.14000', '5.46000', 5, '3.33600', '4.14000', '1990-06-06', '10.jpg'),
(9, 'Gator Products', '0.29800', '0.29800', 0, '0.20800', '0.30010', '1998-11-11', '9.jpg'),
(40, 'Readymix', '0.08558', '0.03000', 345, '0.95000', '0.99200', '2012-01-09', '40.jpg'),
(41, 'Ryanair Holdings', '11.15568', '3.91000', 435, '2.92000', '4.00000', '2005-06-14', '41.jpg'),
(42, 'Siteserv Plc', '0.02852', '0.01000', 982, '0.97000', '0.11000', '1976-11-26', '42.jpg'),
(43, 'Smurfit Kappa Group', '14.23707', '4.99000', 9037, '4.00000', '5.09000', '1994-04-01', '43.jpg'),
(45, 'Tullow Oil', '17.11000', '17.99000', 21, '16.13000', '17.21000', '2004-05-12', '45.jpg'),
(46, 'United Drug Plc', '2.08000', '1.00000', 29, '1.09000', '2.17000', '2001-03-07', '46.jpg'),
(49, 'Utv Media', '1.15000', '1.12000', 23, '0.16000', '1.24000', '1998-03-30', '49.jpg'),
(47, 'Zamano Plc', '28.79163', '0.55000', 91, '0.93000', '0.14000', '2005-05-17', '47.jpg'),
(1, 'Bank Of Ireland', '1.05200', '1.05100', 2, '1.05100', '1.12100', '1985-03-07', '1.jpg'),
(2, 'Aviva', '45.33000', '31.62000', 12, '1.15000', '5.63000', '1991-05-04', '1.jpeg'),
(3, 'Conroy Diamonds and Gold', '1.05553', '15.36000', 0, '15.23000', '15.36000', '2011-04-06', '3.jpg'),
(4, 'Eircom', '1.05553', '15.36000', 0, '15.78000', '14.03000', '2008-11-18', '4.jpg'),
(5, 'Gartmore Irish Growth Fund', '1.05200', '1.05100', 2, '1.05100', '1.12100', '1985-03-07', '5.jpg'),
(23, 'FASTNET OIL & GAS PLC - ESM', '4.55600', '5.36000', 0, '5.36000', '5.36000', '2014-11-10', '23.jpg'),
(24, 'HIBERNIA REIT PLC', '0.70700', '0.98000', 5, '0.20800', '0.89120', '1990-06-06', '24.jpg'),
(26, 'PRIME ACTIVE CAPITAL PLC - ESM', '3.60000', '3.52000', 0, '18.36000', '24.00000', '2000-03-16', '26.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `prices`
--
ALTER TABLE `prices`
 ADD PRIMARY KEY (`companynum`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `prices`
--
ALTER TABLE `prices`
MODIFY `companynum` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=98580;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
