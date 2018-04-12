<style type="text/css">
    .file {
        position: relative;
        display: inline-block;
        background: #D0EEFF;
        border: 1px solid #99D3F5;
        border-radius: 4px;
        padding: 4px 12px;
        overflow: hidden;
        color: #1E88C7;
        text-decoration: none;
        text-indent: 0;
        line-height: 20px;
    }
    .file input {
        position: absolute;
        font-size: 100px;
        right: 0;
        top: 0;
        opacity: 0;
    }
    .file:hover {
        background: #AADFFD;
        border-color: #78C3F3;
        color: #004974;
        text-decoration: none;
    }`
</style>
<div class="bjui-pageContent">
    <form action="/region/save_edit" class="datagrid-edit-form" data-toggle="ajaxform"  data-data-type="json"
          data-reload-navtab="true">
        <div class="bjui-row col-2">
            <label class="row-label">
                <a href="javascript:;" class="file">选择文件
                    <input type="file" name="excelfile" id="excelfile">
                </a>
            </label>
            <div class="row-input required">
                <input id="filename" name="filename" value="" readonly="readonly" type="text">
            </div>
            <label class="row-label"></label>
            <div class="row-input">
                <button id="uploadbutton" type="button" class="btn-default" data-icon="save">点击上传</button>
            </div>
        </div>
    </form>
</div>

<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $("#excelfile").change(function () {
            var filename = $("#excelfile").val();
            var name = getFileName(filename);
            $("#filename").attr("value",name);
        });
        $("#uploadbutton").click(function () {
            var filename = $("#excelfile").val();
            if($("#excelfile").val() == ''){
                BJUI.alertmsg('warn', "请选择要上传的数据文件");
                return;
            }
            var extStart=filename.lastIndexOf(".");
            var ext=filename.substring(extStart,filepath.length).toUpperCase();
            if(ext!=".xlsx"&&ext!=".xls"){
                BJUI.alertmsg('warn', "请选择要上传excel文件");
                return;
            }
            $.ajax({
                type: "POST",
                url: "addFile.do",
                enctype: 'multipart/form-data',
                data: {
                    file: filename
                },
                success: function (data) {
                    alert("Data Uploaded: ");
                }
            });
        });
    });
    function getFileName(o){
        var pos=o.lastIndexOf("\\");
        return o.substring(pos+1);
    }
</script>