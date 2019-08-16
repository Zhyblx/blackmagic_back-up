package businessunit.blackmagicproject.moneyaffairorderstatistics;

/**
 * 枚举类：MoneyAffairOrderStatisticsAppIdEnum
 * 作用：对应财务系统中的业务类型选项
 *
 */

public enum MoneyAffairOrderStatisticsAppIdEnum {

    卡销("1"),
    电商("2"),
    火车票("3"),
    飞机票("4"),
    酒店("5"),
    服务("6"),
    电影票("7"),
    朋友圈("8"),
    咖啡("9"),
    卡面销售("10"),
    门票("11"),
    管家打赏("12"),
    充值中心("16"),
    会籍("21"),
    定制旅行("22"),
    专车("25"),
    虚拟平台("27");

    private String strAppIdEnum = "";

    private MoneyAffairOrderStatisticsAppIdEnum(String strAppIdEnum) {
        this.strAppIdEnum = strAppIdEnum;

    }

    public String getStrAppIdEnum() {
        return this.strAppIdEnum;

    }

}
