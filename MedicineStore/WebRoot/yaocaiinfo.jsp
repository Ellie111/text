<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>用户<b>注册</b>_wy</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="images/style.css" />
		<style type="text/css">
<!--
body{
	text-align:center;
	}
#main {
	width: 900px;
	height: auto;
	margin: auto;
}

#head {
	height: 181px;
	width: 900px;
}
#left {
	float: left;
	height: 650px;
	width: 500px;
	background-image: url(images/left_bg.gif);
	background-repeat: repeat-y;
}
#right {
	float: right;
	width: 400px;
	height: 650px;
	background-image: url(images/center_bg.gif);
}
.STYLE1 {
	font-size: 13px;
	color: #FFFFFF;
	vertical-align: text-bottom;
}
#headright {
	float: right;
	height: 30px;
	width: 200px;
	margin-bottom: 10px;
	margin-top: 10px;
}
.header{
width:900px;
height:181px;
background:url(images/header.jpg) no-repeat center;
}

#menu{
width:900px;
height:30px;
padding:55px 0 0 10px;
}
#menu ul{
display:block;
list-style:none;
padding:9px 0 0 10px;
margin:0px;
}
#menu ul li{
display:inline;
padding:0px;
margin:0px;
height:20px;
}
#menu ul li a{
height:27px;
display:block;
padding:0px 10px 0 10px;
margin:0 4px 0 4px;
_margin:0 2px 0 2px;
float:left;
text-decoration:none;
text-align:center;
color:#fff;
font-size:13px;
line-height:25px;
}
#menu ul li.selected a{
height:27px;
display:block;
padding:0px 10px 0 10px;
margin:0 5px 0 5px;
float:left;
text-decoration:none;
text-align:center;
color:#f7a849;
font-size:13px;
line-height:25px;
}
#menu ul li a:hover{
color:#f7a849
}
.STYLE2 {font-size: 24px}
-->
</style>
	</head>

	<body>

		<div class="main" id="main">
			<div id="head">
				<div class="header">
					<div class="logo">
						<a href="index.jsp"><br> </a>
					</div>
					<div id="headright">
						<table border="0">
							<tr>
								<td class="STYLE1">
									<a href="login.jsp">登录</a>
								</td>
								<td class="STYLE1">
									<a href="reg.jsp"><b>注册</b></a>
								</td>
								<td class="STYLE1">
									<img src="images/cart.gif" width="21" height="18" />
									<a href="cart.jsp">购物车</a>
								</td>
								<td class="STYLE1">
									<a href="showorder.jsp">我的订单</a>
								</td>
							</tr>
						</table>
					</div>
					
				</div>
				<table width="900" border="1" cellpadding="0" cellspacing="0">
  <tr>
    <td><div align="center"><a href="index.jsp"><strong>主页</strong></a></div></td>
    <td><div align="center"><a href="yaocaiinfo.jsp"><strong>本草大全</strong></a></div></td>
    <td><div align="center"><a href="GetAllGoodsServlet?pageNo=1"><strong>本草选购中心</strong></a></div></td>
    <td><div align="center"><a href="cart.jsp"><strong>购物车</strong></a></div></td>
    <td><div align="center"><a href="showorder.jsp"><strong>我的订单</strong></a></div></td>
    <td><div align="center"><a href="usermanage1.jsp"><b>我的资料</b></a></div></td>
  </tr>
</table>
				<div id="left" style="width: 900px;">
					<p align="center"><strong>常用中药材名字大全（1118种）</strong> <br />
    <strong>两字中药材</strong> <br />
  人参　人发　卜芥　儿茶　八角　丁香　刀豆　三七　三棱　干姜　干漆　广白　广角&nbsp;&nbsp;  广丹&nbsp; 大黄　大戟　大枣　大蒜　大蓟　小蓟　小麦小蘖　山丹　山茶　山奈　山香　山枣　山栀&nbsp; 山姜　山药　山楂　川羌　川军　川连　 川朴　川乌　川柏　川谷　川断　川椒　川贝　川芎 马兰　马辛　马菜　马莲　马宝　马勃　马蔺　卫茅　子苓　天冬　天虫　天龙　天雄　  天麻&nbsp; 元胡　元参　木瓜　木耳　木莲　木香　木通木贼　木豆　木笔　木蓝　牙皂　瓦松　瓦韦&nbsp; 贝子　贝母　贝齿　牛至　牛黄　牛膝　 牛蒡　见愁　手参　毛鸡　毛茛　毛姜　升麻　升登 丹砂　丹皮　丹参　乌茜　乌韭　乌药　乌头　乌桕　乌梅　方海　六曲　文元　文蛤　  仁杞&nbsp; 双花　双皮　水花　水萍　水韭　水莽　水蛭巴豆　玉桂　玉竹　玉金　甘松　甘草　甘遂&nbsp; 艾叶　艾片　艾蒿　石韦　石耳　石灰　 石斛　石膏　石榴　石燕　石竹　石蜜　龙胆　龙齿 龙骨　龙葵　龙脑　龙眼　归尾　田螺　申姜　生地　生姜　生军　仙茅　及巳　片苓　  白及&nbsp; 白芨　白求　白术　白芍　白芷　白英　白矾白果　白前　白丑　白参　白苏　白降　白蜜&nbsp; 白蔻　白蔹　白微　玄参　半夏　地龙　 地黄　地椒　地榆　地笋　地锦　杞子　朴硝　芒硝 朴硝　西瓜　西羌　列当　百合　百部　当归　当药　中草　曲莲　肉桂　肉果　朱砂　  向前&nbsp; 竹叶　竹苓　竹沥　竹菇　竹黄　血余　血蝎全蝎　全参　全草　合欢　合萌　守宫　冰片&nbsp; 决明　米仁　羊角　羊乳　羊蹄　灯草　 防己　防风　红花　红根　红粉　红参　红糖　红藤 红升　豆豉　麦冬　麦芽　赤芍　赤药　赤箭　芫花　芫荽　苁蓉　砂仁　花椒　芥子&nbsp;&nbsp; 苍术&nbsp; 芜荑　芹菜　芡实　芦荟　芦根　芦丁　苏子苏木　苏叶　杏仁　杠板　杜仲　杜衡　杜松&nbsp; 辰砂　园参　旱芹　旱莲　岗松　岗梅　 牡蛎　杜桂　皂角　佛手　佛片　条苓　龟甲　龟板 忘忧　辛夷　良姜　谷芽　羌活　远志　连翘　沙参　沙棘　沉香　没药　诃子　没石　  陆英&nbsp; 灵芝　鸡头　阿胶　阿魏　陈皮　附子　青皮青果　青蒿　青黛　苦木　苦参　苦菜　苦酒&nbsp; 茄根　苡仁　茅莓　茅根　枇杷　松节　 松音　松脂　松塔　松醇　郁金　虎仗　虎刺　虎骨 果导　昆布　岩陀　知母　侧柏　乳香　灸草　佩兰　狗宝　狗脊　迭达　夜合　京墨　  官桂&nbsp; 空青　卷柏　卷丹　油葱　法夏　泽兰　泽泻泡参　降香　饴糖　细辛　玳瑁　珍珠　荆芥&nbsp; 茜草　荜拔　草乌　草果　茶油　茵陈　 茯苓　茯神　荠菜　荠草　莎草　莽草　药芹　茴香 胡桃　胡椒　南星　南藤　枯矾　枯草　枯芩　柳叶　柳芽　柳枝　枳壳　枳实　栀子　  枸杞&nbsp; 柿蒂　柿霜　厚朴　砂仁　砂糖　砒石　砒霜轻粉　虻虫　胎盘　将军　钩藤　钩吻　香附&nbsp; 香橼　香嵩　香茹　香薷　重楼　胆木　 胆矾　胆星　脉通　独活　信石　鬼珠　鬼白　鬼刺 鬼针　食盐　炮姜　姜黄　姜汁　姜皮　前胡　首乌　洪连　扁豆　扁蓄　扁蕾　神曲　  蚤休&nbsp; 贯众　贯仲　秦艽　秦皮　莲子　莲肉　莲房莲芯　莲须　莪术　荷叶　荷蒂　荷梗　桂心&nbsp; 桂枝　荸荠　莎草　恶实　桔梗　桃仁　 桃汁　盐蛇　柴胡　崖香　党参　蚌花　铁屑　铝丹 蚕砂　射干　豹骨　狼毒　拳参　益智　海马　海龙　海芋　海藻　海蛰　浮石　浮萍　  通天&nbsp; 通草　桑叶　桑枝　桑皮　桑椹　黄芩　黄芪黄连　黄栌　黄柏　黄精　黄藤　黄丹　黄独&nbsp; 黄杞　黄宣　黄蜡　黄蘖　菱角　菖蒲　 菊苣　菊花　营实　萝卜　菘蓝　梅花　梅仁　梅片 雪胆　常山　野姜　野艾　野菊　野菱　蛇肉　蛇蜕　蛇莓　蚯蚓　银杏　银耳　银花　  银翘&nbsp; 猪苓　兜铃　麻油　麻黄　麻仁　鹿角　鹿茸商陆　商枝　续断　绥草　缘豆　琥珀　斑蛰&nbsp; 斑蟊　葫芦　葱白　葛根　葛花　扁蓄　 落葵　栗壳　硫磺　雄黄　喜树　椒目　棕板　掌参 紫苏　紫萍　紫芝　紫草　紫苑　紫株　紫绀　紫葳　蛤壳　蛤蚧　黑丑　黑锡　黑钻　  黑菜&nbsp; 锁阳　象贝　奥尕　猴头　滑石　寒水　童便犀角　蒺藜　蒲黄　蒲芹　椿皮　槐米　槐实&nbsp; 槐花　槐角　硼砂　雷丸　蜀椒　蜈蚣　 蜂房　蜂蜡　蜂蜜　腰黄　锦纹　腹皮　榧子　槟榔 酸浆　酸模　碱花　磁石　豆姜　蝉衣　熊胆　蝉蜕　辣蓼　赭石　蕲蛇　樟脑　稻芽&nbsp;&nbsp; 僵蚕　蝼蛄　鲤鱼　熟地　漏芦　鹤虱　薤白&nbsp; 薯莨薄荷　橘白　橘皮　橘红　橘核　燕窝&nbsp; 靛蓝　糙苏　鲮鲤　壁虎　檀香　蒿本　爵床　 藕节　礞石　瞿麦　藿香　蘑菇　鳖甲　蟾酥&nbsp; 麝香 <br />
  <br />
  <strong>三字中药材</strong><strong><br />
  </strong>　　<br />
  一见喜　 一见消　 一点红　 一枝香　 一叶萩　 一条鞭　 二叶律　 丁子香　 丁公藤　 七星草&nbsp;&nbsp;  七叶莲　 人中白　 八月札　八角枫　八角莲　 八厘麻　 九里明　 九里香　 九龙根　 九节茶 　九香虫　 了哥王　 刀伤木　 三七草　 三叉苦　  三分三　 三白草　三枝枪　三角草　 三颗针 　干石斛　 土木香　 土贝母　 土三七　 土当归　 土荆皮　 土茯苓　 土党参　 土大黄　 土牛膝 　土人参　土木鳖　土槿皮　  土鳖虫　 大头陈　 大血藤　 大红袍　 大青叶　 大青盐　 大力参 　大力子　 大风子　 大贝母　 大飞扬　 大马勃　大黄炭　大洞果　 大茶药　 大茴香　 大豆卷  　大麻仁　 大蓟炭　 大腹皮　 大紫草　 山栀皮　 山栀茶　 山茱萸　 山羊角　 山豆根　山梗菜 　山龙眼　 山芝麻　 山萸肉　 山沉香　 山崩子　 山指甲　  山慈姑　 山道年　 山鸡椒　 山苍子 　山海螺　 千日红　 千斤拨　千年健　千里光　 千里明　 千金正　 千屈荣　 千里及　 千张纸 　千层塔　 川木香　 川木通　  川贝母　 川白芷　 川牛膝　 川桐皮　川楝子　川山甲　 川槿皮 　川郁金　 广郁金　 广地龙　 广木香　 广地丁　 广防己　 广藿香　 女贞子　 女儿香　 飞刀剑  　飞扬草　飞滑石　小飞扬　 小蓟炭　 小百科　 小石韦　 小红莲　 小红参　 小胡麻　 小兰花 　小驳骨　 小叶朴　 小青皮　 小茴香　 小通草　小黄药　万年青　  马蹄金　 马齿苋　 马前子 　马尾莲　 马利筋　 马兰头　 马兰草　 马牙硝　 马尿泡　 马兜铃　 马缨花　 马槟榔　马鞭草 　也白头　 天冬草　 天花粉　 天竹子  　天竺黄　 天竹根　 天南星　 天门冬　 天南星　 天浆壳 　天葵子　 元明粉　 元宝草　开金锁　云母石　 云木香　 云实皮　 木棉花　 木腰子　 木槿花 　木蝴蝶　  木芙蓉　 木藤蓼　 木鳖子　 木防己　 木笔花　 木贼花　木菠萝　木灵芝　 木姜子 　木患子　 太子参　 太阳花　 五加皮　 五灵脂　 五味子　 五指柑　 五倍子　  五眼果　 五敛子 　扎蓬果　支柱蓼　无漏子　 无名子　 无名异　 无患子　 车前子　 车前草　 瓦楞子　 瓦垄子 　瓦挖草　 贝母花　 丹皮炭　 丹皮酚　 公丁香　牛大力　牛西西　  牛蒡子　 书带草　 毛冬青 　毛诃子　 月季花　 月月花　 风茄花　 风化硝　 风仙花　 凤凰衣　 凤尾草　 乌头碱　乌贼骨 　乌梢蛇　 乌蔹莓　 六和曲　 六月雪　  文旦皮　 文冠木　 火炭母　 火麻仁　 双蝴蝶　 水安息 　水花生　 水车前　 水龙骨　水牛角　水半夏　 水扬梅　 水蜈蚣 　水蔓菁　 巴豆霜　 巴戟天 　玉米须　  功劳木　 甘草节　 甘草稍　 甘露子　 甘松香　 古山龙　石灰华　石见穿　 石吊兰 　石决明　 石龙芮　 石钻子　 石菖蒲　 石椒草　 石楠叶　 石榴子　 石榴皮　  石硫磺　 石钟乳 　石荷叶　石莲子　石胡莩　 石花菜　 布渣叶　 龙胆草　 龙眼肉　 龙利叶　 龙牙草　 龙脑香 　平贝母　 平地木　 北豆根　 北玄参　 北沙参　北柴胡　北野菊　  叶上珠　 叶底珠　 四方藤 　四叶参　 四季青　 四方草　 田三七　 田基黄　 田字草　 甲鱼骨　 生姜皮　 生晒参　生石膏 　生地黄　 生卷柏　 生谷芽　 代代花　  代赭石　 仙人掌　 仙灵脾　 仙遗粮　 仙半夏　 仙桃草 　仙鹤草　 过路黄　 白头须　白头翁　白芥子　 白附子　 白兔根　 白茅根　 白屈菜 　白茯苓 　白药子　  白首乌　 白扁豆　 白鲜皮　 白蔻仁　 白贝齿　 白背叶　白花蛇　白茅花　 白胶木 　白胶香　 白商陆　 白菊花　 白石英　 白雷丸　 白河车　 白马骨　 白平子　  白胡椒　 白茄根 　白木耳　白豆蔻　白蒺藜　 白鲜皮　 白僵蚕　 鸟不宿　 瓜萎仁　 瓜萎子　 瓜萎根　 瓜子金 　瓜菜仁　 瓜姜皮　 冬葵子　 冬虫草　 冬瓜皮　冬瓜仁　冬凌草　  冬葵果　 玄明粉　 玄胡索 　半夏曲　 半枝莲　 半边旗　 半枫荷　 半边莲　 半天雷　 汉肌松　 汉宫秋　 汉桃叶　对座草 　母丁香　 台乌药　 丝瓜络 　丝瓜藤　  老少年　 老勿大　 老鹳草　 老鹳嘴　 老鸦瓣　 吉祥草 　亚麻子　 亚乎奴　 亚吉玛　地锦草　地肤子　 地骨皮　 地鳖虫　 地耳草　 地龙炭　 地枫皮 　地胆草　  地栗粉　 扦扦活　 托盘根　 西瓜皮 　西洋参　 西河柳　百两金　百里霜　 百芯草 　百药煎　 百草霜　 光慈姑　 当门子　 当归尾　 当归身　 虫百腊　 吕宋果　  回回来　 肉豆末 　旱莲草　肉豆蔻　肉苁蓉　 丢了棒　 自然铜　 血余炭　 合欢皮　 决明子　 灯芯草　 安息香 　农吉利　 阳起石 　延胡索　 麦门冬　 赤小豆　赤石脂　芸香草　  苣英菜　 花蕊石　 苍耳子 　苏合香　 两面针 　吴茱萸　 牡丹皮　 何首乌　 皂角刺　 余甘子　 谷精草　 龟板胶　辛夷花 　连钱草　 沙苑子　 补骨脂　 灶心土　  忍冬藤　 鸡内金　 鸡血藤　 鸡冠花　 鸡骨草　 青箱子 　苦瓜干　 苦楝皮　 枇杷叶　板栗壳　板兰根　 松节油　 刺五加　 郁李仁　 罗汉果　 败酱草 　垂盆草　  使君子 　金沙藤　 金钱草　 金银花　 金樱子　 长春花　鱼腥草　狗肝菜　 闹羊花 　炉甘石　 茯苓皮　 茺蔚子　 荔枝核 　柏子仁 　威灵仙　 牵牛子　 鸦胆子　  骨碎补　 钟乳石 　复盆子　禹余粮　急性子　 穿山甲　 穿心莲　 穿破石　 孩儿参　 络石藤　 素馨花　 莱菔子 　莲子心　 核桃仁　 夏天无　 夏枯草　 鸭跖草　倒扣草　徐长卿　  凌霄花　 宽筋藤　 高良姜 　益智仁　 益母草　 海风藤　 海金沙　 海螵蛸　 菟丝子　 羚羊角　 救必应　 野菊花　蛇床子 　蛇胆汁　 猫爪草　 鹿角胶 　鹿角霜　  鹿衔草　 旋复花　 淮山药 　淫羊藿　 淡豆豉 　密蒙花 　款冬花　 葫芦茶　 葶苈子　紫河车　番泻叶　 寒水石　 腊梅花 　蓖麻子　 蒲公英　 路路通 　鼠曲草　  蔓荆子　 酸枣仁　 罂粟壳　 薏苡仁　 薄荷油　 颠茄草　蟛蜞菊　 <br />
  <br />
  <strong>四字以上中药材</strong> <br />
  十大功劳　 王不留行　 冬虫夏草 　五指毛桃　 罗布麻叶 　臭梧桐叶 　紫花杜鹃　&nbsp; 紫背天葵  　 鹅不食草 <br />
  <br />
  <strong>五字以上中药材</strong> <br />
  白花蛇舌草&nbsp;&nbsp; 打破碗花花&nbsp;  　雪上一枝蒿 </p>
				</div>
			</div>
	</body>
</html>
