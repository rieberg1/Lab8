package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     *
     * @return
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     * one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        list = MockCityList();
        City estavan = new City("Estevan", "SK");
        list.addCity(estavan);
        boolean hasCity = list.hasCity(estavan);
        assertTrue(hasCity);
    }

    @Test
    public void deleteCityTest() {
        list = MockCityList();
        City estavan = new City("Estevan", "SK");
        list.addCity(estavan);
        assertTrue(list.hasCity(estavan));
        list.deleteCity(estavan);
        assertFalse(list.hasCity(estavan));
    }

    @Test
    public void countCitiesTest() {
        list = MockCityList();
        City estavan = new City("Estevan", "SK");
        City regina = new City("Regina", "SK");
        list.addCity(estavan);
        assertEquals(1, list.countCities());
        list.addCity(regina);
        assertEquals(2, list.countCities());
        list.deleteCity(regina);
        assertEquals(1, list.countCities());
    }


}
