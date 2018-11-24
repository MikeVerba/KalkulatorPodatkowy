package com.company;

public class Menu {

    private final String welcomeText = " Witaj w naszym Kalkulatorze.";
    private final String mainMenuText = " Menu glowne. \n Wybierz opcje: \n " +
           "1 - Dodaj koszt \n 2 - Dodaj zarobek \n 3 -  Wylicz podatek \n 4 - Wylicz sumę swoich dochodów\n" +
            " 5 - Wylicz sumę swoich kosztów\n" +
            " 6 - Wyświetl nazwy swoich kosztów\n 7 - Wyświetl nazwy swoich dochodów\n" +
            " 8 - Wyświetl najwyższy dochod\n 9 - Wyświetl najniższy koszt\n" +
            " 0 - Wyjście z programu";
    private final String addCostText = "Podaj koszt: ";
    private final String addCostNameText = "Podaj nazwę swojego kosztu: ";
    private final String vatValueText = "Podaj stawkę vat: ";
    private final String addSalaryNameText = "Podaj nazwę swojego dochodu: ";
    private final String addSalaryValueText ="Podaj kwotę zarobku: ";
    private final String resultFirstText = "Podatek dochodowy wynosi: ";
    private final String resultSecondText = " A VAT do zapłacenia wynosi: ";

    private final String emptyValuesText = "Nie ma wystarczających danych. Podaj dane.";
    private final String incorrectValueText = "Nieprawidłowy komunikat, wprowadź właściwe dane";
    private final String litmitExceededText = "Limit wyczerpany. Kup produkt premium!!";

    private final String printSalarySumText = "Suma dochodów wynosi: ";
    private final String printCostSumText = "Suma kosztów wynosi: ";
    private final String printCostNamesText = "Nazwy kosztów to: ";
    private final String printSalariesNamesText = "Nazwy dochodów to: ";
    private final String printMaxSalaryText = "Najwyższy dochód to: ";
    private final String printMinCostText = "Najniższy koszt to: ";



    private final String exitText = "Closing...";

    public String getAddCostText() {
        return addCostText;
    }

    public String getAddCostNameText() {
        return addCostNameText;
    }

    public String getIncorrectValueText() {
        return incorrectValueText;
    }

    public String getResultFirstText() {
        return resultFirstText;
    }

    public String getExitText() {
        return exitText;
    }

    public String getResultSecondText() {
        return resultSecondText;
    }

    public String getVatValueText() {
        return vatValueText;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public String getMainMenuText() {
        return mainMenuText;
    }

    public String getAddSalaryValueText() {
        return addSalaryValueText;
    }

    public String getLitmitExceededText() {
        return litmitExceededText;
    }

    public String getAddSalaryNameText() {
        return addSalaryNameText;
    }

    public String getPrintSalarySumText() {
        return printSalarySumText;
    }

    public String getPrintCostSumText() {
        return printCostSumText;
    }

    public String getPrintCostNamesText() {
        return printCostNamesText;
    }

    public String getPrintSalariesNamesText() {
        return printSalariesNamesText;
    }

    public String getPrintMaxSalaryText() {
        return printMaxSalaryText;
    }

    public String getPrintMinCostText() {
        return printMinCostText;
    }

    public String getEmptyValuesText() {
        return emptyValuesText;
    }
}

