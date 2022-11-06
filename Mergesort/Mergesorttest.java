public class Mergesorttest {

    public static void main(String[] args) {
        int[] test = {11,10,9,8,7,6,5,4,4,2,2};
        String list = "";
        for( int x : test){
            list += x +" ";
        }
        System.out.println("unsorted : " + list);
        test = Merging.mergeSort(test);

        unsorted = "";
        for( int x : test){
            list += x +" ";
        }
        System.out.println("sorted : " + list);
        
    }
    
}
