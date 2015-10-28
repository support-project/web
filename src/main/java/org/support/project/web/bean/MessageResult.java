package org.support.project.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * クライアントに返すメッセージのオブジェクト
 * @author koda
 *
 */
public class MessageResult implements Serializable {
	
	/**
	 * ステータス(org.support.project.web.config.MessageStatus)
	 */
	private Integer status = 0;
	/**
	 * コード(HttpStatus)
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
	
	/**
	 * 結果の中に、子のメッセージを持ちたい場合にセット
	 */
	private List<MessageResult> children = new ArrayList<MessageResult>();
	
	
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
	/**
	 * @return the children
	 */
	public List<MessageResult> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<MessageResult> children) {
		this.children = children;
	}
	
	
}
