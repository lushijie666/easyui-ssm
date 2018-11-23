<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<form id="form">
		<div id="tb" style="padding: 3px">
			<span>姓名:</span>
			<input id="s_name" style="line-height: 26px; border: 1px solid #ccc" />
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="toSearch()">查询</a> 
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="toAdd()">新增</a> 
	    </div>	
        <div>
            <table id="data">
                <thead>
                    <tr>
                        <th field="id" width="100" align="center">id</th>
                        <th field="name" width="100" align="center">姓名</th>
                        <th field="age" width="100" align="center">年龄</th>
                        <th field="job" width="100" align="center">工作</th>
                        <th field="_operate" width="100" align="center" formatter="formatOper">操作</th>
                    </tr>
                </thead>
            </table>
        </div>
</form>


<div id="dialog" title="编辑用户" modal=true draggable=false class="easyui-dialog" closed=true style="width: 400px; height: 200px;">
	<form id="form_dialog">
		<table align="center" style="padding-top: 20px;">
			<input type="hidden" id="id" name="id"/>
			<tr>
			<td>姓名:</td>
			<td><input type="text" id="name" name="name" class="easyui-validatebox" required="true" missingMessage="请输入姓名" /></td>
			</tr>
			<tr>
			<td>年龄:</td>
			<td><input type="text" id="age" name="age" class="easyui-validatebox" required="true" missingMessage="请输入年龄" /></td>
			</tr>
			<tr>
			<td>工作:</td>
			<td><input type="text" id="job" name="job" class="easyui-validatebox" required="true" missingMessage="请输入工作" /></td>
			</tr>
			<tr>
			<td colspan="2" style="text-align: center">
				<a id="save" class="easyui-linkbutton" onclick="oper();">确定</a>
				<a id="cancel" class="easyui-linkbutton" onclick="cancel();">取消</a>
			</td>
			</tr>
		
		</table>
	</form>
</div>

<%@ include file="/include/footer.jsp"%>

<script>
var url = _basePath + "/user";
$(function(){
	init();
	
})
function init (){
	$("#data").datagrid({
		fitColumns: true,
		url: url + "/list.do",
		queryParams: {  		
			'query': $('#s_name').val()
		},
		method: 'get',
		pagination: true,//允许分页
		rownumbers: true,//行号
		singleSelect: false,//只选择一行
		pageSize: 5,//每一页数据数量
		checkOnSelect: false,
	    striped: true,     //交替行换色
        rownumbers: true,  //行号
        pagination: true,  //显示底部分页
		pageList: [5, 10, 15, 20, 25]
	});
	 var p = $('#data').datagrid('getPager');
     $(p).pagination({
         beforePageText: '第',
         afterPageText: '页    共 {pages} 页',
         displayMsg: '当前显示 {from}-{to} 条记录,共 {total} 条记录'
     });
}

function toSearch(){
	$('#data').datagrid('load', {
        'query': $('#s_name').val()
    });
}

//自定义操作列
function formatOper(val, row, index) {
    var str = "";
    str += '<a href="javascript:void(0);" onclick="toEdit('+ index +');">修改</a>';
    str += '  ';
    str += '<a href="javascript:void(0);" onclick="toDelete(' + row.id + ')">删除</a>';
    return str;
}

function toAdd(){
	$("#dialog").dialog({
		title:"新增用户"
	})
	$("#form_dialog").get(0).reset();
	$("#dialog").dialog('open');
}

function toEdit(index) {
	$('#data').datagrid('selectRow',index);	
	$("#dialog").dialog({
		title:"编辑用户"
	})
	$("#form_dialog").get(0).reset();
	$("#dialog").dialog('open');
	var arr = $("#data").datagrid("getSelections");
    $("#name").val(arr[0].name);
    $("#age").val(arr[0].age);
    $("#job").val(arr[0].job);
    $("#id").val(arr[0].id);
}

function toDelete(id) {
	 $.ajax({
         url:url + "/" + id + ".do",
         type:"delete",
         success:function(msg){
        	 $("#data").datagrid("reload");
         }
     });
}

function oper(){
	var data = {'name' : $("#name").val(), 'age' : $("#age").val(), 'job' : $("#job").val(), 'id' : $("#id").val()};
	$.ajax({
        url:url + ".do",
        data:data,
        type:"post",
        success:function(msg){
        	cancel();
       	 $("#data").datagrid("reload");
        }
    });	
}

function cancel(){
	$("#dialog").dialog('close');
}

</script>