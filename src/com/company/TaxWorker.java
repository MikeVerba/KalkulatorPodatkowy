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
                    printer.print(menu.getAddSalaryValueText());
                    double someSalary = scanner.nextDouble();

                    printer.print(menu.getVatValueText());
                    double someSalaryVatValue = scanner.nextDouble();

                    break;
                }
                case "3" :
                {
                    double result = (countSalary(salaries) - countTax(taxValues))*0.18;
                    double result2 = countVat(salaries,taxValues);

                    printer.print(menu.getResultFirstText()+result+menu.getResultSecondText()+result2);


                    break;
                }
                case "4" :
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

    public void addSalary(double someSalary, double salaryVatValue){




            Salary salary = new Salary();
            salary.setSalary(someSalary);
            salary.setSalaryVatValue(salaryVatValue);

            salaries[salariesCounter] = salary;
            salariesCounter++;


    }


    public double countTax(TaxValue[] taxValues){ //suma netto kosztów na output

        double sum = 0;


        for(int i = 0; i<taxValuesCounter; i++) {

            sum+=taxValues[i].getValue()*(1-(0.1*taxValues[i].getVatValue()));
        }

        return sum;
    }

    public double countSalary(Salary[] salaries){ //suma netto zarobku na output

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

        return sumSalary - sumCost;

    }
}
