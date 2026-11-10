package it.unibo.tdd;

public class Multipli {
    
    public String fizzBuzz(int num) {
        String testo = String.valueOf(num); //converte 'num' da numero intero (int) a stringa (String). Serve perchè 'contains' vuole una stringa.
       
        if ((testo.contains("3") || num % 3 == 0) &&
            (testo.contains("5") || num % 5 == 0)) {
            return "FizzBuzz";
        }
        else if (testo.contains("3") || num % 3 == 0) {
            return "Fizz";
        }
        else if (testo.contains("5") || num % 5 == 0) {
            return "Buzz";
        }
        else {
            return String.valueOf(num);
        }
    }

}
