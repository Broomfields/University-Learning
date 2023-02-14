/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package uk.ac.tees.scedt.u0012604.week_02_demo;

import java.util.Scanner;

/**
 *
 * @author u0012604
 */
public class Week_02_Demo {

    public static void main(String[] args) {
        final int PERSONAL_ALLOWANCE = 12570;
        final int BASIC_RATE_THRESHOLD = 50270;
        final int HIGHER_RATE_THRESHOLD = 150000;
        
        System.out.println("Enter salary ");
        
        Scanner keyboard = new Scanner(System.in);
        
        int grossSalary = keyboard.nextInt();
        
        if(grossSalary > PERSONAL_ALLOWANCE) { // they are a tax payer
            
            int taxableSalary = grossSalary - PERSONAL_ALLOWANCE;
            
            System.out.println("taxableSalary - " + taxableSalary);
            
            double netSalary = 0.0;
                    
            if(taxableSalary > BASIC_RATE_THRESHOLD && 
                    taxableSalary < HIGHER_RATE_THRESHOLD) {
                
                int payAtHigherRate = taxableSalary - BASIC_RATE_THRESHOLD;
                int payAtLowerRate = taxableSalary - payAtHigherRate;
                
                double higherTaxToPay = payAtHigherRate * 0.4;
                double basicTaxToPay = payAtLowerRate * 0.2;
                
                System.out.println("higherTaxToPay: " + higherTaxToPay);
                netSalary = grossSalary - higherTaxToPay + basicTaxToPay;
            }
            else {
                double basicTaxToPay = taxableSalary * 0.2;
                
                netSalary = grossSalary - basicTaxToPay;
     
            }
            
            System.out.println("Gross Salary: " + grossSalary);
            System.out.println("Net Salary: " + netSalary);
            
        }
        else {
            System.out.println("No tax to pay");
        }
        
    }
}
