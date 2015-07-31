package org.support.project.web.bean;

import java.io.Serializable;


/**
 * クライアントに返すメッセージのオブジェクト
 * @author koda
 *
 */
public class MessageResult implements Serializable {
	
	/**
	 * ステータス
	 */
	private Integer status = 0;
	/**
	 * コード
	 */
	private Integer code = 0;
	/**
	 * メッセージ
	 */
	private String message;
	
	/**
	 * 結果(何か返す値があれば)
	 */
	private String result;
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
}
