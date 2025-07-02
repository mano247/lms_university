-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lms_projekat_database
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fakultet`
--

DROP TABLE IF EXISTS `fakultet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fakultet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `univerzitet_id` bigint NOT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `dekan` varchar(255) DEFAULT NULL,
  `kontakt` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `slika` varchar(255) DEFAULT NULL,
  `tekstualni_opis` longtext,
  `sifra_fakulteta` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKc9lc5sekwpb19qpobc7eegjpn` (`univerzitet_id`),
  CONSTRAINT `FKc9lc5sekwpb19qpobc7eegjpn` FOREIGN KEY (`univerzitet_id`) REFERENCES `univerzitet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fakultet`
--

LOCK TABLES `fakultet` WRITE;
/*!40000 ALTER TABLE `fakultet` DISABLE KEYS */;
INSERT INTO `fakultet` VALUES (1,1,'Bulevar Patrijarha Pavla 5, Kampus A','Jovan Jovic','email: tf.lms@unimail.rs, tel: 021/500-101','Masinski i tehnicki fakultet','assets/images/mitf.png','Tehnički fakultet Univerziteta LMS nudi vrhunsko obrazovanje u oblasti inženjeringa i tehnologije, sa naglaskom na inovacije, istraživanje i primenu savremenih tehnologija. Fakultet pruža širok spektar studijskih programa, uključujući elektrotehniku, računarstvo, mašinstvo i građevinu, opremljen modernim laboratorijama i radnim prostorima. Kroz integraciju teorijskih znanja i praktičnih iskustava, studenti stiču veštine potrebne za uspeh u dinamičnom tehnološkom sektoru. Fakultet takođe promoviše saradnju sa industrijom, omogućavajući studentima pristup realnim projektima i mogućnostima za profesionalni razvoj.','MITF'),(2,1,'Bulevar Patrijarha Pavla 5, Kampus B','Ana Dobric','email: fmp.lms@unimail.rs tel:021/500-102','Fakultet menadzmenta i poslovnih studija','assets/images/fmips.png','Fakultet menadžmenta i poslovnih studija Univerziteta LMS pruža sveobuhvatno obrazovanje u oblasti menadžmenta, finansija, marketinga i preduzetništva. Fakultet nudi studijske programe koji kombinuju teorijske temelje i praktične veštine, pripremajući studente za vođenje i inovacije u poslovnom svetu. Sa fokusom na savremene poslovne strategije i analitičke metode, studenti se upoznaju sa najnovijim trendovima i tehnologijama u industriji. Fakultet takođe podržava saradnju sa preduzećima i organizacijama, pružajući studentima prilike za praksu i profesionalni razvoj kroz projekte i studije slučaja.','FMIPS'),(3,1,'Bulevar Patrijarha Pavla 5, Kampus C','Bogdan Bojovic','email:bkf.lms@unimail.rs','Faklutet Bezbednosti i kriminalistike','assets/images/fbik.png','Fakultet bezbednosti i kriminalistike Univerziteta LMS specijalizovan je za obrazovanje u oblasti bezbednosti, kriminalistike i pravde. Fakultet nudi studijske programe koji obuhvataju teorijske i praktične aspekte kriminalističkih istraživanja, zaštite i bezbednosti, kao i upravljanja kriznim situacijama. Studenti se upoznaju sa najnovijim metodama i tehnologijama u analizi i prevenciji kriminala, kao i sa pravnim i etičkim normama u oblasti bezbednosti. Fakultet pruža praktične veštine kroz simulacije, terenske vežbe i saradnju sa stručnjacima iz prakse, omogućavajući studentima da se pripreme za profesionalne izazove u oblasti bezbednosti i pravde.','FBIK');
/*!40000 ALTER TABLE `fakultet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `godina_studija`
--

DROP TABLE IF EXISTS `godina_studija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `godina_studija` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `godina` int NOT NULL,
  `studijski_program_id` bigint DEFAULT NULL,
  `godine_stirdoranja_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg1oeoukwkgcc0797clodwjb0r` (`studijski_program_id`),
  KEY `FK64t5pdbxs8psyk7v9ayqy9fdm` (`godine_stirdoranja_id`),
  CONSTRAINT `FK64t5pdbxs8psyk7v9ayqy9fdm` FOREIGN KEY (`godine_stirdoranja_id`) REFERENCES `studijski_programi` (`id`),
  CONSTRAINT `FKg1oeoukwkgcc0797clodwjb0r` FOREIGN KEY (`studijski_program_id`) REFERENCES `studijski_programi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `godina_studija`
--

LOCK TABLES `godina_studija` WRITE;
/*!40000 ALTER TABLE `godina_studija` DISABLE KEYS */;
INSERT INTO `godina_studija` VALUES (1,1,1,NULL),(2,2,1,NULL),(3,3,2,NULL),(4,4,3,NULL);
/*!40000 ALTER TABLE `godina_studija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kancelariski_materijal`
--

DROP TABLE IF EXISTS `kancelariski_materijal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kancelariski_materijal` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `izdato` int NOT NULL,
  `kolicina` int NOT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kancelariski_materijal`
--

LOCK TABLES `kancelariski_materijal` WRITE;
/*!40000 ALTER TABLE `kancelariski_materijal` DISABLE KEYS */;
INSERT INTO `kancelariski_materijal` VALUES (1,1,120,'toneri'),(2,1,110,'blokovi'),(3,1,37,'spajalice'),(4,1,47,'markeri'),(5,0,51,'spajalice');
/*!40000 ALTER TABLE `kancelariski_materijal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nastavni_materijal`
--

DROP TABLE IF EXISTS `nastavni_materijal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nastavni_materijal` (
  `broj_strana` int NOT NULL,
  `ishod` tinyint DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `autori` varchar(255) DEFAULT NULL,
  `godina_izdavanja` varchar(255) DEFAULT NULL,
  `izdavac` varchar(255) DEFAULT NULL,
  `naslov` varchar(255) DEFAULT NULL,
  `opis` longtext,
  `predmet_id` bigint DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `izdato` int NOT NULL,
  `kolicina` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf40468t66rhgrjkqrs7vx1m0l` (`predmet_id`),
  CONSTRAINT `FKf40468t66rhgrjkqrs7vx1m0l` FOREIGN KEY (`predmet_id`) REFERENCES `predmeti` (`id`),
  CONSTRAINT `nastavni_materijal_chk_1` CHECK ((`ishod` between 0 and 2))
) ENGINE=InnoDB AUTO_INCREMENT=215 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nastavni_materijal`
--

LOCK TABLES `nastavni_materijal` WRITE;
/*!40000 ALTER TABLE `nastavni_materijal` DISABLE KEYS */;
INSERT INTO `nastavni_materijal` VALUES (0,NULL,143,'Marko Petrović','2022','LMS Univerzitet','Osnove mašinstva','Uvod u osnovne principe mašinstva, uključujući materijale i procese.',1,'asd',1,30),(350,NULL,144,'Ivana Jovanović','2021','LMS Univerzitet','Mašinski principi','Temeljni principi mašinstva i njihova primena u inženjerskim sistemima.',1,NULL,1,120),(400,NULL,145,'Nikola Miljković','2021','LMS Univerzitet','Termodinamika','Osnovni principi termodinamike, uključujući termodinamičke cikluse i analize.',2,NULL,1,120),(320,NULL,146,'Jelena Novak','2018','LMS Univerzitet','Prenos toplote','Analiza metoda prenosa toplote i njihova primena u inženjerskim sistemima.',2,NULL,1,120),(360,NULL,147,'Petar Petrović','2022','LMS Univerzitet','Mašinski dizajn','Osnovni principi mašinskog dizajna, uključujući analize i simulacije.',3,NULL,1,120),(330,NULL,148,'Ana Stojanović','2020','LMS Univerzitet','Dizajn mašinskih komponenti','Tehnike za projektovanje mašinskih komponenti i sistema.',3,NULL,1,120),(380,NULL,149,'Ivan Kostić','2022','LMS Univerzitet','Automatizacija procesa','Osnove automatizacije i kontrole procesa u industrijskim sistemima.',4,NULL,1,120),(340,NULL,150,'Maja Đorđević','2021','LMS Univerzitet','Kontrola procesa','Metode i tehnike kontrole procesa u industrijskim okruženjima.',4,NULL,1,120),(370,NULL,151,'Stefan Vuković','2022','LMS Univerzitet','Proizvodna tehnika','Osnovne tehnike i metodologije u proizvodnoj tehnici.',5,NULL,1,120),(350,NULL,152,'Jelena Petrović','2021','LMS Univerzitet','Tehnologije proizvodnje','Pregled različitih tehnologija proizvodnje i njihovih primena.',5,NULL,1,120),(0,NULL,153,'Nikola Stojanović','2022','LMS Univerzitet','Energetski sistemi','Pregled energetski sistema, uključujući obnovljive izvore energije.',6,NULL,1,117),(340,NULL,154,'Milena Radosavljević','2020','LMS Univerzitet','Instalacije u energetici','Metode instalacije i upravljanje energetskim sistemima.',6,NULL,1,120),(350,NULL,155,'Ana Marković','2022','LMS Univerzitet','Uvod u IT','Osnovni principi i koncepcije informacionih tehnologija.',7,NULL,1,120),(330,NULL,156,'Marko Radosavljević','2021','LMS Univerzitet','Informacione tehnologije: Uvod','Osnove informacionih tehnologija i njihove aplikacije.',7,NULL,1,120),(360,NULL,157,'Ivan Marković','2022','LMS Univerzitet','Programiranje u Pythonu','Osnovi programiranja u Pythonu sa primerima i vežbama.',8,NULL,1,120),(340,NULL,158,'Milica Đorđević','2021','LMS Univerzitet','Python: Uvod i primena','Tehnike i metode programiranja u Pythonu za početnike.',8,NULL,1,120),(380,NULL,159,'Jovan Stojanović','2022','LMS Univerzitet','Strukture podataka','Osnovne strukture podataka i njihova primena u programiranju.',9,NULL,1,120),(350,NULL,160,'Ana Radosavljević','2021','LMS Univerzitet','Algoritmi i strukture','Analiza algoritama i struktura podataka za efikasno programiranje.',9,NULL,1,120),(400,NULL,161,'Petar Kostić','2022','LMS Univerzitet','Razvoj web aplikacija','Tehnike i alati za razvoj i dizajn web aplikacija.',10,NULL,1,120),(360,NULL,162,'Milena Stanković','2021','LMS Univerzitet','Web razvoj','Metode za izgradnju modernih web aplikacija i sistema.',10,NULL,1,120),(370,NULL,163,'Nikola Vuković','2022','LMS Univerzitet','Računarske mreže','Osnove računarskih mreža i njihova konfiguracija.',11,NULL,1,120),(340,NULL,164,'Jelena Kostić','2021','LMS Univerzitet','Mrežni sistemi','Analiza mrežnih sistema i njihove primene.',11,NULL,1,120),(380,NULL,165,'Maja Jovanović','2022','LMS Univerzitet','Veštačka inteligencija','Osnovni principi veštačke inteligencije i njihove primene.',12,NULL,1,120),(360,NULL,166,'Stefan Petrović','2021','LMS Univerzitet','AI: Tehnike i primene','Tehnike i metode veštačke inteligencije sa praktičnim primerima.',12,NULL,1,120),(360,NULL,167,'Marko Ilić','2022','LMS Univerzitet','Osnove menadžmenta','Temeljni principi menadžmenta i njihove primene u organizacijama.',13,NULL,1,120),(340,NULL,168,'Ana Nikolić','2021','LMS Univerzitet','Menadžment: Uvod','Uvod u osnovne koncepte i tehnike menadžmenta.',13,NULL,1,120),(380,NULL,169,'Petar Đorđević','2022','LMS Univerzitet','Organizacija poslovanja','Strategije za organizaciju i strukturiranje poslovanja.',14,NULL,1,120),(0,NULL,170,'Milena Marković','2021','LMS Univerzitet','Strukturiranje organizacija','Metode za efikasno strukturiranje organizacionih jedinica.',14,NULL,1,119),(370,NULL,171,'Nikola Ristić','2022','LMS Univerzitet','Marketing i strategija','Osnovne tehnike marketinga i strategije za poboljšanje poslovanja.',15,NULL,1,120),(340,NULL,172,'Jelena Vuković','2021','LMS Univerzitet','Strategije marketinga','Strategije i tehnike za uspešno vođenje marketinških kampanja.',15,NULL,1,120),(380,NULL,173,'Ana Đorđević','2022','LMS Univerzitet','Finansijski menadžment','Osnovne tehnike i metode u finansijskom menadžmentu.',16,NULL,1,120),(340,NULL,174,'Milena Tadić','2020','LMS Univerzitet','Principi finansijskog menadžmenta','Detaljan pregled principa i tehnika finansijskog menadžmenta.',16,NULL,1,120),(360,NULL,175,'Tanja Petrović','2022','LMS Univerzitet','Menadžment ljudskih resursa','Strategije za upravljanje ljudskim resursima u organizacijama.',17,NULL,1,120),(340,NULL,176,'Stefan Stojanović','2021','LMS Univerzitet','Upravljanje ljudskim resursima','Osnovne metode za upravljanje ljudskim resursima.',17,NULL,1,120),(380,NULL,177,'Ana Miljković','2022','LMS Univerzitet','Preduzetništvo i inovacije','Tehnike i metodologije za razvoj preduzetničkih veština i inovacija.',18,NULL,1,120),(360,NULL,178,'Marko Jovanović','2021','LMS Univerzitet','Inovacije u preduzetništvu','Strategije za implementaciju inovacija u preduzetničkom okruženju.',18,NULL,1,120),(370,NULL,179,'Nikola Stojanović','2022','LMS Univerzitet','Poslovna ekonomija','Osnovne koncepcije i tehnike u poslovnoj ekonomiji.',19,NULL,1,120),(340,NULL,180,'Jelena Petrović','2021','LMS Univerzitet','Ekonomija poslovanja','Pregled ekonomskih principa koji utiču na poslovanje.',19,NULL,1,120),(360,NULL,181,'Maja Đorđević','2022','LMS Univerzitet','Računovodstvo za menadžere','Osnovne tehnike računovodstva specijalizovane za menadžere.',20,NULL,1,120),(340,NULL,182,'Stefan Vuković','2021','LMS Univerzitet','Menadžersko računovodstvo','Pregled računovodstvenih tehnika za donošenje menadžerskih odluka.',20,NULL,1,120),(370,NULL,183,'Ana Jovanović','2022','LMS Univerzitet','Finansijska analiza i planiranje','Tehnike i metode za analizu i planiranje finansijskih aktivnosti.',21,NULL,1,120),(340,NULL,184,'Nikola Kostić','2021','LMS Univerzitet','Analiza finansijskih izvještaja','Detaljna analiza i planiranje finansijskih izvještaja.',21,NULL,1,120),(380,NULL,185,'Marko Radosavljević','2022','LMS Univerzitet','Menadžment operacija','Tehnike i metodologije za efikasno upravljanje operacijama.',22,NULL,1,120),(350,NULL,186,'Ana Stanković','2021','LMS Univerzitet','Operacije i menadžment','Osnovne tehnike za upravljanje operacijama u organizacijama.',22,NULL,1,120),(360,NULL,187,'Stefan Ristić','2022','LMS Univerzitet','Ekonomija preduzetništva','Principi ekonomije primenjeni na preduzetničke aktivnosti.',23,NULL,1,120),(340,NULL,188,'Jelena Jovanović','2021','LMS Univerzitet','Preduzetnička ekonomija','Analiza ekonomskih aspekata preduzetništva.',23,NULL,1,120),(380,NULL,189,'Ana Petrović','2021','LMS Univerzitet','Menadžment promena','Strategije za uspešno upravljanje promenama u organizacijama.',24,NULL,1,120),(350,NULL,190,'Marko Jovanović','2020','LMS Univerzitet','Upravljanje promenama','Tehnike i metode za upravljanje promenama u organizacionom kontekstu.',24,NULL,1,120),(360,NULL,191,'Milena Kostić','2022','LMS Univerzitet','Osnove kriminalistike','Osnovni principi i tehnike u kriminalistici.',25,NULL,1,120),(340,NULL,192,'Jovan Stojanović','2021','LMS Univerzitet','Kriminalističke tehnike','Metode i tehnike u oblasti kriminalistike.',25,NULL,1,120),(370,NULL,193,'Nikola Stanković','2022','LMS Univerzitet','Forenzička nauka','Osnove forenzičke nauke i njihova primena u kriminalističkim istragama.',26,NULL,1,120),(350,NULL,194,'Ivana Đorđević','2021','LMS Univerzitet','Tehnike forenzike','Pregled tehnika i metoda forenzike za analizu dokaza.',26,NULL,1,120),(360,NULL,195,'Jelena Novak','2022','LMS Univerzitet','Kriminalistička psihologija','Teorije i metode u kriminalističkoj psihologiji.',27,NULL,1,120),(340,NULL,196,'Marko Kostić','2021','LMS Univerzitet','Psihologija kriminala','Analiza psiholoških aspekata kriminalnog ponašanja.',27,NULL,1,120),(380,NULL,197,'Ana Marković','2022','LMS Univerzitet','Bezbednost i zaštita','Osnovni principi i tehnike u oblasti bezbednosti i zaštite.',28,NULL,1,120),(350,NULL,198,'Stefan Petrović','2021','LMS Univerzitet','Zaštita i sigurnost','Strategije i metodologije za zaštitu i sigurnost u organizacijama.',28,NULL,1,120),(360,NULL,199,'Milena Đorđević','2022','LMS Univerzitet','Zakonodavstvo i kriminalistika','Pregled zakonodavstva i njegovih uticaja na kriminalističke aktivnosti.',29,NULL,1,120),(0,NULL,200,'Nikola Jovanović','2021','LMS Univerzitet','Kriminalističko zakonodavstvo','Analiza zakonodavstva u kontekstu kriminalističkih istraga.',29,NULL,1,119),(380,NULL,201,'Ana Petrović','2022','LMS Univerzitet','Upravljanje kriminalitetom','Strategije za upravljanje i smanjenje kriminalnih aktivnosti.',30,NULL,1,120),(350,NULL,202,'Marko Radosavljević','2021','LMS Univerzitet','Kriminalno upravljanje','Metode i tehnike za upravljanje kriminalnim delatnostima.',30,NULL,1,120),(360,NULL,203,'Jelena Stojanović','2022','LMS Univerzitet','Uvod u pravo','Osnovni principi i koncepcije pravnog sistema.',31,NULL,1,120),(340,NULL,204,'Nikola Vuković','2021','LMS Univerzitet','Pravni sistem','Pregled pravnog sistema i njegovih osnovnih funkcija.',31,NULL,1,120),(380,NULL,205,'Stefan Kostić','2022','LMS Univerzitet','Građansko pravo','Osnove građanskog prava i njegovi principi.',32,NULL,1,120),(350,NULL,206,'Maja Stanković','2021','LMS Univerzitet','Principi građanskog prava','Teorije i tehnike u oblasti građanskog prava.',32,NULL,1,120),(370,NULL,207,'Ana Miljković','2022','LMS Univerzitet','Krivično pravo','Osnovni principi i tehnike krivičnog prava.',33,NULL,1,120),(340,NULL,208,'Marko Đorđević','2021','LMS Univerzitet','Principi krivičnog prava','Analiza osnovnih koncepata krivičnog prava.',33,NULL,1,120),(380,NULL,209,'Petar Marković','2022','LMS Univerzitet','Ustavno pravo','Osnovne komponente i principi ustavnog prava.',34,NULL,1,120),(360,NULL,210,'Jelena Kostić','2021','LMS Univerzitet','Principi ustavnog prava','Analiza ustavnog prava i njegovih principa.',34,NULL,1,120),(370,NULL,211,'Nikola Stanković','2022','LMS Univerzitet','Administrativno pravo','Osnovi administrativnog prava i njegove primene.',35,NULL,1,120),(340,NULL,212,'Ana Petrović','2021','LMS Univerzitet','Administrativno zakonodavstvo','Detaljna analiza administrativnog zakonodavstva.',35,NULL,1,120),(380,NULL,213,'Marko Petrović','2022','LMS Univerzitet','Međunarodno pravo','Principi i koncepcije međunarodnog prava.',36,NULL,1,120),(360,NULL,214,'Milena Đorđević','2021','LMS Univerzitet','Prava međunarodnih odnosa','Analiza prava koja regulišu međunarodne odnose.',36,NULL,1,120);
/*!40000 ALTER TABLE `nastavni_materijal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nastavnik_na_realizaciji`
--

DROP TABLE IF EXISTS `nastavnik_na_realizaciji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nastavnik_na_realizaciji` (
  `broj_casova` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nastavnik_id` bigint DEFAULT NULL,
  `tip_nastave` enum('MENTORSKA_NASTAVA','PREDAVANJA','VEZBE') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nastavnik_na_realizaciji`
--

LOCK TABLES `nastavnik_na_realizaciji` WRITE;
/*!40000 ALTER TABLE `nastavnik_na_realizaciji` DISABLE KEYS */;
/*!40000 ALTER TABLE `nastavnik_na_realizaciji` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obavestenja`
--

DROP TABLE IF EXISTS `obavestenja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `obavestenja` (
  `datum` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `vreme_kraja` datetime(6) DEFAULT NULL,
  `vreme_pocetka` datetime(6) DEFAULT NULL,
  `naslov` varchar(255) DEFAULT NULL,
  `predmet_id` bigint DEFAULT NULL,
  `sadrzaj` longtext,
  `slika` varchar(255) DEFAULT NULL,
  `dtype` varchar(31) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt2dcpljxeeg48xstx84x6il34` (`predmet_id`),
  CONSTRAINT `FKt2dcpljxeeg48xstx84x6il34` FOREIGN KEY (`predmet_id`) REFERENCES `predmeti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obavestenja`
--

LOCK TABLES `obavestenja` WRITE;
/*!40000 ALTER TABLE `obavestenja` DISABLE KEYS */;
INSERT INTO `obavestenja` VALUES ('2024-08-08 00:00:00.000000',1,'2024-08-08 00:00:00.000000','2024-10-08 00:00:00.000000','Upis u skolsku 2024/25',NULL,'Informacije o upisu u narednu skolsku godinu',NULL,' '),('2024-08-08 00:00:00.000000',2,'2024-09-08 00:00:00.000000','2024-10-08 00:00:00.000000','Promena rada studentske sluzbe',NULL,'Studentska sluzba nece raditi naredne nedelje',NULL,' '),('2024-08-08 00:00:00.000000',3,'2024-09-08 00:00:00.000000','2024-10-08 00:00:00.000000','predmetno obavestenje 1 ',5,'predmetno obavestenje 1 je obavestenje od predmeta',NULL,''),('2024-08-08 00:00:00.000000',4,'2024-09-08 00:00:00.000000','2024-10-08 00:00:00.000000','predmetno obavestenje 2',5,'predmetno obavestenje 2  je obavestenje od predmeta',NULL,''),('2024-09-09 14:44:54.342297',9,'2024-09-09 14:44:51.931000','2024-09-09 14:44:51.931000','asd',NULL,'asd','','Obavestenje'),('2024-09-13 23:35:36.748615',10,'2024-09-13 23:35:26.355000','2024-09-13 23:35:26.355000','asdddddd',3,'asdddddd','','PredmetnaObavestenja'),('2024-09-14 15:03:34.519827',16,'2025-09-14 15:03:00.000000','2024-09-14 15:03:00.661000','masinski dizajn o1',3,'masinski dizajn obavestenje 1','','PredmetnaObavestenja'),('2024-09-14 15:04:07.728589',17,'2024-09-14 15:03:34.558000','2024-09-14 10:03:34.558000','masinski dizajn o2',3,'masinski dizajn obavestenje 2','','PredmetnaObavestenja'),('2024-09-14 15:06:14.905626',18,'2024-09-14 15:06:06.184000','2024-09-14 15:06:06.184000','o3',3,'o3','','PredmetnaObavestenja'),('2024-09-17 19:23:06.426907',21,'2024-09-17 19:22:46.990000','2024-09-17 19:22:46.990000','a',1,'a','','PredmetnaObavestenja'),('2024-09-17 20:07:11.963030',22,'2024-09-17 20:06:23.527000','2024-09-17 20:06:23.527000','asdasdasd',6,'alfkgvbnaodljkifbgnvopaidufbvopiadbfuvpiuabdfvpiubadfpviubadpfivubapdifubvpaiufbdsvpaidubfvpaiudbfvpiaubfvpiuabdfvpiuabdfvpiubadfpivbapdifubvpaiudfbvpiaudbfvpiaubfvpiuabfpviubapdfiuvbapifdubvpiaubdfgv','','PredmetnaObavestenja');
/*!40000 ALTER TABLE `obavestenja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` enum('ADMINISTRATOR_PERMISSION','KORISNIK_PERMISSION','NASTAVNIK_PERMISSION','STUDENTSKASLUZBA_PERMISSION','STUDENT_PERMISSION') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions` DISABLE KEYS */;
INSERT INTO `permissions` VALUES (1,'KORISNIK_PERMISSION'),(2,'STUDENT_PERMISSION'),(3,'STUDENTSKASLUZBA_PERMISSION'),(4,'ADMINISTRATOR_PERMISSION'),(5,'NASTAVNIK_PERMISSION');
/*!40000 ALTER TABLE `permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polaganje`
--

DROP TABLE IF EXISTS `polaganje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `polaganje` (
  `bodovi` double NOT NULL,
  `konacna_ocena` int NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `kraj` datetime(6) DEFAULT NULL,
  `nastavnik_id` bigint DEFAULT NULL,
  `obavestenja_id` bigint DEFAULT NULL,
  `pocetak` datetime(6) DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  `napomena` longtext,
  `predmet_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pp8v3wdsexk4hem9k9elkaqau` (`obavestenja_id`),
  KEY `FKdhnskqwx11e9k45238to8ol2e` (`nastavnik_id`),
  KEY `FK7j4bcjcliryqpu4ltnlu6rohd` (`predmet_id`),
  KEY `FK7u3qvtnr3fm1p11esk895oyhu` (`student_id`),
  CONSTRAINT `FK7j4bcjcliryqpu4ltnlu6rohd` FOREIGN KEY (`predmet_id`) REFERENCES `predmeti` (`id`),
  CONSTRAINT `FK7u3qvtnr3fm1p11esk895oyhu` FOREIGN KEY (`student_id`) REFERENCES `registrovani_korisnici` (`id`),
  CONSTRAINT `FK9g96u2wy735r8bcyb78r1useu` FOREIGN KEY (`obavestenja_id`) REFERENCES `obavestenja` (`id`),
  CONSTRAINT `FKdhnskqwx11e9k45238to8ol2e` FOREIGN KEY (`nastavnik_id`) REFERENCES `registrovani_korisnici` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polaganje`
--

LOCK TABLES `polaganje` WRITE;
/*!40000 ALTER TABLE `polaganje` DISABLE KEYS */;
INSERT INTO `polaganje` VALUES (77,8,1,NULL,8,NULL,NULL,6,NULL,3),(65,7,2,NULL,8,NULL,NULL,6,NULL,2),(20,5,3,NULL,8,NULL,NULL,6,NULL,5),(11,5,4,NULL,8,NULL,NULL,6,NULL,1),(78,8,11,NULL,8,NULL,NULL,6,'',1),(34,5,20,NULL,8,NULL,NULL,6,'',4),(67,7,21,NULL,8,NULL,NULL,6,'asd',4);
/*!40000 ALTER TABLE `polaganje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `predmeti`
--

DROP TABLE IF EXISTS `predmeti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `predmeti` (
  `espb` int NOT NULL,
  `nastavnik_id` bigint DEFAULT NULL,
  `studijski_program_id` bigint DEFAULT NULL,
  `vreme_kraja` datetime(6) DEFAULT NULL,
  `vreme_pocetka` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `opis` longtext,
  `silabus` longtext,
  `sifra_predmeta` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1byq5p7e8qqehiisb6rekgeli` (`nastavnik_id`),
  KEY `FKhpqx8nnnmojc9i02oyn5mshjq` (`studijski_program_id`),
  CONSTRAINT `FK1byq5p7e8qqehiisb6rekgeli` FOREIGN KEY (`nastavnik_id`) REFERENCES `registrovani_korisnici` (`id`),
  CONSTRAINT `FKhpqx8nnnmojc9i02oyn5mshjq` FOREIGN KEY (`studijski_program_id`) REFERENCES `studijski_programi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `predmeti`
--

LOCK TABLES `predmeti` WRITE;
/*!40000 ALTER TABLE `predmeti` DISABLE KEYS */;
INSERT INTO `predmeti` VALUES (8,8,1,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',1,'Osnove masinstva','Predmet \"Osnove Mašinstva\" pruža temeljno razumevanje ključnih principa i koncepata u oblasti mašinstva. Kurs je dizajniran da studentima omogući osnovne veštine i znanja potrebna za razumijevanje i primenu mašinskih principa u različitim inženjerskim problemima. Fokus je na teorijskim osnovama mašinskih sistema, materijalima, proizvodnim procesima i osnovama termodinamike i statike.','\"1. Uvod u Mašinstvo [Definicija i značaj mašinstva; Istorija i razvoj mašinstva; Uloga mašinstva u savremenom društvu]\"\n\n\"2. Osnovni Koncepti i Principi [Osnovni principi inženjeringa; Razumevanje mašinskih sistema i njihovih komponenti; Uloga i funkcija inženjerskih crteža i specifikacija]\"\n\n\"3. Materijali u Mašinstvu [Osnovne vrste materijala (metali, polimeri, keramika, kompoziti); Karakteristike i svojstva materijala; Selekcija materijala za različite primene]\"\n\n\"4. Proizvodni Procesi [Osnovne metode obrade materijala (tokarenje, frezanje, bušenje); Proizvodne tehnologije i alati; Kontrola kvaliteta i uloga u proizvodnom procesu]\"\n\n\"5. Statika i Dinamika [Osnovni principi statike: sile, momenti, ravnoteža; Osnovni principi dinamike: ubrzanje, sile, zakoni kretanja; Analiza statičkih i dinamičkih sistema]\"\n\n\"6. Termodinamika i Energija [Osnovni zakoni termodinamike; Toplotni prenosi i energija; Rad mašinskih sistema u različitim termodinamičkim uslovima]\"\n\n\"7. Računarske Metode i Softver [Uvod u CAD (Computer-Aided Design) softver; Upotreba softvera za analizu i simulaciju mašinskih sistema; Primena računarskih metoda u rešavanju inženjerskih problema]\"\n\n\"8. Praktična Predavanja i Laboratorijski Rad [Demonstracija i primena osnovnih tehnika obrade; Laboratorijski eksperimenti u analizi materijala; Projektni rad i analiza slučajeva]\"\n\n\"Obavezna Literatura: [Fundamentals of Machine Component Design - Robert C. Juvinall, Kurt M. Marshek; Engineering Materials 1: An Introduction to Properties, Applications and Design - Michael F. Ashby, David Cebon; Introduction to Thermodynamics and Heat Transfer - Yaw\'s Transport Properties of Chemicals and Hydrocarbons]\"\n\n\"Preporučena Literatura: [Mechanical Engineering Design - J.E. Shigley, C.R. Mischke; Manufacturing Engineering and Technology - S. Kalpakjian, S.R. Schmid]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Praktične vežbe i laboratorijski rad (20%); Projekti i prezentacije (20%)]\"\n\n\"Napomene: [Redovno prisustvo i aktivno učešće na predavanjima i vežbama je obavezno; Studentima se preporučuje da redovno prate dodatne materijale i resurse preporučene od strane nastavnika.]\"\n','OM'),(8,8,1,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',2,'Termodinamika i Prenos Toplote','Predmet \"Termodinamika i Prenos Toplosti\" pokriva osnovne zakone termodinamike i metode prenosa toplote, koje su ključne za razumevanje i dizajn sistema koji se bave energijom i toplinom.','\"1. Osnovni Zakoni Termodinamike [Zakon o očuvanju energije; Zakon o entropiji; Termodinamički ciklusi]\"\n\n\"2. Toplotni Prenosi [Kondukcija; Konvekcija; Radijacija]\"\n\n\"3. Mašinski Ciklus i Energetske Mašine [Ciklus Carnot; Tipovi energetski efikasnih mašina; Analiza performansi]\"\n\n\"4. Teorija i Praktična Primena [Analiza u industrijskim sistemima; Optimizacija sistema za prenos toplote; Softverske simulacije]\"\n\n\"Obavezna Literatura: [Fundamentals of Engineering Thermodynamics - Michael J. Moran, Howard N. Shapiro; Heat Transfer - J.P. Holman]\"\n\n\"Preporučena Literatura: [Introduction to Heat Transfer - Frank Kreith, Warren B. Stull; Thermal Engineering - P.K. Nag]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Laboratorijski rad (20%); Projekti i analiza slučajeva (20%)]\"\n\n\"Napomene: [Kurs uključuje praktične laboratorijske vežbe koje su ključne za razumevanje primene teorijskih koncepata.]\"\na','TIPT'),(8,8,1,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',3,'Mašinski Dizajn','Predmet \"Mašinski Dizajn\" fokusira se na metodologiju i procese dizajniranja mašinskih komponenti i sistema. Kurs pokriva sve aspekte od inicijalnog dizajna, preko analize, do optimizacije i testiranja mašinskih sistema.','\"1. Osnovni Principi Dizajna [Proces dizajna; Kreativni pristupi; Analiza zahteva]\"\n\n\"2. Materijali i Odabir [Svojstva materijala; Izbor materijala; Uloga materijala u dizajnu]\"\n\n\"3. Konstrukcija i Analiza [Metode konstrukcije; Računarske simulacije; Analiza opterećenja]\"\n\n\"4. Optimizacija Dizajna [Tehnike optimizacije; Analiza troškova; Testiranje i validacija]\"\n\n\"Obavezna Literatura: [Machine Design - J.E. Shigley, C.R. Mischke; Design of Machine Elements - L. B. Doughtie]\"\n\n\"Preporučena Literatura: [Engineering Design - George E. Dieter, Linda C. Schmidt; Mechanical Engineering Design - J.E. Shigley, C.R. Mischke]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projektni rad i dizajnerski zadaci (30%); Prezentacije (20%)]\"\n\n\"Napomene: [Studenti treba da se uključe u timski rad i individualne projekte kako bi razvili veštine praktične primene.]\"\n','MD'),(8,8,1,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',4,'Automatizacija i Kontrola Procesa','Predmet \"Automatizacija i Kontrola Procesa\" pruža uvid u principe automatizacije i kontrolu industrijskih procesa. Kurs obuhvata teoriju i primenu sistema automatskog upravljanja, senzora, aktuatora i kontrolnih algoritama.','\"1. Osnovni Principi Automatizacije [Uvod u automatizaciju; Tipovi sistema; Razumevanje kontrolnih sistema]\"\n\n\"2. Senzori i Aktuatori [Vrste senzora; Funkcija aktuatora; Integracija senzora i aktuatora]\"\n\n\"3. Kontrolni Algoritmi [PID kontrola; Kontrola u stvarnom vremenu; Digitalna kontrola]\"\n\n\"4. Primene i Tehničke Analize [Industrijske primene; Softverske platforme; Praktična primena i laboratorijski rad]\"\n\n\"Obavezna Literatura: [Introduction to Process Control - P. Harriott; Modern Control Engineering - Ogata]\"\n\n\"Preporučena Literatura: [Process Dynamics and Control - C. Smith, A. Corripio; Control Systems Engineering - N. Nise]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Laboratorijski rad (30%); Projekti i izveštaji (20%)]\"\n\n\"Napomene: [Laboratorijski rad je ključan za sticanje praktičnih veština u automatizaciji i kontroli.]\"\n','AIKP'),(8,8,1,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',5,'Proizvodna Tehnika','Proizvodna Tehnika','\"1. Uvod u Proizvodnu Tehniku [Osnovni pojmovi u proizvodnji; Tipovi proizvodnih procesa; Organizacija proizvodnje]\"\n\n\"2. Tehnike ObRADE [Tokarenje, frezanje, bušenje; Moderne metode obrade; Priprema i postavljanje alata]\"\n\n\"3. Kontrola Kvaliteta [Metode kontrole; Instrumentacija za merenje; Statističke metode u kontroli]\"\n\n\"4. Optimizacija Proizvodnje [Lean manufacturing; Six Sigma; Analiza i poboljšanje procesa]\"\n\n\"Obavezna Literatura: [Manufacturing Engineering and Technology - S. Kalpakjian, S.R. Schmid; Production Technology - R.K. Jain]\"\n\n\"Preporučena Literatura: [Fundamentals of Manufacturing Processes - H. T. Papalambros, D. J. Wilde; Advanced Manufacturing Technology - M. P. Groover]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Praktične vežbe i laboratorijski rad (30%); Projekti i analize slučajeva (10%)]\"\n\n\"Napomene: [Studenti treba da se uključe u praktične projekte i laboratorijske radove kako bi stekli iskustvo u savremenim proizvodnim tehnologijama.]\"\n','PT'),(8,8,1,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',6,'Energetski Sistemi i Instalacije','Predmet \"Energetski Sistemi i Instalacije\" fokusira se na dizajn, analizu i upravljanje energetski efikasnim sistemima. Kurs pokriva različite aspekte energetske proizvodnje, distribucije i upotrebe, uključujući električne, toplotne i mehaničke sisteme.','\"1. Osnovne Koncepti Energetskih Sistema [Uvod u energetske sisteme; Tipovi energetski sistema; Razumevanje energetske efikasnosti]\"\n\n\"2. Električni Energetski Sistemi [Osnovni principi električne energije; Električni generatori i transformatori; Distribucija električne energije]\"\n\n\"3. Toplotni Energetski Sistemi [Kotlovi i turbinske mašine; Sistemi za grejanje i hlađenje; Analiza energetske efikasnosti u toplotnim sistemima]\"\n\n\"4. Mehanički Energetski Sistemi [Pneumatski i hidraulični sistemi; Pumpne i kompresorske instalacije; Upravljanje mehaničkim sistemima]\"\n\n\"5. Instalacije i Održavanje [Projektovanje energetski efikasnih instalacija; Održavanje i inspekcija; Praktične primene i studije slučaja]\"\n\n\"Obavezna Literatura: [Energy Systems Engineering: Evaluation and Implementation - Francis Vanek, Louis Albright; Power System Analysis - John J. Grainger, William D. Stevenson]\"\n\n\"Preporučena Literatura: [Energy Efficiency and Renewable Energy Handbook - D. Yogi Goswami; Electrical Power Systems Technology - Dale R. Patrick, Stephen W. Fardo]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Laboratorijski rad i praktične vežbe (30%); Projekti i analiza slučajeva (20%)]\"\n\n\"Napomene: [Kurs uključuje praktične laboratorijske vežbe koje su ključne za sticanje iskustva u dizajnu i upravljanju energetskim sistemima.]\"\n','ESI'),(8,20,2,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',7,'Uvod u Informacione Tehnologije','Predmet \"Uvod u Informacione Tehnologije\" pruža osnovno razumevanje ključnih koncepata i tehnologija u oblasti informacionih tehnologija. Kurs pokriva osnovne pojmove u vezi sa računarima, softverom, mrežama i bazama podataka.','\"1. Osnove Računarskih Sistema [Komponente računara; Operativni sistemi; Računarske arhitekture]\"\n\n\"2. Softverski Sistemi [Vrste softvera; Razvoj softvera; Upotreba i upravljanje softverom]\"\n\n\"3. Mreže i Komunikacija [Osnove mreža; Protokoli i standardi; Internet i mrežne usluge]\"\n\n\"4. Baze Podataka [Osnovne koncepte baza podataka; Relacijski modeli; SQL i upravljanje bazama podataka]\"\n\n\"Obavezna Literatura: [Introduction to Information Systems - James A. O\'Brien, George M. Marakas; Computer Networking: A Top-Down Approach - James F. Kurose, Keith W. Ross]\"\n\n\"Preporučena Literatura: [Understanding Computers: Today and Tomorrow - Deborah Morley, Charles S. Parker; Database System Concepts - Abraham Silberschatz, Henry Korth, S. Sudarshan]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Laboratorijski rad i praktične vežbe (30%); Projekti i analiza slučajeva (20%)]\"\n\n\"Napomene: [Redovno prisustvo i aktivno učešće na predavanjima i vežbama je preporučeno.]\"\n','UIT'),(8,20,2,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',8,'Programiranje u Pythonu','Predmet \"Programiranje u Pythonu\" uči studente osnovama programiranja koristeći Python, jedan od najpopularnijih i najfleksibilnijih programskih jezika. Kurs pokriva sintaksu, strukture podataka, i osnovne tehnike programiranja.','\"1. Uvod u Python [Osnove sintakse; Variabile i tipovi podataka; Operatori i izrazi]\"\n\n\"2. Kontrola Toka [Uslovne strukture; Petlje; Funkcije i moduli]\"\n\n\"3. Strukture Podataka [Liste, tuple i skupovi; Rečnici; Rad sa fajlovima]\"\n\n\"4. Praktične Vežbe [Razvoj malih projekata; Debugging i testiranje; Rad sa bibliotekama i paketima]\"\n\n\"Obavezna Literatura: [Python Crash Course - Eric Matthes; Learning Python - Mark Lutz]\"\n\n\"Preporučena Literatura: [Automate the Boring Stuff with Python - Al Sweigart; Python Cookbook - David Beazley, Brian K. Jones]\"\n\n\"Način Polaganja: [Pismeni ispiti (40%); Laboratorijski rad i zadaci (40%); Projekti i vežbe (20%)]\"\n\n\"Napomene: [Praktične vežbe su ključne za uspešno savladavanje gradiva i preporučuje se rad na dodatnim projektima.]\"\n','PP'),(8,20,2,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',9,'Strukture Podataka i Algoritmi','Predmet \"Strukture Podataka i Algoritmi\" pokriva osnovne strukture podataka i algoritme koji su neophodni za efikasno rešavanje problema u programiranju. Kurs uključuje analizu složenosti algoritama i njihove primene.','\"1. Osnovne Strukture Podataka [Nizovi i liste; Stogovi i redovi; Veza između struktura]\"\n\n\"2. Napredne Strukture Podataka [Stabla, grafovi, heapi; Hash tabele; Korišćenje biblioteka]\"\n\n\"3. Algoritmi [Sortiranje i pretraga; Dinamičko programiranje; Greedy algoritmi]\"\n\n\"4. Analiza Algoritama [Analiza složenosti; Teorija kompleksnosti; Optimizacija algoritama]\"\n\n\"Obavezna Literatura: [Data Structures and Algorithm Analysis in C++ - Mark Allen Weiss; Introduction to Algorithms - Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein]\"\n\n\"Preporučena Literatura: [Algorithms - Robert Sedgewick, Kevin Wayne; The Algorithm Design Manual - Steven S. Skiena]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Laboratorijski rad i zadaci (20%); Projekti i analiza slučajeva (20%)]\"\n\n\"Napomene: [Studenti treba da se uključe u dodatne vežbe i analize kako bi stekli dublje razumevanje struktura i algoritama.]\"\n','SPA'),(8,20,2,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',10,'Razvoj Web Aplikacija','Predmet \"Razvoj Web Aplikacija\" pokriva osnovne i napredne tehnike za kreiranje modernih web aplikacija. Kurs obuhvata HTML, CSS, JavaScript, kao i rad sa web framework-ovima i bazama podataka.','\"1. Osnove Web Razvoja [HTML i CSS; Struktura web stranica; Responsive dizajn]\"\n\n\"2. Programiranje na Klijentskoj Strani [JavaScript; DOM manipulacija; Asinhrono programiranje i AJAX]\"\n\n\"3. Razvoj na Serverskoj Strani [Uvod u serverske skripte; Rad sa web framework-ovima; Integracija sa bazama podataka]\"\n\n\"4. Bezbednost Web Aplikacija [Sigurnosne pretnje; Prakse za zaštitu podataka; Autentikacija i autorizacija]\"\n\n\"Obavezna Literatura: [Eloquent JavaScript - Marijn Haverbeke; Web Development with Node and Express - Ethan Brown]\"\n\n\"Preporučena Literatura: [JavaScript: The Good Parts - Douglas Crockford; HTML and CSS: Design and Build Websites - Jon Duckett]\"\n\n\"Način Polaganja: [Pismeni ispiti (40%); Projekti i razvoj aplikacija (40%); Laboratorijski rad i prezentacije (20%)]\"\n\n\"Napomene: [Praktični rad na projektima je ključan za uspešno savladavanje tehnika web razvoja.]\"\n','RWA'),(8,20,2,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',11,'Računarske Mreže','Predmet \"Računarske Mreže\" bavi se dizajnom, implementacijom i upravljanjem računarskim mrežama. Kurs obuhvata osnovne protokole, mrežne topologije i sigurnosne aspekte mreža.','\"1. Osnove Računarskih Mreža [Mrežne topologije; OSI i TCP/IP modeli; Mrežni uređaji]\"\n\n\"2. Protokoli i Tehnologije [IP adresiranje; Mrežni protokoli; Routing i switching]\"\n\n\"3. Mrežna Sigurnost [Sigurnosne pretnje; Metode zaštite; Firewall-i i VPN-ovi]\"\n\n\"4. Administracija Mreža [Upravljanje mrežama; Monitoring i dijagnostika; Konfiguracija i održavanje]\"\n\n\"Obavezna Literatura: [Computer Networking: Principles, Protocols and Practice - Olivier Bonaventure; Network+ Guide to Networks - Jill West, Tamara Dean, Jean Andrews]\"\n\n\"Preporučena Literatura: [Data and Computer Communications - William Stallings; Network Security Essentials - William Stallings]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Laboratorijski rad i vežbe (30%); Projekti i analiza slučajeva (20%)]\"\n\n\"Napomene: [Laboratorijski rad je ključan za sticanje praktičnih veština u mrežnoj administraciji i bezbednosti.]\"\n','RM'),(8,20,2,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',12,'Veštačka Inteligencija','Predmet \"Veštačka Inteligencija\" pokriva osnovne koncepte i tehnike u oblasti veštačke inteligencije, uključujući učenje mašina, duboko učenje, i primene AI u različitim domenima.','\"1. Uvod u Veštačku Inteligenciju [Osnovni pojmovi; Istorija i razvoj; Tehnike i metode]\"\n\n\"2. Učenje Mašina [Tipovi učenja; Algoritmi za nadgledano i nenadgledano učenje; Evaluacija modela]\"\n\n\"3. Duboko Učenje [Neuronske mreže; Konvolucione i rekurentne mreže; Primene dubokog učenja]\"\n\n\"4. Primene i Izazovi [Primene AI u industriji; Etika i bezbednost u AI; Trendovi i budućnost]\"\n\n\"Obavezna Literatura: [Artificial Intelligence: A Modern Approach - Stuart Russell, Peter Norvig; Deep\n','VI'),(8,20,3,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',13,'Osnove Menadžmenta','Predmet \"Osnove Menadžmenta\" pruža uvid u fundamentalne koncepte i teorije menadžmenta. Kurs pokriva osnovne funkcije menadžmenta, uključujući planiranje, organizovanje, vođenje i kontrolu.','\"1. Uvod u Menadžment [Definicija i značaj menadžmenta; Istorijski razvoj; Funkcije menadžmenta]\"\n\n\"2. Planiranje [Teorija i vrste planiranja; Proces planiranja; Postavljanje ciljeva]\"\n\n\"3. Organizovanje [Strukture organizacije; Raspodela zadataka; Organizacione kulture]\"\n\n\"4. Vođenje i Motivacija [Teorije liderstva; Motivacija zaposlenih; Komunikacija i donošenje odluka]\"\n\n\"5. Kontrola [Proces kontrole; Metode i alati; Evaluacija performansi]\"\n\n\"Obavezna Literatura: [Management: Theory and Practice - Gerald A. Cole; Principles of Management - Charles W. L. Hill, Steven L. McShane]\"\n\n\"Preporučena Literatura: [Management: A Global Perspective - Heinz Weihrich, Harold Koontz; Fundamentals of Management - Stephen P. Robbins, Mary Coulter]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza slučajeva (30%); Učešće u diskusijama (20%)]\"\n\n\"Napomene: [Aktivno učestvovanje u predavanjima i diskusijama je ključ za uspešno savladavanje gradiva.]\"\n','OME'),(8,20,3,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',14,'Organizacija i Strukturiranje Poslovanja','Predmet \"Organizacija i Strukturiranje Poslovanja\" bavi se razvojem i primenom organizacionih struktura i sistema. Kurs pokriva kako efikasno dizajnirati i implementirati organizacione strukture koje podržavaju poslovne ciljeve.','\"1. Organizacione Strukture [Vrste organizacionih struktura; Prednosti i mane; Primena u različitim industrijama]\"\n\n\"2. Dizajn Organizacije [Organizacioni dizajn; Teorije i modeli; Prilagođavanje strukture potrebama poslovanja]\"\n\n\"3. Upravljanje Timovima [Tehnike upravljanja timovima; Dinamika timskog rada; Konflikti i rešavanje]\"\n\n\"4. Promene i Razvoj [Upravljanje promenama; Proces reorganizacije; Evaluacija uspeha]\"\n\n\"Obavezna Literatura: [Organizational Behavior - Stephen P. Robbins, Timothy A. Judge; Organization Theory: Modern, Symbolic, and Postmodern Perspectives - Mary Jo Hatch]\"\n\n\"Preporučena Literatura: [Designing Effective Organizations - Jay R. Galbraith; The Fifth Discipline - Peter M. Senge]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Projekti i analiza slučajeva (30%); Diskusije i prezentacije (10%)]\"\n\n\"Napomene: [Kurs uključuje praktične studije slučajeva za primenu teorije u stvarnim situacijama.]\"\n','OISP'),(8,20,3,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',15,'Marketing i Strategija','Predmet \"Marketing i Strategija\" pokriva osnovne aspekte marketinga i razvoj marketinških strategija. Kurs istražuje kako razviti i implementirati strategije koje pomažu organizacijama da se takmiče na tržištu.','\"1. Uvod u Marketing [Osnovne komponente marketinga; Marketinška istraživanja; Segmentacija tržišta]\"\n\n\"2. Razvoj Marketinške Strategije [Postavljanje ciljeva; Pozicioniranje; Strategije proizvoda i cena]\"\n\n\"3. Marketinške Kampanje [Planiranje i implementacija kampanja; Promocija i distribucija; Evaluacija uspeha]\"\n\n\"4. Analiza i Praćenje [Analiziranje tržišnih trendova; Praćenje performansi; Prilagođavanje strategija]\"\n\n\"Obavezna Literatura: [Principles of Marketing - Philip Kotler, Gary Armstrong; Marketing Management - Philip Kotler, Kevin Lane Keller]\"\n\n\"Preporučena Literatura: [Strategic Marketing Management - Philip Kotler; Marketing: Real People, Real Choices - Michael R. Solomon]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza slučajeva (30%); Marketinške kampanje (20%)]\"\n\n\"Napomene: [Kurs obuhvata rad na stvarnim marketinškim projektima i kampanjama.]\"\n','MIS'),(8,20,3,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',16,'Finansijski Menadžment','Predmet \"Finansijski Menadžment\" pruža znanje o osnovnim principima upravljanja finansijama u organizaciji. Kurs uključuje analizu finansijskih izveštaja, budžetiranje i procenu investicija.','\"1. Osnovne Finansijske Koncepti [Finansijski izveštaji; Analiza bilansa stanja i bilansa uspeha; Novčani tokovi]\"\n\n\"2. Budžetiranje i Planiranje [Kreiranje budžeta; Kontrola troškova; Planiranje kapitala]\"\n\n\"3. Procena Investicija [Metode procene; Diskontovani novčani tok; Povraćaj investicija]\"\n\n\"4. Upravljanje Rizikom [Identifikacija rizika; Strategije za upravljanje rizikom; Finansijski instrumenti]\"\n\n\"Obavezna Literatura: [Principles of Corporate Finance - Richard A. Brealey, Stewart C. Myers; Financial Management: Theory and Practice - Eugene F. Brigham, Michael C. Ehrhardt]\"\n\n\"Preporučena Literatura: [Corporate Finance - Jonathan Berk, Peter DeMarzo; Financial Statement Analysis - K. R. Subramanyam, John J. Wild]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Projekti i analiza finansijskih izveštaja (30%); Diskusije (10%)]\"\n\n\"Napomene: [Kurs uključuje rad sa stvarnim finansijskim podacima i izveštajima.]\"\n','FM'),(8,20,3,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',17,'Menadžment Ljudskih Resursa','Predmet \"Menadžment Ljudskih Resursa\" pokriva ključne aspekte upravljanja ljudskim resursima, uključujući zapošljavanje, obuku, razvoj i evaluaciju zaposlenih.','\"1. Uvod u Menadžment Ljudskih Resursa [Uloga i značaj; Funkcije HR; Strategije upravljanja ljudskim resursima]\"\n\n\"2. Proces Zapošljavanja [Prikupljanje i selekcija kandidata; Intervjui i evaluacija; Onboarding]\"\n\n\"3. Razvoj i Obuka [Planiranje obuka; Evaluacija efikasnosti; Profesionalni razvoj]\"\n\n\"4. Evaluacija Performansi i Motivacija [Sistemi ocenjivanja performansi; Motivacione teorije; Nagrade i priznanja]\"\n\n\"Obavezna Literatura: [Human Resource Management - Gary Dessler; Managing Human Resources - Wayne F. Cascio]\"\n\n\"Preporučena Literatura: [The New HR Leader\'s First 100 Days - Alan Collins; Strategic Human Resource Management - Jeffrey A. Mello]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza slučajeva (30%); Rad u grupama i prezentacije (20%)]\"\n\n\"Napomene: [Kurs uključuje praktične vežbe i simulacije za razvoj veština u upravljanju ljudskim resursima.]\"\n','MLJR'),(8,20,3,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',18,'Preduzetništvo i Inovacije','Predmet \"Preduzetništvo i Inovacije\" bavi se razvojem preduzetničkog duha i inovativnih veština. Kurs pokriva kako razviti i implementirati inovativne ideje i poslovne modele.','\"1. Osnove Preduzetništva [Definicija i karakteristike preduzetništva; Preduzetnički proces; Razvijanje poslovne ideje]\"\n\n\"2. Razvoj Poslovnog Modela [Pisanje poslovnog plana; Analiza tržišta; Razvoj strategije i implementacija]\"\n\n\"3. Inovacije i Kreativnost [Teorije inovacija; Kreativni proces; Tehnike za stimulaciju inovacija]\"\n\n\"4. Upravljanje Preduzetničkim Poduhvatima [Finansijsko upravljanje; Upravljanje rastom; Evaluacija i prilagođavanje]\"\n\n\"Obavezna Literatura: [The Lean Startup - Eric Ries; Entrepreneurship: Theory, Process, and Practice - Donald F. Kuratko]\"\n\n\"Preporučena Literatura: [Business Model Generation - Alexander Osterwalder, Yves Pigneur; Innovation and Entrepreneurship\n','PII'),(8,20,4,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',19,'Osnove Poslovne Ekonomije','Predmet \"Osnove Poslovne Ekonomije\" pruža uvod u osnovne ekonomske principe koji su relevantni za poslovno okruženje. Kurs obuhvata osnovne ekonomske teorije, tržišne strukture i ekonomske pokazatelje.','\"1. Uvod u Poslovnu Ekonomiju [Definicija i značaj; Ekonomija kao društvena nauka; Ekonomija u poslovnom kontekstu]\"\n\n\"2. Osnovni Ekonomski Principi [Ponuda i potražnja; Elastičnost; Teorija cena]\"\n\n\"3. Tržišne Strukture [Savršena konkurencija; Monopol; Oligopol i monopolistička konkurencija]\"\n\n\"4. Ekonomski Pokazatelji i Politike [BDP; Inflacija; Nezaposlenost; Fiskalna i monetarna politika]\"\n\n\"Obavezna Literatura: [Principles of Economics - N. Gregory Mankiw; Microeconomics - Robert S. Pindyck, Daniel L. Rubinfeld]\"\n\n\"Preporučena Literatura: [Macroeconomics - Olivier Blanchard; Economics: Theory and Applications - David Begg, Stanley Fischer, Rudiger Dornbusch]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza slučajeva (30%); Diskusije i participacija (20%)]\"\n\n\"Napomene: [Kurs je osmišljen da pruža solidne temelje za dalji studij ekonomskih teorija i njihovih primena.]\"\n','OPE'),(8,20,4,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',20,'Računovodstvo za Menadžere','Predmet \"Računovodstvo za Menadžere\" fokusira se na osnovne računovodstvene koncepte i tehnike relevantne za menadžment. Kurs pokriva finansijske izveštaje, analizu troškova i donošenje odluka na osnovu računovodstvenih informacija.','\"1. Osnovni Računovodstveni Koncepti [Finansijski izveštaji; Bilans stanja i bilans uspeha; Novčani tokovi]\"\n\n\"2. Troškovi i Budžetiranje [Vrste troškova; Budžetiranje i planiranje; Analiza troškova]\"\n\n\"3. Računovodstvo Troškova [Direktni i indirektni troškovi; Metode obračuna troškova; Kontrola troškova]\"\n\n\"4. Analiza Finansijskih Izveštaja [Razumevanje i analiza izveštaja; Ključni pokazatelji performansi; Upotreba u donošenju odluka]\"\n\n\"Obavezna Literatura: [Managerial Accounting - Ray H. Garrison, Eric Noreen, Peter C. Brewer; Financial Accounting for Managers - Paul M. Collier]\"\n\n\"Preporučena Literatura: [Cost Accounting: A Managerial Emphasis - Charles T. Horngren; Financial and Managerial Accounting - John J. Wild, K. R. Subramanyam]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Projekti i analiza slučajeva (30%); Laboratorijski rad i zadaci (10%)]\"\n\n\"Napomene: [Praktična primena računovodstvenih metoda je ključna za uspešno savladavanje kursa.]\"\n','RZM'),(8,20,4,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',21,'Finansijska Analiza i Planiranje','Predmet \"Finansijska Analiza i Planiranje\" bavi se analizom finansijskih izveštaja i planiranjem finansijskih aktivnosti preduzeća. Kurs pokriva tehnike procene finansijskog zdravlja i donošenja finansijskih odluka.','\"1. Analiza Finansijskih Izveštaja [Metode analize; Koeficijenti i pokazatelji; Trend analiza]\"\n\n\"2. Planiranje i Kontrola [Budžetiranje; Planiranje kapitala; Kontrola finansijskih performansi]\"\n\n\"3. Procena Investicija [Evaluacija investicija; Diskontovani novčani tok; Analiza rizika]\"\n\n\"4. Finansijsko Planiranje [Strategije finansijskog planiranja; Upravljanje novčanim tokom; Planiranje rasta]\"\n\n\"Obavezna Literatura: [Financial Statement Analysis and Security Valuation - Stephen H. Penman; Financial Planning & Analysis and Performance Management - Jack Alexander]\"\n\n\"Preporučena Literatura: [Principles of Corporate Finance - Richard A. Brealey, Stewart C. Myers; Valuation: Measuring and Managing the Value of Companies - McKinsey & Company Inc., Tim Koller]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza finansijskih izveštaja (30%); Diskusije i vežbe (20%)]\"\n\n\"Napomene: [Kurs uključuje rad na stvarnim poslovnim slučajevima i analizama.]\"\n','FAIP'),(8,20,4,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',22,'Menadžment Operacija','Predmet \"Menadžment Operacija\" fokusira se na upravljanje operacijama u organizaciji. Kurs pokriva optimizaciju procesa, upravljanje kvalitetom i strategije za poboljšanje operativne efikasnosti.','\"1. Uvod u Menadžment Operacija [Osnovni koncepti; Uloga operacija u organizaciji; Ciljevi i strategije]\"\n\n\"2. Upravljanje Procesima [Dizajn procesa; Analiza i optimizacija; Lean i Six Sigma metodologije]\"\n\n\"3. Upravljanje Kvalitetom [Tehnike upravljanja kvalitetom; Kontrola kvaliteta; Standardi i sertifikacije]\"\n\n\"4. Logistika i Lanac Snabdevanja [Upravljanje nabavkom; Distribucija i skladištenje; Planiranje lanca snabdevanja]\"\n\n\"Obavezna Literatura: [Operations Management - Jay Heizer, Barry Render; Managing Operations Across the Supply Chain - Morgan Swink, Steven A. Melnyk, K. Linda, William J. Stevenson]\"\n\n\"Preporučena Literatura: [The Goal: A Process of Ongoing Improvement - Eliyahu M. Goldratt; Lean Thinking - James P. Womack, Daniel T. Jones]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza slučajeva (30%); Laboratorijski rad i vežbe (20%)]\"\n\n\"Napomene: [Praktičan rad na projektima je ključan za razumevanje operativnog menadžmenta.]\"\n','MO'),(8,20,4,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',23,'Ekonomija Preduzetništva','Predmet \"Ekonomika Preduzetništva\" analizira ekonomske aspekte preduzetništva, uključujući razvoj poslovnih ideja, procenu tržišta i strategije za uspešno vođenje preduzeća.','\"1. Uvod u Preduzetništvo [Osnovne karakteristike; Preduzetnički proces; Razvoj poslovne ideje]\"\n\n\"2. Ekonomika Poslovanja [Analiza tržišta; Postavljanje ciljeva; Finansijsko planiranje]\"\n\n\"3. Strategije Rasta i Razvoja [Planiranje rasta; Upravljanje rastom; Internacionalizacija]\"\n\n\"4. Izazovi i Rizici [Identifikacija rizika; Upravljanje neizvesnostima; Strategije za prevazilaženje izazova]\"\n\n\"Obavezna Literatura: [Entrepreneurship: Theory, Process, and Practice - Donald F. Kuratko; The Lean Startup - Eric Ries]\"\n\n\"Preporučena Literatura: [Business Model Generation - Alexander Osterwalder, Yves Pigneur; Start with Why - Simon Sinek]\"\n\n\"Način Polaganja: [Pismeni ispiti (40%); Projekti i poslovni planovi (40%); Diskusije i prezentacije (20%)]\"\n\n\"Napomene: [Kurs uključuje razvoj i prezentaciju poslovnih planova kao ključnu komponentu.]\"\n','EP'),(8,20,4,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',24,'Menadžment Promena','Predmet \"Menadžment Promena\" fokusira se na strategije i tehnike za upravljanje promenama unutar organizacije. Kurs pokriva procese, izazove i metodologije za efikasno sprovođenje promena.','\"1. Osnove Menadžmenta Promena [Definicija i značaj; Proces promena; Teorije i modeli]\"\n\n\"2. Planiranje i Implementacija Promena [Strategije planiranja; Komunikacija promena; Uključivanje zaposlenih]\"\n\n\"3. Izazovi i Prepreke [Prepreke u sprovođenju promena; Uloga liderstva; Strategije za prevazilaženje izazova]\"\n\n\"4. Evaluacija i\n','MP'),(8,20,5,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',25,'Osnove Kriminalistike','Predmet \"Osnove Kriminalistike\" pruža osnovne informacije o kriminalistici kao disciplini. Kurs pokriva ključne koncepte i tehnike u istraživanju kriminalnih dela, uključujući forenziku i metode istrage.','\"1. Uvod u Kriminalistiku [Definicija; Istorijski razvoj; Uloga kriminalistike u pravdi]\"\n\n\"2. Kriminalistička Istraživanja [Metode istraživanja; Prikupljanje i analiza dokaza; Forenzika]\"\n\n\"3. Kriminalistička Teorija [Teorije kriminalnog ponašanja; Profilisanje; Tipologije kriminalaca]\"\n\n\"4. Pravne i Etike Aspekti [Pravna regulativa; Etika u istraživanju; Prava osumnjičenih]\"\n\n\"Obavezna Literatura: [Criminalistics: An Introduction to Forensic Science - Richard Saferstein; Criminal Investigation - Charles R. Swanson, Leonard Territo, Robert W. Taylor]\"\n\n\"Preporučena Literatura: [Forensic Science: From the Crime Scene to the Crime Lab - Richard Saferstein; The Forensic Science Handbook - Dr. Thomas A. Gettings]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza slučajeva (30%); Aktivno učestvovanje u predavanjima (20%)]\"\n\n\"Napomene: [Kurs uključuje analizu stvarnih kriminalističkih slučajeva i primenu teorije u praksi.]\"\n','OK'),(8,20,5,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',26,'Forenzička Nauka','Predmet \"Forenzička Nauka\" pokriva metode i tehnike u forenzičkoj analizi koje se koriste za rešavanje kriminalnih slučajeva. Kurs obuhvata analizu fizičkih dokaza, identifikaciju i laboratorijsku analizu.','\"1. Uvod u Forenziku [Osnovni principi; Vrste forenzičkih analiza; Uloga forenzike u krivičnom postupku]\"\n\n\"2. Forenzička Analiza Dokaza [Tehnike analize; Biološki dokazi; Hemijski i fizički dokazi]\"\n\n\"3. Metode Istraživanja [Prikupljanje i čuvanje dokaza; Laboratorijska analiza; Interpretacija rezultata]\"\n\n\"4. Izveštavanje i Svedočenje [Pisanje forenzičkih izveštaja; Svedočenje u sudu; Uloga forenzičara u pravdi]\"\n\n\"Obavezna Literatura: [Forensic Science: Fundamentals and Investigations - David M. R. G. Davis, Gregor G. V. D. K. Davis; Forensic Science: An Introduction to Scientific and Investigative Techniques - Stuart H. James, Jon J. Nordby]\"\n\n\"Preporučena Literatura: [Introduction to Forensic Science and Criminalistics - Robert W. McCrie; Principles of Forensic Science - Patrick J. G. Jones]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Projekti i laboratorijski rad (30%); Diskusije i učešće u vežbama (10%)]\"\n\n\"Napomene: [Praktične vežbe i laboratorijski rad su ključni za razumevanje forenzičkih tehnika.]\"\n','FN'),(8,20,5,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',27,'Kriminalistička Psihologija','Predmet \"Kriminalistička Psihologija\" bavi se proučavanjem psiholoških aspekata kriminalnog ponašanja. Kurs istražuje motive, mentalne poremećaje i psihološke profile kriminalaca.','\"1. Uvod u Kriminalističku Psihologiju [Definicija i značaj; Psihološki aspekti kriminalnog ponašanja; Psihopatologija]\"\n\n\"2. Profilisanje Kriminalaca [Metode profilisanja; Razumevanje motivacije; Teorije kriminalnog ponašanja]\"\n\n\"3. Mentalni Poremećaji i Kriminalitet [Povezanost mentalnih poremećaja i kriminalnih dela; Psihopatija; Sociopatija]\"\n\n\"4. Psihološki Uticaj na Istraživanje [Psihološki efekti na žrtve i osumnjičene; Uloga psihologa u istragama]\"\n\n\"Obavezna Literatura: [Criminal Behavior: A Psychosocial Approach - David M. W. K. Eysenck, H. J. Eysenck; The Psychology of Crime and Criminal Justice - Andrew E. Taslitz]\"\n\n\"Preporučena Literatura: [Profiling Violent Crimes - Ronald M. Holmes, Stephen T. Holmes; The Criminal Mind: A Study of Psychological Disorders - Walter L. Langer]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza slučajeva (30%); Diskusije i prezentacije (20%)]\"\n\n\"Napomene: [Kurs se fokusira na razumevanje psiholoških aspekata kriminalnog ponašanja kroz studije slučajeva.]\"\n','KP'),(8,20,5,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',28,'Bezbednost i Zaštita','Predmet \"Bezbednost i Zaštita\" istražuje aspekte fizičke i informatičke bezbednosti u organizacijama. Kurs pokriva strategije i tehnike za zaštitu resursa i informacija od pretnji.','\"1. Uvod u Bezbednost [Osnovni principi; Vrste bezbednosnih pretnji; Strategije zaštite]\"\n\n\"2. Fizička Bezbednost [Zaštita objekata; Kontrola pristupa; Bezbednosni sistemi]\"\n\n\"3. Informatička Bezbednost [Zaštita informacionih sistema; Kriptografija; Upravljanje rizikom u IT-u]\"\n\n\"4. Planiranje i Reakcija na Incident [Razvoj plana bezbednosti; Reakcija na incidente; Evaluacija i obuka]\"\n\n\"Obavezna Literatura: [Principles of Information Security - Michael E. Whitman, Herbert J. Mattord; Security Risk Management: Building an Information Security Risk Management Program - Evan Wheeler]\"\n\n\"Preporučena Literatura: [Introduction to Security - Robert R. Moeller; Information Security Management Handbook - Harold F. Tipton, Micki Krause]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza bezbednosnih planova (30%); Diskusije i simulacije (20%)]\"\n\n\"Napomene: [Kurs uključuje rad na realnim scenarijima i pripremu planova za bezbednost.]\"\n','BIZ'),(8,20,5,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',29,'Zakonodavstvo i Kriminalistika','Predmet \"Zakonodavstvo i Kriminalistika\" fokusira se na pravne aspekte kriminalistike, uključujući zakone i regulative koje regulišu kriminalističke istrage i postupke.','\"1. Uvod u Zakonodavstvo i Kriminalistiku [Pravni sistem; Zakoni i regulative; Uloga zakona u istraživanju kriminala]\"\n\n\"2. Kriminalistički Postupci [Postupak hapšenja; Prikupljanje i čuvanje dokaza; Prava osumnjičenih]\"\n\n\"3. Dokazi i Pravni Standardi [Vrste dokaza; Prihvatljivost dokaza; Teret dokazivanja]\"\n\n\"4. Suđenje i Kriminalistička Svjedočenja [Uloga kriminalista u sudskom postupku; Prikazivanje dokaza; Svedočenje u sudu]\"\n\n\"Obavezna Literatura: [Criminal Procedure: Principles, Policies, and Perspectives - Robert M. Bloom; Evidence and Procedure - Gary B. Melton]\"\n\n\"Preporučena Literatura: [Criminal Justice Procedure - Barry Latzer; The Law of Evidence - David P. Leonard]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Projekti i analiza slučajeva (30%); Diskusije i učešće (10%)]\"\n\n\"Napomene: [Kurs uključuje analizu zakonskih normi i procedura kroz studije slučajeva.]\"\n','ZIK'),(8,20,5,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',30,'Upravljanje Kriminalitetom','Predmet \"Upravljanje Kriminalitetom\" istražuje strategije i tehnike za prevenciju i kontrolu kriminaliteta. Kurs pokriva politike, programe i metode za smanjenje kriminalnih aktivnosti u zajednici.','\"1. Uvod u Upravljanje Kriminalitetom [Definicija; Strategije i politike; Uloga vlasti i zajednice]\"\n\n\"2. Prevencija Kriminaliteta [Preventivni programi; Komunitarna bezbednost; Uloga obrazovanja i socijalnih programa]\"\n\n\"3. Analiza Kriminalnih Podataka [Metode prikupljanja podataka; Analiza i interpretacija; Primenjivanje u prevenciji]\"\n\n\"4. Evaluacija i Implementacija Strategija [Procena uspešnosti; Prilagođavanje strategija; Izazovi i prepreke]\"\n\n\"Obavezna Literatura: [Crime Prevention: Approaches, Practices, and Evaluations - Steven P. Lab; The Science of Crime Prevention - Tim Newburn]\"\n\n\"Preporučena Literatura: [Community Policing: A Policing Strategy for the Future - Stephen D. Mastrofski; Crime and Public Policy - James Q. Wilson, Joan Petersilia]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza strategija (30%); Diskusije i evaluacija programa (20%)]\"\n\n\"Napomene: [Kurs se fokusira na razvoj i primenu strategija za prevenciju kriminala u zajednici.]\"\n','UK'),(8,20,6,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',31,'Uvod u Pravo','Predmet \"Uvod u Pravo\" pruža osnovne informacije o pravnom sistemu, uključujući pravne teorije, izvore prava i osnovne pravne koncepte. Kurs je dizajniran da pruži čvrste temelje za dalji studij prava.','\"1. Osnovne Teorije i Koncepti [Šta je pravo; Teorije prava; Pravni sistem i pravne norme]\"\n\n\"2. Izvori Prava [Ustav; Zakoni; Pravni akti i regulative]\"\n\n\"3. Pravni Subjekti i Akti [Pravni subjekti; Pravni akti i njihova funkcija; Tumačenje pravnih normi]\"\n\n\"4. Uloga Prava u Društvu [Pravo i društvo; Uloga prava u regulaciji društvenih odnosa; Pravo i pravda]\"\n\n\"Obavezna Literatura: [Introduction to Law - H. Patrick Glenn; Legal Environment of Business - Jeffrey F. Beatty, Susan S. Samuelson]\"\n\n\"Preporučena Literatura: [Law 101: Everything You Need to Know About the American Legal System - Jay M. Feinman; An Introduction to Legal Reasoning - Edward H. Levi]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Učestvovanje u predavanjima i diskusijama (20%); Projekti i prezentacije (20%)]\"\n\n\"Napomene: [Kurs daje pregled osnovnih pravnih koncepata i pravnog sistema, priprema za dublje proučavanje prava.]\"\n','UUP'),(8,20,6,'2024-09-01 00:00:00.000000','2025-01-20 00:00:00.000000',32,'Građansko Pravo','Predmet \"Građansko Pravo\" bavi se pravnim pravilima koja uređuju odnose među fizičkim i pravnim licima, uključujući ugovore, obaveze i prava. Kurs pruža duboko razumevanje građanskog zakonodavstva.','\"1. Osnovi Građanskog Prava [Definicija; Glavni principi; Pravni odnosi i obaveze]\"\n\n\"2. Ugovori i Obaveze [Vrste ugovora; Pravni efekti ugovora; Obaveze stranaka]\"\n\n\"3. Imovinsko Pravo [Prava na imovinu; Prenos imovine; Prava na nasledstvo]\"\n\n\"4. Odgovornost i Naknada Štete [Vrste odgovornosti; Naknada štete; Pravni lekovi]\"\n\n\"Obavezna Literatura: [Principles of Civil Law - Peter Cane; Civil Law and Justice - Paul Mitchell]\"\n\n\"Preporučena Literatura: [Contracts: Cases and Doctrine - Randy E. Barnett; Introduction to the Law of Property - Thomas W. Merrill]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Analiza slučajeva i projekti (30%); Diskusije i prezentacije (20%)]\"\n\n\"Napomene: [Kurs uključuje rad na realnim slučajevima i primenu građanskog prava u praksi.]\"\n','GP'),(8,20,6,'2025-01-20 00:00:00.000000','2024-09-01 00:00:00.000000',33,'Krivično Pravo','Predmet \"Krivično Pravo\" proučava pravne norme koje regulišu krivična dela i kazne. Kurs obuhvata definicije krivičnih dela, vrste kazni i postupke krivičnog prava.','\"1. Osnovi Krivičnog Prava [Definicija; Glavni principi; Uloga krivičnog prava]\"\n\n\"2. Krivična Dela [Vrste krivičnih dela; Elementi krivičnog dela; Krivična odgovornost]\"\n\n\"3. Kazne i Krivične Sankcije [Vrste kazni; Postupci izricanja kazni; Specijalne kazne i mere]\"\n\n\"4. Krivični Postupak [Postupak suđenja; Prava optuženih; Dokazi i presudne odluke]\"\n\n\"Obavezna Literatura: [Criminal Law: Cases and Materials - Donna C. Schaefer; Criminal Law and Procedure - Stephen A. Saltzburg, Daniel J. Capra]\"\n\n\"Preporučena Literatura: [Principles of Criminal Law - Andrew Ashworth; Criminal Justice: An Introduction to the Criminal Justice System - Michael J. Saks, John F. Hagan]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Projekti i analiza slučajeva (20%); Diskusije i vežbe (20%)]\"\n\n\"Napomene: [Kurs uključuje detaljno proučavanje krivičnih zakona i postupaka kroz analize slučajeva.]\"\n','KPR'),(8,20,6,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',34,'Ustavno Pravo','Predmet \"Ustavno Pravo\" fokusira se na proučavanje ustava i osnovnih principa koji regulišu organizaciju vlasti i ljudska prava. Kurs obuhvata analizu ustavnih normi i njihovu primenu.','\"1. Uvod u Ustavno Pravo [Definicija; Značaj ustava; Osnovni principi]\"\n\n\"2. Organizacija Vlasti [Tri grane vlasti; Ovlašćenja i nadležnosti; Uloga ustava u organizaciji vlasti]\"\n\n\"3. Ljudska Prava [Osnovna ljudska prava; Zaštita prava; Ograničenja i izuzeci]\"\n\n\"4. Primenjivanje Ustava [Ustavni sud; Interpretacija ustavnih normi; Ustavne promene]\"\n\n\"Obavezna Literatura: [Constitutional Law: Principles and Policies - Erwin Chemerinsky; Constitutional Law - Michael C. Dorf]\"\n\n\"Preporučena Literatura: [The Federalist Papers - Alexander Hamilton, James Madison, John Jay; The Law of the Constitution - A.V. Dicey]\"\n\n\"Način Polaganja: [Pismeni ispiti (50%); Projekti i analiza ustavnih slučajeva (30%); Diskusije i prezentacije (20%)]\"\n\n\"Napomene: [Kurs pruža duboko razumevanje ustavnih normi i njihovog uticaja na pravni sistem.]\"\n','USP'),(8,20,6,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',35,'Administrativno Pravo','Predmet \"Administrativno Pravo\" proučava pravne norme koje regulišu odnose između građana i državnih organa. Kurs se fokusira na administrativne procedure, prava i obaveze.','\"1. Uvod u Administrativno Pravo [Definicija; Osnovni principi; Uloga administrativnog prava]\"\n\n\"2. Administrativni Organi i Postupci [Organizacija i nadležnosti; Postupci odlučivanja; Prava stranaka]\"\n\n\"3. Administrativne Sankcije [Vrste sankcija; Postupak izricanja sankcija; Pravni lekovi]\"\n\n\"4. Pravni Lekovi i Kontrola [Kontrola i nadzor; Postupak žalbe; Uloga sudova]\"\n\n\"Obavezna Literatura: [Administrative Law: Cases and Materials - Peter L. Strauss, Richard J. Pierce Jr., Cass R. Sunstein; Administrative Law and Process - Jerry L. Mashaw]\"\n\n\"Preporučena Literatura: [Principles of Administrative Law - Philip A. Hamburger; Administrative Law: A Very Short Introduction - Keith Hawkins]\"\n\n\"Način Polaganja: [Pismeni ispiti (60%); Projekti i analiza administrativnih slučajeva (20%); Diskusije i vežbe (20%)]\"\n\n\"Napomene: [Kurs uključuje rad na administrativnim postupcima i analizama stvarnih slučajeva.]\"\n','AP'),(8,20,6,'2025-06-01 00:00:00.000000','2025-02-05 00:00:00.000000',36,'Međunarodno Pravo','Predmet \"Međunarodno Pravo\" bavi se pravnim normama koje regulišu odnose između država i drugih međunarodnih aktera. Kurs pokriva međunarodne ugovore, organizacije i sporove.','\"1. Uvod u Međunarodno Pravo [Definicija; Osnovni principi; Izvori međunarodnog prava]\"\n\n\"2. Međunarodni Ugovori i Organizacije [Vrste međunarodnih ugovora; Uloga međunarodnih organizacija; Sporazumi i konvencije]\"\n\n\"3. Međunarodni Sukobi i Rešenja [Metode rešavanja sporova; Međunarodni sudovi; Diplomatska rešenja]\"\n\n\"4. Ljudska Prava u Međunarodnom Pravu [Internacionalni standardi; Zaštita ljudskih prava; Međunarodne obaveze]\"\n\n\"Obavezna Literatura: [International Law: Cases and Materials - David Harris, Sandesh Sivakumaran; International Law - Malcolm N. Shaw]\"\n\n\"Preporučena Literatura: [Principles of International Law - Jan Klabbers; International Law: A Very Short Introduction - Vaughan Lowe]\"\n\n\"Način Polaganja: [Pismeni ispiti\n','MPR');
/*!40000 ALTER TABLE `predmeti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrovani_korisnici`
--

DROP TABLE IF EXISTS `registrovani_korisnici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrovani_korisnici` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `univerzitet_id` bigint DEFAULT NULL,
  `dtype` varchar(31) NOT NULL,
  `biografija` varchar(255) DEFAULT NULL,
  `broj_indeksa` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `jmbg` varchar(255) DEFAULT NULL,
  `korisnicko_ime` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `fakultet_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK154urb2oxpgfsnfu2qywj33ja` (`email`),
  KEY `FKp2ls3ml3cg2k5lit6iqgs00yv` (`univerzitet_id`),
  KEY `FK852rhw4euj0pvh5olleur8a4p` (`fakultet_id`),
  CONSTRAINT `FK852rhw4euj0pvh5olleur8a4p` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`id`),
  CONSTRAINT `FKp2ls3ml3cg2k5lit6iqgs00yv` FOREIGN KEY (`univerzitet_id`) REFERENCES `univerzitet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrovani_korisnici`
--

LOCK TABLES `registrovani_korisnici` WRITE;
/*!40000 ALTER TABLE `registrovani_korisnici` DISABLE KEYS */;
INSERT INTO `registrovani_korisnici` VALUES (5,NULL,'Administrator',NULL,NULL,'admin@email.rs','adminn',NULL,'admin','$2a$10$ZanHeNpNZ2ae6AUt32y.FOSnUvwRbzBSRmJnB6AYshgpLXiU0EXC.','adminovic',NULL),(6,NULL,'Student',NULL,'12345','student@email.rs','studentIme',NULL,'student','$2a$10$iNVPiYGihKeCDFj8QVToWuGp8q6ZCNYwSnjQDu9uJ.wZYn7o0AL1W','prezimeStudenta',NULL),(8,NULL,'Nastavnik',NULL,NULL,'nastavnik@email.rs','Jovan',NULL,'nastavnik','$2a$10$hXqAF38NQ.QCrFR84ztsSe13W5/LY1lybyOqMewUlPXxOLzZ1cZ92','Jovic',NULL),(9,NULL,'StudentskaSluzba',NULL,NULL,'sluzba@email.rs','sluzba',NULL,'asdasd','$2a$10$G0yBZWbv3rDqoNHHqNQGHeDTn144mL.ZVifWyRhcUnHU/yc52GnV2','sluzba',NULL),(10,NULL,'RegistrovaniKorisnik',NULL,NULL,'korisnik@email.rs',NULL,NULL,'korisnik','$2a$10$FuNwB0ZQ23DlLQLTPBxlt.FmEQi0prEcGUirzq75dhIswv3jtEyC.',NULL,NULL),(20,NULL,'Nastavnik',NULL,NULL,'gggggggg@ggggg','gggggg',NULL,NULL,'$2a$10$hXqAF38NQ.QCrFR84ztsSe13W5/LY1lybyOqMewUlPXxOLzZ1cZ92','ggggggg',NULL);
/*!40000 ALTER TABLE `registrovani_korisnici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrovani_korisnik_permissions`
--

DROP TABLE IF EXISTS `registrovani_korisnik_permissions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrovani_korisnik_permissions` (
  `permission_id` bigint NOT NULL,
  `registrovani_korisnik_id` bigint NOT NULL,
  PRIMARY KEY (`permission_id`,`registrovani_korisnik_id`),
  KEY `FKead4qs11ht56rwmomx9skplrg` (`registrovani_korisnik_id`),
  CONSTRAINT `FK4jd1v3yiu8f0tcds3x7lon6ui` FOREIGN KEY (`permission_id`) REFERENCES `permissions` (`id`),
  CONSTRAINT `FKead4qs11ht56rwmomx9skplrg` FOREIGN KEY (`registrovani_korisnik_id`) REFERENCES `registrovani_korisnici` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrovani_korisnik_permissions`
--

LOCK TABLES `registrovani_korisnik_permissions` WRITE;
/*!40000 ALTER TABLE `registrovani_korisnik_permissions` DISABLE KEYS */;
INSERT INTO `registrovani_korisnik_permissions` VALUES (4,5),(2,6),(5,8),(3,9),(1,10),(5,20);
/*!40000 ALTER TABLE `registrovani_korisnik_permissions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rektorat`
--

DROP TABLE IF EXISTS `rektorat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rektorat` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `adresa` varchar(255) DEFAULT NULL,
  `kontakt` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `slika` varchar(255) DEFAULT NULL,
  `ime_rektora` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rektorat`
--

LOCK TABLES `rektorat` WRITE;
/*!40000 ALTER TABLE `rektorat` DISABLE KEYS */;
INSERT INTO `rektorat` VALUES (1,'Bulevar PAtrijarha Pavla 3','email: lms.rektorat@unimail.rs','Rektorat LMS Univerziteta',NULL,'Petar Petrovic');
/*!40000 ALTER TABLE `rektorat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_na_godini`
--

DROP TABLE IF EXISTS `student_na_godini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_na_godini` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `datum_upisa` date DEFAULT NULL,
  `godina_studija_id` bigint NOT NULL,
  `student_id` bigint NOT NULL,
  `studijski_program_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`,`student_id`,`godina_studija_id`),
  KEY `FKa0qj2cperexvshppcmuh1a1s7` (`godina_studija_id`),
  KEY `FK4ilu9airwx34ffla0u78qa2bn` (`student_id`),
  KEY `FKdjefxfrflets795wj2pnp0h4h` (`studijski_program_id`),
  CONSTRAINT `FK4ilu9airwx34ffla0u78qa2bn` FOREIGN KEY (`student_id`) REFERENCES `registrovani_korisnici` (`id`),
  CONSTRAINT `FKa0qj2cperexvshppcmuh1a1s7` FOREIGN KEY (`godina_studija_id`) REFERENCES `godina_studija` (`id`),
  CONSTRAINT `FKdjefxfrflets795wj2pnp0h4h` FOREIGN KEY (`studijski_program_id`) REFERENCES `studijski_programi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_na_godini`
--

LOCK TABLES `student_na_godini` WRITE;
/*!40000 ALTER TABLE `student_na_godini` DISABLE KEYS */;
INSERT INTO `student_na_godini` VALUES (1,'2022-03-05',1,6,1);
/*!40000 ALTER TABLE `student_na_godini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studenti_predmeti`
--

DROP TABLE IF EXISTS `studenti_predmeti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studenti_predmeti` (
  `student_id` bigint NOT NULL,
  `predmet_id` bigint NOT NULL,
  PRIMARY KEY (`student_id`,`predmet_id`),
  KEY `FKtmd8fpnsj1nyd7fwmb8y0824` (`predmet_id`),
  CONSTRAINT `FK3o069y2ykfyvix9m1v1x00r2i` FOREIGN KEY (`student_id`) REFERENCES `registrovani_korisnici` (`id`),
  CONSTRAINT `FKtmd8fpnsj1nyd7fwmb8y0824` FOREIGN KEY (`predmet_id`) REFERENCES `predmeti` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studenti_predmeti`
--

LOCK TABLES `studenti_predmeti` WRITE;
/*!40000 ALTER TABLE `studenti_predmeti` DISABLE KEYS */;
INSERT INTO `studenti_predmeti` VALUES (6,1),(6,2),(6,3),(6,4),(6,5),(6,6);
/*!40000 ALTER TABLE `studenti_predmeti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studijski_programi`
--

DROP TABLE IF EXISTS `studijski_programi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studijski_programi` (
  `fakultet_id` bigint NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  `opis` longtext,
  `rukovodilac` varchar(255) DEFAULT NULL,
  `sifrasp` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsbeatm8vm0qft0x8foj8963m3` (`fakultet_id`),
  CONSTRAINT `FKsbeatm8vm0qft0x8foj8963m3` FOREIGN KEY (`fakultet_id`) REFERENCES `fakultet` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studijski_programi`
--

LOCK TABLES `studijski_programi` WRITE;
/*!40000 ALTER TABLE `studijski_programi` DISABLE KEYS */;
INSERT INTO `studijski_programi` VALUES (1,1,'Masinstvo','Na Mašinskom i Tehničkom fakultetu LMS Univerziteta, smer Mašinstvo pruža studentima sveobuhvatan obrazovni program koji spaja osnovne principe inženjeringa sa najnovijim tehnološkim dostignućima. Ovaj smer je dizajniran da studentima omogući duboko razumevanje ključnih aspekata mašinstva, uključujući konstrukciju, analizu i upravljanje mehaničkim sistemima. Studijski program obuhvata temeljne oblasti kao što su mehanika, termodinamika, materijali i tehnologije obrade, ali takođe pruža i napredne kurseve u dizajnu mašinskih komponenti, energetski efikasnim sistemima i automatizaciji. Kroz integraciju teorijskog znanja sa praktičnim iskustvima, studenti stiču ne samo akademsku osnovu već i veštine koje su ključne za uspeh u industriji. Fakultet se ponosi modernim laboratorijama i istraživačkim centrima koji omogućavaju studentima da se upoznaju sa savremenim tehnologijama i metodama. Kroz saradnju sa industrijskim partnerima, studenti imaju priliku da rade na stvarnim projektima, čime dodatno razvijaju svoje profesionalne veštine i pripremaju se za izazove koje donosi dinamičan svet mašinstva. Diplomci ovog smera su spremni da se uspešno uključe u različite industrijske sektore, uključujući automobilski, avio, energetski sektor i mnoge druge. Smer Mašinstvo na Mašinskom i Tehničkom fakultetu LMS Univerziteta pruža solidnu osnovu za profesionalni razvoj i omogućava studentima da postanu lideri u oblasti inženjeringa i tehnologije.','Marko Obradovic','MA'),(1,2,'Informacione tehnologije ','Na Mašinskom i Tehničkom fakultetu LMS Univerziteta, smer Informacione tehnologije pruža studentima sveobuhvatan obrazovni program koji je usmeren na ključne aspekte moderne informatike i tehnologije. Ovaj smer je osmišljen da integriše teorijsko znanje sa praktičnim veštinama, omogućavajući studentima da savladaju kako razvoj softverskih rešenja, tako i upravljanje informacionim sistemima. Program pokriva širok spektar oblasti, uključujući programiranje, baze podataka, mrežne tehnologije i sigurnost informacionih sistema. Kroz napredne kurseve u razvoju softvera, analizi podataka i dizajnu informacionih sistema, studenti stiču duboko razumevanje kako da kreiraju i upravljaju tehnologijama koje pokreću savremeni svet. Fakultet nudi moderne laboratorije i istraživačke centre, omogućavajući studentima da se upoznaju sa najnovijim alatima i tehnologijama u oblasti IT-a. Saradnja sa industrijskim partnerima pruža studentima priliku da rade na stvarnim projektima, čime se dodatno razvijaju njihova praktična znanja i veštine. Diplomci ovog smera su spremni da se uspešno uključe u različite oblasti informacionih tehnologija, uključujući razvoj softvera, upravljanje mrežama, sigurnost podataka i analizu informacija. Smer Informacione tehnologije na Mašinskom i Tehničkom fakultetu LMS Univerziteta nudi čvrstu osnovu za profesionalni uspeh i omogućava studentima da postanu ključni akteri u brzo rastućem polju tehnologije i informatike.','Jovana Ostojic','IT'),(2,3,'Menadzment','Na Fakultetu menadžmenta i poslovnih studija LMS Univerziteta, smer Menadžment nudi studentima sveobuhvatan obrazovni program koji je osmišljen da ih pripremi za ključne uloge u vođenju i organizaciji modernih preduzeća. Ovaj smer integriše teorijska znanja sa praktičnim veštinama, omogućavajući studentima da razviju sposobnosti koje su neophodne za uspešno upravljanje i donošenje strateških odluka u različitim poslovnim okruženjima. Program pokriva ključne oblasti menadžmenta, uključujući strategijsko planiranje, upravljanje ljudskim resursima, finansijski menadžment, marketing i operativno upravljanje. Kroz studije slučaja, grupne projekte i analize realnih poslovnih situacija, studenti stiču sveobuhvatno razumevanje kako da primene menadžerske tehnike i metode u praksi.Fakultet se ponosi savremenim pristupom obrazovanju, pružajući studentima pristup modernim alatima i resursima kroz laboratorije i istraživačke centre. Saradnja sa poslovnim partnerima omogućava studentima da se upuste u praktične projekte i steknu dragocena iskustva koja doprinose njihovom profesionalnom razvoju. Diplomci ovog smera su pripremljeni da preuzmu ključne menadžerske uloge u različitim sektorima, uključujući korporacije, mala i srednja preduzeća, kao i organizacije nevladinog sektora. Smer Menadžment na Fakultetu menadžmenta i poslovnih studija LMS Univerziteta pruža čvrstu osnovu za profesionalni uspeh i omogućava studentima da razviju liderske veštine koje su ključne za uspeh u dinamičnom poslovnom svetu.','Ana Dotlic','ME'),(2,4,'Poslovna ekonomija','Na Fakultetu menadžmenta i poslovnih studija LMS Univerziteta, smer Poslovna ekonomija pruža studentima sveobuhvatan obrazovni program koji je osmišljen da ih pripremi za analizu, upravljanje i optimizaciju poslovnih procesa u različitim organizacijama. Ovaj smer kombinuje duboko razumevanje ekonomskih principa sa praktičnim veštinama potrebnim za donošenje informisanih poslovnih odluka. Program obuhvata ključne oblasti poslovne ekonomije, uključujući mikroekonomiju, makroekonomiju, ekonomske analize, finansijsko planiranje i strategijsko upravljanje. Studenti se upoznaju sa tehnikama analize tržišta, ocenjivanjem finansijskih performansi i primenom ekonomskih teorija u realnim poslovnim situacijama. Kroz projekte, studije slučaja i simulacije, stiču veštine koje su ključne za efikasno upravljanje resursima i donošenje strateških odluka.Fakultet nudi savremene obrazovne resurse, uključujući laboratorije i istraživačke centre, kao i prilike za saradnju sa industrijskim partnerima. Ova praksa omogućava studentima da se angažuju u stvarnim projektima i dobiju dragocena iskustva koja doprinose njihovom profesionalnom razvoju. Diplomci smera Poslovna ekonomija su pripremljeni za različite karijere u poslovnom svetu, uključujući analizu tržišta, finansijsko savetovanje, strategijsko planiranje i upravljanje projektima. Smer Poslovna ekonomija na Fakultetu menadžmenta i poslovnih studija LMS Univerziteta pruža solidnu osnovu za profesionalni uspeh i omogućava studentima da postanu stručnjaci u analizi i upravljanju poslovnim operacijama.','Zoran Otasevic','PE'),(3,5,'Bezbednost i kriminalistika','Na Fakultetu bezbednosti i kriminalistike LMS Univerziteta, smer Bezbednost nudi studentima sveobuhvatan obrazovni program koji je osmišljen da ih pripremi za upravljanje i analizu bezbednosnih sistema u različitim kontekstima. Ovaj smer integriše teorijske koncepte sa praktičnim veštinama, omogućavajući studentima da razviju stručnost u očuvanju bezbednosti i zaštiti od različitih pretnji i rizika. Program pokriva ključne oblasti bezbednosti, uključujući analizu rizika, zaštitu i bezbednost objekata, krizno upravljanje, bezbednost informacionih sistema i prevenciju kriminala. Kroz detaljnu analizu sigurnosnih praksi, studije slučaja i simulacije, studenti stiču veštine potrebne za identifikaciju i rešavanje bezbednosnih izazova u različitim okruženjima.Fakultet pruža pristup modernim obrazovnim resursima i tehnologijama, uključujući specijalizovane laboratorije i istraživačke centre. Saradnja sa državnim i privatnim bezbednosnim agencijama omogućava studentima da učestvuju u stvarnim projektima i steknu iskustva koja doprinose njihovom profesionalnom razvoju.Diplomci smera Bezbednost su pripremljeni za rad u različitim sektorima, uključujući vladine agencije, privatne bezbednosne firme, korporativne bezbednosne odeljenja i organizacije za prevenciju kriminala. Smer Bezbednost na Fakultetu bezbednosti i kriminalistike LMS Univerziteta pruža čvrstu osnovu za profesionalni uspeh i omogućava studentima da postanu stručnjaci u oblasti zaštite i bezbednosti.','Igor Stevic','BIK'),(3,6,'Pravo','Na Fakultetu bezbednosti i kriminalistike LMS Univerziteta, smer Pravo pruža studentima sveobuhvatan obrazovni program koji je usmeren na primenu pravnih principa u kontekstu bezbednosti i kriminalistike. Ovaj smer je osmišljen da integriše pravne teorije sa specifičnim znanjima iz oblasti bezbednosti i kriminalistike, omogućavajući studentima da razviju stručnost u pravnom regulisanju bezbednosnih pitanja i rešavanju krivičnih slučajeva.Program obuhvata ključne oblasti prava, uključujući krivično pravo, građansko pravo, upravno pravo i međunarodno pravo, s posebnim naglaskom na primenu ovih principa u oblasti bezbednosti i kriminalistike. Studenti se upuštaju u analizu pravnih standarda, istraživanje krivičnih postupaka i upravljanje pravnim aspektima bezbednosnih operacija.Kroz detaljne studije slučaja, pravne analize i simulacije stvarnih pravnih situacija, studenti stiču veštine potrebne za efektivno upravljanje pravnim pitanjima u kontekstu bezbednosti. Fakultet nudi pristup savremenim obrazovnim resursima, uključujući specijalizovane laboratorije i istraživačke centre, kao i prilike za saradnju sa pravnim i bezbednosnim institucijama.Diplomci smera Pravo su pripremljeni za rad u različitim sektorima, uključujući pravne firme, državne agencije za sprovođenje zakona, organizacije za ljudska prava i savetodavne uloge u oblasti bezbednosti. Smer Pravo na Fakultetu bezbednosti i kriminalistike LMS Univerziteta pruža čvrstu osnovu za profesionalni uspeh i omogućava studentima da postanu stručnjaci u pravnom regulisanju i upravljanju bezbednosnim pitanjima.','Bogdan Bojovic','PR');
/*!40000 ALTER TABLE `studijski_programi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `univerzitet`
--

DROP TABLE IF EXISTS `univerzitet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `univerzitet` (
  `datum_osnivanja` datetime(6) DEFAULT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `rektorat_id` bigint DEFAULT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `kontakt` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `opis` longtext,
  `rektor` varchar(255) DEFAULT NULL,
  `slika` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKahsea0rwy70y1pxer6djd74rf` (`rektorat_id`),
  CONSTRAINT `FKahsea0rwy70y1pxer6djd74rf` FOREIGN KEY (`rektorat_id`) REFERENCES `rektorat` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `univerzitet`
--

LOCK TABLES `univerzitet` WRITE;
/*!40000 ALTER TABLE `univerzitet` DISABLE KEYS */;
INSERT INTO `univerzitet` VALUES ('2020-07-21 00:00:00.000000',1,1,'Bulevar Patrijarha Pavla 3, Novi Sad','email: lms@unimail.rs, tel: 021/500-100','LMS Univerzitet','LMS Univerzitet, smešten u srcu Novog Sada, predstavlja jedan od najdinamičnijih i inovativnijih visokoškolskih ustanova u regionu. Osnovan 2020. godine, ovaj privatni univerzitet brzo je stekao reputaciju kao centar izvrsnosti u obrazovanju i istraživanju. Kao relativno nov univerzitet, LMS nudi savremene studijske programe koji su u skladu sa najnovijim trendovima i potrebama tržišta rada. Njegova misija je da pruži studentima ne samo akademsko znanje već i praktične veštine koje su ključne za uspeh u savremenom poslovnom svetu. Fakulteti na LMS Univerzitetu obuhvataju širok spektar disciplina, uključujući tehnologiju, ekonomiju, umetnost, društvene nauke i mnoge druge, omogućavajući studentima da izaberu put koji najbolje odgovara njihovim interesovanjima i karijernim ciljevima. Kampus LMS Univerziteta kombinuje modernu arhitekturu sa inovativnim sadržajima, uključujući savremene učionice, laboratorije, i prostore za istraživanje. Ova akademska zajednica podržava kreativnost, kritičko razmišljanje i interdisciplinarni pristup obrazovanju, pružajući studentima sve alate potrebne za postizanje akademskih i profesionalnih uspeha. LMS Univerzitet takođe naglašava važnost internacionalne saradnje i partnerstva sa vodećim univerzitetima i istraživačkim institucijama širom sveta, omogućavajući studentima da se uključe u globalne projekte i steknu međunarodna iskustva. Sa fokusom na kvalitetno obrazovanje, istraživanje i razvoj, LMS Univerzitet se neprekidno razvija kako bi odgovorio na potrebe savremenog društva i tržišta rada, pružajući studentima priliku da postanu lideri i inovatori u svojim oblastima.','Petar Petrovic','assets/images/logo.png');
/*!40000 ALTER TABLE `univerzitet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `zavrsni_rad`
--

DROP TABLE IF EXISTS `zavrsni_rad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `zavrsni_rad` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `link` varchar(255) DEFAULT NULL,
  `tema` varchar(255) DEFAULT NULL,
  `mentor_id` bigint DEFAULT NULL,
  `student_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1k0faknb7uas247yycmgvgyn7` (`mentor_id`),
  KEY `FKbvabglrh32apum02jqign1eul` (`student_id`),
  CONSTRAINT `FK1k0faknb7uas247yycmgvgyn7` FOREIGN KEY (`mentor_id`) REFERENCES `registrovani_korisnici` (`id`),
  CONSTRAINT `FKbvabglrh32apum02jqign1eul` FOREIGN KEY (`student_id`) REFERENCES `registrovani_korisnici` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `zavrsni_rad`
--

LOCK TABLES `zavrsni_rad` WRITE;
/*!40000 ALTER TABLE `zavrsni_rad` DISABLE KEYS */;
INSERT INTO `zavrsni_rad` VALUES (1,NULL,'test zavrsni rad',8,6);
/*!40000 ALTER TABLE `zavrsni_rad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-18  1:47:37
