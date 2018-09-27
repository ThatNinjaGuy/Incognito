/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Order;

import java.util.List;

/**
 *
 * @author Grad57
 */
public interface OrderDAO {



	public List<Order> findAllOrders();

	public List<Order> findAllByCustomerId(String customerId);

	public List<Order> findFirmOrders();

	public List<Order> findClientOrders();

	public List<Order> findAllBuyOrders();

	public List<Order> findAllSellOrders();

	public int addOrder(Order order);

}
