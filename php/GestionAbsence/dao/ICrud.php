<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abdelilah Boutizoua
 */
interface ICrud {
    //put your code here
    
    public function create($obj);
    public function update($obj);
    public function delete($obj);
    public function findById($id);
    public function findAll();
}
