public class TriangleDrawer2 {
    public static void main(String[] args){
        int row = 0;
        int SIZE = 10;
        for (row = 0; row<=SIZE; row += 1) {
            for (int col = 0; col < row; col += 1) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

}
