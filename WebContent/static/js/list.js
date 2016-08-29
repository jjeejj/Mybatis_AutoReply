/**
 * 批量删除
 * @param basePath
 * @returns
 */
function deleteBatch(basePath) {
	alert('调用该方法')
	//改为删除action
	$('mainForm').attr('action',basePath+'deleteBatch.action');
	$('mainForm').submit();
	//改为查询的acton
	$('mainForm').attr('action',basePath+'list.action');
}