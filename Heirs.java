package inheritanceproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yassine
 */
public class Heirs {
    
    ArrayList<Heir> m_heirs;
    Map<String, Boolean> m_heirs_inherits_rest;
    
    public Heirs() {
        m_heirs = new ArrayList<>();
        m_heirs_inherits_rest = new HashMap<>();
        m_heirs_inherits_rest.put("father", false);
        m_heirs_inherits_rest.put("mother", false);
        m_heirs_inherits_rest.put("son", false);
        m_heirs_inherits_rest.put("daugther", false);

    }
    
    public void simplifyQuotas() {
        m_heirs.stream().forEach((heir) -> {
            heir.getQuota().simplifiy();
        }); 
    }
    public boolean isThereSomeoneExcept(Heir heir) {
        
        return m_heirs.stream().anyMatch((h) -> (h != heir && h != null)); 
    }
    public Heir getHeir(int index) {
        return m_heirs.get(index);
    }
    public int getSize() {
        return m_heirs.size();
    }
    public void addHeir(String degree, int quantity) {
        
        m_heirs.add(new Heir(degree, quantity));
    }
    
    public Heir getHeir(String degree) {
        
        for(Heir heir : m_heirs) {
            if(heir.getDegree().equalsIgnoreCase(degree)){
                return heir;
            }
        }
        return null ;
    }
    public void resetRemainingQuota() {
        Heir.resetRemainingQuota();
    }
    public boolean maleBranchExists() {
        for(Heir heir : m_heirs) {
            if(heir.getDegree().equalsIgnoreCase("son"))
                return true;
        }
        return false;
    }
    public boolean branchExists() {
        for(Heir heir : m_heirs) {
            if(heir.getDegree().equalsIgnoreCase("son") || heir.getDegree().equalsIgnoreCase("daughter")) {
                return true;
            }
        }
        return false;
    }
    
    public void clear() {
        m_heirs.clear();
    }
}