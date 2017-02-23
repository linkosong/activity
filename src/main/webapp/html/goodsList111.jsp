<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge"><!--  IEæµè§å¨9.0å¨é½æ¯æ ï¼çæ ¸å¿éç½®æææ¯ä¸bootstrapäº¤èï¼æ­£å¸¸ä½¿ç¨  åæ ¸è§£éå¨-->
		<meta name="viewport" content="device=device-width,initoal-scale=1"><!--  åéå¾æ¡çå¤§å°ï¼ç¼©æ¾çæ¯ä¾ ï¼æ¯æpcç«¯ï¼ç§»å¨ç«¯     -->
		
		<title>Bootstrapåºç¡å¥é¨</title>
		<link rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" type="text/css"></link>
		<script type="text/javascript" src="../../bootstrap/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
	</head>
<script type="text/javascript">
 		$(function(){
 			alert(1);
// 			   $.ajax({
// 				   url: "/activity/goods/getGoodsList",
// 				   type: "get",
// 				   dataType: "json",
// 				   data : {
// 					   typeId:3
// 					},
// 				   success: function(data){
// 					   var hotGoods="";
// 					   for (var i = 0; i < data.data.length; i++) {
// 						   hotGoods += '<div class="col-md-4 col-sm-6 col-xs-4">'
// 						    +'<a href="#" class="thumbnail">'
// 						    +'<img class="img-responsive img-rounded" src="'+data.data[i].goodsMainPicUrl+'">'
// 						    +'</a>'
// 						    +'<h3>'+data.data[i].goodsName+'"</h3>'
// 						    +'<input type="hidden" value="'+data.data[i].goodsId+'"/>'
// 						    +'</div>';
// 					   }
// 					   $('#hotGoods').html(hotGoods);
// 					}
// 				 });
			   
 		});
	   
	   </script>
	<body style="padding: 50px; background-color: pink">
		<div class="container" style="padding: 50px; background-color: #fff"> <!-- container : è¡¨ç¤ºçæ¯æå­æåå®¹å°è¾¹æ¡çèªå¨è°æ´       -->

			<div id="goodsList" class="row" style="padding:50px;">
			sdssdfs
			{{$list}}
			</div>
		</div>
	</body>
</html>