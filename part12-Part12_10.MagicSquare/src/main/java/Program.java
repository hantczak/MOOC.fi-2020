
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here
        
        MagicSquareFactory msFactory = new MagicSquareFactory();
        System.out.println(msFactory.createMagicSquare(3));
        MagicSquare magicSquare = msFactory.createMagicSquare(3);
        magicSquare.placeValue(0,0,1);
        magicSquare.placeValue(0,1,4);
        magicSquare.placeValue(0,2,7);
        magicSquare.placeValue(1,0,2);
        magicSquare.placeValue(1,1,5);
        magicSquare.placeValue(1,2,8);
        magicSquare.placeValue(2,0,3);
        magicSquare.placeValue(2,1,6);
        magicSquare.placeValue(2,2,9);
        System.out.println(magicSquare.toString());
        System.out.println(magicSquare.sumsOfRows());
        System.out.println(magicSquare.sumsOfColumns());
        System.out.println(magicSquare.sumsOfDiagonals());
    }
}
