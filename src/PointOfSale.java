public class PointOfSale {
    private static int CODE_EMPTY = 0;
    private static int CODE_EXIT = -1;

    public static void main(String[] args) {
        newClient(); //Sample client
    }

    private static void newClient() {
        Receipt currentReceipt = new Receipt();

        //Assume client is getting 19 products (last iteration is CODE_EXIT)
        for(int i = 0; i < 20; i++) {

            int scannedCode = BarcodeScanner.scanProduct();

            if(i == 19) {
                scannedCode = CODE_EXIT;
            }

            if (isExitCalled(scannedCode)) {
                Printer.printReceipt(currentReceipt);
                double totalSum = currentReceipt.getTotalSum();
                LCDDisplay.printOnDisplay("Total sum: " + totalSum);

            } else if (isScannedBarCodeEmpty(scannedCode)) {
                onScannedBarcodeEmpty();

            } else {
                onScannedBarcodeValid(scannedCode, currentReceipt);
            }
        }
    }

    private static boolean isExitCalled(int scannedCode) {
        return scannedCode == -1;
    }

    private static boolean isScannedBarCodeEmpty(int scannedBarcode) {
        return scannedBarcode == CODE_EMPTY;
    }

    private static void onScannedBarcodeEmpty() {
        LCDDisplay.printOnDisplay("Invalid bar-code");
    }

    private static void onScannedBarcodeValid(int scannedBarcode, Receipt currentReceipt) {

        Product scannedProduct = Database.findProduct(scannedBarcode);

        if (isProductFound(scannedProduct)) {
            String name = scannedProduct.getProductName();
            double price = scannedProduct.getProductPrice();
            currentReceipt.addProductToReceipt(scannedProduct);
            LCDDisplay.printOnDisplay(name + " " + price);

        } else {
            LCDDisplay.printOnDisplay("Product not found");
        }
    }

    private static boolean isProductFound(Product scannedProduct) {
        return scannedProduct != null;
    }
}
