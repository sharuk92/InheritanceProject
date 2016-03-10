/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritanceproject.quotas;

/**
 *
 * @author yassine
 */
public class QuotasOperations {
    
    public static Quota addition(Quota a, Quota b) {
        int common_q = a.getQ() * b.getQ();
        int p = a.getP() * b.getQ() + a.getQ() * b.getP();
        
        return new Quota(p, common_q);
    }
    
    public static Quota substraction(Quota a, Quota b) {
        int common_q = a.getQ() * b.getQ();
        int p = a.getP() * b.getQ() - a.getQ() * b.getP();
        
        return new Quota(p, common_q);
    }
    
    
    public static Quota multiplication(Quota a, Quota b) {
        int p = a.getP() * b.getP();
        int q = a.getQ() * b.getQ();
        
        return new Quota(p, q);
    }
}
