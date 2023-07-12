# Musinsa-Task

# 해당 프로젝트를 리눅스 기준으로 실행하기 위해 필요한 설치/빌드 방법
1. 자바8 설치
   명령어 sudo apt install openjdk-8-jdk-headless
2. 프로젝트 빌드
   프로젝트 폴더로 이동 한 후 ./gradlew build 명령어 실행
   -> 자바 파일(jar) 생성
4. build/libs 폴더로 이동 후 생성된 자바 파일 실행
   ex)
   build/libs 폴더에서
   sudo java -jar musinsa-0.0.1.jar 명령어로 자바 파일 실행 (musinsa-0.0.1.jar 는 예시 파일명입니다.)

# mariaDB 스키마

-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        11.2.0-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.3.0.6589
-- --------------------------------------------------------


-- musinsa_global 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `musinsa_global` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `musinsa_global`;

-- 테이블 musinsa_global.tb_sys_banner 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_sys_banner` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '배너_id',
  `image` varchar(50) DEFAULT NULL COMMENT '배너_이미지',
  `text` varchar(50) DEFAULT NULL COMMENT '배너_텍스트',
  `url` varchar(50) DEFAULT NULL COMMENT '배너_url',
  `banner_order` int(11) DEFAULT NULL COMMENT '배너_순서',
  `regist_dt` datetime DEFAULT NULL COMMENT '등록일자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='시스템_배너_테이블';

-- 테이블 데이터 musinsa_global.tb_sys_banner:~1 rows (대략적) 내보내기
INSERT INTO `tb_sys_banner` (`id`, `image`, `text`, `url`, `banner_order`, `regist_dt`) VALUES
	(16, '0c531679-0fc8-4153-a1b8-3a689169f148.png', '첫 배너', 'http://hellojhworld.shop', 2, '2023-07-10 17:54:02');

-- 테이블 musinsa_global.tb_sys_menu 구조 내보내기
CREATE TABLE IF NOT EXISTS `tb_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '메뉴_id',
  `menu_nm` varchar(20) NOT NULL COMMENT '메뉴_명',
  `url` varchar(50) DEFAULT NULL COMMENT '메뉴_url',
  `level` int(11) NOT NULL COMMENT '메뉴_레벨',
  `menu_order` int(11) NOT NULL COMMENT '메뉴_순서',
  `parent_id` int(11) unsigned zerofill DEFAULT NULL COMMENT '부모_id',
  `parent_type` varchar(20) DEFAULT NULL COMMENT '상위_타입',
  `child_type` varchar(20) DEFAULT NULL COMMENT '하위_타입',
  `regist_dt` datetime DEFAULT NULL COMMENT '등록일자',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='시스템_메뉴_테이블';

-- 테이블 데이터 musinsa_global.tb_sys_menu:~11 rows (대략적) 내보내기
INSERT INTO `tb_sys_menu` (`id`, `menu_nm`, `url`, `level`, `menu_order`, `parent_id`, `parent_type`, `child_type`, `regist_dt`) VALUES
	(1, '상의', NULL, 1, 1, 00000000000, 'TOP', NULL, '2023-07-12 17:18:01'),
	(2, '하의', NULL, 1, 2, 00000000000, 'PANTS', NULL, '2023-07-12 17:18:01'),
	(3, '반팔', NULL, 2, 1, 00000000001, 'TOP', 'SHORT_SLEEVE', '2023-07-12 17:18:01'),
	(4, '긴팔', NULL, 2, 2, 00000000001, 'TOP', 'LONG_SLEEVE', '2023-07-12 17:18:01'),
	(5, '면바지', NULL, 2, 1, 00000000002, 'PANTS', 'COTTON_PANTS', '2023-07-12 17:18:01'),
	(6, '청바지', NULL, 2, 2, 00000000000, 'PANTS', 'DENIM_PANTS', '2023-07-12 17:18:01'),
	(7, '슬랙스', NULL, 2, 3, 00000000002, 'PANTS', 'SLACKS', '2023-07-12 17:18:01'),
	(26, '신발', '', 1, 3, 00000000000, 'SHOSE', '', '2023-07-12 17:18:01'),
	(29, '스니커즈', '', 2, 1, 00000000026, 'SHOSE', 'SNEAKERS', '2023-07-12 17:49:37'),
	(30, '로퍼', '', 2, 2, 00000000026, 'SHOSE', 'LOAFERS', '2023-07-12 17:50:45'),
	(31, '샌들', '', 2, 3, 00000000026, 'SHOSE', 'SANDAL', '2023-07-12 17:51:24');


