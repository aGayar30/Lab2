public class MinMax {

    public int Min(int[] a){
        int m=a[0];
        for(int i=0; i<a.length; i++){
             if(a[i]<m)
                 m=a[i];
        }
    return m;
    }

    public int Max(int[] a){
        int m=a[0];
        for(int i=0; i<a.length; i++){
            if(a[i]>m)
                m=a[i];

        }
        return m;
    }


}
