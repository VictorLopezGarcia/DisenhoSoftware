package e2P1;

public class ImmutableMatrix {
    //Inicializamos las variables que vamos a pasar por los constructores
    private int[][] Matrix;
    private int cont = 1;

    //Creamos el primer constructor
    //Este acepta un array bidimensional de enteros y comprueba que no sea ni irregular ni nulo
    public ImmutableMatrix(int[][] arr) {

        //Condicional para comprobar que el array no es nulo
        if (arr == null || arr.length == 0) {
            //en caso de serlo se lanza la excepción
        throw new IllegalArgumentException();
        }



        // Bucle que recorre el array comparando que la longitud de las filas y columnas sean la misma
        // Dicho de otra manera: Comprueba que el array es regular, en caso contrario lanza la excepción
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j<arr[0].length; j++) {
                if (arr[i].length != arr[0].length) {
                    throw new IllegalArgumentException();
                }
            }
        }
        //Si el array pasa las condiciones, el constructor devuelve una copia del mismo
        //para respetar la immutabilidad
        this.Matrix = arr;

    }

    //Creamos Un constructor que acepta dos valores enteros (numero de filas y
    //numero de columnas) y crea una matriz con esas dimensiones rellenandola posición a posición
    //empezando por el 1 y aumentando sus valores
    public ImmutableMatrix(int f, int c) {
        //Comprobamos que las dimensiones son correctas y mayores que 0
        if (f <= 0 || c <= 0) {
            throw new IllegalArgumentException();
        }

        //Una vez comprobado igualamos la matriz a las dimensiones pasadas
        Matrix = new int[f][c];

        //Una vez tengamos la matriz establecida la rellenamos recorriendola con bucles
        // y rellenando cada espacio con un contador que incrementa sucesivamente empezando en 1
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                Matrix[i][j] = cont;
                cont++;
            }
        }

    }


    public String toString() {

        //Creamos la variable MatrizString que sera del tipo Stringbuilder
        //para asi posteriormente añadirle los valores de la matriz con la funcion append.
        StringBuilder MatrizString = new StringBuilder();


        //Creamos 2 bucles concatenados que recorren la matriz y a su vez van creando el String
        //utilizando la funcion append que recoge el valor de la matriz y lo añade al String como un caracter más.

        for (int i = 0; i < Matrix.length; i++) {
            MatrizString.append("[");
            for (int j = 0; j < Matrix[i].length; j++)
            {
                MatrizString.append(Matrix[i][j]);
                if(j < Matrix[i].length-1)
                {
                    MatrizString.append(", ");
                }

            }
            MatrizString.append("]");
            MatrizString.append("\n");
        }

        //Devolvemos la matriz en forma de String del mismo formato que se nos pide
        return MatrizString.toString();
    }

    public int at(int f, int c){

        //Comprobamos que la posicion del valor que se nos pide buscar
        //está dentro del parámetro de la matriz
        //En caso contrario se lanzará una excepción
        if(f > Matrix.length || c > Matrix[0].length || f<=0 || c<=0)
        {
            throw new IllegalArgumentException();
        }

        //Una vez hecho la comprobación podemos automaticamente devolver el valor solicitado
        return Matrix[f][c];
    }

    //Metodo que devuelve el numero de filas de la matriz, al haber comprobado la regularidad previamente
    //sabemos que la longitud de las columnas es siempre la misma por lo tanto nos dara el numero de filas
    //simplemente midiendo una columna
    public int rowCount(){
        return Matrix.length;
    }

    //Metodo que devuelve el numero de columnas de la matriz, al haber comprobado la regularidad previamente
    //sabemos que la longitud de las filas es siempre la misma por lo tanto nos dara el numero de columnas
    //simplemente midiendo una fila
    public int columnCount(){
        return Matrix[0].length;
    }

    //Metodo que devuelve
    public int[][] toArray2D(){
        //Metodo que devuelve una copia de la matriz generada en tipo array de 2 dimensiones
        //Realiza la copia recorriendo la matriz y copiando valor a valor a otro array generado con las mismas dimensiones
        //mediante el uso de 2 bucles concatenados
        int[][] Array = new int[Matrix.length][Matrix[0].length];
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[i].length; j++) {
                Array[i][j]=Matrix[i][j];
            }
        }
        return Array;
    }

    //Metodo que devuelve una copia de la matriz generada pero con el orden de los elementos de las filas revertidos

    public ImmutableMatrix reverse()
    {
        //Creamos una variable a la que vamos a copiar la matriz reverse con las mismas dimensiones
        int[][] reversedMatrix = new int[Matrix.length][Matrix[0].length];

        //Con 2 bucles concatenados copiamos los valores de la matriz generada a la copia
        //pero esta vez copiando de mayor a menor en las posiciones de las filas mediante: (Matrix[0].length - 1 - j)
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {

                reversedMatrix[i][j] = Matrix[i][Matrix[0].length - 1 - j];

            }
        }
        return new ImmutableMatrix(reversedMatrix);
    }

    //Metodo que devuelve una copia de la matriz generada pero traspuesta
    public ImmutableMatrix transpose()
    {

        //Creamos la variable donde realizaremos la copia pero con las dimensiones de fila y columna intercambiadas
        //para asi poder hacer la traspuesta
        int[][] trasnposedMatrix = new int[Matrix[0].length][Matrix.length];

        //Del mismo modo que los 2 anteriores metodos copiamos con 2 bucles concatenados recorriendo las matrices todos los valores
        //pero intercambiando las variables i y j en una de las matrices para que realice la traspuesta
        for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {

                trasnposedMatrix[j][i] = Matrix[i][j];

            }
        }
        return new ImmutableMatrix(trasnposedMatrix);
    }

    //Metodo que returna una copia de la matriz con nuevas dimensiones introducidas por parametro
    public ImmutableMatrix reshape(int newColumns){


        //Comprobamos con este condicional que la redimension es realizable
        //Comprueba que con el nuevo numero de columnas no va a quedar una matriz irregular
        //de ser asi lanzamos una excepción
        if((Matrix[0].length*Matrix.length)%newColumns!=0){
            throw new IllegalArgumentException();
        }

        //Creamos una variable que realiza la operación necesaria
        // para que con el nuevo numero de columnas haga las filas correspondientes para rellenar todos los valores de la matriz
        int newRows = (Matrix[0].length*Matrix.length)/newColumns;

        //Inicializamos la variable dodne vamos a introducir la copia de la matriz redimensionada
        int[][] reshapedMatrix = new int[newRows][newColumns];


        //inicializamos un contador para rellenar la matriz empezando desde 1 y rellenando sucesivamente
        int Contador=1;
        

        //Con 2 bucles conccatenados y calculada la nueva dimension de la matriz
        //rellenamos la nueva matriz redimensionada con los mismos valores de la principal mediante el contador previamente creado
        for (int i = 0; i < newRows; i++) {
            for (int j = 0; j < newColumns; j++) {
                reshapedMatrix[i][j]=Contador;
                Contador++;

            }
        }
        return new ImmutableMatrix(reshapedMatrix);
    }

}


