-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13 Des 2018 pada 13.11
-- Versi Server: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_gr`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `gedung`
--

CREATE TABLE `gedung` (
  `kd_gedung` varchar(10) NOT NULL,
  `nm_gedung` varchar(255) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `longitude` varchar(20) NOT NULL,
  `photo_gedung` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `gedung`
--

INSERT INTO `gedung` (`kd_gedung`, `nm_gedung`, `latitude`, `longitude`, `photo_gedung`) VALUES
('AF1', 'Gedung AF lt.1', '-7.946534 ', '112.615122', 'af.jpg\r\n'),
('AF2', 'Gedung AF lt.2', '-7.946534', '112.615122', 'af.jpg'),
('AF3', 'Gedung AF lt.3', '-7.946534 ', '112.615122', 'af.jpg'),
('SITI7', 'Gedung Sipil lt.7', '-7.943915', '112.614565', 'siti.jpg'),
('SITI8', 'Gedung Sipil lt.8', '-7.943915', '112.614565', 'sipil.jpg\r\n');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ruangan`
--

CREATE TABLE `ruangan` (
  `kd_ruangan` varchar(10) NOT NULL,
  `nm_ruangan` varchar(255) NOT NULL,
  `kd_gedung` varchar(10) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `longitude` varchar(20) NOT NULL,
  `photo_ruangan` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ruangan`
--

INSERT INTO `ruangan` (`kd_ruangan`, `nm_ruangan`, `kd_gedung`, `latitude`, `longitude`, `photo_ruangan`) VALUES
('KB.01', 'Kelas Besar 01\r\n', 'AF3', '-7.946534 ', '112.615122', 'kb01.jpg'),
('KB.02', 'Kelas Besar 02\r\n', 'SITI7', '-7.943915', '112.614565', 'kb02.jpg'),
('KB.03', 'Kelas Besar 03\r\n', 'AF3', '-7.943915', '112.614565', 'kb03.jpg'),
('KB.04', 'Kelas Besar 04\r\n', 'SITI8', '-7.943915', '112.614565', 'kb04.jpg\r\n'),
('KB.05', 'Kelas Besar 05\r\n', 'SITI8', '-7.943915', '112.614565', 'kb05.jpg'),
('KR.01', 'Kelas Reguler 01', 'AF1', '-7.946534', '112.615122', 'kr01.jpg'),
('KR.02', 'Kelas Reguler 02', 'AF1', '-7.946534 ', '112.615122', 'kr02.jpg\r\n'),
('KR.03', 'Kelas Reguler 03\r\n', 'AF2', '-7.946534', '112.615122', 'kr03.jpg'),
('KR.04', 'Kelas Reguler 04', 'AF2', '-7.946534 ', '112.615122', 'kr04.jpg\r\n'),
('KR.05', 'Kelas Reguler 05\r\n', 'AF3', '-7.946534', '112.615122', 'kr05.jpg'),
('KR.06', 'Kelas Reguler 06\r\n', 'AF3', '-7.946534 ', '112.615122', 'kr06.jpg\r\n'),
('KR.07', 'Kelas Reguler 07\r\n', 'SITI7', '-7.943915', '112.614565', 'kr07.jpg'),
('LBD.01', 'Lab Basis Data 01\r\n', 'AF1', '-7.946534 ', '112.615122', 'lbd01jpg'),
('LID.01', 'Lab Informatika Dasar 01\r\n', 'SITI7', '-7.943915', '112.614565', 'lid01.jpg'),
('LID.02', 'Lab Informatika Dasar 02\r\n', 'SITI7', '-7.943915', '112.614565', 'lid.02'),
('LIG.01', 'Lab Image dan Grafis 01\r\n', 'SITI7', '-7.943915', '112.614565', 'lig01.jpg'),
('LKJ.01', 'Lab Komputer dan Jaringan 01\r\n', 'SITI7', '-7.943915', '112.614565', 'lkj01.jpg'),
('LKJ.02', 'Lab Komputer dan Jaringan 02\r\n', 'SITI7', '-7.943915', '112.614565', 'lkj02.jpg'),
('LKJ.03', 'Lab Komputer dan Jaringan 03\r\n', 'SITI7', '-7.943915', '112.614565', 'lkj03.jpg'),
('LPJ.01', 'Lab Pemrograman Jaringan 01\r\n', 'SITI7', '-7.943915', '112.614565', 'lpj01.jpg'),
('LPJ.02', 'Lab Pemrograman Jaringan 02\r\n', 'SITI7', '-7.943915', '112.614565', 'lpj02.jpg'),
('LPJ.03', 'Lab Pemrograman Jaringan 03\r\n', 'SITI7', '-7.943915', '112.614565', 'lpj03.jpg'),
('LPJ.04', 'Lab Pemrograman Jaringan 04\r\n', 'AF1', '-7.946534 ', '112.615122', 'lpj04.jpg'),
('LPR.01', 'Lab Pemrograman 01\r\n', 'SITI7', '-7.943915', '112.614565', 'lpr01.jpg'),
('LPR.02', 'Lab Pemrograman 02\r\n', 'SITI7', '-7.943915', '112.614565', 'lpr02.jpg'),
('LPR.03', 'Lab Pemrograman 03\r\n', 'SITI7', '-7.943915', '112.614565', 'lpr03.jpg'),
('LPR.04', 'Lab Pemrograman 04\r\n', 'SITI7', '-7.943915', '112.614565', 'lpr04.jpg'),
('LPR.05', 'Lab Pemrograman 05\r\n', 'AF3', '-7.943915', '112.614565', 'lpr05.jpg'),
('LPR.06', 'Lab Pemrograman 06\r\n', 'AF1', '-7.946534', '112.615122', 'lpr06.jpg'),
('LSI.01', 'Lab Sistem Informasi 01\r\n', 'AF1', '-7.946534 ', '112.615122', 'lsi01.jpg'),
('MKU', 'Ruang Dosen Mata Kuliah Umum\r\n', 'AF1', '-7.946534 ', '112.615122', 'mku.jpg'),
('PS', 'Puskom\r\n', 'AF3', '-7.946534 ', '112.615122', 'ps.jpg'),
('R.B', 'Ruang Baca\r\n', 'AF3', '-7.946534 ', '112.615122', 'rb.jpg'),
('R.D1', 'Ruang Dosen Lantai 1\r\n', 'AF1', '-7.946534 ', '112.615122', 'rd1.jpg'),
('R.D2', 'Ruang Dosen 01\r\n', 'AF2', '-7.946534 ', '112.615122', 'rd2.jpg'),
('R.D3', 'Ruang Dosen 02\r\n', 'AF2', '-7.946534 ', '112.615122', 'rd3.jpg'),
('R.D4', 'Ruang Dosen 03\r\n', 'AF2', '-7.946534 ', '112.615122', 'rd04.jpg'),
('R.D5', 'Ruang Dosen Sipil\r\n', 'SITI7', '-7.943915', '112.614565', 'rd05.jpg'),
('R.J', 'Ruang Jurusan\r\n', 'AF2', '-7.946534 ', '112.615122', 'rj.jpg'),
('R.KPS', 'Ruang Admin dan Dosen\r\n', 'AF2', '-7.946534 ', '112.615122', 'rkps.jpg'),
('R.R', 'Ruang Rapat\r\n', 'AF1', '-7.946534 ', '112.615122', 'rr.jpg'),
('R.T', 'Ruang Teleconference\r\n', 'AF3', '-7.946534 ', '112.615122', 'rt.jpg'),
('R.TK1', 'Ruang Teknisi AF\r\n', 'AF1', '-7.946534 ', '112.615122', 'rtk01.jpg'),
('R.TK2', 'Ruang Teknisi Sipil \r\n', 'SITI7', '-7.943915', '112.614565', 'rtk02.jpg');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `nama_user` varchar(100) NOT NULL,
  `telpon` varchar(13) NOT NULL,
  `photo_user` varchar(255) NOT NULL,
  `level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama_user`, `telpon`, `photo_user`, `level`) VALUES
(4, '1641720207\r\n', '1641720207', 'Abd. Aziz Su\'ud\r\n', '1641720207', 'usr.jpg', 'member'),
(5, '1641720093\r\n', '1641720093', 'Ahmad Illyasa\r\n', '1641720093', 'usr.jpg', 'member'),
(6, '1641720165\r\n', '1641720165', 'Akbar Formadika\r\n', '1641720165', 'usr.jpg', 'member'),
(7, '1641720034\r\n', '1641720034', 'Dikky Awan Nugroho\r\n', '1641720034', 'usr.jpg', 'member'),
(8, '1641720055\r\n', '1641720055', 'Dikta Afif Rahman Praseyo\r\n', '1641720055', 'usr.jpg', 'member'),
(9, '1641720210\r\n', '1641720210', 'Dimas Hariyanto\r\n', '1641720210', 'usr.jpg', 'member'),
(10, '1641720004\r\n', '1641720004', 'Faisal Apilian\r\n', '1641720004', 'usr.jpg', 'member'),
(11, '1641720202\r\n', '1641720202', 'Ferdy Yan Fitrah Tismanto\r\n', '1641720202', 'usr.jpg', 'member'),
(12, '1741723011\r\n', '1741723011', 'Galang Ganesa Perkasa\r\n', '1741723011', 'usr.jpg', 'member'),
(13, '1641720084\r\n', '1641720084', 'Hendra Permana Sasmita\r\n', '1641720084', 'usr.jpg', 'member'),
(14, '1641720006\r\n', '1641720006', 'Kris Widyo Febyanti\r\n', '1641720006', 'usr.jpg', 'member'),
(15, '1641720175\r\n', '1641720175', 'Mardiana Purti Sasmita\r\n', '1641720175', 'usr.jpg', 'member'),
(16, '1641720136\r\n', '1641720136', 'Mas Sulistyo Habib Rianto\r\n', '1641720136', 'usr.jpg', 'member'),
(17, '1641720011\r\n', '1641720011', 'Mochammad Feriyal Indra Rukaman\r\n', '1641720011', 'usr.jpg', 'member'),
(18, '1641720172\r\n', '1641720172', 'Moh. Ilbad Dzulfadli\r\n', '1641720172', 'usr.jpg', 'member'),
(19, '1641720039\r\n', '1641720039', 'Muhammad Dio Syahrizal\r\n', '1641720039', 'usr.jpg', 'member'),
(20, '1641720061\r\n', '1641720061', 'Muhammad Rizky SP\r\n', '1641720061', 'usr.jpg', 'member'),
(21, '1641720079\r\n', '1641720079', 'Nita Rahmawati Komalasari\r\n', '1641720079', 'usr.jpg', 'member'),
(22, '1641720181\r\n', '1641720181', 'Okky Bagus Baitis Tuta\r\n', '1641720181', 'usr.jpg', 'member'),
(23, '1741723006\r\n', '1741723006', 'Piping Adel Wijaya Putri Yacobus\r\n', '1741723006', 'usr.jpg', 'member'),
(24, '1641720133\r\n', '1641720133', 'Ricky Octavian Wahyudi\r\n', '1641720133', 'usr.jpg', 'member'),
(25, '1641720132\r\n', '1641720132', 'Rizky Firmansyah\r\n', '1641720132', 'usr.jpg', 'member'),
(26, '1641720104\r\n', '1641720104', 'Ryan Fitra Fathony\r\n', '1641720104', 'usr.jpg', 'member'),
(27, '1641720170\r\n', '1641720170', 'Sheyba Adinda Azigita\r\n', '1641720170', 'usr.jpg', 'member'),
(28, '1641720067\r\n', '1641720067', 'Siti Kholifah\r\n', '1641720067', 'usr.jpg', 'member'),
(29, '1641720026\r\n', '1641720026', 'Syilvia Windy Kharisma Putri\r\n', '1641720026', 'usr.jpg', 'member'),
(30, '1641720075\r\n', '1641720075', 'Mardiana Purti Sasmita\r\n', '1641720075', 'usr.jpg', 'member'),
(31, '1641720022\r\n', '1641720022', 'Yahya Dwi Pradika\r\n', '1641720022', 'usr.jpg', 'member');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `gedung`
--
ALTER TABLE `gedung`
  ADD PRIMARY KEY (`kd_gedung`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`kd_ruangan`),
  ADD KEY `kd_gedung` (`kd_gedung`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `ruangan`
--
ALTER TABLE `ruangan`
  ADD CONSTRAINT `ruangan_ibfk_1` FOREIGN KEY (`kd_gedung`) REFERENCES `gedung` (`kd_gedung`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
