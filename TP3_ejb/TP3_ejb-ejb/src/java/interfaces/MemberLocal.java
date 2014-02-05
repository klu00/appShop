/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import domain.Member1;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Lucas
 */
@Local
public interface MemberLocal {
    public void addMember(Member1 member);
    public void deleteMember(Member1 member);
    public List<Member1> findAllMember();
    public Member1 findMemberById(Integer id);
    public void updateMember(Member1 member);
}
