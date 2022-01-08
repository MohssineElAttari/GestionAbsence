-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 26 Avril 2018 à 10:46
-- Version du serveur :  10.1.16-MariaDB
-- Version de PHP :  7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_absence`
--

-- --------------------------------------------------------

--
-- Structure de la table `absences`
--

CREATE TABLE `absences` (
  `id` int(11) NOT NULL,
  `stagiaire_id` int(11) NOT NULL,
  `matiere_id` int(11) NOT NULL,
  `date_absence` date NOT NULL,
  `etat` tinyint(1) NOT NULL DEFAULT '0',
  `nbrHeure` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `absences`
--

INSERT INTO `absences` (`id`, `stagiaire_id`, `matiere_id`, `date_absence`, `etat`, `nbrHeure`) VALUES
(8, 11, 1, '2018-04-18', 0, 5),
(9, 12, 1, '2018-04-18', 0, 5),
(10, 1, 1, '2018-04-20', 0, 4),
(11, 1, 1, '2018-04-20', 0, 4),
(12, 1, 2, '2018-04-20', 0, 2),
(13, 1, 2, '2018-04-20', 0, 2),
(14, 4, 1, '2018-04-22', 0, 10),
(15, 5, 1, '2018-04-22', 0, 10),
(16, 1, 12, '2018-04-23', 0, 15),
(17, 2, 12, '2018-04-23', 0, 15),
(18, 3, 12, '2018-04-23', 0, 15),
(19, 4, 12, '2018-04-23', 0, 15),
(20, 5, 1, '2018-04-24', 0, 5),
(21, 6, 1, '2018-04-24', 0, 5),
(22, 7, 1, '2018-04-24', 0, 5),
(23, 1, 1, '2018-04-25', 0, 4),
(24, 2, 1, '2018-04-25', 0, 4),
(25, 3, 1, '2018-04-25', 0, 4),
(26, 4, 1, '2018-04-25', 0, 4),
(27, 7, 1, '2018-04-25', 0, 4),
(28, 10, 1, '2018-04-25', 0, 4),
(29, 8, 1, '2018-04-25', 0, 4),
(30, 1, 1, '2018-04-25', 0, 4),
(31, 1, 1, '2018-04-25', 0, 4),
(32, 2, 1, '2018-04-25', 0, 4),
(33, 3, 1, '2018-04-25', 0, 4),
(34, 4, 1, '2018-04-25', 0, 4),
(37, 1, 12, '2018-04-25', 0, 5),
(38, 2, 12, '2018-04-25', 0, 5),
(39, 3, 12, '2018-04-25', 0, 5),
(40, 7, 12, '2018-04-25', 0, 5),
(41, 8, 12, '2018-04-25', 0, 5),
(42, 9, 12, '2018-04-25', 0, 5),
(43, 10, 12, '2018-04-25', 0, 5),
(44, 13, 12, '2018-04-25', 0, 5),
(45, 1, 8, '2018-04-25', 0, 4),
(46, 2, 8, '2018-04-25', 0, 4),
(47, 3, 8, '2018-04-25', 0, 4),
(48, 4, 8, '2018-04-25', 0, 4),
(49, 5, 8, '2018-04-25', 0, 4),
(50, 12, 8, '2018-04-25', 0, 4),
(51, 13, 8, '2018-04-25', 0, 4),
(52, 1, 10, '2018-04-25', 0, 2),
(53, 2, 10, '2018-04-25', 0, 2),
(54, 3, 10, '2018-04-25', 0, 2),
(55, 5, 10, '2018-04-25', 0, 2),
(56, 6, 10, '2018-04-25', 0, 2),
(57, 1, 1, '2018-04-26', 0, 7),
(58, 2, 1, '2018-04-26', 0, 7),
(59, 9, 1, '2018-04-26', 0, 10),
(60, 10, 1, '2018-04-26', 0, 10),
(61, 1, 1, '2018-04-26', 0, 2),
(62, 2, 1, '2018-04-26', 0, 2),
(63, 1, 12, '2018-04-26', 0, 5),
(64, 2, 12, '2018-04-26', 0, 5),
(65, 3, 12, '2018-04-26', 0, 5),
(66, 4, 12, '2018-04-26', 0, 5),
(67, 1, 1, '2018-04-26', 0, 40),
(68, 2, 1, '2018-04-26', 0, 40),
(69, 4, 1, '2018-04-26', 0, 40),
(70, 5, 1, '2018-04-26', 0, 40),
(71, 6, 1, '2018-04-26', 0, 40),
(72, 7, 1, '2018-04-26', 0, 40),
(73, 8, 1, '2018-04-26', 0, 40),
(74, 9, 1, '2018-04-26', 0, 40),
(75, 10, 1, '2018-04-26', 0, 40),
(76, 11, 1, '2018-04-26', 0, 40),
(77, 12, 1, '2018-04-26', 0, 40),
(78, 13, 1, '2018-04-26', 0, 40);

-- --------------------------------------------------------

--
-- Structure de la table `annee_scolaire`
--

CREATE TABLE `annee_scolaire` (
  `id` int(11) NOT NULL,
  `annee` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `annee_scolaire`
--

INSERT INTO `annee_scolaire` (`id`, `annee`) VALUES
(1, 2018),
(2, 2017);

-- --------------------------------------------------------

--
-- Structure de la table `filieres`
--

CREATE TABLE `filieres` (
  `id` int(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `filieres`
--

INSERT INTO `filieres` (`id`, `code`, `libelle`) VALUES
(1, 'tdi', 'technicien developpment informatique'),
(2, 'tri', 'technicien reseaux informatique');

-- --------------------------------------------------------

--
-- Structure de la table `groupes`
--

CREATE TABLE `groupes` (
  `id` int(11) NOT NULL,
  `code` varchar(20) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `filiere_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `groupes`
--

INSERT INTO `groupes` (`id`, `code`, `libelle`, `filiere_id`) VALUES
(1, 'TDI1', 'Groupe A', 1),
(2, 'TRI1', 'Groupe A', 2),
(3, 'TDI2', 'Groupe B', 1),
(4, 'TDI3', 'Groupe C', 1);

-- --------------------------------------------------------

--
-- Structure de la table `groupe_stagiaires`
--

CREATE TABLE `groupe_stagiaires` (
  `id` int(11) NOT NULL,
  `stagiaire_id` int(11) NOT NULL,
  `groupe_id` int(11) NOT NULL,
  `annee` int(11) NOT NULL,
  `niveau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `groupe_stagiaires`
--

INSERT INTO `groupe_stagiaires` (`id`, `stagiaire_id`, `groupe_id`, `annee`, `niveau`) VALUES
(1, 1, 1, 1, 2),
(2, 2, 1, 1, 2),
(3, 3, 1, 1, 2),
(4, 4, 1, 1, 2),
(5, 5, 1, 1, 2),
(6, 6, 1, 1, 2),
(7, 7, 1, 1, 2),
(8, 8, 1, 1, 2),
(9, 9, 1, 1, 2),
(10, 10, 1, 1, 2),
(11, 11, 1, 1, 2),
(12, 12, 1, 1, 2),
(13, 13, 1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `matieres`
--

CREATE TABLE `matieres` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `code` varchar(20) NOT NULL,
  `massHoraire` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `matieres`
--

INSERT INTO `matieres` (`id`, `nom`, `code`, `massHoraire`) VALUES
(1, 'ASP', 'ASP', '90'),
(2, 'Anaglais', 'Anaglais', '60'),
(3, 'Modelisation et Conception', 'UML', '30'),
(4, 'Programmation Oriente Objet', 'POO', '120'),
(5, 'Arabe', 'AR', '30'),
(6, 'Francais', 'FR', '60'),
(7, 'Programmation Evenementielle', 'PE', '80'),
(8, 'Base de Donnees', 'SGBD', '120'),
(9, 'Programation Structure', 'C', '120'),
(10, 'Developement Aplication Client Serveur', 'ADO', '120'),
(11, 'Bureatique', 'BUR', '20'),
(12, 'Programmation Mobile', 'PM', '120'),
(13, 'Developement Web Cote Client', 'HTML', '80');

-- --------------------------------------------------------

--
-- Structure de la table `matieres_filieres`
--

CREATE TABLE `matieres_filieres` (
  `id` int(11) NOT NULL,
  `matiere_id` int(11) NOT NULL,
  `filiere_id` int(11) NOT NULL,
  `niveau` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `matieres_filieres`
--

INSERT INTO `matieres_filieres` (`id`, `matiere_id`, `filiere_id`, `niveau`) VALUES
(1, 1, 1, 2),
(2, 2, 1, 2),
(3, 3, 1, 1),
(4, 4, 1, 1),
(5, 5, 1, 1),
(6, 6, 1, 2),
(7, 7, 1, 1),
(8, 8, 1, 2),
(9, 9, 1, 1),
(10, 10, 1, 2),
(11, 11, 1, 1),
(12, 12, 1, 2),
(13, 13, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE `niveau` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `niveau`
--

INSERT INTO `niveau` (`id`, `code`, `nom`) VALUES
(1, 1, '1er Annee'),
(2, 2, '2er Annee');

-- --------------------------------------------------------

--
-- Structure de la table `retards`
--

CREATE TABLE `retards` (
  `id` int(11) NOT NULL,
  `stagiaire_id` int(11) NOT NULL,
  `matiere_id` int(11) NOT NULL,
  `date_retard` date NOT NULL,
  `nbre_heure` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `retards`
--

INSERT INTO `retards` (`id`, `stagiaire_id`, `matiere_id`, `date_retard`, `nbre_heure`) VALUES
(2, 2, 1, '2018-04-18', 4),
(3, 3, 1, '2018-04-18', 4),
(4, 4, 1, '2018-04-18', 4),
(5, 1, 2, '2018-04-23', 2),
(6, 11, 2, '2018-04-23', 2),
(7, 12, 2, '2018-04-23', 2),
(8, 13, 2, '2018-04-23', 2),
(9, 1, 1, '2018-04-24', 2),
(10, 2, 1, '2018-04-24', 2),
(11, 3, 1, '2018-04-24', 2),
(12, 9, 1, '2018-04-24', 2),
(13, 10, 1, '2018-04-24', 2),
(14, 11, 1, '2018-04-24', 2),
(15, 1, 13, '2018-04-24', 4),
(16, 9, 13, '2018-04-24', 4),
(17, 10, 13, '2018-04-24', 4),
(18, 6, 1, '2018-04-24', 30),
(19, 7, 1, '2018-04-24', 30),
(20, 8, 1, '2018-04-24', 30),
(21, 2, 1, '2018-04-24', 10),
(22, 3, 1, '2018-04-24', 10),
(23, 10, 1, '2018-04-24', 10),
(24, 1, 8, '2018-04-24', 50),
(25, 2, 8, '2018-04-24', 50),
(26, 3, 8, '2018-04-24', 50),
(27, 4, 8, '2018-04-24', 50),
(28, 8, 8, '2018-04-24', 50),
(29, 10, 8, '2018-04-24', 50),
(30, 12, 8, '2018-04-24', 50),
(31, 1, 8, '2018-04-24', 10),
(32, 2, 8, '2018-04-24', 10),
(33, 3, 8, '2018-04-24', 10),
(34, 4, 8, '2018-04-24', 10),
(35, 8, 8, '2018-04-24', 10),
(36, 10, 8, '2018-04-24', 10),
(37, 12, 8, '2018-04-24', 10),
(38, 1, 8, '2018-04-24', 10),
(39, 2, 8, '2018-04-24', 10),
(40, 3, 8, '2018-04-24', 10),
(41, 4, 8, '2018-04-24', 10),
(42, 8, 8, '2018-04-24', 10),
(43, 10, 8, '2018-04-24', 10),
(44, 12, 8, '2018-04-24', 10),
(45, 6, 1, '2018-04-26', 5),
(46, 7, 1, '2018-04-26', 5),
(47, 8, 1, '2018-04-26', 5),
(48, 3, 1, '2018-04-26', 5),
(49, 5, 1, '2018-04-26', 5),
(50, 6, 1, '2018-04-26', 5),
(51, 7, 1, '2018-04-26', 5),
(52, 8, 1, '2018-04-26', 5);

-- --------------------------------------------------------

--
-- Structure de la table `stagiaires`
--

CREATE TABLE `stagiaires` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `data_naissance` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `stagiaires`
--

INSERT INTO `stagiaires` (`id`, `nom`, `prenom`, `data_naissance`) VALUES
(1, 'El attari', 'Mohssine', '1995-09-14'),
(2, 'Boutizwa', 'Abdelillah', '1996-09-14'),
(3, 'bourhim', 'smail', '1996-06-04'),
(4, 'tiba', 'karim', '1995-06-04'),
(5, 'ghorabi', 'imade', '1996-07-24'),
(6, 'gribise', 'yossef', '1997-03-04'),
(7, 'jarjini', 'redoine', '1995-09-14'),
(8, 'elmansouri', 'abdelillah', '1994-03-04'),
(9, 'kharbouch', 'saad', '1997-04-04'),
(10, 'bouaine', 'yassmine', '1997-03-04'),
(11, 'elhanchani', 'fatiha', '1996-01-01'),
(12, 'youssfi', 'innes', '1996-11-18'),
(13, 'lamirat', 'touria', '1996-04-11');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `absences`
--
ALTER TABLE `absences`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `annee_scolaire`
--
ALTER TABLE `annee_scolaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `filieres`
--
ALTER TABLE `filieres`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `groupes`
--
ALTER TABLE `groupes`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `groupe_stagiaires`
--
ALTER TABLE `groupe_stagiaires`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `matieres`
--
ALTER TABLE `matieres`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `matieres_filieres`
--
ALTER TABLE `matieres_filieres`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `retards`
--
ALTER TABLE `retards`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stagiaires`
--
ALTER TABLE `stagiaires`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `absences`
--
ALTER TABLE `absences`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
--
-- AUTO_INCREMENT pour la table `annee_scolaire`
--
ALTER TABLE `annee_scolaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `filieres`
--
ALTER TABLE `filieres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `groupes`
--
ALTER TABLE `groupes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `groupe_stagiaires`
--
ALTER TABLE `groupe_stagiaires`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `matieres`
--
ALTER TABLE `matieres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `matieres_filieres`
--
ALTER TABLE `matieres_filieres`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `retards`
--
ALTER TABLE `retards`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT pour la table `stagiaires`
--
ALTER TABLE `stagiaires`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
