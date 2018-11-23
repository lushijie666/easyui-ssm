var _basePath = "/mvc"; 
var base = {
	//是否含有class
	addClass : function(obj,className){
		if(!obj.hasClass(className)){
			obj.addClass(className);
		}
	},	
	//ajax请求
	loadScript_all : function(requestUrl,requestData,async,requestType,dataType,successFunction,errorFunction){
		async = base.isNull(async) ? "true" : async;
		requestType = base.isNull(requestType) ? "post" : requestType;
		dataType = base.isNull(dataType) ? "json" : dataType;
		var url = _basePath + base.appendChar(requestUrl) + "_v="+(new Date()).getTime();
		$.ajax({
			url : url,
			data : requestData,
			async : async,
			dataType : dataType,
			type : requestType,
			success : function(result){
				successFunction(result);
			},
			error : function(e){
				errorFunction(e);
			}
		});
	},
	loadScript_normal : function(requestUrl,requestData,successFunction,errorFunction){
		var url = _basePath + base.appendChar(requestUrl) + "_v="+(new Date()).getTime();
		$.ajax({
			url : url,
			data : requestData,
			type : "post",
			dataType: "json",
			success : function(result){
				successFunction(result);
			},
			error : function(e){
				errorFunction(e);
			}
		});
	},
	loadScript : function(requestUrl,requestData,successFunction){
		var url = _basePath + base.appendChar(requestUrl) + "_v="+(new Date()).getTime();
		$.ajax({
			url : url,
			data : requestData,
			type : "post",
			dataType: "json",
			success : function(result){
				successFunction(result);
			}
		});
	},
	//判断为空
	isNull : function(value){
		if(null == value || "" == value || typeof(value) == 'undefined') return true;
		return false;
	},
	//判断不为空
	isNotNull : function(value){
		return !base.isNull(value);
	},
	//url追加?或者&
	appendChar : function(url){
		if(url.indexOf("?") == -1){
			url += "?";
		} else {
			url += "&";
		}
		return url;
	},
	//获取url参数值
	getUrlParam : function(name){
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i"); 
		var r = window.location.search.substr(1).match(reg); 
		if (r != null) {
			return unescape(r[2]);  
		} else {
			return null;
		}
	},
	getHashParam : function(name){
		var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
		var r = window.location.hash.substr(1).match(reg);
		if (r!=null) return unescape(r[2]); return null;
	},
	//格式化日期
	formatDate : function(value) {
        if(base.isNotNull(value)){
        	var temp;
        	if (value instanceof Date) {
                temp = value;
            } else {
                temp = new Date(value);
            }
        	return temp.toLocaleString();
        }
	},
	//json对象是否含有key属性
	hasKey : function(data,key){
		return data.hasOwnProperty(key);
	},
	//表单提交
	formSubmit : function(obj){
		if(base.isNotNull(obj)){
			obj.submit();
		}
	},
	//表单清空
	formReset : function(obj){
		if(base.isNotNull(obj)){
			obj.find("input").not(':button, :submit, :reset, :hidden').val('').removeAttr('checked').removeAttr('selected');
		}
	},
	//请求完整地址
	getHref : function(){
		return location.href;
	},
	//请求项目地址,除去http地址
	getPath : function(){
		return window.document.location.pathname;  
	},
	//请求http地址
	getHost : function(){
		var href = base.getHref();
		var path = base.getPath();
		var index = href.indexOf(path);
		return href.substring(0,index);
	},
	//请求项目名称
	getProject : function(){
		var path = base.getPath();
		return path.substring(0,path.substr(1).indexOf("/")+1);
	},
	//请求项目访问地址,包含http地址
	getProjectPath : function(){
		return base.getHost() + base.getProject();
	}
	
};

