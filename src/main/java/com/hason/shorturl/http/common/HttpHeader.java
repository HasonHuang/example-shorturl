package com.hason.shorturl.http.common;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.HashMap;
import java.util.Map;

/**
 * HTTP Request header 创造者
 *
 * @date 2018/6/14
 */
public class HttpHeader {

    private HttpHeader() {
    }

    ;

    public static HttpHeader custom() {
        return new HttpHeader();
    }

    //记录head头信息
    private Map<String, Header> headerMaps = new HashMap<String, Header>();

    /**
     * 自定义header头信息
     *
     * @param key    header-key
     * @param value    header-value
     * @return 返回当前对象
     */
    public HttpHeader other(String key, String value) {
        headerMaps.put(key, new BasicHeader(key, value));
        return this;
    }

    /**
     * 指定客户端能够接收的内容类型
     * 例如：Accept: text/plain, text/html
     *
     * @param accept accept
     * @return 返回当前对象
     */
    public HttpHeader accept(String accept) {
        headerMaps.put(HttpHeaders.ACCEPT,
                new BasicHeader(HttpHeaders.ACCEPT, accept));
        return this;
    }

    /**
     * 浏览器可以接受的字符编码集
     * 例如：Accept-Charset: iso-8859-5
     *
     * @param acceptCharset accept-charset
     * @return 返回当前对象
     */
    public HttpHeader acceptCharset(String acceptCharset) {
        headerMaps.put(HttpHeaders.ACCEPT_CHARSET,
                new BasicHeader(HttpHeaders.ACCEPT_CHARSET, acceptCharset));
        return this;
    }

    /**
     * 指定浏览器可以支持的web服务器返回内容压缩编码类型
     * 例如：Accept-Encoding: compress, gzip
     *
     * @param acceptEncoding accept-encoding
     * @return 返回当前对象
     */
    public HttpHeader acceptEncoding(String acceptEncoding) {
        headerMaps.put(HttpHeaders.ACCEPT_ENCODING,
                new BasicHeader(HttpHeaders.ACCEPT_ENCODING, acceptEncoding));
        return this;
    }

    /**
     * 浏览器可接受的语言
     * 例如：Accept-Language: en,zh
     *
     * @param acceptLanguage accept-language
     * @return 返回当前对象
     */
    public HttpHeader acceptLanguage(String acceptLanguage) {
        headerMaps.put(HttpHeaders.ACCEPT_LANGUAGE,
                new BasicHeader(HttpHeaders.ACCEPT_LANGUAGE, acceptLanguage));
        return this;
    }

    /**
     * 可以请求网页实体的一个或者多个子范围字段
     * 例如：Accept-Ranges: bytes
     *
     * @param acceptRanges accept-ranges
     * @return 返回当前对象
     */
    public HttpHeader acceptRanges(String acceptRanges) {
        headerMaps.put(HttpHeaders.ACCEPT_RANGES,
                new BasicHeader(HttpHeaders.ACCEPT_RANGES, acceptRanges));
        return this;
    }

    /**
     * HTTP授权的授权证书
     * 例如：Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
     *
     * @param authorization authorization
     * @return 返回当前对象
     */
    public HttpHeader authorization(String authorization) {
        headerMaps.put(HttpHeaders.AUTHORIZATION,
                new BasicHeader(HttpHeaders.AUTHORIZATION, authorization));
        return this;
    }

    /**
     * 指定请求和响应遵循的缓存机制
     * 例如：Cache-Control: no-cache
     *
     * @param cacheControl cache-control
     * @return 返回当前对象
     */
    public HttpHeader cacheControl(String cacheControl) {
        headerMaps.put(HttpHeaders.CACHE_CONTROL,
                new BasicHeader(HttpHeaders.CACHE_CONTROL, cacheControl));
        return this;
    }

    /**
     * 表示是否需要持久连接（HTTP 1.1默认进行持久连接）
     * 例如：Connection: close 短链接； Connection: keep-alive 长连接
     *
     * @param connection connection
     * @return 返回当前对象
     */
    public HttpHeader connection(String connection) {
        headerMaps.put(HttpHeaders.CONNECTION,
                new BasicHeader(HttpHeaders.CONNECTION, connection));
        return this;
    }

    /**
     * HTTP请求发送时，会把保存在该请求域名下的所有cookie值一起发送给web服务器
     * 例如：Cookie: $Version=1; Skin=new;
     *
     * @param cookie cookie
     * @return 返回当前对象
     */
    public HttpHeader cookie(String cookie) {
        headerMaps.put(HttpHeaders.COOKIE,
                new BasicHeader(HttpHeaders.COOKIE, cookie));
        return this;
    }

    /**
     * 请求内容长度
     * 例如：Content-Length: 348
     *
     * @param contentLength content-length
     * @return 返回当前对象
     */
    public HttpHeader contentLength(String contentLength) {
        headerMaps.put(HttpHeaders.CONTENT_LENGTH,
                new BasicHeader(HttpHeaders.CONTENT_LENGTH, contentLength));
        return this;
    }

    /**
     * 请求的与实体对应的MIME信息
     * 例如：Content-Type: application/x-www-form-urlencoded
     *
     * @param contentType content-type
     * @return 返回当前对象
     */
    public HttpHeader contentType(String contentType) {
        headerMaps.put(HttpHeaders.CONTENT_TYPE,
                new BasicHeader(HttpHeaders.CONTENT_TYPE, contentType));
        return this;
    }

    /**
     * 请求发送的日期和时间
     * 例如：Date: Tue, 15 Nov 2010 08:12:31 GMT
     *
     * @param date    date
     * @return 返回当前对象
     */
    public HttpHeader date(String date) {
        headerMaps.put(HttpHeaders.DATE,
                new BasicHeader(HttpHeaders.DATE, date));
        return this;
    }

    /**
     * 请求的特定的服务器行为
     * 例如：Expect: 100-continue
     *
     * @param expect expect
     * @return 返回当前对象
     */
    public HttpHeader expect(String expect) {
        headerMaps.put(HttpHeaders.EXPECT,
                new BasicHeader(HttpHeaders.EXPECT, expect));
        return this;
    }

    /**
     * 发出请求的用户的Email
     * 例如：From: user@email.com
     *
     * @param from from
     * @return 返回当前对象
     */
    public HttpHeader from(String from) {
        headerMaps.put(HttpHeaders.FROM,
                new BasicHeader(HttpHeaders.FROM, from));
        return this;
    }

    /**
     * 指定请求的服务器的域名和端口号
     * 例如：Host: blog.csdn.net
     *
     * @param host host
     * @return 返回当前对象
     */
    public HttpHeader host(String host) {
        headerMaps.put(HttpHeaders.HOST,
                new BasicHeader(HttpHeaders.HOST, host));
        return this;
    }

    /**
     * 只有请求内容与实体相匹配才有效
     * 例如：If-Match: “737060cd8c284d8af7ad3082f209582d”
     *
     * @param ifMatch if-match
     * @return 返回当前对象
     */
    public HttpHeader ifMatch(String ifMatch) {
        headerMaps.put(HttpHeaders.IF_MATCH,
                new BasicHeader(HttpHeaders.IF_MATCH, ifMatch));
        return this;
    }

    /**
     * 如果请求的部分在指定时间之后被修改则请求成功，未被修改则返回304代码
     * 例如：If-Modified-Since: Sat, 29 Oct 2010 19:43:31 GMT
     *
     * @param ifModifiedSince if-modified-Since
     * @return 返回当前对象
     */
    public HttpHeader ifModifiedSince(String ifModifiedSince) {
        headerMaps.put(HttpHeaders.IF_MODIFIED_SINCE,
                new BasicHeader(HttpHeaders.IF_MODIFIED_SINCE, ifModifiedSince));
        return this;
    }

    /**
     * 如果内容未改变返回304代码，参数为服务器先前发送的Etag，与服务器回应的Etag比较判断是否改变
     * 例如：If-None-Match: “737060cd8c284d8af7ad3082f209582d”
     *
     * @param ifNoneMatch if-none-match
     * @return 返回当前对象
     */
    public HttpHeader ifNoneMatch(String ifNoneMatch) {
        headerMaps.put(HttpHeaders.IF_NONE_MATCH,
                new BasicHeader(HttpHeaders.IF_NONE_MATCH, ifNoneMatch));
        return this;
    }

    /**
     * 如果实体未改变，服务器发送客户端丢失的部分，否则发送整个实体。参数也为Etag
     * 例如：If-Range: “737060cd8c284d8af7ad3082f209582d”
     *
     * @param ifRange if-range
     * @return 返回当前对象
     */
    public HttpHeader ifRange(String ifRange) {
        headerMaps.put(HttpHeaders.IF_RANGE,
                new BasicHeader(HttpHeaders.IF_RANGE, ifRange));
        return this;
    }

    /**
     * 只在实体在指定时间之后未被修改才请求成功
     * 例如：If-Unmodified-Since: Sat, 29 Oct 2010 19:43:31 GMT
     *
     * @param ifUnmodifiedSince if-unmodified-since
     * @return 返回当前对象
     */
    public HttpHeader ifUnmodifiedSince(String ifUnmodifiedSince) {
        headerMaps.put(HttpHeaders.IF_UNMODIFIED_SINCE,
                new BasicHeader(HttpHeaders.IF_UNMODIFIED_SINCE, ifUnmodifiedSince));
        return this;
    }

    /**
     * 限制信息通过代理和网关传送的时间
     * 例如：Max-Forwards: 10
     *
     * @param maxForwards max-forwards
     * @return 返回当前对象
     */
    public HttpHeader maxForwards(String maxForwards) {
        headerMaps.put(HttpHeaders.MAX_FORWARDS,
                new BasicHeader(HttpHeaders.MAX_FORWARDS, maxForwards));
        return this;
    }

    /**
     * 用来包含实现特定的指令
     * 例如：Pragma: no-cache
     *
     * @param pragma pragma
     * @return 返回当前对象
     */
    public HttpHeader pragma(String pragma) {
        headerMaps.put(HttpHeaders.PRAGMA,
                new BasicHeader(HttpHeaders.PRAGMA, pragma));
        return this;
    }

    /**
     * 连接到代理的授权证书
     * 例如：Proxy-Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
     *
     * @param proxyAuthorization proxy-authorization
     * @return 返回当前对象
     */
    public HttpHeader proxyAuthorization(String proxyAuthorization) {
        headerMaps.put(HttpHeaders.PROXY_AUTHORIZATION,
                new BasicHeader(HttpHeaders.PROXY_AUTHORIZATION, proxyAuthorization));
        return this;
    }

    /**
     * 只请求实体的一部分，指定范围
     * 例如：Range: bytes=500-999
     *
     * @param range range
     * @return 返回当前对象
     */
    public HttpHeader range(String range) {
        headerMaps.put(HttpHeaders.RANGE,
                new BasicHeader(HttpHeaders.RANGE, range));
        return this;
    }

    /**
     * 先前网页的地址，当前请求网页紧随其后,即来路
     * 例如：Referer: http://www.zcmhi.com/archives/71.html
     *
     * @param referer referer
     * @return 返回当前对象
     */
    public HttpHeader referer(String referer) {
        headerMaps.put(HttpHeaders.REFERER,
                new BasicHeader(HttpHeaders.REFERER, referer));
        return this;
    }

    /**
     * 客户端愿意接受的传输编码，并通知服务器接受接受尾加头信息
     * 例如：TE: trailers,deflate;q=0.5
     *
     * @param te te
     * @return 返回当前对象
     */
    public HttpHeader te(String te) {
        headerMaps.put(HttpHeaders.TE,
                new BasicHeader(HttpHeaders.TE, te));
        return this;
    }

    /**
     * 向服务器指定某种传输协议以便服务器进行转换（如果支持）
     * 例如：Upgrade: HTTP/2.0, SHTTP/1.3, IRC/6.9, RTA/x11
     *
     * @param upgrade upgrade
     * @return 返回当前对象
     */
    public HttpHeader upgrade(String upgrade) {
        headerMaps.put(HttpHeaders.UPGRADE,
                new BasicHeader(HttpHeaders.UPGRADE, upgrade));
        return this;
    }

    /**
     * User-Agent的内容包含发出请求的用户信息
     *
     * @param userAgent user-agent
     * @return 返回当前对象
     */
    public HttpHeader userAgent(String userAgent) {
        headerMaps.put(HttpHeaders.USER_AGENT,
                new BasicHeader(HttpHeaders.USER_AGENT, userAgent));
        return this;
    }

    /**
     * 关于消息实体的警告信息
     * 例如：Warn: 199 Miscellaneous warning
     *
     * @param warning warning
     * @return 返回当前对象
     */
    public HttpHeader warning(String warning) {
        headerMaps.put(HttpHeaders.WARNING,
                new BasicHeader(HttpHeaders.WARNING, warning));
        return this;
    }

    /**
     * 通知中间网关或代理服务器地址，通信协议
     * 例如：Via: 1.0 fred, 1.1 nowhere.com (Apache/1.1)
     *
     * @param via via
     * @return 返回当前对象
     */
    public HttpHeader via(String via) {
        headerMaps.put(HttpHeaders.VIA,
                new BasicHeader(HttpHeaders.VIA, via));
        return this;
    }

    /**
     * 设置此HTTP连接的持续时间（超时时间）
     * 例如：Keep-Alive: 300
     *
     * @param keepAlive keep-alive
     * @return 返回当前对象

     */
    public HttpHeader keepAlive(String keepAlive) {
        headerMaps.put(HttpHeaders.KEEP_ALIVE,
                new BasicHeader(HttpHeaders.KEEP_ALIVE, keepAlive));
        return this;
    }

    public String accept() {
        return get(HttpHeaders.ACCEPT);
    }

    public String acceptCharset() {
        return get(HttpHeaders.ACCEPT_CHARSET);
    }

    public String acceptEncoding() {
        return get(HttpHeaders.ACCEPT_ENCODING);
    }

    public String acceptLanguage() {
        return get(HttpHeaders.ACCEPT_LANGUAGE);
    }

    public String acceptRanges() {
        return get(HttpHeaders.ACCEPT_RANGES);
    }

    public String authorization() {
        return get(HttpHeaders.AUTHORIZATION);
    }

    public String cacheControl() {
        return get(HttpHeaders.CACHE_CONTROL);
    }

    public String connection() {
        return get(HttpHeaders.CONNECTION);
    }

    public String cookie() {
        return get(HttpHeaders.COOKIE);
    }

    public String contentLength() {
        return get(HttpHeaders.CONTENT_LENGTH);
    }

    public String contentType() {
        return get(HttpHeaders.CONTENT_TYPE);
    }

    public String date() {
        return get(HttpHeaders.DATE);
    }

    public String expect() {
        return get(HttpHeaders.EXPECT);
    }

    public String from() {
        return get(HttpHeaders.FROM);
    }

    public String host() {
        return get(HttpHeaders.HOST);
    }

    public String ifMatch() {
        return get(HttpHeaders.IF_MATCH);
    }

    public String ifModifiedSince() {
        return get(HttpHeaders.IF_MODIFIED_SINCE);
    }

    public String ifNoneMatch() {
        return get(HttpHeaders.IF_NONE_MATCH);
    }

    public String ifRange() {
        return get(HttpHeaders.IF_RANGE);
    }

    public String ifUnmodifiedSince() {
        return get(HttpHeaders.IF_UNMODIFIED_SINCE);
    }

    public String maxForwards() {
        return get(HttpHeaders.MAX_FORWARDS);
    }

    public String pragma() {
        return get(HttpHeaders.PRAGMA);
    }

    public String proxyAuthorization() {
        return get(HttpHeaders.PROXY_AUTHORIZATION);
    }

    public String referer() {
        return get(HttpHeaders.REFERER);
    }

    public String te() {
        return get(HttpHeaders.TE);
    }

    public String upgrade() {
        return get(HttpHeaders.UPGRADE);
    }

    public String userAgent() {
        return get(HttpHeaders.USER_AGENT);
    }

    public String via() {
        return get(HttpHeaders.VIA);
    }

    public String warning() {
        return get(HttpHeaders.WARNING);
    }

    public String keepAlive() {
        return get(HttpHeaders.KEEP_ALIVE);
    }


    /**
     * 获取head信息
     *
     * @return
     */
    private String get(String headName) {
        if (headerMaps.containsKey(headName)) {
            return headerMaps.get(headName).getValue();
        }
        return null;
    }

    /**
     * 返回header头信息
     *
     * @return 返回构建的header头信息数组
     */
    public Header[] build() {
        Header[] headers = new Header[headerMaps.size()];
        int i = 0;
        for (Header header : headerMaps.values()) {
            headers[i] = header;
            i++;
        }
        headerMaps.clear();
        headerMaps = null;
        return headers;
    }

    /**
     * HTTP Header 字段名的常量
     *
     * @date 2018/6/14
     */
    private static final class HttpHeaders {
        public static final String ACCEPT = "Accept";
        public static final String ACCEPT_CHARSET = "Accept-Charset";
        public static final String ACCEPT_ENCODING = "Accept-Encoding";
        public static final String ACCEPT_LANGUAGE = "Accept-Language";
        public static final String ACCEPT_RANGES = "Accept-Ranges";
        public static final String AUTHORIZATION = "Authorization";
        public static final String CACHE_CONTROL = "Cache-Control";
        public static final String CONNECTION = "Connection";
        public static final String COOKIE = "Cookie";
        public static final String CONTENT_LENGTH = "Content-Length";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String DATE = "Date";
        public static final String EXPECT = "Expect";
        public static final String FROM = "From";
        public static final String HOST = "Host";
        public static final String IF_MATCH = "If-Match ";
        public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
        public static final String IF_NONE_MATCH = "If-None-Match";
        public static final String IF_RANGE = "If-Range";
        public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
        public static final String KEEP_ALIVE = "Keep-Alive";
        public static final String MAX_FORWARDS = "Max-Forwards";
        public static final String PRAGMA = "Pragma";
        public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
        public static final String RANGE = "Range";
        public static final String REFERER = "Referer";
        public static final String TE = "TE";
        public static final String UPGRADE = "Upgrade";
        public static final String USER_AGENT = "User-Agent";
        public static final String VIA = "Via";
        public static final String WARNING = "Warning";
    }

}
