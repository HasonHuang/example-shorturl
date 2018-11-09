package com.hason.shorturl.client;

import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hason.shorturl.util.JsonMapper;
import com.hason.shorturl.AbstractHttpMultiUrlConverter;
import com.hason.shorturl.UrlConvertException;
import com.hason.shorturl.output.SinaShortUrl;
import com.hason.shorturl.util.StringBuilderHolder;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 使用新浪 API 实现短网址服务
 * <p>
 * source 是指 APP Key，建议使用 setter 做成可配置。
 *
 * 注：新浪 API 每次请求参数数量限制为 20 个。
 *
 * @author Huanghs
 * @since 1.0
 * @date 2018/6/14
 */
public class SinaHttpUrlConverter extends AbstractHttpMultiUrlConverter {

    /** APP Key */
    private static String source = "3271760578";

    private static final String SHORTEN_API = "http://api.t.sina.com.cn/short_url/shorten.json?source=" + source;
    private static final String SHORTEN_PARAM_NAME = "url_long";
    private static final String LENGTHEN_API = "http://api.t.sina.com.cn/short_url/expand.json?source=" + source;
    private static final String LENGTHEN_PARAM_NAME = "url_short";

    private static final char SYMBOL_EQ = '=';
    private static final char PARAM_AT = '&';

    /** 最大允许的参数数量（包含该值） */
    private static final int MAX_PARAM = 20;

    private static JavaType resultType = JsonMapper.INSTANCE.buildCollectionType(List.class, SinaShortUrl.class);

    @Override
    public Map<String, String> shorten(Collection<String> longUrls) {
        check(longUrls);
        Map<String, String> result = Maps.newHashMapWithExpectedSize(longUrls.size());
        // 分割参数列表为合适的大小
        List<List<String>> suitableList = suitableList(longUrls);
        for (List<String> urls : suitableList) {
            // 合并结果集
            result.putAll(super.shorten(urls));
        }
        return result;
    }

    @Override
    public Map<String, String> lengthen(Collection<String> shortUrls) {
        check(shortUrls);
        Map<String, String> result = Maps.newHashMapWithExpectedSize(shortUrls.size());
        // 分割参数列表为合适的大小
        List<List<String>> suitableList = suitableList(shortUrls);
        for (List<String> urls : suitableList) {
            // 合并结果集
            result.putAll(super.lengthen(urls));
        }
        return result;
    }

    @Override
    protected String getShortenUri(Collection<String> longUrls) {
        return appendApiParams(SHORTEN_API, SHORTEN_PARAM_NAME, longUrls);
    }

    @Override
    protected String getLengthenUri(Collection<String> shortUrls) {
        return appendApiParams(LENGTHEN_API, LENGTHEN_PARAM_NAME, shortUrls);
    }

    @Override
    protected Map<String, String> handleShorten(String result) {
        if (isError(result)) {
            throw new UrlConvertException(result);
        }
        List<SinaShortUrl> resultList = JsonMapper.INSTANCE.fromJson(result, resultType);
        Map<String, String> urlMap = Maps.newLinkedHashMapWithExpectedSize(resultList.size());
        for (SinaShortUrl url : resultList) {
            urlMap.put(url.getUrl_long(), url.getUrl_short());
        }
        return urlMap;
    }

    @Override
    protected Map<String, String> handleLengthen(String result) {
        if (isError(result)) {
            throw new UrlConvertException(result);
        }
        List<SinaShortUrl> resultList = JsonMapper.INSTANCE.fromJson(result, resultType);
        Map<String, String> urlMap = Maps.newLinkedHashMapWithExpectedSize(resultList.size());
        for (SinaShortUrl url : resultList) {
            urlMap.put(url.getUrl_short(), url.getUrl_long());
        }
        return urlMap;
    }

    /**
     * 把参数集合大小进行合适化大小
     *
     * @param urls 参数集合
     * @return list
     */
    private static List<List<String>> suitableList(Collection<String> urls) {
        List<String> argumentUrls = Lists.newArrayList(urls);
        List<List<String>> resultList = new ArrayList<>((int) Math.ceil(urls.size() / ((double) PARAM_AT)));

        int index = 0;
        int argumentSize = argumentUrls.size();
        while (index < argumentSize) {
            // 计算子列表高端
            int toIndex = index + MAX_PARAM;
            toIndex = toIndex > argumentSize ? argumentSize : toIndex;
            resultList.add(argumentUrls.subList(index, toIndex));
            index = toIndex;
        }

        return resultList;
    }

    /**
     * 判断请求服务是否成功
     */
    private boolean isError(String result) {
        return result.startsWith("{");
    }

    /**
     * 判断参数是否合法
     */
    private void check(Collection<String> urls) throws IllegalArgumentException {
        Validate.isTrue(urls != null && !urls.isEmpty(), "参数不能为空");
    }

    /**
     * 为 API 添加请求参数
     *
     * @param api api uri
     * @param paramName 参数名
     * @param urls 参数值
     * @return string
     */
    private String appendApiParams(String api, String paramName, Collection<String> urls) {
//        check(urls);
        StringBuilder builder = StringBuilderHolder.getGlobal();
        builder.append(api).append(PARAM_AT);
        appendApiQueryParams(builder, paramName, urls);
        return builder.toString();
    }

    /**
     * 拼接请求参数
     *
     * @param builder 字符串拼接器
     * @param paramName 参数名
     * @param urls 参数值
     * @return string
     */
    private void appendApiQueryParams(StringBuilder builder, String paramName, Collection<String> urls) {
        for (String url : urls) {
            builder.append(paramName)
                    .append(SYMBOL_EQ)
                    .append(url)
                    .append(PARAM_AT);
        }
        if (builder.charAt(builder.length() - 1) == PARAM_AT) {
            builder.setLength(builder.length() - 1);
        }
    }

}
