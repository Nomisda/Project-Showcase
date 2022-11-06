class Merging{

public static int[] mergeSort(int[] input){
    if( input.length < 2){ return input;}
    int half = input.length / 2;
    int otherHalf = input.length - half;
    int[] l = new int[half];
    int[] r = new int[otherHalf];
    for( int x = 0; x < half; x++){
        l[x] = input[x];
    }
    for( int x = 0; x < otherHalf; x++){
        r[x] = input[half+x];
    }

    return merge( mergeSort(l),mergeSort(r));
}

private static int[] merge(int[] l , int[] r){
    int[] combined = new int[l.length + r.length];
    int x = 0;
    int y = 0;
    int z = 0;

        while( x < l.length && y <r.length){
        if(l[x] <= r[y]){
            combined[z] = l[x];
            z++;
            x++;
        }else{
            combined[z] = r[y];
            z++;
            y++;
        }
    }

    while (x<l.length) {
        combined[z] = l[x];
        z++;
        x++;
    }
    while (y < r.length) {
        combined[z] = r[y];
        z++;
        y++;
    }

    return combined;
}  

}