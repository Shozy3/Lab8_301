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
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");
        assertFalse(list.hasCity(city));
        list.addCity(city); // Use addCity instead of add
        assertTrue(list.hasCity(city));
    }

    @Test
    void testDelete() {
        list = MockCityList();
        City city = new City("Regina", "Saskatchewan");

        // Use addCity instead of add to ensure proper list modification
        list.addCity(city);

        // Verify the city was added
        assertTrue(list.hasCity(city), "City should be present after addition.");

        // Delete the city
        list.delete(city);

        // Verify the city was removed
        assertFalse(list.hasCity(city), "City should not be present after deletion.");

        // Verify the count is back to 0
        assertEquals(0, list.countCities(), "City count should be 0 after deletion.");
    }


    @Test
    void testCountCities() {
        // Initialize the CustomList with an empty list
        list = MockCityList();

        // Since MockCityList initializes with an empty list, the initial count should be 0
        assertEquals(0, list.countCities(), "Initial city count should be 0.");

        // Create a new City instance
        City city = new City("Regina", "Saskatchewan");

        // Add the city to the list using the correct method
        list.addCity(city);

        // After adding one city, the count should be 1
        assertEquals(1, list.countCities(), "City count should be 1 after adding a city.");

        // Delete the city from the list
        list.delete(city);

        // After deletion, the count should return to 0
        assertEquals(0, list.countCities(), "City count should be 0 after deleting the city.");
    }




}
