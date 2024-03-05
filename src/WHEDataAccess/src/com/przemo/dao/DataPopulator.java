package com.przemo.dao;

import com.przemo.entity.Item;
import com.przemo.entity.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataPopulator implements CommandLineRunner
{
    @Autowired
    DataRepository dataRepository;

    @Override
    public void run(String... args) throws Exception
    {
        Question qIsAHuman = dataRepository.createQuestion("Is a human");
        Question qIsGood = dataRepository.createQuestion("Is good");
        Question qIsAlive = dataRepository.createQuestion("Is alive");
        Question qIsPluggedIntoComputer = dataRepository.createQuestion("Is plugged into computer");
        Question qHasHands = dataRepository.createQuestion("Has hands");
        Question qIsDangerous = dataRepository.createQuestion("Is dangerous");
        Question qIsUseful = dataRepository.createQuestion("Is useful");
        Question qCanFight = dataRepository.createQuestion("Can fight");
        Question qIsBig = dataRepository.createQuestion("Is big");
        Question qIsMadeOfMetal = dataRepository.createQuestion("Is made of metal");

        Item keyboard = dataRepository.createItem("Keyboard");
        dataRepository.createAnswer(qIsAHuman,keyboard,false);
        dataRepository.createAnswer(qIsGood,keyboard,true);
        dataRepository.createAnswer(qIsAlive,keyboard,false);
        dataRepository.createAnswer(qIsPluggedIntoComputer,keyboard,true);
        dataRepository.createAnswer(qHasHands,keyboard,false);
        dataRepository.createAnswer(qIsDangerous,keyboard,false);
        dataRepository.createAnswer(qIsUseful,keyboard,true);
        dataRepository.createAnswer(qCanFight,keyboard,false);
        dataRepository.createAnswer(qIsBig,keyboard,false);
        dataRepository.createAnswer(qIsMadeOfMetal,keyboard,false);
        Item sky = dataRepository.createItem("Sky");
        dataRepository.createAnswer(qIsAHuman,sky,false);
        dataRepository.createAnswer(qIsGood,sky,true);
        dataRepository.createAnswer(qIsAlive,sky,false);
        dataRepository.createAnswer(qIsPluggedIntoComputer,sky,false);
        dataRepository.createAnswer(qHasHands,sky,false);
        dataRepository.createAnswer(qIsDangerous,sky,false);
        dataRepository.createAnswer(qIsUseful,sky,true);
        dataRepository.createAnswer(qCanFight,sky,false);
        dataRepository.createAnswer(qIsBig,sky,true);
        dataRepository.createAnswer(qIsMadeOfMetal,sky,false);
        Item flower = dataRepository.createItem("Flower");
        dataRepository.createAnswer(qIsAHuman,flower,false);
        dataRepository.createAnswer(qIsGood,flower,true);
        dataRepository.createAnswer(qIsAlive,flower,true);
        dataRepository.createAnswer(qIsPluggedIntoComputer,flower,false);
        dataRepository.createAnswer(qHasHands,flower,false);
        dataRepository.createAnswer(qIsDangerous,flower,false);
        dataRepository.createAnswer(qIsUseful,flower,true);
        dataRepository.createAnswer(qCanFight,flower,false);
        dataRepository.createAnswer(qIsBig,flower,false);
        dataRepository.createAnswer(qIsMadeOfMetal,flower,false);
        Item key = dataRepository.createItem("Key");
        dataRepository.createAnswer(qIsAHuman,key,false);
        dataRepository.createAnswer(qIsGood,key,true);
        dataRepository.createAnswer(qIsAlive,key,false);
        dataRepository.createAnswer(qIsPluggedIntoComputer,key,false);
        dataRepository.createAnswer(qHasHands,key,false);
        dataRepository.createAnswer(qIsDangerous,key,false);
        dataRepository.createAnswer(qIsUseful,key,true);
        dataRepository.createAnswer(qCanFight,key,false);
        dataRepository.createAnswer(qIsBig,key,false);
        dataRepository.createAnswer(qIsMadeOfMetal,key,true);
        Item knife = dataRepository.createItem("Knife");
        dataRepository.createAnswer(qIsAHuman,knife,false);
        dataRepository.createAnswer(qIsGood,knife,true);
        dataRepository.createAnswer(qIsAlive,knife,false);
        dataRepository.createAnswer(qIsPluggedIntoComputer,knife,false);
        dataRepository.createAnswer(qHasHands,knife,false);
        dataRepository.createAnswer(qIsDangerous,knife,true);
        dataRepository.createAnswer(qIsUseful,knife,true);
        dataRepository.createAnswer(qCanFight,knife,false);
        dataRepository.createAnswer(qIsBig,knife,false);
        dataRepository.createAnswer(qIsMadeOfMetal,knife,true);
        Item fireman = dataRepository.createItem("Fireman");
        dataRepository.createAnswer(qIsAHuman,fireman,true);
        dataRepository.createAnswer(qIsGood,fireman,true);
        dataRepository.createAnswer(qIsAlive,fireman,true);
        dataRepository.createAnswer(qIsPluggedIntoComputer,fireman,false);
        dataRepository.createAnswer(qHasHands,fireman,true);
        dataRepository.createAnswer(qIsDangerous,fireman,false);
        dataRepository.createAnswer(qIsUseful,fireman,true);
        dataRepository.createAnswer(qCanFight,fireman,true);
        dataRepository.createAnswer(qIsBig,fireman,false);
        dataRepository.createAnswer(qIsMadeOfMetal,fireman,false);
        Item andrzejD = dataRepository.createItem("Andrzej D");
        dataRepository.createAnswer(qIsAHuman,andrzejD,true);
        dataRepository.createAnswer(qIsGood,andrzejD,false);
        dataRepository.createAnswer(qIsAlive,andrzejD,true);
        dataRepository.createAnswer(qIsPluggedIntoComputer,andrzejD,false);
        dataRepository.createAnswer(qHasHands,andrzejD,true);
        dataRepository.createAnswer(qIsDangerous,andrzejD,true);
        dataRepository.createAnswer(qIsUseful,andrzejD,false);
        dataRepository.createAnswer(qCanFight,andrzejD,false);
        dataRepository.createAnswer(qIsBig,andrzejD,false);
        dataRepository.createAnswer(qIsMadeOfMetal,andrzejD,false);
        Item solaris = dataRepository.createItem("Solaris");
        dataRepository.createAnswer(qIsAHuman,solaris,false);
        dataRepository.createAnswer(qIsGood,solaris,true);
        dataRepository.createAnswer(qIsAlive,solaris,true);
        dataRepository.createAnswer(qIsPluggedIntoComputer,solaris,false);
        dataRepository.createAnswer(qHasHands,solaris,false);
        dataRepository.createAnswer(qIsDangerous,solaris,true);
        dataRepository.createAnswer(qIsUseful,solaris,false);
        dataRepository.createAnswer(qCanFight,solaris,false);
        dataRepository.createAnswer(qIsBig,solaris,false);
        dataRepository.createAnswer(qIsMadeOfMetal,solaris,false);
        Item witcher = dataRepository.createItem("Witcher");
        dataRepository.createAnswer(qIsAHuman,witcher,true);
        dataRepository.createAnswer(qIsGood,witcher,true);
        dataRepository.createAnswer(qIsAlive,witcher,true);
        dataRepository.createAnswer(qIsPluggedIntoComputer,witcher,false);
        dataRepository.createAnswer(qHasHands,witcher,true);
        dataRepository.createAnswer(qIsDangerous,witcher,true);
        dataRepository.createAnswer(qIsUseful,witcher,true);
        dataRepository.createAnswer(qCanFight,witcher,true);
        dataRepository.createAnswer(qIsBig,witcher,false);
        dataRepository.createAnswer(qIsMadeOfMetal,witcher,false);
        Item pirate = dataRepository.createItem("Pirate");
        dataRepository.createAnswer(qIsAHuman,pirate,true);
        dataRepository.createAnswer(qIsGood,pirate,false);
        dataRepository.createAnswer(qIsAlive,pirate,true);
        dataRepository.createAnswer(qIsPluggedIntoComputer,pirate,false);
        dataRepository.createAnswer(qHasHands,pirate,true);
        dataRepository.createAnswer(qIsDangerous,pirate,true);
        dataRepository.createAnswer(qIsUseful,pirate,false);
        dataRepository.createAnswer(qCanFight,pirate,true);
        dataRepository.createAnswer(qIsBig,pirate,false);
        dataRepository.createAnswer(qIsMadeOfMetal,pirate,false);
        Item clock = dataRepository.createItem("Clock");
        dataRepository.createAnswer(qIsAHuman,clock,false);
        dataRepository.createAnswer(qIsGood,clock,false);
        dataRepository.createAnswer(qIsAlive,clock,false);
        dataRepository.createAnswer(qIsPluggedIntoComputer,clock,false);
        dataRepository.createAnswer(qHasHands,clock,true);
        dataRepository.createAnswer(qIsDangerous,clock,false);
        dataRepository.createAnswer(qIsUseful,clock,true);
        dataRepository.createAnswer(qCanFight,clock,false);
        dataRepository.createAnswer(qIsBig,clock,false);
        dataRepository.createAnswer(qIsMadeOfMetal,clock,true);
        Item robbo = dataRepository.createItem("Robbo");
        dataRepository.createAnswer(qIsAHuman,robbo,false);
        dataRepository.createAnswer(qIsGood,robbo,true);
        dataRepository.createAnswer(qIsAlive,robbo,false);
        dataRepository.createAnswer(qIsPluggedIntoComputer,robbo,false);
        dataRepository.createAnswer(qHasHands,robbo,true);
        dataRepository.createAnswer(qIsDangerous,robbo,false);
        dataRepository.createAnswer(qIsUseful,robbo,true);
        dataRepository.createAnswer(qCanFight,robbo,true);
        dataRepository.createAnswer(qIsBig,robbo,false);
        dataRepository.createAnswer(qIsMadeOfMetal,robbo,true);
    }
}