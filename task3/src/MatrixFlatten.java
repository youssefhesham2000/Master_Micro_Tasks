import java.util.Vector;

public class MatrixFlatten {
    /**
     * @param toBeFlattened generic 3d array
     * @return flattened 1D Vector
     * */
    public static <E> Vector flatten(E[][][] toBeFlattened){
        Vector flattened =new Vector<>();
        int width=toBeFlattened.length;
        int height=toBeFlattened[0].length;
        int depth=toBeFlattened[0][0].length;
        flattened.setSize(width*height*depth);
        for (int i=0;i< toBeFlattened.length;i++){
            for (int j=0;j<toBeFlattened[0].length;j++){
                for (int k=0;k<toBeFlattened[0][0].length;k++){
                    flattened.add(toBeFlattened[i][j][k]);
                }
            }
        }
        return flattened;
    }
    /**
     * @param V a 1D vector
     * @param  i integer of width
     *@param j integer of height
     *@param k integer of depth
     * */
    public static<E> void addInIndex(Vector V,int i,int j,int k,E [][][]input){
    int width=input.length;
    int height=input[0].length;
    int index=i+j*width+k*width*height;
    V.set(index,input[i][j][k]);
    }
    public static void main(String args[]){
        Integer[][][] test ={{{1,2},{3,4}},{{5,6},{7,8}}};
        flatten(test);
    }
}
