public class HashTable {

    String[] hashArray;
    int arraySize;
    int size = 0;

    public HashTable(int noOfSlots){

        if(isPrime(noOfSlots)){

            hashArray = new String[noOfSlots];
            arraySize = noOfSlots;
        }

        else {

            int primeCount = getNextPrime(noOfSlots);
            hashArray = new String[primeCount];
            arraySize = primeCount;

            System.out.println("Given size " + noOfSlots + " not a prime number !");
            System.out.println("Changed size = " + primeCount);

        }
    }

    //Sieve of Eratosthenes Algorithm is used ->
    private boolean isPrime(int num){

        for (int i=2; i*i<=num; i++){

            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int minNum){

        for (int i = minNum ; true ; i++){

            if(isPrime(i)){
                return i;
            }
        }
    }

    //Returns preferred index position:
    private int hashFun1(String word){

        int hashVal = word.hashCode();
        hashVal = hashVal%arraySize;
        if (hashVal < 0){

            hashVal+=arraySize;
        }

        return hashVal;
    }

    //Returns Step-Size:
    private int hashFun2(String word){

        int hashVal = word.hashCode();
        hashVal = hashVal%arraySize;
        if(hashVal < 0){

            hashVal+=arraySize;
        }
        //choose any prime number less than arraySize
        return 3 - hashVal%3;
    }

    public void insert(String word){

        int hashVal = hashFun1(word);
        int stepSize = hashFun2(word);

        while(hashArray[hashVal] != null){

            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }

        hashArray[hashVal] = word;
        System.out.println("Inserted word is: " + word);
        size++;
    }

    public int find(String word){

        int hashVal = hashFun1(word);
        int stepSize = hashFun2(word);

        while(hashArray[hashVal] != null){

            if (hashArray[hashVal].equals(word)){

                System.out.print(hashArray[hashVal] + " is present at ");
                return hashVal;
            }

            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }

        System.out.print(hashArray[hashVal] + " is present at ");
        return hashVal;
    }

    public void displayTable(){

        System.out.println("------- HashTable : --------");
        for (int i=0; i<arraySize; i++){

            if (hashArray[i] != null){
                System.out.print(hashArray[i] + " ");
            }

            else {
                System.out.print(" ** ");
            }
        }

        System.out.println("");
    }
}
