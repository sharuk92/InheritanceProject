package inheritanceproject.quotas;
/**
 *
 * @author yassine
 */
public class Quota {
    private int m_p;
    private int m_q;
    
    public Quota(int p, int q){
        m_p = p;
        m_q = q;
    }
    public int getQ() {
        return m_q;
    }
    
    public int getP() {
        return m_p;
    }
    public void setP(int p) {
        m_p = p;
    }
    public void setQ(int q) {
        m_q = q;
    }
    
    public void decreaseBy(Quota quota){
        int common_q = m_q * quota.getQ();
        int p = m_p * quota.getQ() - m_q * quota.getP();
        
        this.m_p = p;
        this.m_q = common_q;
    }
    private int findPGCD(int p, int q) {
        if(p % q == 0) {
            return q;
        }
        else 
            return findPGCD(q, p%q);
    }
    public void simplifiy() {
        int c = findPGCD(m_p, m_q);
        if(c != 1) {
            m_p /= c;
            m_q /= c;
        }
    }
    @Override
    public String toString() {
        String str;
        if(m_p == m_q)
            str = String.valueOf(m_p);
        
        else if(m_p == 0)
            str = String.valueOf(0);
        else
            str = String.valueOf(m_p) + "/" + String.valueOf(m_q);
        
        return str;
    }
}
