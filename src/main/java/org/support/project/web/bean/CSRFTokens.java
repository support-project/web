package org.support.project.web.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import org.support.project.common.serialize.Serialize;
import org.support.project.common.serialize.SerializerValue;

@Serialize(value = SerializerValue.Serializable)
public class CSRFTokens implements Serializable {
    /**
     * シリアルバージョン
     */
    private static final long serialVersionUID = 1L;
    
    private List<CSRFToken> tokens = new ArrayList<>();
    
    /**
     * 指定のキーに対するTokenを発行する
     * @param token
     * @throws NoSuchAlgorithmException 
     */
    public String addToken(String key) throws NoSuchAlgorithmException {
        if (tokens.size() > 5) {
            tokens.remove(0);
        }
        CSRFToken token = CSRFToken.create(key);
        tokens.add(token);
        return token.getToken();
    }
    
    /**
     * トークンが正しい値かチェックする
     * @param key
     * @param reqTokens
     * @return
     */
    public boolean checkToken(String key, CSRFTokens reqTokens) {
        for (CSRFToken csrfToken : tokens) {
            if (csrfToken.getKey().equals(key)) {
                for (CSRFToken reqToken : reqTokens.tokens) {
                    if (reqToken.getKey().equals(key) && csrfToken.getToken().equals(reqToken.getToken())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}
