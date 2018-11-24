package com.company;

public class Menu {

    private String welcomeText = " Witaj w naszym Kalkulatorze.";
    private String mainMenuText = " Menu glowne. \n Wybierz opcje: \n " +
           "1 - Dodaj koszt \n 2 - Dodaj zarobek \n 3 -  Wylicz podatek \n 4 - Wyjście z programu";
    private String addCostText = "Podaj koszt: ";
    private String addCostNameText = "Podaj nazwę swojego kosztu: ";
    private String vatValueText = "Podaj stawkę vat: ";
    private String addSalaryValueText ="Podaj kwotę zarobku: ";
    private String resultFirstText = "Podatek dochodowy wynosi: ";
    private String resultSecondText = " A VAT do zapłacenia wynosi: ";
    private String incorrectValueText = "Nieprawidłowy komunikat, wprowadź właściwe dane";
    private String litmitExceededText = "Limit wyczerpany. Kup produkt premium!!";
    private String exitText = "Closing...";

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
}

