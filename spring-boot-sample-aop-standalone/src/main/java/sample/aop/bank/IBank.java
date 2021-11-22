package sample.aop.bank;

public interface IBank {
    /**
     * Transfert money from an account to another
     * @param amount the amount to be transferred
     * @param emitterId the id of the source account
     * @param receiverId the id of the receiver account
     */
    void transfert(double amount, int emitterId, int receiverId);
}
