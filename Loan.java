import java.util.Date;
import java.text.NumberFormat;
import java.util.Scanner;

public class Loan{
    public double annualInterestRate;
    public int numberOfYears;
    public double loanAmount;
    public java.util.Date loanDate;
    
    public Loan(){
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
    }
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }
    public double getMonthlyPayment(){
        double monthlyRate = (this.annualInterestRate/100)/12.0;
        int termInMonths = this.numberOfYears * 12;
        double monthlyPayment =(this.loanAmount*monthlyRate) / 
        (1-Math.pow(1+monthlyRate, -termInMonths));
        return monthlyPayment;
    }
    public double getTotalPayment(double monthlyPayment){
        return monthlyPayment * this.numberOfYears * 12;
    }
    public java.util.Date getLoanDate(){
        java.util.Date date=new java.util.Date();   
        return date; 
    }
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    public int getNumberOfYears(){
        return this.numberOfYears;
    }
    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }
    public double getLoanAmount(){
        return this.loanAmount;
    }
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double interestAmount = scan.nextFloat();
        System.out.print("Enter number of years as an integer: ");
        int years = scan.nextInt();
        System.out.print("Enter loan amount for example, 120000.95: ");
        double loanAmount = scan.nextFloat();
        Loan test = new Loan(interestAmount, years, loanAmount);
        System.out.println("The loan was created on " + test.getLoanDate());
        System.out.println("The monthly payment is " +String.format("%.2f",test.getMonthlyPayment()));
        System.out.println("The total payment is " +String.format("%.2f",test.getTotalPayment(test.getMonthlyPayment())));
    }
}