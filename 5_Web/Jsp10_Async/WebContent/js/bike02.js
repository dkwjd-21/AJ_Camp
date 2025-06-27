$(function(){
	parseJson();
});

function parseJson(){
	$.getJSON("json/bike.json", function(data){
		$.ajax({
			url:"bike.do?command=second_db",
			method:"post",
			data:{"obj": JSON.stringify(data)},
			succes:function(){
				
			},
			error:function(){
				alert("data 저장 실패ㅜㅜ");
			}
		});
	});
}