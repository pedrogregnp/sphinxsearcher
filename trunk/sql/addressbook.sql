-- MySQL dump 10.13  Distrib 5.1.48, for unknown-linux-gnu (x86_64)
--
-- Host: localhost    Database: addressbook
-- ------------------------------------------------------
-- Server version	5.1.48-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `AddressBook`
--

DROP TABLE IF EXISTS `AddressBook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AddressBook` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `OfficeId` int(11) DEFAULT NULL,
  `Title` varchar(20) DEFAULT NULL,
  `Alias` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `DOJ` date NOT NULL,
  `PhoneNo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AddressBook`
--

LOCK TABLES `AddressBook` WRITE;
/*!40000 ALTER TABLE `AddressBook` DISABLE KEYS */;
INSERT INTO `AddressBook` VALUES (1,'Aabheer','Kumar',1,'Mr','u534','Kumar.Aabheer@gogs.it','2008-09-03','+911234599990'),(2,'Aadarsh','Gupta',6,'Mr','u668','Gupta.Aadarsh@gogs.it','2007-02-23','+911234599991'),(3,'Aachman','Singh',5,'Mr','u2766','Singh.Aachman@gogs.it','2006-12-18','+911234599992'),(4,'Aadesh','Shrivastav',5,'Mr','u3198','Shrivastav.Aadesh@gogs.it','2007-11-23','+911234599993'),(5,'Aadi','manav',1,'Mr','u2686','manav.Aadi@gogs.it','2010-07-20','+911234599994'),(6,'Aadidev','singh',4,'Mr','u572','singh.Aadidev@gogs.it','2010-08-18','+911234599995'),(7,'Aafreen','sheikh',4,'Smt','u1092','sheikh.Aafreen@gogs.it','2007-07-11','+911234599996'),(8,'Aakar','Sherpa',5,'Mr','u1420','Sherpa.Aakar@gogs.it','2009-10-03','+911234599997'),(9,'Aakash','Singh',4,'Mrs','u2884','Singh.Aakash@gogs.it','2008-06-11','+911234599998'),(10,'Aalap','Singhania',4,'Mrs','u609','Singhania.Aalap@gogs.it','2010-10-08','+911234599999'),(11,'Aandaleeb','mahajan',1,'Smt','u131','mahajan.Aandaleeb@gogs.it','2010-10-21','+911234580001'),(12,'Mamata','kumari',5,'Sh','u2519','kumari.Mamata@gogs.it','2009-06-12','+911234580002'),(13,'Mamta','sharma',6,'Smt','u4123','sharma.Mamta@gogs.it','2009-02-08','+911234580003'),(14,'Manali','singh',6,'Mr','u1078','singh.Manali@gogs.it','2008-06-14','+911234580004'),(15,'Manda','saxena',1,'Mrs','u196','saxena.Manda@gogs.it','2010-09-04','+911234580005'),(16,'Salila','shetty',3,'Miss','u157','shetty.Salila@gogs.it','2009-11-15','+911234580006'),(17,'Salima','happy',3,'Mrs','u3445','happy.Salima@gogs.it','2006-07-14','+911234580007'),(18,'Salma','haik',5,'Sh','u4621','haik.Salma@gogs.it','2008-06-23','+911234580008'),(19,'Samita','patil',3,'Smt','u3156','patil.Samita@gogs.it','2006-06-07','+911234580009'),(20,'Sameena','sheikh',5,'Mrs','u952','sheikh.Sameena@gogs.it','2008-08-13','+911234580010'),(21,'Ranita','gupta',5,'Mrs','u2664','gupta.Ranita@gogs.it','2008-10-20','+911234580011'),(22,'Ranjana','sharma',1,'Sh','u3085','sharma.Ranjana@gogs.it','2010-06-21','+911234580012'),(23,'Ranjini','singh',6,'Mrs','u4200','singh.Ranjini@gogs.it','2007-04-13','+911234580013'),(24,'Ranjita','vyapari',2,'Smt','u1109','vyapari.Ranjita@gogs.it','2008-01-22','+911234580014'),(25,'Rashi','gupta',6,'Mrs','u3492','gupta.Rashi@gogs.it','2006-02-02','+911234580015'),(26,'Rashmi','sehgal',3,'Mr','u3248','sehgal.Rashmi@gogs.it','2008-09-09','+911234580016'),(27,'Rashmika','sexy',1,'Mrs','u4599','sexy.Rashmika@gogs.it','2009-03-12','+911234580017'),(28,'Rasika','dulari',3,'Smt','u2089','dulari.Rasika@gogs.it','2009-01-24','+911234580018'),(29,'Dilber','lover',6,'Mr','u4241','lover.Dilber@gogs.it','2007-10-11','+911234580019'),(30,'Dilshad','happy',1,'Mr','u1564','happy.Dilshad@gogs.it','2007-04-08','+911234580020'),(31,'Dipali','lights',5,'Sh','u1127','lights.Dipali@gogs.it','2006-11-01','+911234580021'),(32,'Dipika','lamp',1,'Sh','u2271','lamp.Dipika@gogs.it','2010-12-17','+911234580022'),(33,'Dipti','brightness',5,'Smt','u422','brightness.Dipti@gogs.it','2010-09-25','+911234580023'),(34,'Disha','singh',3,'Sh','u4604','singh.Disha@gogs.it','2006-05-02','+911234580024'),(35,'Maadhav','Krishna',1,'Miss','u2561','Krishna.Maadhav@gogs.it','2007-11-06','+911234580025'),(36,'Maagh','month',5,'Miss','u874','month.Maagh@gogs.it','2008-05-08','+911234580026'),(37,'Maahir','Skilled',4,'Mr','u3372','Skilled.Maahir@gogs.it','2007-08-04','+911234580027'),(38,'Maalolan','Ahobilam',5,'Mrs','u3498','Ahobilam.Maalolan@gogs.it','2007-07-09','+911234580028'),(39,'Maandhata','King',1,'Smt','u2089','King.Maandhata@gogs.it','2009-09-03','+911234580029'),(40,'Maaran','Brave',2,'Miss','u4020','Brave.Maaran@gogs.it','2008-04-05','+9112345606001'),(41,'Maari','Rain',2,'Sh','u3593','Rain.Maari@gogs.it','2007-12-05','+9112345606002'),(42,'Madan','Cupid',4,'Mrs','u795','Cupid.Madan@gogs.it','2007-11-11','+9112345606003'),(43,'Madangopal','Krishna',3,'Sh','u438','Krishna.Madangopal@gogs.it','2007-02-19','+9112345606004'),(44,'sahil','gogna',1,'Sh','u2273','gogna.sahil@gogs.it','2007-10-07','+9112345606005'),(45,'nikhil','gogna',2,'Mr','u1240','gogna.nikhil@gogs.it','2009-09-14','+9112345606006'),(46,'amit','gogna',5,'Sh','u3879','gogna.amit@gogs.it','2006-02-08','+9112345606007'),(47,'krishan','gogna',4,'Miss','u3632','gogna.krishan@gogs.it','2010-09-20','+9112345606008'),(48,'anil','kashyap',4,'Smt','u3939','kashyap.anil@gogs.it','2010-03-15','+9112345606009'),(49,'sunil','kashyap',5,'Mrs','u3493','kashyap.sunil@gogs.it','2008-03-16','+9112345606010'),(50,'sandy','singh',6,'Mrs','u4691','singh.sandy@gogs.it','2009-06-02','+9112345606011'),(51,'vishal','kapoor',3,'Mr','u1087','kapoor.vishal@gogs.it','2010-05-13','+9112345606012'),(52,'bala','ji',5,'Mrs','u4762','ji.bala@gogs.it','2007-08-09','+9112345606013'),(53,'karan','sarin',4,'Miss','u3030','sarin.karan@gogs.it','2008-04-08','+9112345606014'),(54,'abhishek','kumar',4,'Miss','u1093','kumar.abhishek@gogs.it','2008-12-21','+9112345605001'),(55,'babu','the',1,'Miss','u1055','the.babu@gogs.it','2008-07-02','+9112345506001'),(56,'sandeep','gainda',3,'Miss','u1320','gainda.sandeep@gogs.it','2010-05-14','+9112345606301'),(57,'dheeraj','kumar',3,'Miss','u3685','kumar.dheeraj@gogs.it','2007-10-14','+9112345606091'),(58,'dharmendra','chauhan',1,'Smt','u3235','chauhan.dharmendra@gogs.it','2008-08-01','+9112345806001'),(59,'max','alan',3,'Smt','u3465','alan.max@gogs.it','2009-05-05','+9112345608011'),(60,'hidayat','khan',3,'Smt','u958','khan.hidayat@gogs.it','2007-11-18','+911234599101'),(61,'himnashu','singh',4,'Miss','u2027','singh.himnashu@gogs.it','2008-03-02','+911234599102'),(62,'dinesh','kumar',6,'Sh','u3233','kumar.dinesh@gogs.it','2008-05-09','+911234599103'),(63,'toshi','prakash',1,'Mr','u3766','prakash.toshi@gogs.it','2010-09-17','+911234599104'),(64,'niti','puri',3,'Mr','u3575','puri.niti@gogs.it','2009-11-15','+911234599105'),(65,'pawan','tikki',3,'Sh','u3919','tikki.pawan@gogs.it','2006-03-19','+911234599106'),(66,'gaurav','sharma',2,'Sh','u413','sharma.gaurav@gogs.it','2010-04-02','+911234599107'),(67,'himanshu','verma',2,'Mrs','u4732','verma.himanshu@gogs.it','2009-03-20','+911234599108'),(68,'priyanshu','verma',3,'Sh','u183','verma.priyanshu@gogs.it','2010-08-12','+911234599109'),(69,'nitika','luthra',2,'Mrs','u4259','luthra.nitika@gogs.it','2010-07-12','+911234599110'),(70,'neeru','gogna',2,'Sh','u1633','gogna.neeru@gogs.it','2010-06-23','+91532110000'),(71,'bindu','gupta',1,'Sh','u1859','gupta.bindu@gogs.it','2006-11-10','+91532110001'),(72,'gurleen','bakshi',5,'Miss','u1423','bakshi.gurleen@gogs.it','2007-07-01','+91532110003'),(73,'rahul','gupta',3,'Sh','u1223','gupta.rahul@gogs.it','2009-08-11','+91532110004'),(74,'jagdish','salgotra',3,'Mr','u12','salgotra.jagdish@gogs.it','2008-05-19','+91532110005'),(75,'vikas','sharma',3,'Smt','u465','sharma.vikas@gogs.it','2006-06-02','+91532110006'),(76,'poonam','mahendra',2,'Sh','u1744','mahendra.poonam@gogs.it','2009-12-02','+91532110007'),(77,'pooja','kulkarni',3,'Mrs','u1903','kulkarni.pooja@gogs.it','2008-10-06','+91532110008'),(78,'priya','mahajan',6,'Sh','u4205','mahajan.priya@gogs.it','2010-08-05','+91532110009'),(79,'manoj','zerger',1,'Mrs','u3369','zerger.manoj@gogs.it','2009-12-04','+91532110010'),(80,'mohan','master',5,'Mr','u2841','master.mohan@gogs.it','2010-10-07','+91532110011');
/*!40000 ALTER TABLE `AddressBook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CompanyLocations`
--

DROP TABLE IF EXISTS `CompanyLocations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CompanyLocations` (
  `Id` int(11) NOT NULL,
  `Location` varchar(60) NOT NULL,
  `Country` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CompanyLocations`
--

LOCK TABLES `CompanyLocations` WRITE;
/*!40000 ALTER TABLE `CompanyLocations` DISABLE KEYS */;
INSERT INTO `CompanyLocations` VALUES (1,'Tower One, Harbour Front, Singapore','SG'),(2,'DLF Phase 3, Gurgaon, India','IN'),(3,'Hiranandani Gardens, Powai, Mumbai, India','IN'),(4,'Hinjwadi, Pune, India','IN'),(5,'Toll Post, Nagrota, Jammu, India','IN'),(6,'Bani (Kathua), India','IN');
/*!40000 ALTER TABLE `CompanyLocations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-08-23  2:21:29
