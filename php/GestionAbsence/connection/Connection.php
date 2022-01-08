<?php


/**
 * Description of Connection
 *
 * @author Abdelilah Boutizoua
 */
class Connection {

    private $conn;
    
    private $connextion;
    public function __construct() {
        $host = 'localhost';
        $dbname = 'gestion_absence';
        $login = 'root';
        $password = '';
        try {
            $this->conn = new PDO("mysql:host=$host;dbname=$dbname", $login, $password);
            $this->conn->query("SET NAMES UTF8");
            $this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $this->conn->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_OBJ);

        } 
        catch (Exception $e) {
            die('Erreur : ' . $e->getMessage());
        }
    }
    function getConn() {
        return $this->conn;
    }

}
