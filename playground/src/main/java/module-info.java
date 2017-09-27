module de.exxcellent.java9 {
    exports de.exxcellent.java9.collections;

    // Depend on an offficial JDK modules
    requires jdk.incubator.httpclient;

    // Service example  (SPI with Jigsaw modules)
    exports de.exxcellent.java9.jigsaw;
    exports de.exxcellent.java9.jigsaw.spi;
    uses de.exxcellent.java9.jigsaw.spi.BillingServiceProvider;
}