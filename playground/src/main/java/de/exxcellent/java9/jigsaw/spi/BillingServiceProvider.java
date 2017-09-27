package de.exxcellent.java9.jigsaw.spi;

import de.exxcellent.java9.jigsaw.BillingService;

public interface BillingServiceProvider {

    BillingService buildBillingService();
}