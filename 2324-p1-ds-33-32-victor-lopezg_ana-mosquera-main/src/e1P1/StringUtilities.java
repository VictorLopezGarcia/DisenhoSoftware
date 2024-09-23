package e1P1;

public class StringUtilities {


    public static boolean isValidString(String palabra, String valido, int longitudMinima) {
        //En este bucle resolvemos el criterio del String vacío o nulo devolviendo falso si esto ocurre
        if (palabra == null || palabra.isEmpty()) {
            return false;
        }
        //Resolvemos el criterio de longitud devolviendo falso si el texto es menor al parámetro permitido
        if (palabra.length() < longitudMinima) {
            return false;
        }
        //Creamos un bucle for e instanciamos un char para poder resolver el criterio de los dígitos y caracteres admitidos

        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);

            if (!Character.isDigit(c) && valido.indexOf(c) == -1) {
                return false; //devuelve falso si no es un dígito númerico ni está en la lista de caracteres permitidos
            }

        }
        return true; // verdadero si cumple todas las condiciones
    }
    public static String lowercaseFirst(String letra) {
        //Utilizamos StringBuilder lowercase para almacenar las letras minúsculas
        StringBuilder lowercase = new StringBuilder();
        //StringBuilder uppercase para almacenar las letras mayúsculas
        StringBuilder uppercase = new StringBuilder();

        /*creamos un bucle for para recorrer el String (letra) de entrada y saber si contiene letras mayúsculas o minúsculas
         *dentro del bucle if separa los caracteres por minúsculas y mayúsuclas
         * retornamos una concatenación de lowerrcase y uppercase de tal forma que las minúsculas vayan primero*/
        for (int i = 0; i < letra.length(); i++) {
            char c = letra.charAt(i);
            if (Character.isLowerCase(c)) {
                lowercase.append(c);
            } else {
                uppercase.append(c);
            }
        }

        return lowercase + uppercase.toString();
    }

    public static boolean checkTextStats(String frase, int min, int max){
        //Creamos un bucle if para comprobar si el texto de entrada es un String nulo o vacío
        //en el caso de que sea así devolvemos un  throw new IllegalArgumentException();
        if ( frase == null || frase.isEmpty()){
            throw new IllegalArgumentException();
        }
        //Creamos un bucle if para comprobar si los valores minimo y maximo que se pasan como parámetro son negativos o cero
        // en el caso de que sea así devolvemos un  throw new IllegalArgumentException();
        if (min <= 0 || max<=0) {
            throw new IllegalArgumentException();
        }

    /*Utilizamos split para encontrar coincidencias en este caso con los espacios en blanco
    Creamos un bucle for para hacer un conteo de las palabras
    */

        String[] palabras = frase.split(" ");
        int num = 1;


        for (int i=0; i<frase.length(); i++)
        {
            char c = frase.charAt(i);
            if(c == ' '){
                num ++;
            }

        }
    /*
    creamos un int letras para contar el numero de letras totales evitando los espacios
    calculamos la media
     */


        int letras = frase.length()-num+1;

        double media =(double) letras/num;
        /*
         * Con MaxLong y el for comparamos la longitud de todas las palabras y guardamos la longitud maxima */
        int MaxLong = palabras[0].length();

        for (int i = 1; i < num; i++)
        {
            if (MaxLong<palabras[i].length())
            {
                MaxLong = palabras[i].length();
            }

        }

        // comparamos la  media con las longitudes y la palabra mas larga con el doble de la media
        if(media >= min && media <= max && MaxLong <= media*2)
        {
            return true;
        }

        return false;

    }
}
