
//获取用户ID
function get_user(){
    $('#main1',window.parent.document).html();
    return  parent.get_user();
}

//动态生成单号(8位)
function auto_number1(obj) {
    $.ajax({
        url:"/main/auto_number1",
        type:"post",
        data:{
            src:obj
        },
        success:function (data) {
            $('#insert_no').val(data);
        }
    })
}
//动态生成单号(4位)
function auto_number2(obj) {
    $.ajax({
        url:"/main/auto_number2",
        type:"post",
        data:{
            src:obj
        },
        success:function (data) {
            $('#insert_no').val(data);
        }
    })
}
//动态获取下拉值 (ven_code+ven_name)
function get_option1(obj) {
    //alert($('#'+obj.name).val())
    $.ajax({
        url: "/main/get_option",
        type: "post",
        data: {
            value:$('#'+obj.name).val(),
            src: obj.name
        },
        success:function (data) {
            let list = [];
            for (let i=0;i<data.length;i++){
                list.push(data[i]['code']+data[i]['name'])
            }
            $('#'+obj.name).autocomplete({
                source: list,
            })
        }
    })
}

//动态获取下拉值(带spell)
function get_option2(obj) {
    //alert($('#'+obj.name).val())
    $.ajax({
        url: "/main/get_option",
        type: "post",
        data: {
            value:$('#'+obj.name).val(),
            src: obj.name
        },
        success:function (data) {
            let list = [];
            for (let i=0;i<data.length;i++){
                list.push(data[i]['code']+data[i]['name']+data[i]['spell'])
            }
            $('#'+obj.name).autocomplete({
                        source:list
            })
        }
    })
}

//重写submit
$(document).ready(function(){
    $(':submit').css( {'width':'75px',
                              'height':'25px',
                              'border':'medium none',
                              'border-radius':'2px',
                              'background':'lightskyblue none repeat scroll 0% 0%',
                              'font-size':'14px',
                              'cursor':'pointer'})
})