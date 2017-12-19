package org.support.project.web.logic;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.support.project.di.DI;
import org.support.project.di.Instance;
import org.support.project.web.common.InvokeTarget;
import org.support.project.web.exception.CallControlException;
import org.support.project.web.exception.InvalidParamException;

import net.arnx.jsonic.JSONException;

@DI(instance = Instance.Singleton)
public interface CallControlLogic {

    /**
     * 初期化
     * @param controlPackage コントローラーのパッケージ名称（カンマ区切り）
     * @param classSuffix クラスのサフィックス(デフォルト「Control」)
     * @param searchSubpackages コントローラーの検索をサブパッケージにも適用するか
     * @param ignoreRegularExpression このフィルタで処理しないものの正規表現
     */
    void init(String controlPackage, String classSuffix, boolean searchSubpackages, String ignoreRegularExpression);

    /**
     * パスで取得されるControlクラスを呼び出す
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @throws CallControlException CallControlException
     * @throws InvalidParamException 
     * @throws IOException 
     * @throws JSONException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchAlgorithmException 
     */
    InvokeTarget searchInvokeTarget(HttpServletRequest request, HttpServletResponse response) throws CallControlException, InstantiationException,
            IllegalAccessException, JSONException, IOException, InvalidParamException, NoSuchAlgorithmException;

}