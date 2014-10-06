<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/includes/taglibs.jspf"%>
<!DOCTYPE HTML>
<html lang="zh_CN">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>商城管理系统</title>
<%@ include file="/WEB-INF/views/includes/admin_head_scripts_links.jspf"%>
</head>
<body>
	<!-- 引用页面header模板 -->
	<%@ include file="/WEB-INF/views/includes/admin_header.jspf"%>

	<div id="container">
		<!-- 引用页面侧边栏模板 -->
		<%@ include file="/WEB-INF/views/includes/admin_aside.jspf"%>

		<div id="content">
			<ul id="nav-info" class="clearfix">
				<li><a href="#"><i class="icon-gift"></i></a></li>
				<li><a href="#">商品管理</a></li>
				<li class="active"><a href="#">添加商品</a></li>
			</ul>
			<!-- 商品基本信息 -->
			<c:set var="method" value="POST" />
			<c:url var="productUrl" value="/admin/product" />
			<c:if test="${param.add == null }">
				<c:set var="method" value="PUT" />
			</c:if>
			<form:form action="${productUrl}" method="${method}" class="form-horizontal form-box"
				modelAttribute="productInfo">
				<h4 class="form-box-header">商品信息</h4>
				<div class=" form-box-content">
					<div class="form-group">
						<label class="control-label col-md-2">商品名称：</label>
						<div class="col-md-6">
							<form:input path="name" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品类型：</label>
						<div class="col-md-3">
							<select class="form-control" name="productType" id="productType">
								<option>--所有商品--</option>
								<option>积木</option>
								<option>模型</option>
								<option>益智</option>
							</select>
						</div>
						<label class="control-label col-md-2">商品货号：</label>
						<div class="col-md-3">
							<form:input path="number" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品价格：</label>
						<div class="col-md-3">
							<div class="input-group">
								<span class="input-group-addon">￥</span>
								<form:input path="price" cssClass="form-control input-sm" />
							</div>
						</div>
						<label class="control-label col-md-2">商品折扣：</label>
						<div class="col-md-3">
							<form:input path="discount" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品产地：</label>
						<div class="col-md-3">
							<form:input path="orgin" cssClass="form-control input-sm" />
						</div>
						<label class="control-label col-md-2">商品材质：</label>
						<div class="col-md-3">
							<form:input path="materials" cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品毛重：</label>
						<div class="col-md-3">
							<form:input path="weight" cssClass="form-control input-sm" />
						</div>
						<label class="control-label col-md-2">库存数量：</label>
						<div class="col-md-3">
							<input type="number" name="amount" class="form-control input-sm"/>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">是否推荐：</label>
						<div class="col-md-4">
							<label class="radio-inline"> <form:radiobutton
									path="recommend" value="0" />是
							</label> <label class="radio-inline"> <form:radiobutton
									path="recommend" value="1" />否
							</label>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">缩略图：</label>
						<div class="col-md-4">
							<input type="file" name="thumbnailImg" class="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品描述：</label>
						<div class="col-md-6">
							<form:textarea path="desc" rows="3"
								cssClass="form-control input-sm" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">商品备注：</label>
						<div class="col-md-6">
							<form:input path="remark" cssClass="form-control input-sm" />
						</div>
					</div>
					<div class="form-group form-actions">
						<div class="col-md-10 col-md-offset-2">
							<input type="submit" value="确定" class="btn btn-success" /> <input
								type="reset" value="重置" class="btn btn-danger" />
						</div>
					</div>
				</div>
			</form:form>

			<!-- 商品展示图片 -->
		</div>
	</div>

	<!-- 引用页面底部模板 -->
	<%@ include file="/WEB-INF/views/includes/admin_footer.jspf"%>
</body>
<%@ include file="/WEB-INF/views/includes/admin_foot_scripts_links.jspf"%>
<script type="text/javascript">
	
</script>
</html>