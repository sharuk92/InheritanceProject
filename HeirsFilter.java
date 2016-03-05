
package inheritanceproject;

/**
 *
 * @author yassine
 */
public class HeirsFilter {
    
    Heirs m_heirs;
    
    public HeirsFilter(Heirs heirs) {
        m_heirs = heirs;
    }
    
   
    public void start() {
        filterForPartners();
        filterForParents();
        filterForBranches();
        //ResultGenerator.showResult(m_heirs);
        
        m_heirs.simplifyQuotas();
    }

    private void filterForBranches() {
        Heir son = m_heirs.getHeir("son");
        Heir daugther = m_heirs.getHeir("daugther");
        if(son != null) {
            if(!m_heirs.isThereSomeoneExcept(son)) {
                son.setQuota(new Quota(1, 1));
            }
            else {
                if(daugther != null) {
                    int onth = son.getQuantity() * 2;
                    int halfs= daugther.getQuantity();
                    
                    Quota r = new Quota(Heir.getRemainingQuota().getP(), Heir.getRemainingQuota().getQ());
                    son.setQuota(QuotasOperations.multiplication(r, QuotasOperations.multiplication(new Quota(onth, 1),new Quota(1, onth+halfs))));
                    daugther.setQuota(QuotasOperations.multiplication(r, new Quota(daugther.getQuantity(), onth+halfs)));
                    
                    
                    
                }
            }
        }
    }
    
   
    private void filterForParents() {
        Heir father = m_heirs.getHeir("father");
        Heir mother = m_heirs.getHeir("mother");
        
        if(father != null ){
            if(m_heirs.isThereSomeoneExcept(father)) {
                if(m_heirs.maleBranchExists()) {
                    father.setQuota(new Quota(1, 6));
                    
                    System.out.println(Heir.m_remaining_quota);
                }
                else {
                    
                }
            }
            else {
                father.setQuota(new Quota(1, 1));
            }
        }
        
        if(mother != null) {
            if(!m_heirs.isThereSomeoneExcept(mother)) {
                mother.setQuota(new Quota(1, 1));
            }
            if(m_heirs.branchExists()) {
                mother.setQuota(new Quota(1, 6));   
            }
            else {
                mother.setQuota(new Quota(1, 3));
            }
            
            
        }
        
    }
    
    
    private void filterForPartners() {
        Heir husband = m_heirs.getHeir("husband");
        Heir wife = m_heirs.getHeir("wife");

        if(husband != null) {
            if(m_heirs.branchExists()) {              
                husband.setQuota(new Quota(1, 4));
            }
            else {            
                husband.setQuota(new Quota(1, 2));
            }
        }
        else if (wife != null) {
            if(m_heirs.branchExists()) {
                wife.setQuota(new Quota(1, 8));
                
                
            }
            else {
                wife.setQuota(new Quota(1, 4));
            }
        }
        else {
            
        }
    
    }
    

}
