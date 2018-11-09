package com.hason.shorturl.output;

/**
 * 新浪的缩短网址结果
 *
 * 仅当失败时，{@code error_code} 不为空
 *
 * 详见：
 *
 * http://open.weibo.com/wiki/Short_url/expand
 *
 * @author Huanghs
 * @since 1.0
 * @date 2018/6/15
 */
public class SinaShortUrl {

    /** 错误码 */
    private String error_code;

    /** 错误提示 */
    private String error;

    /** 链接的类型，0：普通网页、1：视频、2：音乐、3：活动、5、投票 */
    private int type;

    /** 短网址 */
    private String url_short;

    /** 长网址 */
    private String url_long;

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl_short() {
        return url_short;
    }

    public void setUrl_short(String url_short) {
        this.url_short = url_short;
    }

    public String getUrl_long() {
        return url_long;
    }

    public void setUrl_long(String url_long) {
        this.url_long = url_long;
    }
}
