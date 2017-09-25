package org.support.project.web.exception;

/**
 * CallControlLogic で何らかのエラーになった際に、送信するHttpStatusを保持するException
 * @author koda
 */
public class CallControlException extends Exception {
    /** SerialVersion */
    private static final long serialVersionUID = 1L;
    /** Http Status */
    private int httpStatus;
    /**
     * コンストラクタ
     * @param httpStatus Http Status
     */
    public CallControlException(int httpStatus) {
        super();
        this.httpStatus = httpStatus;
    }
    /**
     * @return the httpStatus
     */
    public int getHttpStatus() {
        return httpStatus;
    }
}
