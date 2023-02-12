/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shaunbroomfield.week_08;

import java.util.function.BiPredicate;

/**
 *
 * @author perso
 */
public class Cat {

    private static String Name;
    private static int Age;

    public static void main(String[] args) {

    }

    public static int getAgeInHumanYears() {
        int humanYearsAge = 0;
        
        BiPredicate<Integer, Integer> ageComparitor = (num1, num2) -> {return (Age > num1 && Age < num2);};
        if (ageComparitor.test(15,24))
        {
            humanYearsAge = 1;
        }
        else if (ageComparitor.test(24,28))
        {
            humanYearsAge = 2;
        }
        else if (ageComparitor.test(28,32))
        {
            humanYearsAge = 3;
        }
        else if (ageComparitor.test(32,36))
        {
            humanYearsAge = 4;
        }
        else if (ageComparitor.test(36,40))
        {
            humanYearsAge = 5;
        }
        else if (ageComparitor.test(24,28))
        {
            humanYearsAge = 6;
        }
        else if (ageComparitor.test(24,28))
        {
            humanYearsAge = 7;
        }
        
        return humanYearsAge;
    }
    
    
    public static void setAge(int age) {
        Age = age;
    }
    
    public static int getAge() {
        return Age;
    }
    
    public static void setName(String name) {
        Name = name;
    }
    
    public static String getName() {
        return Name;
    }
}
