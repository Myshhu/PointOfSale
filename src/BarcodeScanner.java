import java.util.Random;

public class BarcodeScanner {
    public static int scanProduct() {
        //Scanning product and getting barcode
        //...
        Random random = new Random();
        int scannedBarcode = random.nextInt(15 + 1); //Assign scanned barcode, now it is random
        //...
        return scannedBarcode;
    }
}
