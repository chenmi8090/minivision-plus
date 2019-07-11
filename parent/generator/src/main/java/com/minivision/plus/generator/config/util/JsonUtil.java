/**************************************************************************************** 
 南京小视科技有限公司
 ****************************************************************************************/
package com.minivision.plus.generator.config.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.minivision.common.framework.web.constant.ParamConst;

import java.util.Date;
import java.util.List;

/**
 * <Description> json工具类<br>
 *
 * @author quss<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年11月16日 <br>
 */

public class JsonUtil {

    /**
     * DATEFORMAT yyyy-MM-dd HH:mm:ss
     */
    private static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * mapping
     */
    private static SerializeConfig mapping = new SerializeConfig();

    //过滤掉class字段
    private static PropertyFilter propertyFilter = (Object object, String name, Object value) -> {
        if ("class".equalsIgnoreCase(name)) {
            return false;
        }
        return true;
    };

    /**
     * 静态构造
     */
    static {

        mapping.put(Date.class, new SimpleDateFormatSerializer(DATEFORMAT));
    }

    /**
     * Description: 获取带对象正确的json字符串，并处理日期格式默认yyyy-MM-dd HH:mm:ss<br>
     *
     * @param obj obj
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getSucc4Date(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), mapping, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取带对象正确的json字符串，自定义配置格式<br>
     *
     * @param obj        对象
     * @param jsonConfig 定义格式
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, SerializeConfig jsonConfig) {

        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), jsonConfig, propertyFilter, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * s Description: 获取带有对象的正确结果的json字符串<br>
     *
     * @param obj obj
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getSucc(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), propertyFilter,SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取带有对象的正确结果的json字符串<br>
     *
     * @param obj obj
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getSucc4data(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_SUCC, obj), propertyFilter, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 返回正确信息，有正确码<br>
     *
     * @param obj         返回信息
     * @param messageCode 编码
     * @return <br>
     * @author qss<br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, String messageCode) {
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode), obj), propertyFilter,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 返回正确信息，有正确码,带占位符信息<br>
     *
     * @param obj         返回信息
     * @param messageCode 编码
     * @param msg         msg
     * @return <br>
     * @author qss<br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, String messageCode, Object... msg) {
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode, msg), obj),propertyFilter,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 有正确码,返回信息<br>
     *
     * @param messageCode 编码
     * @return <br>
     * @author qss<br>
     * @taskId <br>
     */
    public static String getSucc(String messageCode) {
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode)),propertyFilter,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 有正确码,带占位符信息<br>
     *
     * @param messageCode 编码
     * @param msg         msg
     * @return <br>
     * @author qss<br>
     * @taskId <br>
     */
    public static String getSucc(String messageCode, Object... msg) {
        return JSONObject.toJSONString(new ResultInfo<Object>(ParamConst.RESULT_SUCC, new RtnMessage(messageCode, msg)),propertyFilter,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取自定义fileter和features特性<br>
     *
     * @param obj      obj
     * @param filter   fileter
     * @param features features
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, SerializeFilter filter, SerializerFeature... features) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                ParamConst.RESULT_SUCC, obj), filter, features);
    }

    /**
     * Description: 获取自定义features特性<br>
     *
     * @param obj      obj
     * @param features features
     * @return <br>
     * @author xubin<br>
     * @taskId <br>
     */
    public static String getSucc(Object obj, SerializerFeature... features) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                ParamConst.RESULT_SUCC, obj), propertyFilter,features);
    }

    /**
     * Description: 根据错误编码构造一条表示错误信息的json字符串<br>
     *
     * @param errorCode <br>
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getErrorJson(String errorCode) {

        return JSONObject.toJSONString(new ResultInfo<Object>(
                ParamConst.RESULT_ERROR, new RtnMessage(errorCode)),
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 根据错误编码构造一条表示错误信息的json字符串 输出带有占位符<br>
     *
     * @param errorCode <br>
     * @param obj       消息占位符 <br>
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getErrorJsonWithObj(String errorCode, Object... obj) {

        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, new RtnMessage(errorCode, obj)), SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 根据错误编码构造一条表示错误信息的json字符串<br>
     *
     * @param errorCode <br>
     * @param errorMsg  <br>
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getErrorJson(String errorCode, String errorMsg) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, new RtnMessage(errorCode, errorMsg)), SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 多个错误信息的json字符串<br>
     *
     * @param rtnMsgs 多个错误消息
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getErrorJson(List<RtnMessage> rtnMsgs) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, rtnMsgs), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取带有对象的错误信息json字符串<br>
     *
     * @param obj obj
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static String getErrorJson4data(Object obj) {
        return JSONObject.toJSONString(new ResultInfo<Object>(
                        ParamConst.RESULT_ERROR, obj), SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty);
    }

    /**
     * Description: 获取json字符串成功标志码<br>
     *
     * @param jsonStr json字符串
     * @return true表示成功<br>
     * @author quss<br>
     * @taskId <br>
     */
    public static boolean isSucc(String jsonStr) {
        JSONObject json = JSON.parseObject(jsonStr);
        return isSucc(json);
    }

    /**
     * Description: 获取json字符串成功标志码<br>
     *
     * @param json <br>
     * @return true表示成功<br>
     * @author quss<br>
     * @taskId <br>
     */
    public static boolean isSucc(JSONObject json) {
        return ParamConst.RESULT_SUCC == json.getInteger(ParamConst.RES_CODE);
    }

    /**
     * Description: 合并多个jsonobject<br>
     *
     * @param jsons jsonObject
     * @return <br>
     * @author quss<br>
     * @taskId <br>
     */
    public static JSONObject megerJson(JSONObject... jsons) {
        if (null == jsons) {
            return null;
        }
        JSONObject resultJson = new JSONObject();

        for (JSONObject json : jsons) {
            if (null != json) {
                resultJson.putAll(json);
            }
        }

        return resultJson;
    }

}
