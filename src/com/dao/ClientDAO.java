/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Client;

import java.util.List;


/**
 *
 * @author PUNGRAD035
 */
public interface ClientDAO {
    
    int addClient(Client Client);
    int DeleteClient(String Client_ID);
    Client FindClientByID(String Client_ID);
    List<Client> FindAllClients();
    boolean UpdateClientPassword(String Client_ID,String Password,Client client);
    boolean UpdateClientID(String Client_ID,String Password,Client client);
        
}
