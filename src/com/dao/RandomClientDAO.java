package com.dao;

import java.util.ArrayList;

import com.pojo.Client;

public interface RandomClientDAO {
	int addClientBatch(Client[] randomClientList);
}
