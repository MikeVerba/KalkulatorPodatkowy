package com.company;

import java.util.Scanner;

public class TaxWorker {

    Menu menu;
    Scanner scanner;
    Printer printer;
    Salary[] salaries;
    int salariesCounter = 0;
    TaxValue[] taxValues;
    int taxValuesCounter = 0;
    public TaxWorker(){

        scanner = new Scanner(System.in);
        printer = new Printer();
        menu = new Menu();
        salaries = new Salary[50];
        taxValues = new TaxValue[50];

    }

    public void start(){


        boolean isWorking = true;

        printer.print(menu.getWelcomeText());
        while (isWorking){
            printer.print(menu.getMainMenuText());
            String choice = scanner.next();
            switch (choice){
                case "1" :

                {

                    if(taxValuesCounter>=50){
                        printer.print(menu.getLitmitExceededText());
                        break;
                    }
                    printer.print(menu.getAddCostNameText());
                    String someCostName = scanner.next();


                    printer.print(menu.getAddCostText());
                    double someCost = scanner.nextDouble();


                    printer.print(menu.getVatValueText());
                    double someVatValue = scanner.nextDouble();

                    addValue(someCostName,someCost,someVatValue);

                    break;

                }
                case "2" :
                {
                    if(salariesCounter>=50){
                        printer.print(menu.getLitmitExceededText());
                        break;
                    }

                    printer.print(menu.getAddSalaryNameText());
                    String someSalaryName = scanner.next();

                    printer.print(menu.getAddSalaryValueText());
                    double someSalary = scanner.nextDouble();

                    printer.print(menu.getVatValueText());
                    double someSalaryVatValue = scanner.nextDouble();

                    addSalary(someSalary,someSalaryVatValue,someSalaryName);

                    break;
                }
                case "3" :
                    if(taxValuesCounter<1 && salariesCounter<1){
                        printer.print(menu.getEmptyValuesText());
                        break;
                    }
                {
                    double result = Math.round((countSalary() - countTax())*0.18);
                    double result2 = countVat(salaries,taxValues);

                    printer.print(menu.getResultFirstText()+result+menu.getResultSecondText()+result2);


                    break;
                }
                case "4" :
                    if(salariesCounter<1){
                        printer.print(menu.getEmptyValuesText());
                        break;
                    }

                {
                    printer.print(menu.getPrintSalarySumText() + countSalariesSum());
                    break;
                }
                case "5" :
                    if(taxValuesCounter<1){
                        printer.print(menu.getEmptyValuesText());
                        break;
                    }
                {
                    printer.print(menu.getPrintCostSumText() + countCostsSum());
                    break;
                }
                case "6" :
                    if(taxValuesCounter<1){
                        printer.print(menu.getEmptyValuesText());
                        break;
                    }
                {
                    printer.print(menu.getPrintCostNamesText());

                    String[] costNames = returnCostNames();
                    for (int i = 0; i<taxValuesCounter; i++){
                        printer.print(costNames[i]);
                    }
                    break;
                }
                case "7" :
                    if(salariesCounter<1){
                        printer.print(menu.getEmptyValuesText());
                        break;
                    }
                {
                    printer.print(menu.getPrintSalariesNamesText());

                    String[] salariesNames = returnSalariesNames();
                    for (int i = 0; i<salariesCounter; i++){
                        printer.print(salariesNames[i]);
                    }
                    break;
                }
                case "8":
                    if(salariesCounter<1){
                        printer.print(menu.getEmptyValuesText());
                        break;
                    }
                {
                    printer.print(menu.getPrintMaxSalaryText()+returnMaxIncome());
                    break;
                }
                case "9":
                    if(taxValuesCounter<1){
                        printer.print(menu.getEmptyValuesText());
                        break;
                    }
                {
                    printer.print(menu.getPrintMinCostText()+returnMinTax());
                    break;
                }
                case "0" :
                {
                    printer.print(menu.getExitText());
                    isWorking = false;
                    break;
                }
                default: printer.print(menu.getIncorrectValueText());

            }


        }

    }

    public void addValue(String someCostName, double someCost, double someVatValue){



            TaxValue taxValue = new TaxValue();
            taxValue.setName(someCostName);
            taxValue.setValue(someCost);
            taxValue.setVatValue(someVatValue);

            taxValues[taxValuesCounter] = taxValue;
            taxValuesCounter++;



    }

    public void addSalary(double someSalary, double salaryVatValue,String someSalaryName){




            Salary salary = new Salary();
            salary.setSalary(someSalary);
            salary.setSalaryVatValue(salaryVatValue);
            salary.setName(someSalaryName);

            salaries[salariesCounter] = salary;
            salariesCounter++;


    }


    public double countTax(){ //suma netto kosztów na output

        double sum = 0;


        for(int i = 0; i<taxValuesCounter; i++) {

            sum+=taxValues[i].getValue()*(1-(0.1*taxValues[i].getVatValue()));
        }

        return sum;
    }

    public double countSalary(){ //suma netto zarobku na output

        double sum = 0;


        for(int i = 0; i<salariesCounter; i++) {

            sum+=salaries[i].getSalary()*(1-(0.1*salaries[i].getSalary()));
        }

        return sum;

    }

    public double countVat(Salary[] salaries, TaxValue[] taxValues){



        double sumCost = 0;


        for(int i = 0; i<taxValuesCounter; i++) {

            sumCost+=taxValues[i].getValue()*((0.1*taxValues[i].getVatValue()));
        }

        double sumSalary = 0;


        for(int i = 0; i<salariesCounter; i++) {

            sumSalary+=salaries[i].getSalary()*((0.1*salaries[i].getSalary()));
        }

        return Math.round(sumSalary - sumCost);

    }

    public double countCostsSum(){  //liczy wszystkie koszty - zagadnienie 1
        double costSum = 0;
        for(int i = 0; i<taxValuesCounter; i++){
            costSum+=taxValues[i].getValue();
        }
        return costSum;
    }

    public double countSalariesSum(){  //liczy wszystkie dochody - zagadnienie 2
        double salariesSum = 0;
        for(int i = 0; i<salariesCounter; i++){
            salariesSum+=salaries[i].getSalary();
        }
        return salariesSum;
    }

    public double returnMaxIncome() {    //liczy najwyzszy dochod

        double maxIncome = salaries[0].getSalary();

        for(int i = 0; i<salariesCounter; i++){
            if(salaries[i].getSalary() > maxIncome){
                maxIncome = salaries[i].getSalary();
            }
        }
        return maxIncome;
    }
    public double returnMinTax() {    //liczy najnizszy koszt

        double minIncome = taxValues[0].getValue();

        for(int i = 0; i<taxValuesCounter; i++){
            if(taxValues[i].getValue() < minIncome){
                minIncome = taxValues[i].getValue();
            }
        }
        return minIncome;
    }

    public String[] returnCostNames() {   //zwraca nazwy kosztow
        String[] costNames = new String[taxValuesCounter];
        for(int i = 0; i<taxValuesCounter; i++){
            costNames[i] = taxValues[i].getName();
        }
        return costNames;
    }
    public String[] returnSalariesNames() {  //zwraca nazwy dochodow
        String[] salariesNames = new String[salariesCounter];
        for (int i = 0; i < salariesCounter; i++) {
            salariesNames[i] = salaries[i].getName();
        }
        return salariesNames;
    }
}
