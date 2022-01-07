-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2022 at 03:47 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tugas_uas`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_barang`
--

CREATE TABLE `tb_barang` (
  `kd_barang` varchar(10) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `kategori_barang` varchar(20) NOT NULL,
  `merek` varchar(50) DEFAULT NULL,
  `ukuran` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_barang`
--

INSERT INTO `tb_barang` (`kd_barang`, `nama_barang`, `kategori_barang`, `merek`, `ukuran`) VALUES
('01', 'kipas', 'Barang Electronik', 'maspion', 'besar'),
('02', 'tv', 'Barang Electronik', 'LG', '21 int'),
('03', 'AC', 'Barang Electronik', 'Sharp', '1pk');

-- --------------------------------------------------------

--
-- Table structure for table `tb_inventaris_keluar`
--

CREATE TABLE `tb_inventaris_keluar` (
  `kd_inventaris_keluar` char(15) NOT NULL,
  `kd_inventaris_masuk` char(15) NOT NULL,
  `jumlah` double NOT NULL,
  `tanggal_keluar` date DEFAULT NULL,
  `keterangan` varchar(20) NOT NULL,
  `id_user` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_inventaris_keluar`
--

INSERT INTO `tb_inventaris_keluar` (`kd_inventaris_keluar`, `kd_inventaris_masuk`, `jumlah`, `tanggal_keluar`, `keterangan`, `id_user`) VALUES
('OUT0001', 'IN0001', 1, '2022-01-07', 'diperbaiki', '01'),
('OUT0002', 'IN0002', 1, '2022-01-07', 'rusak', '01');

-- --------------------------------------------------------

--
-- Table structure for table `tb_inventaris_masuk`
--

CREATE TABLE `tb_inventaris_masuk` (
  `kd_inventaris_masuk` char(15) NOT NULL,
  `kd_barang` varchar(10) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `nilai_barang` float NOT NULL,
  `tanggal_masuk` date DEFAULT NULL,
  `id_user` varchar(10) NOT NULL,
  `kd_lokasi` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_inventaris_masuk`
--

INSERT INTO `tb_inventaris_masuk` (`kd_inventaris_masuk`, `kd_barang`, `jumlah`, `nilai_barang`, `tanggal_masuk`, `id_user`, `kd_lokasi`) VALUES
('IN0001', '01', 1, 100000, '2022-01-07', '01', '01'),
('IN0002', '03', 2, 1000000, '2022-01-07', '01', '01');

-- --------------------------------------------------------

--
-- Table structure for table `tb_lokasi`
--

CREATE TABLE `tb_lokasi` (
  `kd_lokasi` varchar(10) NOT NULL,
  `nama_lokasi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_lokasi`
--

INSERT INTO `tb_lokasi` (`kd_lokasi`, `nama_lokasi`) VALUES
('01', 'kantor'),
('02', 'kelas');

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama` varchar(35) DEFAULT NULL,
  `jenis_kelamin` varchar(20) DEFAULT NULL,
  `alamat` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `username`, `password`, `nama`, `jenis_kelamin`, `alamat`) VALUES
('01', 'rudini', 'rudini', 'Rudini', 'Laki - laki', 'Jl.Sungai Andai Blok AB');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_barang`
--
ALTER TABLE `tb_barang`
  ADD PRIMARY KEY (`kd_barang`);

--
-- Indexes for table `tb_inventaris_keluar`
--
ALTER TABLE `tb_inventaris_keluar`
  ADD PRIMARY KEY (`kd_inventaris_keluar`);

--
-- Indexes for table `tb_inventaris_masuk`
--
ALTER TABLE `tb_inventaris_masuk`
  ADD PRIMARY KEY (`kd_inventaris_masuk`,`kd_barang`);

--
-- Indexes for table `tb_lokasi`
--
ALTER TABLE `tb_lokasi`
  ADD PRIMARY KEY (`kd_lokasi`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
