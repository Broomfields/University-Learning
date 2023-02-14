/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ood_tax;

import java.util.Scanner;

/**
 *
 * @author u0012604
 */
public class OOD_Tax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int PERSONAL_ALLOWANCE = 12570;
        final int BASIC_RATE_THRESHOLD = 50270;
        final int HIGHER_RATE_THRESHOLD = 150000;
        
        final double BASIC_RATE = 0.2;
        final double HIGHER_RATE = 0.4;
        final double ADDITIONAL_RATE = 0.45;
        
        double basicTaxToPay = 0.0;
        double higherTaxToPay = 0.0;
        
        final Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Please enter your salary: ");
        final int salary = keyboard.nextInt();
        
        if(salary <= PERSONAL_ALLOWANCE) {
            System.out.println("No tax to pay.");
        }
        else {
            int salaryMinusPersonalAllowance = PERSONAL_ALLOWANCE;
            
            // always calculate the basic rate
            if(salaryMinusPersonalAllowance >= BASIC_RATE_THRESHOLD && salaryMinusPersonalAllowance <= HIGHER_RATE_THRESHOLD) {
                int payAtHigherRate = salaryMinusPersonalAllowance - BASIC_RATE_THRESHOLD;
                System.out.println(payAtHigherRate);
                int payAtBasicRate = salaryMinusPersonalAllowance - payAtHigherRate;
                
                higherTaxToPay = HIGHER_RATE * payAtHigherRate;
                basicTaxToPay = BASIC_RATE * payAtBasicRate;
            }
            else {
                basicTaxToPay = BASIC_RATE * salaryMinusPersonalAllowance;
            }
            
            double netPay = salary - higherTaxToPay - basicTaxToPay;
            
            System.out.println("-----------------------");
            System.out.printf("Gross Salary: %d\n", salary);
            System.out.printf("Basic Rate Tax: %.2f\n", basicTaxToPay);
            System.out.printf("Higher Rate Tax: %.2f\n", higherTaxToPay);
            System.out.printf("Net Pay: %.2f\n", netPay);
        }
        
    }
    
}
