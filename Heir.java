package inheritanceproject;

/**
 *
 * @author yassine
 */
public class Heir {
    
    protected String m_degree;
   // protected double m_quota;
    protected Quota m_quota;
    protected int m_quantity;
    
    protected static Quota m_remaining_quota = new Quota(1, 1);
    
    public Heir(String degree, int quantity) {
        m_degree = degree;
        m_quantity = quantity;
    }
    
    public void setQuota(Quota quota) {
        m_quota = quota;
        m_remaining_quota.decreaseBy(m_quota);
    }
    
    public int getQuantity() {
        return m_quantity;
    }
    
    public String getDegree() {
        return m_degree;
    }
    
    public Quota getQuota() {
        return m_quota;
    }
    public boolean exists() {
         return m_quantity != 0;
    }
    
    public static void resetRemainingQuota() {
        m_remaining_quota = new Quota(1, 1);
    }
    
    public static Quota getRemainingQuota() {
        return m_remaining_quota;
    }
}
