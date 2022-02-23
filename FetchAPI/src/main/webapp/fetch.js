$(document).ready(function (){
    $("#data").click(function (){
        fetch("Get.action").then(request=>request.json()).then(data=>{
            add(data);
        });
    });
});
function add(data){
    var s=``;
    $.each(data.empBeanList,function (){
        s+=`<tr><td>${this.id}</td><td>${this.name}</td></tr>`
    })
    $("#tbody").html(s);
}