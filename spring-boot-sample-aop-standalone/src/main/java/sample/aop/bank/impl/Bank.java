package sample.aop.bank.impl;

import org.springframework.stereotype.Component;
import sample.aop.bank.IBank;

import java.util.logging.Logger;

@Component
public class Bank implements IBank {
    /**
     * {@inheritDoc}
     * Logs the transfert into Global logger
     */
    @Override
    public void transfert(double amount, int emitterId, int receiverId) {
        Logger.getGlobal().info(String.format("[Bank] Tranfered %f from %d to %d", amount, emitterId, receiverId));
    }
}
