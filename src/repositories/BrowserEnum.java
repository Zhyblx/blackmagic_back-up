package repositories;

public enum BrowserEnum {

    userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");

    private String strBrowserEnum = "";

    private BrowserEnum(String strBrowserEnum) {
        this.strBrowserEnum = strBrowserEnum;

    }

    public String getStrBrowserEnum() {
        return this.strBrowserEnum;

    }

}
