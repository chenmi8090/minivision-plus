/**************************************************************************************** 
           南京小视科技有限公司           
 ****************************************************************************************/
package com.minivision.plus.generator.config.util;

import com.alibaba.fastjson.annotation.JSONField;
import com.minivision.spring.framework.util.ResourceUtil;

/**
 * <Description> 错误信息封装<br>
 * 
 * @author quss<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年11月23日 <br>
 */
public class RtnMessage {

    /**
     * 返回消息
     */
    @JSONField
    private String msgText;

    /**
     * 返回结果
     */
    @JSONField
    private String msgCode;

    /**
     * Description: 构造
     * 
     * @param msgCode <br>
     */
    public RtnMessage(String msgCode) {
        super();
        this.msgCode = msgCode;
        this.msgText = ResourceUtil.getMessage(msgCode);
    }

    /**
     * Description: 构造
     * 
     * @param msgCode <br>
     * @param msgText <br>
     */
    public RtnMessage(String msgCode, String msgText) {
        super();
        this.msgCode = msgCode;
        this.msgText = msgText;
    }

    /**
     * Description: 构造 带有占位符
     * 
     * @param msgCode <br>
     * @param obj 消息占位符
     */
    public RtnMessage(String msgCode, Object... obj) {
        super();
        this.msgCode = msgCode;
        this.msgText = ResourceUtil.getMessage(msgCode, obj);
    }

    /**
     * get msgText
     * 
     * @return Returns the msgText.<br>
     */
    public String getMsgText() {
        return msgText;
    }

    /**
     * set msgText
     * 
     * @param msgText The msgText to set. <br>
     */
    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    /**
     * get msgCode
     * 
     * @return Returns the msgCode.<br>
     */
    public String getMsgCode() {
        return msgCode;
    }

    /**
     * set msgCode
     * 
     * @param msgCode The msgCode to set. <br>
     */
    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

}
