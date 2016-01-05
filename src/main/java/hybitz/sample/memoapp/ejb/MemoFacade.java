/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hybitz.sample.memoapp.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import hybitz.sample.memoapp.entity.Memo;

/**
 *
 * @author hiro
 */
@Stateless
public class MemoFacade extends AbstractFacade<Memo> {

    @PersistenceContext(unitName = "jp.co.hybitz.sample_MemoApp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MemoFacade() {
        super(Memo.class);
    }
    
}
