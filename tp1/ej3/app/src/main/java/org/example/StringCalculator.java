package org.example;
import java.util.List;
import java.util.ArrayList;

public class StringCalculator {

    private List<Integer> numbers;
    
    public StringCalculator(){
        numbers = new ArrayList<>();
    }

    public int add(String input){
        
        parseStringToIntList(input);

        int sum = 0;
        for(int i = 0; i < numbers.size(); i++)
            sum += numbers.get(i);
        return sum;
    }

    private void parseStringToIntList(String input){
        
        if(input.isEmpty()){
            numbers.add(0);
        }else{
            String currentStr = "";
            for(int i = 0; i < input.length(); i++){
                char currentChar = input.charAt(i);
                
                //cuando currentChar no es un delimitador ni un digito, excepcion 
                if(!isDelimiter(currentChar) && !Character.isDigit(currentChar))
                    throw new IllegalArgumentException();
                
                //cuando currentChar es el ultimo char: 
                if(i == input.length() - 1){
                    //cuando currentChar es un ',' o un '\n', es decir, un delimitador, excepcion 
                    if(isDelimiter(currentChar)){
                        throw new IllegalArgumentException();
                    }else{
                    //cuando currentChar es un digito, actualizo el currentStr para incluir a currentChar, 
                    //lo transformo a entero, lo agrego a la lista y reinicio currentStr 
                        currentStr += currentChar;
                        int n = Integer.parseInt(currentStr);
                        numbers.add(n);
                        currentStr = "";
                    }
                }else{
                //a partir de aqui, sabemos que currentChar no es el ultimo char 
    
                    char nextChar = input.charAt(i+1); 
                    
                    //si nextChar no es un delimitador ni un digito, excepcion 
                    if(!isDelimiter(nextChar) && !Character.isDigit(nextChar))
                        throw new IllegalArgumentException();              

                    //si currentChar es un delimitador:
                    if(isDelimiter(currentChar)){
                        //si nextChar tambien es un delimitador, excepcion 
                        if(isDelimiter(nextChar)){
                            throw new IllegalArgumentException();
                        }else{
                        //si nextChar es un digito, transformo el currentStr en un entero, lo agrego a la lista y reinicio currentStr 
                            int n = Integer.parseInt(currentStr);
                            numbers.add(n);
                            currentStr = "";
                        }
                    }else{
                    //si currentChar es un digito, actualizo el currentStr 
                        currentStr += currentChar;
                    }
                }
            }
        }
        
    }

    private boolean isDelimiter(char c){
        return c == ',' || c == '\n';
    }

    /**
     * Antes de refactorizar
     *
    public int add(String numbers){
        if(!numbers.isEmpty()){
            char fstChar = numbers.charAt(0);
            if(!Character.isDigit(fstChar)) throw new IllegalArgumentException();
        }

        int n = 0;
        String currentStr = "";
        for(int i = 0; i < numbers.length(); i++){
            char c = numbers.charAt(i);
            if(Character.isDigit(c)){
                currentStr += c;
            }else{
                if(i < numbers.length() - 1){
                   char nextChar = numbers.charAt(i+1);
                   if(!Character.isDigit(nextChar)) throw new IllegalArgumentException();
                }
                if(i == numbers.length() - 1) throw new IllegalArgumentException();

                if(!currentStr.isEmpty()){
                    int m = Integer.parseInt(currentStr);
                    n += m;
                }
                currentStr = "";
            }
        }
      
        if(!currentStr.isEmpty()){
            int m = Integer.parseInt(currentStr);
            n += m;
        }

        return n;
    }/*

    /**
     * version donde solo se consideraba que los numeros eran de un digito
    public int add(String numbers){
        if(!numbers.isEmpty() && numbers.length() % 2 == 0) throw new IllegalArgumentException();

        int n = 0;
        for(int i = 0; i < numbers.length(); i += 2){ //voy incrementando de a dos porque se que solo puede haber comasi
            char c = numbers.charAt(i);
            n += Character.getNumericValue(c);
      }

        return n;
    }*/
    
    /**
     * version antes de permitir que venga mas de un numero 
    public int add(String numbers){
        
        if(numbers.length() == 2 ||numbers.length() > 3) throw new IllegalArgumentException();

        int n = 0;
        if(numbers.length() == 1){
            char c = numbers.charAt(0);
            n = Character.getNumericValue(c);
        }else if(numbers.length() == 3){
            char c1 = numbers.charAt(0);
            char c2 = numbers.charAt(2);
            int n1 = Character.getNumericValue(c1);
            int n2 = Character.getNumericValue(c2);
            n = n1 + n2;
        }
        return n;
    }*/

}
