package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
    }

    @Test
    void testDeleteCity(){
        CityList cityList = new CityList();

        assertEquals(0, cityList.getCities().size());

        City city1 = new City("HoChiMinh", "Vietnam");
        City city2 = new City("Vancouver", "BC");
        cityList.add(city1);
        cityList.add(city2);

        assertEquals(2, cityList.getCities().size());

        cityList.deleteCity(city1);

        assertEquals(1, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(city1));
        assertTrue(cityList.getCities().contains(city2));

        cityList.deleteCity(city2);

        assertEquals(0, cityList.getCities().size());
    }
}
