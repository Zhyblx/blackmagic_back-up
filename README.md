## 黑魔法

    (我工作中的"Jarvis")

<strong>项目宗旨：</strong>
更好的有效工作，优质的享受生活。

<strong>项目结构：</strong>
由6个子模块组成。<br>
1.toolbox(工具箱)：定义通用功能的开发。<br>
2.businessunit(事业部)：定义不同的业务场景功能。<br>
3.edges(边角料)：定义边缘业务的特定功能。<br>
4.experimentation(试验场)：定义测试场景的开发。<br>
5.repositories(资源库)：定义公共参数。<br>
6.Institutes(研究院)：定义对新型项目的调研。<br>

----

#### businessunit(事业部)

<table>

<tr>
<td>功能名称</td>
<td>包名</td>
<td>类名</td>
<td>方法</td>
<td>参数说明</td>
<td>返回类型</td>
<td>描述</td>
</tr>

<tr>
<td>浏览器身份接口</td>
<td>businessunit.activitytopics;</td>
<td>UserAgentInterface</td>
<td>--</td>
<td>--</td>
<td>Map</td>
<td>浏览器身份</td>
</tr>

<tr>
<td>专题下商品删除</td>
<td>businessunit.activitytopics;</td>
<td>Topic</td>
<td>setTopicShopID()</td>
<td>pageNum：页码</td>
<td>List</td>
<td>获取专题下商品的专题ID</td>
</tr>

<tr>
<td>专题下商品删除</td>
<td>businessunit.activitytopics;</td>
<td>Topic</td>
<td>getDeleteGoods()</td>
<td>topicShopID：专题下商品的专题ID</td>
<td>--</td>
<td>删除专题下的商品列表</td>
</tr>

<tr>
<td>专题下商品删除</td>
<td>businessunit.activitytopics;</td>
<td>Topic</td>
<td>Topic()</td>
<td>
strCookie：cookie <br>
topicId：专题ID
</td>
<td>--</td>
<td>构造方法</td>
</tr>

<tr>
<td>专题下商品删除</td>
<td>businessunit.activitytopics;</td>
<td>TopicTest</td>
<td>--</td>
<td>--</td>
<td>--</td>
<td>执行删除专题商品列表的操作</td>
</tr>

<tr>
<td>专题商品按排序导入</td>
<td>businessunit.activitytopics;</td>
<td>UploadShop</td>
<td>setUploadShop()</td>
<td>
strCookie：cookie <br>
productIds:商品ID<br>
topicId：专题ID
</td>
<td>--</td>
<td>作用于按顺序导入商品</td>
</tr>

<tr>
<td>电商当日实际利润计算</td>
<td>businessunit.excel;</td>
<td>ProfitCalculation</td>
<td>getProfitCalculationList()</td>
<td>--</td>
<td>List</td>
<td>排除商品ID 12810、13038 的利润价</td>
</tr>

<tr>
<td>电商当日实际利润计算</td>
<td>businessunit.excel;</td>
<td>ProfitCalculation</td>
<td>getSpecialGoods()</td>
<td>--</td>
<td>List</td>
<td>单独计算商品ID 12810、13038 的利润</td>
</tr>

<tr>
<td>电商当日实际利润计算</td>
<td>businessunit.excel;</td>
<td>ProfitCalculation</td>
<td>main()</td>
<td>--</td>
<td>--</td>
<td>主方法直接计算</td>
</tr>

<tr>
<td>当日利润贡献榜</td>
<td>businessunit.excel;</td>
<td>ProfitRanking</td>
<td>main()</td>
<td>--</td>
<td>--</td>
<td>根据当天利润的贡献度进行排序</td>
</tr>

<tr>
<td>自动计算实际利润</td>
<td>businessunit.excel;</td>
<td>AutomaticProfitCalculation</td>
<td>构造方法</td>
<td>
String startDate(开始日期)<br>
String endDate(结束日期)<br>
String strCookie(cookie)<br>
<td>--</td>
<td>自动计算电商实际利润</td>
</tr>

<tr>
<td>[利润计算]文件判断</td>
<td>businessunit.excel;</td>
<td>IsFileExists</td>
<td>setIsFileExists(File file)</td>
<td>
File file(对象文件)<br>
<td>--</td>
<td>自动计算实际利润，判断被计算的文件是否存在</td>
</tr>


<tr>
<td>类目信息</td>
<td>businessunit.blackmagicproject;</td>
<td>BlackMagicSortInfo</td>
<td>getCatId1()</td>
<td>pageNum:页码</td>
<td>Map</td>
<td>查询一级类目</td>
</tr>

<tr>
<td>类目信息</td>
<td>businessunit.blackmagicproject;</td>
<td>BlackMagicSortInfo</td>
<td>getCatId2()</td>
<td>
parentId:一级类目ID<br>
pageNum:页码
</td>
<td>String</td>
<td>查询二级类目</td>
</tr>

<tr>
<td>类目映射</td>
<td>businessunit.blackmagicproject;</td>
<td>ClassificationCorrespondence</td>
<td>getClassificationMapPing()</td>
<td>
Key:类目ID<br>
</td>
<td>String</td>
<td>查询类目名称</td>
</tr>

<tr>
<td>下载订单</td>
<td>businessunit.blackmagicproject;</td>
<td>DowOederFile</td>
<td>getDowOederFile()</td>
<td>
urlStr:访问链接;<br>
fileName:文件命名<br>
savePath:下载路径<br>
setCookie:Cookie值<br>
</td>
<td>String</td>
<td>
返回:下载成功/下载失败
</td>
</tr>

<tr>
<td>下载订单</td>
<td>businessunit.blackmagicproject;</td>
<td>DowOederFile</td>
<td>getDowOederFile()</td>
<td>
startTime:开始时间<br>
endTimer:结束时间<br>
fileName:文件命名<br>
savePath:下载路径<br>
setCookie:Cookie值<br>
</td>
<td>String</td>
<td>
返回:下载成功/下载失败
</td>
</tr>

<tr>
<td>下载订单</td>
<td>businessunit.blackmagicproject;</td>
<td>DowOederFile</td>
<td>getDowOrderCenter()</td>
<td>
startTime:开始时间<br>
endTimer:结束时间<br>
state:订单状态<br>
fileName:文件命名<br>
savePath:下载路径<br>
setCookie:Cookie值<br>
</td>
<td>String</td>
<td>
返回:订单中心的订单列表
</td>
</tr>


<tr>
<td>
查询组单号
</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectgroupSeq</td>
<td>getSelectgroupSeq()</td>
<td>
seqCard_ID:子订单号<br>
strCookie:Cookie值
</td>
<td>String</td>
<td>
返回结果：<br>
组订单号+子订单号+订单地址<br>
(可返回订单详情)
</td>
</tr>


<tr>
<td>
查询组单号
</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectgroupSeq</td>
<td>getSelectgroupSeq()</td>
<td>
seqCard_ID:子订单号<br>
strCookie:Cookie值<br>
timeout:访问时长
</td>
<td>String</td>
<td>
返回结果：<br>
组订单号+子订单号<br>
(效率高但不可返回订单详情)
</td>
</tr>


<tr>
<td>
查询组单号<br>
(废弃)
</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectgroupSeq</td>
<td>getSelectgroupSeq()</td>
<td>
seqCard_ID:子订单号<br>
uid:用户ID<br>
strCookie:Cookie值
</td>
<td>String</td>
<td>
返回结果：<br>
组订单号+"，"+子订单号
</td>
</tr>

<tr>
<td>
查询订单<br>
userID
</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectgroupSeq</td>
<td>getSupplierUid()</td>
<td>
seqCard_ID:子订单号<br>
strCookie:Cookie值
</td>
<td>map</td>
<td>
返回结果<br>
组订单号+用户ID
</td>
</tr>

<tr>
<td>是否下单</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectInfo</td>
<td>getSelectUid()</td>
<td>
userid:用户ID;<br>
setCookie:Cookie值
</td>
<td>String</td>
<td>
返回结果：<br>
1146050,true
</td>
</tr>

<tr>
<td>商家商品列表</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectInfo</td>
<td>getShopCommodity()</td>
<td>
supplierId:供应商ID;<br>
pageNum:页码;<br>
setCookie:Cookie值
</td>
<td>String</td>
<td>
返回结果：<br>
商品ID、商品标题、型号
</td>
</tr>

<tr>
<td>查询全量商品信息</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectInfo</td>
<td>getCommodityData()</td>
<td>
status:状态(上/下架);<br>
pageNum:页码;<br>
setCookie:Cookie值
</td>
<td>String</td>
<td>
返回结果：<br>
商品ID、商品标题、类目名称<br>
发布时间、已售数量、上下架状态、售价
</td>
</tr>

<tr>
<td>退款订单量</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectOrderDataSize</td>
<td>getRefundData()</td>
<td>
status:状态<br>
startTime:开始时间<br>
endTime:结束时间<br>
strCookie:Cookie值
</td>
<td>String</td>
<td>废弃方法</td>
</tr>

<tr>
<td>订单数据量查询</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectOrderDataSize</td>
<td>getOrderData()</td>
<td>
status:状态<br>
startTime:开始时间<br>
endTime:结束时间<br>
strCookie:Cookie值
</td>
<td>String</td>
<td>返回各种状态订单总量数据</td>
</tr>

<tr>
<td>用户信息</td>
<td>businessunit.blackmagicproject;</td>
<td>SelectUserInfo</td>
<td>getSearchInfo()</td>
<td>
time:时间范围;<br>
时间格式:<br>
{2018-11-02<br>
+%E8%87%B3+<br>
2018-11-03}<br>
searchInfo:黑卡ID<br>
nameInfo:用户名<br>
phoneInfo:手机号<br>
pageNum:默认1<br>
pageSize:默认20<br>
CookieValue:Cookie值
</td>
<td>String</td>
<td>查询用户信息</td>
</tr>

<tr>
<td>商家商品信息</td>
<td>businessunit.blackmagicproject;</td>
<td>ShopGoodsJsonData</td>
<td>getUltimaVip()</td>
<td>
provinceId:省份/城市ID;<br>
CookieKey:Cookie<key>;<br>
CookieValue:Cookie<value>
</td>
<td>String</td>
<td>
返回省份的花费价格信息
</td>
</tr>

<tr>
<td>商家商品信息</td>
<td>businessunit.blackmagicproject;</td>
<td>ShopGoodsJsonData</td>
<td>getShopCommodity()</td>
<td>
supplierId:供应商ID;<br>
pageNum:页码;<br>
CookieValue:Cookie值
</td>
<td>String</td>
<td>
返回该供应商ID下的商品信息
</td>
</tr>

<tr>
<td>商家信息</td>
<td>businessunit.blackmagicproject;</td>
<td>ShopGoodsJsonData</td>
<td>getShopsJsonDataList()</td>
<td>
pageNum:页码;<br>
CookieValue:Cookie值
</td>
<td>String</td>
<td>
返回查询页码下的供应商列表信息
</td>
</tr>

<tr>
<td>查询订单明细</td>
<td>businessunit.blackmagicproject;</td>
<td>Orderstatusbreakdown</td>
<td>getOrderstatusbreakdown()</td>
<td>
String status:订单状态<br>
String pageNum:订单页码<br>
CookieValue:Cookie值
</td>
<td>String</td>
<td>
返回订单ID和用户ID
</td>
</tr>

<tr>
<td>查询订单明细</td>
<td>businessunit.blackmagicproject;</td>
<td>Orderstatusbreakdown</td>
<td>getOrderDetail()</td>
<td>
String supplierSeq:订单ID<br>
String uid:用户ID<br>
CookieValue:Cookie值
</td>
<td>String</td>
<td>
返回订单ID和订单实付金额
</td>
</tr>

<tr>
<td>查询用户信息</td>
<td>businessunit.blackmagicproject.userinfo;</td>
<td>UserInfo</td>
<td>getUserLocation()</td>
<td>
userID:用户ID;<br>
CookieValue:Cookie值
</td>
<td>String</td>
<td>
查询用户信：<br>
1.支持使用UserID查询<br>
2.使用cardNum(卡号)查询<br>
3.支持使用UserID查询会员身份信息<br>
</td>
</tr>

<tr>
<td>查询上/下状态的商品列表</td>
<td>businessunit.blackmagicproject.userinfo;</td>
<td>ShopCommodityUpdateStatus</td>
<td>setShopCommodity()</td>
<td>
String supplierId(店铺ID)<br>
String status(在架状态)<br>
int pageNum(页码)<br>
String strCookie
</td>
<td>String</td>
<td>
根据商家ID，查询上/下状态的商品列表。
</td>
</tr>

<tr>
<td>对当前商品的状态进行上/下架变更</td>
<td>businessunit.blackmagicproject.userinfo;</td>
<td>ShopCommodityUpdateStatus</td>
<td>setShopCommoditytUpdateStatus()</td>
<td>
String id(商品ID)<br>
String status(变更状态:true/false)<br>
String strCookie
</td>
<td>String</td>
<td>
商品批量上/下架的状态变更
</td>
</tr>

<tr>
<td>商品查询和状态变更的功能整合</td>
<td>businessunit.blackmagicproject.userinfo;</td>
<td>ShopCommodityUpdateStatusExpand</td>
<td>setShopCommodityExpand()</td>
<td>
String supplierId(店铺ID)<br>
String selectStatus(在架状态)<br>
String shopStatus(变更状态:true/false)<br>
int pageNum(页码)<br>
String strCookie

</td>
<td>String</td>
<td>
类：ShopCommodityUpdateStatus的功能拓展类
</td>
</tr>


<tr>
<td>统计财务订单</td>
<td>businessunit.blackmagicproject.moneyaffairorderstatistics;</td>
<td>MoneyAffairOrderStatistics</td>
<td>getMoneyAffairOrderStatistics()</td>
<td>
startTime:开始时间;<br>
endTime:结束时间<br>
appId:业务类型<br>
strCookie:Cookie值
</td>
<td>Map</td>
<td>
返回业务类型和订单量
</td>
</tr>

<tr>
<td>统计财务订单</td>
<td>businessunit.blackmagicproject.moneyaffairorderstatistics;</td>
<td>MoneyAffairOrderStatistics</td>
<td>getMoneyAffairOrderStatistics()</td>
<td>
startTime:开始时间;<br>
endTime:结束时间<br>
appId:业务类型<br>
status:订单状态<br>
strCookie:Cookie值
</td>
<td>Map</td>
<td>
返回业务类型和订单量
</td>
</tr>

<tr>
<td>财务统计枚举</td>
<td>businessunit.blackmagicproject.moneyaffairorderstatistics;</td>
<td>MoneyAffairOrderStatisticsAppIdEnum</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>
枚举类
</td>
</tr>

<tr>
<td>财务统计Map</td>
<td>businessunit.blackmagicproject.moneyaffairorderstatistics;</td>
<td>MoneyAffairOrderStatisticsMap</td>
<td>getMoneyAffairOrderStatisticsMapPing()</td>
<td>
Key:key
</td>
<td>String</td>
<td>
返回业务类型
</td>
</tr>

<tr>
<td>订单量计算</td>
<td>businessunit.blackmagicproject.moneyaffairorderstatistics;</td>
<td>MoneyAffairCalculation</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>计算各业务的订单量</td>
</tr>


<tr>
<td>朋友圈信息</td>
<td>businessunit.blackmagicproject.circleoffriends;</td>
<td>PostingMessage</td>
<td>getPostingDocuments()</td>
<td>
int page:页码<br>
String cookie:cookie
</td>
<td>String</td>
<td>获取用户的帖子信息</td>
</tr>

<tr>
<td>朋友圈信息</td>
<td>businessunit.blackmagicproject.circleoffriends;</td>
<td>PostingMessage</td>
<td>getReplyDocuments()</td>
<td>
int page:页码<br>
String cookie:cookie
</td>
<td>String</td>
<td>获取用户的评论信息</td>
</tr>

<tr>
<td>词频统计</td>
<td>edges.statistics;</td>
<td>lexicostatistics</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>统计文档中的词汇量</td>
</tr>

<tr>
<td>拼音标注</td>
<td>edges.statistics;</td>
<td>PinyinTagging</td>
<td>getTaggingQuanPin()</td>
<td>
String vocabulary：输入词
</td>
<td>--</td>
<td>标注输入词的全拼</td>
</tr>

<tr>
<td>拼音标注</td>
<td>edges.statistics;</td>
<td>PinyinTagging</td>
<td>getTaggingSuolue()</td>
<td>
String vocabulary：输入词
</td>
<td>--</td>
<td>标注输入词的拼音缩写</td>
</tr>

<tr>
<td>拼音标注测试</td>
<td>edges.statistics;</td>
<td>PinyinTaggingStart</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>--</td>
</tr>


<tr>
<td>搜索后台cookie信息</td>
<td>businessunit.blackmagicproject.search;</td>
<td>InterfaceCookie</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>接口：定义cookie信息</td>
</tr>

<tr>
<td>采集每日新增的词汇量</td>
<td>businessunit.blackmagicproject.search;</td>
<td>TakeQuery</td>
<td>setTakeQuery()</td>
<td>
Integer page:页码
Integer limit:输出数量
String word:搜索词汇
String operationEn:业务表示符
String dateRange:日期范围
String cookie:cookie信息
</td>
<td>--</td>
<td>返回当日信息的词汇数量</td>
</tr>

<tr>
<td>删除线上搜索词</td>
<td>businessunit.blackmagicproject.search;</td>
<td>DeleteQuery</td>
<td>setDeleteQuery()</td>
<td>
String id:搜索词编号
String operationCn:业务名称
String operationEn:业务表示符
String word:搜索词
String createTime:搜索词创建时间
String cookie:cookie信息
</td>
<td>--</td>
<td>删除线上搜索词</td>
</tr>

<tr>
<td>添加搜索词</td>
<td>businessunit.blackmagicproject.search;</td>
<td>UpdateQuery</td>
<td>setUpdateQuery()</td>
<td>
String lexicon:搜索词
String operationCn:业务名称
String operationEn:业务表示符
String cookie:cookie信息
</td>
<td>--</td>
<td>添加搜索词</td>
</tr>


<tr>
<td>微拍堂的线上地址</td>
<td>businessunit.blackmagicproject.ultimavip.weipaitang.weipaitanginterface;</td>
<td>WeiPaiTangInterface</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>--</td>
</tr>

<tr>
<td>获取精选分类的拍品数据</td>
<td>businessunit.blackmagicproject.ultimavip.weipaitang.Selected;</td>
<td>RecommendTogetherData</td>
<td>setRecommendTogetherData()</td>
<td>
String page：页码<br>
String timer：时间
</td>
<td>String</td>
<td>微拍堂</td>
</tr>


<tr>
<td>获取"热门"分类的直播视频数据</td>
<td>businessunit.blackmagicproject.ultimavip.weipaitang.video;</td>
<td>VideoData</td>
<td>setVideoData()</td>
<td>
String start：状态<br>
String page：页码
</td>
<td>String</td>
<td>微拍堂</td>
</tr>

<tr>
<td>获取具体分类的直播视频数据</td>
<td>businessunit.blackmagicproject.ultimavip.weipaitang.video;</td>
<td>VideoClassifyData</td>
<td>setVideoClassifyData() </td>
<td>
String start：状态<br>
String page：页码<br>
String categoryId:分类码<br>
String secCategoryId:默认-1
</td>
<td>String</td>
<td>微拍堂</td>
</tr>

<tr>
<td>时间处理器返回时间戳</td>
<td>businessunit.blackmagicproject.ultimavip.weipaitang.timeprocessor;</td>
<td>TimeProcessor</td>
<td>getTimeProcessor() </td>
<td>
--
</td>
<td>--</td>
<td>返回时间戳</td>
</tr>


</table>


#### toolbox(工具箱)

<table>

<tr>
<td>功能名称</td>
<td>包名</td>
<td>类名</td>
<td>方法</td>
<td>参数说明</td>
<td>返回类型</td>
<td>描述</td>
</tr>

<tr>
<td>百度翻译</td>
<td>toolbox;</td>
<td>BaiduFanyi</td>
<td>getBaiduFanyi()</td>
<td>
text:文字
</td>
<td>String</td>
<td>
返回翻译结果
</td>
</tr>

<tr>
<td>日志工具</td>
<td>toolbox;</td>
<td>LogPrinting</td>
<td>getLog()</td>
<td>
msg:错误消息
</td>
<td>--</td>
<td>
错误消息进行存储
</td>
</tr>

<tr>
<td>MD5加密</td>
<td>toolbox;</td>
<td>MD5Util</td>
<td>setMD5()</td>
<td>
strTxt:字符串
</td>
<td>String</td>
<td>
返回加密结果
</td>
</tr>

<tr>
<td>图片识别</td>
<td>toolbox;</td>
<td>Ocr</td>
<td>getOcrRun()</td>
<td>
imagePath:图片地址
</td>
<td>String</td>
<td>
返回文字识别结果
</td>
</tr>

<tr>
<td>图片翻译</td>
<td>toolbox;</td>
<td>PictureTranslation</td>
<td>getPictureTranslation()</td>
<td>
imagePath:图片地址
</td>
<td>String</td>
<td>
返回图片内容翻译结果
</td>
</tr>

<tr>
<td>时间转换为时间戳</td>
<td>toolbox;</td>
<td>TimeStamp</td>
<td>dateToStamp()</td>
<td>
strDate:日期
</td>
<td>String</td>
<td>
返回：时间戳
</td>
</tr>

<tr>
<td>时间戳转换为时间</td>
<td>toolbox;</td>
<td>TimeStamp</td>
<td>stampToDate()</td>
<td>
strTimeStamp:时间戳
</td>
<td>String</td>
<td>
返回：日期
</td>
</tr>

<tr>
<td>Unicode转义</td>
<td>toolbox;</td>
<td>UnicodeConversion</td>
<td>getdecodeUnicode()</td>
<td>
unicodeData:Unicode编码
</td>
<td>String</td>
<td>
unicode编码转字符
</td>
</tr>

<tr>
<td>Unicode转义</td>
<td>toolbox;</td>
<td>UnicodeConversion</td>
<td>getgbEncoding()</td>
<td>
stringData:字符
</td>
<td>String</td>
<td>
字符转unicode编码
</td>
</tr>

<tr>
<td>解压Rar</td>
<td>toolbox;</td>
<td>UntieRARFile</td>
<td>getUntieRARFile()</td>
<td>
File sourceRar:RAR文件地址;<br>
File destDir:解压目的地址;<br>
</td>
<td>--</td>
<td>
引用传递<br>
</td>
</tr>

<tr>
<td>文字过滤器</td>
<td>toolbox;</td>
<td>TextFilter</td>
<td>textFilter() </td>
<td>
String text:待处理字符串;<br>
</td>
<td>boolean</td>
<td>
文字过滤器<br>
</td>
</tr>


<tr>
<td>创建数据库</td>
<td>toolbox.databaseservice;</td>
<td>CreateSQLiteService</td>
<td>main()</td>
<td>/</td>
<td>/</td>
<td>/</td>
</tr>

<tr>
<td>插入数据</td>
<td>toolbox.databaseservice;</td>
<td>InsertService</td>
<td>getInsertService()</td>
<td>插入字段/注入Sql</td>
<td>/</td>
<td>/</td>
</tr>

<tr>
<td>字符统计</td>
<td>toolbox;</td>
<td>CharacterStatistics</td>
<td>getCharacterStatistics()</td>
<td>
inputStrintCharacter:字符串<br>
inputCharacter:字符
</td>
<td>String</td>
<td>统计字符在一段字符串中出现的次数</td>
</tr>

<tr>
<td>Map排序工具</td>
<td>toolbox.mapsort.accordingtovalue;</td>
<td>MapValueComparator</td>
<td>compare()</td>
<td>--</td>
<td>int</td>
<td>map_Value比较器；返回map条目的值</td>
</tr>

<tr>
<td>Map排序工具</td>
<td>toolbox.mapsort.accordingtovalue;</td>
<td>SortMapByValue</td>
<td>sortMapByValue()</td>
<td>Map对象</td>
<td>Map</td>
<td>根据(Map)value值的大小进行排序输出</td>
</tr>

<tr>
<td>Map排序工具</td>
<td>toolbox.mapsort.accordingtokey;</td>
<td>MapKeyComparator</td>
<td>compare()</td>
<td>--</td>
<td>int</td>
<td>map_Key比较器；返回map条目的值</td>
</tr>

<tr>
<td>Map排序工具</td>
<td>toolbox.mapsort.accordingtokey;</td>
<td>SortMapByKey</td>
<td>sortMapByKey()</td>
<td>Map对象</td>
<td>Map</td>
<td>根据(Map)key值的大小进行排序输出</td>
</tr>

<tr>
<td>解析二维码</td>
<td>toolbox;</td>
<td>QRcodeanalysis</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>输入二维码图片地址</td>
</tr>

</table>


#### Institutes(研究院)

<table>

<tr>
<td>功能名称</td>
<td>包名</td>
<td>类名</td>
<td>方法</td>
<td>参数说明</td>
<td>返回类型</td>
<td>描述</td>
</tr>

<tr>
<td>文件改名</td>
<td>Institutes.changefilename.Kernel;</td>
<td>DiskScan</td>
<td>getFileName()</td>
<td>File file</td>
<td>String</td>
<td>递归扫描文件</td>
</tr>

<tr>
<td>文件改名</td>
<td>Institutes.changefilename.Kernel;</td>
<td>DiskScan</td>
<td>renameFile()</td>
<td>
path:文件路径
oldname:原文件名称
newname:新文件名称
</td>
<td>/</td>
<td>文件重命名</td>
</tr>

<tr>
<td>猜数字</td>
<td>Institutes.game.guessthenumber;</td>
<td>Guessframe</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>猜数字游戏</td>
</tr>

<tr>
<td>应用程序</td>
<td>Institutes.changefilename.window;</td>
<td>toolwindow</td>
<td>/</td>
<td>
/
</td>
<td>/</td>
<td>变更文件名的窗口程序</td>
</tr>

<tr>
<td>扫描目录</td>
<td>Institutes.changefilename.Kernel;</td>
<td>AllFilesCatalog</td>
<td>getAllFiles()</td>
<td>
File dir: File对象
</td>
<td>List</td>
<td>获取所有目录路径(即，扫描目录)</td>
</tr>


<tr>
<td>文件扫描器</td>
<td>Institutes.changefilename.Kernel;</td>
<td>DocumentScanner</td>
<td>getDocumentScanner()</td>
<td>
File file: File对象
</td>
<td>List</td>
<td>可扫描一个目录(包括子目录)下的所以文件</td>
</tr>

</table>

#### experimentation(试验场)

<table>

<tr>
<td>功能名称</td>
<td>包名</td>
<td>类名</td>
<td>方法</td>
<td>参数说明</td>
<td>返回类型</td>
<td>描述</td>
</tr>

<tr>
<td>下载订单</td>
<td>businessunit.blackmagicproject.DowOederFile;</td>
<td>DowOederFileStatic</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>下载订单的应用类</td>
</tr>

<tr>
<td>插入数据</td>
<td>businessunit.blackmagicproject.DowOederFile;</td>
<td>InsertServiceStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>插入数据到数据库</td>
</tr>

<tr>
<td>图片识别文字</td>
<td>experimentation.blackmagictest;</td>
<td>OcrStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>图片识别文字的应用</td>
</tr>

<tr>
<td>子单号反查组单号</td>
<td>experimentation.blackmagictest;</td>
<td>SelectgroupSeqStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>子单号反查组单号的应用</td>
</tr>

<tr>
<td>查询供应商的商品</td>
<td>experimentation.blackmagictest;</td>
<td>SelectShopCommodityStatr</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>查询供应商的商品列表</td>
</tr>


<tr>
<td>存储商品信息</td>
<td>experimentation.blackmagictest;</td>
<td>StoreGoodsStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>存储StoreGoods.txt</td>
</tr>

<tr>
<td>解压RAR文件</td>
<td>experimentation.blackmagictest;</td>
<td>UntieRARFileStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>解压RAR压缩包的应用类</td>
</tr>

<tr>
<td>地址匹配计算</td>
<td>experimentation.blackmagictest;</td>
<td>UntieRARFileStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>京东和考拉地址信息的匹配计算</td>
</tr>

<tr>
<td>(电商)分词结果的基础分层</td>
<td>experimentation.blackmagictest;</td>
<td>BusinessWordSort</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>计算(电商)商品标题的分词结果与基础词库的文本相似度，<br>
遍历过程(分词)词汇划分在分最高的(基础)词汇所属业务</td>
</tr>

<tr>
<td>词汇与业务的对应关系</td>
<td>experimentation.blackmagictest;</td>
<td>VocabularyMap</td>
<td>getVocabularyMap()</td>
<td>key:Map key</td>
<td>String</td>
<td>记录基础词库中的每个词汇与业务的对应关系</td>
</tr>


<tr>
<td>地址匹配计算</td>
<td>experimentation.blackmagictest;</td>
<td>BusinessWord</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>计算输入词的业务所属关系</td>
</tr>

<tr>
<td>扫描文件启动程序</td>
<td>experimentation.blackmagictest;</td>
<td>ScanFileStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>扫描文件启动程序</td>
</tr>

<tr>
<td>获取用户信息启动程序</td>
<td>experimentation.blackmagictest;</td>
<td>UserInfoSelectStart</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>获取用户信息启动程序</td>
</tr>

<tr>
<td>处理文档中的空格行</td>
<td>experimentation.blackmagictest;</td>
<td>UserLocationSelect</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>处理文档中的空格行</td>
</tr>


<tr>
<td>数据报告应用代码</td>
<td>experimentation.blackmagictest;</td>
<td>DataReport</td>
<td>getReadFileName()</td>
<td>
String filePath:文件地址
</td>
<td>/</td>
<td>读取文件名称</td>
</tr>

<tr>
<td>数据报告应用代码</td>
<td>experimentation.blackmagictest;</td>
<td>DataReport</td>
<td>getNewsFileOcrRun()</td>
<td>/</td>
<td>/</td>
<td>完成对新闻图片的文字转化</td>
</tr>

<tr>
<td>数据报告应用代码</td>
<td>experimentation.blackmagictest;</td>
<td>DataReport</td>
<td>getNewsRun()</td>
<td>/</td>
<td>/</td>
<td>完成对新闻的内容分词</td>
</tr>


<tr>
<td>测试文本相似度算法</td>
<td>experimentation.worddatatest;</td>
<td>TextSimilarityAccuracyTest</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>文本相似度的准确性测试</td>
</tr>

<tr>
<td>测试反义词算法</td>
<td>experimentation.worddatatest;</td>
<td>AntonymComputationTest</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>反义词计算测试</td>
</tr>

<tr>
<td>测试标注拼音</td>
<td>experimentation.worddatatest;</td>
<td>PinyinTaggingTest</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>测试标注拼音</td>
</tr>

<tr>
<td>词频统计</td>
<td>experimentation.worddatatest;</td>
<td>WordStatistics</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>词频统计</td>
</tr>


<tr>
<td>测试Map_value的排序功能</td>
<td>experimentation.mapsortingtest;</td>
<td>MapValueSortingTest</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>测试Map_value的排序功能</td>
</tr>

<tr>
<td>测试Map_Key的排序功能</td>
<td>experimentation.mapsortingtest;</td>
<td>MapKeySortingTest</td>
<td>/</td>
<td>/</td>
<td>/</td>
<td>测试Map_Key的排序功能</td>
</tr>

</table>


#### edges(边角料)

<table>

<tr>
<td>功能名称</td>
<td>包名</td>
<td>类名</td>
<td>方法</td>
<td>参数说明</td>
<td>返回类型</td>
<td>描述</td>
</tr>

<tr>
<td>解析京东地址</td>
<td>edges.jd;</td>
<td>JDAddressResolution</td>
<td>getJDAddressJSONObject()</td>
<td>/</td>
<td>/</td>
<td>
1.将京东地址根据省维度进行Json数据拆分<br>
2.解析结果存储到本地文件str.txt文件中
</td>
</tr>

<tr>
<td>解析京东地址</td>
<td>edges.jd;</td>
<td>JDAddressResolution</td>
<td>getJDAddressJSONObject()</td>
<td>
path:京东地址Json原文件地址
</td>
<td>List</td>
<td>
1.将京东地址根据省维度进行Json数据拆分<br>
2.存到List中返回
</td>
</tr>

<tr>
<td>地址解析</td>
<td>edges.jd;</td>
<td>JDAddressResolution</td>
<td>getAddressList()</td>
<td>/</td>
<td>/</td>
<td>
1.处理本地str.txt中的数据<br>
2.最多解析成4级地址
</td>
</tr>

<tr>
<td>地址解析</td>
<td>edges.jd;</td>
<td>JDAddressResolution</td>
<td>getAddressList()</td>
<td>
list:省维度的List数据
</td>
<td>/</td>
<td>
1.处理由getJDAddressJSONObject()方法返回的list数据<br>
2.最多解析成4级地址
</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusinessEnum</td>
<td>getStrEnum()</td>
<td>--</td>
<td>String</td>
<td>趣满满电影票接口</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getQueryCitys()</td>
<td>--</td>
<td>String</td>
<td>返回地区列表</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getQueryCinemas()</td>
<td>--</td>
<td>List<String></td>
<td>返回当前地区影院列表</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getQueryFilms()</td>
<td>
CinemaId:影院ID
</td>
<td>List<String></td>
<td>返回影片列表</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getQueryShows()</td>
<td>
CinemaId:影院ID
FilmId:影片id
</td>
<td>List<String></td>
<td>返回场次列表</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getQueryShowSeat()</td>
<td>
showId:场次号
</td>
<td>List<String></td>
<td>返回座位图列表</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getSubmitOrder()</td>
<td>
seatId:座位id
</td>
<td>List<String></td>
<td>下单进行锁座</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getConfirmOrder()</td>
<td>
orderId:订单ID
price:金额
</td>
<td>String</td>
<td>扣款</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaBusiness</td>
<td>getQueryOrder()</td>
<td>
orderId:订单ID
</td>
<td>String</td>
<td>查询订单详情</td>
</tr>

<tr>
<td>电影接口</td>
<td>edges.piaofer;</td>
<td>CinemaInterfaceVerification</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>--</td>
</tr>

<tr>
<td>检索反馈内容</td>
<td>edges.userexperience;</td>
<td>UserFeedback</td>
<td>--</td>
<td>
--
</td>
<td>--</td>
<td>检索出现关键词的反馈内容</td>
</tr>

<tr>
<td>解析json数据</td>
<td>edges.analysisjson;</td>
<td>AnalysisJson</td>
<td>--</td>
<td>--</td>
<td>--</td>
<td>临时脚本</td>
</tr>

<tr>
<td>计算2个文件的相同词汇</td>
<td>edges.analysisjson;</td>
<td>LexicalMatching</td>
<td>--</td>
<td>--</td>
<td>--</td>
<td>得到相同词汇</td>
</tr>


<tr>
<td>获取大消费对账系统数据</td>
<td>edges.temporaryjob;</td>
<td>TakeConsumptionBill</td>
<td>--</td>
<td>--</td>
<td>--</td>
<td>给盒子取数据的临时代码</td>
</tr>

<tr>
<td>考拉数据接口</td>
<td>edges.kaoladata;</td>
<td>KaoLaInterface</td>
<td>--</td>
<td>--</td>
<td>--</td>
<td>考拉数据接口定义</td>
</tr>

<tr>
<td>监控UCC咖啡的评论数据</td>
<td>edges.kaoladata;</td>
<td>UCCCommentData</td>
<td>setUCCCommentData()</td>
<td>
String goodsId：商品ID<br>
String pageNo：页码
</td>
<td>String</td>
<td>监控UCC咖啡的评论数据</td>
</tr>


<tr>
<td>穷举计算</td>
<td>edges.exhaustiveaddress;</td>
<td>AddressExhaustive</td>
<td>getCityName()</td>
<td>
String readPath：输入城市地址<br>
String outputPath：输入穷举词汇地址
</td>
<td>--</td>
<td>针对城市列表进行穷举</td>
</tr>

<tr>
<td>穷举计算测试</td>
<td>edges.exhaustiveaddress;</td>
<td>AddressExhaustiveTest</td>
<td>--</td>
<td>--</td>
<td>--</td>
<td>穷举计算测试</td>
</tr>

<tr>
<td>解析json文件中的城市名称</td>
<td>edges.exhaustiveaddress;</td>
<td>AddressExhaustiveJson</td>
<td>setAddressExhaustiveJson()</td>
<td>String readPath：输入城市地址<br></td>
<td>--</td>
<td>解析json文件中的城市名称</td>
</tr>

<tr>
<td>处理出行订单中的城市名称</td>
<td>edges.exhaustiveaddress;</td>
<td>CityName</td>
<td>setCityName()</td>
<td>
String inputPath：输入城市地址<br>
String outPath：输出城市地址<br>
</td>
<td>--</td>
<td>处理出行订单中的城市名称</td>
</tr>

</table>

----

#### 更新日志

2018年09月14日：维护项目V1.0。<br>
    
    说明:完成各种提效功能提交。

2018年11月28日：维护项目V2.0。<br>

    说明:完成项目架构调整，明确功能所属模块。


2019年01月08日：维护项目V2.1。<br>

    说明:
    1.增加Map 排序功能。
    2.加入word分词算法元素;实现分词、文本相似度计算、反义词计算等。
    3.增加文件扫描器的功能。


#### 附录：

##### 实验一：【验证搜索产品学习并了解lucnen框架】

##### (一、知识点)：<br>
搜索产品大致可以划分为平台级搜索和后台搜索。<br>
后台搜索：一般而言对产品后台所集成的搜索模块要求不会太高，能完成本业务域下数据库的模糊查询即可。(如：select * from  table where  Field like ‘%name%’;)  这种查询方式的实现成本低，同时效率也低；致命的特点是无法支持大数据量的查询。<br>
平台搜索：搜索对产品的贡献要达到两个要求：1.实时的搜索效率。2.降低损耗服务端的资源。以公司所使用的lucene开源框架举例就很好的满足了当前我们公司对搜索的要求。<br>


##### (二、学习小结)：<br>
1.lucene是一个开源的全文搜索框架。<br>
2.lucene大体上分为两部分：索引引擎和查询引擎。即，系统要预先对后续接入搜索服务的数据进行“索引”的建立；从而通过匹配用户的输入文本进行结果查询，以达到高效服务和降低损耗的目的。<br>

        举个例子：<br>
        有一件衣服，商品标题是“男式都市户外羽绒服”。那么为了后面用户能快速的找到这件衣服，lucene要做两件事情：<br>
        a.对商品标题“男式都市户外羽绒服”进行分词，从而建立索引值；他的索引值大概体现成以下几个字或词；如：男、式、都、市、户、外、羽、绒、服、男式、都市、户外、羽绒服。这些字或词都是可对应到这件商品的索引。<br>
        B.当用户A输入“羽绒服”的时候，lucene就会启动查询引擎对索引库中的索引值进行遍历匹配；当关键字“羽绒服”和索引值“羽绒服”匹配到了，这个商品就出现在了搜索结果。<br>

3.为什么lucene就能减少服务损耗呢？那是因为“索引文件”就是一段文本文件，体积非常小，存储的内容就是索引和各个数据实体的映射关系。<br>

##### (三、项目说明)：<br>
一、建立索引值<br>
接口：Institutes.searchtopic.demo.lucene.Createindex;<br>
方法：createIndex()<br>
类型：boolean<br>
定义：--<br>
描述：建立索引目录<br>
参数：<br>
<table>
<tr>
<td>名称</td>
<td>类型</td>
<td>必填</td>
<td>描述</td>

</tr>

<tr>
<td>indexDir</td>
<td>String</td>
<td>是</td>
<td>索引地址</td>

</tr>

</table>

返回结果：true或false<br>


二、文件内容转数组<br>
接口：Institutes.searchtopic.demo.readfile.ReadFile;<br>
方法：getArray()<br>
类型：String[]<br>
定义：static<br>
描述：将文本内容转成建立索引过程中所需的数组值<br>
参数：<br>
<table>
<tr>
<td>名称</td>
<td>类型</td>
<td>必填</td>
<td>描述</td>

</tr>

<tr>
<td>Path</td>
<td>String</td>
<td>是</td>
<td>文件地址</td>

</tr>

</table>

返回结果：数组地址 <br>


三、搜索实现<br>
接口：Institutes.searchtopic.demo.lucene.SearchBuilder;<br>
方法：doSearch()<br>
类型：List<String><br>
定义：static<br>
描述：完成实现搜索的方法<br>
参数：<br>
<table>
<tr>
<td>名称</td>
<td>类型</td>
<td>必填</td>
<td>描述</td>

</tr>

<tr>
<td>indexDir</td>
<td>String</td>
<td>是</td>
<td>索引地址</td>

</tr>

<tr>
<td>queryStr</td>
<td>String</td>
<td>是</td>
<td>输入的关键词</td>

</tr>

</table>

返回结果：list搜索结果 <br>


四、定义业务词库<br>
接口：Institutes.searchtopic.demo.thesaurus.SearchThesaurus;<br>
方法：getSearchThesaurusMap()<br>
类型：String<br>
定义：static<br>
描述：完成查询用户输入词隶属的业务线<br>
参数：<br>
<table>
<tr>
<td>名称</td>
<td>类型</td>
<td>必填</td>
<td>描述</td>

</tr>

<tr>
<td>key</td>
<td>String</td>
<td>是</td>
<td>输入词</td>

</tr>

</table>

返回结果：业务名称 <br>


五、搜索的应用<br>
接口：Institutes.searchtopic.demo.applicationtest.SearchApplication;<br>
方法：--<br>
类型：--<br>
定义：--<br>
描述：<br>
1.完成查询用户输入词隶属的业务线。<br>
2.完成对用户输入词的搜索结果输出。<br>
3.判断用户的输入词是否有对应的业务线，如果"有"那么搜索结果就按照对应的业务线输出，否则就直接按照搜索的结果输出。<br>

