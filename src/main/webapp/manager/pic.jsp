
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title> - 选项卡 & 面板</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <style>
        .fa-times {
            font-size: 15px;
        }
        .panel {
            height: 285px;
            margin-bottom: 0;
            margin-top: 10px;
        }
        .panel-heading {
            text-align: right;
        }
        /*加号*/
        .icon-add-50 {
            position: relative;
            box-sizing: border-box;
            width: 50px;
            height: 50px;
            border: 2px dashed #9a9ba3;
            border-radius: 50%;
        }
        .icon-add-50:before {
            content: '';
            position: absolute;
            width: 30px;
            height: 2px;
            left: 50%;
            top: 50%;
            margin-left: -15px;
            margin-top: -1px;
            background-color: #aaabb2;
        }
        .icon-add-50:after {
            content: '';
            position: absolute;
            width: 2px;
            height: 30px;
            left: 50%;
            top: 50%;
            margin-left: -1px;
            margin-top: -15px;
            background-color: #aaabb2;
        }

        .updatepanel {
            border: 1px solid #ccc;
            text-align: center;
        }
        .updatepanel .addbox {
            vertical-align: middle;
            height: 285px;
            line-height: 285px;
        }

        #image {
            overflow: hidden;
        }
        .panel-body {
            /*padding-top: 0px;
            padding-bottom: 0px;*/
        }
        label {
            width: 100%;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeIn">

    <div class="row">
        <div class="col-sm-12">
            <div class="ibox">
                <div class="ibox-title">
                    <h5>轮播图</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <i class="fa fa-times"></i>
                                </div>
                                <div class="panel-body" style="text-align: center;">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-12" id="image">
                                            <img class="updateimg img-responsive" src="img/p_big3.jpg" style="width: inherit;height: 210px;"/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-4" id="updatebox">
                            <label for="file">
                                <div class="panel updatepanel">
                                    <div class="addbox"><span class="icon-add-50"></span></div>
                                    <input type="file" id="file" style="display: none" />
                                </div>
                            </label>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<!-- 全局js -->
<script src="js/jquery.min.js?v=2.1.4"></script>
<script src="js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="js/content.js?v=1.0.0"></script>
<script>

    $(".updatepanel").height($(".panel-info").height());
    document.getElementById('file').onchange = function() {
        add();
        var imgFile = this.files[0];
        var fr = new FileReader();
        fr.onload = function() {
            var imgs = document.getElementsByClassName('updateimg');
            imgs[imgs.length-1].src = fr.result;
            /*document.getElementById('image').getElementsByTagName('img')[0].src = fr.result;*/
        };
        fr.readAsDataURL(imgFile);
    };
    function add(){
        var html = "<div class='col-sm-4'><div class='panel panel-info'><div class='panel-heading'><i class='fa fa-times'></i></div><div class='panel-body' style='text-align: center;'><div class='row'><div class='col-sm-12 col-md-12'><img class='updateimg img-responsive' src='img/p_big3.jpg' style='width: inherit;height: 210px;'/></div></div></div></div></div>";
        $("#updatebox").before(html);
    }
    $(".fa-times").click(function(){
        alert("111");
        /*alert($(this).parent().parent().parent().html());*/
        $(this).parent().parent().parent().remove();
    });
    /*$(".panel").on("click","i",function(){
        alert("111");
        alert($(this).parent().parent().parent().html());
        $(this).parent().parent().parent().remove();
    });*/
    /*function delete(){

    }*/
</script>

</body>

</html>