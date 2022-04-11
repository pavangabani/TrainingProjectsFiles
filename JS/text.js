$(document).ready(function(){
    $("#invert").click(function(){
        $(":checkbox").each(function(){
            if($(this).prop("checked")==true){
                $(this).prop("checked",false);
            }
            else{
                $(this).prop("checked",true);
            }
        });
  
    }
);
});
