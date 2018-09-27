package com.dao;

import java.util.ArrayList;

import com.pojo.Order;
import com.pojo.ProprietaryTraders;
import com.randomDataGeneration.RandomOrder;

public interface RandomOrderDAO {
	int addOrderBatch(ArrayList<RandomOrder> randomOrderList);
}
