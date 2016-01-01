/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.hybitz.sample.memoapp.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import jp.co.hybitz.sample.memoapp.ejb.MemoFacade;
import jp.co.hybitz.sample.memoapp.entity.Memo;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hiro
 */
@Named(value = "memoBean")
@ViewScoped
public class MemoBean implements Serializable {

    @Getter
    @Setter
    private String memo;

    @Getter
    @Setter
    private List<Memo> memoList;

    @Inject
    private MemoFacade memoFacade;

    @PostConstruct
    public void init() {
        getAllMemo();
    }

    public void createMemo() {
        if (memo.length() > 0) {
            Memo newMemo = new Memo();
            newMemo.setMemo(memo);
            memoFacade.create(newMemo);
            getAllMemo();
        }
    }

    /**
     * 
     * @param editMemo
     * @return 
     */
    public String updateMemo(Memo editMemo){
        Flash flash =FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("editMemoId", editMemo.getId());
        return "memoEdit.xhtml";
    }
    
    /**
     * 
     * @param delMemo 
     */
    public void deleteMemo(Memo delMemo){
        memoFacade.remove(delMemo);
        getAllMemo();
    }
    

    private void getAllMemo() {
        memoList = memoFacade.findAll();
    }

}
