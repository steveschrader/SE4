-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 11, 2015 at 02:41 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `pajotters15`
--

-- --------------------------------------------------------

--
-- Table structure for table `partijen`
--

CREATE TABLE IF NOT EXISTS `partijen` (
`id` int(11) NOT NULL,
  `voornaam` varchar(80) DEFAULT NULL,
  `familienaam` varchar(80) DEFAULT NULL,
  `emailadres` varchar(120) DEFAULT NULL,
  `paswoord` varchar(90) DEFAULT NULL,
  `status` varchar(40) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `partijen`
--

INSERT INTO `partijen` (`id`, `voornaam`, `familienaam`, `emailadres`, `paswoord`, `status`) VALUES
(1, 'testje', 'test', 'test@test.be', 'testjedsze', 'Actief'),
(3, 'dgfdsgd', 'dsfsdjk', 'mdslkjgmsqj@lmskjd.be', 'mdjsfmdsjfmkjdglm', 'actief'),
(4, 'df', 'sdf', 'sdsf@sdfs.be', 'sdfsdfdsg', 'actief'),
(5, 'new', 'new', 'new@new.be', 'msdfjkdsfds', 'actief'),
(6, 'dmsljkfk', 'mlfdjsm', 'sdljmjl@mkj.be', 'mqkdjfmdsjflmdj', 'actief'),
(7, 'kjdskljfd', 'dlmskjfm', 'mdsj@lmksdjfm.be', 'mjdsmlfjsldm', 'actief'),
(8, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(9, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(10, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(11, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(12, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(13, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(14, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(15, 'fds', 'dsgds', 'gdsf@dsg.be', 'dsopfmjlmd', 'actief'),
(16, 'dsf', 'dsg', 's@s.be@s@', 'mdlkjfmlds', 'actief'),
(17, 'dsf', 'dsg', 's@s.be@s@', 'mdlkjfmlds', 'actief');

-- --------------------------------------------------------

--
-- Table structure for table `rollen`
--

CREATE TABLE IF NOT EXISTS `rollen` (
`id` int(11) NOT NULL,
  `partij_id` int(11) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  `usernaam` varchar(90) DEFAULT NULL,
  `type` varchar(60) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `rollen`
--

INSERT INTO `rollen` (`id`, `partij_id`, `status`, `usernaam`, `type`) VALUES
(1, 1, '1', 'testusername', 'Administrator'),
(2, 3, 'test', 'test3', 'Pajotter');

-- --------------------------------------------------------

--
-- Table structure for table `telers`
--

CREATE TABLE IF NOT EXISTS `telers` (
`id` int(11) NOT NULL,
  `familienaam` varchar(30) NOT NULL,
  `voornaam` varchar(30) NOT NULL,
  `emailadres` varchar(100) NOT NULL,
  `paswoord` varchar(100) NOT NULL,
  `status` varchar(40) NOT NULL,
  `adres` varchar(200) DEFAULT NULL,
  `telefoon` varchar(30) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=18 ;

--
-- Dumping data for table `telers`
--

INSERT INTO `telers` (`id`, `familienaam`, `voornaam`, `emailadres`, `paswoord`, `status`, `adres`, `telefoon`) VALUES
(4, 'schrader', 'steve', 'steve@steve.be', 'steve', 'actief', 'Tubize', '039493030'),
(10, 'dedobbeleer', 'stef', 'stef@stef', 'dklmsfjdmglkjd', 'Actief', 'sdfmj', 'sdmklfj'),
(11, 'Behaeghe', 'Ben ', 'ben@ben', 'gdsf', 'Actief', 'dfd', 'dsf'),
(16, 'Anders', 'Iemand BEN', 'ieq@aa.ezel', 'ieaa', 'Actief', 'stal', 'qqqqqqqqq'),
(17, 'tdfdsgd', 'test', 'Het word geupdate :OO !!!', 't', 'Actief', 't', 't');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `partijen`
--
ALTER TABLE `partijen`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rollen`
--
ALTER TABLE `rollen`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `telers`
--
ALTER TABLE `telers`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `partijen`
--
ALTER TABLE `partijen`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `rollen`
--
ALTER TABLE `rollen`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `telers`
--
ALTER TABLE `telers`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
