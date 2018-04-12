<div class="bjui-pageContent">
    <form action="/region/save_edit?callback=?" data-toggle="ajaxform" data-reload-navtab="true">
        <input type="hidden" name="id" value="">
        <div class="pageFormContent" data-layout-h="0">
            <table class="table table-condensed table-hover" width="100%">
                <tbody>
                <tr>
                    <td>
                        <label class="row-label">地区名称</label>
                        <div class="row-input">
                            <input size="50" value="" type="text" data-rule="required">
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="row-label">备注</label>
                        <div class="row-input">
                            <textarea cols="50" rows="4" data-rule="required"></textarea>
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
