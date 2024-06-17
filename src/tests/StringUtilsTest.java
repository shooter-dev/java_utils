package tests;

import metiers.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static metiers.StringUtils.*;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    
    @Test
    void testFizzBuzz() {
        Assertions.assertEquals("0", fizzBuzz(0));
        assertEquals("1", fizzBuzz(1));
        assertEquals("2", fizzBuzz(2));
        assertEquals("Fizz", fizzBuzz(3));
        assertEquals("4", fizzBuzz(4));
        assertEquals("Buzz", fizzBuzz(5));
        assertEquals("Fizz", fizzBuzz(6));
        assertEquals("Buzz", fizzBuzz(10));
        assertEquals("FizzBuzz", fizzBuzz(15));
        assertEquals("FizzBuzz", fizzBuzz(30));
    }

    @Test
    void testToNomPropre() {
        assertEquals("Jean-Paule", toNomPropre("jean-paule"));
        assertEquals("Jean-Paule", toNomPropre("JEAN-paule"));
        assertEquals("Jean-Paule", toNomPropre("jean-PAULE"));
        assertEquals("Jean-Paule", toNomPropre("jEaN-pAuLe"));
        assertEquals("Jean-Paule", toNomPropre("JeAn-PaUlE"));
        assertEquals("Jean-Paule", toNomPropre("jEaN-paule"));
        assertEquals("Jean-Paule", toNomPropre("JeAn-paule"));
        assertEquals("Jean-Paule", toNomPropre("jean-PaUlE"));
        assertEquals("Jean-Paule", toNomPropre("jean-pAuLe"));

        assertEquals("Jean Paule", toNomPropre("jean paule"));
        assertEquals("Jean Paule", toNomPropre("JEAN paule"));
        assertEquals("Jean Paule", toNomPropre("jean PAULE"));
        assertEquals("Jean Paule", toNomPropre("jEaN pAuLe"));
        assertEquals("Jean Paule", toNomPropre("JeAn PaUlE"));
        assertEquals("Jean Paule", toNomPropre("jEaN paule"));
        assertEquals("Jean Paule", toNomPropre("JeAn paule"));
        assertEquals("Jean Paule", toNomPropre("jean PaUlE"));
        assertEquals("Jean Paule", toNomPropre("jean pAuLe"));
    }

    @Test
    void testToAccent() {
        assertEquals("a", toAccent("à"));
        assertEquals("a", toAccent("â"));
        assertEquals("a", toAccent("ä"));

        assertEquals("c", toAccent("ç"));

        assertEquals("e", toAccent("é"));
        assertEquals("e", toAccent("è"));
        assertEquals("e", toAccent("ê"));
        assertEquals("e", toAccent("ë"));

        assertEquals("i", toAccent("ì"));
        assertEquals("i", toAccent("î"));
        assertEquals("i", toAccent("ï"));

        assertEquals("o", toAccent("ò"));
        assertEquals("o", toAccent("ô"));
        assertEquals("o", toAccent("ö"));

        assertEquals("u", toAccent("ù"));
        assertEquals("u", toAccent("û"));
        assertEquals("u", toAccent("ü"));
        assertEquals("u", toAccent("µ"));

        assertEquals("y", toAccent("ÿ"));


        assertEquals(" ", toAccent("'"));
        assertEquals(" ", toAccent("-"));
        assertEquals(" ", toAccent("_"));

        assertEquals("aaaceeeeiiiooouuuuy   ", toAccent("àâäçéèêëìîïòôöùûüµÿ'-_"));
    }


    @Test
    void testSuprExtention() {
        assertEquals("bonjour", suprExtention("bonjour.mp4"));
        assertEquals("bonjour", suprExtention("bonjour.mp4.fr"));
        assertEquals("bonjour", suprExtention("bonjour.m4v.fr.fr"));
    }

    @Test
    void testDoubleEspace() {
        assertEquals("bonjour tout le monde", doubleEspace("bonjour         tout      le    monde"));
        assertEquals("", doubleEspace(""));
        assertEquals("jean-paul", doubleEspace("jean--paul"));
        assertEquals("jean-paul", doubleEspace("jean------------paul"));
    }

    @Test
    void testClassementLivre() {
        assertEquals("du bellay, jonchin", classementLivre("du bellay", "jonchin"));
        assertEquals("le clezio, jean-marie", classementLivre("le clezio", "jean-marie"));
        assertEquals("la fontaine, jean (de)", classementLivre("de la fontaine", "jean"));
        assertEquals("arras, jean (d')", classementLivre("d'arras", "jean"));
    }

    @Test
    void testClassementTitre() {
        assertEquals("mille est une nuit (les)", classementTitre("les mille est une nuit"));
        assertEquals("invite (l')", classementTitre("l'invite"));
    }
}