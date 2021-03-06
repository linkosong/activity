<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge"><!--  IE浏览器9.0全都支持 ，的核心配置意思是与bootstrap交融，正常使用  -->
		<meta name="viewport" charset="utf-8"  content="device=device-width,initoal-scale=1"><!--  合适图框的大小，缩放的比例 ，支持pc端，移动端     -->
		<title>Bootstrap基础入门</title>
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"></link>
		<script type="text/javascript" src="bootstrap/js/jquery-3.1.1.min.js"></script>
		<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<!-- 		<script type="text/javascript" src="js/index.js"></script> -->
	</head>
		<script type="text/javascript">
// 		 $(function () { 
// 	       $('#myTab a:first').tab('hidden');//初始化显示哪个tab 
// 	       $('#myTab a:last').tab('hidden');
// 	      })
	      
	      
	   $(function(){
		   $.ajax({
			   url: "/activity/index/gethotGoods",
			   type: "get",
			   dataType: "json",
			   data : {
				},
			   success: function(data){
				   var hotGoods="";
				   for (var i = 0; i < data.data.length; i++) {
					   hotGoods += '<div class="col-md-4 col-sm-6 col-xs-4">'
					    +'<a href="#" class="thumbnail">'
					    +'<img class="img-responsive img-rounded" src="'+data.data[i].goodsMainPicUrl+'">'
					    +'</a>'
					    +'<h3>'+data.data[i].goodsName+'"</h3>'
					    +'<input type="hidden" value="'+data.data[i].goodsId+'"/>'
					    +'</div>';
				   }
				   $('#hotGoods').html(hotGoods);
				}
			 });
		   
		   
		  $.ajax({
				url : "/activity/index/getTypeAll",
				type : "post",
				dataType : "json",
				data : {
					level : 1
				},
				success : function(data) {
					console.log(data)
					var liLevel="";
					var tabpanelDiv="";
					var tabpanelDiv1="";
					for (var i = 0; i < data.data.length; i++) {
						if(data.data[i].level==1){
							liLevel +='<li  role="presentation" style="background:green; height:50%; width:100%;">'+'<a href="#tab'+(i+1)+'" data-toggle="tab"   style="height:100%;">'+data.data[i].levelName+'</a>'+'</li>';
							tabpanelDiv+='<div  role="tabpanel" class="tab-pane" id="tab'+(i+1)+'" style="background-color: #fff;height:300px;width:100%;">'	
							  			+'<div class="container-fluid"><div class="row">level2</div></div></div>';
							  			//二级类目
										var level2Name="";
										for (var j = 0; j < data.data.length; j++) {
											if(data.data[j].level==2 && data.data[j].pid==data.data[i].id){
												
												level2Name+='<div class="col-md-6 col-sm-6 col-xs-6" >'
													+'<ul class="list-unstyled">'
														            +'<li><div  class="text-center"><a href="#">'+data.data[j].levelName+'</a></div></li>'
														            +'<li class="divider"></li>'
														            +'<li>level3</li>'
													          	+'</ul>'
													          	+'</div>';
												  			
												  			 			
												//三级类目
												var level3Name='<ul class="list-unstyled list-inline">';
												for (var k = 0; k < data.data.length; k++) {		
													if(data.data[k].level==3 && data.data[k].pid==data.data[j].id){
														level3Name += '<li><a onclick="goodsListShow('+data.data[k].id+')">'+data.data[k].levelName+'</a></li>';
													}
												}
												console.log("3333"+level3Name);
												level2Name=level2Name.replace('level3',level3Name); 			
												
											}
										}	
										tabpanelDiv=tabpanelDiv.replace('level2',level2Name);
						}
					}
					$('#myTab').html(liLevel);
					$('.tab-content').html(tabpanelDiv);
					
				},
				error : function(data) {
					console.log(data)
					alert( "Data Saved1: " + data.msg);
				}
			});
		   
	
		   
		   
		   
		    $('#myTab li').each(function(index){
			   $(this).click(function(){
				   $(".tab-pane").hide();
				   $(".tab-pane").eq(index).show();
			   })
		 	 }); 
		    
		    
// 		   $(document).click(function(){
// 				 $(".tab-pane").hide();
// 		   }
		    
		 
	   })
	   
	      
		function goodsListShow(id){
			 
			 $.ajax({
					url : "/activity/goods/getGoodsList",
					type : "post",
					dataType : "json",
					data : {
						typeId : id
					},
					success : function(data) {
						console.log(data)
						windows.href="../html/goodsList.html";
					},
					error : function(data) {
						console.log(data)
					}
				});
		 }
	       

		</script>
<!-- 栅格系统 -->
	<body style="background-color: pink; padding 0px;">

<!-- 	navbar-fixed-top -->
		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		  <div class="container">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">首页</a>
		      <p class="navbar-text">欢迎光临!</p>
		    </div>
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav navbar-left">
		        <li class="active"><a href="#">新品上市</a></li>
		        <li><a href="#">关于我们</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown">帮助中心 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="#">联系我们</a></li>
		            <li class="divider"></li>
		            <li><a href="#">新闻资讯</a></li>
		          </ul>
		          <li><a href="#">图片</a></li>
		      </ul>
		<!--       <form class="navbar-form navbar-left" role="search"> -->
		<!--         <div class="form-group"> -->
		<!--           <input type="text" class="form-control" placeholder="Search"> -->
		<!--         </div> -->
		<!--         <button type="submit" class="btn btn-default">Submit</button> -->
		<!--       </form> -->
		<!--       <ul class="nav navbar-nav navbar-right"> -->
		<!--         <li><a href="#">Link</a></li> -->
		<!--         <li class="dropdown"> -->
		<!--           <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a> -->
		<!--           <ul class="dropdown-menu" role="menu"> -->
		<!--             <li><a href="#">Action</a></li> -->
		<!--             <li><a href="#">Another action</a></li> -->
		<!--             <li><a href="#">Something else here</a></li> -->
		<!--             <li class="divider"></li> -->
		<!--             <li><a href="#">Separated link</a></li> -->
		<!--           </ul> -->
		<!--         </li> -->
		<!--       </ul> -->
		    </div><!-- /.navbar-collapse -->
 		  </div><!--/.container-fluid -->
		</nav>

		<div class="container-fluid" style="padding-top:50px;"> <!-- container : 表示的是文字或内容到边框的自动调整       -->
		<div class="row" style="position:relative;">
			<div class="col-md-2 col-sm-2 col-xs-2" style="height:300px;">
					<ul id="myTab" class="nav nav-pills nav-stacked" role="tablist" style="height:300px;width:100%;">
<!-- 	动态加载			   <li  role="presentation" style="background:green; height:50%; width:100%;"><a href="#tab2" data-toggle="tab"   style="height:100%;">副食</a></li> -->
				    </ul>
			</div>
			<!-- Tab panes js 实现 -->
 				<div class="tab-content" style="width:300px;position:absolute;top:0;left:300px;z-index:10;"> 
<!-- 	动态加载			  <div role="tabpanel" class="tab-pane" id="tab1" style="background-color: #fff;height:400px;width:100%;">	 -->
<!-- 			  			<div class="col-md-4 col-sm-4 col-xs-4" style="background:yellow;height:400px;width:100%"> -->
			  						
<!-- 			  			</div> -->
<!-- 				  </div> -->
 				</div>	 
			<div class="col-md-10 col-sm-10 col-xs-10 " style="height:300px;background-image:image/star.jpg">
			</div>
			
		</div>
		
		<div class="jumbotron" style="margin-left: 0px;margin-right: 0px;margin-bottom: 0px;">
				<h2 class="text-center">关于我们</h2>
				<h4>  关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们
				关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们
				关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们
				关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们
				关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们
				关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们关于我们
				关于我们关于我们关于我们关于我们关于我们关于我们关于我们</h4>
				
				
		</div>
		<h1 class="text-center">热卖商品</h1>
		
		<div id="hotGoods" class="row" style="padding:50px;">
<!-- 		动态加载 -->
<!-- 				<div class="col-md-4 col-sm-6 col-xs-4" style="border:1px solid red;height:300px">  col-md-* :表示的是所适应的屏幕 
<!-- 				                                                                        col-后跟sm用于手机端， xs用于平板 ， md用于电脑 ，lg用于大屏幕   -->
<!-- 				                                                                                                                                                                                                                        默认的是一行十二列 -->
<!-- 				                                                                     --> -->
<!-- 						 <a href="#" class="thumbnail"> -->
<!-- 					      <img data-src="holder.js/100%x180" alt="..."> -->
<!-- 					    </a> -->
<!-- 				</div> -->

		</div>
	</div>
	</body>
</html>