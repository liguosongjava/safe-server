<div class="bjui-pageContent">
    <form action="/region/save_edit" class="datagrid-edit-form" data-toggle="ajaxform" data-data-type="json"
          data-reload-navtab="true">
        <input type="hidden" name="id" value="${region.id}">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td>
                        <label class="row-label">地区名称</label>
                        <div class="row-input required">
                            <input size="50" name="region.name"  value="${region.name}" type="text" data-rule="地区名称:required;">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="row-label">备注</label>
                        <div class="row-input required">
                            <textarea cols="50" name="region.remark" rows="4" data-rule="备注:required;">${region.remark}</textarea>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>

<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
        <li><button type="submit" class="btn-default" data-icon="save">保存</button></li>
    </ul>
</div>
