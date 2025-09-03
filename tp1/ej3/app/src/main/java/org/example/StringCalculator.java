package org.example;
import java.util.List;
import java.util.ArrayList;

public class StringCalculator {

    private List<Integer> numbers;
    private boolean isDefaultDelimiter;
    private String input;
    private char noDefaultDelimiter;
    private List<Integer> negativeInts;

    public StringCalculator(){
        numbers = new ArrayList<>();
        isDefaultDelimiter = true;
        negativeInts = new ArrayList<>();
    }

    public int add(String input){

        //verifico si el parametro actual es un input default o no 
        verifyDefaultDelimiter(input);
        
        //en this.input esta el input con solo numeros (por si el input parametro formal
        //tenia identificadores no default)
        parseStringToIntList(this.input);

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
                
                //cuando currentChar no es un delimitador ni un digito ni un '-' (posibilidad de 
                //tener un entero negativo), excepcion 
                if(!isDelimiter(currentChar) && !Character.isDigit(currentChar) && currentChar != '-')
                    throw new IllegalArgumentException();
                
                //cuando currentChar es el ultimo char: 
                if(i == input.length() - 1){
                    //cuando currentChar es un delimitador, excepcion
                    //lo mismo en caso de ser '-'
                    if(isDelimiter(currentChar) || currentChar == '-'){
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
                    
                    //si nextChar no es un delimitador ni un digito ni un '-', excepcion 
                    if(!isDelimiter(nextChar) && !Character.isDigit(nextChar) && nextChar != '-')
                        throw new IllegalArgumentException();

                    //si currentChar es un delimitador:
                    if(isDelimiter(currentChar)){
                        //si nextChar tambien es un delimitador, excepcion 
                        if(isDelimiter(nextChar)){
                            throw new IllegalArgumentException();
                        }else{
                        //si nextChar es un digito o un - (probable entero negativo), transformo el currentStr en un entero, lo agrego a la lista y reinicio currentStr 
                            int n = Integer.parseInt(currentStr);
                            numbers.add(n);
                            currentStr = "";
                        }
                    }else{
                    //si currentChar es un digito o un -:
                        if(currentChar == '-'){
                            //en caso que nextChar no sea un digito, excepcion normal 
                            if(!Character.isDigit(nextChar))
                                throw new IllegalArgumentException();
                            
                            //sabemos que nextChar es un digito 
                            //buscamos cual es el entero negativo 
                            //int negativeInt = searchNegativeInteger(input,i);
                            //throw new IllegalArgumentException("negatives not allowed: " + negativeInt);
                            
                            //sabemos que nextChar es un digito, entonces hay por lo menos un entero negativo 
                            //buscamos cuales son esos enteros negativos 
                            searchNegativeIntegers(input,i);
                            throw new IllegalArgumentException("negatives not allowed: " + negativeInts.toString());
                        }else{
                            currentStr += currentChar;
                        } 
                    }
                }
            }
        }
        
    }

    private boolean isDelimiter(char c){
        if(isDefaultDelimiter)
            return c == ',' || c == '\n';
        else 
            return c == noDefaultDelimiter;
    }

    /**
     * metodo que verifica si el input tiene forma para ser un delimitador 
     * no default. En caso de no serlo, modifica el atributo input para que 
     * en el mismo solo esten los numeros, no el delimitador ni \n 
     */
    private void verifyDefaultDelimiter(String input){
        
        if(input.length() >= 4 && input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\n'){
            isDefaultDelimiter = false;
            noDefaultDelimiter = input.charAt(2);
            //el string de numeros arranca en la posicion 4
            this.input = input.substring(4);
        }else{
            //el input se trata como antes, no de alguna forma especial
            this.input = input; 
        }
    }

    /**
     * @pre 0 <= i < s.length() - 1 && s.charAt(i) == '-' && Character.isDigit(s.charAt(i+1))
     * @post retorna el entero negativo que comienza en el string s en la posicion i 
     */
    private int searchNegativeInteger(String s,int i){
        if(i < 0 || i >= s.length() || s.charAt(i) != '-' || !Character.isDigit(s.charAt(i+1)))
            throw new IllegalArgumentException();

        String negativeInt = "-";

        //comienzo a crearlo desde el primer digito 
        for(int j = i+1; j < s.length() && Character.isDigit(s.charAt(j)); j++){
            negativeInt += s.charAt(j);
        }

        return Integer.parseInt(negativeInt);
    }

    /**
     * @pre 0 <= i < s.length() - 1 && s.charAt(i) == '-' && Character.isDigit(s.charAt(i+1))
     * @post retorna el entero negativo que comienza en el string s en la posicion i 
     */
    private void searchNegativeIntegers(String s, int i){
        if(i < 0 || i >= s.length() || s.charAt(i) != '-' || !Character.isDigit(s.charAt(i+1)))
            throw new IllegalArgumentException();
        
        String currentNegativeInt = "";
        int j = i;
        while(j < s.length()){
            char currentChar = s.charAt(j);
            
            //en caso de que el currentChar no sea '-', entonces voy al siguiente
            if(currentChar != '-'){
                j++;
            }else{
                //en caso de que el currentChar sea '-' 
                
                //pero que sea el ultimo digito 
                if(j == s.length() - 1){
                    j++;
                }else{
                //y no sea el ultimo digito
                
                    char nextChar = s.charAt(j+1);

                    if(!Character.isDigit(nextChar)){
                    //en caso de que el siguiente char no sea un digito, avanzo 
                        j++;
                    }else{
                    //en caso de que el siguiente char sea un digito, entonces el '-' actual va 
                        currentNegativeInt += currentChar; 
                        
                        //agrego todos los siguientes digitos al currentNegativeInt
                        for(int k = j+1; k < s.length() && Character.isDigit(s.charAt(k)); k++){
                            currentNegativeInt += s.charAt(k);
                            //voy actualizando el j 
                            j++;
                        }
                        
                        //transformo el currentNegativeInt a un entero negativo, lo agrego a la lista 
                        // y reinicio currentNegativeInt 
                        int n = Integer.parseInt(currentNegativeInt);
                        negativeInts.add(n);
                        currentNegativeInt = "";
                    }
                }
            }
        }
        /*
        for(int j = i; j < s.length(); j++){
            
            char currentChar = s.charAt(j);

            //UNICA CONDICION PARA ACEPTAR '-'
            //si no estoy en el ultimo char, si el char actual es - y el siguiente es digito 
            //entonces agrego el actual al currentNegativeInt 
            if(j < s.length() - 1 && currentChar == '-' && Character.isDigit(s.charAt(j+1)))
                currentNegativeInt += currentChar;
            
            if(Character.isDigit(currentChar)){
                currentNegativeInt += currentChar;

                //en caso que estemos en el ultimo char, transformo currentNegativeInt en int 
                //para agregarlo a la lista, y actualizo currentNegativeInt 
                if(j == s.length() - 1){
                    int n = Integer.parseInt(currentNegativeInt);
                    negativeInts.add(n);
                    currentNegativeInt = "";
                }else if(j < s.length() - 1 && !Character.isDigit(s.charAt(j+1))){
                //en caso de que no estemos en el ultimo char, me fijo si el proximo char es un digito, 
                //en caso de no serlo, entonces transformo currentNegativeInt en int para agregarlo 
                //a la lista, y actualizo currentNegativeInt 
                    int n = Integer.parseInt(currentNegativeInt);
                    negativeInts.add(n);
                    currentNegativeInt = "";
                }
            }
        }
        */
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
