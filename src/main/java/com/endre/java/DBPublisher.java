package com.endre.java;

import com.endre.java.DTOs.Country;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;

public class DBPublisher {

    private DBConnector dbConnector;

    public DBPublisher(DBConnector dbConnector){
        this.dbConnector = dbConnector;
    }

    public void addCountry() throws Exception{

        try {
            Dao<Country, String> countriesDao = DaoManager.createDao(
                    dbConnector.getConnection(), Country.class);

            Country norway = new Country();
            norway.setName("Norway");
            norway.setCapital(23456);
            norway.setCode("NOR");
            norway.setCode2("NO");
            norway.setContinents(Country.Continents.Europa);
            norway.setGnp(24399000);
            norway.setGnpOld(234567);
            norway.setGovernmentForm("Monarcy");
            norway.setHeadOfState("Erna Solberg");
            norway.setIndepYear(1905);
            norway.setLifeExpectancy(79);
            norway.setLocalName("Norge");
            norway.setPopulation(5000000);
            norway.setRegion("West");
            norway.setSurfaceArea(56789098);

            countriesDao.createIfNotExists(norway);

        }catch (Exception e){
            throw new Exception("Could not add to database");
        }


    }
}
