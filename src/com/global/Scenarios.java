/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.global;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author aaksh
 */
public class Scenarios {
    private Map<String, String> scenarios = new HashMap<>();
    
    public Scenarios(){
        scenarios.put("1", "");
    }
    
    public String getScenarioNames(String id){
        return scenarios.get(id);
    }
    
}
