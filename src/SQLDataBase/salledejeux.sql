-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 13 déc. 2022 à 01:21
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `salledejeux`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idAbo` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `typeAbo` varchar(30) NOT NULL,
  `date_abonn` varchar(30) NOT NULL,
  `date_naiss` text NOT NULL,
  `aveugle` tinyint(1) NOT NULL,
  `rang` int(11) NOT NULL,
  `nbrTournois` int(11) NOT NULL,
  `benefices` float NOT NULL,
  `promo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idAbo`, `nom`, `prenom`, `typeAbo`, `date_abonn`, `date_naiss`, `aveugle`, `rang`, `nbrTournois`, `benefices`, `promo`) VALUES
(1, 'hachem', 'mohamed', 'annuel', '12/02/2021', '21/06/2000', 0, 2, 1, 6, 5),
(2, 'yassin', 'mohamed', 'annuel', 'null', 'null', 0, 23, 5, 3, 5),
(8, 'ahmed', 'ahmed', 'ahmed', '2022-12-09', '2022-12-07', 1, 22, 22, 22, 25),
(9, 'hach', 'hach', 'kk', '2022-12-08', '2022-11-30', 1, 25, 2, 55, 10);

-- --------------------------------------------------------

--
-- Structure de la table `jeu`
--

CREATE TABLE `jeu` (
  `idJeu` int(11) NOT NULL,
  `ageLegal` int(11) NOT NULL,
  `description` text NOT NULL,
  `type` varchar(30) NOT NULL,
  `prix` float NOT NULL,
  `date_creation` text NOT NULL,
  `Titre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `jeu`
--

INSERT INTO `jeu` (`idJeu`, `ageLegal`, `description`, `type`, `prix`, `date_creation`, `Titre`) VALUES
(4, 15, '55555555', 'ok', 55, '2022-12-03', 'ok'),
(7, 22, '222', 'hhhhhhhhhhhhhhhhhhhhhh', 22, '2022-12-15', 'hhhhhhh'),
(8, 12, '77777777777', 'okkkkkkkkk', 52, 'null', 'titre'),
(15, 12, '22', 'a', 22, '2022-11-30', 'ha');

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `idMateriel` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `etat` varchar(20) NOT NULL,
  `date_achat` text NOT NULL,
  `prix` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`idMateriel`, `nom`, `etat`, `date_achat`, `prix`) VALUES
(2, '11', '12', 'null', 22),
(3, '11', '10', 'null', 11),
(4, '12', '12', '2022-12-08', 12),
(5, '12', '12', '2022-12-09', 12),
(6, '15', '15', '2022-12-08', 5),
(8, 'ok', 'ok', '2022-12-30', 15),
(9, 'nom', 'prenom', '2022-12-08', 12),
(10, 'ps4', 'aa', 'null', 12);

-- --------------------------------------------------------

--
-- Structure de la table `personnel`
--

CREATE TABLE `personnel` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `poste` varchar(30) NOT NULL,
  `date_naiss` text NOT NULL,
  `nbrHeures` int(11) NOT NULL,
  `prixHeure` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personnel`
--

INSERT INTO `personnel` (`id`, `nom`, `prenom`, `poste`, `date_naiss`, `nbrHeures`, `prixHeure`) VALUES
(2, '12', 'ff', 'null', '2022-12-08', 0, 0),
(4, 'hachem', 'mohamed', 'perso', '2022-12-02', 12, 12),
(5, 'hh', 'hh', '2022-11-30', '2022-11-30', 15, 55),
(6, 'hachem1', 'med', '2022-12-02', 'null', 20, 22),
(7, 'aa', 'aa', 'aa', '2022-12-17', 12, 12),
(9, 'aa', 'aa', '15', '2022-12-01', 55, 12),
(10, 'haha', 'aa', 'ee', 'null', 5, 3),
(11, 'hachem', 'hachem', 'hachem', '2022-12-03', 22, 22);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `mdp` text NOT NULL,
  `type` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `mdp`, `type`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'client', 'client', 'client');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idAbo`);

--
-- Index pour la table `jeu`
--
ALTER TABLE `jeu`
  ADD PRIMARY KEY (`idJeu`);

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`idMateriel`);

--
-- Index pour la table `personnel`
--
ALTER TABLE `personnel`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idAbo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `jeu`
--
ALTER TABLE `jeu`
  MODIFY `idJeu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `idMateriel` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `personnel`
--
ALTER TABLE `personnel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
